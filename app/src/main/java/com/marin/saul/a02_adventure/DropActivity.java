package com.marin.saul.a02_adventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DropActivity extends AppCompatActivity {

    @BindView(R.id.activity_drop_item_list) ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_drop);

        ButterKnife.bind(this);
    }
}
