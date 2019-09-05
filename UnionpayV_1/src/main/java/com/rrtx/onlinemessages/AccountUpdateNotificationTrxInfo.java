package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class AccountUpdateNotificationTrxInfo implements Serializable {

    String token;
    String accountTier;
    String referNo;


    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        AccountUpdateNotificationTrxInfo accountUpdateNotificationTrxInfo = new AccountUpdateNotificationTrxInfo();
        public AccountUpdateNotificationTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(token)) {
                accountUpdateNotificationTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(accountTier)) {
                accountUpdateNotificationTrxInfo.setAccountTier(accountTier);
            }
            return accountUpdateNotificationTrxInfo;
        }
        public Builder setToken(String token_) {
            token = token_;
            accountUpdateNotificationTrxInfo.setToken(token);
            return this;
        }
        public Builder setAccountTier(String accountTier_) {
            accountTier = accountTier_;
            accountUpdateNotificationTrxInfo.setAccountTier(accountTier);
            return this;
        }
    }

    private void setToken(String token) {
        this.token = token;
    }

    private void setAccountTier(String accountTier) {
        this.accountTier = accountTier;
    }

    private void setReferNo(String referNo) {
        this.referNo = referNo;
    }

    public String getToken() {
        return token;
    }

    public String getAccountTier() {
        return accountTier;
    }

    public String getReferNo() {
        return referNo;
    }

    @Override
    public String toString() {
        return "{" +
                "token='" + token + '\'' +
                ", accountTier='" + accountTier + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
