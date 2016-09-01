package androidapplication.com.android_all_examples.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.adapter.PersonAdapter;
import androidapplication.com.android_all_examples.interfaces.DialogShowListener;
import androidapplication.com.android_all_examples.model.Person;

/**
 * Created by Anand on 01-09-2016.
 */
public class InterfaceLearning extends AppCompatActivity implements DialogShowListener {
    public List<Person> personList = new ArrayList<>();
    ListView list;
    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_learning);

        setListData();
        list = (ListView) findViewById(R.id.listView);
        personAdapter = new PersonAdapter(this);
        personAdapter.register(this);
        list.setAdapter(personAdapter);
        personAdapter.updateList(personList);

    }

    public void setListData() {

        for (int i = 0; i < 20; i++) {
            Person  person = new Person();
            person.setPersonName("Name : "+i);
            person.setAge(i);
            person.setHeight(30-i);
            person.setWeight(25+i);
            personList.add(person);
        }
    }
    @Override
    public void showNameChangeDialog(int position) {
        change(position,"name");
    }

    @Override
    public void showHeightChangeDialog(int position) {
        change(position,"height");
    }
    @Override
    public void showAgeChangeDialog(int position) {
        change(position,"age");
    }
    @Override
    public void showWeightChangeDialog(int position) {
        change(position,"weight");
    }

    private void change(final int position, final String type){

        LayoutInflater layoutInflater = LayoutInflater.from(InterfaceLearning.this);
        View promptView = layoutInflater.inflate(R.layout.dialog_change_title, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(InterfaceLearning.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.editText);


        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String changedValue = editText.getText().toString();
                        if (changedValue!=null&&!changedValue.isEmpty()){
                            if("name".equals(type)){
                                personList.get(position).setPersonName(changedValue);
                            }else if("height".equals(type)){
                                personList.get(position).setHeight(Integer.valueOf(changedValue));
                            }else if("age".equals(type)){
                                personList.get(position).setAge(Integer.valueOf(changedValue));
                            }else if ("weight".equals(type)){
                                personList.get(position).setWeight(Integer.valueOf(changedValue));
                            }
                            dialog.cancel();
                            personAdapter.updateList(personList);
                        }else {
                            Toast.makeText(InterfaceLearning.this, "Please enter text", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
