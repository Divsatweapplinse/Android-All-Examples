package androidapplication.com.android_all_examples.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidapplication.com.android_all_examples.ProfileFetcher;
import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.interfaces.ProfileListener;
import androidapplication.com.android_all_examples.model.Profile;

/**
 * Created by Anand on 02-09-2016.
 */
public class ProfileActivity extends AppCompatActivity {
    TextView textView,textView2,textView3,textView4,textView5;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pesonalInfo();
            }
        });

    }

    public void pesonalInfo(){

        ProfileFetcher profileFetcher = new ProfileFetcher();
        profileFetcher.profileId(new ProfileListener() {
            @Override
            public void onSuccess(final Profile profile) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(profile.getPersonName() + " Name");
                        textView2.setText(profile.getHeight() + " Height");
                        textView3.setText(profile.getWeight() + " Weight");
                        textView4.setText(profile.getEmail()+ " Email");
                        textView5.setText(profile.getAge()+ " Age");
                    }
                });
            }
        });

    }
}
