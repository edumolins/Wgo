package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import wgo_app.wgo.fonts.CustomButton;
import wgo_app.wgo.utils.Constants;

public class NewAlertActivity extends Activity {

    private RelativeLayout weekendsLayout;
    private RelativeLayout originLayout;
    private RelativeLayout destinationLayout;

    private TextView originLocation;
    private TextView destinationLocation;
    private TextView numberWeekends;


    private TextView minusText;
    private TextView plusText;
    private TextView peopleText;

    private CustomButton availableButton;

    private PriceSeekBar priceSeekBar;
    private DiscreteSeekBar discreteSeekBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_alert_main);


        DiscreteSeekBar discreteSeekBar1 = (DiscreteSeekBar) findViewById(R.id.seek_bar);

        weekendsLayout = (RelativeLayout)findViewById(R.id.weekends_layout);
        weekendsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        originLayout = (RelativeLayout)findViewById(R.id.origin_layout);
        originLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, SearchActivity.class);
                intent.putExtra("from", "Origin");
                startActivity(intent);
            }
        });

        destinationLayout = (RelativeLayout)findViewById(R.id.destination_layout);
        destinationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, SearchActivity.class);
                intent.putExtra("from", "Destination");
                startActivity(intent);
            }
        });

        originLocation = (TextView)findViewById(R.id.origin);
        destinationLocation = (TextView)findViewById(R.id.destination);
        numberWeekends = (TextView)findViewById(R.id.number_weekends);

        minusText = (TextView)findViewById(R.id.minus);
        plusText = (TextView)findViewById(R.id.plus);
        peopleText = (TextView)findViewById(R.id.people);

        minusText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nPeople = Integer.parseInt(peopleText.getText().toString());
                nPeople--;
                peopleText.setText(Integer.toString(nPeople));

            }
        });

        plusText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nPeople = Integer.parseInt(peopleText.getText().toString());
                nPeople++;
                peopleText.setText(Integer.toString(nPeople));

            }
        });

        availableButton = (CustomButton)findViewById(R.id.button_available);
        availableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, AvailableFlightsActivity.class);
                startActivity(intent);
            }
        });

        priceSeekBar = (PriceSeekBar)findViewById(R.id.priceLimitPicker);
        priceLimitCreator(0);


    }

    private void priceLimitCreator(final int defaultValue) {
        priceSeekBar.setProgress(defaultValue);

        priceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = 0 + progress;
                priceSeekBar.setPriceSelected(NewAlertActivity.this, progressChanged);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setSecondaryProgress(seekBar.getProgress());
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(Constants.fromLocationAdapter){
            Constants.fromLocationAdapter = false;
            originLocation.setText(Constants.originLocation);
            destinationLocation.setText(Constants.destinationLocation);
        }

        if(Constants.fromCalendar){
            Constants.fromCalendar= false;
            numberWeekends.setText(Integer.toString(Constants.numWeekends));
        }


    }

}
