package com.rrtx.onlinemessages;


import com.rrtx.util.JavaUtil;
import com.rrtx.util.SignUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenkai
 * Transmits the KYC verification information entered by users to SCIS for verification
 * 将用户输入的KYC验证信息传输给SCIS进行验证
 * 2.2 KYC Verification interface's Transaction Information ""trxInfo""
 *
 */
public class KYCVerificationTrxInfo implements Serializable {


    String deviceID;
    String userID;
    String cvmInfo;
    String referNo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        KYCVerificationTrxInfo KYCVerificationTrxInfo = new KYCVerificationTrxInfo();

        public KYCVerificationTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                KYCVerificationTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                KYCVerificationTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(cvmInfo)) {
                KYCVerificationTrxInfo.setCvmInfo(cvmInfo);
            }
            return KYCVerificationTrxInfo;

        }

        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            KYCVerificationTrxInfo.setDeviceID(deviceID_);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            KYCVerificationTrxInfo.setUserID(userID_);
            return this;
        }
        public Builder setCvmInfo(String cvmInfo_) {
            cvmInfo = SignUtil.sensitiveInformationEncrypt(cvmInfo_);
            KYCVerificationTrxInfo.setCvmInfo(cvmInfo);
            return this;
        }

    }

    private void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    private void setUserID(String userID) {
        this.userID = userID;
    }

    private void setCvmInfo(String cvmInfo) {
        this.cvmInfo = cvmInfo;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUserID() {
        return userID;
    }

    public String getCvmInfo() {
        return cvmInfo;
    }

    public String getReferNo() {
        return referNo;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", cvmInfo='" + cvmInfo + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
