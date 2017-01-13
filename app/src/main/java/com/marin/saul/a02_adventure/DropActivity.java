package com.marin.saul.a02_adventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DropActivity extends AppCompatActivity {

    @BindView(R.id.activity_drop_item_list) ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop);

        ButterKnife.bind(this);
    }
}
