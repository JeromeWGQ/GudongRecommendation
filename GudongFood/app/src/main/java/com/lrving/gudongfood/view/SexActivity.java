package com.lrving.gudongfood.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.R;
import com.lrving.gudongfood.model.User;

public class SexActivity extends AppCompatActivity {

    private Button btn_sexCancel, btn_sexOk;
    private RadioButton rb_male, rb_female;

    //private LinearLayout ll_sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rb_female = (RadioButton) findViewById(R.id.rb_female);
        rb_male = (RadioButton) findViewById(R.id.rb_male);
        if (User.sex == "0")
            rb_male.setChecked(true);
        else
            rb_female.setChecked(true);
//        ll_sex= (LinearLayout) findViewById(R.id.ll_sex);
//        ll_sex.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        rb_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.sex = "1";
            }
        });
        rb_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.sex = "0";
            }
        });
        btn_sexCancel = (Button) findViewById(R.id.btn_sexCancel);
        btn_sexOk = (Button) findViewById(R.id.btn_sexOk);
        btn_sexCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_sexOk.setOnClickListener(new View.OnClickListener() {
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
