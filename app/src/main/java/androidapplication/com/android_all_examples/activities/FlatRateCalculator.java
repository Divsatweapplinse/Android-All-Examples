package androidapplication.com.android_all_examples.activities;

import androidapplication.com.android_all_examples.interfaces.RateListener;

/**
 * Created by Anand on 02-09-2016.
 */
public class FlatRateCalculator {

    int noOfRooms;
    int noOfDiningRooms;
    public FlatRateCalculator(int noOfRooms,int noOfDiningRooms){
        this.noOfRooms=noOfRooms;
        this.noOfDiningRooms=noOfDiningRooms;

    }
    public void calculate(final RateListener rateListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int total = 25*noOfRooms + 30*noOfDiningRooms;
                    Thread.sleep(2000);
                    rateListener.onSuccess(total);
                } catch (Exception e) {
                    e.printStackTrace();
                    rateListener.onError("someError");
                }
            }
        }).start();
    }

}
