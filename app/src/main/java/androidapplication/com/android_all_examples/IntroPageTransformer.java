package androidapplication.com.android_all_examples;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Anand on 03-09-2016.
 */
public class IntroPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {


        int pagePosition = (int) page.getTag();

        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        if (position <= -1.0f || position >= 1.0f) {


        } else if (position == 0.0f) {


        } else {

            View title = page.findViewById(R.id.title);
            title.setAlpha(1.0f - absPosition);

            View description = page.findViewById(R.id.description);
            description.setTranslationY(-pageWidthTimesPosition / 2f);
            description.setAlpha(1.0f - absPosition);

            View computer = page.findViewById(R.id.computer);

            if (pagePosition == 0 && computer != null) {
                computer.setAlpha(1.0f - absPosition);
                computer.setTranslationX(-pageWidthTimesPosition * 1.5f);
            }

            if (position < 0) {

            } else {

            }
        }
    }

}
