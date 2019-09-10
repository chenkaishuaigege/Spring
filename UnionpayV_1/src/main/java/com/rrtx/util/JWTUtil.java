package com.rrtx.util;

import cn.hutool.core.codec.Base64;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.rrtx.encryption.CertificateRead;
import com.rrtx.encryption.UnionPaySingleton;
import com.rrtx.service.impl.UnionPayServiceImpl;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.StringUtil;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.*;

import static com.rrtx.encryption.RSAUtil.encryptWithPrivateResultBase64;
import static com.rrtx.encryption.UnionPaySingleton.getSingletonMethod;


/**
 * JWT 工具类
 * jweEncryption    jwe加密----公钥加密(scis的 加密 公钥)
 * jwsSignature     jws签名----私钥签名(spay的 签名 私钥)
 * jweDecryption    jwe解密----私钥解密(spay的 加密 私钥)
 * jwsAttestation   jws验签----公钥验签(scis的 签名 公钥)
 */
public class JWTUtil {

    static RSAPublicKey publicRsaKey = null;
    static RSAPrivateKey privateRsaKey = null;


    static{
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

                keyPairGenerator.initialize(1024);

                // generate the key pair
                KeyPair keyPair = keyPairGenerator.genKeyPair();

                // create KeyFactory and RSA Keys Specs
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
                RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);

