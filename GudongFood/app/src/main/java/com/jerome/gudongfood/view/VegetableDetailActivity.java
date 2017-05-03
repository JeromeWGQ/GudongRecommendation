package com.jerome.gudongfood.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.jerome.gudongfood.dao.StepsUtil;
import com.jerome.gudongfood.gsonBeans.ReceiveVegetable;

public class VegetableDetailActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private ReceiveVegetable rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle receiveBundle = this.getIntent().getExtras();
        String vName = receiveBundle.getString("name");
        setTitle(vName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mQueue = Volley.newRequestQueue(this);

        String url = "http://apis.haoservice.com/lifeservice/cook/query?menu=" + vName + "&pn=1&rn=1&key=7f9b2d5760f0407b9304101b913ff494";
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAG", "===================网络请求返回：" + s);
                        Gson gson = new Gson();
                        ReceiveVegetable rv = gson.fromJson(s, ReceiveVegetable.class);
                        if (rv.error_code.equals("0"))
                            fillData(rv);
                        else {
                            Toast toast = Toast.makeText(getApplicationContext(), "请求失败，请检查网络！", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
                Toast toast = Toast.makeText(getApplicationContext(), "请求失败，请检查网络！", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        // TODO: 2017/5/3 假数据
        //mQueue.add(stringRequest);
        String demo = "{\n" +
                "    \"error_code\": 0,\n" +
                "    \"reason\": \"成功\",\n" +
                "    \"result\": [\n" +
                "        {\n" +
                "            \"id\": 248421,\n" +
                "            \"title\": \"酸辣土豆丝\",\n" +
                "            \"tags\": \"炒;酸辣;家常菜;热菜;健脾;健脾胃;增肥;脾虚;\",\n" +
                "            \"intro\": \"酸辣土豆丝可谓是人见人爱的一道家常菜，虽然价格便宜但是酸辣可口味道味道却是大家喜爱的。无论是家庭餐桌、还是饭馆酒店几乎都能见到它的身影，虽然酸辣土豆丝是一道普通的菜肴，但是能够做好也是不容易的，如何才能保持土豆丝熟而脆爽是关键，这个和土豆的选择、土豆丝的处理、炒制时的时间火候的把握有密切的关系。土豆最好选择含水量高的新土豆，土豆丝要过水，炒制时大火快炒勤翻动，掌握了这些窍门相信你也能做出饭店水平。做酸辣土豆丝我喜欢用陈醋而不是白醋来烹制，虽然颜色稍深，但是陈醋的香味远比白醋来的醇厚，尽管用白醋来烹制土豆丝的色泽好看，但是白醋的味道感觉太过妖艳，自己吃的菜我会以味道为先来选择食材。\",\n" +
                "            \"ingredients\": \"土豆:500g;干辣椒:2个;香菜梗:3g;\",\n" +
                "            \"burden\": \"大蒜:5g;盐:3/4小勺;大葱:5g;味精:1/4小勺;陈醋:1大勺;\",\n" +
                "            \"albums\": \"http://imgs.haoservice.com/CaiPu/pic/recipe/l/65/ca/248421_c54e36.jpg\",\n" +
                "            \"steps\": [\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/c1/a7/829377.jpg\",\n" +
                "                    \"step\": \"1.所有原料准备好，清洗干净。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/c2/a7/829378.jpg\",\n" +
                "                    \"step\": \"2.土豆丝去皮切成丝，用清水洗净表面的淀粉，再浸泡5分钟。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/c3/a7/829379.jpg\",\n" +
                "                    \"step\": \"3.葱蒜切片，干辣椒斜切成段，香菜梗切段。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/bb/a7/829371.jpg\",\n" +
                "                    \"step\": \"4.起油锅，油温升至4成热时放入干辣椒、葱蒜片爆香。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/bc/a7/829372.jpg\",\n" +
                "                    \"step\": \"5.放入土豆丝。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/bd/a7/829373.jpg\",\n" +
                "                    \"step\": \"6.加入盐。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/be/a7/829374.jpg\",\n" +
                "                    \"step\": \"7.再加入陈醋。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/bf/a7/829375.jpg\",\n" +
                "                    \"step\": \"8.开大火快速翻炒，直至土豆丝8成熟关火，放入香菜段和味精快速炒匀出锅。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/c1/a7/829377.jpg\",\n" +
                "                    \"step\": \"1.所有原料准备好，清洗干净。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/c2/a7/829378.jpg\",\n" +
                "                    \"step\": \"2.土豆丝去皮切成丝，用清水洗净表面的淀粉，再浸泡5分钟。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/c3/a7/829379.jpg\",\n" +
                "                    \"step\": \"3.葱蒜切片，干辣椒斜切成段，香菜梗切段。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/bb/a7/829371.jpg\",\n" +
                "                    \"step\": \"4.起油锅，油温升至4成热时放入干辣椒、葱蒜片爆香。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/bc/a7/829372.jpg\",\n" +
                "                    \"step\": \"5.放入土豆丝。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/bd/a7/829373.jpg\",\n" +
                "                    \"step\": \"6.加入盐。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/be/a7/829374.jpg\",\n" +
                "                    \"step\": \"7.再加入陈醋。\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"img\": \"http://imgs.haoservice.com/CaiPu/pic/step/m/bf/a7/829375.jpg\",\n" +
                "                    \"step\": \"8.开大火快速翻炒，直至土豆丝8成熟关火，放入香菜段和味精快速炒匀出锅。\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Gson gson = new Gson();
        rv = gson.fromJson(demo, ReceiveVegetable.class);
        fillData(rv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepsUtil.currentRV = rv;
                Intent intent = new Intent(VegetableDetailActivity.this, StepsActivity.class);
                startActivity(intent);
            }
        });
    }

    private AppBarLayout appBarLayout;

    /**
     * 根据获取的蔬菜信息向activity填充数据
     *
     * @param rv
     */
    private void fillData(ReceiveVegetable rv) {
        // 加载背景图片
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        // TODO: 2017/5/3 优化
        ImageRequest imageRequest = new ImageRequest(
                rv.result.get(0).albums,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        // TODO: 2017/5/3 不直接用构造方法
                        appBarLayout.setBackground(new BitmapDrawable(response));
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: 2017/5/3 添加一张加载失败的图片
            }
        });
        mQueue.add(imageRequest);

        TextView detailText = (TextView) findViewById(R.id.vegetableDetail);
        String fullDetail = "";
        fullDetail += "菜品名称:\n";
        fullDetail += rv.result.get(0).title + "\n\n";
        fullDetail += "标签:\n";
        fullDetail += rv.result.get(0).tags + "\n\n";
        fullDetail += "菜品简介:\n";
        fullDetail += rv.result.get(0).intro + "\n\n";
        fullDetail += "原料:\n";
        fullDetail += rv.result.get(0).ingredients + "\n\n";
        fullDetail += "菜品名称:\n";
        fullDetail += rv.result.get(0).burden + "\n\n";
        detailText.setText(fullDetail);
    }
}
