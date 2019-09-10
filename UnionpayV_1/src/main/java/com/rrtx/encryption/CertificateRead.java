package com.rrtx.encryption;

import cn.hutool.core.codec.Base64;
import com.rrtx.fap.frame.util.Str;
import sun.misc.BASE64Encoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Enumeration;

/**
 * 从本地路径下读取公私钥方法
 *
 */
public class CertificateRead {


//
//    static String KEY_PASSWORD = "";

    /**
     * 读取.pfx文件获取公私钥信息
     */
    public static String getPrivateKeyInfo(String privateKeyFilePath , String privateKeyPassword){

        String keyAlias = null;

        String publicKeyStr = null;

        String privateKeyStr = null;

        try
        {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream fileInputStream = new FileInputStream(privateKeyFilePath);
            char[] nPassword = null;
            if ((privateKeyPassword == null) || privateKeyPassword.trim().equals(""))
            {
                nPassword = null;
            } else {
                nPassword = privateKeyPassword.toCharArray();
            }
            keyStore.load(fileInputStream, nPassword);
            fileInputStream.close();
            //System.out.println("keystore type=" + keyStore.getType());
            Enumeration<String> enumeration = keyStore.aliases();
            if (enumeration.hasMoreElements()){
                keyAlias = (String) enumeration.nextElement();
                //System.out.println("alias=[" + keyAlias + "]");
            }
            //System.out.println("is key entry=" + keyStore.isKeyEntry(keyAlias));
            PrivateKey prikey = (PrivateKey) keyStore.getKey(keyAlias, nPassword);
            Certificate cert = keyStore.getCertificate(keyAlias);
            PublicKey pubkey = cert.getPublicKey();

            publicKeyStr = Base64.encode(pubkey.getEncoded());
            privateKeyStr = Base64.encode(prikey.getEncoded());
            System.out.println("public key = ");
            System.out.println("===================================================public1 key===================================================");
            System.out.println(publicKeyStr);
            System.out.println("private key = ");
            System.out.println("===================================================private key===================================================");
            System.out.println(privateKeyStr);


        } catch (Exception e)
        {
            System.out.println(e);
        }
        return privateKeyStr;
    }

    /**
     * 读取.cer文件获取公钥信息
     */
    public static String getPublicKeyInfo(String publicKeyFilePath){

        String publicKye = null;

        try {
            CertificateFactory certificatefactory=CertificateFactory.getInstance("X.509");
            FileInputStream bais= null;

            bais = new FileInputStream(publicKeyFilePath);

            X509Certificate Cert = (X509Certificate)certificatefactory.generateCertificate(bais);
            PublicKey pk = Cert.getPublicKey();
            publicKye = new BASE64Encoder().encode(pk.getEncoded());

            System.out.println("===================================================public2 key===================================================");
            System.out.println(publicKye);

        } catch (FileNotFoundException | CertificateException e) {
            e.printStackTrace();
        }
        return publicKye;
    }

    /**
     * 读取.cer文件获取公钥
     */
    public static PublicKey getPublicKey(String publicKeyFilePath){

        PublicKey pk = null;

        try {
            CertificateFactory certificatefactory=CertificateFactory.getInstance("X.509");
            FileInputStream bais= null;

            bais = new FileInputStream(publicKeyFilePath);

            X509Certificate Cert = (X509Certificate)certificatefactory.generateCertificate(bais);
            pk = Cert.getPublicKey();

        } catch (FileNotFoundException | CertificateException e) {
            e.printStackTrace();
        }
        return pk;
    }


