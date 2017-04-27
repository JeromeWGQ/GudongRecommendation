package com.jerome.gudongfood.model;

/**
 * 全部的menu数据（与数据库一致）
 * <p>
 * Created by Jerome on 2016/12/13.
 */

public class AllMenuData {
    public int id;
    public String menuName;
    public String menuDetail;
    public String menuDetailLong;
    public String menuImagePath;

    public AllMenuData() {

    }

    public AllMenuData(int id, String menuName, String menuDetail, String menuDetailLong, String menuImagePath) {
        this.id = id;
        this.menuName = menuName;
        this.menuDetail = menuDetail;
        this.menuDetailLong = menuDetailLong;
        this.menuImagePath = menuImagePath;
    }
}
