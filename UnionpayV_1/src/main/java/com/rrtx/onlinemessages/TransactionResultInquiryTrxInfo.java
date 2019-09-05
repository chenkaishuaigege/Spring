package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class TransactionResultInquiryTrxInfo implements Serializable {

    String deviceID;
    String userID;
    String token;
    String origMsgID;
    String origMsgType;
    String trxAmt;
    String trxCurrency;
    String discountDetails;
    String originalAmount;
    String qrcVoucherNo;
    String paymentStatus;
    String rejectionReason;
    String referNo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        TransactionResultInquiryTrxInfo transactionResultInquiryTrxInfo = new TransactionResultInquiryTrxInfo();

        public TransactionResultInquiryTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                transactionResultInquiryTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                transactionResultInquiryTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                transactionResultInquiryTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(origMsgID)) {
                transactionResultInquiryTrxInfo.setOrigMsgID(origMsgID);
            }
            if (JavaUtil.isEmpty(origMsgType)) {
                transactionResultInquiryTrxInfo.setOrigMsgType(origMsgType);
            }
            if (JavaUtil.isEmpty(trxAmt)) {
                transactionResultInquiryTrxInfo.setTrxAmt(trxAmt);
            }
            if (JavaUtil.isEmpty(trxCurrency)) {
                transactionResultInquiryTrxInfo.setTrxCurrency(trxCurrency);
            }
            return transactionResultInquiryTrxInfo;
        }
        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            transactionResultInquiryTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            transactionResultInquiryTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            transactionResultInquiryTrxInfo.setToken(token);
            return this;
        }
        public Builder setOrigMsgID(String origMsgID_) {
            origMsgID = origMsgID_;
            transactionResultInquiryTrxInfo.setOrigMsgID(origMsgID_);
            return this;
        }
        public Builder setOrigMsgType(String origMsgType_) {
            origMsgType = origMsgType_;
            transactionResultInquiryTrxInfo.setOrigMsgType(origMsgType);
            return this;
        }
        public Builder setTrxAmt(String trxAmt_) {
            trxAmt = trxAmt_;
            transactionResultInquiryTrxInfo.setTrxAmt(trxAmt);
            return this;
        }
        public Builder setTrxCurrency(String trxCurrency_) {
            trxCurrency = trxCurrency_;
            transactionResultInquiryTrxInfo.setTrxCurrency(trxCurrency);
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

    private void setOrigMsgID(String origMsgID) {
        this.origMsgID = origMsgID;
    }

    private void setOrigMsgType(String origMsgType) {
        this.origMsgType = origMsgType;
    }

    private void setTrxAmt(String trxAmt) {
        this.trxAmt = trxAmt;
    }

    private void setTrxCurrency(String trxCurrency) {
        this.trxCurrency = trxCurrency;
    }

//    private void setDiscountDetails(String discountDetails) {
//        this.discountDetails = discountDetails;
//    }
//
//    private void setOriginalAmount(String originalAmount) {
//        this.originalAmount = originalAmount;
//    }
//
//    private void setQrcVoucherNo(String qrcVoucherNo) {
//        this.qrcVoucherNo = qrcVoucherNo;
//    }
//
//    private void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//    private void setRejectionReason(String rejectionReason) {
//        this.rejectionReason = rejectionReason;
//    }
//
//    private void setReferNo(String referNo) {
//        this.referNo = referNo;
//    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUserID() {
        return userID;
    }

    public String getToken() {
        return token;
    }

    public String getOrigMsgID() {
        return origMsgID;
    }

    public String getOrigMsgType() {
        return origMsgType;
    }

    public String getTrxAmt() {
        return trxAmt;
    }

    public String getTrxCurrency() {
        return trxCurrency;
    }

    public String getDiscountDetails() {
        return discountDetails;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public String getQrcVoucherNo() {
        return qrcVoucherNo;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
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
                ", origMsgID='" + origMsgID + '\'' +
                ", origMsgType='" + origMsgType + '\'' +
                ", trxAmt='" + trxAmt + '\'' +
                ", trxCurrency='" + trxCurrency + '\'' +
                ", discountDetails='" + discountDetails + '\'' +
                ", originalAmount='" + originalAmount + '\'' +
                ", qrcVoucherNo='" + qrcVoucherNo + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
