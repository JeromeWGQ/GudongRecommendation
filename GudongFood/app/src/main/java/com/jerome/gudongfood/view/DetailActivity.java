package com.jerome.gudongfood.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //新页面接收数据
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        String menuName = bundle.getString("menuName");
        String menuDetailLong = bundle.getString("menuDetailLong");

//        TextView detailTitle = (TextView) findViewById(R.id.detailTitle);
        TextView detailText = (TextView) findViewById(R.id.detailText);

        detailText.setText(menuDetailLong);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this,EvaluateActivity.class);
                startActivity(intent);
            }
        });
    }
}
