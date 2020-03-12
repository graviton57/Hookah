package com.bshtef.hookah.data.model;

import java.util.List;

public class Hookah {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private int price;
    private int pipeLength;
    private int height;                                                      // thinking about that
    private int mouthpieceCount;
    private int coalCount;
    private boolean forceps;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPipeLength() {
        return pipeLength;
    }

    public void setPipeLength(int pipeLength) {
        this.pipeLength = pipeLength;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMouthpieceCount() {
        return mouthpieceCount;
    }

    public void setMouthpieceCount(int mouthpieceCount) {
        this.mouthpieceCount = mouthpieceCount;
    }

    public int getCoalCount() {
        return coalCount;
    }

    public void setCoalCount(int coalCount) {
        this.coalCount = coalCount;
    }

    public boolean isForceps() {
        return forceps;
    }

    public void setForceps(boolean forceps) {
        this.forceps = forceps;
    }
}
