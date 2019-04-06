package com.android.example.kjsceinsignia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class contactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

//        creates database
        final DBHandler db = new DBHandler(this);

        Button add = (Button) findViewById(R.id.add);
        Button edit = (Button) findViewById(R.id.edit);
        Button delete = (Button) findViewById(R.id.delete);
        Button view = (Button) findViewById(R.id.view);
        final EditText etname = (EditText) findViewById(R.id.edittext1);
        final EditText etcon = (EditText) findViewById(R.id.edittext2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etname.getText().toString();
                String con = etcon.getText().toString();
                db.addContact(new Contact(name, con));
            }
        });

        // Reading all contacts
        List<Contact> contacts = db.getAllContacts();
        ListView listView = findViewById(R.id.lv_Contacts);
        listView.setAdapter(new ContactAdapter(this, R.layout.contact, contacts));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etname.getText().toString();
                String con = etcon.getText().toString();
                db.updateContact(new Contact(name, con));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etname.getText().toString();
                String con = etcon.getText().toString();
                db.deleteContact(new Contact(name, con));
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> contacts = db.getAllContacts();
                ListView listView = findViewById(R.id.lv_Contacts);
                listView.setAdapter(new ContactAdapter(getApplicationContext(), R.layout.contact, contacts));
            }
        });

    }
}