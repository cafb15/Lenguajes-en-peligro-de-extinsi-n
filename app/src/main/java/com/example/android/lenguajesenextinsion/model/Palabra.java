package com.example.android.lenguajesenextinsion.model;

public class Palabra {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int pronunciation;
    private int imageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Palabra(String mDefaultTranslation, String mMiwokTranslation, int pronunciation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.pronunciation = pronunciation;
    }

    public Palabra(String mDefaultTranslation, String mMiwokTranslation, int imageResourceID, int pronunciation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.imageResourceID = imageResourceID;
        this.pronunciation = pronunciation;
    }

    public String getDefaultTraslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTraslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public int getPronunciation() {
        return pronunciation;
    }

    public boolean hasImage() {
        return imageResourceID != NO_IMAGE_PROVIDED;
    }
}