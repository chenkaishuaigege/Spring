package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;
import java.io.Serializable;

public class CardBalanceInquiryTrxInfo implements Serializable{

    String deviceID;
    String userID;
    String token;
    String accountTier;
    String balAmt;
    String balCurrency;
    String referNo;


    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        CardBalanceInquiryTrxInfo cardBalanceInquiryTrxInfo = new CardBalanceInquiryTrxInfo();

        public CardBalanceInquiryTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                cardBalanceInquiryTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                cardBalanceInquiryTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                cardBalanceInquiryTrxInfo.setToken(token);
            }
            return cardBalanceInquiryTrxInfo;
        }

        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            cardBalanceInquiryTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            cardBalanceInquiryTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            cardBalanceInquiryTrxInfo.setToken(token);
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

    private void setAccountTier(String accountTier) {
        this.accountTier = accountTier;
    }

    private void setBalAmt(String balAmt) {
        this.balAmt = balAmt;
    }

    private void setBalCurrency(String balCurrency) {
        this.balCurrency = balCurrency;
    }

    private void setReferNo(String referNo) {
        this.referNo = referNo;
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

    public String getAccountTier() {
        return accountTier;
    }

    public String getBalAmt() {
        return balAmt;
    }

    public String getBalCurrency() {
        return balCurrency;
    }

    public String getReferNo() {
        return referNo;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", token='" + token + '\'' +
                ", accountTier='" + accountTier + '\'' +
                ", balAmt='" + balAmt + '\'' +
                ", balCurrency='" + balCurrency + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
