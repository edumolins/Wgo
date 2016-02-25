package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RelativeLayout globalLayout;
    private RelativeLayout searchLayout;

    private RelativeLayout alertsLayout;
    private RelativeLayout newAlertLayout;
    private RelativeLayout manageLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //WELCOME VIEW
        globalLayout = (RelativeLayout)findViewById(R.id.global_layout);
        searchLayout = (RelativeLayout)findViewById(R.id.last_search);
        alertsLayout = (RelativeLayout)findViewById(R.id.alerts);
        newAlertLayout = (RelativeLayout)findViewById(R.id.new_alert);
        manageLayout = (RelativeLayout)findViewById(R.id.manage_alerts);

        /*
        searchLayout.setVisibility(View.VISIBLE);
        alertsLayout.setVisibility(View.VISIBLE);

        Animation anim  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up_anim);
        anim.setDuration(500);
        globalLayout.setAnimation(anim);
        globalLayout.startAnimation(anim);
        */

        RelativeLayout alert = (RelativeLayout)findViewById(R.id.new_alert);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewAlertActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout manage = (RelativeLayout)findViewById(R.id.manage_alerts);
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, LastSearchsActivity.class);
                startActivity(intent);
            }
        });

        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout friends = (RelativeLayout)findViewById(R.id.friends);
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout friends = (RelativeLayout)findViewById(R.id.friends_layout);
                friends.setVisibility(View.VISIBLE);
                Animation anim  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up_anim);
                anim.setDuration(500);
                friends.setAnimation(anim);
                friends.startAnimation(anim);
                newAlertLayout.setEnabled(false);
                manageLayout.setEnabled(false);


            }
        });

        RelativeLayout closeFriends = (RelativeLayout)findViewById(R.id.close_layout);
        closeFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout friends = (RelativeLayout)findViewById(R.id.friends_layout);
                Animation anim  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_to_down_anim);
                anim.setDuration(500);
                friends.setAnimation(anim);
                friends.startAnimation(anim);
                friends.setVisibility(View.GONE);
                newAlertLayout.setEnabled(true);
                manageLayout.setEnabled(true);
            }
        });

        LinearLayout share = (LinearLayout)findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Exemple de subject");
                share.putExtra(Intent.EXTRA_TEXT, "https://www.google.com");
                startActivity(Intent.createChooser(share, "Comparteix WGO!"));
            }
        });

    }
}
