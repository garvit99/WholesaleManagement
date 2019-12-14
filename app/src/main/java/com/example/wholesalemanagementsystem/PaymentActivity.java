package com.example.wholesalemanagementsystem;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {

    String TAG="Error";
    int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        final int finalTotal;
        Button button=findViewById(R.id.button);
        Bundle extras=getIntent().getExtras();
        total=extras.getInt("total");
        ItemAdapter.sum=0;
        ItemAdapter.list.clear();
        total=total*100;


        finalTotal = total;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this,""+total,Toast.LENGTH_LONG).show();
                startPayment(finalTotal);
            }
        });
    }
    private void startPayment(int finaltotal)
    {
/**
 * Instantiate Checkout
 */
        Checkout checkout = new Checkout();

        /**
         * Set your logo here
         */
        //checkout.setImage(R.drawable.logo);

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject orderRequest = new JSONObject();

            /**
             * Merchant Name
             * eg: ACME Corp || HasGeek etc.
             */
            orderRequest.put("amount", finaltotal); // amount in the smallest currency unit
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "order_rcptid_11");
            orderRequest.put("payment_capture", false);
            /**
             * Amount is always passed in currency subunits
             * Eg: "500" = INR 5.00
             */


            checkout.open(activity, orderRequest);
        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {

        Toast.makeText(PaymentActivity.this,"Payment Sucess",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPaymentError(int code, String response) {

        Toast.makeText(PaymentActivity.this,"Payment Failure"+code+response,Toast.LENGTH_LONG).show();
    }
}
