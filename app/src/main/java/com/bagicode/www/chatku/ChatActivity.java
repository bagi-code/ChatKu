package com.bagicode.www.chatku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bagicode.www.chatku._adapter.ChatAdapter;
import com.bagicode.www.chatku._adapter.RecyclerTouchListener;
import com.bagicode.www.chatku._model.item_chat;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private List<item_chat> itemproductList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChatAdapter mAdapter;

    private boolean status;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        getSupportActionBar().setTitle("Chat Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ChatAdapter(itemproductList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();
    }

        private void prepareMovieData() {

        item_chat itemproduct = new item_chat(true,"","Robby", "Hello gan lagi ngapain?", "1");
        itemproductList.add(itemproduct);

        itemproduct = new item_chat(true,"","Putra", "Lagi tiduran aja gan, situ lagi ngapain?", "0");
        itemproductList.add(itemproduct);

        itemproduct = new item_chat(true,"","Robby", "Oh, biasa gan lagi ngedota", "1");
        itemproductList.add(itemproduct);

        mAdapter.notifyDataSetChanged();
    }
}
