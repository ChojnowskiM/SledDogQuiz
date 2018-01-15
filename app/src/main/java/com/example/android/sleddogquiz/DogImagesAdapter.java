package com.example.android.sleddogquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.mobeta.android.dslv.DragSortListView;

import java.util.ArrayList;

/**
 * Created by Misiek on 20.12.2017.
 */

public class DogImagesAdapter extends ArrayAdapter<DogImage> {
    /**
     * Create a new {@link DogImagesAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param dogImages is the list of {@link DogImage}s to be displayed.
     */
    public DogImagesAdapter(Context context, ArrayList<DogImage> dogImages) {
        super(context, 0, dogImages);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View DragSortListView = convertView;
        if (DragSortListView == null) {
            DragSortListView = LayoutInflater.from(getContext()).inflate(
                    R.layout.question1, parent, false);
        }
        DogImage currentDogImage = getItem(position);
        ImageView imageView = (ImageView) DragSortListView.findViewById(R.id.image);
        imageView.setImageResource(currentDogImage.getDogImageId());
        return DragSortListView;
    }
}
