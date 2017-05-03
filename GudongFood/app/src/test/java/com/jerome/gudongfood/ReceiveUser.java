package com.jerome.gudongfood;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jerome on 2017/5/1.
 */

public class ReceiveUser {
    public String status;
    @SerializedName("json")
    public List<UserInfo> userInfoList;
    private class UserInfo {
        public String userid;
        public String nickname;
        public String interest;
        public String signature;
        public String purpose;
        public double height;
        public double weight;
        public int age;
        public int sex;
        public double pweight;
        public double pdays;
    }
}
