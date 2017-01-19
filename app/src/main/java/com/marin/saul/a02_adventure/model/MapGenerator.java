package com.marin.saul.a02_adventure.model;

import android.content.Context;

import com.marin.saul.a02_adventure.R;

import java.util.LinkedList;


public class MapGenerator {
    public static Room initialRoom;

    public static void  generate(Context context){
        Room room1 = new Room();
        room1.setDescription(context.getString(R.string.room_desc1));

        Room room2 = new Room();
        room2.setDescription(context.getString(R.string.room_desc2));

        Room room3 = new Room();
        room3.setDescription(context.getString(R.string.room_desc3));

        Room room4 = new Room();
        room4.setDescription(context.getString(R.string.room_desc4));

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

        room1.setImageUrl(context.getString(R.string.room_img1));
        room2.setImageUrl(context.getString(R.string.room_img2));
        room3.setImageUrl(context.getString(R.string.room_img3));
        room4.setImageUrl(context.getString(R.string.room_img4));

        room2.setMonster(new Monster("Un chalao", "Sin tele ni cerveza Homer pierde la cabeza.","http://statics.viralizalo.com/virs/2016/01/VIR_99225_8407_que_tan_loco_estas.jpg?cb=98918"));

        initialRoom = room1;

    }
}
