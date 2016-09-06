package androidapplication.com.android_all_examples.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import androidapplication.com.android_all_examples.R;
import androidapplication.com.android_all_examples.adapter.FeedAdapter;
import androidapplication.com.android_all_examples.interfaces.DialogShowListenerr;
import androidapplication.com.android_all_examples.model.Feed;
import androidapplication.com.android_all_examples.provider.Images;

/**
 * Created by Anand on 06-09-2016.
 */
public class MyFeedImageFragment extends Fragment implements DialogShowListenerr{

    ListView listView;
    Context context;
    FeedAdapter feedAdapter;
    List<Feed> feedList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed_image, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        context=getActivity().getApplicationContext();
        listView=(ListView)view.findViewById(R.id.listView);
        feedAdapter=new FeedAdapter(context);
        feedAdapter.register(this);
        listView.setAdapter(feedAdapter);
        Feed feed;
        for (int i=0;i<20;i++)
        {
            feed = new Feed();
            feed.setTitle("Title : "+i);
            feed.setThumbImageUrl(Images.imageThumbUrls[i]);
            feed.setImageUrl(Images.imageUrls[i]);
            feedList.add(feed);
        }
        feedAdapter.updateList(feedList);
    }

    @Override
    public void showDialog(int position) {
        showChangeTitleDialog(position);
    }

    private void showChangeTitleDialog(final int position){

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.dialog_change_title, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);

        final EditText editTitle = (EditText) promptView.findViewById(R.id.editText);


        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String changedTitle = editTitle.getText().toString();
                        if (changedTitle!=null&&!changedTitle.isEmpty()){
                            feedList.get(position).setTitle(changedTitle);
                            dialog.cancel();
                            feedAdapter.updateList(feedList);
                        }else {
                            Toast.makeText(context,"Please enter text",Toast.LENGTH_SHORT).show();
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
