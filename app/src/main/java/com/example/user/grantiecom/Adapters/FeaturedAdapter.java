package com.example.user.grantiecom.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.grantiecom.Models.FeaturedItem;
import com.example.user.grantiecom.R;

import java.util.ArrayList;


public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.MyViewHolder> {
    private ArrayList<FeaturedItem> featuredItems;
    private Context context;

    public FeaturedAdapter(ArrayList<FeaturedItem> featuredItems, Context context) {
        this.featuredItems = featuredItems;
        this.context = context;
    }

    @Override
    public FeaturedAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_post_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeaturedAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView UserImg;
        public TextView postTitle,postOwner;
        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
