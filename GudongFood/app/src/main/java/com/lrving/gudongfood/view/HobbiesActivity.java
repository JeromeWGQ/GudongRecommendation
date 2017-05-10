package com.lrving.gudongfood.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.R;

import com.lrving.gudongfood.model.User;

public class HobbiesActivity extends AppCompatActivity {

    private Button btn_hobbiesCancel, btn_hobbiesOk;
    private CheckBox cb_run, cb_riding, cb_soccor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        cb_riding = (CheckBox) findViewById(R.id.cb_riding);
        cb_run = (CheckBox) findViewById(R.id.cb_run);
        cb_soccor = (CheckBox) findViewById(R.id.cb_soccer);
        if (User.hobby == "跑步") {
            cb_run.setChecked(true);
        } else if (User.hobby == "骑行") {
            cb_riding.setChecked(true);
        } else {
            cb_soccor.setChecked(true);
        }
        cb_soccor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb_run.setChecked(false);
                cb_riding.setChecked(false);
                User.hobby = "足球";
            }
        });
        cb_riding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb_run.setChecked(false);
                cb_soccor.setChecked(false);
                User.hobby = "骑行";
            }
        });
        cb_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb_soccor.setChecked(false);
                cb_riding.setChecked(false);
                User.hobby = "跑步";
            }
        });
        btn_hobbiesCancel = (Button) findViewById(R.id.btn_hobbiesCancel);
        btn_hobbiesOk = (Button) findViewById(R.id.btn_hobbiesOk);
        btn_hobbiesCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_hobbiesOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}
