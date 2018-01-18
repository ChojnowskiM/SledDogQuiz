package com.example.android.sleddogquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionThree extends AppCompatActivity {
private EditText editText;
private int score;
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
    }
}
