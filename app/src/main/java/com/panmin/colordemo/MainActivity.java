package com.panmin.colordemo;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int color1 = Color.parseColor("#de4444");
    private int color2 = Color.parseColor("#e48937");
    private int color3 = Color.parseColor("#e5de20");
    private int color4 = Color.parseColor("#74bc1e");
    private int color5 = Color.parseColor("#3c9c11");
    private ColorBar cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        cb = (ColorBar) findViewById(R.id.cb);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        handler.postDelayed(runnable,1000);
    }
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Random random = new Random();
            int i = random.nextInt(5);
            int color = 0;
            switch (i){
                case 1:
                    color = color1;
                    break;
                case 2:
                    color = color2;
                    break;
                case 3:
                    color = color3;
                    break;
                case 4:
                    color = color4;
                    break;
                case 5:
                    color = color5;
                    break;
                default:
                    color = color1;
                    break;
            }
            cb.addData(100, color);
            handler.postDelayed(runnable,1000);
        }
    };
}
