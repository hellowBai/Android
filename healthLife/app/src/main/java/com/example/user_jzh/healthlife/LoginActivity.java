package com.example.user_jzh.healthlife;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.user_jzh.healthlife.base.BaseActivity;
import com.example.user_jzh.healthlife.util.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    private EditText accountEdit, pwdEdit;
    private Button regBtn, loginBtn;
    private CheckBox rememberCheckBox;
    private SharedPreferences spf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();
        //设置按钮的监听事件
        regBtn.setOnClickListener(listener);
        loginBtn.setOnClickListener(listener);
        rememberCheckBox.setOnCheckedChangeListener(this);
        spf = getSharedPreferences("user", MODE_PRIVATE);

    }

    private void initview() {
        accountEdit = (EditText) findViewById(R.id.login_account);
        pwdEdit = (EditText) findViewById(R.id.login_password);
        regBtn = (Button) findViewById(R.id.login_regist_btn);
        loginBtn = (Button) findViewById(R.id.login_login_btn);
        rememberCheckBox = (CheckBox) findViewById(R.id.login_remember_password);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login_login_btn:
                    if (TextUtils.isEmpty(accountEdit.getText())) {
                        toast("用户名不能为空!");
                        return;
                    } else if (TextUtils.isEmpty(pwdEdit.getText())) {
                        toast("密码不能为空!");
                        return;
                    } else {
                        //执行登录
                        login();
                    }
                    break;
                case R.id.login_regist_btn:
                    startIntent(RegistActivity.class);
                    break;
            }
        }
    };

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        //SharedPreferences.Editor editor = spf.edit();
        if (isChecked) {

        } else {

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void login() {
        //创建新线程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                HashMap<String ,Object> map=new HashMap<>();
                map.put("account",accountEdit.getText().toString().trim());
                map.put("password",pwdEdit.getText().toString().trim());
                String face="login.aspx";
                final String result = HttpUtils.doPost("Http_web/server/test",map);
                Log.e("tag", "======"+result );
                //运行在主线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //下面在主线程运行
                        toast(result);
                        try {
                            //将数据转换为JASON格式
                            JSONObject jsonObject=new JSONObject(result);
                            //取出 数据
                            int code =jsonObject.getInt("code");
                            if (code==0){
                                startIntent(MainActivity.class);
                                toast("登录成功");
                            }else{
                                toast(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

        };

        new Thread(runnable).start();
    }
}


