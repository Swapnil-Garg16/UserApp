package com.houssup.userapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class QuestionOneActivity extends AppCompatActivity {

    CardView cardView1,cardView2,cardView3,cardView4;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        nextButton = (Button)findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionOneActivity.this , AnsweredSuccessActivity.class);
                startActivity(intent);
            }
        });


        cardView1 = (CardView) findViewById(R.id.card_view1);

       cardView1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               v.setAlpha(.5f);

           }
       });
      /*  optionOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setAlpha(.5f);
                optionTwo.setClickable(false);
                optionThree.setClickable(false);
                optionFour.setClickable(false);
                return false;
            }
        });



        optionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(.5f);
                optionOne.setClickable(false);
                optionThree.setClickable(false);
                optionFour.setClickable(false);
            }
        });
        optionTwo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setAlpha(.5f);
                optionOne.setClickable(false);
                optionThree.setClickable(false);
                optionFour.setClickable(false);
                return false;
            }
        });


        optionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(.5f);
                optionTwo.setClickable(false);
                optionOne.setClickable(false);
                optionFour.setClickable(false);
            }
        });
        optionThree.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setAlpha(.5f);
                optionTwo.setClickable(false);
                optionOne.setClickable(false);
                optionFour.setClickable(false);
                return false;
            }
        });


        optionFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(.5f);
                optionTwo.setClickable(false);
                optionOne.setClickable(false);
                optionThree.setClickable(false);
            }
        });
        optionFour.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setAlpha(.5f);
                optionTwo.setClickable(false);
                optionOne.setClickable(false);
                optionThree.setClickable(false);
                return false;
            }
        });*/
    }
}
