        package com.houssup.userapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.Toast;

        import com.hanks.library.AnimateCheckBox;

        public class ThreeStepsActivity extends AppCompatActivity {

            ImageView questionnare,floorPlan,houseImage;
            Button createMoodBoard;
            AnimateCheckBox cb1, cb2, cb3;
            AnsweredSuccessActivity answeredSuccessActivity;
            String value;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_three_steps);
                cb1 = (AnimateCheckBox) findViewById(R.id.itemCheckBox);
                cb2 = (AnimateCheckBox) findViewById(R.id.itemCheckBox1);
                cb3 = (AnimateCheckBox) findViewById(R.id.itemCheckBox2);
                questionnare = (ImageView) findViewById(R.id.fillQuestionnare);
                floorPlan=(ImageView)findViewById(R.id.floorPlan);
                houseImage=(ImageView)findViewById(R.id.houseImage);
                createMoodBoard = (Button)findViewById(R.id.button);

                boolean data = getIntent().hasExtra("keyName");

                if (data == true) {
                    AnimateCheckBox checkBox = (AnimateCheckBox) findViewById(R.id.itemCheckBox);
                    checkBox.setVisibility(View.VISIBLE);
                    checkBox.setChecked(true);
                }

                if (data == false)
                    Toast.makeText(ThreeStepsActivity.this, "", Toast.LENGTH_SHORT).show();

                    questionnare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(ThreeStepsActivity.this, QuestionOneActivity.class);
                            startActivity(intent);
                        }
                    });


                    floorPlan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(ThreeStepsActivity.this , UpdateFloorPlanActivity.class);
                            startActivity(intent);
                        }
                    });


                houseImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ThreeStepsActivity.this , HomeImageActivity.class);
                        startActivity(intent);
                    }
                });


                createMoodBoard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ThreeStepsActivity.this , MoodActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
