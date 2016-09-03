package androidapplication.com.android_all_examples.adapter;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import androidapplication.com.android_all_examples.fragment.IntroFragment;

/**
 * Created by Anand on 03-09-2016.
 */
public class IntroAdapter extends FragmentPagerAdapter {
    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(Color.parseColor("#03A9F4"), position);
            default:
                return IntroFragment.newInstance(Color.parseColor("#4CAF50"), position);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
