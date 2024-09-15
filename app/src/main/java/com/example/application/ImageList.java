package com.example.application;

public class ImageList
{
    private String imageURL;
    public ImageList(String imageUrl)
    {
        this.imageURL=imageUrl;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
