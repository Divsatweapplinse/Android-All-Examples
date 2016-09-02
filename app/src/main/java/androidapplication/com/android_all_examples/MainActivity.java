package androidapplication.com.android_all_examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidapplication.com.android_all_examples.activities.ContactDataActivity;
import androidapplication.com.android_all_examples.activities.EventBusActivity;
import androidapplication.com.android_all_examples.activities.FlatRateActivity;
import androidapplication.com.android_all_examples.activities.InterfaceLearning;
import androidapplication.com.android_all_examples.activities.MileageCalculatorActivity;
import androidapplication.com.android_all_examples.activities.ProfileActivity;
import androidapplication.com.android_all_examples.activities.SplashActivity;
import androidapplication.com.android_all_examples.activities.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonOne = (Button)findViewById(R.id.buttonOne);
        buttonTwo = (Button)findViewById(R.id.buttonTwo);
        buttonThree = (Button)findViewById(R.id.buttonThree);
        buttonFour = (Button)findViewById(R.id.buttonFour);
        buttonFive = (Button)findViewById(R.id.buttonFive);
        buttonSix = (Button)findViewById(R.id.buttonSix);
        buttonSeven = (Button)findViewById(R.id.buttonSeven);
        buttonEight = (Button)findViewById(R.id.buttonEight);


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
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MileageCalculatorActivity.class);
                startActivity(intent);

            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);

            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FlatRateActivity.class);
                startActivity(intent);
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventBusActivity.class);
                startActivity(intent);

            }
        });
    }
}
