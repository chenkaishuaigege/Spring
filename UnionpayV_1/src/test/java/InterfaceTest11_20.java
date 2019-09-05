import com.rrtx.dataobject.*;
import com.rrtx.onlinemessages.*;
import com.rrtx.service.impl.UnionPayServiceImpl;
import org.junit.Test;
import java.util.Map;

public class InterfaceTest11_20 {


    /**
     * Exchange Rate Inquiry 测试接口
     */
    @Test
    public void ExchangeRateInquiryTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("EXCHANGE_RATE_INQUIRY").createEntity();
        // trxInfo交易信息
        ExchangeRateInquiryTrxInfo trxInfo = new ExchangeRateInquiryTrxInfo().builder()
                .setOrigCurrency("344")
                .setOrigAmt("100")
                .setExchangeCurrency("156")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * 测试接口
     */
    @Test
    public void P2PTransferTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("P2P_TRANSFER").createEntity();
        // trxInfo交易信息
        P2PTransferTrxInfo trxInfo = new P2PTransferTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setToken("6292610308700265602")
                .setCreditAccountInfo("eyJhbGciOiJSU0ExXzUiLCJlbmMiOiJBMTI4Q0JDLUhTMjU2Iiwia2lkIjoiMTU1NTU3MDMwMiJ9.ZmL7bADf86yl-Q_AJOM9lTRUTqIMq_Q\n" +
                        "wcWJUFpH-K5FUjm4G0Ulxjnf1yx_Vd8tUMl1qYYUJ_aCRLIpdeP1qNr4SuxPaTL_TTA7vt7zVi3DkmZMH0Wq4Gsbo3UY2y28YvYEM85TbSYCwVsOnrkeQvrfbvxGZvR\n" +
                        "HemA60HSsgbK2QNEyCn15vz6AZzmQT77Oa62EGjQmRVL-2YAudyONTq3giG1xLWKV1ZfQCRx4qmX6gQdKsHnbXkS-Xqkn26-mg2iBlZuZ7R4ObXUAYA3vGY9Gb2j9\n" +
                        "b1v8KbvD9tm9wbALicy2qeQqExDg76-_KfHJ101pb0m9zJIgUzaQroLX05w.YWE3NWU4ZGYyMjBlNDAwMw.RzAQa7fKNQ1vzCXCutNKar3MkgY-GeOIPMLoNxG-m\n" +
                        "VmuQnpLmjudWZZK0UVEEYZAJRyNGJvdWaO-G8Ka3aSoIVlGiHgALi3CXmNoPr51zu0.lYhN-t-vZ1DcNDxBAv7VKg")
                .setTrxAmt("1")
                .setTrxCurrency("156")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }


    /**
     * QRC Generation 测试接口 2.13
     */
    @Test
    public void QRCGenerationTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("QRC_GENERATION").createEntity();
        // trxInfo交易信息
        QRCGenerationTrxInfo trxInfo = new QRCGenerationTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setToken("6292610358444335641")
                .setTrxLimit("100")
                .setCvmLimit("1")
                .setLimitCurrency("156")
                .setCpqrcNo("cpqrcNo")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * Additional Processing 测试接口 2.14 sics 发送给APPGW
     */

    /**
     * Additional Processing Result 测试接口 2.15
     */
    @Test
    public void AdditionalProcessingResultTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("ADDITIONAL_PROCESSING_RESULT").createEntity();
        // trxInfo交易信息
        String[] emvCpqrcPayload = {"hQVDUFYwMWFYTwigAAADMwEBAVcTYpJhA1hEQzVkHSIQIBAAABiAH180AQBjM58mCFaLEtnaC9l/nycBgJ8QEQcAAQOgAAABCDM5OTk5OTk5nzYCAAGCAgAAnzcE6gZYyA=="};
        AdditionalProcessingResultTrxInfo trxInfo = new AdditionalProcessingResultTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setToken("6292610358444335641")
                .setEmvCpqrcPayload(emvCpqrcPayload)
                .setPaymentStatus("CONTINUING")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * Transaction Result Notification 测试接口 2.16 sics 发送给APPGW
     */

    /**
     * Cash Out Token 测试接口 2.17
     */
    @Test
    public void CashOutTokenTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("GET_CASH_OUT_TOKEN").createEntity();
        // trxInfo交易信息
        CashOutTokenTrxInfo trxInfo = new CashOutTokenTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3331192801347584")
                .setToken("6292610308700265602")
                .setTrxTokenType("WITHDRAW")
                .setTrxAmt("20")
                .setTrxCurrency("156")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * QRC Info Inquiry 测试接口 2.18
     */
    @Test
    public void qrcInfoInquiryTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("QRC_INFO_INQUIRY").createEntity();
        // trxInfo交易信息
        QRCInfoInquiryTrxInfo trxInfo = new QRCInfoInquiryTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setMpqrcPayload("https://qr.95516.com/00010000/010133220077388392780208852187")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * MPQRC Payment EMV 测试接口
     */
    @Test
    public void MPQRCPaymentEMVTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("MPQRC_PAYMENT_EMV").createEntity();
        MerchantInfo MerchantInfo = new MerchantInfo().builder()
                .setAcquirerIIN("25000344")
                .setFwdIIN("00020344")
                .setMid("500034470110001")
                .setMerchantName("Discount Testing")
                .setMcc("7011")
                .createEntity();
        AdditionalData AdditionalData = new AdditionalData().builder()
                .setBillNo("00000000000000000000")
                .setReferenceLabel("00000000000000000000")
                .setTerminalLabel("88888888")
                .createEntity();
        // trxInfo交易信息
        MPQRCPaymentEMVTrxInfo trxInfo = new MPQRCPaymentEMVTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setToken("6292610358444335641")
                .setTrxAmt("1")
                .setTrxCurrency("344")
                .setMpqrcPayload("000201010211153125000344000203445000344701100015204701153033445802HK5916DiscountTesting6008Hongkong62600120000000000000000000000520000000000000000000000708888888886304F153")
                .setMerchantInfo(MerchantInfo)
                .setAdditionalData(AdditionalData)
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * MPQRCPaymentURL 测试接口 2.20
     */
    @Test
    public void MPQRCPaymentURLTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("MPQRC_PAYMENT_URL").createEntity();
        MerchantInfo MerchantInfo = new MerchantInfo().builder()
                .setMerchantName("Test Merchant")
                .setMcc("5811")
                .createEntity();
        // trxInfo交易信息
        MPQRCPaymentURLTrxInfo trxInfo = new MPQRCPaymentURLTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setToken("6292610358444335641")
                .setOrigTrxMsgID("A3999999920190808110302170477")
                .setTrxAmt("1")
                .setTrxCurrency("156")
                .setMpqrcPayload("https://qr.95516.com/00010000/0101332200773883927802088521877")
                .setMerchantInfo(MerchantInfo)
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
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
