package com.jerome.gudongfood.dao;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.jerome.gudongfood.model.AllMenuData;
import com.jerome.gudongfood.model.MenuDataItem;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

/**
 * 获取菜谱列表数据的工具类
 * Created by Jerome on 2016/12/9.
 */
public class MenuDataUtil {

    //    public static List<AllMenuData> dataList = connectMySQL();
    public static List<AllMenuData> dataList = simuConnectMySQL();

    public static List<MenuDataItem> getMenu(Context context) {

        int length = dataList.size();

        // 获取全部Bitmap对象
        Resources r = context.getResources();
        List<Bitmap> listBitmap = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int id = r.getIdentifier(dataList.get(i).menuImagePath, "mipmap", context.getPackageName());
            Bitmap b = BitmapFactory.decodeResource(r, id);
            listBitmap.add(b);
        }

        // 建立MenuDataItem列表
        List<MenuDataItem> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            MenuDataItem item;
            AllMenuData all = dataList.get(i);
            item = new MenuDataItem(i, all.menuName, all.menuDetail, listBitmap.get(i));
            list.add(item);
        }

        return list;
    }

    public static String getDetailLong(int id) {
        return dataList.get(id).menuDetailLong;
    }

    private static Connection conn;

    private static List<AllMenuData> connectMySQL() {

        List<AllMenuData> dataList = new ArrayList<>();

        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名
        String url = "jdbc:mysql://10.0.2.2:3306/gudong";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "";
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连接数据库
            conn = DriverManager.getConnection(url, user, password);
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要执行的SQL语句
            String sql = "select * from menu";
            // 结果集
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String menuName = rs.getString("menuName");
                String menuDetail = rs.getString("menuDetail");
                String menuDetailLong = rs.getString("menuDetailLong");
                String menuImagePath = rs.getString("menuImagePath");
                AllMenuData oneDataItem = new AllMenuData(id, menuName, menuDetail, menuDetailLong, menuImagePath);
                dataList.add(oneDataItem);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    private static List<AllMenuData> simuConnectMySQL() {

        List<AllMenuData> listData = new ArrayList<>();

        DummyData.init();

        for (int i = 0; i < DummyData.LENGTH; i++) {
            listData.add(new AllMenuData(i, DummyData.menuName.get(i), DummyData.menuDetail.get(i), DummyData.menuDetailLong.get(i), DummyData.menuImagePath.get(i)));
        }

        return listData;

    }

    private static class DummyData {

        public static final int LENGTH = 14;

        public static List<String> menuName;
        public static List<String> menuDetail;
        public static List<String> menuDetailLong;
        public static List<String> menuImagePath;

        public static void init() {

            menuName = new ArrayList<>();
            menuDetail = new ArrayList<>();
            menuDetailLong = new ArrayList<>();
            menuImagePath = new ArrayList<>();

            // ===============================
            //         菜品1
            // ===============================
            menuName.add("菜品1");
            menuDetail.add("这是菜品1的细节");
            menuDetailLong.add("这是菜品1的详细细节");
            menuImagePath.add("p1");

            // ===============================
            //         菜品2
            // ===============================
            menuName.add("菜品2");
            menuDetail.add("这是菜品2的细节");
            menuDetailLong.add("这是菜品2的详细细节");
            menuImagePath.add("p2");

            // ===============================
            //         菜品3
            // ===============================
            menuName.add("菜品3");
            menuDetail.add("这是菜品3的细节");
            menuDetailLong.add("这是菜品3的详细细节");
            menuImagePath.add("p3");

            // ===============================
            //         菜品4
            // ===============================
            menuName.add("菜品4");
            menuDetail.add("这是菜品4的细节");
            menuDetailLong.add("这是菜品4的详细细节");
            menuImagePath.add("p4");

            // ===============================
            //         菜品5
            // ===============================
            menuName.add("菜品5");
            menuDetail.add("这是菜品5的细节");
            menuDetailLong.add("这是菜品5的详细细节");
            menuImagePath.add("p5");

            // ===============================
            //         菜品6
            // ===============================
            menuName.add("菜品6");
            menuDetail.add("这是菜品6的细节");
            menuDetailLong.add("这是菜品6的详细细节");
            menuImagePath.add("p6");

            // ===============================
            //         菜品7
            // ===============================
            menuName.add("菜品7");
            menuDetail.add("这是菜品7的细节");
            menuDetailLong.add("这是菜品7的详细细节");
            menuImagePath.add("p7");

            // ===============================
            //         菜品8
            // ===============================
            menuName.add("菜品8");
            menuDetail.add("这是菜品8的细节");
            menuDetailLong.add("这是菜品8的详细细节");
            menuImagePath.add("p8");

            // ===============================
            //         菜品9
            // ===============================
            menuName.add("菜品9");
            menuDetail.add("这是菜品9的细节");
            menuDetailLong.add("这是菜品9的详细细节");
            menuImagePath.add("p9");

            // ===============================
            //         菜品10
            // ===============================
            menuName.add("菜品10");
            menuDetail.add("这是菜品10的细节");
            menuDetailLong.add("这是菜品10的详细细节");
            menuImagePath.add("p10");

            // ===============================
            //         菜品11
            // ===============================
            menuName.add("菜品11");
            menuDetail.add("这是菜品11的细节");
            menuDetailLong.add("这是菜品12的详细细节");
            menuImagePath.add("p11");

            // ===============================
            //         菜品12
            // ===============================
            menuName.add("菜品12");
            menuDetail.add("这是菜品12的细节");
            menuDetailLong.add("这是菜品12的详细细节");
            menuImagePath.add("p12");

            // ===============================
            //         菜品13
            // ===============================
            menuName.add("菜品13");
            menuDetail.add("这是菜品13的细节");
            menuDetailLong.add("这是菜品13的详细细节");
            menuImagePath.add("p13");

            // ===============================
            //         菜品14
            // ===============================
            menuName.add("菜品14");
            menuDetail.add("这是菜品14的细节");
            menuDetailLong.add("这是菜品14的详细细节");
            menuImagePath.add("p14");

        }
    }

}
