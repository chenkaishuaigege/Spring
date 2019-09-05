package com.rrtx.dataobject;


import com.rrtx.util.JavaUtil;
import java.io.Serializable;

/**
 *
 */
public class MsgInfo implements Serializable {

    String versionNo;
    String msgID;
    String timeStamp;
    String msgType;
    String insID;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        MsgInfo msgInfo = new MsgInfo();

        public MsgInfo createEntity() {

            if (JavaUtil.isEmpty(versionNo)) {
                versionNo = "1.0.0";
                msgInfo.setVersionNo(versionNo);
            }
            if (JavaUtil.isEmpty(msgID)) {
                msgID = "A" + insID + "***Serial No";
                msgInfo.setMsgID(msgID);
            }
            if (JavaUtil.isEmpty(timeStamp)) {
                timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
                msgInfo.setTimeStamp(timeStamp);
            }
            if (JavaUtil.isEmpty(insID)) {
                insID = "insID";
                msgInfo.setInsID(insID);
            }
            if (JavaUtil.isEmpty(msgType)) {
                msgInfo.setMsgType(msgType);
            }

            return msgInfo;
        }

        public Builder setMsgType(String msgType_) {
            msgType = msgType_;
            msgInfo.setMsgType(msgType);
            return this;
        }

    }

    public String getVersionNo() {
        return versionNo;
    }

    public String getMsgID() {
        return msgID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getInsID() {
        return insID;
    }

    private void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    private void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    private void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    private void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    private void setInsID(String insID) {
        this.insID = insID;
    }

    @Override
    public String toString() {
        return "MsgInfo{" +
                "versionNo='" + versionNo + '\'' +
                ", msgID='" + msgID + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", msgType='" + msgType + '\'' +
                ", insID='" + insID + '\'' +
                '}';
    }
}
