package com.houssup.userapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class UploadLayoutsActivity extends AppCompatActivity {

    ImageView left , right;
    HorizontalScrollView horizontalScrollView;
    LinearLayout linearLayout ;
    Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_layouts);
        right=(ImageView)findViewById(R.id.nextButton);
        left=(ImageView)findViewById(R.id.previousButton);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontal_scrollview);
        linearLayout = (LinearLayout) findViewById(R.id.dynamic_generation);
        proceed=(Button)findViewById(R.id.proceed);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadLayoutsActivity.this , FloorSuccessActivity.class);
                startActivity(intent);
            }
        });
        right.setOnTouchListener(new View.OnTouchListener() {

            private Handler mHandler;
            private long mInitialDelay = 300;
            private long mRepeatDelay = 100;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null)
                            return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, mInitialDelay);
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null)
                            return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override
                public void run() {
                    horizontalScrollView.scrollTo((int) horizontalScrollView.getScrollX() + 10, (int) horizontalScrollView.getScrollY());
                    mHandler.postDelayed(mAction, mRepeatDelay);
                }
            };
        });
    }
}
