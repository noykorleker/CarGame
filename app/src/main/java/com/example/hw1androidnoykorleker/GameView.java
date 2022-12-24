package com.example.hw1androidnoykorleker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.os.Handler;

import java.util.Random;

public class GameView extends AppCompatActivity {
    Handler handler = new Handler();Random randomNum = new Random();
    ImageView carC, heart, stone;
    int counter, delay = 500, startY = 50, dy = 440,dx = 220, max_cell = 6, stoneIndex = 0, life = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_view);
        carC = findViewById(R.id.car_center);
        handler.postDelayed(runnable, delay);
    }


    public ImageView change(int row){
        switch (row){
            case 1:
                stone = findViewById(R.id.stone_1);
                return stone;
            case 2:
                stone = findViewById(R.id.stone_2);
                return stone;
            case 3:
                stone = findViewById(R.id.stone_3);
                return stone;
            case 4:
                stone = findViewById(R.id.stone_4);
                return stone;
            case 5:
                stone = findViewById(R.id.stone_5);
                return stone;
            default:
                break;
        }
        return null;
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            counter = 1;
            stoneIndex = randomNum.nextInt(max_cell);
            stone = change(stoneIndex);
            stone.setVisibility(View.VISIBLE);
            handler.postDelayed(runnable2, delay);
        }
    };

    private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            stone.setY(stone.getY()+dy);
            counter = counter+1;
            if(counter >= 5){
                stone.setY(startY);
                stone.setVisibility(View.INVISIBLE);
                handler.postDelayed(runnable, delay);
            }else{
                handler.postDelayed(runnable2, delay);
            }
        }
    };
    public void hearts(int numOfHearts) {
        switch (numOfHearts) {
            case 2:
                heart = findViewById(R.id.heart3);
                break;
            case 1:
                heart = findViewById(R.id.heart2);
                break;
            case 0:
                heart = findViewById(R.id.heart1);
                break;
            default:
        }
    }

    public void moveCar(View view) {
            switch (view.getId()){
                case R.id.rightBtn:
                    if (carC.getX() > -440)
                        carC.setX(carC.getX()-dx);
                    break;
                case R.id.leftBtn:
                    if (carC.getX() < 440)
                        carC.setX(carC.getX()+dx);
                    break;
            }
    }


}