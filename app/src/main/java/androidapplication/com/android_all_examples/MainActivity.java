package androidapplication.com.android_all_examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidapplication.com.android_all_examples.activities.ContactDataActivity;
import androidapplication.com.android_all_examples.activities.InterfaceLearning;
import androidapplication.com.android_all_examples.activities.SplashActivity;
import androidapplication.com.android_all_examples.activities.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonOne,buttonTwo,buttonThree,buttonFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = (Button)findViewById(R.id.buttonOne);
        buttonTwo = (Button)findViewById(R.id.buttonTwo);
        buttonThree = (Button)findViewById(R.id.buttonThree);
        buttonFour = (Button)findViewById(R.id.buttonFour);


        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);

            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);

            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InterfaceLearning.class);
                startActivity(intent);

            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactDataActivity.class);
                startActivity(intent);

            }
        });
    }
}
