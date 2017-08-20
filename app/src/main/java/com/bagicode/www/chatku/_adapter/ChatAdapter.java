package com.bagicode.www.chatku._adapter;

/**
 * Created by robbydianputra on 4/17/17.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bagicode.www.chatku.R;
import com.bagicode.www.chatku._model.item_chat;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private List<item_chat> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, createby;
        public TextView title2, createby2;
        public RelativeLayout penerima, pengirim;
        public CardView chat;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txtJudul);
            createby = (TextView) view.findViewById(R.id.subJudul);

            title2 = (TextView) view.findViewById(R.id.txtJudul2);
            createby2 = (TextView) view.findViewById(R.id.subJudul2);

            penerima = (RelativeLayout) view.findViewById(R.id.penerima);
            pengirim = (RelativeLayout) view.findViewById(R.id.pengirim);

            chat = (CardView) view.findViewById(R.id.chat);
        }
    }

    public ChatAdapter(List<item_chat> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        item_chat itemproduct = moviesList.get(position);

        String statusChat = itemproduct.getId_kategori();
        if (statusChat.equals("1")) {
            holder.penerima.setVisibility(View.GONE);
            holder.pengirim.setVisibility(View.VISIBLE);
            holder.title.setText(itemproduct.getTitle());
            holder.createby.setText(itemproduct.getCreateBy());
        } else {
            holder.pengirim.setVisibility(View.GONE);
            holder.penerima.setVisibility(View.VISIBLE);
            holder.title2.setText(itemproduct.getTitle());
            holder.createby2.setText(itemproduct.getCreateBy());

        }

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}