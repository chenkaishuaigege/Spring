package com.rrtx.util;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class Cerdemo {

    public Cerdemo() throws CertificateException, FileNotFoundException, KeyStoreException {
    }

    public static void main(String[] args) throws Exception{
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate)cf.generateCertificate(new FileInputStream("/Users/chenkai/home/rrtx/cert/sign_1560936206326.crt"));
        PublicKey publicKey = cert.getPublicKey();
        BASE64Encoder base64Encoder=new BASE64Encoder();
        String publicKeyString = base64Encoder.encode(publicKey.getEncoded());

        System.out.println("-----------------公钥--------------------");
        System.out.println(publicKeyString);
        System.out.println("-----------------公钥--------------------"); }
}
