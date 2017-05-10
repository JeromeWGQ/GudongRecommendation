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

public class AgeActivity extends AppCompatActivity {
    private NumberPicker np_age;
    private Button btn_ageCancel, btn_ageOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        np_age = (NumberPicker) findViewById(R.id.np_age);
        //初始化滑动框
        np_age.setMaxValue(100);
        np_age.setMinValue(1);
        np_age.setValue(Integer.parseInt(User.age));
        btn_ageCancel = (Button) findViewById(R.id.btn_ageCancel);
        btn_ageOk = (Button) findViewById(R.id.btn_ageOk);
        btn_ageCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_ageOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.age = String.valueOf(np_age.getValue());
                finish();
            }
        });


    }

    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }


}