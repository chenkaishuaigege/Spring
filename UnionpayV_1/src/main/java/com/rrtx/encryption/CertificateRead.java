package com.rrtx.encryption;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;


/**
 * 从本地路径下读取公私钥方法
 *
 */
public class CertificateRead {

    static String KEY_PATH = "/Users/chenkai/home/rrtx/cert/ttf.pfx";
    static String CER_PATH = "/Users/chenkai/home/rrtx/cert/ttf.cer";

    // TODO 证书路径处理有问题
    static String KEY_PASSWORD = "1";

    /**
     * 读取.pfx文件获取公私钥信息
     */
    public static String getPrivateKeyInfo(){

        String privKeyFileString = KEY_PATH;

        String privKeyPswdString = KEY_PASSWORD;

        String keyAlias = null;

        String publicKeyStr = null;

        String privateKeyStr = null;

        try
        {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream fileInputStream = new FileInputStream(privKeyFileString);
            char[] nPassword = null;
            if ((privKeyPswdString == null) || privKeyPswdString.trim().equals(""))
            {
                nPassword = null;
            } else {
                nPassword = privKeyPswdString.toCharArray();
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
    public static String getPublicKeyInfo(){

        String publicKeyFileString = CER_PATH;

        String publicKye = null;

        try {
            CertificateFactory certificatefactory=CertificateFactory.getInstance("X.509");
            FileInputStream bais= null;

            bais = new FileInputStream(publicKeyFileString);

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
    public static PublicKey getPublicKey(){

        String publicKeyFileString = CER_PATH;

        PublicKey pk = null;

        try {
            CertificateFactory certificatefactory=CertificateFactory.getInstance("X.509");
            FileInputStream bais= null;

            bais = new FileInputStream(publicKeyFileString);

            X509Certificate Cert = (X509Certificate)certificatefactory.generateCertificate(bais);
            pk = Cert.getPublicKey();

        } catch (FileNotFoundException | CertificateException e) {
            e.printStackTrace();
        }
        return pk;
    }

    /**
     * 读取.pfx文件获取公私钥信息
     * @return
     */
    public static PrivateKey getPrivateKey(){

        String privKeyFileString = KEY_PATH;

        String privKeyPswdString = KEY_PASSWORD;

        String keyAlias = null;

        String publicKeyStr = null;

        String privateKeyStr = null;

        PrivateKey prikey = null;
        try
        {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream fileInputStream = new FileInputStream(privKeyFileString);
            char[] nPassword = null;
            if ((privKeyPswdString == null) || privKeyPswdString.trim().equals(""))
            {
                nPassword = null;
            } else {
                nPassword = privKeyPswdString.toCharArray();
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
            prikey = (PrivateKey) keyStore.getKey(keyAlias, nPassword);
            Certificate cert = keyStore.getCertificate(keyAlias);
            PublicKey pubkey = cert.getPublicKey();

        } catch (Exception e){
            System.out.println(e);
        }
        return prikey;
    }

    public static void main(String[] args) {
        getPrivateKeyInfo();
        getPublicKeyInfo();
        getPublicKey();
        getPrivateKey();
    }
}
