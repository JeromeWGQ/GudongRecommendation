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

        Button buttonV1, buttonV2, buttonV3;
        buttonV1 = (Button) findViewById(R.id.buttonV1);
        buttonV2 = (Button) findViewById(R.id.buttonV2);
        buttonV3 = (Button) findViewById(R.id.buttonV3);

        Bundle bundle = this.getIntent().getExtras();
        final String v1 = bundle.getString("v1");
        final String v2 = bundle.getString("v2");
        final String v3 = bundle.getString("v3");
        buttonV1.setText(v1);
        buttonV2.setText(v2);
        buttonV3.setText(v3);

        buttonV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(v1);
            }
        });
        buttonV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(v2);
            }
        });
        buttonV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetail(v3);
            }
        });
    }

    private void switchToDetail(String vName){
        Intent intent = new Intent(this, VegetableDetailActivity.class);
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", vName);
        intent.putExtras(bundle1);
        startActivity(intent);
    }
}
