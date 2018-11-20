package com.dropit.task.ui.layoutasessment.viewtype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dropit.task.ui.layoutasessment.R;

public class SingleLayout extends RecyclerView.ViewHolder {
    public TextView userNameSingle;
    public ImageView userImageSingle;
    public ImageView oddImageSingle;
    public TextView urlCountOddSingle;

    public SingleLayout(View itemView) {
        super(itemView);
        userImageSingle = (ImageView) itemView.findViewById(R.id.user_image_single);
        userNameSingle = (TextView) itemView.findViewById(R.id.user_name_single);
        oddImageSingle = (ImageView) itemView.findViewById(R.id.odd_picture_single);
        urlCountOddSingle = (TextView) itemView.findViewById(R.id.url_count_single);
    }
}
