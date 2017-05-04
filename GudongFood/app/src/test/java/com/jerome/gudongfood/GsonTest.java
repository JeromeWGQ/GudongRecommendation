package com.jerome.gudongfood;

import com.google.gson.Gson;

import org.junit.Test;

/**
 * Created by Jerome on 2017/5/1.
 */

public class GsonTest {
    @Test
    public void testGson() {
        String sourceJson = "{\"json\":[{\"userid\":\"4d368235c4bbb791718d\",\"nickname\":\"feng\",\"interest\":\"chifan\",\"signature\":\"chihaofan\",\"purpose\":\"chihaoduofan\",\"height\":175.0,\"weight\":120.0,\"age\":22,\"sex\":1,\"pweight\":130.0,\"pdays\":30}],\"status\":\"1\"}";
        Gson gson = new Gson();
        ReceiveUser user = gson.fromJson(sourceJson, ReceiveUser.class);
    }
}
