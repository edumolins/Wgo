package wgo_app.wgo.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import wgo_app.wgo.R;
import wgo_app.wgo.objects.DetailedFlightHolder;
import wgo_app.wgo.objects.ObjFlight;

public class DetailedFlightAdapter extends ArrayAdapter<ObjFlight> {

    private Activity context;
    private ArrayList<ObjFlight> datos;

    public DetailedFlightAdapter(Activity ctx, ArrayList<ObjFlight> datos) {
        super(ctx, R.layout.detailed_flight_row, datos);
        this.datos = new ArrayList<ObjFlight>(datos);
        this.context = ctx;
    }
     
    public int getCount() {
        return datos.size();
    }
    
    public ObjFlight getItem(int position) {
        return datos.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
    
    public void setList(ArrayList<ObjFlight> datos) {
        this.datos = datos;
        notifyDataSetChanged();
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
    	final DetailedFlightHolder flightHolder;
    	View item = convertView;
    	if(item == null)
		{
    		LayoutInflater inflater= context.getLayoutInflater();
			View viewGroup = inflater.inflate(R.layout.detailed_flight_row, parent, false);
			//using the ViewHolder pattern to reduce lookups
            flightHolder = new DetailedFlightHolder(
                    (ImageView)viewGroup.findViewById(R.id.logo),
                    (ImageView)viewGroup.findViewById(R.id.logo2),
                    (RelativeLayout)viewGroup.findViewById(R.id.row1),
            		(TextView)viewGroup.findViewById(R.id.time1),
            		(TextView)viewGroup.findViewById(R.id.day1),
                    (TextView)viewGroup.findViewById(R.id.time2),
                    (TextView)viewGroup.findViewById(R.id.day2),
                    (TextView)viewGroup.findViewById(R.id.last_check),
                    (TextView)viewGroup.findViewById(R.id.price));
            viewGroup.setTag(flightHolder);
            item = viewGroup;
		}
		else
		{
			 flightHolder = (DetailedFlightHolder)convertView.getTag();
        	 item = convertView;
		}
    	try{
	    	/*
	    	    Codi on es fa set de les variables de cada row

	    	 */
            //Location Name
            flightHolder.getFlightRow().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View child = context.getLayoutInflater().inflate(R.layout.expanded_flight_row, null);
                    flightHolder.getFlightRow().addView(child);
                    //v.addView(child);
                    //v = context.getLayoutInflater().inflate(R.layout.expanded_flight_row, null, false);
                }
            });

    	}catch(Exception e){    		
    		Log.e("Adapter error flights", e.getMessage());
    	}
    	return item;
    }
}
