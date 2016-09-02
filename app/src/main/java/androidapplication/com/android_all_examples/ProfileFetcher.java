package androidapplication.com.android_all_examples;

import androidapplication.com.android_all_examples.interfaces.ProfileListener;
import androidapplication.com.android_all_examples.model.Profile;

/**
 * Created by Anand on 02-09-2016.
 */
public class ProfileFetcher {
    public void profileId(final ProfileListener profileListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Profile profile = new Profile();
                    profile.setAge(30);
                    profile.setEmail("dxg");
                    profile.setPersonName("djk");
                    profile.setHeight(6);
                    profile.setWeight(70);
                    profileListener.onSuccess(profile);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
