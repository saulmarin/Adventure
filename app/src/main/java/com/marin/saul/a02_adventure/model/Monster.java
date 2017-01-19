package com.marin.saul.a02_adventure.model;

import java.io.Serializable;
import java.util.Random;


public class Monster implements Serializable{

    private String name;
    private String description;
    private String imageUrl;
    private int healthPoints;

    public Monster(String name, String description, String imageUrl, int healthPoints) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int attack(){
        Random random = new Random();
        return random.nextInt(20);
    }
}
