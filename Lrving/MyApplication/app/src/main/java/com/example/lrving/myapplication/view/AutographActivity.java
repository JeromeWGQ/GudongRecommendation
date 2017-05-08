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

public class AutographActivity extends AppCompatActivity {
    private Button btn_autographCancel, btn_autographOk;
    private EditText et_autograph;
    private TextView tv_autographLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autograph);

        et_autograph = (EditText) findViewById(R.id.et_autograph);
        et_autograph.setText(User.autograph);
        tv_autographLength = (TextView) findViewById(R.id.tv_autographLength);
        int length = et_autograph.getText().length();
        tv_autographLength.setText("还可输入" + (100 - length) + "个字符");
        btn_autographCancel = (Button) findViewById(R.id.btn_autographCancel);
        btn_autographOk = (Button) findViewById(R.id.btn_autographOk);
        btn_autographCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_autographOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.autograph = String.valueOf(et_autograph.getText());
                finish();
            }
        });
        et_autograph.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = et_autograph.getText().length();
                tv_autographLength.setText("还可输入" + (100 - length) + "个字符");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
