package com.example.hw1androidnoykorleker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<RecordData> items;

    public MyAdapter(ArrayList<RecordData> items){
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_data_view, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = items.get(position).getName();
        String record = items.get(position).getRecord();

        holder.nameView.setText(name);
        holder.recordView.setText(record);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
