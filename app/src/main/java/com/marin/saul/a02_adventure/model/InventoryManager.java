package com.marin.saul.a02_adventure.model;

import java.util.LinkedList;

/**
 * Created by usuario on 23/12/2016.
 */
public class InventoryManager {

    public static void take(Room room, Inventory inventory, String nameOfthingToTake){
        if (room.getItems() == null){
            System.out.println("Esta vacia");
            return;
        }
         Item itemFound = null;
        for (Item item: room.getItems()){
            if (item.getName().equalsIgnoreCase(nameOfthingToTake)){
                itemFound = item;
            }
        }
        if (itemFound == null){
            System.out.println("no se ha encontrado nada");
        }else{
            inventory.add(itemFound);
            room.getItems().remove(itemFound);
            System.out.println("Obtienes: " + itemFound.getName());
        }

    }

    public static void drop(Room room, Inventory inventory, String nameOfthingToTake){
        if (inventory.getItems() == null){
            System.out.println("Esta vacia");
            return;
        }
        Item itemFound = null;
        for (Item item: inventory.getItems()){
            if (item.getName().equalsIgnoreCase(nameOfthingToTake)){
                itemFound = item;
            }
        }
        if (itemFound == null){
            System.out.println("no hay objeto");
        }else{
            inventory.getItems().remove(itemFound);
            if(room.getItems() == null){
                room.setItems(new LinkedList<Item>());
            }
            room.getItems().addLast(itemFound);
            System.out.println("Sueltas: " + itemFound.getName());
        }


    }
}
