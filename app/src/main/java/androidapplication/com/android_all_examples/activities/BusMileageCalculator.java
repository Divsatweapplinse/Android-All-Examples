package androidapplication.com.android_all_examples.activities;

import androidapplication.com.android_all_examples.interfaces.MileageCalculator;
import androidapplication.com.android_all_examples.interfaces.MileageListener;

/**
 * Created by Anand on 02-09-2016.
 */
public class BusMileageCalculator implements MileageCalculator {
    int kmTravelled;
    int fuelUsed;
    public BusMileageCalculator(int kmTravelled,int fuelUsed){
        this.kmTravelled = kmTravelled;
        this.fuelUsed = fuelUsed;
    }


    @Override
    public void calculate(final MileageListener mileageListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int mileage = (kmTravelled/fuelUsed)-2;
                    Thread.sleep(1000);
                    mileageListener.onSuccess(mileage);
                }catch (Exception e){
                    e.printStackTrace();
                    mileageListener.onError();
                }
            }
        }).start();

    }
}
