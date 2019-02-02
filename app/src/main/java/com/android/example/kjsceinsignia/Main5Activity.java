package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
    private List<cardEvents> listItems;
    private int card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
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
        listItems = new ArrayList<>();

        cardEvents listItem1 = new cardEvents("Freshers " + (16+i), i, i);
        listItems.add(listItem1);

        cardEvents listItem2 = new cardEvents("Abhiyantriki " + (16+i), i, i);
        listItems.add(listItem2);

        cardEvents listItem3 = new cardEvents("Skream " + (17+i), i, i);
        listItems.add(listItem3);

        cardEvents listItem4 = new cardEvents("Symphony " + (17+i), i, i);
        listItems.add(listItem4);

        cardEvents listItem5 = new cardEvents("Other projects " + (17+i), i, i);
        listItems.add(listItem5);

//        mAdapter.notifyDataSetChanged();

        // specify an adapter (see also next example)
        mAdapter = new cardAdapter(this, listItems);
        mRecyclerView.setAdapter(mAdapter);


    }
    public void openGallery(View v){
        TextView tv = v.findViewById(R.id.info_text);
        String item = tv.getText().toString();
        int card_no = Integer.parseInt(item.substring(item.length() - 1));
        card = this.listItems.get(card_no).getCard();
        Intent i  = new Intent(this, Main4Activity.class);
        i.putExtra("event", card);
        startActivity(i);
    }
}
