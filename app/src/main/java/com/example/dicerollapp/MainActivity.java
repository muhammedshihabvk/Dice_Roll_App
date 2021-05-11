package com.example.dicerollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.security.PrivateKey;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button roll;
    private ImageView dice1,dice2;


    public  static  final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        roll = (Button)findViewById(R.id.rollButton);
        dice1 = (ImageView)findViewById(R.id.dice1);
        dice2 = (ImageView)findViewById(R.id.dice2);


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int roll1 = randomDice();
                int roll2 = randomDice();
                System.out.println("roller:"+roll1+" "+roll2);

                int res1 = getResources().getIdentifier("dice_"+roll1,"drawable","com.example.dicerollapp");
                int res2 = getResources().getIdentifier("dice_"+roll2,"drawable","com.example.dicerollapp");

                System.out.println("Resource:"+res1+" "+res2);


                dice1.setImageResource(res1);
                dice2.setImageResource(res2);
            }
        });

    }

    public static int randomDice(){
            return random.nextInt(6)+1;
    }
}