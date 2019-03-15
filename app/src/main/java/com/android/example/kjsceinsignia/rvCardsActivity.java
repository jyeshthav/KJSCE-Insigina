package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class rvCardsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
    private List<cardEvents> listItems;
    private int index;
    private int event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_cards);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        int year = intent.getIntExtra("year", 0);
        int i = year;
        int j;
        switch(i){
            case 0:
                j = 0;
                break;
            case 1:
                j = 5;
                break;
            case 2:
                j = 10;
                break;
            default:
                j = 0;
                break;
        }
        listItems = new ArrayList<>();

        cardEvents listItem1 = new cardEvents("Freshers " + (16+i), j, i, i);
        listItems.add(listItem1);

        cardEvents listItem2 = new cardEvents("Abhiyantriki " + (16+i), (j+1), i, (i+1));
        listItems.add(listItem2);

        cardEvents listItem3 = new cardEvents("Skream " + (17+i), (j+2), i, (i+2));
        listItems.add(listItem3);

        cardEvents listItem4 = new cardEvents("Symphony " + (17+i), (j+3), i, (i+3));
        listItems.add(listItem4);

        cardEvents listItem5 = new cardEvents("Other projects " + (17+i), (j+4), i, (i+4));
        listItems.add(listItem5);

        mAdapter = new cardAdapter(this, listItems);
        mRecyclerView.setAdapter(mAdapter);


    }
    public void openGallery(View v){
        TextView tv1 = v.findViewById(R.id.info_text2);
        TextView tv2 = v.findViewById(R.id.info_text3);
        String s1 = tv1.getText().toString();
        String s2 = tv2.getText().toString();
        int t1 = Integer.parseInt(s1);
        int t2 = Integer.parseInt(s2);
        index = t1;
        event = t2 - t1;
        Intent i  = new Intent(this, imageGridActivity.class);
        i.putExtra("index", index);
        i.putExtra("event", event);
        startActivity(i);
    }
}
