package wgo_app.wgo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import wgo_app.wgo.adapter.DetailedFlightAdapter;
import wgo_app.wgo.objects.ObjFlight;

public class DetailedFlightsActivity extends Activity {

    private ArrayList<ObjFlight> flightDatos = new ArrayList<>();
    private DetailedFlightAdapter flightAdapter;
    private ListView listFlights;
    private RelativeLayout headerFlight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_flights_main);

        ImageView back = (ImageView)findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listFlights= (ListView)findViewById(R.id.list_flights);
        headerFlight = (RelativeLayout)getLayoutInflater().inflate(R.layout.header_flight, null, false);
        listFlights.addHeaderView(headerFlight);
        RelativeLayout close = (RelativeLayout)findViewById(R.id.close_layout);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        new GetFlights().execute();
    }

    private class GetFlights extends AsyncTask<String, Void, Boolean> {

        public GetFlights() {
            super();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            try{
                for (int i =0; i < 15; i++){
                    flightDatos.add(new ObjFlight(1));
                }
                flightAdapter = new DetailedFlightAdapter(DetailedFlightsActivity.this, flightDatos);
                //listFriends.setVisibility(View.VISIBLE);
                listFlights.setAdapter(flightAdapter);
                listFlights.setSelection(0);
                //jsonEmails = null; jsonArray = null;

            }catch (Exception e){
                Log.e("Error list locations", e.getMessage());
            }
            super.onPostExecute(result);

        }

    }


}
