package wgo_app.wgo.adapter;

import android.app.Activity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import wgo_app.wgo.R;
import wgo_app.wgo.objects.LocationHolder;
import wgo_app.wgo.objects.ObjLocation;
import wgo_app.wgo.utils.Constants;

public class LocationAdapter extends ArrayAdapter<ObjLocation> implements Filterable {

    private Activity context;
    private ArrayList<ObjLocation> datos;
    private ArrayList<ObjLocation> all;
    private Filter filter;
    private String from;

    public LocationAdapter(Activity ctx, ArrayList<ObjLocation> datos, String from) {
        super(ctx, R.layout.location_row, datos);
        this.datos = new ArrayList<ObjLocation>(datos);
        this.all= new ArrayList<ObjLocation>(datos);
        this.context = ctx;
        this.from = from;
    }
     
    public int getCount() {
        return datos.size();
    }
    
    public ObjLocation getItem(int position) {
        return datos.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
    
    public void setList(ArrayList<ObjLocation> datos) {
        this.datos = datos;
        notifyDataSetChanged();
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
    	final LocationHolder locationHolder;
    	View item = convertView;
    	if(item == null)
		{
    		LayoutInflater inflater= context.getLayoutInflater();
			View viewGroup = inflater.inflate(R.layout.location_row, parent, false);
			//using the ViewHolder pattern to reduce lookups
            locationHolder = new LocationHolder(
            		(TextView)viewGroup.findViewById(R.id.location));
            viewGroup.setTag(locationHolder);
            item = viewGroup;
		}
		else
		{
			 locationHolder = (LocationHolder)convertView.getTag();
        	 item = convertView;
		}
    	try{
	    	//Location Name
            String text = "<font color=#333333>"+datos.get(position).getLocationName()+"</font>&nbsp;&nbsp;<font color=#999999>"+datos.get(position).getLocationCountry()+"</font>";
	    	locationHolder.getLocationName().setText(Html.fromHtml(text));
	        //Location Country
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(from.equals("Destination")){
                        Constants.destinationLocation = datos.get(position).getLocationName();
                    }else if (from.equals("Origin")){
                        Constants.originLocation = datos.get(position).getLocationName();
                    }
                    Constants.fromLocationAdapter = true;
                    context.finish();
                    
                }
            });
    	}catch(Exception e){    		
    		Log.e("Adapter error", e.getMessage());
    	}
    	return item;
    }



    @Override
    public Filter getFilter()
    {
        if (filter == null)
            filter = new PkmnNameFilter();

        return filter;
    }

    private class PkmnNameFilter extends Filter
    {
            @Override
            protected FilterResults performFiltering(CharSequence constraint)
            {   
                FilterResults results = new FilterResults();
                String prefix = constraint.toString().toLowerCase();

                if (prefix == null || prefix.length() == 0)
                {
                    ArrayList<ObjLocation> list = new ArrayList<ObjLocation>(all);
                    results.values = list;
                    results.count = list.size();
                }
                else
                {
                    final ArrayList<ObjLocation> list = new ArrayList<ObjLocation>(all);
                    final ArrayList<ObjLocation> nlist = new ArrayList<ObjLocation>();
                    int count = list.size();

                    for (int i=0; i<count; i++)
                    {
                        final ObjLocation pkmn = list.get(i);
                        final String value = pkmn.getLocationName().toLowerCase();

                        if (value.contains(prefix))
                        {
                            nlist.add(pkmn);
                        }
                    }
                    results.values = nlist;
                    results.count = nlist.size();
                }
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                datos = (ArrayList<ObjLocation>)results.values;
                clear();
                int count = datos.size();
                for (int i=0; i<count; i++)
                {
                    ObjLocation pkmn = datos.get(i);
                    add(pkmn);
                }
            }

        }
}
