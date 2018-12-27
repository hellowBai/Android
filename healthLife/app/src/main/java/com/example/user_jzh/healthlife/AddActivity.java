package com.example.user_jzh.healthlife;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.user_jzh.healthlife.base.BaseActivity;

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
                //Ìá½»ÐÅÏ¢
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
}
