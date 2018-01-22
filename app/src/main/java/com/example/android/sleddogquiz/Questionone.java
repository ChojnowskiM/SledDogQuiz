package com.example.android.sleddogquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mobeta.android.dslv.DragSortListView;

import java.util.ArrayList;
import java.util.Collections;

public class Questionone extends AppCompatActivity {
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    ArrayList<DogImage> dogImages;
    DogImagesAdapter adapter;
    DogImage swing = new DogImage(R.drawable.swing);
    DogImage lead = new DogImage(R.drawable.lead);
    DogImage team = new DogImage(R.drawable.team);
    DogImage wheel = new DogImage(R.drawable.wheel);
    private long mBackPressed;
    private int score = 0;
    //images for question 1
    private int im1, im2, im3, im4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionone);
        displayListView();
    }
    //Displays draggable elements of ArrayList @DogImages.
    private void displayListView() {
        dogImages = new ArrayList<DogImage>();
        adapter = new DogImagesAdapter(this, dogImages);
        //Create a list of images

        dogImages.add(swing);
        dogImages.add(lead);
        dogImages.add(team);
        dogImages.add(wheel);
        Collections.shuffle(dogImages);
        DragSortListView dragSortListView = findViewById(R.id.list);
        dragSortListView.setAdapter(adapter);
        dragSortListView.setScrollbarFadingEnabled(false);
        dragSortListView.setDropListener(new DragSortListView.DropListener() {
            @Override
            public void drop(int from, int to) {
                DogImage movedItem = dogImages.get(from);
                dogImages.remove(from);
                if (from > to) --from;
                dogImages.add(to, movedItem);
                adapter.notifyDataSetChanged();
            }
        });
    }
    /*Returns position of each elements when user click on "next button" and adds scores.
    */
    public void nextQuestion(View view) {
        im1 = dogImages.indexOf(wheel);
        im2 = dogImages.indexOf(team);
        im3 = dogImages.indexOf(swing);
        im4 = dogImages.indexOf(lead);
        if (im1 == 0) {
            score += 1;
        }
        if (im2 == 1) {
            score += 1;
        }
        if (im3 == 2) {
            score += 1;
        }
        if (im4 == 3) {
            score += 1;
        }
        /*Returns show Toast meesage with actual scores.
        */
        Toast toast = Toast.makeText(this, getString(R.string.scores) + score, Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, QuestionTwo.class);
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
