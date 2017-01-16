package com.marin.saul.a02_adventure.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Room implements Serializable{
    private  String description;
    private String image;
    private String imageUrl;


    private LinkedList<Item> items;

        private Room roomNorth;
        private Room roomEast;
        private Room roomWest;
        private Room roomSouth;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Item> getItems() {
        if (items == null){
            items = new LinkedList<>();
        }
        return items;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }

    public Room getRoomNorth() {
        return roomNorth;
    }

    public void setRoomNorth(Room roomNorth) {
        this.roomNorth = roomNorth;
    }

    public Room getRoomEast() {
        return roomEast;
    }

    public void setRoomEast(Room roomEast) {
        this.roomEast = roomEast;
    }

    public Room getRoomWest() {
        return roomWest;
    }

    public void setRoomWest(Room roomWest) {
        this.roomWest = roomWest;
    }

    public Room getRoomSouth() {
        return roomSouth;
    }

    public void setRoomSouth(Room roomSouth) {
        this.roomSouth = roomSouth;
    }

    public List<String> getItemNames(){
        List<String> names = new ArrayList<>();
        for (Item item: items){
            names.add(item.getName());
        }
        return names;
    }
}
