package androidapplication.com.android_all_examples.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.utils.AppConstant;

/**
 * Created by Anand on 02-09-2016.
 */
public class LifeCycleActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    boolean hasToBeUpdated=false;
    Button btnAdd,btnEdit;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);


        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnEdit = (Button)findViewById(R.id.btnEdit);
        textView = (TextView)findViewById(R.id.textView);
        Button btnClearData = (Button)findViewById(R.id.btnClearData);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        updateData();

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LifeCycleActivity.this,EditTextActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEdit.performClick();
            }
        });

        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString(AppConstant.TEXT,"").apply();
                textView.setText("");
                btnEdit.setVisibility(View.INVISIBLE);
                btnAdd.setVisibility(View.VISIBLE);

            }
        });
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (hasToBeUpdated){
            updateData();
            hasToBeUpdated = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(UpdateEvent event){
        hasToBeUpdated = true;
    }

    public void updateData(){
        String savedData = sharedPreferences.getString(AppConstant.TEXT,"");


        if (savedData!=null&&!savedData.isEmpty()){
            // show saveddata in twxt
            btnAdd.setVisibility(View.INVISIBLE);
            textView.setText(savedData);




        }else{
            // hide text show add
            textView.setVisibility(View.INVISIBLE);
            btnAdd.setVisibility(View.VISIBLE);
            btnEdit.setVisibility(View.INVISIBLE);



        }
    }
}
