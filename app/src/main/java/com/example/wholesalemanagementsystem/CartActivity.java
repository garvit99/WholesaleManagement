package com.example.wholesalemanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Button btn_placeorder=findViewById(R.id.btn_placeorder);



        Item[] myListData = new Item[] {
                new Item("Vaseline(12 Packs)",R.drawable.bodylotion,1400,0),
                new Item("Frooti(120 Packs)",R.drawable.frooti,1050,0),
                new Item("Parachute Hair Oil(30 Packs)",R.drawable.hairoil,1500,0),
                new Item("Kurkure(50 Packs)",R.drawable.kurkure,900,0),
                new Item("Lays(50 Packs)",R.drawable.lays,900,0),
                new Item("Maggi(50 Packs)",R.drawable.maggi,1200,0),
                new Item("Apsara HB pencil(50 Box)",R.drawable.pencil,1200,0),
                new Item("Haldiram Sev(30 Packs)",R.drawable.sev,2600,0),
                new Item("Dettol Soap(50 Packs)",R.drawable.soap,1400,0),
                new Item("Colgate(80 Packs)",R.drawable.toothpaste,2300,0),
        };





        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_cart);
        final ItemAdapter adapter = new ItemAdapter(myListData);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

      btn_placeorder.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent= new Intent(CartActivity.this,ProcessOrder.class);
              startActivity(intent);
              int k=ItemAdapter.sum;
              System.out.println(k);
              String listi= String.valueOf(ItemAdapter.list);

          }
      });

    }



    }






