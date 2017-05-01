package com.jerome.gudongfood.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.R;

import com.jerome.gudongfood.dao.MenuDataUtil;
import com.jerome.gudongfood.model.MenuDataItem;

public class MenuListActivity extends AppCompatActivity implements MenuItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
    }

    @Override
    public void onListFragmentInteraction(MenuDataItem item) {
//        Toast.makeText(this, "点击了" + item, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,DetailActivity.class);

        //用Bundle携带数据
        Bundle bundle=new Bundle();
        //传递name参数为tinyphp
        bundle.putString("menuName", item.menuName);
        bundle.putString("menuDetailLong", MenuDataUtil.getDetailLong(item.id));
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
