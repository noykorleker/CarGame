package com.example.hw1androidnoykorleker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /** Called when the user touches the button */
    public void goToGame(View view) {
        Intent i = new Intent(Main.this,GameView.class);
        startActivity(i);//go to game page and start
    }
}