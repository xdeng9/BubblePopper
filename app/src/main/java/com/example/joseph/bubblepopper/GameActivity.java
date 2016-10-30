package com.example.joseph.bubblepopper;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import static android.os.Build.VERSION_CODES.M;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GameActivity extends AppCompatActivity {

    private ViewGroup mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().setBackgroundDrawableResource(R.drawable.water_background);

        mContentView = (ViewGroup) findViewById(R.id.activity_game);

        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFullScreenMode();
            }
        });
        mContentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("onTouch:", "Clicked!!!");
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Bubble bubble = new Bubble(GameActivity.this, 100);
                    bubble.setX(event.getX());
                    bubble.setY(event.getY());
                    mContentView.addView(bubble);
                }
                return false;
            }
        });
    }

    private void setFullScreenMode(){
        ViewGroup root = (ViewGroup) findViewById(R.id.activity_game);
        root.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    protected void onResume(){
        super.onResume();
        setFullScreenMode();
    }
}