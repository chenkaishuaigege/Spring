package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class ExchangeRateInquiryTrxInfo implements Serializable {

    String origCurrency;
    String origAmt;
    String exchangeCurrency;
    String exchangeAmt;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        ExchangeRateInquiryTrxInfo exchangeRateInquiryTrxInfo = new ExchangeRateInquiryTrxInfo();

        public ExchangeRateInquiryTrxInfo createEntity() {
            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(origCurrency)) {
                exchangeRateInquiryTrxInfo.setOrigCurrency(origCurrency);
            }
            if (JavaUtil.isEmpty(origAmt)) {
                exchangeRateInquiryTrxInfo.setOrigAmt(origAmt);
            }
            if (JavaUtil.isEmpty(exchangeCurrency)) {
                exchangeRateInquiryTrxInfo.setExchangeCurrency(exchangeCurrency);
            }
            return exchangeRateInquiryTrxInfo;
        }

        public Builder setOrigCurrency(String origCurrency_) {
            origCurrency = origCurrency_;
            exchangeRateInquiryTrxInfo.setOrigCurrency(origCurrency);
            return this;
        }
        public Builder setOrigAmt(String origAmt_) {
            origAmt = origAmt_;
            exchangeRateInquiryTrxInfo.setOrigAmt(origAmt);
            return this;
        }
        public Builder setExchangeCurrency(String exchangeCurrency_) {
            exchangeCurrency = exchangeCurrency_;
            exchangeRateInquiryTrxInfo.setExchangeCurrency(exchangeCurrency);
            return this;
        }
    }


    private void setOrigCurrency(String origCurrency) {
        this.origCurrency = origCurrency;
    }

    private void setOrigAmt(String origAmt) {
        this.origAmt = origAmt;
    }

    private void setExchangeCurrency(String exchangeCurrency) {
        this.exchangeCurrency = exchangeCurrency;
    }

    private void setExchangeAmt(String exchangeAmt) {
        this.exchangeAmt = exchangeAmt;
    }

    public String getOrigCurrency() {
        return origCurrency;
    }

    public String getOrigAmt() {
        return origAmt;
    }

    public String getExchangeCurrency() {
        return exchangeCurrency;
    }

    public String getExchangeAmt() {
        return exchangeAmt;
    }

    @Override
    public String toString() {
        return "ExchangeRateInquiryTrxInfo{" +
                "origCurrency='" + origCurrency + '\'' +
                ", origAmt='" + origAmt + '\'' +
                ", exchangeCurrency='" + exchangeCurrency + '\'' +
                ", exchangeAmt='" + exchangeAmt + '\'' +
                '}';
    }
}
