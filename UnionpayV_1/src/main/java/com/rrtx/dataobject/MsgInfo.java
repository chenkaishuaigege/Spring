package com.rrtx.dataobject;


import com.rrtx.util.JavaUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.rrtx.encryption.UnionPaySingleton.getSingletonMethod;

/**
 *
 */
public class MsgInfo implements Serializable {

    String versionNo = "1.0.0";
    String msgID;
    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
    String msgType;
    String insID = getSingletonMethod().getUpi_appid();;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        MsgInfo msgInfo = new MsgInfo();

        public MsgInfo createEntity() {
            //如果为空,设置默认值
            if (JavaUtil.isEmpty(versionNo)) {
                msgInfo.setVersionNo(versionNo);
            }
            if (JavaUtil.isEmpty(msgID)) {
                msgID = "A" + insID + timeStamp;
                msgInfo.setMsgID(msgID);
            }
            if (JavaUtil.isEmpty(timeStamp)) {
                msgInfo.setTimeStamp(timeStamp);
            }
            if (JavaUtil.isEmpty(insID)) {
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
