package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class CashOutTokenTrxInfo implements Serializable {

    String deviceID;
    String userID;
    String token;
    String trxTokenType;
    String trxToken;
    String trxAmt;
    String trxCurrency;
    String referNo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        CashOutTokenTrxInfo cashOutTokenTrxInfo = new CashOutTokenTrxInfo();

        public CashOutTokenTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                cashOutTokenTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                cashOutTokenTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                cashOutTokenTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(trxTokenType)) {
                cashOutTokenTrxInfo.setTrxTokenType(trxTokenType);
            }
            if (JavaUtil.isEmpty(trxAmt)) {
                cashOutTokenTrxInfo.setTrxAmt(trxAmt);
            }
            if (JavaUtil.isEmpty(trxCurrency)) {
                cashOutTokenTrxInfo.setTrxCurrency(trxCurrency);
            }
            return cashOutTokenTrxInfo;
        }
        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            cashOutTokenTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            cashOutTokenTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            cashOutTokenTrxInfo.setToken(token);
            return this;
        }
        public Builder setTrxTokenType(String trxTokenType_) {
            trxTokenType = trxTokenType_;
            cashOutTokenTrxInfo.setTrxTokenType(trxTokenType);
            return this;
        }
        public Builder setTrxAmt(String trxAmt_) {
            trxAmt = trxAmt_;
            cashOutTokenTrxInfo.setTrxAmt(trxAmt);
            return this;
        }
        public Builder setTrxCurrency(String trxCurrency_) {
            trxCurrency = trxCurrency_;
            cashOutTokenTrxInfo.setTrxCurrency(trxCurrency);
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

    private void setTrxTokenType(String trxTokenType) {
        this.trxTokenType = trxTokenType;
    }

    private void setTrxToken(String trxToken) {
        this.trxToken = trxToken;
    }

    private void setTrxAmt(String trxAmt) {
        this.trxAmt = trxAmt;
    }

    private void setTrxCurrency(String trxCurrency) {
        this.trxCurrency = trxCurrency;
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

    public String getTrxTokenType() {
        return trxTokenType;
    }

    public String getTrxToken() {
        return trxToken;
    }

    public String getTrxAmt() {
        return trxAmt;
    }

    public String getTrxCurrency() {
        return trxCurrency;
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
                ", trxTokenType='" + trxTokenType + '\'' +
                ", trxToken='" + trxToken + '\'' +
                ", trxAmt='" + trxAmt + '\'' +
                ", trxCurrency='" + trxCurrency + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
