package com.marin.saul.a02_adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.view.Window;
=======
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
>>>>>>> feature/Drop_function
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
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_drop);

        ButterKnife.bind(this);

        Intent i  = getIntent();
        inventory = (Inventory) i.getSerializableExtra(Constants.KEY_INTENT_INVENTORY);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, inventory.getItemNames());
        itemList.setAdapter(adapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View row, int position, long id) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constants.KEY_INTENT_DROP_ITEM_POSITION, position);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
