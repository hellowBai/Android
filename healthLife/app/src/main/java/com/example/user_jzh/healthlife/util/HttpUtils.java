package com.example.user_jzh.healthlife.util;

import com.example.user_jzh.healthlife.base.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class HttpUtils {
   // private final static String HOST = "http://119.29.60.170:80/";
   private final static String HOST = "http://10.0.2.2:8080/";
    StringBuffer sb = new StringBuffer();
    public static String doPost(String method, HashMap<String,Object>params  ) {
        try {
            URL url = new URL(HOST + method);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            if (params.entrySet().size()>0){
                //有开启，需要开启输入流，获取输出流
                //开启输入流
                conn.setDoOutput(true);
                OutputStream os=conn.getOutputStream();
                String reqData=param(params);
             /*   try{
                JSONObject jsonObject=new JSONObject(reqData);}
                 catch (JSONException e) {
                    e.printStackTrace();
                }*/
                os.write(reqData.getBytes("utf-8"));
            }
            StringBuffer sb = new StringBuffer();
            if (conn.getResponseCode() == 200) {
                InputStream is = conn.getInputStream();
                int len;//读取长度
                byte[] b = new byte[1024];
                //循环读取数据，临时存储在byte数组，直到读取结束
                while ((len = is.read(b)) != -1) {
                    sb.append(new String(b, 0, len, "utf-8"));
                }
                is.close();
                conn.disconnect();
                return sb.toString();
            } else {
                return "请检查url";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "异常";
        }
    }

    public static String param(HashMap<String, Object> params){
        StringBuffer sb = new StringBuffer();
        for (HashMap.Entry entry:params.entrySet()){
            sb.append("&"+entry.getKey()+"="+entry.getValue())  ;
            }
            if (sb!=null) {
                sb.deleteCharAt(0);
            }else {
            //传入的字符为空
            }
            return sb.toString();
    }

}
