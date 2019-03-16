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
    private int year;
    private int event;
    private Integer[] images;
//    private Integer[] images00 = {R.drawable.s1};       //freshers 16
//    private Integer[] images01 = {R.drawable.s4};       //abhiyantriki 16
//    private Integer[] images02 = {R.drawable.s7};       //skream 17
//    private Integer[] images03 = {R.drawable.s10};      //symphony 17
//    private Integer[] images04 = {R.drawable.s13};      //others 17
//
//    private Integer[] images10 = {R.drawable.s2};       //freshers 17
//    private Integer[] images11 = {R.drawable.s5};       //abhiyantriki 17
//    private Integer[] images12 = {R.drawable.s8};       //skream 18
//    private Integer[] images13 = {R.drawable.s11};      //symphony 18
//    private Integer[] images14 = {R.drawable.s14};      //others 18
//
//    private Integer[] images20 = {R.drawable.s3};       //freshers 18
//    private Integer[] images21 = {R.drawable.s6};       //abhiyantriki 18
//    private Integer[] images22 = {R.drawable.s9};       //skream 19
//    private Integer[] images23 = {R.drawable.s12};      //symphony 19
//    private Integer[] images24 = {R.drawable.s15};      //others 19

    public Integer[] explore_images = {R.drawable.fre1, R.drawable.abhi1, R.drawable.skr1,
            R.drawable.sym1, R.drawable.ot1 };

//    public ImageAdapter(Context c, int year, int event) {
//        this.mContext = c;
//        this.year = year;
//        this.event = event;
//        this.images = setCard(year, event);
//    }

    public ImageAdapter(Context c) {
        this.mContext = c;
    }

//    public Integer[] setCard(int year, int event){
//        switch (event){
//            case 0:
//                if (year == 0){
//                    images = images00;
//                }
//                else if(year == 1){
//                    images = images10;
//                }
//                else if(year == 2){
//                    images = images20;
//                }
//                else {
//                    images = images00;
//                }
//                break;
//            case 1:
//                if (year == 0){
//                    images = images01;
//                }
//                else if(year == 1){
//                    images = images11;
//                }
//                else if(year == 2){
//                    images = images21;
//                }
//                else {
//                    images = images01;
//                }
//                break;
//            case 2:
//                if (year == 0){
//                    images = images02;
//                }
//                else if(year == 1){
//                    images = images12;
//                }
//                else if(year == 2){
//                    images = images22;
//                }
//                else {
//                    images = images02;
//                }
//                break;
//            case 3:
//                if (year == 0){
//                    images = images03;
//                }
//                else if(year == 1){
//                    images = images13;
//                }
//                else if(year == 2){
//                    images = images23;
//                }
//                else {
//                    images = images03;
//                }
//                break;
//            case 4:
//                if (year == 0){
//                    images = images04;
//                }
//                else if(year == 1){
//                    images = images14;
//                }
//                else if(year == 2){
//                    images = images24;
//                }
//                else {
//                    images = images04;
//                }
//                break;
//            default:
//                images = images00;
//                break;
//        }
//        return images;
//    }

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

}