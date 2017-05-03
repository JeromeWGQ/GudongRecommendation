package com.jerome.gudongfood.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.R;

public class SportResultActivity extends AppCompatActivity {

    private View clickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_result);

        clickButton = findViewById(R.id.seeMenuButton);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked();
            }
        });

    }

    private void clicked() {
        Intent intent = new Intent(this, MenuListActivity.class);
        startActivity(intent);
        finish();
    }
}
