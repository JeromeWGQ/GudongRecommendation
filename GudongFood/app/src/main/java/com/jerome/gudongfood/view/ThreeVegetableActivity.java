package com.jerome.gudongfood.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.R;

public class ThreeVegetableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_vegetable);

        Button buttonV1, buttonV2, buttonV3, buttonV4, buttonV5, buttonV6, buttonV7;
        buttonV1 = (Button) findViewById(R.id.buttonV1);
        buttonV2 = (Button) findViewById(R.id.buttonV2);
        buttonV3 = (Button) findViewById(R.id.buttonV3);
        buttonV4 = (Button) findViewById(R.id.buttonV4);
        buttonV5 = (Button) findViewById(R.id.buttonV5);
        buttonV6 = (Button) findViewById(R.id.buttonV6);
        buttonV7 = (Button) findViewById(R.id.buttonV7);

        Bundle bundle = this.getIntent().getExtras();
        final String b = bundle.getString("b");
        final String l1 = bundle.getString("l1");
        final String l2 = bundle.getString("l2");
        final String l3 = bundle.getString("l3");
        final String d1 = bundle.getString("d1");
        final String d2 = bundle.getString("d2");
        final String d3 = bundle.getString("d3");
        buttonV1.setText(b);
        buttonV2.setText(l1);
        buttonV3.setText(l2);
        buttonV4.setText(l3);
        buttonV5.setText(d1);
        buttonV6.setText(d2);
        buttonV7.setText(d3);

        buttonV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(b);
            }
        });
        buttonV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(l1);
            }
        });
        buttonV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(l2);
            }
        });
        buttonV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(l3);
            }
        });
        buttonV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(d1);
            }
        });
        buttonV6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(d2);
            }
        });
        buttonV7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(d3);
            }
        });
    }

    private void switchToDetail(String vName) {
        Intent intent = new Intent(this, VegetableDetailActivity.class);
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", vName);
        intent.putExtras(bundle1);
        startActivity(intent);
    }
}
