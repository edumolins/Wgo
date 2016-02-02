package wgo_app.wgo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

import wgo_app.wgo.adapter.LocationAdapter;
import wgo_app.wgo.fonts.GNLightEditText;
import wgo_app.wgo.objects.ObjLocation;

public class SearchActivity extends Activity {
   
	
	private String nameUser = "";
	private JSONArray jsonArray;	
	private ListView listLocations;
	private GNLightEditText searchBar;
	private LocationAdapter locationAdapter;
	private ArrayList<ObjLocation> locationDatos = new ArrayList<ObjLocation>();
	StringBuffer buffer;
	 /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	try{
	        setContentView(R.layout.search_main);
	        jsonArray = new JSONArray();
	        searchBar = (GNLightEditText)findViewById(R.id.destination);
	        locationDatos.clear();
	        listLocations= (ListView)findViewById(R.id.list_locations);
	        //Utils.listOverScrollMode(listFriends);
	        buffer = new StringBuffer();
			listLocations.setDivider(null);
	        listLocations.setTextFilterEnabled(true);
	        listLocations.setFastScrollEnabled(true);
	        TextWatcher filterTextWatcher = new TextWatcher() {
	            public void afterTextChanged(Editable s) {
	            }
	            public void beforeTextChanged(CharSequence s, int start, int count,
	                    int after) {
	            }
	            public void onTextChanged(CharSequence s, int start, int before,
	                    int count) {
	            	try{
	            		locationAdapter.getFilter().filter(s);
	            		locationAdapter.notifyDataSetChanged();
	            	}catch(Exception e){}
	            }
	        };
	        searchBar.addTextChangedListener(filterTextWatcher);
	        searchBar.setEnabled(false);

	        new GetLocations().execute();
    	}catch(Exception e){
    		
    	}
    }

	private class GetLocations extends AsyncTask<String, Void, Boolean> {
		private String result_locations;
		public GetLocations() {
			super();
		}

		@Override
		protected Boolean doInBackground(String... params) {
			return null;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			try{

				locationDatos.add(new ObjLocation(1, "ROMA", "ITALIA"));
				locationDatos.add(new ObjLocation(2, "BARCELONA", "ESPAÑA"));
				locationDatos.add(new ObjLocation(3, "LONDRES", "REINO UNIDO"));
				locationDatos.add(new ObjLocation(4, "NUEVA YORK", "ESTADOS UNIDOS"));
				locationDatos.add(new ObjLocation(5, "BARCELONA", "COLOMBIA"));
				locationDatos.add(new ObjLocation(6, "BERLÍN", "ALEMANIA"));
				locationDatos.add(new ObjLocation(7, "LONDRINA", "ANDORRA"));
				locationDatos.add(new ObjLocation(7, "SANTA CRUS DE TENERIFE", "PAÍS MEGALARGO"));
				locationAdapter = new LocationAdapter(SearchActivity.this, locationDatos);
				//listFriends.setVisibility(View.VISIBLE);
				listLocations.setAdapter(locationAdapter);
				listLocations.setSelection(0);
				//jsonEmails = null; jsonArray = null;

			}catch (Exception e){
				Log.e("Error list locations", e.getMessage());
			}
			searchBar.setEnabled(true);
			super.onPostExecute(result);
       
		}

	}
	
   
}