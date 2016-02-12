package wgo_app.wgo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import wgo_app.wgo.fonts.CustomButton;

public class RegisterActivity extends Activity {

    private RelativeLayout errorFbLayout;
    private RelativeLayout shadowLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        errorFbLayout = (RelativeLayout)findViewById(R.id.error_fb_layout);
        shadowLayout = (RelativeLayout)findViewById(R.id.shadow_layout);

        RelativeLayout backIcon = (RelativeLayout)findViewById(R.id.close_layout);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RelativeLayout closeFbButton = (RelativeLayout)findViewById(R.id.close_error_fb);
        closeFbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(errorFbLayout);
            }
        });

        CustomButton fbButton = (CustomButton)findViewById(R.id.button_facebook);
        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showError(errorFbLayout, "");
            }
        });
    }

    private void hideError(RelativeLayout layout){
        Animation anim  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_to_down_anim);
        anim.setDuration(500);
        layout.setAnimation(anim);
        layout.startAnimation(anim);
        shadowLayout.setVisibility(View.GONE);
        layout.setVisibility(View.GONE);
    }

    private void showError (RelativeLayout layout, String error_message){
        shadowLayout.setVisibility(View.VISIBLE);
        layout.setVisibility(View.VISIBLE);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up_anim);
        anim.setDuration(500);
        layout.setAnimation(anim);
        layout.startAnimation(anim);
    }
}
