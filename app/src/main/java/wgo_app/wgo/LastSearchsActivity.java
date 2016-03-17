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

import wgo_app.wgo.adapter.LastSearchAdapter;
import wgo_app.wgo.objects.ObjLastSearch;

public class LastSearchsActivity extends Activity {

    private ArrayList<ObjLastSearch> searchDatos = new ArrayList<>();
    private LastSearchAdapter searchAdapter;
    private ListView listSearch;
    private RelativeLayout headerFlight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_searchs_main);

        ImageView back = (ImageView)findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listSearch= (ListView)findViewById(R.id.list_search);
        RelativeLayout close = (RelativeLayout)findViewById(R.id.close_layout);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        headerFlight = (RelativeLayout)getLayoutInflater().inflate(R.layout.header_empty, null, false);
        listSearch.addHeaderView(headerFlight);
        new GetSearch().execute();
    }

    private class GetSearch extends AsyncTask<String, Void, Boolean> {

        public GetSearch() {
            super();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            try{
                for (int i =0; i < 3; i++){
                    searchDatos.add(new ObjLastSearch(1));
                }
                searchAdapter = new LastSearchAdapter(LastSearchsActivity.this, searchDatos);
                listSearch.setAdapter(searchAdapter);
                listSearch.setSelection(0);

            }catch (Exception e){
                Log.e("Error list last searchs", e.getMessage());
            }
            super.onPostExecute(result);

        }

    }


}
