package com.jerome.gudongfood.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jerome.gudongfood.R;

public class EvaluateActivity extends AppCompatActivity {

    // TODO: 2016/12/18 提交评价可以发出网络请求
    // TODO: 2016/12/18 查看地图可以连接到api

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        Button evaButton = (Button) findViewById(R.id.buttonSubmitEvaluate);
        evaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluate();
            }
        });

        Button mapButton = (Button) findViewById(R.id.buttonShowMap);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToMap();
            }
        });

    }

    private void evaluate() {
        EditText eText = (EditText) findViewById(R.id.editText);

        Toast toast = Toast.makeText(getApplicationContext(), "已提交：" + eText.getText(), Toast.LENGTH_SHORT);
        toast.show();
    }

    private void switchToMap() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        finish();
    }
}
