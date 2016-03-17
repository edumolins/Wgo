package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import wgo_app.wgo.fonts.CustomButton;
import wgo_app.wgo.utils.Constants;

public class NewAlertActivity extends Activity {

    private LinearLayout weekendsLayout;
    private LinearLayout originLayout;
    private LinearLayout destinationLayout;

    private RelativeLayout shadowLayout;
    private RelativeLayout errorLayout;
    private TextView errorMessage;

    private TextView originLocation;
    private TextView destinationLocation;
    private TextView numberWeekends;


    private RelativeLayout minusText;
    private TextView plusText;
    private TextView peopleText;

    private CustomButton availableButton;

    private PriceSeekBar priceSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_alert_main);

        //DiscreteSeekBar discreteSeekBar1 = (DiscreteSeekBar) findViewById(R.id.seek_bar);

        weekendsLayout = (LinearLayout) findViewById(R.id.weekends_layout);
        weekendsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        originLayout = (LinearLayout) findViewById(R.id.origin_layout);
        originLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, SearchActivity.class);
                intent.putExtra("from", "Origin");
                startActivity(intent);
            }
        });

        destinationLayout = (LinearLayout) findViewById(R.id.destination_layout);
        destinationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, SearchActivity.class);
                intent.putExtra("from", "Destination");
                startActivity(intent);
            }
        });

        originLocation = (TextView) findViewById(R.id.origin);
        destinationLocation = (TextView) findViewById(R.id.destination);
        numberWeekends = (TextView) findViewById(R.id.number_weekends);

        minusText = (RelativeLayout) findViewById(R.id.minus_l);
        plusText = (TextView) findViewById(R.id.plus);
        peopleText = (TextView) findViewById(R.id.people);

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

        availableButton = (CustomButton) findViewById(R.id.button_available);
        availableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateSearch();
            }
        });

        priceSeekBar = (PriceSeekBar) findViewById(R.id.priceLimitPicker);
        priceLimitCreator(0);


        RelativeLayout close = (RelativeLayout) findViewById(R.id.close_layout);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //ERRORS
        errorLayout = (RelativeLayout) findViewById(R.id.error_layout);
        shadowLayout = (RelativeLayout) findViewById(R.id.shadow_layout);
        errorMessage = (TextView) findViewById(R.id.error_message);

        //Hide Error Layout
        Button errorButton = (Button) findViewById(R.id.error_button);
        errorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(errorLayout);
            }
        });
        RelativeLayout closeButton = (RelativeLayout) findViewById(R.id.close_error);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(errorLayout);
            }
        });
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
    protected void onResume() {
        super.onResume();
        if (Constants.fromLocationAdapter) {
            Constants.fromLocationAdapter = false;
            originLocation.setText(Constants.originLocation);
            destinationLocation.setText(Constants.destinationLocation);
        }

        if (Constants.fromCalendar) {
            Constants.fromCalendar = false;
            numberWeekends.setText(Integer.toString(Constants.numWeekends));
        }


    }

    private void hideError(RelativeLayout layout) {
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_to_down_anim);
        anim.setDuration(500);
        layout.setAnimation(anim);
        layout.startAnimation(anim);
        shadowLayout.setVisibility(View.GONE);
        layout.setVisibility(View.GONE);
    }

    private void showError(RelativeLayout layout, String error_message) {
        shadowLayout.setVisibility(View.VISIBLE);
        errorMessage.setText(error_message);
        layout.setVisibility(View.VISIBLE);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up_anim);
        anim.setDuration(500);
        layout.setAnimation(anim);
        layout.startAnimation(anim);
    }

    private void validateSearch() {

        //Simulació error
        if (Integer.parseInt(numberWeekends.getText().toString()) == 0)
            showError(errorLayout, getResources().getString(R.string.error_alert_no_results));
        else
        {
            Intent intent = new Intent(NewAlertActivity.this, AvailableFlightsActivity.class);
            startActivity(intent);
        }

    }

}
