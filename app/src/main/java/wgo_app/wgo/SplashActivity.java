package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashActivity extends Activity {

    private ImageView logoImg;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_main);

        logoImg = (ImageView)findViewById(R.id.log_img);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setFillAfter(true);
        anim.setDuration(2000);
        logoImg.setVisibility(View.VISIBLE);
        logoImg.setAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2800);


	}


}