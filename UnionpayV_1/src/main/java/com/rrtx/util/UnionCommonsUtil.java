package com.rrtx.util;

import java.io.IOException;

public class UnionCommonsUtil {

    /**
     * 属性:
     * 公钥证书路径,
     * 私钥证书路径,
     * 银联URL,
     * 序列号,
     * 钱包机构ID
     */
    public String union_cert_publicKey;
    public String union_cert_privateKey;
    public String union_url;
    public String upi_certid;
    public String upi_appid;





    /**
     * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    public static UnionCommonsUtil unionCommonsUtil = null;

    /**
     * 构造方法私有化*/
    public UnionCommonsUtil() {}

    /**
     * 提供一个初始化的方法*/
    private static synchronized void syncInit() {
        if(unionCommonsUtil == null){
            System.out.println("没有获取到对象,创建对象");
            unionCommonsUtil = new UnionCommonsUtil();
            try {
                unionCommonsUtil.setUnion_cert_publicKey(ProConst.getValue("union_cert_publicKey"));
                unionCommonsUtil.setUnion_cert_privateKey(ProConst.getValue("union_cert_privateKey"));
                unionCommonsUtil.setUnion_url(ProConst.getValue("union_url"));
                unionCommonsUtil.setUpi_certid(ProConst.getValue("upi_certid"));
                unionCommonsUtil.setUpi_appid(ProConst.getValue("upi_appid"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对外提供获取对象的静态方法方法
     *
     * */
    public static UnionCommonsUtil getSingletonMethod(){
        if(unionCommonsUtil == null){
            syncInit();
        }
        return unionCommonsUtil;
    }

    public String getUnion_cert_publicKey() {
        return union_cert_publicKey;
    }

    private void setUnion_cert_publicKey(String union_cert_publicKey) {
        this.union_cert_publicKey = union_cert_publicKey;
    }

    public String getUnion_cert_privateKey() {
        return union_cert_privateKey;
    }

    private void setUnion_cert_privateKey(String union_cert_privateKey) {
        this.union_cert_privateKey = union_cert_privateKey;
    }

    public String getUnion_url() {
        return union_url;
    }

    private void setUnion_url(String union_url) {
        this.union_url = union_url;
    }

    public String getUpi_certid() {
        return upi_certid;
    }

    private void setUpi_certid(String upi_certid) {
        this.upi_certid = upi_certid;
    }

    public String getUpi_appid() {
        return upi_appid;
    }

    public void setUpi_appid(String upi_appid) {
        this.upi_appid = upi_appid;
    }
}
