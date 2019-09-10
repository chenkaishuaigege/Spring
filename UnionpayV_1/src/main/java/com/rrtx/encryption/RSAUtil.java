package com.rrtx.encryption;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

/**
* 私钥和公钥同时为空
*/
public class RSAUtil {

    static RSA rsa = null;

    private static PrivateKey privateKey = null;

    private static PublicKey publicKey = null;

    static {
        String rsaAlgorithm = "RSA/ECB/PKCS1Padding";

//        String privateKey = getPrivateKeyInfo();
//        String publicKey = getPublicKeyInfo();
//        String privateKey = getPrivateKeyInfo();
//        String publicKey = getPublicKeyInfo();

//        //公钥 自己生成
//        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyl1OaA/EE2/zLcUQzGhjcLZ/2BgM2NXcWdXtKZMLW8xXm1+sc6ujFnAJKu44uofUsVN7XkZuXchoYtZyE+1Mqvu9uugCizDWK75eLir5nvX7AXLLB4LyrRmBS2+m0VTO6l4WH1s/z+gvENg62+Xc9QPK2l2FqkpkUaiytWJXYTCSZBBeWN9zAX3FreIxOFcXUsDAp6lZ1LWeeMBKk7+K3h1vdhL3ZODfII/IvYTOykdYYD30cFiCoAfELo40xMJzC0RkhCIOQlUDptjKV+Pd3NznWw5T1BGy5wDB63gsObRKFe2/YBDeUcEw+5lFj4N61qwd/fAUeIPjLuVsq+KKTQIDAQAB";
//        //私钥 自己生成
        String privateKeyStr = "MIIEpAIBAAKCAQEAwtRaXXy+TJ0GUovLeggeMnfefdYc9YKk1x7SstPWvw7L4sNrTdtPARVXycpc4f19o5P1fCh3o0K5w2skk1TT3GetHP/b6obZ1K4php7rjHGWp9139LwWh2qlau14MPKxPiS4JhauRMjVwV4PwfAtjM3ewHtYF8YR5lmQlefXDEfI3rHkuzR/r+YK4NCzHpxrkcQz4B/5B4Bl31cXMHjVaFu+vRwB4rUUNQkCaTtcaY7J+YDh2/3zKhH4P/omsa7TUZjtyqqcVjNlq/HiXa3f3Kv4MxBxNmLvoOdNC6cWJlgLaL0Sl8Bh/RGCCLPqcc6cb2+SBF/3/jBBAmWufzm0XQIDAQABAoIBAHPo/nIMGvNdoDtP7BiH599CrV3UGpp9xTAuqE+39FTqqqYYeShyx0fvuLDW8feJZkwBZNUfBj5dHkOC5Nm6Z+kCzV0pY17eJ45+pznuJlkB4w2vlwRFOmoKKqu45/7HBGfiVKRkbf2CNpm6KknJaHASsul0+G38av3OX1Sv/6LPr4p2vlKcMNiWKfjpmLpD3O3KstVBDY+wvrS9JRbRm/1MVqCR0J1/NwSH7wkyXn1hPxYUIIfS/pp/tzz2pk7DboYEs3t7SIfFItbCojc/5thrgvksHFqVD3DC5NgpiyFtpRIO87jQoHq5SiaYIkzmpTBdg5tN2v187RuFP00oXskCgYEA9BYbRcuT6tjwy1yk/b7eWr162PLrS/Ra8WHhoJuCA3OWVtkWKVHXS/EwO8lyCmou9B6K+Uig5yziL0WEytw5yNQ5Dum3C5y0DkNtvPRU2LWHLtRL/KiSYXiC3Zu5JUk/F2c9fgwbRj9qz4DvULTPEozlLmwekAUtvK+n+eYJ4+8CgYEAzFbGcNyR6sEjy73Exb/+NKQsxtr0IQjqMIz7OPgC0SzoDCJr0WaLXXsSacbKhHAEyob2jEYt4BtLlhoophwesUOqlFRfd6ZGZiEi7TxELKQ02bpGMsX7dLx5kQwPsZOEJJTcV9b6fpYga9tjUOQBgfx4h8D0Kg/H0JoA9cEssHMCgYEAp82W3EnTnA2epUBA0Y1pkhpXnVSLfME10GKJWf/uxu6s+XHu8WMpTzU2ArQ/6XcMZpmk0zIiJCvQJ810OH5kX3O+8kispZgKlQ+4HsIenolVsVUUFFPTppzR4wZOp5qOfElmlgQ+r/GjPZqXa/WRsmAYouyDqmFVCzX7liqWvBMCgYApxIMDhtJ8vcXnW37hPQFlGTnd29uS9ROJoQeo+Wj6AMfd0xtezismjIWTAYNb1tnj2/qBacbuzCWDJQ2yBoVvjnlLoINzHZW+Qn+1JmB5D4eOCblXn4hqsCvZLjH3BkQ4hgUUH2lMfrtZ0JpYaoK0Yzrv5M0D2/3n8dLIaRgNaQKBgQCAG4H9A4A08CBc0DpqSoJ6ZpRv15IicRasf6REB+Uh3XEwlKg7h+QUVP8QC9oxBYcSl+6+WQ1w6lrQEQYu/QwdRtPuYDsGjAvNLPX3qwzcDIwWUSUEDe80bq8gMWgQzhxpD4erQXjQQcBHTuf9/3EcK0H6NRXpOv+nsVVWyg5r+g==";
//         String publicKey_path_spay = "/Users/chenkai/home/unionPay/rsa_public_key.pem";
//         String privateKey_path_spay = "/Users/chenkai/home/unionPay/rsa_private_key.pem";
//         String privateKey_password_spay = "";
//        PrivateKey privateKey = null;
//        PublicKey publicKey = null;
        //生成公钥
//        PublicKey publicKey = null;
        try {
            privateKey = CertificateRead.getPemPrivateKey(privateKeyStr);
            publicKey = CertificateRead.getPublicKey("/Users/chenkai/home/unionPay/spayupi_qa_pub.pem");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //生成公钥
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
