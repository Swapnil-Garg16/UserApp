package com.houssup.userapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UpdateFloorPlanActivity extends AppCompatActivity {

    Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_floor_plan);
        proceed=(Button)findViewById(R.id.proceedButton);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(UpdateFloorPlanActivity.this , UploadLayoutsActivity.class);
                startActivity(i);
            }
        });
    }
}
