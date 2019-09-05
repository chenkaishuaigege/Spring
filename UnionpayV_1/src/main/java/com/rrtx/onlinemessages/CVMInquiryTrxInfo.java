package com.rrtx.onlinemessages;

import com.rrtx.util.JavaUtil;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author chenkai
 * Functions:This message is sent by APPGW to SCIS to get the list of cardholder verification(CV) methods required.
 * 此消息由APPGW发送到SCIS，以获得所需的持卡人验证(CV)方法列表。
 *
 * 2.1 CVM Inquiry trxInfo
 */
public class CVMInquiryTrxInfo implements Serializable {


    /**
     * TrxInfo 交易信息,接口文档中对应的两个字段
     */
    String cvm[];

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        CVMInquiryTrxInfo CVMInquiryTrxInfo = new CVMInquiryTrxInfo();

        public CVMInquiryTrxInfo createEntity() {

            /**
             * 添加默认值,当创建实体类的时候不set值时,会使用默认值
             */
            if (JavaUtil.isEmpty(cvm)) {
                CVMInquiryTrxInfo.setCvm(cvm);
            }
            return CVMInquiryTrxInfo;

        }

        public Builder setCvm(String[] cvm_) {
            cvm = cvm_;
            CVMInquiryTrxInfo.setCvm(cvm);
            return this;
        }
    }


    /**
     * set方法需要private
     * @param cvm
     */
    private void setCvm(String[] cvm) {
        this.cvm = cvm;
    }

    /**
     * get方法需要public
     * @return
     */
    public String[] getCvm() {
        return cvm;
    }

//    public String getDecryptionPan() {
//        if (!JavaUtil.isEmpty(getPan())) {
//            return decryptWithPrivateParamBase64(getPan());
//        }else{
//            return "";
//        }
//    }


    @Override
    public String toString() {
        return "{" +
                "cvm=" + Arrays.toString(cvm) +
                '}';
    }
}
