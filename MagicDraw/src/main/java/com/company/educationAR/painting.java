package com.company.educationAR;

public class painting {
    private String name;
    private int imageId;

    public painting(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
