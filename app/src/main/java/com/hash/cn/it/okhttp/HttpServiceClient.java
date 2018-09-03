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
        RetrofitUtils.setUrl_ROOT("http://13.115.238.48/");//测试环境
        interfaceService=RetrofitUtils.createApiForGson(InterfaceService.class);
        return  interfaceService;
    }
}
