package com.android.example.kjsceinsignia;

public class cardEvents {
    String name;
    int image_id;
    int card;

    public cardEvents(String name, int image_id, int card, int index) {
        this.name = name;
        this.image_id = image_id;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public int getImage_id() {
        return image_id;
    }

    public int getCard() {
        return card;
    }
}
