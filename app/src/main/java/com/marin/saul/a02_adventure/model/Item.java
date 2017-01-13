package com.marin.saul.a02_adventure.model;


import java.io.Serializable;

public class Item implements Serializable{
    private  String name;
    private  String description;

    public Item(){

    }
    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return  "\n" + getName() + "\n" + getDescription() + "\n";
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
}
