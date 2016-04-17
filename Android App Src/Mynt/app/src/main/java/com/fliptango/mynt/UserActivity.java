package com.fliptango.mynt;

import android.content.Context;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fliptango.mynt.tindercard.FlingCardListener;
import com.fliptango.mynt.tindercard.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;


public class UserActivity extends AppCompatActivity implements FlingCardListener.ActionDownInterface {

    //int formals=0, casuals=0, shoes=0, sandals=0, shirts=0, jeans=0;
    int x=0, y=1;
    static int i=0;
    int k=1;
    public static MyAppAdapter myAppAdapter;
    public static ViewHolder viewHolder;
    private ArrayList<Data> al;
    private List<Integer> data;
    private SwipeFlingAdapterView flingContainer;

    public static void removeBackground() {


        ViewHolder.background.setVisibility(View.GONE);
        myAppAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


            flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

            data = new ArrayList<>();
            al = new ArrayList<>();
            al.add(new Data("http://www.manningcompany.com/blog/wp-content/uploads/2015/09/formal-suit-for-men.jpg", "Is FORMALS what u love?\n\n swipe right for 'yes' swipe left for 'no'."));
            al.add(new Data("http://nationtrendz.com/wp-content/uploads/2014/08/casual-dress-designs-for-men-4.jpg", "Are you interested in CASUALS?\n\n swipe right for 'yes' swipe left for 'no'."));
            al.add(new Data("http://www.partyrockclothing.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/p/a/party-rock-shoes-women-stacked_web.jpg", "Is SHOES your thing?\n\n swipe right for 'yes' swipe left for 'no'."));
            al.add(new Data("http://g02.a.alicdn.com/kf/HTB11Nn8KpXXXXb3XVXXq6xXFXXXe/r-Fashion-font-b-men-s-b-font-font-b-sandals-b-font-casual-summer-font.jpg", "Is Sandals something that you love?\n\n swipe right for 'yes' swipe left for 'no'."));
            al.add(new Data("https://cdn.propercloth.com/images/home2/shirt-stack2.jpg", "Are you interested in awesome SHIRTS?\n\n swipe left for 'yes' swipe right for 'no'."));
            al.add(new Data("http://d2pnn7clgn6qxc.cloudfront.net/assets/slider/washed-jeans-stack-ba914286bd29f71f44a879705faefd3e.jpg", "Are you interested in awesome JEANS?\n\n swipe left for 'yes' swipe right for 'no'."));


            myAppAdapter = new MyAppAdapter(al, UserActivity.this);
            flingContainer.setAdapter(myAppAdapter);
            flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {


                @Override
                public void removeFirstObjectInAdapter() {

                }

                @Override
                public void onLeftCardExit(Object dataObject) {
                    al.remove(0);
                    data.add(i, x);
                    myAppAdapter.notifyDataSetChanged();
                    //Do something on the left!
                    //You also have access to the original object.
                    //If you want to use it just cast it (String) dataObject
                    Log.d("Myapp", String.valueOf(data.get(i)));
                    i = i + 1;

                }

                @Override
                public void onRightCardExit(Object dataObject) {
                    al.remove(0);
                    myAppAdapter.notifyDataSetChanged();
                    data.add(i, y);
                    Log.d("Myapp", String.valueOf(data.get(i)));
                    i = i + 1;

                }

                @Override
                public void onAdapterAboutToEmpty(int itemsInAdapter) {

                }


                @Override
                public void onScroll(float scrollProgressPercent) {

                    View view = flingContainer.getSelectedView();
                    view.findViewById(R.id.background).setAlpha(0);
                    view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                    view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
                }

            });



        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                myAppAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onActionDownPerform() {
        Log.e("action", "bingo");
    }

    public static class ViewHolder {
        public static FrameLayout background;
        public TextView DataText;
        public ImageView cardImage;


    }


    public class MyAppAdapter extends BaseAdapter {


        public List<Data> parkingList;
        public Context context;

        private MyAppAdapter(List<Data> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;


            if (rowView == null) {

                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.item, parent, false);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.DataText = (TextView) rowView.findViewById(R.id.bookText);
                ViewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.cardImage);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.DataText.setText(parkingList.get(position).getDescription() + "");

            Glide.with(UserActivity.this).load(parkingList.get(position).getImagePath()).into(viewHolder.cardImage);

            return rowView;
        }


    }


}
