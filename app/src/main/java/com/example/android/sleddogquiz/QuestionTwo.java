package com.example.android.sleddogquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.mobeta.android.dslv.DragSortListView;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionTwo extends AppCompatActivity {
    private int score;
    private CheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        ch4 = findViewById(R.id.ch4);
        ch5 = findViewById(R.id.ch5);
        ch6 = findViewById(R.id.ch6);
        ch7 = findViewById(R.id.ch7);
        ch8 = findViewById(R.id.ch8);
        ch9 = findViewById(R.id.ch9);
        ch10 = findViewById(R.id.ch10);
        ch11 = findViewById(R.id.ch11);
        ch12 = findViewById(R.id.ch12);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("scores");
        }
        ArrayList<String> breeds = new ArrayList<String>();
        breeds.add(getText(R.string.alaskan_husky).toString());
        breeds.add(getText(R.string.alaskan_malamute).toString());
        breeds.add(getText(R.string.greenland).toString());
        breeds.add(getText(R.string.eurodog).toString());
        breeds.add(getText(R.string.greyhound).toString());
        breeds.add(getText(R.string.greyster).toString());
        breeds.add(getText(R.string.kleekai).toString());
        breeds.add(getText(R.string.malinois).toString());
        breeds.add(getText(R.string.norwegian_elkhound).toString());
        breeds.add(getText(R.string.rottweiler).toString());
        breeds.add(getText(R.string.samoyed).toString());
        breeds.add(getText(R.string.siberian_husky).toString());
        Collections.shuffle(breeds);

        ch1.setText(breeds.get(0));
        ch2.setText(breeds.get(1));
        ch3.setText(breeds.get(2));
        ch4.setText(breeds.get(3));
        ch5.setText(breeds.get(4));
        ch6.setText(breeds.get(5));
        ch7.setText(breeds.get(6));
        ch8.setText(breeds.get(7));
        ch9.setText(breeds.get(8));
        ch10.setText(breeds.get(9));
        ch11.setText(breeds.get(10));
        ch12.setText(breeds.get(11));
    }

    public boolean findCorrectAnwer (String text) {
        if (text.equals(getString(R.string.alaskan_husky))) {
            return true;
        } else if (text.equals(getString(R.string.alaskan_malamute))) {
            return true;
        } else if (text.equals(getString(R.string.greenland))) {
            return true;
        } else if (text.equals(getString(R.string.eurodog))) {
            return true;
        } else if (text.equals(getString(R.string.greyster))) {
            return true;
        } else if (text.equals(getString(R.string.samoyed))) {
            return true;
        } else if (text.equals(getString(R.string.siberian_husky))) {
            return true;
        } else { return false; }
    }

    public int checkScores () {
        if (ch1.isChecked()) {
            if (findCorrectAnwer(ch1.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch2.isChecked()) {
            if (findCorrectAnwer(ch2.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch3.isChecked()) {
            if (findCorrectAnwer(ch3.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch4.isChecked()) {
            if (findCorrectAnwer(ch4.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch5.isChecked()) {
            if (findCorrectAnwer(ch5.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch6.isChecked()) {
            if (findCorrectAnwer(ch6.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch7.isChecked()) {
            if (findCorrectAnwer(ch7.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch8.isChecked()) {
            if (findCorrectAnwer(ch8.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch9.isChecked()) {
            if (findCorrectAnwer(ch9.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch10.isChecked()) {
            if (findCorrectAnwer(ch10.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch11.isChecked()) {
            if (findCorrectAnwer(ch11.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        if (ch12.isChecked()) {
            if (findCorrectAnwer(ch12.getText().toString())) {
                score += 1;
            } else {
                score -= 1;
            }
        }
        return score;
    }

    public void nextQuestion(View view) {
        checkScores();
        Toast toast = Toast.makeText(this, getString(R.string.scores) + score, Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, QuestionThree.class);
        intent.putExtra("scores", score);
        startActivity(intent);
    }
}
