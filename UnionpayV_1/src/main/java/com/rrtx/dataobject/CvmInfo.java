package com.rrtx.dataobject;

import com.rrtx.util.ConversionUtil;
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
        CvmInfo cvmInfo = new CvmInfo();

        public CvmInfo createEntity() {
            return cvmInfo;
        }

        public Builder setPan(String pan_) {
            pan = pan_;
            cvmInfo.setPan(pan);
            return this;
        }
        public Builder setAccountNo(String accountNo_) {
            accountNo = accountNo_;
            cvmInfo.setAccountNo(accountNo);
            return this;
        }
        public Builder setExpiryDate(String expiryDate_) {
            expiryDate = expiryDate_;
            cvmInfo.setExpiryDate(expiryDate);
            return this;
        }
        public Builder setCvn2(String cvn2_) {
            cvn2 = cvn2_;
            cvmInfo.setCvn2(cvn2);
            return this;
        }
        public Builder setFirstName(String firstName_) {
            firstName = firstName_;
            cvmInfo.setFirstName(firstName);
            return this;
        }
        public Builder setLastName(String lastName_) {
            lastName = lastName_;
            cvmInfo.setLastName(lastName);
            return this;
        }
        public Builder setIdType(String idType_) {
            idType = idType_;
            cvmInfo.setIdType(idType);
            return this;
        }
        public Builder setIdNo(String idNo_) {
            idNo = idNo_;
            cvmInfo.setIdNo(idNo);
            return this;
        }
        public Builder setMobileNo(String mobileNo_) {
            mobileNo = mobileNo_;
            cvmInfo.setMobileNo(mobileNo);
            return this;
        }
        public Builder setIdCountry(String idCountry_) {
            idCountry = ConversionUtil.threeCountryNumToLetter(idCountry_);
            cvmInfo.setIdCountry(idCountry);
            return this;
        }
    }


    private void setPan(String pan) {
        this.pan = pan;
    }

    private void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    private void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    private void setCvn2(String cvn2) {
        this.cvn2 = cvn2;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setIdType(String idType) {
        this.idType = idType;
    }

    private void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    private void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    private void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
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
