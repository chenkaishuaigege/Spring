package com.rrtx.util;

import cn.hutool.crypto.digest.DigestUtil;
import com.rrtx.encryption.RSAUtil;

public class SignUtil {


    /**
     * 总体消息进行签名
     *
     * @param onlineMessage     待签名数据
     * @return encryptMessage   签名结果
     */
    public static String constructSignedMethod(String onlineMessage){
        // 步骤1:构造 To-Be-Signed,组件:UPI-APPID  +  UPI-UUID + requestPath+在线消息。
        String toBeSigned = "UPI-APPID"  +  "UPI-UUID" + "requestPath" + onlineMessage;

        // 步骤2:使用SHA-256算法计算  To-Be-Signed  的 <Hash Value>
        byte[] toBeSignedHash = DigestUtil.sha256(toBeSigned);

        // 步骤3:使用机构签名证书私钥和RSA (PKCS1_PADDING)算法加密  Hash Value  。(上一步得到的结果)
        // 步骤4:Base64对 <Hash Value> 进行编码，并将其作为签名结果。Base64编码和解码在[RFC 4648]中定义。
        String encryptMessage = RSAUtil.encryptWithPrivateResultBase64(toBeSignedHash);
        return encryptMessage;
    }

    /**
     * step1:使用UPI加密证书的 <公钥> ，使用RSA (PKCS1_PADDING)算法对敏感信息进行加密。
     * step2:对加密的结果进行 <Base64编码> ，并将其填入字段的值。
     * @param sensitiveInformation
     * @return
     */
    public static String sensitiveInformationEncrypt(String sensitiveInformation){
        return RSAUtil.encryptWithPublicResultBase64(sensitiveInformation);
    }


}
