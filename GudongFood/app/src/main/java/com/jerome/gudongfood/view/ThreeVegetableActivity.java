package com.jerome.gudongfood.view;

import android.app.Activity;
import android.os.Bundle;
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
        buttonV1.setText(bundle.getString("v1"));
        buttonV2.setText(bundle.getString("v2"));
        buttonV3.setText(bundle.getString("v3"));

        // TODO: 2017/5/2 跳转到蔬菜详情页面
    }
}
