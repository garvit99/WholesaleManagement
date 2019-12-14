package com.example.wholesalemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class ProcessOrder extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_order);
        TextView bill=findViewById(R.id.bill);
         int k = 0;
        ArrayList<String> mobileArray= new ArrayList<String>();
        Button bt= findViewById(R.id.btn_process);
        String listi;
        int temp=0;
        String ti="";
        Enumeration j=ItemAdapter.dictionary.keys();
        for (Enumeration i = ItemAdapter.dictionary.elements(); i.hasMoreElements();)
        {   temp= (int) i.nextElement();
        ti=j.nextElement().toString();
        if(temp!=0) {
            listi = ti + temp;

            mobileArray.add(listi);
        }
            k+=temp;
            j.hasMoreElements();
//            ItemAdapter.dictionary.remove(listi);

        }

        String himanshu[]=new String[Integer.parseInt(String.valueOf(mobileArray.size()))];

for(int i=0;i<mobileArray.size();i++)
{
    himanshu[i]=String.valueOf(mobileArray.get(i));

}


     //   Toast.makeText(this, himanshu.toString(), Toast.LENGTH_SHORT).show();
        final int sum=k;
        k=0;

        bt.setText("Pay: "+String.valueOf(sum));
        bill.setText(mobileArray.toString());
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProcessOrder.this,PaymentActivity.class);
                intent.putExtra("total",sum);

                startActivity(intent);

            }
        });



    }
}
