package com.example.lrving.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
    //初始化按钮控件
    Button btn_editPortrait,btn_editName,btn_editSex,btn_editAge,btn_editHobbies,
            btn_editAutograph,btn_editGoal,btn_editHeight,btn_editWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏

        //获取按钮控件
        btn_editPortrait = (Button) findViewById(R.id.btn_editPortrait);
        btn_editName = (Button) findViewById(R.id.btn_editName);
        btn_editSex = (Button) findViewById(R.id.btn_editSex);
        btn_editAge = (Button) findViewById(R.id.btn_editAge);
        btn_editHobbies = (Button) findViewById(R.id.btn_editHobbies);
        btn_editAutograph = (Button) findViewById(R.id.btn_editAutograph);
        btn_editGoal = (Button) findViewById(R.id.btn_editGoal);
        btn_editHeight = (Button) findViewById(R.id.btn_editHeight);
        btn_editWeight = (Button) findViewById(R.id.btn_editWeight);

        //按下头像修改跳转到头像界面
        btn_editPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HobbiesActivity.class);
                startActivity(intent);
            }
        });

        //按下昵称修改跳转到昵称界面
        btn_editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, NameActivity.class);
                startActivity(intent);
            }
        });

        //按下年龄修改跳转到年龄界面
        btn_editAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AgeActivity.class);
                startActivity(intent);
            }
        });

        //按下兴趣修改跳转到兴趣界面
        btn_editHobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HobbiesActivity.class);
                startActivity(intent);
            }
        });

        //按下个性签名修改跳转到个性签名界面
        btn_editAutograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AutographActivity.class);
                startActivity(intent);
            }
        });

        //按下运动目的修改跳转到运动目的界面
        btn_editGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, GoalActivity.class);
                startActivity(intent);
            }
        });

        //按下性别修改跳转到行呗界面
        btn_editSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SexActivity.class);
                startActivity(intent);
            }
        });

        //按下身高修改跳转到身高界面
        btn_editHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HeightActivity.class);
                startActivity(intent);
            }
        });

        //按下体重修改跳转到体重界面
        btn_editWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HeightActivity.class);
                startActivity(intent);
            }
        });


    }
}