    /**
     * 读取私钥信息
     * @param privateKeyFilepath
     * @param privateKeyPassword
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKeyFilepath , String privateKeyPassword){

        String keyAlias = null;

        PrivateKey prikey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream fileInputStream = new FileInputStream(privateKeyFilepath);

            char[] nPassword = null;
            if ((privateKeyPassword == null) || privateKeyPassword.trim().equals("")){
                nPassword = null;
            } else {
                nPassword = privateKeyPassword.toCharArray();
            }
            keyStore.load(fileInputStream, nPassword);
            fileInputStream.close();
            Enumeration<String> enumeration = keyStore.aliases();
            if (enumeration.hasMoreElements()){
                keyAlias = (String) enumeration.nextElement();
            }
            prikey = (PrivateKey) keyStore.getKey(keyAlias, nPassword);
            Certificate cert = keyStore.getCertificate(keyAlias);
            PublicKey pubkey = cert.getPublicKey();

        } catch (Exception e){
            System.out.println(e);
        }
        return prikey;
    }

    public static PrivateKey getPemPrivateKey(String privateKeyStr) throws Exception {
        PrivateKey privateKey = null;
        java.security.Security.addProvider(
                new org.bouncycastle.jce.provider.BouncyCastleProvider()
        );
        //String privateKeyStr = "MIIEpAIBAAKCAQEAwtRaXXy+TJ0GUovLeggeMnfefdYc9YKk1x7SstPWvw7L4sNrTdtPARVXycpc4f19o5P1fCh3o0K5w2skk1TT3GetHP/b6obZ1K4php7rjHGWp9139LwWh2qlau14MPKxPiS4JhauRMjVwV4PwfAtjM3ewHtYF8YR5lmQlefXDEfI3rHkuzR/r+YK4NCzHpxrkcQz4B/5B4Bl31cXMHjVaFu+vRwB4rUUNQkCaTtcaY7J+YDh2/3zKhH4P/omsa7TUZjtyqqcVjNlq/HiXa3f3Kv4MxBxNmLvoOdNC6cWJlgLaL0Sl8Bh/RGCCLPqcc6cb2+SBF/3/jBBAmWufzm0XQIDAQABAoIBAHPo/nIMGvNdoDtP7BiH599CrV3UGpp9xTAuqE+39FTqqqYYeShyx0fvuLDW8feJZkwBZNUfBj5dHkOC5Nm6Z+kCzV0pY17eJ45+pznuJlkB4w2vlwRFOmoKKqu45/7HBGfiVKRkbf2CNpm6KknJaHASsul0+G38av3OX1Sv/6LPr4p2vlKcMNiWKfjpmLpD3O3KstVBDY+wvrS9JRbRm/1MVqCR0J1/NwSH7wkyXn1hPxYUIIfS/pp/tzz2pk7DboYEs3t7SIfFItbCojc/5thrgvksHFqVD3DC5NgpiyFtpRIO87jQoHq5SiaYIkzmpTBdg5tN2v187RuFP00oXskCgYEA9BYbRcuT6tjwy1yk/b7eWr162PLrS/Ra8WHhoJuCA3OWVtkWKVHXS/EwO8lyCmou9B6K+Uig5yziL0WEytw5yNQ5Dum3C5y0DkNtvPRU2LWHLtRL/KiSYXiC3Zu5JUk/F2c9fgwbRj9qz4DvULTPEozlLmwekAUtvK+n+eYJ4+8CgYEAzFbGcNyR6sEjy73Exb/+NKQsxtr0IQjqMIz7OPgC0SzoDCJr0WaLXXsSacbKhHAEyob2jEYt4BtLlhoophwesUOqlFRfd6ZGZiEi7TxELKQ02bpGMsX7dLx5kQwPsZOEJJTcV9b6fpYga9tjUOQBgfx4h8D0Kg/H0JoA9cEssHMCgYEAp82W3EnTnA2epUBA0Y1pkhpXnVSLfME10GKJWf/uxu6s+XHu8WMpTzU2ArQ/6XcMZpmk0zIiJCvQJ810OH5kX3O+8kispZgKlQ+4HsIenolVsVUUFFPTppzR4wZOp5qOfElmlgQ+r/GjPZqXa/WRsmAYouyDqmFVCzX7liqWvBMCgYApxIMDhtJ8vcXnW37hPQFlGTnd29uS9ROJoQeo+Wj6AMfd0xtezismjIWTAYNb1tnj2/qBacbuzCWDJQ2yBoVvjnlLoINzHZW+Qn+1JmB5D4eOCblXn4hqsCvZLjH3BkQ4hgUUH2lMfrtZ0JpYaoK0Yzrv5M0D2/3n8dLIaRgNaQKBgQCAG4H9A4A08CBc0DpqSoJ6ZpRv15IicRasf6REB+Uh3XEwlKg7h+QUVP8QC9oxBYcSl+6+WQ1w6lrQEQYu/QwdRtPuYDsGjAvNLPX3qwzcDIwWUSUEDe80bq8gMWgQzhxpD4erQXjQQcBHTuf9/3EcK0H6NRXpOv+nsVVWyg5r+g==";
        try {
            Base64 base64 = new Base64();
            byte[] buffer = Base64.decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
            return privateKey;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception(e.getMessage());
        } catch (InvalidKeySpecException e) {
            throw new Exception(e.getMessage());
        } catch (NullPointerException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
//        getPublicKey("/Users/chenkai/home/unionPay/enc_1560935656467.crt");
//        getPrivateKey("/Users/chenkai/home/unionPay/ttf.pfx" , "1");

//        String publicKey_path_scis_enc = "/Users/chenkai/home/unionPay/enc_1560935656467.crt";
//        String publicKey_path_scis_sign = "/Users/chenkai/home/unionPay/sign_1560936206326.crt";
//        String publicKey_path_spay = "/Users/chenkai/home/unionPay/spayupi_qa_pub.pem";
//        String privateKey_path_spay = "/Users/chenkai/home/unionPay/spayupi_qa_priv.pem";
//        String privateKey_password_spay = "";
        /**
         * 读取 scis 加密 公钥
         */
        //PublicKey publicKey_path_scis_enc_ = getPublicKey(publicKey_path_scis_enc);
        /**
         * 读取 scis 签名 公钥
         */
        //PublicKey publicKey_path_scis_sign_ = getPublicKey(publicKey_path_scis_sign);
        /**
         * 读取 spay 公钥
         */
        //PublicKey publicKey_path_spay_ = getPublicKey(publicKey_path_spay);
        /**
         * 读取 spay 私钥
         */
        //PrivateKey privateKey_path_spay_ = getPrivateKey(privateKey_path_spay, privateKey_password_spay);

        //PrivateKey fasdfs = getPemPrivateKey(privateKey_path_spay, "RSA");

//        getPemPrivateKey("");
    }
}
