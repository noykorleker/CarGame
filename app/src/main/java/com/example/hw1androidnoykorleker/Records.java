package com.example.hw1androidnoykorleker;

import android.content.ClipData;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Records extends AppCompatActivity {
    private  ArrayList<RecordData> items;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);
        items = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        setRecordDataInfo();
        setAdapter();
    }

    private void setAdapter() {
        MyAdapter myAdapter = new MyAdapter(items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }

    private void setRecordDataInfo() {
        items.add(new RecordData("Eden", "4567800"));
        items.add(new RecordData("Shiran", "4500"));
        items.add(new RecordData("Lihi", "60000"));
        items.add(new RecordData("Joy", "7400"));
        items.add(new RecordData("Rachel", "1200"));
        items.add(new RecordData("Noy", "80044"));
        items.add(new RecordData("Chelsea", "87055"));
        items.add(new RecordData("Sahar", "450430"));

        items.add(new RecordData("Roni", "455500"));
        items.add(new RecordData("Nadav", "45000000"));
    }
}
