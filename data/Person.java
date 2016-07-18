package com.example.jyw.samplelist_practice.data;

import android.graphics.drawable.Drawable;

/**
 * Created by JYW on 2016-07-17.
 */
public class Person {
    private String name;
    private int age;
    private Drawable picture;

    public Person() {}
    public Person(String name, int age, Drawable picture) {
        this.name = name;
        this.age = age;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }
}
