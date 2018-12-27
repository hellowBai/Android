package com.example.user_jzh.healthlife;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.user_jzh.healthlife.base.BaseActivity;



public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button morningBtn,morningExerciseBtn,walkBtn,bikeBtn,swimBtn,ballBtn,nightRunBtn,addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        morningBtn.setOnClickListener(this);
        morningExerciseBtn.setOnClickListener(this);
        walkBtn.setOnClickListener(this);
        swimBtn.setOnClickListener(this);
        bikeBtn.setOnClickListener(this);
        ballBtn.setOnClickListener(this);
        nightRunBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
    }
    private void initview(){
        morningBtn= (Button) findViewById(R.id.main_morning_btn);
        morningExerciseBtn= (Button) findViewById(R.id.main_morning_exercise_btn);
        walkBtn= (Button) findViewById(R.id.main_walk_btn);
        swimBtn= (Button) findViewById(R.id.main_swim_btn);
        ballBtn= (Button) findViewById(R.id.main_ball_btn);
        bikeBtn= (Button) findViewById(R.id.main_bike_btn);
        nightRunBtn= (Button) findViewById(R.id.main_night_run_btn);
        addBtn= (Button) findViewById(R.id.main_add_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_add_btn:
                //Â¼Èë
                startIntent(AddActivity.class);
                break;
            case R.id.main_morning_btn:
                //³¿ÅÜ
                break;
            case R.id.main_morning_exercise_btn:
                //Ôç²Ù
                break;
            case R.id.main_ball_btn:
                //ÇòÀàÔË¶¯
                break;
            case R.id.main_bike_btn:
                //ÆïÐÐ
                break;
            case R.id.main_swim_btn:
                //ÓÎÓ¾
                break;
            case R.id.main_night_run_btn:
                //ÍíÅÜ
                break;
            case R.id.main_walk_btn:
                //ÈÕ¼äÐÐ×ß
                break;
        }
    }
}
