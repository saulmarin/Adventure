package com.marin.saul.a02_adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.marin.saul.a02_adventure.model.Inventory;
import com.marin.saul.a02_adventure.model.InventoryManager;
import com.marin.saul.a02_adventure.model.Item;
import com.marin.saul.a02_adventure.model.MapGenerator;
import com.marin.saul.a02_adventure.model.Room;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ImageButton helpButton;
    TextView roomDescription;
    ImageView roomImage;

    ImageButton moveNorth;
    ImageButton moveEast;
    ImageButton moveWest;
    ImageButton moveSouth;
    ImageButton lookButton;
    ImageButton takeButton;
    ImageButton dropButton;
    ImageButton inventoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveNorth = (ImageButton) findViewById(R.id.activity_main_button_north);
        moveEast = (ImageButton) findViewById(R.id.activity_main_button_east);
        moveWest = (ImageButton) findViewById(R.id.activity_main_button_west);
        moveSouth = (ImageButton) findViewById(R.id.activity_main_button_south);
        lookButton = (ImageButton) findViewById(R.id.activity_main_button_look);
        takeButton = (ImageButton) findViewById(R.id.activity_main_button_take);
        dropButton = (ImageButton) findViewById(R.id.activity_main_button_drop);
        inventoryButton = (ImageButton) findViewById(R.id.activity_main_button_inventory);
        helpButton = (ImageButton) findViewById(R.id.activity_main_button_help);
        roomDescription = (TextView) findViewById(R.id.activity_main_scene_text);
        roomImage = (ImageView) findViewById(R.id.activity_main_scene_image);


        moveNorth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRoom = currentRoom.getRoomNorth();
                repaintScene();
            }
        });
        moveEast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRoom = currentRoom.getRoomEast();
                repaintScene();
            }
        });
        moveWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRoom = currentRoom.getRoomWest();
                repaintScene();
            }
        });
        moveSouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRoom = currentRoom.getRoomSouth();
                repaintScene();
            }
        });
        lookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lookRoom();
            }
        });
        takeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InventoryManager.take(currentRoom,inventory,"Mapa");
            }
        });
        dropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InventoryManager.drop(currentRoom,inventory,"Mapa");
            }
        });
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInventory();
            }
        });
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(i);
            }
        });


        initGame();
        repaintScene();
    }

    Inventory inventory = new Inventory();
    Room currentRoom;
    private void initGame(){

        Item sword = new Item("Espada de madera","Una espada que no sirve para mucho.");
        Item shield = new Item("Escudo de madera","Escudo inutil.");
        Item rubberChiken = new Item("Pollo de goma","Puede que te salve la vida algun dia.");

        inventory.add(sword);
        inventory.add(shield);
        inventory.add(rubberChiken);

        MapGenerator.generate();
        currentRoom = MapGenerator.initialRoom;

    }

    public void repaintScene(){
        roomDescription.setText(currentRoom.getDescription());
        String sceneImage = currentRoom.getImage();
        int id = getResources().getIdentifier(sceneImage, "drawable", getPackageName());
        roomImage.setImageResource(id);

        if (currentRoom.getRoomNorth() != null){
            moveNorth.setVisibility(View.VISIBLE);
        }else{
            //no room
            moveNorth.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomEast() != null){
            moveEast.setVisibility(View.VISIBLE);
        }else{
            //no room
            moveEast.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomWest() != null){
            moveWest.setVisibility(View.VISIBLE);
        }else{
            //no room
            moveWest.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomSouth() != null){
            moveSouth.setVisibility(View.VISIBLE);
        }else{
            //no room
            moveSouth.setVisibility(View.INVISIBLE);
        }
    }

    public void showInventory() {
        String inventoryText = inventory.print();
        roomDescription.setText(inventoryText);
    }

    public void lookRoom(){
        String roomText = "";
        roomText = roomText + currentRoom.getDescription() + "\n";

        LinkedList<Item> roomItems = currentRoom.getItems();
        for (Item item: roomItems){
            roomText = roomText + item.getName()+ "\n";
        }

        roomDescription.setText(roomText);
    }
}
