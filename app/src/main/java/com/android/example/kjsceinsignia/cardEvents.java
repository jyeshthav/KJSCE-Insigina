package com.android.example.kjsceinsignia;

public class cardEvents {
    String name;
    int image_id;
    int year;
    int event;

    public cardEvents(String name, int image_id, int year, int event) {
        this.name = name;
        this.image_id = image_id;
        this.year = year;
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public int getImage_id() {
        return image_id;
    }

    public int getYear() {
        return year;
    }

    public int getEvent() {
        return event;
    }
}
