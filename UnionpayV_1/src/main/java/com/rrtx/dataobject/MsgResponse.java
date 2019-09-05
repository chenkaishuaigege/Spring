package com.rrtx.dataobject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MsgResponse implements Serializable {

    String responseCode;
    String responseMsg;

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }


    @Override
    public String toString() {
        return "{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMsg='" + responseMsg + '\'' +
                '}';
    }
}
