package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class KeyExchangeTrxInfo implements Serializable {


    /**
     * TrxInfo 交易信息,接口文档中对应的两个字段
     */
    String insSignCertID;
    String insSignPublicKey;
    String insEncCertID;
    String insEncPublickey;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        KeyExchangeTrxInfo KeyExchangeTrxInfo = new KeyExchangeTrxInfo();

        public KeyExchangeTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(insSignCertID)) {
                KeyExchangeTrxInfo.setInsSignCertID("cvm默认值");
            }
            return KeyExchangeTrxInfo;

        }

//        public Builder setCvm(String cvm_) {
//            cvm = cvm_;
//            CVMInquiryTrxInfo.setCvm(cvm);
//            return this;
//        }
//
//        public Builder setPan(String pan_) {
//            if (!JavaUtil.isEmpty(pan_)) {
//                pan = encrypWithPublicResultBase64(pan_);
//                CVMInquiryTrxInfo.setPan(pan);
//            }
//            return this;
//        }

    }

    /**
     * set方法需要private
     * get方法需要public
     */

    public String getInsSignCertID() {
        return insSignCertID;
    }

    public void setInsSignCertID(String insSignCertID) {
        this.insSignCertID = insSignCertID;
    }

    public String getInsSignPublicKey() {
        return insSignPublicKey;
    }

    public void setInsSignPublicKey(String insSignPublicKey) {
        this.insSignPublicKey = insSignPublicKey;
    }

    public String getInsEncCertID() {
        return insEncCertID;
    }

    public void setInsEncCertID(String insEncCertID) {
        this.insEncCertID = insEncCertID;
    }

    public String getInsEncPublickey() {
        return insEncPublickey;
    }

    public void setInsEncPublickey(String insEncPublickey) {
        this.insEncPublickey = insEncPublickey;
    }

    @Override
    public String toString() {
        return "{" +
                "insSignCertID='" + insSignCertID + '\'' +
                ", insSignPublicKey='" + insSignPublicKey + '\'' +
                ", insEncCertID='" + insEncCertID + '\'' +
                ", insEncPublickey='" + insEncPublickey + '\'' +
                '}';
    }
}
