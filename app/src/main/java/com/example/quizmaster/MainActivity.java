package com.example.quizmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  public static  ArrayList<model> listOfQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       listOfQ=new ArrayList<>();
        listOfQ.add(new model(" India is a federal union comprising twenty-eight states and how many union territories?",
                "6","7","8","9","8"));
        listOfQ.add(new model(" Which of the following is the capital of Arunachal Pradesh?",
                "Itanagar","Dispur","Imphal","Panaji","Itanagar"));
        listOfQ.add(new model(" What are the major languages spoken in Andhra Pradesh?",
                "Odia and Telugu","Telugu and Urdu","Telugu and Kannada","All of the above language","Telugu and Urdu"));
        listOfQ.add(new model("  What is the state flower of Haryana?",
                " Lotus","Rhododendron","Golden Shower"," Not Declared","Lotus"));
        listOfQ.add(new model(" Which of the following states is not located in the North?",
                "Jharkhand","Jammu and Kashmir","Himachal Pradesh","Haryana","Jharkhand"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        },1500);
    }
}