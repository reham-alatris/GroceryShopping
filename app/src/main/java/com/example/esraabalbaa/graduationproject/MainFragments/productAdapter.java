package com.example.esraabalbaa.graduationproject.MainFragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.esraabalbaa.graduationproject.R;

import java.util.List;

/**
 * Created by reham moamed on 10/04/2017.
 */


public class productAdapter extends RecyclerView.Adapter<productAdapter.MyViewHolder> {

    private Context mContext;
    private List<product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
//
        }
    }


    public productAdapter(Context mContext, List<product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        product p = productList.get(position);
        holder.title.setText(p.getName());
        holder.count.setText(p.getPrice() + "L.E");

        // loading album cover using Glide library
        Glide.with(mContext).load(p.getThumbnail()).into(holder.thumbnail);
    }


    public int getItemCount() {

        return productList.size();
    }

}


