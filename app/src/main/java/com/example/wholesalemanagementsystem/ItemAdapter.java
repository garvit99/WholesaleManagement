package com.example.wholesalemanagementsystem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Dictionary;
import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    public static Item[] listdata;
    //public static List<Item> selecteditems;

    // RecyclerView recyclerView;
    public ItemAdapter(Item[] listdata) {
        this.listdata = listdata;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Item myListData = listdata[position];



        holder.name.setText(listdata[position].getName());
        holder.image.setImageResource(listdata[position].getImgId());
        holder.price.setText(listdata[position].getPrice()+"");
        holder.quantity.setText(listdata[position].getQuantity()+"");
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //total+=listdata[position].getPrice()*listdata[position].getQuantity();
                Toast.makeText(view.getContext(),"click on item: "+listdata[position].getQuantity(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name,price;
        public EditText quantity;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.image);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.quantity = (EditText) itemView.findViewById(R.id.quantity);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}