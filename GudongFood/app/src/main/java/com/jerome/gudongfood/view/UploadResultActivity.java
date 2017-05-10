package com.jerome.gudongfood.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.jerome.gudongfood.gsonBeans.ReceiveV;

public class UploadResultActivity extends Activity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_result);

        mQueue = Volley.newRequestQueue(this);

        Button uploadButton = (Button) findViewById(R.id.buttonUpload);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doUpload();
//                Intent intent = new Intent(UploadResultActivity.this, ThreeVegetableActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("v1", "茄子");
//                bundle.putString("v2", "豌豆");
//                bundle.putString("v3", "金针菇");
//                intent.putExtras(bundle);
//                startActivity(intent);
            }
        });
    }

    private void doUpload() {
        StringRequest stringRequest = new StringRequest("http://10.0.3.2:8080/SportsRecipe/sport_upload?username=gaofeng&length=3600&caloria=500&bupin=60&bufu=80&steps=3000&avgspeed=5",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAG", "===================网络请求返回：" + s);
                        Gson gson = new Gson();
                        ReceiveV rv = gson.fromJson(s, ReceiveV.class);
                        Intent intent = new Intent(UploadResultActivity.this, ThreeVegetableActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("v1", rv.vegetable1);
                        bundle.putString("v2", rv.vegetable2);
                        bundle.putString("v3", rv.vegetable3);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(stringRequest);
    }
}
