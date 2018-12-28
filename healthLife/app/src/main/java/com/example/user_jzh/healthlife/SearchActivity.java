package com.example.user_jzh.healthlife;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.user_jzh.healthlife.base.BaseActivity;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends BaseActivity {

    Button searchBtn,cancleBtn,startBtn,endBtn;
    private Calendar calendar;

    private List<JSONObject> list=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        fidById();
        calendar=Calendar.getInstance();
        Intent intent=new Intent();
    }

    private void fidById(){
        //找到全部的id

        searchBtn=findViewById(R.id.search_btn);
        endBtn=findViewById(R.id.search_morning_end_btn);
    }

    public void onClinck(View v){
        switch (v.getId()){
            case R.id.search_btn:

            break;
            case R.id.search_morning_end_btn:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        endBtn.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

                break;
            case R.id.main_walk_btn:
                getIntent().putExtra("name","日间行走");
                break;
        }
    }

    public void getData(){
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                HashMap<String,Object>map=new HashMap<>();
                map.put("account",AppApplication.account);
            }
        };
        new Thread(runnable).start();
    }



}
