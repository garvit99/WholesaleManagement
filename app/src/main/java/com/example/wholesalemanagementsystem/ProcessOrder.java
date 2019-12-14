package com.example.wholesalemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProcessOrder extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_order);
        TextView bill=findViewById(R.id.bill);
        final int k=ItemAdapter.sum;
        Button bt= findViewById(R.id.btn_process);
        System.out.println(k);
        String listi= String.valueOf(ItemAdapter.list);
        bt.setText(String.valueOf(k));
        bill.setText(listi);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProcessOrder.this,PaymentActivity.class);
                intent.putExtra("total",k);
                startActivity(intent);

            }
        });



    }
}
