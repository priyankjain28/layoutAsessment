package com.dropit.task.ui.layoutasessment.viewtype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dropit.task.ui.layoutasessment.R;

public class HeadLayout extends RecyclerView.ViewHolder {
    public TextView userNameHead;
    public ImageView userImageHead;
    public TextView urlCount;

    public HeadLayout(View itemView) {
        super(itemView);
        userImageHead = (ImageView) itemView.findViewById(R.id.user_image_head);
        userNameHead = (TextView) itemView.findViewById(R.id.user_name_head);
        urlCount = (TextView) itemView.findViewById(R.id.url_count_head);
    }
}
