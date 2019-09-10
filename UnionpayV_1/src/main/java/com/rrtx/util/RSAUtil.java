package com.rrtx.util;

import cn.hutool.core.codec.Base64;
import com.rrtx.encryption.CertificateRead;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static com.rrtx.encryption.UnionPaySingleton.getSingletonMethod;

public class RSAUtil {

    //公钥加密
    public static String encrypt(String content, PublicKey publicKey) {
        try{
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA/ECB/PKCS1Padding"
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(content.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) {
        try{
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA/ECB/PKCS1Padding"
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return  cipher.doFinal(content);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(content);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //私钥解密
    public static String decrypt(String content, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte [] b = cipher.doFinal(content.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * String转公钥PublicKey
     * @param key
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     * String转私钥PrivateKey
     * @param key
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }


    public static String rsaSing(String data) throws Exception {
        //加密使用的公钥:scis提供的 加密 公钥文件
        String getway_signature_private_str = getSingletonMethod().getGetway_signature_private_str();
//        String getway_signature_private_str = "MIIEowIBAAKCAQEAyl1OaA/EE2/zLcUQzGhjcLZ/2BgM2NXcWdXtKZMLW8xXm1+sc6ujFnAJKu44uofUsVN7XkZuXchoYtZyE+1Mqvu9uugCizDWK75eLir5nvX7AXLLB4LyrRmBS2+m0VTO6l4WH1s/z+gvENg62+Xc9QPK2l2FqkpkUaiytWJXYTCSZBBeWN9zAX3FreIxOFcXUsDAp6lZ1LWeeMBKk7+K3h1vdhL3ZODfII/IvYTOykdYYD30cFiCoAfELo40xMJzC0RkhCIOQlUDptjKV+Pd3NznWw5T1BGy5wDB63gsObRKFe2/YBDeUcEw+5lFj4N61qwd/fAUeIPjLuVsq+KKTQIDAQABAoIBAAdTATd6+pnJf3+0ljsPvCmkMVRc6noeo28M8xyCGfMknjcda1x0Zd62B17qaFs391bDsr9ixTPXwQ9yu4ZFHHVDz0Yoh48KIXZL2ZTKMWazeHZA9WA8ORRSy/8y91K0QxjwdtSDtPeNa8asTNUQqMKldH4azG+xaZgbBvzRpl/6FYiqo9Fw5wRwpm3Qvob6ECNIwG/1AYWnpdMHvWIF1bKMzF29MXs0cKzlXkGipjBVxuoKjzJcrWhcIIW1gq9BjVAgwNG3LUR1vGNtGtaSBG2lBwFnpZcGSsDWUInNdrgSauH4v4mzkscqwj/NAhyakQKTKZlhti7IMM9T65ERxnECgYEA+C0zQglCRCpPflFPs29ejrM6espsoOl94943FBMGV0kiOy+kkl3sjDB45cWhlGlUbt6rK6HwLN8wM0XaSElXuV3jbME027AjkXagOlidQyYPHbSqPGxitfh0vEacgbFCJGhAo8kJMGiIv4d8qZuMnQo/aZT/U6RY31Db9eBtJe8CgYEA0L5mVwOOdKGveuZf8fF8uvytKAAMpMX3B5bp3q1F94ifzNL/h/PAiFMpHA+Ilt9xDOzoj0pR6UiptdZaFkZKt8TmQwsFe5Fv85LreZVqizWRR3HeXzYM6E3Wjum26kJjJn/0m4qbRSShMbeJn6oR47gdryu2hTNRexHDNzpC74MCgYBYhzcrrUXYLwegVb0KkwW1/bU0rBTH6cKgkFoxbP/sDwiI+FvKYnrJH1lhDXiwCkq2KfQBYojcWNlG0PomoxMJ6rX/y4PhghmOADTz2zxuAZuOyy2W1Er6AqERsFaP5P1lI1M7mbEPdZqiR+BuWDB2rHsmXKIf4hZZwuxT7zTAPQKBgQDEy9x8CHRTbOOdgHfQB5VKTFGLNpC0/5YnZ5XRQ5aFCh9t4Tbbm2hWneBR/isN4lYYk3mlLbIPt1uYfR+thFOI8W8MoeVnW/QptMefdshdugDfVHELXk/I6yluztSOAkyrzVJ1GbXM9/2oe5qaFqKLB9ekgBexeHJHDrX26UyVtQKBgHIHxzsgQ0oQBvsewEwNLI5Ykjr9oUZ+ZCs0Y1nr0Cc4e2NUIWN344Okk00HZOzeghFxjmMrpAor7ARasWRfj7lZP+R6C3PrdCKi0y1MQIkRaJH3rU7e91Y3ppGOn7sYjPLN9SqeJ3cXpORjJfT3F02qT1PVAISuDLCOh8pELSR3";
        //生成私钥
        PrivateKey privateKey = CertificateRead.getPemPrivateKey(getway_signature_private_str);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes("UTF-8"));
        byte[] result = signature.sign();
        String resultStr = Base64.encode(result);
        return resultStr;
    }

    public static Boolean rsaAttestation(String data , String sing) throws Exception {
        String publicKeyPath = "/Users/chenkai/home/unionPay/spayupi_qa_pub.pem";
        PublicKey publicKey = CertificateRead.getPublicKey(publicKeyPath);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(data.getBytes("UTF-8"));
        boolean result = signature.verify(Base64.decode(sing));
        if(result){
            System.out.println("验签成功");
        }else {
            System.out.println("验签失败");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String data = "123456";
        String sign = rsaSing(data);
        Boolean result = rsaAttestation(data, sign);
        System.out.println(result.toString());
    }
}
