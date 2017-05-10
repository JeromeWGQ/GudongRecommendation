package com.jerome.gudongfood.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.jerome.gudongfood.dao.StepsUtil;
import com.jerome.gudongfood.gsonBeans.ReceiveVegetable;

public class VegetableDetailActivity extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle receiveBundle = this.getIntent().getExtras();
        String vName = receiveBundle.getString("name");
        setTitle(vName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mQueue = Volley.newRequestQueue(this);

        String url = "http://apis.haoservice.com/lifeservice/cook/query?menu=" + vName + "&pn=1&rn=1&key=7f9b2d5760f0407b9304101b913ff494";
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAG", "===================网络请求返回：" + s);
                        Gson gson = new Gson();
                        ReceiveVegetable rv = gson.fromJson(s, ReceiveVegetable.class);
                        StepsUtil.currentRV = rv;
                        if (rv.error_code.equals("0"))
                            fillData(rv);
                        else {
                            Toast toast = Toast.makeText(getApplicationContext(), "请求失败，请检查网络！", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
                Toast toast = Toast.makeText(getApplicationContext(), "请求失败，请检查网络！", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        mQueue.add(stringRequest);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VegetableDetailActivity.this, StepsActivity.class);
                startActivity(intent);
            }
        });
    }

    private AppBarLayout appBarLayout;

    /**
     * 根据获取的蔬菜信息向activity填充数据
     *
     * @param rv
     */
    private void fillData(ReceiveVegetable rv) {
        // 加载背景图片
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        // TODO: 2017/5/3 优化
        ImageRequest imageRequest = new ImageRequest(
                rv.result.get(0).albums,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        // TODO: 2017/5/3 不直接用构造方法
                        appBarLayout.setBackground(new BitmapDrawable(response));
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: 2017/5/3 添加一张加载失败的图片
            }
        });
        mQueue.add(imageRequest);

        TextView detailText = (TextView) findViewById(R.id.vegetableDetail);
        String fullDetail = "";
        fullDetail += "菜品名称:\n";
        fullDetail += rv.result.get(0).title + "\n\n";
        fullDetail += "标签:\n";
        fullDetail += rv.result.get(0).tags + "\n\n";
        fullDetail += "菜品简介:\n";
        fullDetail += rv.result.get(0).intro + "\n\n";
        fullDetail += "原料:\n";
        fullDetail += rv.result.get(0).ingredients + "\n\n";
        fullDetail += "菜品名称:\n";
        fullDetail += rv.result.get(0).burden + "\n\n";
        detailText.setText(fullDetail);
    }
}
