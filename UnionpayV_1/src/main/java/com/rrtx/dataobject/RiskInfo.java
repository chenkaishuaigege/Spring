package com.rrtx.dataobject;

import java.io.Serializable;

public class RiskInfo implements Serializable {


    String gps;
    String simCard;
    String appUserID;
    String usrEnrolDate;
    String captureMethod;
    String ipAddress;
    String reservedMobileNo;
    String deviceType;
    String deviceScore;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

    }

    public String getGps() {
        return gps;
    }

    public String getSimCard() {
        return simCard;
    }

    public String getAppUserID() {
        return appUserID;
    }

    public String getUsrEnrolDate() {
        return usrEnrolDate;
    }

    public String getCaptureMethod() {
        return captureMethod;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getReservedMobileNo() {
        return reservedMobileNo;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getDeviceScore() {
        return deviceScore;
    }
}
