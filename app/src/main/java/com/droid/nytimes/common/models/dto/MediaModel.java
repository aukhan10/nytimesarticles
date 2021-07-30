package com.droid.nytimes.common.models.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class MediaModel implements Serializable {

    @SerializedName("media-metadata")
    @Expose
    private ArrayList<ImageModel> imageUrls;

    public ArrayList<ImageModel> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<ImageModel> imageUrls) {
        this.imageUrls = imageUrls;
    }
}