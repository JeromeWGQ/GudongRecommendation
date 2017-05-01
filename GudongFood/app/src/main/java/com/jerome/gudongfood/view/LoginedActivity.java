package com.jerome.gudongfood.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.R;

public class LoginedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logined);

        View buttonSubmit = findViewById(R.id.submitButton);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitEvent();
            }
        });

    }

    private void submitEvent() {

        CheckBox box1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox box2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox box3 = (CheckBox) findViewById(R.id.checkBox3);

        boolean[] result = new boolean[10];
        result[0] = box1.isChecked();
        result[1] = box2.isChecked();
        result[2] = box3.isChecked();

        String resultString = "Selected menu is ";

        for (int i = 0; i < 3; i++) {
            if (result[i]) {
                resultString += "menu" + (i + 1) + " ";
            }
        }

        Toast toast = Toast.makeText(getApplicationContext(), resultString, Toast.LENGTH_SHORT);
        toast.show();
    }
}
