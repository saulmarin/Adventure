package com.marin.saul.a02_adventure.model;

import java.util.LinkedList;


public class MapGenerator {
    public static Room initialRoom;

    public static void  generate(){
        Room room1 = new Room();
        room1.setDescription("[ROOM 1]Te encuentras en una habitacion vacia,que inpira poca seguridad...");

        Room room2 = new Room();
        room2.setDescription("[ROOM 2]Ves una habitacion sombría,con un aire misterioso...");

        Room room3 = new Room();
        room3.setDescription("[ROOM 3]Llegas a una habitacion bastante normal...o eso parece...");

        Room room4 = new Room();
        room4.setDescription("[ROOM 4]habitacion con un letrero que pone 4");

        room1.setRoomSouth(room2);
        room2.setRoomNorth(room1);

        room1.setRoomEast(room4);
        room4.setRoomWest(room1);
        room4.setRoomSouth(room3);
        room3.setRoomNorth(room4);

        room2.setRoomEast(room3);
        room3.setRoomWest(room2);

        LinkedList<Item> itemsRoom3 = new LinkedList<>();
        itemsRoom3.add(new Item("Piedra","Pues eso...una simple piedra \n"));
        itemsRoom3.add(new Item("Mapa","Mapa mohoso al que le falta la otra mitad \n"));
        itemsRoom3.add(new Item("Llave","Quizás aun funcione...\n"));
        room3.setItems(itemsRoom3);

        room1.setImage("room1");
        room2.setImage("room2");
        room3.setImage("room3");
        room4.setImage("room4");


        initialRoom = room1;

    }
}
