package com.example.user_jzh.healthlife.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user_jzh.healthlife.R;

import org.json.JSONObject;

import java.util.List;


public class MyAdapter extends BaseAdapter {
    private List<JSONObject> sportDatas=null;
    @Override
    public int getCount() {
        //显示数据的个数
        return sportDatas.size();
    }

    @Override
    public Object getItem(int position) {
        //

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //解析布局文件

        return null;
    }
}
