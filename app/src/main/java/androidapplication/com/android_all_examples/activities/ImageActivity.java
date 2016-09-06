package androidapplication.com.android_all_examples.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.fragment.MyFeedImageFragment;

/**
 * Created by Anand on 06-09-2016.
 */
public class ImageActivity extends AppCompatActivity{
    ListView listView;
    ArrayAdapter<String> listAdapter;
    String fragmentArray[] = {"My Feed","Profile" };
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

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
                        fragment = new MyFeedImageFragment();
                        break;
                    case 1 :
                        fragment = new MyFeedImageFragment();
                        break;
                    default:
                        fragment = new MyFeedImageFragment();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit();
                drawerLayout.closeDrawers();
            }

        });

        Fragment fragment = new MyFeedImageFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit();



    }
}
