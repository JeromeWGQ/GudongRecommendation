package com.lrving.gudongfood.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;

import com.R;
import com.lrving.gudongfood.model.User;

public class SexActivity extends AppCompatActivity {

    private Button btn_sexCancel, btn_sexOk;
    private RadioButton rb_male, rb_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏

        rb_female = (RadioButton) findViewById(R.id.rb_female);
        rb_male = (RadioButton) findViewById(R.id.rb_male);
        if (User.sex == "男")
            rb_male.setChecked(true);
        else
            rb_female.setChecked(true );
        rb_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.sex = "女";
            }
        });
        rb_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.sex = "男";
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
}
