package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    private RelativeLayout welcomeLayout;
    private RelativeLayout globalLayout;
    private RelativeLayout searchLayout;

    private RelativeLayout alertsLayout;
    private RelativeLayout newAlertLayout;
    private RelativeLayout manageLayout;

    private ViewFlipper viewFlipper;
    private Button goButton;
    private float lastX;
    private ImageView point1;
    private ImageView point2;
    private ImageView point3;

    //TextViews


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //WELCOME VIEW
        welcomeLayout = (RelativeLayout)findViewById(R.id.welcome_layout);
        globalLayout = (RelativeLayout)findViewById(R.id.global_layout);
        searchLayout = (RelativeLayout)findViewById(R.id.last_search);
        alertsLayout = (RelativeLayout)findViewById(R.id.alerts);
        newAlertLayout = (RelativeLayout)findViewById(R.id.new_alert);
        manageLayout = (RelativeLayout)findViewById(R.id.manage_alerts);


        viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
        goButton = (Button)findViewById(R.id.go_button);
        point1 = (ImageView)findViewById(R.id.point1);
        point2 = (ImageView)findViewById(R.id.point2);
        point3 = (ImageView)findViewById(R.id.point3);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchLayout.setVisibility(View.VISIBLE);
                alertsLayout.setVisibility(View.VISIBLE);

                Animation anim  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up_anim);
                anim.setDuration(500);
                globalLayout.setAnimation(anim);
                globalLayout.startAnimation(anim);

                welcomeLayout.setVisibility(View.GONE);
            }
        });

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

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();
                // Handling left to right screen swap.
                if (lastX < currentX) {
                    // If there aren't any other children, just break.
                    if (viewFlipper.getDisplayedChild() == 0)
                    break;
                    // Next screen comes in from left.
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                    // Current screen goes out from right.
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                    // Display next screen.
                    viewFlipper.showNext();
                }
                // Handling right to left screen swap.
                if (lastX > currentX) {
                    // If there is a child (to the left), kust break.
                    if (viewFlipper.getDisplayedChild() == 1)
                    break;
                    // Next screen comes in from right.
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                    // Current screen goes out from left.
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                    // Display previous screen
                    viewFlipper.showPrevious();

                }

                if(viewFlipper.getDisplayedChild() == 1 ){
                    point3.setImageResource(R.drawable.elipse_gris);
                    point2.setImageResource(R.drawable.elipse_trans);
                    point1.setImageResource(R.drawable.elipse_trans);
                }else if (viewFlipper.getDisplayedChild() == 2){
                    point2.setImageResource(R.drawable.elipse_gris);
                    point1.setImageResource(R.drawable.elipse_trans);
                    point3.setImageResource(R.drawable.elipse_trans);
                }else{
                    point1.setImageResource(R.drawable.elipse_gris);
                    point2.setImageResource(R.drawable.elipse_trans);
                    point3.setImageResource(R.drawable.elipse_trans);
                }

                break;
        }
        return false;
    }
}
