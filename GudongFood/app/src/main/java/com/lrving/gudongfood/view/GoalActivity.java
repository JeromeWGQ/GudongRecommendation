package com.lrving.gudongfood.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.R;

import com.lrving.gudongfood.model.User;

public class GoalActivity extends AppCompatActivity {

    private Button btn_goalCancel, btn_goalOk;
    private RadioGroup rg_goal;
    private RadioButton rb_bodybuilding, rb_reduceWeight;
    private NumberPicker np_goalWeight, np_goalTime;
    private LinearLayout ll_goalWeight, ll_goalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ll_goalWeight = (LinearLayout) findViewById(R.id.ll_goalWeight);
        ll_goalTime = (LinearLayout) findViewById(R.id.ll_goalTime);
        rb_reduceWeight = (RadioButton) findViewById(R.id.rb_reduceWeight);
        rb_bodybuilding = (RadioButton) findViewById(R.id.rb_bodybuilding);
        //体重滑动框
        np_goalWeight = (NumberPicker) findViewById(R.id.np_goalWeight);
        np_goalWeight.setMinValue(20);
        np_goalWeight.setMaxValue(220);
        //np_goalTime.set
        //np_goalTime.value
        np_goalTime = (NumberPicker) findViewById(R.id.np_goalTime);
        np_goalTime.setMinValue(1);
        np_goalTime.setMaxValue(3);
        np_goalTime.setValue(2);
        if (User.goal == "减肥") {
            rb_reduceWeight.setChecked(true);
            np_goalWeight.setValue(Integer.parseInt(User.goal_weight));
            np_goalTime.setValue(Integer.parseInt(User.goal_time));
            ll_goalWeight.setVisibility(View.VISIBLE);
            ll_goalTime.setVisibility(View.VISIBLE);
        } else if (User.goal == "健身") {
            rb_bodybuilding.setChecked(true);
            np_goalWeight.setValue(60);
        }


        //根据选择显示滑动框
        rg_goal = (RadioGroup) findViewById(R.id.rg_goal);
        //radiobutton选中触发
        rg_goal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_bodybuilding) {
                    ll_goalWeight.setVisibility(View.INVISIBLE);
                    ll_goalTime.setVisibility(View.INVISIBLE);
                    User.goal = "健身";

                } else {
                    ll_goalWeight.setVisibility(View.VISIBLE);
                    ll_goalTime.setVisibility(View.VISIBLE);
                    User.goal = "减肥";
                }
            }
        });

        //按钮触发事件
        btn_goalCancel = (Button) findViewById(R.id.btn_goalCancel);
        btn_goalOk = (Button) findViewById(R.id.btn_goalOk);
        btn_goalCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_goalOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (User.goal == "减肥") {
                    User.goal_weight = String.valueOf(np_goalWeight.getValue());
                    User.goal_time = String.valueOf(np_goalTime.getValue() * 30);
                } else {
                    User.goal_weight = "";
                    User.goal_time = "";
                }
                finish();
            }
        });


    }

    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}
