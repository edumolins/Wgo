package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

public class WelcomeActivity extends Activity {

    private RelativeLayout welcomeLayout;

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
        setContentView(R.layout.welcome_main);

        //WELCOME VIEW
        welcomeLayout = (RelativeLayout)findViewById(R.id.welcome_layout);

        viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
        goButton = (Button)findViewById(R.id.go_button);
        point1 = (ImageView)findViewById(R.id.point1);
        point2 = (ImageView)findViewById(R.id.point2);
        point3 = (ImageView)findViewById(R.id.point3);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

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
