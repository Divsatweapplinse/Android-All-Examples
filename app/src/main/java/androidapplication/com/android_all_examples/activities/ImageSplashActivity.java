package androidapplication.com.android_all_examples.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import androidapplication.com.android_all_examples.MainActivity;
import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.utils.AppConstant;

/**
 * Created by Anand on 06-09-2016.
 */
public class ImageSplashActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isLoggedIn = sharedPreferences.getBoolean(AppConstant.IS_LOGGED_IN,false);

        if(isLoggedIn){
            Intent intent = new Intent(ImageSplashActivity.this,ImageActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(ImageSplashActivity.this,ImageLoginActivity.class);
            startActivity(intent);
        }
        finish();
    }
}
