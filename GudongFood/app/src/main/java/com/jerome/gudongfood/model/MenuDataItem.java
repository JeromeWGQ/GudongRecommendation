package com.jerome.gudongfood.model;

import android.graphics.Bitmap;

/**
 * 单条菜品信息（列表页）
 * Created by Jerome on 2016/12/9.
 */
public class MenuDataItem {

    public int id;
    public String menuName;
    public String menuDetail;
    public Bitmap menuImage;

    public MenuDataItem(int id, String menuName, String menuDetail, Bitmap bitmap) {
        this.id = id;
        this.menuName = menuName;
        this.menuDetail = menuDetail;
        this.menuImage = bitmap;
    }

    @Override
    public String toString() {
        return menuName;
    }
}
