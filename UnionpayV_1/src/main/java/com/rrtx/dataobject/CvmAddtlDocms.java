package com.rrtx.dataobject;

import java.io.Serializable;

public class CvmAddtlDocms implements Serializable {

    String cvmAddtlDocms;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

    }

    public String getCvmAddtlDocms() {
        return cvmAddtlDocms;
    }
}
