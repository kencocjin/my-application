package com.test.easestandby;

import static com.test.easestandby.SplashScreen.listofQ;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class quiz extends AppCompatActivity {

    CountDownTimer countdownTimer;
    int timer=20;
    //RoundedHorizontalProgressBar progressBar;
    List<OptionClass> allQuestionList;
    OptionClass optionClass;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        //progressBar=findViewById(R.id.qtimer);
        allQuestionList=listofQ;
        Collections.shuffle(allQuestionList);
        optionClass= listofQ.get(index);


        countdownTimer= new CountDownTimer(2000,1000){
        @Override
            public void onTick(long millisUntilFinished){
                timer=timer-1;
            }
            @Override
            public void onFinish() {
                Dialog dialog=new Dialog(quiz.this,R.style.Dialog);
                dialog.setContentView(R.layout.alert_dialogbox);

                dialog.findViewById(R.id.tryAgain).setOnClickListener(new View.OnClickListener(){
                @Override
                    public void onClick(View v){
                    Intent intent = new Intent(quiz.this,MainActivity.class);
                    startActivity(intent);
                }
                });
                dialog.show();
            }

            }.start();
    }

}