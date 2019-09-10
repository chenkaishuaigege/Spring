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
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.*;
import static com.rrtx.encryption.UnionPaySingleton.getSingletonMethod;


/**
 * JWT 工具类
 * jweEncryption    jwe加密----公钥加密(scis的 加密 公钥)
 * jwsSignature     jws签名----私钥签名(spay的 签名 私钥)
 * jweDecryption    jwe解密----私钥解密(spay的 加密 私钥)
 * jwsAttestation   jws验签----公钥验签(scis的 签名 公钥)
 */
public class JWTUtil {

//    static RSAPublicKey publicRsaKey = null;
//    static RSAPrivateKey privateRsaKey = null;


//    static{
//            try {
//                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//
//                keyPairGenerator.initialize(1024);
//
//                // generate the key pair
//                KeyPair keyPair = keyPairGenerator.genKeyPair();
//
//                // create KeyFactory and RSA Keys Specs
//                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//                RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
//                RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);
//
//                // generate (and retrieve) RSA Keys from the KeyFactory using Keys Specs
//                publicRsaKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
//                privateRsaKey  = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
//            } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//        }

    /**
     * jwe加密
     * @param data      被加密数据
     * @return
     */
    public static String jweEncryption(String data){
        //定义加密结果
        String jwtString = "";
        //加密使用的公钥:scis提供的 加密 公钥文件
        String scis_encryption_public_file = getSingletonMethod().getScis_encryption_public_file();
        //生成公钥
        PublicKey publicKey = null;
        try {
            publicKey = CertificateRead.getPublicKey(scis_encryption_public_file);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        RSAPublicKey publicRsaKey = (RSAPublicKey) publicKey;
        JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
        claimsSet.subject(data);
        //创建JWT报头并指定:
        // RSA-OAEP作为加密算法
        // 128位AES/GCM作为加密方法
        String kid = getSingletonMethod().getKid_encryption();
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
            return "";
        }
        // 序列化为JWT紧凑形式
        jwtString = jwt.serialize();
        return jwtString;
    }


    /**
     * 解密
     * @param data
     * @return
     * @throws Exception
     */
    public static String jweDecryption(String data) throws Exception {{
            // 创建EncryptedJWT对象
            Base64URL[] base64URL = EncryptedJWT.split(data);
            EncryptedJWT jwt = new EncryptedJWT(base64URL[0],base64URL[1],base64URL[2],base64URL[3],base64URL[4]);

            //加密使用的公钥:scis提供的 加密 公钥文件
            String getway_decryption_private_str = getSingletonMethod().getGetway_decryption_private_str();

            PrivateKey privateKey = CertificateRead.getPemPrivateKey(getway_decryption_private_str);

            RSADecrypter decrypter = new RSADecrypter(privateKey);
            jwt.decrypt(decrypter);

        return "";
    }}


    /**
     * 验签
     * @param onlinemessage
     * @param upi_jwsEnc
     * @return
     * @throws Exception
     */
    public static boolean jwsAttestation(String onlinemessage ,String upi_jwsEnc) throws Exception {

        System.out.println("返回的jws");
        System.out.println(upi_jwsEnc);
        upi_jwsEnc = upi_jwsEnc.replaceAll("\r|\n", "");
        String[] upi_jws = upi_jwsEnc.split("\\.\\.");

        // 待签信息
        String signStr = upi_jws[1].replaceAll("\r|\n", "");

        String JWSProtectedHeaderString = upi_jws[0].replaceAll("\r|\n", "");

        //待验签第一部分
        String JWSProtectedHeader = JWSProtectedHeaderString;
        //待验签第二部分 onlinemessage
        String JWSPayload = cn.hutool.core.codec.Base64.encodeUrlSafe(onlinemessage.getBytes("UTF-8"));
        //待验签信息
        String tempSing = JWSProtectedHeader + "." + JWSPayload;

        //验签使用的公钥:getway 提供的 验签 公钥文件
        String scis_attestation_public_file = getSingletonMethod().getScis_attestation_public_file();
        //生成公钥SHA256withRSA
        PublicKey publicKey = CertificateRead.getPublicKey(scis_attestation_public_file);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(tempSing.getBytes("UTF-8"));
        boolean result = signature.verify(Base64.decode(signStr));
        if(result){
            System.out.println("验签成功");
        }else {
            System.out.println("验签失败");
        }
        return result;
    }

    /**
     * 签名结果
     * @param data
     * @return
     * @throws Exception
     */
    public static String jwsSignature(String data) throws Exception {
        //加密使用的公钥:scis提供的 加密 公钥文件
        String getway_signature_private_str = getSingletonMethod().getGetway_signature_private_str();
        //生成公钥
        PrivateKey privateKey = CertificateRead.getPemPrivateKey(getway_signature_private_str);

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        String upi_timestamp = String.valueOf(System.currentTimeMillis() / 1000);

        //银联定义 的 机构ID/钱包ID
        String upi_appid = UnionPaySingleton.getSingletonMethod().getUpi_appid();
        String service_URL_suffix = "/scis/switch/kycverify";
        String kid = getSingletonMethod().getKid_signature();
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

}