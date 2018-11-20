package com.dropit.task.ui.layoutasessment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dropit.task.ui.layoutasessment.R;

import java.util.ArrayList;
import java.util.List;

public final class MyAdapter extends BaseAdapter {
    private List<String> imageUrlList = new ArrayList<String>();
    private final LayoutInflater mInflater;
    Context context;

    public MyAdapter(Context context, List<String> urlList) {
        this.context = context;

        imageUrlList = urlList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageUrlList.size();
    }

    @Override
    public String getItem(int i) {
        return imageUrlList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        ImageView picture;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));

        }
        String url = getItem(i);
        picture = (ImageView) v.getTag(R.id.picture);
        Glide.with(context)
                .load(url)
                .into(picture);


        return v;
    }


}