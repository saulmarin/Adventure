package com.marin.saul.a02_adventure;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.JetPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.marin.saul.a02_adventure.model.Inventory;
import com.marin.saul.a02_adventure.model.Item;
import com.marin.saul.a02_adventure.model.MapGenerator;
import com.marin.saul.a02_adventure.model.Room;
import com.marin.saul.a02_adventure.util.Constants;
import com.marin.saul.a02_adventure.util.JetPlayerUtil;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_button_north) ImageButton moveNorth;
    @BindView(R.id.activity_main_button_east) ImageButton moveEast;
    @BindView(R.id.activity_main_button_west) ImageButton moveWest;
    @BindView(R.id.activity_main_button_south) ImageButton moveSouth;
    @BindView(R.id.activity_main_button_look) ImageButton lookButton;
    @BindView(R.id.activity_main_button_take) ImageButton takeButton;
    @BindView(R.id.activity_main_button_drop) ImageButton dropButton;
    @BindView(R.id.activity_main_button_inventory) ImageButton inventoryButton;
    @BindView(R.id.activity_main_button_help) ImageButton helpButton;
    @BindView(R.id.activity_main_scene_text) TextView roomDescription;
    @BindView(R.id.activity_main_scene_image) ImageView roomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Picasso.with(this).setIndicatorsEnabled(true);
        Picasso.with(this).setLoggingEnabled(true);

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
                Intent i = new Intent(MainActivity.this, ItemListActivity.class).putExtra(Constants.KEY_INTENT_TAKE_ITEM_FROM_ROOM, currentRoom);
                startActivityForResult(i, 2);
            }
        });
        dropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ItemListActivity.class).putExtra(Constants.KEY_INTENT_INVENTORY, inventory);
                startActivityForResult(i, 1);
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
        JetPlayerUtil.play(this, R.raw.jet);
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

        MapGenerator.generate(this);
        currentRoom = MapGenerator.initialRoom;

    }

    public void repaintScene(){
        roomDescription.setText(currentRoom.getDescription());
        Picasso.with(this).
                load(currentRoom.getImageUrl()).
                into(roomImage);

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

        //check for monster
        if ( currentRoom.getMonster() != null){
            Intent i = new Intent(MainActivity.this, FightMonsterActivity.class);
            i.putExtra("monster", currentRoom.getMonster());
            startActivity(i);
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
        if ( roomItems == null){
            roomText = roomText + "No hay nada en la sala...";
        }else {
            for (Item item : roomItems) {
                roomText = roomText + "<i>" + item.getName() + "</i><br>";
            }
        }
        Spanned sp = Html.fromHtml(roomText.toString());
        roomDescription.setText(sp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                int itemPosition = data.getIntExtra(Constants.KEY_INTENT_ITEM_LIST_POSITION, -1);

                Item item = inventory.getItem(itemPosition);
                currentRoom.getItems().add(item);
                inventory.deleteItem(itemPosition);
                Snackbar.make(roomDescription, getString(R.string.drop_item_text) + item.getName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        }
        if (requestCode == 2){
            if (resultCode == RESULT_OK){
                int itemPosition = data.getIntExtra(Constants.KEY_INTENT_ITEM_LIST_POSITION, -1);

                Item item = currentRoom.getItems().get(itemPosition);
                inventory.add(item);
                currentRoom.getItems().remove(itemPosition);
                Snackbar.make(roomDescription, "Coges " + item.getName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        }
    }
}
