package com.example.user_jzh.healthlife;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.user_jzh.healthlife.base.BaseActivity;
import com.example.user_jzh.healthlife.util.HttpUtils;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;

public class AddActivity  extends BaseActivity implements View.OnClickListener {
    private Button addBtn,cancelBtn,morningStartBtn,morningEndBtn;
    private EditText mileageEdit,bikeMileageEdit,nightRunEdit;
    private Button morningExerciseStartBtn,morningExerciseEndBtn;
    private Button walkStartBtn,walkEndBtn;
    private Button bikeStartBtn,bikeEndBtn;
    private Button swimStartBtn,swimEndBtn;
    private Button ballStartBtn,ballEndBtn;
    private Button nightStartBtn,nightEndBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_entry);
        initview();
        addBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        morningExerciseEndBtn.setOnClickListener(this);
        morningExerciseStartBtn.setOnClickListener(this);
        walkStartBtn.setOnClickListener(this);
        walkEndBtn.setOnClickListener(this);
        bikeEndBtn.setOnClickListener(this);
        bikeStartBtn.setOnClickListener(this);
        nightEndBtn.setOnClickListener(this);
        nightStartBtn.setOnClickListener(this);
        ballEndBtn.setOnClickListener(this);
        ballStartBtn.setOnClickListener(this);
        morningEndBtn.setOnClickListener(this);
        morningStartBtn.setOnClickListener(this);
        swimEndBtn.setOnClickListener(this);
        swimStartBtn.setOnClickListener(this);
    }
    private void initview(){
        addBtn = (Button) findViewById(R.id.add_submit_btn);
        cancelBtn = (Button) findViewById(R.id.add_cancel_btn);
        morningStartBtn = (Button) findViewById(R.id.add_morning_start_btn);
        morningEndBtn = (Button) findViewById(R.id.add_morning_end_btn);
        mileageEdit = (EditText) findViewById(R.id.add_mileage_edit);
        bikeMileageEdit = (EditText) findViewById(R.id.add_bike_mileage_edit);
        nightRunEdit = (EditText) findViewById(R.id.add_night_run_mileage_edit);
        morningExerciseStartBtn = (Button) findViewById(R.id.add_morning_exercise_start_btn);
        morningExerciseEndBtn = (Button) findViewById(R.id.add_morning_exercise_end_btn);
        walkStartBtn = (Button) findViewById(R.id.add_walk_start_btn);
        walkEndBtn = (Button) findViewById(R.id.add_walk_end_btn);
        bikeStartBtn = (Button) findViewById(R.id.add_bike_start_btn);
        bikeEndBtn = (Button) findViewById(R.id.add_bike_end_btn);
        swimStartBtn = (Button) findViewById(R.id.add_swim_start_btn);
        swimEndBtn = (Button) findViewById(R.id.add_swim_end_btn);
        ballStartBtn = (Button) findViewById(R.id.add_ball_start_btn);
        ballEndBtn = (Button) findViewById(R.id.add_ball_end_btn);
        nightStartBtn = (Button) findViewById(R.id.add_night_run_start_btn);
        nightEndBtn = (Button) findViewById(R.id.add_night_run_end_btn);


    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.add_submit_btn:
                //提交信息
                if(morningStartBtn.getText().toString().toString().trim().matches("[\\u4e00-\\u9fa5]*"))
                {
                    toast("请选择开始时间");
                }else{
                    toast("请选择结束时间");
                }
                break;
            case R.id.add_cancel_btn:
                //È¡Ïû
                finish();
                break;
            case R.id.add_morning_start_btn:
                //³¿ÅÜ¿ªÊ¼Ê±¼ä
                TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ((Button)v).setText(hourOfDay+":"+minute);
                    }
                },11,11,true);
                timePickerDialog.show();
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void inserData(){
        final Runnable runable=new Runnable() {
            @Override
            public void run() {
                HashMap<String,Object>map=new HashMap<>();
                Calendar calendar =  Calendar.getInstance();;
                String today=calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+" ";
                map.put("sport_name","晨跑");
                map.put("start_time",morningStartBtn.getText().toString().trim());
                map.put("start_time",morningEndBtn.getText().toString().trim());
                map.put("account","123");
                map.put("distance",mileageEdit.getText().toString().trim());
                final String result = HttpUtils.doPost("insertSport",map);
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                     try{
                         JSONObject jsonReader=new JSONObject(result);
                        if (jsonReader.getInt("code")==0){
                            toast("成功");
                            finish();
                        }else{

                        }
                     }
                           catch (Exception e){

                        }
                   }
               });
            }
        };

    }
}
