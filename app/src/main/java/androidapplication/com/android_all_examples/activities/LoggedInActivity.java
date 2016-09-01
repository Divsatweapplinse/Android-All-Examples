package androidapplication.com.android_all_examples.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.fragment.MyFeedFragment;
import androidapplication.com.android_all_examples.utils.AppConstant;

/**
 * Created by Anand on 30-08-2016.
 */
public class LoggedInActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> listAdapter;
    String fragmentArray[] = {"Login","My Feed"};
    DrawerLayout drawerLayout;
    CallbackManager callbackManager;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_logged_in);

        listView = (ListView)findViewById(R.id.fragmentList);
        listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fragmentArray);
        listView.setAdapter(listAdapter);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment fragment;

                switch (i){
                    case 0:
                        fragment = new MyFeedFragment();
                        break;
                    case 1 :
                        fragment = new MyFeedFragment();
                        break;
                    default:
                        fragment = new MyFeedFragment();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit();
            }
        });

        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {


            }

            @Override
            public void onError(FacebookException error) {


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
                                                   AccessToken currentAccessToken) {
            if (currentAccessToken == null) {
                //write your code here what to do when user logout

                sharedPreferences.edit().putBoolean(AppConstant.IS_LOGGED_IN,false).apply();
                Intent intent = new Intent(LoggedInActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();


            }

        }
    };
}
