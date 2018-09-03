package com.hash.cn.it;

import android.app.Application;

import com.example.authorlibrary.JARAuthorization;

public class MyApplication extends Application{
    public static AuBean.DataBean bean;
    @Override
    public void onCreate() {
        super.onCreate();
        JARAuthorization.init(this,"sampleClientId","http://your_callback_uri ","1","d");
    }
}
