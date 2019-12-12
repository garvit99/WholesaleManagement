package com.example.wholesalemanagementsystem;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

class MyPersonalViewHolder extends RecyclerView.ViewHolder {

    TextView numberTextView;
    EditText nameEditText;

    public MyPersonalViewHolder(View itemView) {
        super(itemView);
        nameEditText = (EditText) itemView.findViewById(R.id.quantity);
    }
}
