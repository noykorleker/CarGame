package com.example.hw1androidnoykorleker;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nameView;
    TextView recordView;

    public MyViewHolder(final View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.name);
        recordView = itemView.findViewById(R.id.record);
    }
}
