package com.houssup.userapp;


        import android.content.Intent;
        import android.graphics.Typeface;
        import android.os.CountDownTimer;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DigitalClock;
        import android.widget.TextView;

public class MoodActivity extends AppCompatActivity {
    private TextView clock;
    Button proceed ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        proceed=(Button)findViewById(R.id.button);
        clock=(TextView)findViewById(R.id.textView8);

        int hoursToGo = 24;
        int minutesToGo = 0;
        int secondsToGo = 0;

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MoodActivity.this , SelectDesignersActivity.class);
                startActivity(intent);
            }
        });
        int millisToGo = secondsToGo*1000+minutesToGo*1000*60+hoursToGo*1000*60*60;
        final Typeface face = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        new CountDownTimer(millisToGo,1000) {

            @Override
            public void onTick(long millis) {
                int seconds = (int) (millis / 1000) % 60 ;
                int minutes = (int) ((millis / (1000*60)) % 60);
                int hours   = (int) ((millis / (1000*60*60)) % 24);
                String text = String.format("%02d:%02d:%02d",hours,minutes,seconds);

                clock.setText(text);
                clock.setTypeface(face);
            }

            @Override
            public void onFinish() {
                clock.setText("00:00:00");
            }
        }.start();

    }


}
