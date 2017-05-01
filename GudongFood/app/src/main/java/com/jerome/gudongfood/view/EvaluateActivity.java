package com.jerome.gudongfood.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.R;

public class EvaluateActivity extends AppCompatActivity {

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
