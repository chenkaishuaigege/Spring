package com.rrtx.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.rrtx.encryption.UnionPaySingleton;


public class HttpUtil {

    public static String postMethod(String interfaceName, String onlineMessage , String headerSign) {
        //公共URL
        String url = UnionPaySingleton.getSingletonMethod().getUnion_url();
        //组装URL
        String unionURL = url + interfaceName;
        //链式构建请求
        HttpResponse response = HttpRequest.post(unionURL)
                //银联定义 的 机构ID/钱包ID
                .header("header-UPI-JWS", headerSign)
                .header("header-Content-Type", "application/json;charset=UTF-8")
                //表单内容
                .form(onlineMessage)
                //超时，毫秒
                .timeout(9000).execute();
        System.out.println("-------发送信息-------");
        System.out.println("UPI-JWS:");
        System.out.println(headerSign);
        System.out.println("Content-Type:");
        System.out.println("application/json;charset=UTF-8");
        System.out.println("body:");
        System.out.println(onlineMessage);
        String resultMessage = response.body();
        return resultMessage; }
}
