package com.rrtx.encryption;


import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import static com.rrtx.encryption.CertificateRead.getPrivateKeyInfo;
import static com.rrtx.encryption.CertificateRead.getPublicKeyInfo;

public class MainClass {


    private static String publicKeyStr;
    private static String privateKeyStr;

    public static void main(String[] args) throws Exception {

        String textBase = "我是一段特别长的测试";
        String text = "";
        for (int i = 0; i < 10; i++) {
            text += textBase;
        }


        String rsaAlgorithm = "RSA/ECB/PKCS1Padding";

        //公钥
        publicKeyStr =  getPublicKeyInfo("");
        privateKeyStr = getPrivateKeyInfo("" , "");
        System.out.println("publicKeyStr");
        System.out.println(publicKeyStr);
        System.out.println("privateKeyStr");
        System.out.println(privateKeyStr);

        final RSA rsa = new RSA(rsaAlgorithm, privateKeyStr, publicKeyStr);

        // 公钥加密，私钥解密
        String encryptStr = rsa.encryptBase64(text, KeyType.PublicKey);

        String decryptStr = StrUtil.utf8Str(rsa.decrypt(encryptStr, KeyType.PrivateKey));
        System.out.println("text");
        System.out.println(text);
        System.out.println("encryptStr");
        System.out.println(encryptStr);
        System.out.println("decryptStr");
        System.out.println(decryptStr);
        if(text.equals(decryptStr)){
            System.out.println("校验通过");
        }
    }
}
