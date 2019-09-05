package com.rrtx.onlinemessages;

import com.rrtx.dataobject.MerchantInfo;
import com.rrtx.util.JavaUtil;

import java.io.Serializable;

public class CreditTransactionTrxInfo implements Serializable {

    MerchantInfo merchantInfo;
    String token;
    String trxAmt;
    String trxCurrency;
    String trxNote;
    String referNo;


    public Builder builder() {
        return new Builder();
    }

    public class Builder {
        CreditTransactionTrxInfo creditTransactionTrxInfo = new CreditTransactionTrxInfo();

        public CreditTransactionTrxInfo createEntity() {
            if (merchantInfo != null) {
                creditTransactionTrxInfo.setMerchantInfo(merchantInfo);
            }
            if (JavaUtil.isEmpty(token)) {
                creditTransactionTrxInfo.setToken(token);
            }
            if (JavaUtil.isEmpty(trxAmt)) {
                creditTransactionTrxInfo.setTrxAmt(trxAmt);
            }
            if (JavaUtil.isEmpty(trxCurrency)) {
                creditTransactionTrxInfo.setTrxCurrency(trxCurrency);
            }
            if (JavaUtil.isEmpty(trxNote)) {
                creditTransactionTrxInfo.setTrxNote(trxNote);
            }
            return creditTransactionTrxInfo;
        }

        public Builder setMerchantInfo(MerchantInfo merchantInfo_) {
            merchantInfo = merchantInfo_;
            creditTransactionTrxInfo.setMerchantInfo(merchantInfo);
            return this;
        }
        public Builder setToken(String token_) {
            token = token_;
            creditTransactionTrxInfo.setToken(token);
            return this;
        }
        public Builder setTrxAmt(String trxAmt_) {
            trxAmt = trxAmt_;
            creditTransactionTrxInfo.setTrxAmt(trxAmt);
            return this;
        }
        public Builder setTrxCurrency(String trxCurrency_) {
            trxCurrency = trxCurrency_;
            creditTransactionTrxInfo.setTrxCurrency(trxCurrency);
            return this;
        }
        public Builder setTrxNote(String trxNote_) {
            trxNote = trxNote_;
            creditTransactionTrxInfo.setTrxNote(trxNote);
            return this;
        }

    }

    private void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    private void setToken(String token) {
        this.token = token;
    }

    private void setTrxAmt(String trxAmt) {
        this.trxAmt = trxAmt;
    }

    private void setTrxCurrency(String trxCurrency) {
        this.trxCurrency = trxCurrency;
    }

    private void setTrxNote(String trxNote) {
        this.trxNote = trxNote;
    }

    private void setReferNo(String referNo) {
        this.referNo = referNo;
    }

    @Override
    public String toString() {
        return "{" +
                "merchantInfo=" + merchantInfo +
                ", token='" + token + '\'' +
                ", trxAmt='" + trxAmt + '\'' +
                ", trxCurrency='" + trxCurrency + '\'' +
                ", trxNote='" + trxNote + '\'' +
                ", referNo='" + referNo + '\'' +
                '}';
    }
}
