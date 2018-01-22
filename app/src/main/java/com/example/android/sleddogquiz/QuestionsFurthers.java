package com.example.android.sleddogquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsFurthers extends AppCompatActivity {
    private static final String pointsGainedKey = "pointsGained";
    private static final String questionNumberKey = "questionNumber";
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private Button nextQ;
    private TextView questionAsk;
    private RadioGroup rg;
    private RadioButton ans1, ans2, ans3, ans4;
    //variable holds number of points gained in quiz.
    private int score;
    //variable setting correct question from array setQuestion.
    private int questionNumber = 0;
    private long mBackPressed;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_furthers);
        nextQ = findViewById(R.id.next);
        questionAsk = findViewById(R.id.question);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("scores");
        }
        rg = findViewById(R.id.q1);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        setQuestion(questionNumber);
        String question = setQuestion(questionNumber);
        questionAsk.setText(question);
        setAnswers(questionNumber);
        //Check saved data and returns it.
        if (savedInstanceState != null) {
            score = savedInstanceState.getInt(pointsGainedKey);
            questionNumber = savedInstanceState.getInt(questionNumberKey);
            //if scores was displayed on screen - saved to display it.
            if (questionNumber == 4) {
                setContentView(R.layout.scores);
                TextView finalScore = findViewById(R.id.final_score);
                ProgressBar cds2 = findViewById(R.id.cds_bar2);
                TextView scoreDesc = findViewById(R.id.score_desc);
                finalScore.setText(String.valueOf(score));
                cds2.setProgress(score);
                //Set description for given scores.
                if (score < 5) {
                    scoreDesc.setText(getString(R.string.mushing_poor));
                } else if (score >= 5 && score <= 10) {
                    scoreDesc.setText(getString(R.string.mushing_little));
                } else if (score >= 11 && score <= 17) {
                    scoreDesc.setText(getString(R.string.mushing_know_sth));
                } else if (score >= 18) {
                    scoreDesc.setText(getString(R.string.are_you_musher));
                }
            } else {
                //if question was with id=16 or less it will retrieve data.
                question = setQuestion(questionNumber);
                questionAsk.setText(question);
                setAnswers(questionNumber);
                if (questionNumber == 4) {
                    nextQ.setText(getString(R.string.result));
                }
            }
        }
    }

    //Saving data (questions, points, etc. state).
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(pointsGainedKey, score);
        outState.putInt(questionNumberKey, questionNumber);
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

    //Method which makes button "next" working as intended.
    public void nextQuestion(View view) {

        //statement check is there any button checked, if not do nothing.
        if (rg.getCheckedRadioButtonId() == -1) {
        } else {
            //moving user to next question
            points();
            questionNumber += 1;
            //run if it is the one before last question
            if (questionNumber >= 3) {
                //run if it is last question, showing results
                if (questionNumber >= 4) {
                    Toast toast = Toast.makeText(this, getString(R.string.scores) + score, Toast.LENGTH_SHORT);
                    toast.show();
                    score(view);
                } else {
                    //sets question and TextViews correctly.
                    String question = setQuestion(questionNumber);
                    questionAsk.setText(question);
                    setAnswers(questionNumber);
                    nextQ.setText(getString(R.string.result));
                    Toast toast = Toast.makeText(this, getString(R.string.scores) + score, Toast.LENGTH_SHORT);
                    toast.show();
                    rg.clearCheck();
                }

            } else {
                //updating question to next one, clearing radiobuttons, updating progress bars
                String question = setQuestion(questionNumber);
                questionAsk.setText(question);
                setAnswers(questionNumber);
                Toast toast = Toast.makeText(this, getString(R.string.scores) + score, Toast.LENGTH_SHORT);
                toast.show();
                rg.clearCheck();
            }
        }
    }

    // Method which calls question.
    public String setQuestion(int questionNumber) {
        String[] question = new String[4];
        question[0] = getString(R.string.rg_question_1);
        question[1] = getString(R.string.rg_question_2);
        question[2] = getString(R.string.rg_question_3);
        question[3] = getString(R.string.rg_question_4);
        return question[questionNumber];
    }
    //Updates texts for each radioButton
    public void setAnswers(int questionNumber) {
        String answer1 = setAnswer1(questionNumber);
        ans1.setText(answer1);
        String answer2 = setAnswer2(questionNumber);
        ans2.setText(answer2);
        String answer3 = setAnswer3(questionNumber);
        ans3.setText(answer3);
        String answer4 = setAnswer4(questionNumber);
        ans4.setText(answer4);
    }
    //Set answers for 1st radioButton
    public String setAnswer1(int questionNumber) {
        String[] questionAns1 = new String[4];
        questionAns1[0] = getString(R.string.left);
        questionAns1[1] = getString(R.string.Iditarod);
        questionAns1[2] = getString(R.string.greyster);
        questionAns1[3] = getString(R.string.rig);
        return questionAns1[questionNumber];
    }
    //Set answers for 2nd radioButton
    public String setAnswer2(int questionNumber) {
        String[] questionAns2 = new String[4];
        questionAns2[0] = getString(R.string.right);
        questionAns2[1] = getString(R.string.yukon_quest);
        questionAns2[2] = getString(R.string.alaskan_malamute);
        questionAns2[3] = getString(R.string.bikejoring);
        return questionAns2[questionNumber];
    }
    //Set answers for 3rd radioButton
    public String setAnswer3(int questionNumber) {
        String[] questionAns3 = new String[4];
        questionAns3[0] = getString(R.string.faster);
        ;
        questionAns3[1] = getString(R.string.all_alaska);
        questionAns3[2] = getString(R.string.samoyed);
        questionAns3[3] = getString(R.string.scooter);
        return questionAns3[questionNumber];
    }
    //Set answers for 4th radioButton
    public String setAnswer4(int questionNumber) {
        String[] questionAns4 = new String[4];
        questionAns4[0] = getString(R.string.slow_down);
        questionAns4[1] = getString(R.string.la_prene);
        questionAns4[2] = getString(R.string.siberian_husky);
        questionAns4[3] = getString(R.string.canicross);
        return questionAns4[questionNumber];
    }

    //This method add points depends of which button is checked.
    public int points() {
        int id = rg.getCheckedRadioButtonId();
        View radioB = rg.findViewById(id);
        int position = rg.indexOfChild(radioB);

        switch (position) {
            case 0:
                if (questionNumber == 0) {
                    score += 1;
                    break;
                }
                break;
            case 1:
                if (questionNumber == 3) {
                    score += 1;
                    break;
                }
                break;
            case 2:
                if (questionNumber == 1) {
                    score += 1;
                    break;
                }
                break;
            case 3:
                if (questionNumber == 2) {
                    score += 1;
                    break;
                }
                break;
        }
        return score;
    }

    //Method restarts quiz.
    public void restart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Method stops app.
    public void quit(View view) {
        finish();
    }
    //Method displays result screen.
    public void score(View view) {
        setContentView(R.layout.scores);
        TextView finalScore = findViewById(R.id.final_score);
        ProgressBar cds2 = findViewById(R.id.cds_bar2);
        TextView scoreDesc = findViewById(R.id.score_desc);
        finalScore.setText(String.valueOf(score));
        cds2.setProgress(score);
        //Set description for given scores.
        if (score < 5) {
            scoreDesc.setText(getString(R.string.mushing_poor));
        } else if (score >= 5 && score <= 10) {
            scoreDesc.setText(getString(R.string.mushing_little));
        } else if (score >= 11 && score <= 17) {
            scoreDesc.setText(getString(R.string.mushing_know_sth));
        } else if (score >= 18) {
            scoreDesc.setText(getString(R.string.are_you_musher));
        }
    }
}