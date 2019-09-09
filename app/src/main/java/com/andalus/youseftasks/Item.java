package com.andalus.youseftasks;

public class Item {
    private int image;
    private String text;

    Item(int image, String text) {
        this.image = image;
        this.text = text;
    }
    Item(){}

    int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
