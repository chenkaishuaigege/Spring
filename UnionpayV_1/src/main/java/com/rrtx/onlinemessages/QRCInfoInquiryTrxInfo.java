package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class QRCInfoInquiryTrxInfo implements Serializable {

    String deviceID;
    String userID;
    String mpqrcPayload;
    String trxAmt;
    String trxCurrency;
    String qrcUseCase;
    String merchantName;
    String mcc;
    String merchantCountry;
    String merchantCity;
    String postalCode;
    String languagePreference;
    String merchantNameAL;
    String merchantCityAL;
    String terminalID;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        QRCInfoInquiryTrxInfo qrcInfoInquiryTrxInfo = new QRCInfoInquiryTrxInfo();

        public QRCInfoInquiryTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                qrcInfoInquiryTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                qrcInfoInquiryTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(mpqrcPayload)) {
                qrcInfoInquiryTrxInfo.setMpqrcPayload(mpqrcPayload);
            }
            return qrcInfoInquiryTrxInfo;
        }
        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            qrcInfoInquiryTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            qrcInfoInquiryTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setMpqrcPayload(String mpqrcPayload_) {
            mpqrcPayload = mpqrcPayload_;
            qrcInfoInquiryTrxInfo.setMpqrcPayload(mpqrcPayload);
            return this;
        }




    }

    private void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    private void setUserID(String userID) {
        this.userID = userID;
    }

    private void setMpqrcPayload(String mpqrcPayload) {
        this.mpqrcPayload = mpqrcPayload;
    }

    private void setTrxAmt(String trxAmt) {
        this.trxAmt = trxAmt;
    }

    private void setTrxCurrency(String trxCurrency) {
        this.trxCurrency = trxCurrency;
    }

    private void setQrcUseCase(String qrcUseCase) {
        this.qrcUseCase = qrcUseCase;
    }

    private void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    private void setMcc(String mcc) {
        this.mcc = mcc;
    }

    private void setMerchantCountry(String merchantCountry) {
        this.merchantCountry = merchantCountry;
    }

    private void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    private void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private void setLanguagePreference(String languagePreference) {
        this.languagePreference = languagePreference;
    }

    private void setMerchantNameAL(String merchantNameAL) {
        this.merchantNameAL = merchantNameAL;
    }

    private void setMerchantCityAL(String merchantCityAL) {
        this.merchantCityAL = merchantCityAL;
    }

    private void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUserID() {
        return userID;
    }

    public String getMpqrcPayload() {
        return mpqrcPayload;
    }

    public String getTrxAmt() {
        return trxAmt;
    }

    public String getTrxCurrency() {
        return trxCurrency;
    }

    public String getQrcUseCase() {
        return qrcUseCase;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getMcc() {
        return mcc;
    }

    public String getMerchantCountry() {
        return merchantCountry;
    }

    public String getMerchantCity() {
        return merchantCity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLanguagePreference() {
        return languagePreference;
    }

    public String getMerchantNameAL() {
        return merchantNameAL;
    }

    public String getMerchantCityAL() {
        return merchantCityAL;
    }

    public String getTerminalID() {
        return terminalID;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", mpqrcPayload='" + mpqrcPayload + '\'' +
                ", trxAmt='" + trxAmt + '\'' +
                ", trxCurrency='" + trxCurrency + '\'' +
                ", qrcUseCase='" + qrcUseCase + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", mcc='" + mcc + '\'' +
                ", merchantCountry='" + merchantCountry + '\'' +
                ", merchantCity='" + merchantCity + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", languagePreference='" + languagePreference + '\'' +
                ", merchantNameAL='" + merchantNameAL + '\'' +
                ", merchantCityAL='" + merchantCityAL + '\'' +
                ", terminalID='" + terminalID + '\'' +
                '}';
    }
}
