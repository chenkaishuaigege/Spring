package com.rrtx.onlinemessages;


import com.rrtx.util.JavaUtil;

import java.io.Serializable;

/**
 * @author chenkai
 * Apply for a virtual card.If this application is approved,a new virtual card is created by SCIS,the PAN and token of the virtual card will be returned by the
 * response message to APPGW.
 * 申请一张虚拟卡。如果这个应用程序被批准，SCIS将创建一个新的虚拟卡，响应消息将把虚拟卡的PAN和令牌返回给APPGW。
 *
 * 2.3 Open Account interface's Transaction Information "trxInfo"
 *
 */
public class OpenAccountTrxInfo implements Serializable {

    /**
     * 设备号 Android--->IMEI iOS-->IDFV
     */
    String deviceID;

    String userID;
    /**
     * 这两个请求该字段应该相同: KYC_VERIFICATION, OPEN_ACCOUNT
     * 对于每个注册过程，值必须是惟一的
     */
    String origMsgID;
    String origReferNo;
    String cvmAddtlDocums;
    String token;
    String tokenExpiry;
    /**
     * TODO 返回信息需要解密
     */
    String pan;
    String panExpiry;
    String maskedPan;
    String cardType;
    String cardFaceID;
    String referNo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        OpenAccountTrxInfo openAccountTrxInfo = new OpenAccountTrxInfo();

        public OpenAccountTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                openAccountTrxInfo.setDeviceID("deviceID默认值");
            }
            return openAccountTrxInfo;

        }

        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            openAccountTrxInfo.setDeviceID(deviceID);
            return this;
        }

        public Builder setUserID(String userID_) {
            if (!JavaUtil.isEmpty(userID_)) {
                userID = userID_;
                openAccountTrxInfo.setUserID(userID);
            }
            return this;
        }
        public Builder setOrigMsgID(String origMsgID_) {
            origMsgID = origMsgID_;
            openAccountTrxInfo.setOrigMsgID(origMsgID_);
            return this;
        }

        public Builder setOrigReferNo(String origReferNo_) {
            if (!JavaUtil.isEmpty(origReferNo_)) {
                origReferNo = origReferNo_;
                openAccountTrxInfo.setOrigReferNo(origReferNo);
            }
            return this;
        }
    }

    public String getDeviceID() {
        return deviceID;
    }

    private void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getUserID() {
        return userID;
    }

    private void setUserID(String userID) {
        this.userID = userID;
    }

    public String getReferNo() {
        return referNo;
    }


    public String getCvmAddtlDocums() {
        return cvmAddtlDocums;
    }

    public String getToken() {
        return token;
    }

    public String getTokenExpiry() {
        return tokenExpiry;
    }

    public String getPan() {
        return pan;
    }

    public String getPanExpiry() {
        return panExpiry;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardFaceID() {
        return cardFaceID;
    }

    public String getOrigMsgID() {
        return origMsgID;
    }

    private void setOrigMsgID(String origMsgID) {
        this.origMsgID = origMsgID;
    }

    public String getOrigReferNo() {
        return origReferNo;
    }

    private void setOrigReferNo(String origReferNo) {
        this.origReferNo = origReferNo;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", origMsgID='" + origMsgID + '\'' +
                ", origReferNo='" + origReferNo + '\'' +
                ", cvmAddtlDocums='" + cvmAddtlDocums + '\'' +
                ", token='" + token + '\'' +
                ", tokenExpiry='" + tokenExpiry + '\'' +
                ", pan='" + pan + '\'' +
                ", panExpiry='" + panExpiry + '\'' +
                ", maskedPan='" + maskedPan + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardFaceID='" + cardFaceID + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
