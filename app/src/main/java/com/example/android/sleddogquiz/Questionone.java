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
    private void displayListView() {
        dogImages = new ArrayList<DogImage>();
        adapter = new DogImagesAdapter(this, dogImages);
        //Create a list of images
        dogImages.add(new DogImage(R.drawable.swing));
        dogImages.add(new DogImage(R.drawable.lead));
        dogImages.add(new DogImage(R.drawable.team));
        dogImages.add(new DogImage(R.drawable.wheel));
        DragSortListView dragSortListView = (DragSortListView) findViewById(R.id.list);
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
        im1 = dogImages.lastIndexOf(R.drawable.wheel);
        im2 = dogImages.indexOf(R.drawable.team);
        im3 = dogImages.indexOf(R.drawable.swing);
        im4 = dogImages.indexOf(R.drawable.lead);
        if (im1 == 0 && im2 == 1 && im3 == 2 && im4 == 3) {
            score += 1;
        } else {
            score = score + 0;
        }
        Log.v("test", "działa" + score + "id to" + im1 + im2 + im3 + im4);
    }
}
