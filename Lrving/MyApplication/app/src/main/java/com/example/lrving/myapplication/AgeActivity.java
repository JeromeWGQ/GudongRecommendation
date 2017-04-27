package com.example.lrving.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.NumberPicker;

public class AgeActivity extends AppCompatActivity{
    NumberPicker np_age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏

        np_age= (NumberPicker) findViewById(R.id.np_age);
        init();
    }



    private void init() {

        np_age.setMaxValue(100);
        np_age.setMinValue(1);
        np_age.setValue(18);
    }
}
