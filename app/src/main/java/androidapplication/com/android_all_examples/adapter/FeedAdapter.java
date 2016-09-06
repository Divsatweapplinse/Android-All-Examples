package androidapplication.com.android_all_examples.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.activities.ImageFeedDetailActivity;
import androidapplication.com.android_all_examples.interfaces.DialogShowListener;
import androidapplication.com.android_all_examples.interfaces.DialogShowListenerr;
import androidapplication.com.android_all_examples.model.Feed;
import androidapplication.com.android_all_examples.utils.AppConstant;

/**
 * Created by Anand on 06-09-2016.
 */
public class FeedAdapter extends BaseAdapter {
    private final static String TAG = FeedAdapter.class.getSimpleName();
    private Context context;
    private List<Feed> list = new ArrayList<>();
    private DialogShowListenerr dialogShowListener;

    public FeedAdapter(Context context) {
        this.context = context;
    }

    public void register(DialogShowListenerr dialogShowListener){
        this.dialogShowListener = dialogShowListener;
    }

    public void updateList(List<Feed> feedList) {
        this.list = feedList;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_feed_image, parent, false);
            holder = new ViewHolder();
            holder.textViewTitle = (TextView)convertView.findViewById(R.id.textViewTitle);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.btnChangeTitle = (Button) convertView.findViewById(R.id.btnChangeTitle);
            convertView.setTag(holder);

        }else {
            holder=(ViewHolder) convertView.getTag();
        }

        holder.textViewTitle.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getThumbImageUrl()).into(holder.imageView);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Position : "+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ImageFeedDetailActivity.class);
                intent.putExtra(AppConstant.IMAGE_URL,list.get(position).getImageUrl());
                intent.putExtra(AppConstant.FEED_TITLE,list.get(position).getTitle());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.btnChangeTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShowListener.showDialog(position);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView textViewTitle;
        ImageView imageView;
        Button btnChangeTitle;
    }


}
