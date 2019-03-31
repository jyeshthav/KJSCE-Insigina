package com.android.example.kjsceinsignia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class exploreAdapter extends BaseAdapter {
    private Context context;
    public Integer[] explore_images = {R.drawable.y16, R.drawable.abhi1, R.drawable.skr1,
            R.drawable.sym1, R.drawable.ot1};

    public exploreAdapter(Context con){
        this.context = con;
    }
    @Override
    public int getCount() {
        return explore_images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, 820));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        Glide.with(context).load(explore_images[position]).into(imageView);
        return imageView;
    }
}
