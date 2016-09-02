package androidapplication.com.android_all_examples.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.interfaces.MileageCalculator;
import androidapplication.com.android_all_examples.interfaces.MileageListener;

/**
 * Created by Anand on 02-09-2016.
 */
public class MileageCalculatorActivity extends AppCompatActivity {
    Button btnCarMileage,btnBusMileage;
    EditText edit1,edit2;
    TextView textView,textViewBusMileage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mileage_calculator);

        btnCarMileage = (Button)findViewById(R.id.btnCarMileage);
        btnBusMileage = (Button)findViewById(R.id.btnBusMileage);
        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        textView = (TextView) findViewById(R.id.textView);
        textViewBusMileage = (TextView) findViewById(R.id.textViewBusMileage);

        btnCarMileage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                findCarMileage();
            }
        });
        btnBusMileage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findBusMileage();
            }
        });

    }
    public void findCarMileage(){
        int kmTravelled;
        int fuelUsed;

        kmTravelled = Integer.valueOf(edit1.getText().toString());
        fuelUsed = Integer.valueOf(edit2.getText().toString());

        MileageCalculator carMileageCalculator = new CarMileageCalculator(kmTravelled,fuelUsed);
        carMileageCalculator.calculate(new MileageListener() {
            @Override
            public void onSuccess(final int mileage) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(mileage + " car mileage");
                    }
                });
            }
            @Override
            public void onError() {

            }
        });
    }


    public void findBusMileage(){
        int kmTravelled;
        int fuelUsed;

        kmTravelled = Integer.valueOf(edit1.getText().toString());
        fuelUsed = Integer.valueOf(edit2.getText().toString());

        MileageCalculator busMileageCalculator = new BusMileageCalculator(kmTravelled,fuelUsed);
        busMileageCalculator.calculate(new MileageListener() {
            @Override
            public void onSuccess(final int mileage) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewBusMileage.setText(mileage + " bus mileage ");
                    }
                });
            }
            @Override
            public void onError() {

            }
        });
    }

}
