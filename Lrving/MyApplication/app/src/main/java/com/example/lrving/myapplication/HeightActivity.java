package com.example.lrving.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.NumberPicker;

public class HeightActivity extends AppCompatActivity {
    NumberPicker np_height;
    NumberPicker np_weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
        np_height= (NumberPicker) findViewById(R.id.np_height);
        np_weight= (NumberPicker) findViewById(R.id.np_weight);
        init();

    }
    private void init() {

        np_weight.setMaxValue(220);
        np_weight.setMinValue(20);
        np_weight.setValue(50);
        np_height.setMaxValue(220);
        np_height.setMinValue(50);
        np_height.setValue(160);
    }
}
