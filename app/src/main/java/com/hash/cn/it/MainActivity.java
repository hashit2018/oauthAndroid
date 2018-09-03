package com.hash.cn.it;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.authorlibrary.AuthorBaseActivity;
import com.example.authorlibrary.AuthorBean;
import com.example.authorlibrary.JARAuthorization;
import com.example.authorlibrary.JarRandomUtil;
import com.hash.cn.it.okhttp.HttpServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AuthorBaseActivity {
    private TextView tv;

    @Override
    protected void onChangeUserInfo(AuthorBean result) {
        super.onChangeUserInfo(result);
        Log.i("数据：", result.getCode() + "zzz");
        tv.setEnabled(false);
        getData(result);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("hash", "resume");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JARAuthorization.startAuthor(MainActivity.this, "CwtchSDKDemo", "com.hash.cn.it", "com.hash.cn.it.MainActivity");
            }
        });
    }

    private void getData(AuthorBean result) {
        String state = null;
        if (result.getData().getState() == null) {
            state = null;
        } else {
            state = result.getData().getState() + "";
        }
        HttpServiceClient.getInstance().getData("sampleClientId","sampleClientSecret",result.getData().getCode(), result.getData().getRedirect_uri(), state, JarRandomUtil.RandomNumber()).enqueue(new Callback<AuBean>() {
            @Override
            public void onResponse(Call<AuBean> call, Response<AuBean> response) {
                if (response.isSuccessful()) {
                    Log.d("hash", "获取数据成功");
                    if (response.body().getCode().equals("20000")) {
                        MyApplication.bean = response.body().getData();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AuBean> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
