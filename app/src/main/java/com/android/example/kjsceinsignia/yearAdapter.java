package com.android.example.kjsceinsignia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class yearAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] images = { R.drawable.s1, R.drawable.s2, R.drawable.s3};

    public yearAdapter(Context c) {
        this.mContext = c;
    }

    public int getCount() {
        return images.length;
    }

//    returns object from adapter
    public Object getItem(int position) {
        return null;
    }

//    returns row number of image
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
//    convertView is the existing view for the image IF ANY
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, 370));
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            ;
        } else {
            imageView = (ImageView) convertView;
        }

        Glide.with(mContext).load(images[position]).into(imageView);
//        imageView.setImageResource(images[position]);
        return imageView;
    }

    // references to our images

}