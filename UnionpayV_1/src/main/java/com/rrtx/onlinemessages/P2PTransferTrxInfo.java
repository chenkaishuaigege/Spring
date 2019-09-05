package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class P2PTransferTrxInfo implements Serializable {

    String deviceID;
    String userID;
    String token;
    String creditAccountInfo;
    String trxAmt;
    String trxCurrency;
    String trxNote;
    String riskInfo;
    String referNo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        P2PTransferTrxInfo p2pTransferTrxInfo = new P2PTransferTrxInfo();

        public P2PTransferTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                p2pTransferTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                p2pTransferTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                p2pTransferTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(creditAccountInfo)) {
                p2pTransferTrxInfo.setCreditAccountInfo(creditAccountInfo);
            }
            if (JavaUtil.isEmpty(trxAmt)) {
                p2pTransferTrxInfo.setTrxAmt(trxAmt);
            }
            if (JavaUtil.isEmpty(trxCurrency)) {
                p2pTransferTrxInfo.setTrxCurrency(trxCurrency);
            }

            return p2pTransferTrxInfo;
        }
        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            p2pTransferTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            p2pTransferTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            p2pTransferTrxInfo.setToken(token);
            return this;
        }
        public Builder setCreditAccountInfo(String creditAccountInfo_) {
            creditAccountInfo = creditAccountInfo_;
            p2pTransferTrxInfo.setCreditAccountInfo(creditAccountInfo);
            return this;
        }
        public Builder setTrxAmt(String trxAmt_) {
            trxAmt = trxAmt_;
            p2pTransferTrxInfo.setTrxAmt(trxAmt);
            return this;
        }
        public Builder setTrxCurrency(String trxCurrency_) {
            trxCurrency = trxCurrency_;
            p2pTransferTrxInfo.setTrxCurrency(trxCurrency);
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

    private void setCreditAccountInfo(String creditAccountInfo) {
        this.creditAccountInfo = creditAccountInfo;
    }

    private void setTrxAmt(String trxAmt) {
        this.trxAmt = trxAmt;
    }

    private void setTrxCurrency(String trxCurrency) {
        this.trxCurrency = trxCurrency;
    }

    private void setTrxNote(String trxNote) {
        this.trxNote = trxNote;
    }

    private void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo;
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

    public String getCreditAccountInfo() {
        return creditAccountInfo;
    }

    public String getTrxAmt() {
        return trxAmt;
    }

    public String getTrxCurrency() {
        return trxCurrency;
    }

    public String getTrxNote() {
        return trxNote;
    }

    public String getRiskInfo() {
        return riskInfo;
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
                ", creditAccountInfo='" + creditAccountInfo + '\'' +
                ", trxAmt='" + trxAmt + '\'' +
                ", trxCurrency='" + trxCurrency + '\'' +
                ", trxNote='" + trxNote + '\'' +
                ", riskInfo='" + riskInfo + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
