package com.rrtx.onlinemessages;


import com.rrtx.util.JavaUtil;
import com.rrtx.util.SignUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenkai
 *
 * This message is used to apply for a token with an existing entity card,or apply for a new virtual card with a given account no
 *
 * 2.4 Card Enrollment
 */
public class CardEnrollmentTrxInfo implements Serializable {

    String deviceID;
    String userID;
    String cvmInfo;
    String token;
    String tokenExpiry;
    // TODO 需要解密
    String pan;
    String panExpiry;
    String maskedPan;
    String cardType;
    String cardFaceID;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        CardEnrollmentTrxInfo cardEnrollmentTrxInfo = new CardEnrollmentTrxInfo();

        public CardEnrollmentTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                cardEnrollmentTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                cardEnrollmentTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(cvmInfo)) {
                cardEnrollmentTrxInfo.setCvmInfo(cvmInfo);
            }
            return cardEnrollmentTrxInfo;
        }

        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            cardEnrollmentTrxInfo.setDeviceID(deviceID_);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            cardEnrollmentTrxInfo.setUserID(userID_);
            return this;
        }
        public Builder setCvmInfo(String cvmInfo_) {
            cvmInfo = SignUtil.sensitiveInformationEncrypt(cvmInfo_);
            cardEnrollmentTrxInfo.setCvmInfo(cvmInfo);
            return this;
        }

    }

    private void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    private void setUserID(String userID) {
        this.userID = userID;
    }

    private void setCvmInfo(String cvmInfo) {
        this.cvmInfo = cvmInfo;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUserID() {
        return userID;
    }

    public String getCvmInfo() {
        return cvmInfo;
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

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", cvmInfo='" + cvmInfo + '\'' +
                ", token='" + token + '\'' +
                ", tokenExpiry='" + tokenExpiry + '\'' +
                ", pan='" + pan + '\'' +
                ", panExpiry='" + panExpiry + '\'' +
                ", maskedPan='" + maskedPan + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardFaceID='" + cardFaceID + '\'' +
                '}';
    }
}
