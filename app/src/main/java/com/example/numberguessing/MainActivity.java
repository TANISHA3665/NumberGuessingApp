package com.example.numberguessing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnLeft;
    private Button btnRight;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btnLeft = findViewById(R.id.btnLeft);
         btnRight = findViewById(R.id.btnRight);
         constraintLayout = findViewById(R.id.backgroundView);
         assignNumber();
         btnLeft.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 checkNumber(true);
                 assignNumber();
             }
         });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNumber(false);
                assignNumber();
            }
        });
    }

    private void checkNumber(boolean isLeftButtonSelected){
        int leftNum = Integer.parseInt(btnLeft.getText().toString());
        int rightNum = Integer.parseInt(btnRight.getText().toString());
        boolean isAnswerCorrect;
        if(isLeftButtonSelected){
            isAnswerCorrect = leftNum > rightNum;
        }
        else{
            isAnswerCorrect = rightNum > leftNum;
        }
        if(isAnswerCorrect) {
            constraintLayout.setBackgroundColor(Color.GREEN);
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else{
            constraintLayout.setBackgroundColor(Color.RED);
            Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    private void assignNumber(){
        int leftNum = new Random().nextInt(100) + 1; // [0, 109] + 1 => [1, 100]
        int rightNum= new Random().nextInt(100) + 1;
        while(leftNum == rightNum){
            rightNum = new Random().nextInt(100) + 1;
        }
        btnLeft.setText(leftNum + "");
        btnRight.setText(rightNum + "");
    }
}