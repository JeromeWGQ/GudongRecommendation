package com.jerome.gudongfood.model;

/**
 * Created by Jerome on 2017/5/17.
 */

public class SportData {
    public SportData(String username, String length, String caloria, String bupin, String bufu, String steps, String avgspeed) {
        this.username = username;
        this.length = length;
        this.caloria = caloria;
        this.bupin = bupin;
        this.bufu = bufu;
        this.steps = steps;
        this.avgspeed = avgspeed;
    }
    public String username;
    public String length;
    public String caloria;
    public String bupin;
    public String bufu;
    public String steps;
    public String avgspeed;
}
