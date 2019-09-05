package com.rrtx.dataobject;

import java.io.Serializable;


/**
 * @author 陈凯
 * AccountInfo
 */
public class AccountInfo implements Serializable {

    String token;
    String pan;
    String accountNo;
    String firstName;
    String lastName;
    String accountStatus;
    String accountTier;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

    }

    public String getToken() {
        return token;
    }

    public String getPan() {
        return pan;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getAccountTier() {
        return accountTier;
    }
}
