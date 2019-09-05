package com.rrtx.dataobject;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class AdditionalData implements Serializable {

    String billNo;
    String mobileNo;
    String storeLabel;
    String loyaltyNumber;
    String referenceLabel;
    String customerLabel;
    String terminalLabel;
    String trxPurpose;
    String consumerEmail;
    String consumerAddress;
    String consumerMobileNo;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        AdditionalData additionalData = new AdditionalData();

        public AdditionalData createEntity() {
            if (JavaUtil.isEmpty(billNo)) {
                additionalData.setBillNo(billNo);
            }
            if (JavaUtil.isEmpty(referenceLabel)) {
                additionalData.setReferenceLabel(referenceLabel);
            }
            if (JavaUtil.isEmpty(terminalLabel)) {
                additionalData.setTerminalLabel(terminalLabel);
            }
            return additionalData;
        }
        public Builder setBillNo(String billNo_) {
            billNo = billNo_;
            additionalData.setBillNo(billNo);
            return this;
        }
        public Builder setReferenceLabel(String referenceLabel_) {
            referenceLabel = referenceLabel_;
            additionalData.setReferenceLabel(referenceLabel);
            return this;
        }
        public Builder setTerminalLabel(String terminalLabel_) {
            terminalLabel = terminalLabel_;
            additionalData.setTerminalLabel(terminalLabel);
            return this;
        }

    }

    private void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    private void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    private void setStoreLabel(String storeLabel) {
        this.storeLabel = storeLabel;
    }

    private void setLoyaltyNumber(String loyaltyNumber) {
        this.loyaltyNumber = loyaltyNumber;
    }

    private void setReferenceLabel(String referenceLabel) {
        this.referenceLabel = referenceLabel;
    }

    private void setCustomerLabel(String customerLabel) {
        this.customerLabel = customerLabel;
    }

    private void setTerminalLabel(String terminalLabel) {
        this.terminalLabel = terminalLabel;
    }

    private void setTrxPurpose(String trxPurpose) {
        this.trxPurpose = trxPurpose;
    }

    private void setConsumerEmail(String consumerEmail) {
        this.consumerEmail = consumerEmail;
    }

    private void setConsumerAddress(String consumerAddress) {
        this.consumerAddress = consumerAddress;
    }

    private void setConsumerMobileNo(String consumerMobileNo) {
        this.consumerMobileNo = consumerMobileNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getStoreLabel() {
        return storeLabel;
    }

    public String getLoyaltyNumber() {
        return loyaltyNumber;
    }

    public String getReferenceLabel() {
        return referenceLabel;
    }

    public String getCustomerLabel() {
        return customerLabel;
    }

    public String getTerminalLabel() {
        return terminalLabel;
    }

    public String getTrxPurpose() {
        return trxPurpose;
    }

    public String getConsumerEmail() {
        return consumerEmail;
    }

    public String getConsumerAddress() {
        return consumerAddress;
    }

    public String getConsumerMobileNo() {
        return consumerMobileNo;
    }
}
