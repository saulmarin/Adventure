package com.marin.saul.a02_adventure.model;

import java.io.Serializable;
import java.util.LinkedList;

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



}
