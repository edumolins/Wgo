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

public class NewAlertActivity extends Activity {

    private Button loginButton;
    private EditText emailInput;
    private EditText passwordInput;
    private TextView errorMessage;
    private RelativeLayout shadowLayout;
    private RelativeLayout errorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        emailInput = (EditText)findViewById(R.id.email_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        errorMessage = (TextView)findViewById(R.id.error_message);
        shadowLayout = (RelativeLayout)findViewById(R.id.shadow_layout);
        errorLayout = (RelativeLayout)findViewById(R.id.error_layout);


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
                Intent intent = new Intent(NewAlertActivity.this, NewAlertActivity.class);
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
                hideError();
            }
        });
        ImageView closeButton = (ImageView)findViewById(R.id.close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError();
            }
        });
    }

    private void validateLogin(){
        if(emailInput.getText().toString().equals("")){

            showError(getResources().getString(R.string.error_mail));

        }else if (passwordInput.getText().toString().equals("")){

            showError(getResources().getString(R.string.error_password));

        }else if (!emailInput.getText().toString().equals("123") && !passwordInput.getText().toString().equals("123")){

            showError(getResources().getString(R.string.error_login));
        }else{

        }
    }

    private void hideError(){
        Animation anim  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_to_down_anim);
        anim.setDuration(500);
        errorLayout.setAnimation(anim);
        errorLayout.startAnimation(anim);
        shadowLayout.setVisibility(View.GONE);
        errorLayout.setVisibility(View.GONE);
    }

    private void showError (String error_message){
        shadowLayout.setVisibility(View.VISIBLE);
        errorMessage.setText(error_message);
        errorLayout.setVisibility(View.VISIBLE);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up_anim);
        anim.setDuration(500);
        errorLayout.setAnimation(anim);
        errorLayout.startAnimation(anim);
    }
}
