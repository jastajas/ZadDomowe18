package com.example.demo;

public class Animal {

    private String name;
    private String category;
    private String picture;

    public Animal() {
    }

    public Animal(String name, String category, String picture) {
        this.name = name;
        this.category = category;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
