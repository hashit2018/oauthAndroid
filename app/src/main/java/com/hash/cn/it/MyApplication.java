package com.hash.cn.it;

import android.app.Application;

import com.example.authorlibrary.JARAuthorization;

public class MyApplication extends Application{
    public static AuBean.DataBean bean;
    @Override
    public void onCreate() {
        super.onCreate();
        JARAuthorization.init(this,"1111","http://your_callback_uri ",null,"d");
    }
}
