package com.dropit.task.ui.layoutasessment.viewtype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dropit.task.ui.layoutasessment.R;

public class FiveLayout extends RecyclerView.ViewHolder {
    public TextView userNameFive;
    public ImageView userImageFive;
    public ImageView oddImageFive;
    public TextView urlCountFive;
    public ImageView five1;
    public ImageView five2;
    public ImageView five11;
    public ImageView five22;

    public TextView urlCountOdd;

    public FiveLayout(View itemView) {
        super(itemView);
        userImageFive = (ImageView) itemView.findViewById(R.id.user_image_five);
        userNameFive = (TextView) itemView.findViewById(R.id.user_name_five);
        oddImageFive = (ImageView) itemView.findViewById(R.id.odd_picture_five);
        urlCountFive = (TextView) itemView.findViewById(R.id.url_count_five);
        five1 = (ImageView) itemView.findViewById(R.id.five_1);
        five2 = (ImageView) itemView.findViewById(R.id.five_2);
        five11 = (ImageView) itemView.findViewById(R.id.five_11);
        five22 = (ImageView) itemView.findViewById(R.id.five_22);
    }
}
