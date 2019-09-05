package com.rrtx.dataobject;

import java.io.Serializable;


public class EncCertId implements Serializable {

    String upiEncCertID;
    String insEncCertID;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

    }

    public String getUpiEncCertID() {
        return upiEncCertID;
    }

    public String getInsEncCertID() {
        return insEncCertID;
    }

    @Override
    public String toString() {
        return "EncCertId{" +
                "upiEncCertID='" + upiEncCertID + '\'' +
                ", insEncCertID='" + insEncCertID + '\'' +
                '}';
    }
}
