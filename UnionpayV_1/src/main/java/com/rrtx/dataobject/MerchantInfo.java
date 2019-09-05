package com.rrtx.dataobject;

import com.rrtx.util.JavaUtil;
import java.io.Serializable;

public class MerchantInfo implements Serializable {


    String acquirerIIN;
    String fwdIIN;
    String mid;
    String merchantName;
    String mcc;


    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        MerchantInfo merchantInfo = new MerchantInfo();

        public MerchantInfo createEntity() {
            if (JavaUtil.isEmpty(acquirerIIN)) {
                merchantInfo.setAcquirerIIN(acquirerIIN);
            }
            if (JavaUtil.isEmpty(fwdIIN)) {
                merchantInfo.setFwdIIN(fwdIIN);
            }
            if (JavaUtil.isEmpty(mid)) {
                merchantInfo.setMid(mid);
            }
            if (JavaUtil.isEmpty(merchantName)) {
                merchantInfo.setMerchantName(merchantName);
            }
            if (JavaUtil.isEmpty(mcc)) {
                merchantInfo.setMcc(mcc);
            }
            return merchantInfo;
        }

        public Builder setAcquirerIIN(String acquirerIIN_) {
            acquirerIIN = acquirerIIN_;
            merchantInfo.setAcquirerIIN(acquirerIIN);
            return this;
        }
        public Builder setFwdIIN(String fwdIIN_) {
            fwdIIN = fwdIIN_;
            merchantInfo.setFwdIIN(fwdIIN);
            return this;
        }
        public Builder setMid(String mid_) {
            mid = mid_;
            merchantInfo.setMid(mid);
            return this;
        }
        public Builder setMerchantName(String merchantName_) {
            merchantName = merchantName_;
            merchantInfo.setMerchantName(merchantName);
            return this;
        }
        public Builder setMcc(String mcc_) {
            mcc = mcc_;
            merchantInfo.setMcc(mcc);
            return this;
        }
    }

    private void setAcquirerIIN(String acquirerIIN) {
        this.acquirerIIN = acquirerIIN;
    }

    private void setFwdIIN(String fwdIIN) {
        this.fwdIIN = fwdIIN;
    }

    private void setMid(String mid) {
        this.mid = mid;
    }

    private void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    private void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getAcquirerIIN() {
        return acquirerIIN;
    }

    public String getFwdIIN() {
        return fwdIIN;
    }

    public String getMid() {
        return mid;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getMcc() {
        return mcc;
    }
}
