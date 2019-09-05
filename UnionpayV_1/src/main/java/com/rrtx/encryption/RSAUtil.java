package com.rrtx.encryption;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import static com.rrtx.encryption.CertificateRead.getPrivateKeyInfo;
import static com.rrtx.encryption.CertificateRead.getPublicKeyInfo;

/**
* 私钥和公钥同时为空
*/
public class RSAUtil {

    static RSA rsa = null;

    static {
        String rsaAlgorithm = "RSA/ECB/PKCS1Padding";

//        String privateKey = getPrivateKeyInfo();
//        String publicKey = getPublicKeyInfo();
//        String privateKey = getPrivateKeyInfo();
//        String publicKey = getPublicKeyInfo();

        //公钥
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANi1oL7q9gr+Ycihji6X51IzmjHkUY26yUV7le4cjLZdtq9KOLNx50lbHDdofzrxXzOe5UmiRxIqAw0zkvNRh4MCAwEAAQ==";
        //私钥
        String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA2LWgvur2Cv5hyKGOLpfnUjOaMeRRjbrJRXuV7hyMtl22r0o4s3HnSVscN2h/OvFfM57lSaJHEioDDTOS81GHgwIDAQABAkEApJVEkNrHpE/QGdzArBhH4YE5UTzyxy4d4DxdAOsD3xdldl+VY1jA/zyC8z8b5wrvSVwkIsfnOxP3t0RDj1cMCQIhAO4AYWgczdshemVRuvD0B6Zu+L3WFvCKoG6uX2lTzWaPAiEA6RkK0EZqAhXL2iAPUI5W6yVQ7R2pEQcGTpBMME++qc0CIQDswm4j7vuN8QjcP+jTCD+P/rbtykr5sT4VvNtnYRlk2wIgP+dkporXXzD4jRlC+ZO8UoUNdaQvCIMDgKBgstH59HUCIHdnUzOg1OG9d4VbYlaZZEAVhRm/nPBRg9zfVvXvjdDY";


//        System.out.println("-------------------");
//        System.out.println("私钥:");
//        System.out.println(privateKey);
//        System.out.println("公钥");
//        System.out.println(publicKey);
//        System.out.println("-------------------");
        rsa = new RSA(rsaAlgorithm, privateKey, publicKey);

    }


    /**
     * 公钥加密,返回Base64编码格式
     * @param dataByte 明文(byte[])
     * @return result base64
     */
    public static String encryptWithPublicResultBase64(byte[] dataByte) {
        return rsa.encryptBase64(dataByte, KeyType.PublicKey);
    }

    /**
     * 私钥加密,返回Base64编码格式
     * @param dataByte 明文(byte[])
     * @return result base64
     */
    public static String encryptWithPrivateResultBase64(byte[] dataByte) {
        return rsa.encryptBase64(dataByte, KeyType.PrivateKey);
    }

    /**
     * 公钥加密,返回Base64编码格式
     * @param data 明文(String)
     * @return result base64
     */
    public static String encryptWithPublicResultBase64(String data) {
        return rsa.encryptBase64(data, KeyType.PublicKey);
    }

    /**
     * 私钥加密,返回Base64编码格式
     * @param data 明文(String)
     * @return result base64
     */
    public static String encryptWithPrivateResultBase64(String data) {
        return rsa.encryptBase64(data, KeyType.PrivateKey);
    }


    /**
     * 私钥解密,参数为Base64编码格式
     * @param data base64
     * @return result 明文
     */
    public static String decryptWithPrivateParamBase64(String data){
        return rsa.decryptStr(data, KeyType.PrivateKey);
    }

    /**
     * 公钥解密,参数为Base64编码格式
     * @param data base64
     * @return result 明文
     */
    public static String decryptWithPublicParamBase64(String data){
        return rsa.decryptStr(data, KeyType.PublicKey);
    }




    public static void main(String[] args) throws Exception {
        String data = "1234567890";
        //私钥加密
        String fas = encryptWithPrivateResultBase64(data);
        System.out.println("私钥加密");
        System.out.println(fas);
        //公钥解密
        String fasfas = decryptWithPublicParamBase64(fas);
        System.out.println("公钥解密");
        System.out.println(fasfas);

//        String privateKey = getPrivateKeyInfo();
//        System.out.println("------------privateKey------------");
//        System.out.println(privateKey);
//        String publicKey = getPublicKeyInfo();
//        System.out.println("------------publicKey------------");
//        System.out.println(publicKey);
    }

}
