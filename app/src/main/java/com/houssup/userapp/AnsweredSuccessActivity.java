        package com.houssup.userapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

        import com.hanks.library.AnimateCheckBox;

        public class AnsweredSuccessActivity extends AppCompatActivity {

            Button nextButton,backButton;
            ImageView iv;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_answered_success);

                nextButton = (Button)findViewById(R.id.nextButton);
                backButton = (Button)findViewById(R.id.backButton);
                AnimateCheckBox checkBox = (AnimateCheckBox) findViewById(R.id.itemCheckBox_one);
                checkBox.setChecked(true);

                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AnsweredSuccessActivity.this, ThreeStepsActivity.class);
                        intent.putExtra("keyName","value");
                        startActivity(intent);
                    }
                });
            }
        }
