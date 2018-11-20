package com.dropit.task.ui.layoutasessment.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dropit.task.ui.layoutasessment.R;
import com.dropit.task.ui.layoutasessment.models.User;
import com.dropit.task.ui.layoutasessment.util.PaginationAdapterCallback;
import com.dropit.task.ui.layoutasessment.viewtype.EvenLayout;
import com.dropit.task.ui.layoutasessment.viewtype.FiveLayout;
import com.dropit.task.ui.layoutasessment.viewtype.HeadLayout;
import com.dropit.task.ui.layoutasessment.viewtype.SingleLayout;
import com.dropit.task.ui.layoutasessment.viewtype.TripleLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suleiman on 19/10/16.
 */

public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // View Types

    private static final int HEADER = 0;
    private static final int EVEN = 2;
    private static final int LOADING = 1;
    private static final int SINGLE = 11;
    private static final int TRIPLE = 3;
    private static final int FIVE = 5;


    private List<User> userList;
    private Context context;

    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;

    private PaginationAdapterCallback mCallback;

    private String errorMsg;

    public PaginationAdapter(Context context) {
        this.context = context;
        this.mCallback = (PaginationAdapterCallback) context;
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingVH(viewLoading);
                break;

            case HEADER:
                View viewHead = inflater.inflate(R.layout.head_layout, parent, false);
                viewHolder = new HeadLayout(viewHead);
                break;

            case SINGLE:
                View viewSingle = inflater.inflate(R.layout.item_single, parent, false);
                viewHolder = new SingleLayout(viewSingle);
                break;
            case EVEN:
                View viewEven = inflater.inflate(R.layout.even_item, parent, false);
                viewHolder = new EvenLayout(viewEven);
                break;
            case TRIPLE:
                View viewTriple = inflater.inflate(R.layout.item_tripple, parent, false);
                viewHolder = new TripleLayout(viewTriple);
                break;
            case FIVE:
                View viewFive = inflater.inflate(R.layout.item_five, parent, false);
                viewHolder = new FiveLayout(viewFive);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        User user = userList.get(position);
        //Log.d("Adapter", "Peeru Call User : " + user.getName() + " : " + user.getItems().size());
        switch (getItemViewType(position)) {
            case HEADER:
                final HeadLayout headLayout = (HeadLayout) holder;
                headLayout.userNameHead.setText(user.getName());
                Glide.with(context).load(user.getImage()).into(headLayout.userImageHead);
                headLayout.urlCount.setText("" + user.getItems().size());
                break;

            case EVEN:
                final EvenLayout evenLayout = (EvenLayout) holder;
                evenLayout.userName.setText(user.getName());
                evenLayout.urlCount.setText(user.getItems().size() + "");
                Glide.with(context)
                        .load(user.getImage())
                        .into(evenLayout.userImage);

                evenLayout.gridView.setAdapter(new MyAdapter(context, user.getItems()));
                break;

            case LOADING:
                LoadingVH loadingVH = (LoadingVH) holder;

                if (retryPageLoad) {
                    loadingVH.mErrorLayout.setVisibility(View.VISIBLE);
                    loadingVH.mProgressBar.setVisibility(View.GONE);

                    loadingVH.mErrorTxt.setText(
                            errorMsg != null ?
                                    errorMsg :
                                    context.getString(R.string.error_msg_unknown));

                } else {
                    loadingVH.mErrorLayout.setVisibility(View.GONE);
                    loadingVH.mProgressBar.setVisibility(View.VISIBLE);
                }
                break;
            case SINGLE:
                final SingleLayout singleLayout = (SingleLayout) holder;
                singleLayout.userNameSingle.setText(user.getName());
                singleLayout.urlCountOddSingle.setText(user.getItems().size() + "");
                Glide.with(context).load(user.getImage()).into(singleLayout.userImageSingle);

                Glide.with(context)
                        .load(user.getItems().get(0))
                        .into(singleLayout.oddImageSingle);
                break;
            case TRIPLE:
                final TripleLayout tripleLayout = (TripleLayout) holder;
                tripleLayout.userNameTripple.setText(user.getName());
                tripleLayout.urlCountTripple.setText(user.getItems().size() + "");
                Glide.with(context).load(user.getImage()).into(tripleLayout.userImageTripple);

                Glide.with(context)
                        .load(user.getItems().get(0))
                        .into(tripleLayout.oddImageTripple);
                Glide.with(context)
                        .load(user.getItems().get(1))
                        .into(tripleLayout.triple1);
                Glide.with(context)
                        .load(user.getItems().get(2))
                        .into(tripleLayout.triple2);
                break;

            case FIVE:
                final FiveLayout fiveLayout = (FiveLayout) holder;
                fiveLayout.userNameFive.setText(user.getName());
                fiveLayout.urlCountFive.setText(user.getItems().size() + "");
                Glide.with(context).load(user.getImage()).into(fiveLayout.userImageFive);

                Glide.with(context)
                        .load(user.getItems().get(0))
                        .into(fiveLayout.oddImageFive);
                Glide.with(context)
                        .load(user.getItems().get(1))
                        .into(fiveLayout.five1);
                Glide.with(context)
                        .load(user.getItems().get(1))
                        .into(fiveLayout.five2);
                Glide.with(context)
                        .load(user.getItems().get(1))
                        .into(fiveLayout.five11);
                Glide.with(context)
                        .load(user.getItems().get(1))
                        .into(fiveLayout.five22);
                break;


        }
    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }


    @Override
    public int getItemViewType(int position) {
        //Log.d("USER","Peeru User Name "+userList.get(position).getName()+" User Count :"+userList.get(position).getItems().size());
        if (position == userList.size() - 1 && isLoadingAdded) {
            return LOADING;
        } else if (userList.get(position).getItems().size() == 0) {
            return HEADER;
        } else if (userList.get(position).getItems().size() % 2 == 0) {
            return EVEN;
        } else if (userList.get(position).getItems().size() == 1) {
            return SINGLE;
        } else if (userList.get(position).getItems().size() == 3) {
            return TRIPLE;
        } else if (userList.get(position).getItems().size() == 5) {
            return FIVE;
        } else {
            return LOADING;
        }
    }


    /*
        Helpers - Pagination
   _________________________________________________________________________________________________
    */

    public void add(User u) {
        userList.add(u);
        notifyItemInserted(userList.size() - 1);
    }

    public void addAll(List<User> userList) {
        for (User u : userList) {
            add(u);
        }
    }

    public void remove(User r) {
        int position = userList.indexOf(r);
        if (position > -1) {
            userList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new User());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = userList.size() - 1;
        User user = getItem(position);

        if (user != null) {
            userList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public User getItem(int position) {
        return userList.get(position);
    }

    /**
     * Displays Pagination retry footer view along with appropriate errorMsg
     *
     * @param show
     * @param errorMsg to display if page load fails
     */
    public void showRetry(boolean show, @Nullable String errorMsg) {
        retryPageLoad = show;
        notifyItemChanged(userList.size() - 1);

        if (errorMsg != null) this.errorMsg = errorMsg;
    }


    protected class LoadingVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ProgressBar mProgressBar;
        public ImageButton mRetryBtn;
        public TextView mErrorTxt;
        public LinearLayout mErrorLayout;

        public LoadingVH(View itemView) {
            super(itemView);

            mProgressBar = (ProgressBar) itemView.findViewById(R.id.loadmore_progress);
            mRetryBtn = (ImageButton) itemView.findViewById(R.id.loadmore_retry);
            mErrorTxt = (TextView) itemView.findViewById(R.id.loadmore_errortxt);
            mErrorLayout = (LinearLayout) itemView.findViewById(R.id.loadmore_errorlayout);

            mRetryBtn.setOnClickListener(this);
            mErrorLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.loadmore_retry:
                case R.id.loadmore_errorlayout:

                    showRetry(false, null);
                    mCallback.retryPageLoad();
                    break;
            }
        }


    }

}
