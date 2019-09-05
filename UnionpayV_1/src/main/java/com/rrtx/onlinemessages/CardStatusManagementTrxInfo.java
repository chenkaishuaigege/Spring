package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class CardStatusManagementTrxInfo  implements Serializable {

    String deviceID;
    String userID;
    String token;
    String tokenAction;
    String tokenState;


    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        CardStatusManagementTrxInfo cardStatusManagementTrxInfo = new CardStatusManagementTrxInfo();
        public CardStatusManagementTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(deviceID)) {
                cardStatusManagementTrxInfo.setDeviceID(deviceID);
            }
            if (JavaUtil.isEmpty(userID)) {
                cardStatusManagementTrxInfo.setUserID(userID);
            }
            if (JavaUtil.isEmpty(token)) {
                cardStatusManagementTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(tokenAction)) {
                cardStatusManagementTrxInfo.setTokenAction(tokenAction);
            }
            return cardStatusManagementTrxInfo;
        }
        public Builder setDeviceID(String deviceID_) {
            deviceID = deviceID_;
            cardStatusManagementTrxInfo.setDeviceID(deviceID);
            return this;
        }
        public Builder setUserID(String userID_) {
            userID = userID_;
            cardStatusManagementTrxInfo.setUserID(userID);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            cardStatusManagementTrxInfo.setToken(token);
            return this;
        }
        public Builder setTokenAction(String tokenAction_) {
            tokenAction = tokenAction_;
            cardStatusManagementTrxInfo.setTokenAction(tokenAction);
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

    private void setTokenAction(String tokenAction) {
        this.tokenAction = tokenAction;
    }

    private void setTokenState(String tokenState) {
        this.tokenState = tokenState;
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

    public String getTokenAction() {
        return tokenAction;
    }

    public String getTokenState() {
        return tokenState;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceID='" + deviceID + '\'' +
                ", userID='" + userID + '\'' +
                ", token='" + token + '\'' +
                ", tokenAction='" + tokenAction + '\'' +
                ", tokenState='" + tokenState + '\'' +
                '}';
    }
}
