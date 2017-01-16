package com.marin.saul.a02_adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.marin.saul.a02_adventure.model.Inventory;
import com.marin.saul.a02_adventure.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DropActivity extends AppCompatActivity {

    @BindView(R.id.activity_drop_item_list) ListView itemList;

    Inventory inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop);

        ButterKnife.bind(this);

        Intent i  = getIntent();
        inventory = (Inventory) i.getSerializableExtra(Constants.KEY_INTENT_INVENTORY);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, inventory.getItemNames());
        itemList.setAdapter(adapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
