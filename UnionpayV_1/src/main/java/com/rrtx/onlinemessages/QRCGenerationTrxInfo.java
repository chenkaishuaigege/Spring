package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;
import java.io.Serializable;
import java.util.Arrays;

public class QRCGenerationTrxInfo implements Serializable {

    String deviceID;
    String userID;
    String token;
    String trxLimit;
    String cvmLimit;
    String limitCurrency;
    String cpqrcNo;
    String[] emvCpqrcPayload;
    String[] barcodeCpqrcPayload;
    String couponInfo;
    String riskInfo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        QRCGenerationTrxInfo qrcGenerationTrxInfo = new QRCGenerationTrxInfo();

        public QRCGenerationTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                qrcGenerationTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                qrcGenerationTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                qrcGenerationTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(trxLimit)) {
                qrcGenerationTrxInfo.setTrxLimit(trxLimit);
            }
            if (JavaUtil.isEmpty(cvmLimit)) {
                qrcGenerationTrxInfo.setCvmLimit(cvmLimit);
            }
            if (JavaUtil.isEmpty(limitCurrency)) {
                qrcGenerationTrxInfo.setLimitCurrency(limitCurrency);
            }
            if (JavaUtil.isEmpty(cpqrcNo)) {
                qrcGenerationTrxInfo.setCpqrcNo(cpqrcNo);
            }
            return qrcGenerationTrxInfo;
        }
        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            qrcGenerationTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            qrcGenerationTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            qrcGenerationTrxInfo.setToken(token);
            return this;
        }

        public Builder setTrxLimit(String trxLimit_) {
            trxLimit = trxLimit_;
            qrcGenerationTrxInfo.setTrxLimit(trxLimit);
            return this;
        }
        public Builder setCvmLimit(String cvmLimit_) {
            cvmLimit = cvmLimit_;
            qrcGenerationTrxInfo.setCvmLimit(cvmLimit);
            return this;
        }
        public Builder setLimitCurrency(String limitCurrency_) {
            limitCurrency = limitCurrency_;
            qrcGenerationTrxInfo.setLimitCurrency(limitCurrency);
            return this;
        }
        public Builder setCpqrcNo(String cpqrcNo_) {
            cpqrcNo = cpqrcNo_;
            qrcGenerationTrxInfo.setCpqrcNo(cpqrcNo);
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

    private void setTrxLimit(String trxLimit) {
        this.trxLimit = trxLimit;
    }

    private void setCvmLimit(String cvmLimit) {
        this.cvmLimit = cvmLimit;
    }

    private void setLimitCurrency(String limitCurrency) {
        limitCurrency = limitCurrency;
    }

    private void setCpqrcNo(String cpqrcNo) {
        this.cpqrcNo = cpqrcNo;
    }

    private void setEmvCpqrcPayload(String[] emvCpqrcPayload) {
        this.emvCpqrcPayload = emvCpqrcPayload;
    }

    private void setBarcodeCpqrcPayload(String[] barcodeCpqrcPayload) {
        this.barcodeCpqrcPayload = barcodeCpqrcPayload;
    }

    private void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }

    private void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo;
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

    public String getTrxLimit() {
        return trxLimit;
    }

    public String getCvmLimit() {
        return cvmLimit;
    }

    public String getLimitCurrency() {
        return limitCurrency;
    }

    public String getCpqrcNo() {
        return cpqrcNo;
    }

    public String[] getEmvCpqrcPayload() {
        return emvCpqrcPayload;
    }

    public String[] getBarcodeCpqrcPayload() {
        return barcodeCpqrcPayload;
    }

    public String getCouponInfo() {
        return couponInfo;
    }

    public String getRiskInfo() {
        return riskInfo;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", token='" + token + '\'' +
                ", trxLimit='" + trxLimit + '\'' +
                ", cvmLimit='" + cvmLimit + '\'' +
                ", limitCurrency='" + limitCurrency + '\'' +
                ", cpqrcNo='" + cpqrcNo + '\'' +
                ", emvCpqrcPayload=" + Arrays.toString(emvCpqrcPayload) +
                ", barcodeCpqrcPayload=" + Arrays.toString(barcodeCpqrcPayload) +
                ", couponInfo='" + couponInfo + '\'' +
                ", riskInfo='" + riskInfo + '\'' +
                '}';
    }
}
