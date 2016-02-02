package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class NewAlertActivity extends Activity {

    private RelativeLayout weekendsLayout;
    private RelativeLayout destinationLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_alert_main);

        weekendsLayout = (RelativeLayout)findViewById(R.id.weekends_layout);
        weekendsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        destinationLayout = (RelativeLayout)findViewById(R.id.destination_layout);
        destinationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAlertActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

    }

}
