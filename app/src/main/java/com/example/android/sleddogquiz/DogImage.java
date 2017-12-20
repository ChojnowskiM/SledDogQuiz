package com.example.android.sleddogquiz;

/**
 * Created by Misiek on 20.12.2017.
 */

public class DogImage {
    private int mDogImageId;

    public DogImage (int dogImageId) {
        mDogImageId = dogImageId;
    }
    /**
     * Return the image resource ID of the word.
     */
    public int getDogImageId() {
        return mDogImageId;
    }
}
