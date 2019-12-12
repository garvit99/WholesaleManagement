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
public static int sum=0;
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Item myListData = listdata[position];

        holder.name.setText(listdata[position].getName());
        holder.image.setImageResource(listdata[position].getImgId());
        holder.price.setText(listdata[position].getPrice()+"");
        holder.quantity.setText(listdata[position].getQuantity()+"");



        holder.relativeLayout.findViewById(R.id.quantity).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

        if(!hasFocus) {
            EditText ed = holder.relativeLayout.findViewById(R.id.quantity);
            TextView pr=holder.relativeLayout.findViewById(R.id.price);
            sum+=Integer.parseInt(ed.getText().toString())*Integer.parseInt(pr.getText().toString());

            Toast.makeText(v.getContext(), "Total price: "+sum, Toast.LENGTH_SHORT).show();

        }
            }
        });
/*        holder.relativeLayout.findViewById(R.id.quantity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //total+=listdata[position].getPrice()*listdata[position].getQuantity();
             //   Toast.makeText(view.getContext(),"click on item: "+holder.relativeLayout.findViewById(R.id.quantity).toString(),Toast.LENGTH_LONG).show();
                EditText ed=holder.relativeLayout.findViewById(R.id.quantity);
                Toast.makeText(view.getContext(), ed.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
  */  }


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