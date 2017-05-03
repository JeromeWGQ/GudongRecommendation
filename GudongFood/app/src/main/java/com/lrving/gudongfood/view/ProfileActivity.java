package com.lrving.gudongfood.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.R;
import com.google.gson.Gson;
import com.jerome.gudongfood.dao.UserDataUtil;
import com.jerome.gudongfood.gsonBeans.ReceiveUser;
import com.lrving.gudongfood.model.User;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    //初始化按钮控件
    private Button btn_editPortrait, btn_editName, btn_editSex, btn_editAge, btn_editHobbies,
            btn_editAutograph, btn_editGoal, btn_editHeight, btn_editWeight, btn_profileOk;
    private TextView tv_userName, tv_sex, tv_age, tv_hobby, tv_autograph, tv_goal, tv_weight, tv_height, tv_goalWeight, tv_goalTime;
    private LinearLayout ll_weightInfo;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mQueue = Volley.newRequestQueue(this);
        getInfo();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
        //获取按钮控件
        btn_editPortrait = (Button) findViewById(R.id.btn_editPortrait);
        btn_editName = (Button) findViewById(R.id.btn_editName);
        btn_editSex = (Button) findViewById(R.id.btn_editSex);
        btn_editAge = (Button) findViewById(R.id.btn_editAge);
        btn_editHobbies = (Button) findViewById(R.id.btn_editHobbies);
        btn_editAutograph = (Button) findViewById(R.id.btn_editAutograph);
        btn_editGoal = (Button) findViewById(R.id.btn_editGoal);
        btn_editHeight = (Button) findViewById(R.id.btn_editHeight);
        btn_editWeight = (Button) findViewById(R.id.btn_editWeight);
        btn_profileOk = (Button) findViewById(R.id.btn_profileOk);
        //按下头像修改跳转到头像界面
        btn_editPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PortraitActivity.class);
                startActivity(intent);
            }
        });

        //按下昵称修改跳转到昵称界面
        btn_editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, NameActivity.class);
                startActivity(intent);
            }
        });

        //按下年龄修改跳转到年龄界面
        btn_editAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AgeActivity.class);
                startActivity(intent);
            }
        });

        //按下兴趣修改跳转到兴趣界面
        btn_editHobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HobbiesActivity.class);
                startActivity(intent);
            }
        });

        //按下个性签名修改跳转到个性签名界面
        btn_editAutograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AutographActivity.class);
                startActivity(intent);
            }
        });

        //按下运动目的修改跳转到运动目的界面
        btn_editGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, GoalActivity.class);
                startActivity(intent);
            }
        });

        //按下性别修改跳转到行呗界面
        btn_editSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SexActivity.class);
                startActivity(intent);
            }
        });

        //按下身高修改跳转到身高界面
        btn_editHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HeightActivity.class);
                startActivity(intent);
            }
        });

        //按下体重修改跳转到体重界面
        btn_editWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HeightActivity.class);
                startActivity(intent);
            }
        });

        //按下确认按钮返回
        btn_profileOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInfo();
            }
        });
    }

    protected void onResume() {
        super.onResume();
        showInfo();
    }

    private void showInfo() {
        //获取显示信息控件
        //头像
        ImageView iv_portrait = (ImageView) findViewById(R.id.iv_portrait);
        //iv_portrait.setImageBitmap(User.stringToBitmap(User.portrait));
//        Bitmap b = convertViewToBitmap(iv_portrait);
//        User.portrait=User.bitmapToString(b);
        iv_portrait.setImageBitmap(User.stringToBitmap(User.portrait));
        //昵称
        tv_userName = (TextView) findViewById(R.id.tv_userName);
        tv_userName.setText(User.name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        //性别
        if (User.sex.equals("0"))
            tv_sex.setText("女");
        else
            tv_sex.setText("男");
        //年龄
        tv_age = (TextView) findViewById(R.id.tv_age);
        tv_age.setText(User.age);
        //兴趣
        tv_hobby = (TextView) findViewById(R.id.tv_hobby);
        tv_hobby.setText(User.hobby);
        //个性签名
        tv_autograph = (TextView) findViewById(R.id.tv_autograph);
        tv_autograph.setText(User.autograph);
        //目的
        tv_goal = (TextView) findViewById(R.id.tv_goal);
        tv_goal.setText(User.goal);
        //体重身高
        tv_height = (TextView) findViewById(R.id.tv_height);
        tv_height.setText(User.height);
        tv_weight = (TextView) findViewById(R.id.tv_weight);
        tv_weight.setText(User.weight);

        tv_goalWeight = (TextView) findViewById(R.id.tv_goalWeight);
        tv_goalTime = (TextView) findViewById(R.id.tv_goalTime);
        ll_weightInfo = (LinearLayout) findViewById(R.id.ll_weightInfo);
        if (User.goal == "减肥") {
            ll_weightInfo.setVisibility(View.VISIBLE);
            tv_goalWeight.setText(User.goal_weight);
            tv_goalTime.setText(User.goal_time);
        } else {
            ll_weightInfo.setVisibility(View.GONE);
            tv_goalWeight.setText("60");
            tv_goalTime.setText("60");
        }
    }

    private void updateInfo() {
        StringRequest stringRequest1 = new StringRequest("http://10.0.3.2:8080/SportsRecipe/user_update?" +
                "username=" + UserDataUtil.currentUser + "&nickname=" + User.name + "&interest=" + User.hobby + "&signature=" + User.autograph + "&purpose="
                + User.goal + "&height=" + User.height + "&weight=" + User.weight + "&age=" + User.age + "&sex=" + User.sex + "&pweight=" + User.goal_weight + "&pdays=" + User.goal_time,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAG", "===================网络请求返回：" + s);
                        String[] str = s.split("\"");
                        int code = Integer.parseInt(str[1]);
                        switch (code) {
                            case 1:
                                break;
                            default:
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(stringRequest1);
        StringRequest stringRequest2 = new StringRequest("http://10.0.3.2:8080/SportsRecipe/img_update?" +
                "username=" + UserDataUtil.currentUser + "&imgbase64=" + User.portrait,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAG", "===================网络请求返回：" + s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(stringRequest2);
    }

    private void getInfo() {
        GetProfileTask gTask = new GetProfileTask();
        gTask.execute((Void) null);

//        GetPictureTask pTask = new GetPictureTask();
//        pTask.execute((Void) null);
    }

    public class GetProfileTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            StringRequest stringRequest1 = new StringRequest("http://10.0.3.2:8080/SportsRecipe/user_inf?username=" + UserDataUtil.currentUser,
                    new Response.Listener<String>() {
                        public void onResponse(String s) {
                            Gson gson = new Gson();
                            ReceiveUser user = gson.fromJson(s, ReceiveUser.class);
                            if (user.status.equals("1")) {
                                User.name = user.userInfoList.get(0).nickname;
                                User.hobby = user.userInfoList.get(0).interest;
                                User.autograph = user.userInfoList.get(0).signature;
                                User.goal = user.userInfoList.get(0).purpose;
                                User.height = user.userInfoList.get(0).height + "";
                                User.weight = user.userInfoList.get(0).weight + "";
                                User.age = user.userInfoList.get(0).age + "";
                                User.sex = user.userInfoList.get(0).sex + "";
                                User.goal_weight = user.userInfoList.get(0).pweight + "";
                                User.goal_time = user.userInfoList.get(0).pdays + "";
                                showInfo();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.e("Tag", volleyError.getMessage(), volleyError);
                }
            });
            mQueue.add(stringRequest1);
            return null;
        }
    }

    public class GetPictureTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: 2017/5/1 头像的网络请求
            StringRequest stringRequest = new StringRequest("http://localhost:8080/SportsRecipe/user_img_get?username=" + UserDataUtil.currentUser,
                    new Response.Listener<String>() {
                        JSONObject jsonObject = null;

                        public void onResponse(String s) {
                            try {
                                jsonObject = new JSONObject(s);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                User.portrait = jsonObject.getString("imgbase64");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.e("Tag", volleyError.getMessage(), volleyError);
                }
            });
            mQueue.add(stringRequest);
            return null;
        }
    }
}
