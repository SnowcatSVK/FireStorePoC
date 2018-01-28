package com.globallogic.snowcat.firestorepoc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Snowcat on 28.01.2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<UserItemViewHolder> {

    private List<User> users = null;

    public void setData(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(
                R.layout.item_list_users, parent, false
        );
        return new UserItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        holder.bindData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }
}
