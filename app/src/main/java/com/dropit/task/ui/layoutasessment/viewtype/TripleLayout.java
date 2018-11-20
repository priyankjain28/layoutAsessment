package com.dropit.task.ui.layoutasessment.viewtype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dropit.task.ui.layoutasessment.R;

public class TripleLayout extends RecyclerView.ViewHolder {
    public TextView userNameTripple;
    public ImageView userImageTripple;
    public ImageView oddImageTripple;
    public TextView urlCountTripple;
    public ImageView triple1;
    public ImageView triple2;


    public TextView urlCountOdd;

    public TripleLayout(View itemView) {
        super(itemView);
        userImageTripple = (ImageView) itemView.findViewById(R.id.user_image_tripple);
        userNameTripple = (TextView) itemView.findViewById(R.id.user_name_tripple);
        oddImageTripple = (ImageView) itemView.findViewById(R.id.odd_picture_tripple);
        urlCountTripple = (TextView) itemView.findViewById(R.id.url_count_tripple);
        triple1 = (ImageView) itemView.findViewById(R.id.triple_1);
        triple2 = (ImageView) itemView.findViewById(R.id.triple_2);
    }
}
