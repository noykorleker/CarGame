package com.example.hw1androidnoykorleker;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.os.Handler;
import android.widget.Toast;

import java.util.Random;

public class GameView extends AppCompatActivity{
    Handler handler = new Handler();Car car = new Car();ImageView carC, carR, carL, heart, stone;int currentPosition;
    GridLayout gridLayout;Random randomNum = new Random();int stoneIndex, life = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_view);

        carC = findViewById(R.id.car_center);carR = findViewById(R.id.car_rigth);carL = findViewById(R.id.car_left);
        gridLayout = findViewById(R.id.grid_stones);
        handler.postDelayed(runnable, 500);
    }

    private  Runnable runnable = new Runnable() {
        @Override
        public void run() {
            stoneIndex = randomNum.nextInt(4);
            randomsStones(stoneIndex);
            stone.setVisibility(View.VISIBLE);
            handler.postDelayed(runnable2, 500);
        }
    };

    private  Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            stone.setVisibility(View.INVISIBLE);
            stoneIndex+=3;//move to next stone
            randomsStones(stoneIndex);
            stone.setVisibility(View.VISIBLE);
            if(stoneIndex <= 12){
                handler.postDelayed(runnable2, 500);
                if(stoneIndex > 8){
                    if((stoneIndex == 10 && car.getPosition() == 1) || (stoneIndex == 11 && car.getPosition() == 2)||
                            (stoneIndex == 12 && car.getPosition() == 3)){
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        v.vibrate(400);// Vibrate for 400 milliseconds
                        Toast.makeText(GameView.this, "stone + car = not good!!", Toast.LENGTH_SHORT).show();
                        life--;
                        hearts(life);
                        heart.setVisibility(View.INVISIBLE);
                    }
                }
            }
            else if(stoneIndex > 12){
                stone.setVisibility(View.INVISIBLE);
                handler.postDelayed(runnable, 500);
            }
        }
    };

    public void hearts(int numOfHearts){
        switch(numOfHearts) {
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

    public void randomsStones(int num) {
        switch(num) {
            case 1:
                stone =  findViewById(R.id.stone_1);
                break;
            case 2:
                stone =  findViewById(R.id.stone_2);
                break;
            case 3:
                stone =  findViewById(R.id.stone_3);
                break;
            case 4:
                stone =  findViewById(R.id.stone_4);
                break;
            case 5:
                stone =  findViewById(R.id.stone_5);
                break;
            case 6:
                stone =  findViewById(R.id.stone_6);
                break;
            case 7:
                stone =  findViewById(R.id.stone_7);
                break;
            case 8:
                stone =  findViewById(R.id.stone_8);
                break;
            case 9:
                stone =  findViewById(R.id.stone_9);
                break;
            case 10:
                stone =  findViewById(R.id.stone_10);
                break;
            case 11:
                stone =  findViewById(R.id.stone_11);
                break;
            case 12:
                stone =  findViewById(R.id.stone_12);
                break;
            default:
        }
    }

    public void moveCarRight(View view) {
        currentPosition = car.getPosition();
        switch (currentPosition){
            case 1:
                carL.setVisibility(View.INVISIBLE);
                carC.setVisibility(View.VISIBLE);
                carR.setVisibility(View.INVISIBLE);
                car.setPosition(2);
                return;
            case 2:
                carL.setVisibility(View.INVISIBLE);
                carC.setVisibility(View.INVISIBLE);
                carR.setVisibility(View.VISIBLE);
                car.setPosition(3);
                return;
            case 3:
                return;
            default:
        }
    }

    public void moveCarLeft(View view) {
        currentPosition = car.getPosition();
        switch (currentPosition){
            case 1:
                return;
            case 2:
                carC.setVisibility(View.INVISIBLE);
                carL.setVisibility(View.VISIBLE);
                carR.setVisibility(View.INVISIBLE);
                car.setPosition(1);
                return;
            case 3:
                carR.setVisibility(View.INVISIBLE);
                carC.setVisibility(View.VISIBLE);
                carL.setVisibility(View.INVISIBLE);
                car.setPosition(2);
                return;
            default:
        }
    }
}