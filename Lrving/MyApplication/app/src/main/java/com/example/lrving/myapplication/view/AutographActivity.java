package com.example.lrving.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.lrving.myapplication.R;
import com.example.lrving.myapplication.model.User;

public class AutographActivity extends AppCompatActivity {
    private Button btn_autographCancel,btn_autographOk;
    private EditText et_autograph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autograph);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏

        et_autograph = (EditText) findViewById(R.id.et_autograph);
        et_autograph.setText(User.autograph);
        btn_autographCancel = (Button) findViewById(R.id.btn_autographCancel);
        btn_autographOk= (Button) findViewById(R.id.btn_autographOk);
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
    }
}
