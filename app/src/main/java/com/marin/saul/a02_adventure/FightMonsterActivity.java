package com.marin.saul.a02_adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.marin.saul.a02_adventure.model.Monster;
import com.marin.saul.a02_adventure.model.Player;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FightMonsterActivity extends AppCompatActivity {

    @BindView(R.id.activity_fight_monster_monster_image)ImageView monsterImage;
    @BindView(R.id.activity_fight_monster_monster_name)TextView monsterName;
    @BindView(R.id.activity_fight_monster_monster_description)TextView monsterDescription;
    @BindView(R.id.activity_fight_monster_monster_life)TextView monsterLife;
    @BindView(R.id.activity_fight_monster_player_life)TextView playerLife;
    @BindView(R.id.activity_fight_monster_fight_button)Button fightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_monster);
        ButterKnife.bind(this);

        Intent i = getIntent();
        final Monster monster = (Monster) i.getSerializableExtra("monster");
        monsterName.setText(monster.getName());
        monsterDescription.setText(monster.getDescription());
        Picasso.with(this).load(monster.getImageUrl()).into(monsterImage);
        monsterLife.setText("" + monster.getHealthPoints());

        final Player player = (Player) i.getSerializableExtra("player");
        playerLife.setText("" + player.getHealthPoints());

        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int monsterAttack = monster.attack();
                int playerAttack = player.attack();

                player.setHealthPoints(player.getHealthPoints() - monsterAttack);
                monster.setHealthPoints(monster.getHealthPoints() - playerAttack);

                playerLife.setText("" + player.getHealthPoints());
                monsterLife.setText("" + monster.getHealthPoints());
            }
        });


    }
}
