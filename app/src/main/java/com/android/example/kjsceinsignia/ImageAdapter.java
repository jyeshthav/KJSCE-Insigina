package com.android.example.kjsceinsignia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int card;
    private Integer[] images;
    private Integer[] images1 = { R.drawable.s1, R.drawable.s2, R.drawable.s3};
    private Integer[] images2 = {R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7};
    private Integer[] images3 = {R.drawable.s8, R.drawable.s9, R.drawable.s10, R.drawable.s11};
    private Integer[] images4 = {R.drawable.s12, R.drawable.s13, R.drawable.s14, R.drawable.s15};

    public ImageAdapter(Context c, int card) {
        this.mContext = c;
        this.card = card;
        setCard(card);
    }

    public Integer[] setCard(int card){
        if (card == 0){
            images = images1;
        }
        else if (card == 1){
            images = images2;
        }
        else if (card == 2){
            images = images3;
        }
        else if (card == 3){
            images = images4;
        }
        else{
            images = images1;
        }
        return images;
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
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, 120));
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