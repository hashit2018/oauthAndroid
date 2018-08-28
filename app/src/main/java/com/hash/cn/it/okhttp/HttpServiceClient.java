package com.hash.cn.it.okhttp;

/**
 * Retrofit
 * 网络请求初始化
 */
public class HttpServiceClient {

    private static InterfaceService interfaceService;
    /**
     * 获取实例
     * @return
     */
    public static InterfaceService getInstance(){
        RetrofitUtils.setUrl_ROOT("http://192.168.254.141:1112/");
        interfaceService=RetrofitUtils.createApiForGson(InterfaceService.class);
        return  interfaceService;
    }
}
