package com.rrtx.onlinemessages;

import com.rrtx.dataobject.AdditionalData;
import com.rrtx.dataobject.MerchantInfo;
import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class MPQRCPaymentEMVTrxInfo implements Serializable {

    String deviceID;
    String userID;
    String token;
    String trxAmt;
    String trxCurrency;
    String discountDetails;
    String originalAmount;
    String trxFeeAmt;
    String mpqrcPayload;
    String qrcVoucherNo;
    String couponInfo;
    String trxNote;
    MerchantInfo merchantInfo;
    String riskInfo;
    AdditionalData additionalData;
    String referNo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        MPQRCPaymentEMVTrxInfo mpQRCPaymentEMVTrxInfo = new MPQRCPaymentEMVTrxInfo();

        public MPQRCPaymentEMVTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                mpQRCPaymentEMVTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                mpQRCPaymentEMVTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                mpQRCPaymentEMVTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(trxAmt)) {
                mpQRCPaymentEMVTrxInfo.setTrxAmt(trxAmt);
            }
            if (JavaUtil.isEmpty(trxCurrency)) {
                mpQRCPaymentEMVTrxInfo.setTrxCurrency(trxCurrency);
            }
            if (JavaUtil.isEmpty(mpqrcPayload)) {
                mpQRCPaymentEMVTrxInfo.setMpqrcPayload(mpqrcPayload);
            }
            if (merchantInfo != null) {
                mpQRCPaymentEMVTrxInfo.setMerchantInfo(merchantInfo);
            }
            return mpQRCPaymentEMVTrxInfo;
        }

        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            mpQRCPaymentEMVTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            mpQRCPaymentEMVTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            mpQRCPaymentEMVTrxInfo.setToken(token);
            return this;
        }
        public Builder setTrxAmt(String trxAmt_) {
            trxAmt = trxAmt_;
            mpQRCPaymentEMVTrxInfo.setTrxAmt(trxAmt);
            return this;
        }
        public Builder setTrxCurrency(String trxCurrency_) {
            trxCurrency = trxCurrency_;
            mpQRCPaymentEMVTrxInfo.setTrxCurrency(trxCurrency);
            return this;
        }
        public Builder setAdditionalData(AdditionalData additionalData_) {
            additionalData = additionalData_;
            mpQRCPaymentEMVTrxInfo.setAdditionalData(additionalData);
            return this;
        }

        public Builder setMpqrcPayload(String mpqrcPayload_) {
            mpqrcPayload = mpqrcPayload_;
            mpQRCPaymentEMVTrxInfo.setMpqrcPayload(mpqrcPayload);
            return this;
        }
        public Builder setMerchantInfo(MerchantInfo merchantInfo_) {
            merchantInfo = merchantInfo_;
            mpQRCPaymentEMVTrxInfo.setMerchantInfo(merchantInfo);
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

    private void setDiscountDetails(String discountDetails) {
        this.discountDetails = discountDetails;
    }

    private void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    private void setTrxFeeAmt(String trxFeeAmt) {
        this.trxFeeAmt = trxFeeAmt;
    }

    private void setMpqrcPayload(String mpqrcPayload) {
        this.mpqrcPayload = mpqrcPayload;
    }

    private void setQrcVoucherNo(String qrcVoucherNo) {
        this.qrcVoucherNo = qrcVoucherNo;
    }

    private void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }

    private void setTrxNote(String trxNote) {
        this.trxNote = trxNote;
    }

    private void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    private void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo;
    }

    private void setAdditionalData(AdditionalData additionalData) {
        this.additionalData = additionalData;
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

    public String getTrxFeeAmt() {
        return trxFeeAmt;
    }

    public String getMpqrcPayload() {
        return mpqrcPayload;
    }

    public String getQrcVoucherNo() {
        return qrcVoucherNo;
    }

    public String getCouponInfo() {
        return couponInfo;
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

    public AdditionalData getAdditionalData() {
        return additionalData;
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
                ", discountDetails='" + discountDetails + '\'' +
                ", originalAmount='" + originalAmount + '\'' +
                ", trxFeeAmt='" + trxFeeAmt + '\'' +
                ", mpqrcPayload='" + mpqrcPayload + '\'' +
                ", qrcVoucherNo='" + qrcVoucherNo + '\'' +
                ", couponInfo='" + couponInfo + '\'' +
                ", trxNote='" + trxNote + '\'' +
                ", merchantInfo=" + merchantInfo +
                ", riskInfo='" + riskInfo + '\'' +
                ", additionalData=" + additionalData +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
