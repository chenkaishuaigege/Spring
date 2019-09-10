package com.rrtx.encryption;

import cn.hutool.core.codec.Base64;
import java.io.FileInputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Enumeration;

/**
 * 从本地路径下读取公私钥方法
 */
public class CertificateRead {


    /**
     * 通过<证书路径>和<证书密码>读取私钥
     *
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
            Enumeration<String> enumeration = keyStore.aliases();
            if (enumeration.hasMoreElements()){
                keyAlias = (String) enumeration.nextElement();
            }
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
        } catch (Exception e){
            System.out.println(e);
        }
        return privateKeyStr;
    }


    /**
     * 通过<证书路径>读取公钥
     * 返回 {@link java.security.PublicKey}
     *  适用 .cer/.pem 证书文件
     */

    public static PublicKey getPublicKey(String publicKeyFilePath) throws Exception {
        PublicKey pk = null;
        try {
            CertificateFactory certificatefactory=CertificateFactory.getInstance("X.509");
            FileInputStream bais = new FileInputStream(publicKeyFilePath);
            X509Certificate Cert = (X509Certificate)certificatefactory.generateCertificate(bais);
            pk = Cert.getPublicKey();
        } catch (Exception e) {
            throw new Exception("Failed to generate PublicKey");
        }
        return pk;
    }


    /**
     * 通过<证书路径>和<证书密码>读取私钥信息
     * 返回 {@link java.security.PrivateKey}
     * @param privateKeyFilepath
     * @param privateKeyPassword
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKeyFilepath , String privateKeyPassword) throws Exception {
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
        } catch (Exception e) {
            throw new Exception("Failed to generate PrivateKey");
        }
        return prikey;
    }

    /**
     * 通过<私钥字符串>读取私钥
     * 适用 .cer/.pem 证书文件
     * @param privateKeyStr 私钥字符串
     * @return {@link java.security.PrivateKey}
     * @throws Exception
     */
    public static PrivateKey getPemPrivateKey(String privateKeyStr) throws Exception {
        PrivateKey privateKey = null;
        java.security.Security.addProvider(
                new org.bouncycastle.jce.provider.BouncyCastleProvider()
        );
        try {
            byte[] buffer = Base64.decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
            return privateKey;
        } catch (Exception e) {
            throw new Exception("Failed to generate PrivateKey");
        }
    }

}
