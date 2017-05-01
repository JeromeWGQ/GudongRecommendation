package com.lrving.gudongfood.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //声明控件对象
    Button btn_show, btn_quit;
    EditText ed_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//加载布局文件
        setContentView(R.layout.main);
//        //获取TextView对象
//        TextView tv_show = (TextView) findViewById(R.id.tv_show);
//
//        //获取文本内容
//        String text = tv_show.getText().toString();
//
//        Log.i("lnb",text);
//
//        //吐司
//        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
//
//        //设定文本内容
//        tv_show.setText(R.string.app_name);
//        tv_show.setTextColor(getResources().getColor(R.color.colorPrimary));
        //拿到对象
        btn_show = (Button)findViewById(R.id.btn_show);
        //btn_quit = (Button) findViewById(R.id.btn_quit);
        //ed_search = (EditText) findViewById(R.id.ed_search);
        //注册监听器
//        btn_show.setOnClickListener(new View.OnClickListener() {//匿名内部类
//            @Override
//            public void onClick(View v) {
//                //相应
//                String text = "您点击了按钮";
//                Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
//                Log.i("lnb",text);
//
//            }
//        });
        btn_show.setOnClickListener(this);
        //btn_quit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*String text = ed_search.getText().toString();
        switch (v.getId()) {
            case R.id.btn_show:
                text = "按钮一";
                break;
            case R.id.btn_quit:
                text = "按钮二";
                break;
        }

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        Log.i("lnb", text);
        setContentView(R.layout.activity_main);*/

        Intent intent = new Intent(this, HobbiesActivity.class);
        startActivity(intent);
    }


//    public void btnClick(View v){
//        String text = "您点击了按钮?";
//        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
//        Log.i("lnb",text);
//    }
}
