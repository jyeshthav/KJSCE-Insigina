package com.android.example.kjsceinsignia;

public class Image {
    int id;
    byte[] bytes;
    String name;

    public Image(){ }

    public Image(byte[] bytes, String name){
        this.bytes = bytes;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

