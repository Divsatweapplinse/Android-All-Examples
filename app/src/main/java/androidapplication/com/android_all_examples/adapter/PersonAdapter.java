package androidapplication.com.android_all_examples.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.interfaces.DialogShowListener;
import androidapplication.com.android_all_examples.model.Person;

/**
 * Created by Anand on 01-09-2016.
 */
public class PersonAdapter extends BaseAdapter {

    private Context context;
    private List<Person> list = new ArrayList<>();
    private DialogShowListener dialogShowListener;

    public PersonAdapter(Context context) {
        this.context = context;
    }
    public void register(DialogShowListener dialogShowListener){
        this.dialogShowListener = dialogShowListener;
    }

    public void updateList(List<Person> personList) {
        this.list = personList;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.person_list, parent, false);
            holder = new ViewHolder();
            holder.textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.textViewHeight = (TextView) convertView.findViewById(R.id.textViewHeight);
            holder.textViewAge = (TextView) convertView.findViewById(R.id.textViewAge);
            holder.textViewWeight = (TextView) convertView.findViewById(R.id.textViewWeight);
            holder.btnChangeName = (Button) convertView.findViewById(R.id.btnChangeName);
            holder.btnChangeHeight = (Button) convertView.findViewById(R.id.btnChangeHeight);
            holder.btnChangeAge = (Button) convertView.findViewById(R.id.btnChangeAge);
            holder.btnChangeWeight = (Button) convertView.findViewById(R.id.btnChangeWeight);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewName.setText(list.get(position).getPersonName());
        holder.textViewHeight.setText(String.valueOf(list.get(position).getHeight()));
        holder.textViewAge.setText(String.valueOf(list.get(position).getAge()));
        holder.textViewWeight.setText(String.valueOf(list.get(position).getWeight()));

        holder.btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShowListener.showNameChangeDialog(position);

            }
        });
        holder.btnChangeHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShowListener.showHeightChangeDialog(position);

            }
        });
        holder.btnChangeAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShowListener.showAgeChangeDialog(position);

            }
        });
        holder.btnChangeWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShowListener.showWeightChangeDialog(position);

            }
        });

        return convertView;
    }

    public static class ViewHolder {
        public TextView textViewName;
        public TextView textViewHeight;
        public TextView textViewAge;
        public TextView textViewWeight;
        public Button btnChangeName;
        public Button btnChangeHeight;
        public Button btnChangeAge;
        public Button btnChangeWeight;
    }
}

