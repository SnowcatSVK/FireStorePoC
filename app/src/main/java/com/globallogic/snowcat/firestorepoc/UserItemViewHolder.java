package com.globallogic.snowcat.firestorepoc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by snowcat on 26.1.2018.
 */

public class UserItemViewHolder extends RecyclerView.ViewHolder {

    private TextView tvUserName;

    public UserItemViewHolder(View itemView) {
        super(itemView);
        itemView.findViewById(R.id.tv_user_name);
    }

    public void bindData(User user) {
        tvUserName.setText(user.getFirstName() + " " + user.getLastName());
    }
}
