package com.rrtx;


import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import static com.rrtx.encryption.CertificateRead.*;

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
        publicKeyStr =  getPublicKeyInfo();
        privateKeyStr = getPrivateKeyInfo();
        System.out.println("publicKeyStr");
        System.out.println(publicKeyStr);
        System.out.println("privateKeyStr");
        System.out.println(privateKeyStr);



        final RSA rsa = new RSA(rsaAlgorithm, privateKeyStr, publicKeyStr);

        // 公钥加密，私钥解密
        String encryptStr = rsa.encryptBase64(text, KeyType.PublicKey);
        String encryptStr2 = rsa.encryptBase64(text, KeyType.PublicKey);
        String encryptStr3 = rsa.encryptBase64(text, KeyType.PublicKey);
        String encryptStr4 = rsa.encryptBase64(text, KeyType.PublicKey);




        String decryptStr = StrUtil.utf8Str(rsa.decrypt(encryptStr, KeyType.PrivateKey));
        String decryptStr2 = StrUtil.utf8Str(rsa.decrypt(encryptStr2, KeyType.PrivateKey));
        String decryptStr3 = StrUtil.utf8Str(rsa.decrypt(encryptStr3, KeyType.PrivateKey));
        String decryptStr4 = StrUtil.utf8Str(rsa.decrypt(encryptStr4, KeyType.PrivateKey));
        System.out.println("text");
        System.out.println(text);
        System.out.println("encryptStr");
        System.out.println(encryptStr);

        System.out.println("encryptStr2");
        System.out.println(encryptStr2);

        System.out.println("encryptStr3");
        System.out.println(encryptStr3);

        System.out.println("encryptStr4");
        System.out.println(encryptStr4);

        System.out.println("decryptStr");
        System.out.println(decryptStr);

        System.out.println("decryptStr2");
        System.out.println(decryptStr2);

        System.out.println("decryptStr3");
        System.out.println(decryptStr3);

        System.out.println("decryptStr4");
        System.out.println(decryptStr4);
        if(text.equals(decryptStr)){
            System.out.println("校验通过");
        }
    }

}
