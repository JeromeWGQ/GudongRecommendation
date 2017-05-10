package com.lrving.gudongfood.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import com.R;

import com.lrving.gudongfood.model.User;

public class HeightActivity extends AppCompatActivity {
    private NumberPicker np_height;
    private NumberPicker np_weight;
    private Button btn_heightCancel, btn_heightOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        np_height = (NumberPicker) findViewById(R.id.np_height);
        np_weight = (NumberPicker) findViewById(R.id.np_weight);
        init();

        btn_heightCancel = (Button) findViewById(R.id.btn_heightCancel);
        btn_heightOk = (Button) findViewById(R.id.btn_heightOk);
        btn_heightCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_heightOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.weight = String.valueOf(np_weight.getValue());
                User.height = String.valueOf(np_height.getValue());
                finish();
            }
        });
    }

    private void init() {

        np_weight.setMaxValue(220);
        np_weight.setMinValue(20);
        np_weight.setValue(Integer.parseInt(User.weight));
        np_height.setMaxValue(220);
        np_height.setMinValue(50);
        np_height.setValue(Integer.parseInt(User.height));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}
