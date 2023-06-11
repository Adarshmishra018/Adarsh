package com.example.quizmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WonActivity extends AppCompatActivity {


    ProgressBar circularprogress;
    TextView resulttext;
    int correct,wrong;
    ImageView ic_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        correct=getIntent().getIntExtra("correct",0) ;
        wrong=getIntent().getIntExtra("wrong",0) ;
    circularprogress=findViewById(R.id.circularprogress);
        resulttext=findViewById(R.id.resulttext);
        circularprogress.setProgress(correct);
        resulttext.setText(correct+"/5");
        ic_back= (ImageView)findViewById(R.id.ic_back);
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DashboardActivity.PutExtra("EXIT",true);
                finish();
                System.exit(0);
            }
        });

    }
}