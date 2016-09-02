package androidapplication.com.android_all_examples.activities;

import androidapplication.com.android_all_examples.interfaces.MileageCalculator;
import androidapplication.com.android_all_examples.interfaces.MileageListener;

/**
 * Created by Anand on 02-09-2016.
 */
public class CarMileageCalculator implements MileageCalculator{
    int kmTravelled;
    int fuelUsed;

    public CarMileageCalculator(int kmTravelled,int fuelUsed){
        this.kmTravelled = kmTravelled;
        this.fuelUsed = fuelUsed;
    }



    @Override
    public void calculate(final MileageListener mileageListener) {
        new Thread(new Runnable() {//in background
            @Override
            public void run() {
                try {
                    int mileage = kmTravelled/fuelUsed;
                    Thread.sleep(2000);
                    mileageListener.onSuccess(mileage);
                }catch (Exception e){
                    e.printStackTrace();
                    mileageListener.onError();
                }
            }
        }).start();

    }
}
