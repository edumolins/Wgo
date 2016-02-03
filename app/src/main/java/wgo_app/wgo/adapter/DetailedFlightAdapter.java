package wgo_app.wgo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import wgo_app.wgo.DetailedFlightsActivity;
import wgo_app.wgo.R;
import wgo_app.wgo.objects.FlightHolder;
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
    	final FlightHolder flightHolder;
    	View item = convertView;
    	if(item == null)
		{
    		LayoutInflater inflater= context.getLayoutInflater();
			View viewGroup = inflater.inflate(R.layout.detailed_flight_row, parent, false);
			//using the ViewHolder pattern to reduce lookups
            flightHolder = new FlightHolder(
                    (RelativeLayout)viewGroup.findViewById(R.id.row),
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
			 flightHolder = (FlightHolder)convertView.getTag();
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
                    Intent intent = new Intent(context, DetailedFlightsActivity.class);
                    context.startActivity(intent);
                }
            });

    	}catch(Exception e){    		
    		Log.e("Adapter error flights", e.getMessage());
    	}
    	return item;
    }
}
