package com.doanbvph31058.th_intent;

public class bai1_School_model {

    private String name;
    private int img;

    public bai1_School_model(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public bai1_School_model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
