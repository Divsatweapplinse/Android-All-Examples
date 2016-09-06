package androidapplication.com.android_all_examples.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.utils.AppConstant;

/**
 * Created by Anand on 06-09-2016.
 */
public class ImageLoginActivity extends Activity {

    EditText editTextEmail,editTextPassword;
    Button btnSubmit;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_login);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidity();
            }
        });


    }
    private void checkValidity(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        if (email==null){
            showError();
            return;
        }
        if (password==null){
            showError();
            return;
        }
        if (!"demo@gmail.com".equals(email)){
            showError();
            return;
        }
        if (!"demo".equals(password)){
            showError();
            return;
        }
        sharedPreferences.edit().putBoolean(AppConstant.IS_LOGGED_IN,true).apply();
        sharedPreferences.edit().putString(AppConstant.EMAIL,email).apply();
        Intent intent = new Intent(ImageLoginActivity.this,ImageActivity.class);
        startActivity(intent);
        finish();
    }

    private void showError(){
        Toast.makeText(ImageLoginActivity.this,"Enter the correct detail",Toast.LENGTH_LONG).show();
    }
}
