package com.example.aplikasisenibudaya;

public class ClassDetailContent {

    String name;
    String description;
    String image;
    String video;

    public ClassDetailContent(String name, String description, String image, String video) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.video = video;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getVideo() {
        return video;
    }
}
