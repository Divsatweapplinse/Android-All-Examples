package androidapplication.com.android_all_examples.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import androidapplication.com.android_all_examples.IntroPageTransformer;
import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.adapter.IntroAdapter;

/**
 * Created by Anand on 03-09-2016.
 */
public class IntroActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);


        mViewPager.setAdapter(new IntroAdapter(getSupportFragmentManager()));

        mViewPager.setPageTransformer(false, new IntroPageTransformer());
    }
}
