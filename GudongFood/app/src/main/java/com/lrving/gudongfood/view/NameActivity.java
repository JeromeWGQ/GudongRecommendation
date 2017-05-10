package com.lrving.gudongfood.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.R;
import com.lrving.gudongfood.model.User;

public class NameActivity extends AppCompatActivity {

    private Button btn_nameCancel,btn_nameOk;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        et_name = (EditText) findViewById(R.id.et_name);
        et_name.setText(User.name);
        btn_nameCancel = (Button) findViewById(R.id.btn_nameCancel);
        btn_nameOk= (Button) findViewById(R.id.btn_nameOk);
        btn_nameCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_nameOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.name = String.valueOf(et_name.getText());
                finish();
            }
        });
    }
}
