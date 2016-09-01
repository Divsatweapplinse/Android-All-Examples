package androidapplication.com.android_all_examples.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.adapter.CustomPagerAdapter;

/**
 * Created by Anand on 30-08-2016.
 */
public class ViewPagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }
}
//circle pager indicator keyb