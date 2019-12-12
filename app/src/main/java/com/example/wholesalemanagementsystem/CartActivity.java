package com.example.wholesalemanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Button btn_placeorder=(Button)findViewById(R.id.btn_placeorder);
        TextView tv_total=(TextView)findViewById(R.id.tv_total);

        Item[] myListData = new Item[] {
                new Item("Product A",R.drawable.a,10,0),
                new Item("Product B",R.drawable.b,20,0),
                new Item("Product C",R.drawable.c,30,0),
                new Item("Product D",R.drawable.d,40,0),
                new Item("Product E",R.drawable.e,50,0),
                new Item("Product A",R.drawable.a,10,0),
                new Item("Product B",R.drawable.b,20,0),
                new Item("Product C",R.drawable.c,30,0),
                new Item("Product D",R.drawable.d,40,0),
                new Item("Product E",R.drawable.e,50,0),
        };





        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_cart);
        final ItemAdapter adapter = new ItemAdapter(myListData);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }



}