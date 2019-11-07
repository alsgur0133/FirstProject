package com.webcash.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity extends AppCompatActivity {
    private Handler mHandler;
    private CustomRunnable mCustomRunnable;
    private TextView mTvTimer;
    private String mCurrentTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        mTvTimer = (TextView) findViewById(R.id.tv_Timer);
        mCustomRunnable = new CustomRunnable();
        mHandler = new Handler();
        mHandler.postDelayed(mCustomRunnable, 1000);
        }
        @Override
        protected void onDestroy(){
        mHandler.removeCallbacks(mCustomRunnable);
        super.onDestroy();
        }

        class CustomRunnable implements Runnable{
            @Override
            public void run() {
                try {
                    while(true){
                        Thread.sleep(1000);

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:ss");
                        mCurrentTime = sdf.format(new Date());

                        Log.d("Timer", mCurrentTime);
                        mTvTimer.setText("Timer : "+mCurrentTime);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

  }
}
