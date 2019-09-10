package com.rrtx.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.rrtx.encryption.CertificateRead;
import com.rrtx.encryption.UnionPaySingleton;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
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

        //加密所用的kid
        String kid = getSingletonMethod().getKid_encryption();

        //创建JWT报头并指定 :RSA1_5作为加密算法 | 128位A128CBC_HS256作为加密方法
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
    public static String jweDecryption(String data) throws Exception {
        // 创建EncryptedJWT对象
        Base64URL[] base64URL = EncryptedJWT.split(data);
        EncryptedJWT jwt = new EncryptedJWT(base64URL[0],base64URL[1],base64URL[2],base64URL[3],base64URL[4]);

        //加密使用的公钥:scis提供的 加密 公钥文件
        String getway_decryption_private_str = getSingletonMethod().getGetway_decryption_private_str();

        PrivateKey privateKey = CertificateRead.getPemPrivateKey(getway_decryption_private_str);

        RSADecrypter decrypter = new RSADecrypter(privateKey);
        jwt.decrypt(decrypter);
        return "";
    }

    /**
     * 签名 使用<网关的签名证书私钥>进行签名
     * @param data
     * @return
     * @throws Exception
     */
    public static String jwsSignature(String data) throws Exception {
        //生成加密使用的私钥: <网关 签名私钥> 签名
        String getway_signature_private_str = getSingletonMethod().getGetway_signature_private_str();
        PrivateKey privateKey = CertificateRead.getPemPrivateKey(getway_signature_private_str);
        // uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //timestamp
        String upi_timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        //钱包ID
        String upi_appid = UnionPaySingleton.getSingletonMethod().getUpi_appid();
        //获取Service_URL_suffix
        JSONObject jsonObject = JSONUtil.parseObj(data);
        JSONObject msgInfo = JSONUtil.parseObj(jsonObject.get("msgInfo"));
        String msgType = msgInfo.get("msgType").toString();
        String service_URL_suffix = ConversionUtil.msgTypeToUrlSuffix(msgType);
        //获取kid
        String kid = getSingletonMethod().getKid_signature();
        //创建crit
        Set<String> crit = new HashSet<>();
        crit.add("UPI-UUID");
        crit.add("UPI-TIMESTAMP");
        crit.add("UPI-APPID");
        crit.add("UPI-REQPATH");

        //JWSProtectedHeader
        Map map = new HashMap();
        map.put("alg" , "RS256");
        map.put("kid" , kid);
        map.put("crit" , crit);
        map.put("UPI-UUID" , uuid);
        map.put("UPI-TIMESTAMP" , upi_timestamp);
        map.put("UPI-APPID" , upi_appid);
        map.put("UPI-REQPATH" , service_URL_suffix);
        String JWSProtectedHeaderString = JSONUtil.parseFromMap(map).toString();
        String JWSProtectedHeader = Base64.encodeUrlSafe(JWSProtectedHeaderString.getBytes("UTF-8"));

        //JWS Payload
        String JWSPayload = Base64.encodeUrlSafe(data.getBytes("UTF-8"));

        //待签名字符串
        String tempSing = JWSProtectedHeader + "." + JWSPayload;
        // TODO 调试信息 System.out.println() 需要去掉
        System.out.println("待签名字符串组成部分-JWS Protected Header:");
        System.out.println(JWSProtectedHeader);
        System.out.println("待签名字符串组成部分-JWS Payload");
        System.out.println(JWSPayload);
        System.out.println("待签名字符串:");
        System.out.println(tempSing);

        //生成签名信息
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(tempSing.getBytes("UTF-8"));
        byte[] result = signature.sign();
        String JWSSignature = Base64.encode(result);
        String headerSign = JWSProtectedHeader + ".." + JWSSignature;
        System.out.println();
        return headerSign;
    }


    /**
     * 验签 使用<scis的签名公钥>进行验签
     * @param onlinemessage
     * @param upi_jwsEnc
     * @return
     * @throws Exception
     */
    public static boolean jwsAttestation(String onlinemessage ,String upi_jwsEnc) throws Exception {
        System.out.println("返回的jws");
        System.out.println(upi_jwsEnc);
        //按照[..]切分
        String[] upi_jws = upi_jwsEnc.split("\\.\\.");
        // JWS Protected Header 待验签第一部分
        String JWSProtectedHeader = upi_jws[0];
        // 签名信息
        String signStr = upi_jws[1];
        //待验签第二部分 onlinemessage
        String JWSPayload = Base64.encodeUrlSafe(onlinemessage.getBytes("UTF-8"));
        //组装待验签信息
        String tempSing = JWSProtectedHeader + "." + JWSPayload;
        //验签使用的公钥:scis 提供的 <签名公钥> 验签
        String scis_attestation_public_file = getSingletonMethod().getScis_attestation_public_file();
        //生成 SHA256withRSA 公钥
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



}