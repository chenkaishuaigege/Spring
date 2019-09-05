import com.rrtx.dataobject.EncCertId;
import com.rrtx.dataobject.MerchantInfo;
import com.rrtx.dataobject.MsgInfo;
import com.rrtx.dataobject.MsgResponse;
import com.rrtx.onlinemessages.BillPaymentTrxInfo;
import com.rrtx.onlinemessages.CreditTransactionTrxInfo;
import com.rrtx.onlinemessages.KYCVerificationTrxInfo;
import com.rrtx.onlinemessages.TransactionResultInquiryTrxInfo;
import com.rrtx.service.impl.UnionPayServiceImpl;
import org.junit.Test;
import java.util.Map;

public class InterfaceTest21_23 {


    /**
     * 2.21 Bill Payment 测试接口
     */
    @Test
    public void BillPaymentTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("BILL_PAYMENT").createEntity();
        MerchantInfo MerchantInfo = new MerchantInfo().builder()
                .setMerchantName("mm")
                .setMid("246753577744578")
                .createEntity();
        // trxInfo交易信息
        BillPaymentTrxInfo trxInfo = new BillPaymentTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setToken("6292610358444335641")
                .setTrxAmt("50")
                .setTrxCurrency("156")
                .setTrxFeeAmt("2")
                .setTrxNote("test")
                .setMerchantInfo(MerchantInfo)
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * 2.22 Bill Payment 测试接口
     */
    @Test
    public void CreditTransactionTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("CREDIT_TRANSACTION").createEntity();
        MerchantInfo merchantInfo = new MerchantInfo().builder()
                .setMerchantName("mm")
                .setMid("124566788532236")
                .createEntity();
        // trxInfo交易信息
        CreditTransactionTrxInfo trxInfo = new CreditTransactionTrxInfo().builder()
                .setMerchantInfo(merchantInfo)
                .setToken("6292610358444335641")
                .setTrxAmt("20")
                .setTrxCurrency("156")
                .setTrxNote("test")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }


    /**
     * 2.23 Transaction Result Inquiry 测试接口
     */
    @Test
    public void TransactionResultInquiryTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("TRX_RESULT_INQUIRY").createEntity();
        // trxInfo交易信息
        TransactionResultInquiryTrxInfo trxInfo = new TransactionResultInquiryTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setToken("6292610358444335641")
                .setOrigMsgID("A3999999920190808110216974867")
                .setOrigMsgType("MPQRC_PAYMENT_EMV")
                .setTrxAmt("1.00")
                .setTrxCurrency("344")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        TransactionResultInquiryTrxInfo fdsa = (TransactionResultInquiryTrxInfo) map.get("trxInfo");
        printMehod(map);
    }

    private static void printMehod(Map map ) throws Exception {
        System.out.println("---------------------返回信息----------------------");
        Object trxInfo2 = map.get("trxInfo");
        MsgResponse msgResponse2 = (MsgResponse) map.get("msgResponse");
        EncCertId encCertId2 = (EncCertId) map.get("encCertId");
        MsgInfo msgInfo2 = (MsgInfo) map.get("msgInfo");
        System.out.println("返回实体类交易信息:");
        System.out.println(trxInfo2);
        System.out.println("返回实体类msgInfo:");
        System.out.println(msgInfo2);
        System.out.println("返回实体类MsgResponse:");
        System.out.println(msgResponse2);
        System.out.println("返回实体类EncCertId:");
        System.out.println(encCertId2);
    }
}
