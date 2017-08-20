package com.bagicode.www.chatku._adapter;

/**
 * Created by robbydianputra on 4/17/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bagicode.www.chatku.R;
import com.bagicode.www.chatku._model.item_user;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<item_user> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView icons;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.labelText);
            icons = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    public UserAdapter(List<item_user> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        item_user itemproduct = moviesList.get(position);
        holder.title.setText(itemproduct.getTitle());
        holder.icons.setImageResource(itemproduct.getIcons());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}