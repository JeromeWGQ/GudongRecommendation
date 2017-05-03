package com.lrving.gudongfood.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by Lrving on 2017/4/20.
 */

public class User {
    public static String userId = "056111";
    public static String name = "哈哈";
    public static String portrait;
    //public static String portrait="data:image/png;base64,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";
    public static String sex = "1";
    public static String age = "18";
    public static String hobby = "run";
    public static String autograph = "hha";
    public static String goal = "减肥";
    public static String goal_weight = "60";
    public static String goal_time = "60";
    public static String height = "180";
    public static String weight = "70";
    public static String bitmapToString(Bitmap bitmap) {
        //将Bitmap转换成字符串
        String string =null;
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bStream);
        byte[] bytes = bStream.toByteArray();
        string = Base64.encodeToString(bytes,Base64.DEFAULT);
        return string;
    }

    public static Bitmap stringToBitmap(String string) {
        //将字符串转换成Bitmap类型
        Bitmap bitmap =null;
        try {
            byte[] bitmapArray;
            bitmapArray= Base64.decode(string,Base64.DEFAULT);
            bitmap= BitmapFactory.decodeByteArray(bitmapArray,0,bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
