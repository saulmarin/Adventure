package com.marin.saul.a02_adventure.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by usuario on 20/12/2016.
 */
public class Inventory implements Serializable{
    private LinkedList<Item> inventory = new LinkedList<>();

    public Inventory(){

    }

    public String print(){
        String result = "Inventory:\n";
        for (Item item: inventory){
            result = result + item.getName()+ "\n";
        }
        return result;
    }

    public void add(Item item){
        inventory.add(item);
    }

    public LinkedList<Item> getItems(){
        return inventory;
    }

    public List<String> getItemNames(){
        List<String> names = new ArrayList<>();
        for (Item item: inventory){
            names.add(item.getName());
        }
        return names;
    }

    public Item getItem(int itemPosition) {
        return inventory.get(itemPosition);
    }

    public void deleteItem(int itemPosition) {
        inventory.remove(itemPosition);
    }
}
