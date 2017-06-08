package com.jerome.gudongfood.gsonBeans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jerome on 2017/5/10.
 */

public class ReceiveV {
    public String status;
    @SerializedName("breakfastinfo")
    public String breakfast;
    @SerializedName("lunchinfo1")
    public String lunch1;
    @SerializedName("lunchinfo2")
    public String lunch2;
    @SerializedName("lunchinfo3")
    public String lunch3;
    @SerializedName("vegetable1")
    public String dinner1;
    @SerializedName("vegetable2")
    public String dinner2;
    @SerializedName("vegetable3")
    public String dinner3;
}
