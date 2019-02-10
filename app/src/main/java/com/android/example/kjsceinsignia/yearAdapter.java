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
        View gridView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridView = new View(mContext);
            gridView = inflater.inflate(R.layout.year_grid, null);
            TextView textView = (TextView) gridView.findViewById(R.id.gridview_text);
            ImageView imageView = (ImageView) gridView.findViewById(R.id.gridview_image);
            textView.setText(gridViewString[position]);
            Glide.with(imageView.getContext()).load(images[position]).into(imageView);
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }

    // references to our images

}