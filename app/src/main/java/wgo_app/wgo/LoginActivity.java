package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import wgo_app.wgo.fonts.CustomButton;

public class LoginActivity extends Activity {

    private Button loginButton;
    private EditText emailInput;
    private EditText passwordInput;
    private TextView errorMessage;
    private RelativeLayout shadowLayout;
    private RelativeLayout errorLayout;
    private RelativeLayout errorFbLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        emailInput = (EditText)findViewById(R.id.email_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        errorMessage = (TextView)findViewById(R.id.error_message);
        shadowLayout = (RelativeLayout)findViewById(R.id.shadow_layout);
        errorLayout = (RelativeLayout)findViewById(R.id.error_layout);
        errorFbLayout = (RelativeLayout)findViewById(R.id.error_fb_layout);

        loginButton = (Button)findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });

        TextView signIn = (TextView)findViewById(R.id.sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

        ImageView backIcon = (ImageView)findViewById(R.id.back_icon);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Hide Error Layout
        Button errorButton = (Button)findViewById(R.id.error_button);
        errorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(errorLayout);
            }
        });
        ImageView closeButton = (ImageView)findViewById(R.id.close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(errorLayout);
            }
        });

        ImageView closeFbButton = (ImageView)findViewById(R.id.close_fb);
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

    private void validateLogin(){

        if(emailInput.getText().toString().equals("")){

            showError(errorLayout, getResources().getString(R.string.error_mail));

        }else if (passwordInput.getText().toString().equals("")){

            showError(errorLayout, getResources().getString(R.string.error_password));

        }else if (emailInput.getText().toString().equals("123") && passwordInput.getText().toString().equals("123")){

            Intent intent = new Intent(LoginActivity.this, NewAlertActivity.class);
            startActivity(intent);

        }else{

            showError(errorLayout, getResources().getString(R.string.error_login));

        }
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
        errorMessage.setText(error_message);
        layout.setVisibility(View.VISIBLE);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up_anim);
        anim.setDuration(500);
        layout.setAnimation(anim);
        layout.startAnimation(anim);
    }
}
