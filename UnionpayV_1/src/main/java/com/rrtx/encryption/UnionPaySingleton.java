package com.rrtx.encryption;

import com.rrtx.util.ProConst;

public class UnionPaySingleton {

    static String union_url;
    static String upi_appid;
    static String upi_certid;
    static String kid_encryption;
    static String kid_signature;

    static String scis_encryption_public_file;
    static String scis_attestation_public_file;
    static String getway_decryption_private_file;
    static String getway_decryption_private_str;
    static String getway_signature_private_file;
    static String getway_signature_private_str;



    private static UnionPaySingleton unionPaySingleton= null;

    /*构造方法私有化*/
    private UnionPaySingleton() {}


    private static synchronized void syncInit(){
        System.out.println("初始化对象");
        if(unionPaySingleton == null){
            scis_encryption_public_file = ProConst.getValue("scis_encryption_public_file");
            scis_attestation_public_file = ProConst.getValue("scis_attestation_public_file");
            getway_decryption_private_file = ProConst.getValue("getway_decryption_private_file");
            getway_decryption_private_str = ProConst.getValue("getway_decryption_private_str");
            getway_signature_private_file = ProConst.getValue("getway_signature_private_file");
            getway_signature_private_str = ProConst.getValue("getway_signature_private_str");
            union_url = ProConst.getValue("union_url");
            upi_appid = ProConst.getValue("upi_appid");
            upi_certid = ProConst.getValue("upi_certid");
            kid_encryption = ProConst.getValue("kid_encryption");
            kid_signature = ProConst.getValue("kid_signature");

            unionPaySingleton = new UnionPaySingleton();
            unionPaySingleton.setScis_encryption_public_file(scis_encryption_public_file);
            unionPaySingleton.setScis_attestation_public_file(scis_attestation_public_file);
            unionPaySingleton.setGetway_decryption_private_file(getway_decryption_private_file);
            unionPaySingleton.setGetway_decryption_private_str(getway_decryption_private_str);
            unionPaySingleton.setGetway_signature_private_file(getway_signature_private_file);
            unionPaySingleton.setGetway_signature_private_str(getway_signature_private_str);
            unionPaySingleton.setUnion_url(union_url);
            unionPaySingleton.setUpi_appid(upi_appid);
            unionPaySingleton.setUpi_certid(upi_certid);
            unionPaySingleton.setKid_encryption(kid_encryption);
            unionPaySingleton.setKid_signature(kid_signature);
        }
    }

    /*对外提供获取对象的静态方法*/
    public static UnionPaySingleton getSingletonMethod(){
        if(unionPaySingleton == null){
            syncInit();
        }
        return unionPaySingleton;
    }

    public String getUnion_url() {
        return union_url;
    }

    private void setUnion_url(String union_url) {
        UnionPaySingleton.union_url = union_url;
    }

    public String getUpi_appid() {
        return upi_appid;
    }

    private void setUpi_appid(String upi_appid) {
        UnionPaySingleton.upi_appid = upi_appid;
    }

    public String getUpi_certid() {
        return upi_certid;
    }

    private void setUpi_certid(String upi_certid) {
        UnionPaySingleton.upi_certid = upi_certid;
    }

    public String getScis_encryption_public_file() {
        return scis_encryption_public_file;
    }

    private void setScis_encryption_public_file(String scis_encryption_public_file) {
        UnionPaySingleton.scis_encryption_public_file = scis_encryption_public_file;
    }

    public String getScis_attestation_public_file() {
        return scis_attestation_public_file;
    }

    private void setScis_attestation_public_file(String scis_attestation_public_file) {
        UnionPaySingleton.scis_attestation_public_file = scis_attestation_public_file;
    }

    public String getGetway_decryption_private_file() {
        return getway_decryption_private_file;
    }

    private void setGetway_decryption_private_file(String getway_decryption_private_file) {
        UnionPaySingleton.getway_decryption_private_file = getway_decryption_private_file;
    }

    public String getGetway_decryption_private_str() {
        return getway_decryption_private_str;
    }

    private void setGetway_decryption_private_str(String getway_decryption_private_str) {
        UnionPaySingleton.getway_decryption_private_str = getway_decryption_private_str;
    }

    public String getGetway_signature_private_file() {
        return getway_signature_private_file;
    }

    private void setGetway_signature_private_file(String getway_signature_private_file) {
        UnionPaySingleton.getway_signature_private_file = getway_signature_private_file;
    }

    public String getGetway_signature_private_str() {
        return getway_signature_private_str;
    }

    private void setGetway_signature_private_str(String getway_signature_private_str) {
        UnionPaySingleton.getway_signature_private_str = getway_signature_private_str;
    }

    public String getKid_encryption() {
        return kid_encryption;
    }

    public void setKid_encryption(String kid_encryption) {
        UnionPaySingleton.kid_encryption = kid_encryption;
    }

    public String getKid_signature() {
        return kid_signature;
    }

    public void setKid_signature(String kid_signature) {
        UnionPaySingleton.kid_signature = kid_signature;
    }

}
