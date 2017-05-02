package com.example.esraabalbaa.graduationproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements View.OnLongClickListener{
    Button l;
    ImageView imv;
    Toolbar t;
    RecyclerView rv;
    RecyclerView.LayoutManager layoutmanager;
    RecyclerView.Adapter adapter;
    int[] image_id = {R.drawable.milk,R.drawable.honey,R.drawable.afia,R.drawable.shampoo};
    ArrayList<CartRecycler> cartitems = new ArrayList<>();
    ArrayList<CartRecycler> selected_items_list = new ArrayList<>();
    int countt =0;
boolean edit_mode =false;
    TextView counterr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
         t = (Toolbar) findViewById(R.id.toolb);

        imv = (ImageView) findViewById(R.id.gotoback);
        imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        l = (Button) findViewById(R.id.checkoutsummary);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(CartActivity.this,SummaryActivity.class);
                startActivity(n);
            }
        });
        rv = (RecyclerView) findViewById(R.id.mycartrecycler);
        layoutmanager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutmanager);
        rv.setHasFixedSize(true);

        String[] name,price,quantity;
        name = getResources().getStringArray(R.array.productname);
        price = getResources().getStringArray(R.array.productprice);
        quantity = getResources().getStringArray(R.array.productquantity);
        int i = 0;
        for(String NAME : name){
            CartRecycler cart = new CartRecycler(image_id[i],NAME,price[i],quantity[i]);
            cartitems.add(cart);
            i++;
        }
        adapter = new CartAdapter(cartitems,CartActivity.this);
        rv.setAdapter(adapter);

        counterr = (TextView) findViewById(R.id.selecteditemcounter);
        counterr.setVisibility(View.GONE);
    }

    @Override
    public boolean onLongClick(View view) {
      t.getMenu().clear();
        t.inflateMenu(R.menu.cart_edit_mode);
        counterr.setVisibility(View.VISIBLE);
        edit_mode = true;
        adapter.notifyDataSetChanged();
        //to back button
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }
    public void prepareselection(View view,int position){
//put elected items in array list
        if(((CheckBox)view).isChecked()){
            selected_items_list.add(cartitems.get(position));
            countt = countt+1;
            updatecounter(countt);
        }
        else {
            selected_items_list.remove(cartitems.get(position));
            countt = countt -1;
            updatecounter(countt);
        }

    }
    public void updatecounter(int counter){
        if(counter==0){
            counterr.setText("0 items selected");
        }
        else {
            counterr.setText(counter+" item selected");
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.item_delete){
            CartAdapter cartAdapter = (CartAdapter) adapter;
            cartAdapter.updateadapter(selected_items_list);

     }

        else if(item.getItemId()== android.R.id.home)
        {
            adapter.notifyDataSetChanged();
        }
        return true;
    }
}
