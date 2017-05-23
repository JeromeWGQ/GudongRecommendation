package com.jerome.gudongfood.dao;

import com.jerome.gudongfood.model.SportData;

/**
 * Created by Jerome on 2017/5/17.
 */

public class SportDataUtil {
    public static SportData getData(String username) {
        return new SportData("gaofeng", "3600", "500", "60", "80", "3000", "5");
    }
}
