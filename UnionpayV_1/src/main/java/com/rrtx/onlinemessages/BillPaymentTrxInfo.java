package com.rrtx.onlinemessages;

import com.rrtx.dataobject.MerchantInfo;
import com.rrtx.util.JavaUtil;

public class BillPaymentTrxInfo {

    String deviceID;
    String userID;
    String token;
    String trxAmt;
    String trxCurrency;
    String trxFeeAmt;
    String trxNote;
    MerchantInfo merchantInfo;
    String riskInfo;
    String referNo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        BillPaymentTrxInfo billPaymentTrxInfo = new BillPaymentTrxInfo();
        public BillPaymentTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                billPaymentTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                billPaymentTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                billPaymentTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(trxAmt)) {
                billPaymentTrxInfo.setTrxAmt(trxAmt);
            }
            if (JavaUtil.isEmpty(trxCurrency)) {
                billPaymentTrxInfo.setTrxCurrency(trxCurrency);
            }
            if (JavaUtil.isEmpty(trxFeeAmt)) {
                billPaymentTrxInfo.setTrxFeeAmt(trxFeeAmt);
            }
            if (JavaUtil.isEmpty(trxNote)) {
                billPaymentTrxInfo.setTrxNote(trxNote);
            }
            if (merchantInfo != null) {
                billPaymentTrxInfo.setMerchantInfo(merchantInfo);
            }
            return billPaymentTrxInfo;
        }

        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            billPaymentTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            billPaymentTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            billPaymentTrxInfo.setToken(token);
            return this;
        }
        public Builder setTrxAmt(String trxAmt_) {
            trxAmt = trxAmt_;
            billPaymentTrxInfo.setTrxAmt(trxAmt);
            return this;
        }
        public Builder setTrxCurrency(String trxCurrency_) {
            trxCurrency = trxCurrency_;
            billPaymentTrxInfo.setTrxCurrency(trxCurrency);
            return this;
        }

        public Builder setTrxFeeAmt(String trxFeeAmt_) {
            trxCurrency = trxFeeAmt_;
            billPaymentTrxInfo.setTrxFeeAmt(trxFeeAmt);
            return this;
        }
        public Builder setTrxNote(String trxNote_) {
            trxNote = trxNote_;
            billPaymentTrxInfo.setTrxNote(trxNote);
            return this;
        }
        public Builder setMerchantInfo(MerchantInfo merchantInfo_) {
            merchantInfo = merchantInfo_;
            billPaymentTrxInfo.setMerchantInfo(merchantInfo);
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

    private void setTrxAmt(String trxAmt) {
        this.trxAmt = trxAmt;
    }

    private void setTrxCurrency(String trxCurrency) {
        this.trxCurrency = trxCurrency;
    }

    private void setTrxFeeAmt(String trxFeeAmt) {
        this.trxFeeAmt = trxFeeAmt;
    }

    private void setTrxNote(String trxNote) {
        this.trxNote = trxNote;
    }

    private void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
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

    public String getTrxAmt() {
        return trxAmt;
    }

    public String getTrxCurrency() {
        return trxCurrency;
    }

    public String getTrxFeeAmt() {
        return trxFeeAmt;
    }

    public String getTrxNote() {
        return trxNote;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
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
                ", trxAmt='" + trxAmt + '\'' +
                ", trxCurrency='" + trxCurrency + '\'' +
                ", trxFeeAmt='" + trxFeeAmt + '\'' +
                ", trxNote='" + trxNote + '\'' +
                ", merchantInfo=" + merchantInfo +
                ", riskInfo='" + riskInfo + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
