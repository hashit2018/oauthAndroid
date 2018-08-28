package com.hash.cn.it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hash.cn.it.okhttp.HttpServiceClient;
import com.hash.cn.it.okhttp.MiddleDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    private TextView layout;
    private TextView nickname;
    private TextView mobile;
    private TextView uuid;
    private TextView nationCode;
    private TextView name;

    private Gson mGson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        layout=findViewById(R.id.layout);
        nickname=findViewById(R.id.nickname);
        mobile=findViewById(R.id.mobile);
        uuid=findViewById(R.id.uuid);
        nationCode=findViewById(R.id.nationCode);
        name=findViewById(R.id.name);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MiddleDialog(Main2Activity.this,new MiddleDialog.onButtonCLickListener2() {
                    @Override
                    public void onActivieButtonClick(Object bean, int po) {
                        if(bean!=null){
                            Layout();
                        }
                    }
                },R.style.registDialog).show();
            }
        });
        set2(MyApplication.bean);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void Layout(){
        HttpServiceClient.getInstance().layout(null).enqueue(new Callback<LayoutBean>() {
            @Override
            public void onResponse(Call<LayoutBean> call, Response<LayoutBean> response) {
                if(response.isSuccessful()){
                    Log.d("hash","获取数据成功");
                    if(response.body().getCode().equals("20000")){
                        Toast.makeText(Main2Activity.this,"退出登录成功", Toast.LENGTH_SHORT).show();
                        set1();
                        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(Main2Activity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Main2Activity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LayoutBean> call, Throwable t) {
                Toast.makeText(Main2Activity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void set1(){
        nickname.setText("nickname:");
        mobile.setText("mobile:");
        uuid.setText("uuid:");
        nationCode.setText("nationCode:");
        name.setText("name:");
    }
    private void set2(AuBean.DataBean bean){
        nickname.setText("nickname:  "+bean.getNickname());
        mobile.setText("mobile:  "+bean.getMobile());
        uuid.setText("uuid:  "+bean.getUuid());
        nationCode.setText("nationCode:  "+bean.getNationCode());
        name.setText("name:  "+bean.getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
