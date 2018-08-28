package com.example.authorlibrary;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public class BService extends Service {
    public static Messenger to;
    public static  Message message;
    public static String App_key;
    public static String redirect_uri;
    public static String scope;
    public static String state;
    public static String data;
    Messenger messenger = new Messenger(new Handler() {
        @Override
        public void handleMessage(Message msg) {
            JARAuthorization.en=false;
            App_key=msg.getData().getString("App_key");
            redirect_uri=msg.getData().getString("redirect_uri");
            scope=msg.getData().getString("scope");
            state=msg.getData().getString("state");
            data=msg.getData().getString("data");
            Log.e("kk",data+"zzz");
            Log.e("kk","App_key:"+App_key+"+redirect_uri:"+redirect_uri+"+scope:"+scope+"+state:"+state);

            super.handleMessage(msg);
        }
    });

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("kk", "绑定成功！");
        return messenger.getBinder();
    }
}
