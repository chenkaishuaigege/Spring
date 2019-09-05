package com.rrtx.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.rrtx.encryption.CertificateRead;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.*;

public class JWTUtil {


    /**
     * scis 公钥用作加密
     */
    static String keyEnc  = "MIIC9jCCAd6gAwIBAgIGAWtvA+wTMA0GCSqGSIb3DQEBCwUAMD0xCzAJBgNVBAYTAkNOMREwDwYDVQQHEwhTaGVuemhlbjEMMAoGA1UEChMDVVBJMQ0wCwYDVQQDEwRVQUdTMB4XDTE5MDYxOTA5MTQxNloXDTI5MDYxOTA5MTQxNlowPTELMAkGA1UEBhMCQ04xETAPBgNVBAcTCFNoZW56aGVuMQwwCgYDVQQKEwNVUEkxDTALBgNVBAMTBFVBR1MwggEgMA0GCSqGSIb3DQEBAQUAA4IBDQAwggEIAoIBAQCZJq2oJ0WK5Dk3c11m4YvPmJ+oVbph1sanV/2ANIsz7rDboP3AJqEaPsZUNwldYJmyBwvcndBZZJRWcjt8YG9dkd/gcFyOs45Uf+C2oZY/8aWduwjMTA3VpAbMdp6XUGl0jy4Zad7MUVzBuVGmTWpzk0SvnhKH7oIURw1D0cUJlm0k3QVAC5MEmIGGwa249w+O/5Skh6nPIwnL+sFOgNImBuwanoJ+1xTZj9IX+mbmnUCeKIaqXhnuSPN+Tfw6vDNgBxmY3tky1yHNjdEqRp5L699oZeKZ60vQrzSa0H47G++MFsObKEDrOC3mmaIqKqxIxWhFicYnCfqk82EOgfB7AgEDMA0GCSqGSIb3DQEBCwUAA4IBAQBNWMVfSS+Qaw8sz6Q/byV127ul6INnI1wTblgPTUYqpDdZUEodYVGfZJ46ywANECDyWdAtPuk7lrhLsmyPtC3QFGxeFSRvNIGdLBQhuKnaRKXfJY64RI24F0j79vKf9P1cWBTfJfbP4ZJNLE7+692vTP31wjSpfBtRt8vvutn3pZXQJDBPYYrVKrNIEa4/Ckr8PdiSFPxR3Ata3qm0U9zMX4em/63pZkTOcYYSVvzOTP29CEHB+COMNo2+RzsNXmo0EWd+G6GiVquQlIfAr5fSkm45B6rnmxWRUELKV6YGHY36sLru7wgWsatgKmhiMrYsxfSPiY6j9FLiAKocwjqb";

    /**
     * 我们私钥用作签名
     */
    static String keySing = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA2LWgvur2Cv5hyKGOLpfnUjOaMeRRjbrJRXuV7hyMtl22r0o4s3HnSVscN2h/OvFfM57lSaJHEioDDTOS81GHgwIDAQABAkEApJVEkNrHpE/QGdzArBhH4YE5UTzyxy4d4DxdAOsD3xdldl+VY1jA/zyC8z8b5wrvSVwkIsfnOxP3t0RDj1cMCQIhAO4AYWgczdshemVRuvD0B6Zu+L3WFvCKoG6uX2lTzWaPAiEA6RkK0EZqAhXL2iAPUI5W6yVQ7R2pEQcGTpBMME++qc0CIQDswm4j7vuN8QjcP+jTCD+P/rbtykr5sT4VvNtnYRlk2wIgP+dkporXXzD4jRlC+ZO8UoUNdaQvCIMDgKBgstH59HUCIHdnUzOg1OG9d4VbYlaZZEAVhRm/nPBRg9zfVvXvjdDY";


//    static PublicKey publicKey;
//    static PrivateKey privateKey;

//    static {
//        try {
//            publicKey = RSAUtil.getPublicKey(keyEnc);
//            privateKey = RSAUtil.getPrivateKey(keySing);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    public static String jweEncryption(String data) {
        String jwtString = "";

