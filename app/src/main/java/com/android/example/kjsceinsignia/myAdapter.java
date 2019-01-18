package com.android.example.kjsceinsignia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {
    private List<recyclerItems> listItems;
    private Context mContext;

    public myAdapter(List<recyclerItems> listItems) {this.listItems = listItems;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
//    shows actual data to recycler
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
//      creates instance of class
        public TextView TextView1;
//        public ImageView image;
//        public TextView TextView2;
        public MyViewHolder(View v) {
            super(v);
            TextView1 = (TextView) v.findViewById(R.id.info_text);
//            image = v.findViewById(R.id.photo);
//            TextView2 = (TextView) v.findViewById(R.id.textView2);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public myAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_items, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
//    binds data to viewholder
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        recyclerItems listItem = listItems.get(position);
        holder.TextView1.setText(listItem.getItem1());
//        holder.TextView2.setText(listItem.getItem2());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
