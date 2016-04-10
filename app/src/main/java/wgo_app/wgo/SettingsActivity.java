package wgo_app.wgo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends Activity {


    private Spinner language;
    private RadioGroup currency;
    private Spinner alerts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);

        //Language
        language = (Spinner)findViewById(R.id.language_select);
        List<String> list = new ArrayList<String>();
        list.add("English");
        list.add("Español");
        list.add("Català");
        ArrayAdapter<String> languageAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_row, list);
        languageAdapter.setDropDownViewResource(R.layout.dropdown_row);
        language.setAdapter(languageAdapter);

        //Currency
        currency = (RadioGroup) findViewById(R.id.radioCurrency);
        currency.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });


        //Alerts
        alerts = (Spinner)findViewById(R.id.alerts_select);
        list = new ArrayList<String>();
        list.add("Daily");
        list.add("Weekly");
        list.add("monthly");
        ArrayAdapter<String> alertsAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_row, list);
        alertsAdapter.setDropDownViewResource(R.layout.dropdown_row);
        alerts.setAdapter(alertsAdapter);

        //
    }

}