                // generate (and retrieve) RSA Keys from the KeyFactory using Keys Specs
                publicRsaKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
                privateRsaKey  = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
            } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

    /**
     *jwe加密
     * @param data      被加密数据
     * @return
     */
    public static String jweEncryption(String data) {
        //加密结果
        String jwtString = "";
        //加密使用的公钥:scis提供的 加密 公钥文件
        String scis_encryption_public_file = getSingletonMethod().getScis_encryption_public_file();
        //生成公钥
        PublicKey publicKey = CertificateRead.getPublicKey(scis_encryption_public_file);
            //生成公钥
            RSAPublicKey publicRsaKey = (RSAPublicKey) publicKey;

            JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
            claimsSet.subject(data);
            //创建JWT报头并指定:
            // RSA-OAEP作为加密算法
            // 128位AES/GCM作为加密方法
            String kid = "1560935656467";
            JWEHeader header = new JWEHeader(JWEAlgorithm.RSA1_5, com.nimbusds.jose.EncryptionMethod.A128CBC_HS256,null, null, null, null, null, null, null, null, null, kid, null, null, null, null, null, 0, null, null, null, null);

            // 创建EncryptedJWT对象
            EncryptedJWT jwt = new EncryptedJWT(header, claimsSet.build());

            // 使用指定的公共RSA密钥创建RSA加密器
            RSAEncrypter encrypter = new RSAEncrypter(publicRsaKey);

            // 进行实际加密
            try {
                jwt.encrypt(encrypter);
            } catch (JOSEException e) {
                e.printStackTrace();
            }

            // 序列化为JWT紧凑形式
            jwtString = jwt.serialize();
//            System.out.println("\nJwt Compact Form : " + jwtString);
//
//            // print out the claims
//            System.out.println("===========================================================");
//            System.out.println("JWE Protected Header :");
//            System.out.println(jwt.getHeader().toString());
//            System.out.println("JWE Encrypted Key :");
//            System.out.println(jwt.getEncryptedKey().toString());
//            System.out.println("JWE Initialization Vector :");
//            System.out.println(jwt.getIV().toString());
//            System.out.println("JWE Ciphertext :");
//            System.out.println(jwt.getCipherText().toString());
//            System.out.println("JWE Authentication Tag :");
//            System.out.println(jwt.getAuthTag().toString());
//            System.out.println("===========================================================");
        return jwtString;
    }

    /**
     *jwe加密
     * @param data      被加密数据
     * @return
     */
    public static String jweEncryptionNew(String data) throws Exception {

        //BASE64URL(UTF8(JWE Protected Header)) || '.' || BASE64URL(JWE Encrypted Key) || '.' || BASE64URL(JWE Initialization Vector) || '.' || BASE64URL(JWE Ciphertext) || '.' || BASE64URL(JWE Authentication Tag)
        Map map = new HashMap();
        String kid = "1560935656467";
        map.put("alg" , "RSA1_5");
        map.put("enc" , "A128CBC-HS256");
        map.put("kid" , kid);
        String JWEProtectedHeaderString = JsonMapCoverUtill.coverMap2JsonString(map);
        //BASE64URL(UTF8(JWE Protected Header))
        String JWEProtectedHeader = cn.hutool.core.codec.Base64.encodeUrlSafe(JWEProtectedHeaderString.getBytes("UTF-8"));
        //BASE64URL(JWE Encrypted Key)
        //BASE64URL(JWE Initialization Vector)
        //BASE64URL(JWE Ciphertext)
        //BASE64URL(JWE Authentication Tag)








        //加密结果
        String jwtString = "";
        //加密使用的公钥:scis提供的 加密 公钥文件
        String scis_encryption_public_file = getSingletonMethod().getScis_encryption_public_file();
        //生成公钥
        PublicKey publicKey = CertificateRead.getPublicKey(scis_encryption_public_file);
        //生成公钥
        RSAPublicKey publicRsaKey = (RSAPublicKey) publicKey;

        JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
        claimsSet.subject(data);
        //创建JWT报头并指定:
        // RSA-OAEP作为加密算法
        // 128位AES/GCM作为加密方法

        JWEHeader header = new JWEHeader(JWEAlgorithm.RSA1_5, com.nimbusds.jose.EncryptionMethod.A128CBC_HS256,null, null, null, null, null, null, null, null, null, kid, null, null, null, null, null, 0, null, null, null, null);

        // 创建EncryptedJWT对象
        EncryptedJWT jwt = new EncryptedJWT(header, claimsSet.build());

        // 使用指定的公共RSA密钥创建RSA加密器
        RSAEncrypter encrypter = new RSAEncrypter(publicRsaKey);

        // 进行实际加密
        try {
            jwt.encrypt(encrypter);
        } catch (JOSEException e) {
            e.printStackTrace();
        }

        // 序列化为JWT紧凑形式
        jwtString = jwt.serialize();
        return jwtString;
    }


    public static String jweDecryption(String data) throws Exception {{
            // 创建EncryptedJWT对象
            Base64URL[] base64URL = EncryptedJWT.split(data);
            EncryptedJWT jwt = new EncryptedJWT(base64URL[0],base64URL[1],base64URL[2],base64URL[3],base64URL[4]);
            RSADecrypter decrypter = new RSADecrypter(privateRsaKey);
            jwt.decrypt(decrypter);
            System.out.println("===========================================================");
//            System.out.println("Issuer: [ " + jwt2.getJWTClaimsSet().getIssuer() + "]");
//            System.out.println("Subject: [" + jwt2.getJWTClaimsSet().getSubject()+ "]");
//            System.out.println("Audience size: [" + jwt2.getJWTClaimsSet().getAudience().size()+ "]");
//            System.out.println("Expiration Time: [" + jwt2.getJWTClaimsSet().getExpirationTime()+ "]");
//            System.out.println("Not Before Time: [" + jwt2.getJWTClaimsSet().getNotBeforeTime()+ "]");
//            System.out.println("Issue At: [" + jwt2.getJWTClaimsSet().getIssueTime()+ "]");
//            System.out.println("JWT ID: [" + jwt2.getJWTClaimsSet().getJWTID()+ "]");
            System.out.println("===========================================================");

        return "";
    }}

    public static String jwsSignature(String data) throws Exception {

        String jwtString = "";
        JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
        claimsSet.subject(data);
        // create the JWT header and specify:
        //  RSA1_5 as the encryption algorithm
        //  A128CBC_HS256 as the encryption method
        //创建JWT报头并指定:
        // RSA-OAEP作为加密算法
        // 128位AES/GCM作为加密方法
        String kid = "1555570302";

        Set<String> crit = new HashSet<>();
        crit.add("UPI-UUID");
        crit.add("UPI-TIMESTAMP");
        crit.add("UPI-APPID");
        crit.add("UPI-REQPATH");
        Map<String, Object> customParams = new HashMap<>();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        long upi_timestamp_long = System.currentTimeMillis() / 1000;
        String upi_timestamp = String.valueOf(upi_timestamp_long);

        //银联定义 的 机构ID/钱包ID
        String upi_appid = UnionPaySingleton.getSingletonMethod().getUpi_appid();

        customParams.put("UPI-UUID" , uuid);
        customParams.put("UPI-TIMESTAMP" , upi_timestamp);
        customParams.put("UPI-APPID" , upi_appid);

        String service_URL_suffix = "/scis/switch/cvminquiry";

        customParams.put("UPI-REQPATH" , service_URL_suffix);

        JWSHeader header = new JWSHeader(JWSAlgorithm.RS256,null, null,crit, null, null, null, null, null, null, kid,customParams, null);

        PrivateKey privateKey = CertificateRead.getPemPrivateKey("MIIEpAIBAAKCAQEAwtRaXXy+TJ0GUovLeggeMnfefdYc9YKk1x7SstPWvw7L4sNrTdtPARVXycpc4f19o5P1fCh3o0K5w2skk1TT3GetHP/b6obZ1K4php7rjHGWp9139LwWh2qlau14MPKxPiS4JhauRMjVwV4PwfAtjM3ewHtYF8YR5lmQlefXDEfI3rHkuzR/r+YK4NCzHpxrkcQz4B/5B4Bl31cXMHjVaFu+vRwB4rUUNQkCaTtcaY7J+YDh2/3zKhH4P/omsa7TUZjtyqqcVjNlq/HiXa3f3Kv4MxBxNmLvoOdNC6cWJlgLaL0Sl8Bh/RGCCLPqcc6cb2+SBF/3/jBBAmWufzm0XQIDAQABAoIBAHPo/nIMGvNdoDtP7BiH599CrV3UGpp9xTAuqE+39FTqqqYYeShyx0fvuLDW8feJZkwBZNUfBj5dHkOC5Nm6Z+kCzV0pY17eJ45+pznuJlkB4w2vlwRFOmoKKqu45/7HBGfiVKRkbf2CNpm6KknJaHASsul0+G38av3OX1Sv/6LPr4p2vlKcMNiWKfjpmLpD3O3KstVBDY+wvrS9JRbRm/1MVqCR0J1/NwSH7wkyXn1hPxYUIIfS/pp/tzz2pk7DboYEs3t7SIfFItbCojc/5thrgvksHFqVD3DC5NgpiyFtpRIO87jQoHq5SiaYIkzmpTBdg5tN2v187RuFP00oXskCgYEA9BYbRcuT6tjwy1yk/b7eWr162PLrS/Ra8WHhoJuCA3OWVtkWKVHXS/EwO8lyCmou9B6K+Uig5yziL0WEytw5yNQ5Dum3C5y0DkNtvPRU2LWHLtRL/KiSYXiC3Zu5JUk/F2c9fgwbRj9qz4DvULTPEozlLmwekAUtvK+n+eYJ4+8CgYEAzFbGcNyR6sEjy73Exb/+NKQsxtr0IQjqMIz7OPgC0SzoDCJr0WaLXXsSacbKhHAEyob2jEYt4BtLlhoophwesUOqlFRfd6ZGZiEi7TxELKQ02bpGMsX7dLx5kQwPsZOEJJTcV9b6fpYga9tjUOQBgfx4h8D0Kg/H0JoA9cEssHMCgYEAp82W3EnTnA2epUBA0Y1pkhpXnVSLfME10GKJWf/uxu6s+XHu8WMpTzU2ArQ/6XcMZpmk0zIiJCvQJ810OH5kX3O+8kispZgKlQ+4HsIenolVsVUUFFPTppzR4wZOp5qOfElmlgQ+r/GjPZqXa/WRsmAYouyDqmFVCzX7liqWvBMCgYApxIMDhtJ8vcXnW37hPQFlGTnd29uS9ROJoQeo+Wj6AMfd0xtezismjIWTAYNb1tnj2/qBacbuzCWDJQ2yBoVvjnlLoINzHZW+Qn+1JmB5D4eOCblXn4hqsCvZLjH3BkQ4hgUUH2lMfrtZ0JpYaoK0Yzrv5M0D2/3n8dLIaRgNaQKBgQCAG4H9A4A08CBc0DpqSoJ6ZpRv15IicRasf6REB+Uh3XEwlKg7h+QUVP8QC9oxBYcSl+6+WQ1w6lrQEQYu/QwdRtPuYDsGjAvNLPX3qwzcDIwWUSUEDe80bq8gMWgQzhxpD4erQXjQQcBHTuf9/3EcK0H6NRXpOv+nsVVWyg5r+g==");
        JWSSigner signer = new RSASSASigner((RSAPrivateKey)privateKey);

        // create the EncryptedJWT object
        // 创建EncryptedJWT对象
        SignedJWT jwt = new SignedJWT(header, claimsSet.build());
        try {
            jwt.sign(signer);
        } catch (JOSEException e) {
            e.printStackTrace();
            return "";
        }
        // 序列化为JWT紧凑形式
        jwtString = jwt.serialize();
        System.out.println("\nJwt Compact Form : " + jwtString);
        System.out.println("===========================================================");
        System.out.println(jwt.getHeader().toString());
        System.out.println(jwt.getPayload());
        System.out.println("===========================================================");
        return jwtString;
    }


    public static boolean jwsAttestation(String onlinemessage ,String upi_jwsEnc) throws Exception {
        System.out.println("返回的jws");
        System.out.println(upi_jwsEnc);
        upi_jwsEnc = upi_jwsEnc.replaceAll("\r|\n", "");
        String[] upi_jws = upi_jwsEnc.split("\\.\\.");

        // 签名头
        //{"alg":"RS256","kid":"1560936206326",
        // "crit":["UPI-UUID","UPI-TIMESTAMP","UPI-APPID"],
        // "UPI-UUID":"eff7fafc2c6f421688798cdebc3f9ba1","UPI-TIMESTAMP":"1568080653","UPI-APPID":"39990061"}

        // 待签信息
        String signStr = upi_jws[1].replaceAll("\r|\n", "");

        //验签使用的公钥:getway 提供的 验签 公钥文件
        String scis_attestation_public_file = getSingletonMethod().getScis_attestation_public_file();
        //生成公钥SHA256withRSA
        PublicKey publicKey = CertificateRead.getPublicKey(scis_attestation_public_file);

        Signature signature = Signature.getInstance("");
        signature.initVerify(publicKey);
        signature.update(cn.hutool.core.codec.Base64.encodeUrlSafe(onlinemessage.getBytes("UTF-8")).getBytes());
        boolean result = signature.verify(signStr.getBytes());
        if(result){
            System.out.println("验签成功");
        }else {
            System.out.println("验签失败");
        }
        return result;
    }

    public static String jwsSignatureNew(String data) throws Exception {
        //加密使用的公钥:scis提供的 加密 公钥文件
        String getway_signature_private_str = getSingletonMethod().getGetway_signature_private_str();
        //生成公钥
        PrivateKey privateKey = CertificateRead.getPemPrivateKey(getway_signature_private_str);

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        String upi_timestamp = String.valueOf(System.currentTimeMillis() / 1000);

        //银联定义 的 机构ID/钱包ID
        String upi_appid = UnionPaySingleton.getSingletonMethod().getUpi_appid();
//        data = data.replace("\\" , "");
//        data = data.replace("\"" , "");
//        Map<String, Object> fsdaf = JsonMapCoverUtill.coverJsonString2Map(data);
//        Object msgInfo = fsdaf.get("msgInfo");
//
//        Object fdsa = fsdaf.get("msgType");
//        String service_URL_suffix = UrlSuffixUtil.getServiceUrlSuffix(fdsa.toString());
        String service_URL_suffix = "/scis/switch/kycverify";
        String kid = getSingletonMethod().getKid();
        Set<String> crit = new HashSet<>();
        crit.add("UPI-UUID");
        crit.add("UPI-TIMESTAMP");
        crit.add("UPI-APPID");
        crit.add("UPI-REQPATH");

        Map map = new HashMap();
        map.put("alg" , "RS256");
        map.put("kid" , kid);
        map.put("crit" , crit);
        map.put("UPI-UUID" , uuid);
        map.put("UPI-TIMESTAMP" , upi_timestamp);
        map.put("UPI-APPID" , upi_appid);
        map.put("UPI-REQPATH" , service_URL_suffix);

        String JWSProtectedHeaderString = JsonMapCoverUtill.coverMap2JsonString(map);

        String JWSProtectedHeader = cn.hutool.core.codec.Base64.encodeUrlSafe(JWSProtectedHeaderString.getBytes("UTF-8"));

        String JWSPayload = cn.hutool.core.codec.Base64.encodeUrlSafe(data.getBytes("UTF-8"));
        String tempSing = JWSProtectedHeader + "." + JWSPayload;
        System.out.println("待签名字符串组成部分-JWS Protected Header:");
        System.out.println(JWSProtectedHeader);
        System.out.println("待签名字符串组成部分-JWS Payload");
        System.out.println(JWSPayload);
        System.out.println("待签名字符串:");
        System.out.println(tempSing);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(tempSing.getBytes("UTF-8"));
        byte[] result = signature.sign();
        String JWSSignature = Base64.encode(result);
        String headerSign = JWSProtectedHeader + ".." + JWSSignature;
        System.out.println();
        return headerSign;
    }

    public static void main(String[] args) throws Exception {
//        String message = jweEncryption("12341234");
//        System.out.println("密文:");
//        System.out.println(message);
//        //jwsSignature("12341234");
//        String message2 = jweDecryption(message);
//        System.out.println("明文");
//        System.out.println(message2);
//        String data = "1234567890";
//        String message = jwsSignatureNew(data);
//        System.out.println(message);
//        jwsAttestation(data , message , "SHA256withRSA");


        String fdas = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjE1NjA5MzYyMDYzMjYiLCJjcml0IjpbIlVQSS1VVUlEIiwiVVBJLVRJTUVTVEFNUCIsIlVQSS1BUFBJRCJdLCJVUEktVVVJRCI6IjgxNGExYzc2ZWNjZjRlOGZhZGYxZWQxMzVmNGQ2M2MwIiwiVVBJLVRJTUVTVEFNUCI6IjE1NjgwMzA5NjkiLCJVUEktQVBQSUQiOiIzOTk5MDA2MSJ9..brmgdMvscnUlIWzUgYl3zvWMzfQcXjwQlLQG9sshzA-5oPDNR84JpBY3YplvTiZclRW7Jnr32Xae7XDHC9emyBfjjhAwtv3BHDbCfkCb3xiGkrOyatJ5upIq9tzkM7_ClFVn6rHPB6mPepcmTaQR1nKogHUpGJ3p8YY6ODzKpsKerOKi6eFz4NWsXmuZ9_JhSnJtiHu6Ff2IGfN8zjxcO3ecCcqkzlou_xkmHOidwvAPXwfOciQVlyCpSodbDXhQZbuPopJwenCbMKKm5vMlW6av_0eL_aeiAwgNARiQ2eHfouY36WRqegjrrsfy2mARkLfGoEgA-zng485m-J35_g";
        //fdas.concat()
        String[] fdsaf = fdas.split("\\.\\.");
    }
}