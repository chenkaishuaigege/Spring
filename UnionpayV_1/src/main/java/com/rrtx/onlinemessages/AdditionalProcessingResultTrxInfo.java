package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;
import java.io.Serializable;
import java.util.Arrays;

public class AdditionalProcessingResultTrxInfo implements Serializable {

    String deviceID;
    String userID;
    String token;
    String[] emvCpqrcPayload;
    String barcodeCpqrcPayload;
    String paymentStatus;
    String rejectionReason;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        AdditionalProcessingResultTrxInfo additionalProcessingResultTrxInfo = new AdditionalProcessingResultTrxInfo();

        public AdditionalProcessingResultTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                additionalProcessingResultTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                additionalProcessingResultTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                additionalProcessingResultTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(emvCpqrcPayload)) {
                additionalProcessingResultTrxInfo.setEmvCpqrcPayload(emvCpqrcPayload);
            }
            if (JavaUtil.isEmpty(paymentStatus)) {
                additionalProcessingResultTrxInfo.setPaymentStatus(paymentStatus);
            }
            return additionalProcessingResultTrxInfo;
        }
        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            additionalProcessingResultTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            additionalProcessingResultTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            additionalProcessingResultTrxInfo.setToken(token);
            return this;
        }
        public Builder setEmvCpqrcPayload(String[] emvCpqrcPayload_) {
            emvCpqrcPayload = emvCpqrcPayload_;
            additionalProcessingResultTrxInfo.setEmvCpqrcPayload(emvCpqrcPayload);
            return this;
        }
        public Builder setPaymentStatus(String paymentStatus_) {
            paymentStatus = paymentStatus_;
            additionalProcessingResultTrxInfo.setPaymentStatus(paymentStatus);
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

    private void setEmvCpqrcPayload(String[] emvCpqrcPayload) {
        this.emvCpqrcPayload = emvCpqrcPayload;
    }

    private void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public String[] getEmvCpqrcPayload() {
        return emvCpqrcPayload;
    }

    public String getBarcodeCpqrcPayload() {
        return barcodeCpqrcPayload;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", token='" + token + '\'' +
                ", emvCpqrcPayload=" + Arrays.toString(emvCpqrcPayload) +
                ", barcodeCpqrcPayload='" + barcodeCpqrcPayload + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }
}
