package com.dropit.task.ui.layoutasessment.viewtype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dropit.task.ui.layoutasessment.R;

public class EvenLayout extends RecyclerView.ViewHolder {
    public TextView userName;
    public TextView urlCount;
    public ImageView userImage;
    public GridView gridView;

    public EvenLayout(View itemView) {
        super(itemView);
        userImage = (ImageView) itemView.findViewById(R.id.user_image);
        userName = (TextView) itemView.findViewById(R.id.user_name);
        urlCount = (TextView) itemView.findViewById(R.id.url_count);
        gridView = (GridView) itemView.findViewById(R.id.gridview);
    }
}
