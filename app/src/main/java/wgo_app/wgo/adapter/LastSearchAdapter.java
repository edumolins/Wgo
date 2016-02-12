package wgo_app.wgo.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import wgo_app.wgo.R;
import wgo_app.wgo.objects.LastSearchHolder;
import wgo_app.wgo.objects.ObjLastSearch;

public class LastSearchAdapter extends ArrayAdapter<ObjLastSearch> {

    private Activity context;
    private ArrayList<ObjLastSearch> datos;

    public LastSearchAdapter(Activity ctx, ArrayList<ObjLastSearch> datos) {
        super(ctx, R.layout.search_row, datos);
        this.datos = new ArrayList<ObjLastSearch>(datos);
        this.context = ctx;
    }
     
    public int getCount() {
        return datos.size();
    }
    
    public ObjLastSearch getItem(int position) {
        return datos.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
    
    public void setList(ArrayList<ObjLastSearch> datos) {
        this.datos = datos;
        notifyDataSetChanged();
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
    	final LastSearchHolder searchHolder;
    	View item = convertView;
    	if(item == null)
		{
    		LayoutInflater inflater= context.getLayoutInflater();
			View viewGroup = inflater.inflate(R.layout.search_row, parent, false);
			//using the ViewHolder pattern to reduce lookups
            searchHolder = new LastSearchHolder(
            		(TextView)viewGroup.findViewById(R.id.origin),
            		(TextView)viewGroup.findViewById(R.id.destination),
                    (TextView)viewGroup.findViewById(R.id.number_weekends),
                    (TextView)viewGroup.findViewById(R.id.number_price),
                    (TextView)viewGroup.findViewById(R.id.duration),
                    (TextView)viewGroup.findViewById(R.id.edit),
                    (TextView)viewGroup.findViewById(R.id.delete),
                    (Button)viewGroup.findViewById(R.id.show_button));
            viewGroup.setTag(searchHolder);
            item = viewGroup;
		}
		else
		{
			 searchHolder = (LastSearchHolder)convertView.getTag();
        	 item = convertView;
		}
    	try{
	    	/*
	    	    Codi on es fa set de les variables de cada row

	    	 */
            //Location Name
            /*flightHolder.getFlightRow().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailedFlightsActivity.class);
                    context.startActivity(intent);
                }
            });*/
            searchHolder.getDeleteText().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    datos.remove(position);
                    notifyDataSetChanged();
                }
            });
    	}catch(Exception e){    		
    		Log.e("error adapter search", e.getMessage());
    	}
    	return item;
    }
}
