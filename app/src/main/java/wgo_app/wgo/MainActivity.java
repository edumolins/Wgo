package wgo_app.wgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout alertLayout = (RelativeLayout)findViewById(R.id.new_alert);
        alertLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout manageLayout = (RelativeLayout)findViewById(R.id.manage_alerts);
        manageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout friendsLayout = (RelativeLayout)findViewById(R.id.friends);
        friendsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout friends = (RelativeLayout)findViewById(R.id.friends_layout);
                friends.setVisibility(View.VISIBLE);
                Animation anim  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up_anim);
                anim.setDuration(500);
                friends.setAnimation(anim);
                friends.startAnimation(anim);


            }
        });

        ImageView closeFriends = (ImageView)findViewById(R.id.close);
        closeFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout friends = (RelativeLayout)findViewById(R.id.friends_layout);
                Animation anim  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_to_down_anim);
                anim.setDuration(500);
                friends.setAnimation(anim);
                friends.startAnimation(anim);
                friends.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
