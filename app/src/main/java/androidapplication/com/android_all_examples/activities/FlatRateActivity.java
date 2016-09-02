package androidapplication.com.android_all_examples.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.interfaces.RateListener;

/**
 * Created by Anand on 02-09-2016.
 */
public class FlatRateActivity extends AppCompatActivity {

    EditText edit1,edit2;
    TextView textview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_rate);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        textview = (TextView) findViewById(R.id.textview);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCalculation();
            }
        });

    }
    public void doCalculation(){

        progressBar.setVisibility(View.VISIBLE);

        textview.setText("Calculating...");
        int noOfRooms;
        int noOfDiningRooms;

        noOfRooms = Integer.valueOf(edit1.getText().toString());
        noOfDiningRooms = Integer.valueOf(edit2.getText().toString());

        FlatRateCalculator flatRateCalculator = new FlatRateCalculator(noOfRooms,noOfDiningRooms);

        flatRateCalculator.calculate(new RateListener() {
            @Override
            public void onSuccess(final int rate) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        progressBar.setVisibility(View.INVISIBLE);
                        textview.setText(rate + " lakhs");
                    }
                });
            }

            @Override
            public void onError(String error) {

            }
        });


    }
}
