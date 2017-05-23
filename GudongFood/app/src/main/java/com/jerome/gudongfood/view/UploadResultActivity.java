package com.jerome.gudongfood.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.jerome.gudongfood.dao.SportDataUtil;
import com.jerome.gudongfood.gsonBeans.ReceiveV;
import com.jerome.gudongfood.model.SportData;

public class UploadResultActivity extends Activity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_result);

        mQueue = Volley.newRequestQueue(this);

        fillTestData();

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

    private void fillTestData() {
        SportData s = SportDataUtil.getData("gaofeng");
        EditText editTestHH = (EditText) findViewById(R.id.editTextHH);
        EditText editTextMM = (EditText) findViewById(R.id.editTextMM);
        EditText editTextSS = (EditText) findViewById(R.id.editTextSS);
        EditText editTextKaluli = (EditText) findViewById(R.id.editTextKaluli);
        EditText editTextStepsPerMinute = (EditText) findViewById(R.id.editTextStepsPerMinute);
        EditText editTextLength = (EditText) findViewById(R.id.editTextLength);
        EditText editTextSteps = (EditText) findViewById(R.id.editTextSteps);
        EditText editTextAverageSpeed = (EditText) findViewById(R.id.editTextAverageSpeed);
        int seconds = Integer.parseInt(s.length);
        int hh = seconds / 3600;
        int mm = (seconds % 3600) / 60;
        int ss = (seconds % 60);
        editTestHH.setText(hh + "");
        editTextMM.setText(mm + "");
        editTextSS.setText(ss + "");
        editTextKaluli.setText(s.caloria + "");
        editTextStepsPerMinute.setText(s.bupin + "");
        editTextLength.setText(s.bufu + "");
        editTextSteps.setText(s.steps + "");
        editTextAverageSpeed.setText(s.avgspeed + "");
    }

    private void doUpload() {
        SportData s = SportDataUtil.getData("gaofeng");
        StringRequest stringRequest = new StringRequest("http://10.0.3.2:8080/SportsRecipe/sport_upload?username=" + s.username + "&length=" + s.length + "&caloria=" + s.caloria + "&bupin=" + s.bupin + "&bufu=" + s.bufu + "&steps=" + s.steps + "&avgspeed=" + s.avgspeed,
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
