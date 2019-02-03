package com.android.example.kjsceinsignia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class yearAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] images = { R.drawable.s1, R.drawable.s2, R.drawable.s3};
    private final String[] gridViewString = {"16-17", "17-18", "18-19", "19-20"};

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
//        ImageView imageView;
//        if (convertView == null) {
//            // if it's not recycled, initialize some attributes
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, 370));
////            imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
//            ;
//        } else {
//            imageView = (ImageView) convertView;
//        }
//
//        Glide.with(mContext).load(images[position]).into(imageView);

        View gridView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridView = new View(mContext);
            gridView = inflater.inflate(R.layout.year_grid, null);
            TextView textViewAndroid = (TextView) gridView.findViewById(R.id.gridview_text);
            ImageView imageViewAndroid = (ImageView) gridView.findViewById(R.id.gridview_image);
            textViewAndroid.setText(gridViewString[position]);
            Glide.with(imageViewAndroid.getContext()).load(images[position]).into(imageViewAndroid);
        } else {
            gridView = (View) convertView;
        }
//        imageView.setImageResource(images[position]);
        return gridView;
    }

    // references to our images

}