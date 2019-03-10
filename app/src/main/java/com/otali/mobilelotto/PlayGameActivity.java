package com.otali.mobilelotto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PlayGameActivity extends AppCompatActivity
{
    @Override
    public void onCreate(@Nullable Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.play_game_layout);

        Button closeButton = (Button) findViewById(R.id.close_main_play);
        final Intent MainActivityIntent = new Intent(PlayGameActivity.this, MainActivity.class);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivityIntent);
            }
        });

    }
}
