package com.example.esraabalbaa.graduationproject;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shiko on 26/04/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    ArrayList<CartRecycler> adapterlist  = new ArrayList<>();
    CartActivity cartactivity;
    Context cnx;
    public CartAdapter(ArrayList<CartRecycler> adapterlist,Context cnx){
        this.adapterlist =adapterlist;
        this.cnx =cnx;
        cartactivity = (CartActivity) cnx;
    }
    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_cards,parent,false);
       CartViewHolder cartviewholder = new CartViewHolder(v,cartactivity);

        return cartviewholder;
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
// SET DATA FOR IMAGE AND TEXT
        holder.image.setImageResource(adapterlist.get(position).getImages_id());
        holder.name.setText(adapterlist.get(position).getProductname());
        holder.price.setText(adapterlist.get(position).getProductprice());
        holder.quantity.setText(adapterlist.get(position).getProductquantity());
   if(!cartactivity.edit_mode){
       holder.checkornot.setVisibility(View.GONE);
   }
   else {
       holder.checkornot.setVisibility(View.VISIBLE);
       holder.checkornot.setChecked(false);

   }
    }


    @Override
    public int getItemCount() {
        return adapterlist.size();
    }



    public static class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
ImageView image;
    TextView price,quantity,name;
    CheckBox checkornot;
    CartActivity cartactivity;
    CardView cardv;
    public CartViewHolder(View itemView, CartActivity cartactivity) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.cartimage);
        name = (TextView) itemView.findViewById(R.id.pn);
        price = (TextView) itemView.findViewById(R.id.p);
        quantity = (TextView) itemView.findViewById(R.id.q);
        checkornot = (CheckBox) itemView.findViewById(R.id.ckbox);
        this.cartactivity= cartactivity;
        cardv = (CardView) itemView.findViewById(R.id.cardd);
        cardv.setOnLongClickListener(cartactivity);
        checkornot.setOnClickListener(this);
    }
        @Override
        public void onClick(View view) {
cartactivity.prepareselection(view,getAdapterPosition());
        }
}
public void updateadapter(ArrayList<CartRecycler> list){
    for(CartRecycler cartRecycler:list){
        adapterlist.remove(cartRecycler);
    }
notifyDataSetChanged();
}
}
