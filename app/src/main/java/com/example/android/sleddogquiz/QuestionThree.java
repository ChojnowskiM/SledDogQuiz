package com.example.android.sleddogquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionThree extends AppCompatActivity {
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private EditText editText;
    private int score;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);
        editText = findViewById(R.id.edit_answer);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("scores");
        }
    }

    public void nextQuestion(View view) {
        if (editText.getText().toString().equals(getString(R.string.pulka)) || editText.getText().toString().equals(getString(R.string.pulka_Cap))) {
            score += 5;
        }
        Toast toast = Toast.makeText(this, getString(R.string.scores) + score, Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, QuestionsFurthers.class);
        intent.putExtra("scores", score);
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
