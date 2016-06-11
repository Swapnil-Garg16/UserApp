package com.houssup.userapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanks.library.AnimateCheckBox;

public class HomeActivity extends AppCompatActivity {

    Button designHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        designHome = (Button)findViewById(R.id.designHome);
        designHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this , ThreeStepsActivity.class);
                startActivity(intent);
            }
        });

        AnimateCheckBox checkBox = (AnimateCheckBox) findViewById(R.id.itemCheckBox);
        checkBox.setChecked(true);
    }
}
