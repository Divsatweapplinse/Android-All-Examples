package androidapplication.com.android_all_examples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.utils.AppConstant;

/**
 * Created by Anand on 06-09-2016.
 */
public class ImageFeedDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_detail_image);


        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);


        Intent intent =getIntent();

        if(intent!=null){
            String imageUrl = intent.getStringExtra(AppConstant.IMAGE_URL);
            String title = intent.getStringExtra(AppConstant.FEED_TITLE);
            Glide.with(this).load(imageUrl).into(imageView);
            textView.setText(title);
        }
    }
}
