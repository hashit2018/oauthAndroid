package com.hash.cn.it.okhttp;


import com.hash.cn.it.AuBean;
import com.hash.cn.it.LayoutBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceService {

    @FormUrlEncoded
    @POST("loginByAuthCode")
    Call<AuBean> getData(@Field("clientId") String clientId,
                         @Field("clientSecret") String clientSecret,
                         @Field("code") String code,
                         @Field("redirectUri") String redirectUri,
                         @Field("state") String state,
                         @Field("nonce") String nonce);

    @FormUrlEncoded
    @POST("logout")
    Call<LayoutBean> layout(@Field("deviceUUID") String deviceUUID);

}