        PublicKey publicKey = CertificateRead.getPublicKey();
//        KeyPairGenerator keyPairGenerator;
        try {
//            keyPairGenerator = KeyPairGenerator.getInstance("RSA");

//            keyPairGenerator.initialize(1024);

            // generate the key pair
//            KeyPair keyPair = keyPairGenerator.genKeyPair();

            // create KeyFactory and RSA Keys Specs
            //生成公钥私钥
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
            //RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);

            // generate (and retrieve) RSA Keys from the KeyFactory using Keys Specs
            //生成公钥私钥
            RSAPublicKey publicRsaKey = (RSAPublicKey) publicKey;
            //RSAPrivateKey privateRsaKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);

            JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
            claimsSet.subject(data);
//            claimsSet.issuer("https://my-auth-server.com");
//            claimsSet.subject("John Kerr");
//            claimsSet.audience(getAudience());
//            claimsSet.expirationTime(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
//            claimsSet.notBeforeTime(new Date());
//            claimsSet.jwtID(UUID.randomUUID().toString());
//            System.out.println("--------------------------");
//            System.out.println("Claim Set : \n" + claimsSet.build());

            // create the JWT header and specify:
            //  RSA1_5 as the encryption algorithm
            //  A128CBC_HS256 as the encryption method
            //创建JWT报头并指定:
            // RSA-OAEP作为加密算法
            // 128位AES/GCM作为加密方法
            String kid = "20190411000000";
            JWEHeader header = new JWEHeader(JWEAlgorithm.RSA1_5, com.nimbusds.jose.EncryptionMethod.A128CBC_HS256,null, null, null, null, null, null, null, null, null, kid, null, null, null, null, null, 0, null, null, null, null);

            // create the EncryptedJWT object
            // 创建EncryptedJWT对象
            EncryptedJWT jwt = new EncryptedJWT(header, claimsSet.build());

            // create an RSA encrypter with the specified public RSA key
            // 使用指定的公共RSA密钥创建RSA加密器
            RSAEncrypter encrypter = new RSAEncrypter(publicRsaKey);

            // do the actual encryption
            // 进行实际加密
            jwt.encrypt(encrypter);

            // serialize to JWT compact form
            // 序列化为JWT紧凑形式
            jwtString = jwt.serialize();
            System.out.println("\nJwt Compact Form : " + jwtString);

            // in order to read back the data from the token using your private RSA key:
            // parse the JWT text string using EncryptedJWT object
//            jwt = EncryptedJWT.parse(jwtString);

            // create a decrypter with the specified private RSA key
//            RSADecrypter decrypter = new RSADecrypter(privateRsaKey);

            // do the decryption
//            jwt.decrypt(decrypter);

            // print out the claims

            System.out.println("===========================================================");
            System.out.println("JWE Protected Header :");
            System.out.println(jwt.getHeader().toString());
            System.out.println("JWE Encrypted Key :");
            System.out.println(jwt.getEncryptedKey().toString());
            System.out.println("JWE Initialization Vector :");
            System.out.println(jwt.getIV().toString());
            System.out.println("JWE Ciphertext :");
            System.out.println(jwt.getCipherText().toString());
            System.out.println("JWE Authentication Tag :");
            System.out.println(jwt.getAuthTag().toString());

//            System.out.println("Issuer: [ " + jwt.getJWTClaimsSet().getIssuer() + "]");
//            System.out.println("Subject: [" + jwt.getJWTClaimsSet().getSubject() + "]");
//            System.out.println("Audience size: [" + jwt.getJWTClaimsSet().getAudience().size() + "]");
//            System.out.println("Expiration Time: [" + jwt.getJWTClaimsSet().getExpirationTime() + "]");
//            System.out.println("Not Before Time: [" + jwt.getJWTClaimsSet().getNotBeforeTime() + "]");
//            System.out.println("Issue At: [" + jwt.getJWTClaimsSet().getIssueTime() + "]");
//            System.out.println("JWT ID: [" + jwt.getJWTClaimsSet().getJWTID() + "]");
            System.out.println("===========================================================");

        } catch (JOSEException e) {
            System.out.println(e.getMessage());
        }
        return jwtString;
    }

    public static String jwsSignature(String data) {
            String jwtString = "";

            PrivateKey privateKey = CertificateRead.getPrivateKey();

            KeyPairGenerator keyPairGenerator;
            try {
                keyPairGenerator = KeyPairGenerator.getInstance("RSA");

                keyPairGenerator.initialize(1024);

                // generate the key pair
                KeyPair keyPair = keyPairGenerator.genKeyPair();

                // create KeyFactory and RSA Keys Specs
                //生成公钥私钥
//                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//                RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
//                RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);

                // generate (and retrieve) RSA Keys from the KeyFactory using Keys Specs
                //生成公钥私钥
//                RSAPublicKey publicRsaKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
//                RSAPrivateKey privateRsaKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
                RSAPrivateKey privateRsaKey = (RSAPrivateKey)privateKey;

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
                //证书序列号
                String upi_certid = "1560936206326";
                //银联定义 的 机构ID/钱包ID
                String upi_appid = "39990061";

                customParams.put("UPI-UUID" , uuid);
                customParams.put("UPI-TIMESTAMP" , upi_timestamp);
                customParams.put("UPI-APPID" , upi_appid);
                //UnionPayServiceImpl unionPayServiceImpl = new UnionPayServiceImpl();
                //String service_URL_suffix = unionPayServiceImpl.getServiceUrlSuffix("");
                String service_URL_suffix = "/scis/switch/cvminquiry";
                customParams.put("UPI-REQPATH" , service_URL_suffix);

                JWSHeader header = new JWSHeader(JWSAlgorithm.RS256,null, null,crit, null, null, null, null, null, null, kid,customParams, null);

                JWSSigner signer = new RSASSASigner(privateRsaKey);

                // create the EncryptedJWT object
                // 创建EncryptedJWT对象
                SignedJWT jwt = new SignedJWT(header, claimsSet.build());
                try {
                    jwt.sign(signer);
                } catch (JOSEException e) {
                    e.printStackTrace();
                    return "";
                }
//                // create an RSA encrypter with the specified public RSA key
//                // 使用指定的公共RSA密钥创建RSA加密器
//                RSAEncrypter encrypter = new RSAEncrypter(publicRsaKey);
//                byte[] var2 = new byte[0];
//                JWSSigner JWSSigner = new JWSSigner().sign();
//                // do the actual encryption
//                // 进行实际加密
//                jwt.sign();
                // serialize to JWT compact form
                // 序列化为JWT紧凑形式
                jwtString = jwt.serialize();
                System.out.println("\nJwt Compact Form : " + jwtString);
                System.out.println("===========================================================");
                System.out.println(jwt.getHeader().toString());
                System.out.println(jwt.getPayload());
                System.out.println("===========================================================");

            } catch (NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
            }
            return jwtString;
    }

    private static List<String> getAudience() {
        List<String> audience = new ArrayList<>();
        audience.add("https://my-web-app.com");
        audience.add("https://your-web-app.com");
        return audience;
    }

    public static void main(String[] args) {
        //jweEncryption("12341234");
        jwsSignature("12341234");
    }
}