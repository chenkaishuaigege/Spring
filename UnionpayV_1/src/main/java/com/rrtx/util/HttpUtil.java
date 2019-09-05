package com.rrtx.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import java.util.UUID;

public class HttpUtil {

    public static String postMethod(String interfaceName, String onlineMessage , String headerSign) {

        //组装URL
        String unionURL = "https://apigatewaytest.unionpayintl.com" + interfaceName;
        //时间戳
        //long upi_timestamp = new Date().getTime() / 1000;
        long upi_timestamp_long = System.currentTimeMillis() / 1000;
        String upi_timestamp = String.valueOf(upi_timestamp_long);
        //UUID
        String upi_uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //证书序列号
        String upi_certid = "1560936206326";
        //银联定义 的 机构ID/钱包ID
        String upi_appid = "39990061";
        //链式构建请求
        HttpResponse response = HttpRequest.post(unionURL)
                //银联定义 的 机构ID/钱包ID
                .header("UPI-APPID", upi_appid)
                // Signature Certificate ID
                .header("UPI-CERTID", upi_certid)
                //消息创建时间戳，使用Unix时间戳格式。
                .header("UPI-TIMESTAMP", upi_timestamp)
                //消息UUID，在RFC4122中定义。该值必须惟一地标识任何一天的任何消息。(当天不可重复)
                .header("UPI-UUID", upi_uuid)
                //Signature result of base64 encoding.Using SHA256withRSA.
                .header("UPI-SIGN", headerSign)
                //表单内容
                .form(onlineMessage)
                //超时，毫秒
                .timeout(9000).execute();
        String resultMessage = response.body();
        return resultMessage; }
}
