package com.example.lrving.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lrving.myapplication.R;
import com.example.lrving.myapplication.model.User;

public class NameActivity extends AppCompatActivity {

    private Button btn_nameCancel, btn_nameOk;
    private EditText et_name;
    private TextView tv_nameLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);


        et_name = (EditText) findViewById(R.id.et_name);
        et_name.setText(User.name);
        tv_nameLength = (TextView) findViewById(R.id.tv_nameLength);
        int length = et_name.getText().length();
        tv_nameLength.setText("还可输入" + (24 - length) + "个字符");
        btn_nameCancel = (Button) findViewById(R.id.btn_nameCancel);
        btn_nameOk = (Button) findViewById(R.id.btn_nameOk);
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
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = et_name.getText().length();
                tv_nameLength.setText("还可输入" + (24 - length) + "个字符");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
