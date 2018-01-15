package com.example.android.sleddogquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.mobeta.android.dslv.DragSortListView;
import java.util.ArrayList;
import java.util.List;

public class Questionone extends AppCompatActivity {
    public int score = 0;
    //images for question 1
    private int im1, im2, im3, im4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionone);
        displayListView();
    }
    ArrayList<DogImage> dogImages;
    DogImagesAdapter adapter;
    DogImage swing = new DogImage(R.drawable.swing);
    DogImage lead = new DogImage(R.drawable.lead);
    DogImage team = new DogImage(R.drawable.team);
    DogImage wheel = new DogImage(R.drawable.wheel);
    private void displayListView() {
        dogImages = new ArrayList<DogImage>();
        adapter = new DogImagesAdapter(this, dogImages);
        //Create a list of images

        dogImages.add(swing);
        dogImages.add(lead);
        dogImages.add(team);
        dogImages.add(wheel);
        DragSortListView dragSortListView = findViewById(R.id.list);
        dragSortListView.setAdapter(adapter);
        dragSortListView.setScrollbarFadingEnabled(false);
        dragSortListView.setDropListener(new DragSortListView.DropListener() {
            @Override public void drop(int from, int to) {
                DogImage movedItem = dogImages.get(from);
                dogImages.remove(from);
                if (from > to) --from;
                dogImages.add(to, movedItem);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void firstQ(View view) {
        im1 = dogImages.indexOf(wheel);
        im2 = dogImages.indexOf(team);
        im3 = dogImages.indexOf(swing);
        im4 = dogImages.indexOf(lead);
        if (im1 == 0 && im2 == 1 && im3 == 2 && im4 == 3) {
            score += 1;
        } else {
            score = score + 0;
        }
        Log.v("test", "działa" + score + "id to" + im1 + im2 + im3 + im4);
    }
}
