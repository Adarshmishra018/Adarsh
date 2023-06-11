package com.example.quizmaster;

import static com.example.quizmaster.MainActivity.listOfQ;
import static com.example.quizmaster.R.*;
import static com.example.quizmaster.R.color.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CardView cardView;
    CountDownTimer countDownTimer;
    ProgressBar progressBar;
    int timerValue =20;
    List<model> allQ;
    model model;
    int index=0;
    TextView card_question,card_optiona,card_optionb,card_optionc,card_optiond,ic_exit;
    CardView optionA,optionB,optionC,optionD;
    int correctCount=0;
    int wrongCount=0;
    LinearLayout nextbtn;
    ImageView ic_back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_dashboard);
        Hooks();

        allQ=listOfQ;
        Collections.shuffle(allQ);//shuffle questions
        model=listOfQ.get(index);
        enableButton();
        optionA.setCardBackgroundColor(getResources().getColor(white));
        optionB.setCardBackgroundColor(getResources().getColor(white));
        optionC.setCardBackgroundColor(getResources().getColor(white));
        optionD.setCardBackgroundColor(getResources().getColor(white));
        resetColor();
        nextbtn.setClickable(false);
        SetAlldata();
        ic_back= (ImageView)findViewById(id.ic_back);
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DashboardActivity.PutExtra("EXIT",true);
                finish();
                System.exit(0);
            }
        });




        CountDownTimer countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue=timerValue-1;
                progressBar.setProgress(timerValue);

            }

            @Override
            public void onFinish() {
                Dialog dialog=new Dialog(DashboardActivity.this, style.Dialoge);
                dialog.setContentView(layout.timeout_dialog);
                dialog.findViewById(id.btntryagain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(DashboardActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();

    }

    private void SetAlldata() {
        card_question.setText(model.getQuestion());
        card_optiona.setText(model.getoA());
        card_optionb.setText(model.getoB());
        card_optionc.setText(model.getoC());
        card_optiond.setText(model.getoD());


    }

    //@SuppressLint("WrongViewCast")
    private void Hooks() {
        progressBar=findViewById(id.quiz_timer);
        card_question=findViewById(id.card_question);
                card_optiona=findViewById(id.card_optiona);
                card_optionb=findViewById(id.card_optionb);
                card_optionc=findViewById(id.card_optionc);
                card_optiond=findViewById(id.card_optiond);

                optionA=findViewById(id.optionA);
                optionB=findViewById(id.optionB);
                optionC=findViewById(id.optionC);
                optionD=findViewById(id.optionD);

                nextbtn=findViewById(id.nextbtn);
                //ic_back = findViewById(id.ic_back);
                //ic_exit=findViewById(id.ic_exit);
    }
    public void Correct(CardView cardView){
      cardView.setBackgroundColor(getResources().getColor(green));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resetColor();
                ++correctCount;
                    index++;
                    model = listOfQ.get(index);
                    SetAlldata();

                cardView.setBackgroundColor(getResources().getColor(white));
                resetColor();
                enableButton();

                    timerValue = 20;
                    progressBar.setProgress(20);


            }
        });

    }
    public void Wrong(CardView optionA){
        optionA.setCardBackgroundColor(getResources().getColor(red));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if(index<listOfQ.size()-1 ){
                    index++;
                    model=listOfQ.get(index);
                    SetAlldata();
                    resetColor();

                    enableButton();
                    timerValue=20;
                    progressBar.setProgress(20);

                }else{
                    GameWon();
            }
        }

      });

    }

    private void GameWon() {
        Intent intent=new Intent(DashboardActivity.this,WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }

    public void enableButton(){
        optionA.setClickable(true);
        optionB.setClickable(true);
        optionC.setClickable(true);
        optionD.setClickable(true);
    }
    public void disableButton(){
        optionA.setClickable(false);
        optionB.setClickable(false);
        optionC.setClickable(false);
        optionD.setClickable(false);
    }
    public void resetColor(){
        optionA.setCardBackgroundColor(getResources().getColor(white));
        optionB.setCardBackgroundColor(getResources().getColor(white));
        optionC.setCardBackgroundColor(getResources().getColor(white));
        optionD.setCardBackgroundColor(getResources().getColor(white));

    }

    public void optionAclick(View view) {
        disableButton();
        nextbtn.setClickable(true);
        disableButton();
        if(model.getoA().equals(model.getAns())){
            optionA.setCardBackgroundColor(getResources().getColor(green));
            if(index< listOfQ.size()-1){
                Correct(optionA);
               // resetColor();
            }else{
                GameWon();
            }
        }else{
            Wrong(optionA);
        }
    }

    public void optionBclick(View view) {
      disableButton();
        nextbtn.setClickable(true);
        disableButton();
        if(model.getoB().equals(model.getAns())){
            optionB.setCardBackgroundColor(getResources().getColor(green));
            if(index< listOfQ.size()-1){
            Correct(optionB);
                   //         resetColor();
            }else{
                GameWon();
            }
        }else{
            Wrong(optionB);
        }
    }
    public void optionCclick(View view) {
        disableButton();
        nextbtn.setClickable(true);
        disableButton();
        if(model.getoC().equals(model.getAns())){
            optionC.setCardBackgroundColor(getResources().getColor(green));
            if(index< listOfQ.size()-1){

                Correct(optionC);
               // resetColor();
            }else{
                GameWon();
            }
        }else{
            Wrong(optionC);
        }
    }

    public void optionDclick(View view) {
        disableButton();
        nextbtn.setClickable(true);
        disableButton();
        if(model.getoD().equals(model.getAns())){
            optionD.setCardBackgroundColor(getResources().getColor(green));
            if(index< listOfQ.size()-1){
               Correct(optionD);
              // resetColor();
            }else{
                GameWon();
            }
        }else{
            Wrong(optionD);
        }
    }
}