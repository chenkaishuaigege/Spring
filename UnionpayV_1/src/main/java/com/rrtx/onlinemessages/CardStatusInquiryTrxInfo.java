package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;
import java.io.Serializable;

public class CardStatusInquiryTrxInfo implements Serializable{

    String deviceID;
    String userID;
    String token;
    String cardStatus;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        CardStatusInquiryTrxInfo cardStatusInquiryTrxInfo = new CardStatusInquiryTrxInfo();

        public CardStatusInquiryTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                cardStatusInquiryTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                cardStatusInquiryTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                cardStatusInquiryTrxInfo.setToken(token);
            }
            return cardStatusInquiryTrxInfo;

        }

        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            cardStatusInquiryTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            cardStatusInquiryTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            cardStatusInquiryTrxInfo.setToken(token);
            return this;
        }


    }

    private void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    private void setUserID(String userID) {
        this.userID = userID;
    }

    private void setToken(String token) {
        this.token = token;
    }

    private void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUserID() {
        return userID;
    }

    public String getToken() {
        return token;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", token='" + token + '\'' +
                ", cardStatus='" + cardStatus + '\'' +
                '}';
    }
}
