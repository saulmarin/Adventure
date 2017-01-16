package com.marin.saul.a02_adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


    }
}
