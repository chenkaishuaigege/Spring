package com.rrtx.dataobject;

import java.io.Serializable;

public class CvmAddtlDocm implements Serializable {

    String dataType;
    String dataFormat;
    String dataContent;

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

    }

    public String getDataType() {
        return dataType;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public String getDataContent() {
        return dataContent;
    }
}
