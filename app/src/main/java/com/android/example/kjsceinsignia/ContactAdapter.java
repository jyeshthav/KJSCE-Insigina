package com.android.example.kjsceinsignia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    Context mContext;
    int resource;
    List<Contact> contactList;

    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.resource = resource;
        this.contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
        }

        Contact conItem = contactList.get(position);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView con = (TextView) convertView.findViewById(R.id.contact);
        name.setText(conItem.getName());
        con.setText(conItem.getPhoneNumber());

        return convertView;

    }

}

