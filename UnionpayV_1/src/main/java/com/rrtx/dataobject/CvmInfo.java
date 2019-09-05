package com.rrtx.dataobject;

import java.io.Serializable;

public class CvmInfo implements Serializable {

    String pan;
    String accountNo;
    String expiryDate;
    String cvn2;
    String firstName;
    String lastName;
    String idType;
    String idNo;
    String mobileNo;
    String idCountry;


    public Builder builder() {
        return new Builder();
    }

    public class Builder {

    }

    public String getPan() {
        return pan;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvn2() {
        return cvn2;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getIdCountry() {
        return idCountry;
    }
}
