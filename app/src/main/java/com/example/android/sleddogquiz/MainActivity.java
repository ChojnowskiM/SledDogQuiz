package com.example.android.sleddogquiz;

import android.content.ClipData;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public int score = 0;
    //images for question 1
    private int im1, im2, im3, im4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginQuiz(View view) {
        Intent intent = new Intent(this, Questionone.class);
        startActivity(intent);
    }

    public void firstQ(View view) {
        if (im1 == 0 && im2 == 1 && im3 == 2 && im4 == 3) {
            score += 1;
        } else {
            score = score + 0;
        }
        Log.v("test", "działa" + score);
    }
}
