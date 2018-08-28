package com.hash.cn.it.okhttp;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 *  Retrofit
 */
public class RetrofitUtils {
    private static String Url_ROOT="";

    public static void setUrl_ROOT(String url_root) {
       Url_ROOT = url_root;
    }

    private static Retrofit singleton;

    /**
     * 获取api
     * @param clazz
     * @param <T>
     * @return  返回call
     */
    public static <T> T createApiForGson( Class<T> clazz) {
        if (singleton == null) {
            synchronized (RetrofitUtils.class) {
                if (singleton == null) {
                    Retrofit.Builder builder = new Retrofit.Builder();
                    builder.baseUrl(Url_ROOT);
                    builder.addConverterFactory(GsonConverterFactory.create());
                    builder.client(OkHttpUtils.getInstance());
                    singleton = builder.build();
                }
            }
        }
        return singleton.create(clazz);
    }
}
