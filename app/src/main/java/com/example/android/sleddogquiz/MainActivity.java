package com.example.android.sleddogquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Set for button which begins the quiz. Opens activity with first questions.
    public void beginQuiz(View view) {
        Intent intent = new Intent(this, Questionone.class);
        startActivity(intent);
        finish();
    }
    //it holds behavior for clicking back button - going to question before and decrease points.
    public void onBackPressed() {

        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), getString(R.string.exit), Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();

    }
}
