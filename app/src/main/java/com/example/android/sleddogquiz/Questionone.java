package com.example.android.sleddogquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Questionone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionone);
        displayListView();
        DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById(R.id.container);
        // set all children draggable except the first (the header)
        for (int i = -1; i < dragLinearLayout.getChildCount(); i++) {
            View child = dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child); // the child is its own drag handle
        }
    }
    private void displayListView() {
        ArrayList<DogImage> dogImages = new ArrayList<DogImage>();
        //Create a list of images
        dogImages.add(new DogImage(R.drawable.swing));
        dogImages.add(new DogImage(R.drawable.lead));
        dogImages.add(new DogImage(R.drawable.team));
        dogImages.add(new DogImage(R.drawable.wheel));
        DogImagesAdapter adapter = new DogImagesAdapter(this, dogImages);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
