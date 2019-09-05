import com.rrtx.dataobject.EncCertId;
import com.rrtx.dataobject.MsgInfo;
import com.rrtx.dataobject.MsgResponse;
import com.rrtx.onlinemessages.*;
import com.rrtx.service.impl.UnionPayServiceImpl;
import org.junit.Test;
import java.util.Map;

public class InterfaceTest1_10 {

    /**
     * 2.1
     * Functions:This message is sent by APPGW to SCIS to get the list of cardholder verification(CV) methods required.
     * 获取所需的持卡人验证(CV)方法列表。
     */
    @Test
    public void cvmInquiryTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("CVM_INQUIRY").createEntity();
        // trxInfo交易信息
        CVMInquiryTrxInfo trxInfo = new CVMInquiryTrxInfo().builder().createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * KYC Verification 测试接口 2.2
     * Functions:Transmits the KYC verification information entered by users to SCIS for verification.
     * 将用户输入的KYC验证信息传输给SCIS进行验证。
     * TODO CvmInfo  使用加密证书的公钥加密。
     */
    @Test
    public void KYCVerificationTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("KYC_VERIFICATION").createEntity();
        // trxInfo交易信息
        KYCVerificationTrxInfo trxInfo = new KYCVerificationTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3329941324335104")
                .setCvmInfo("123121233123")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }


    /**
     * 2.3 Open Account
     * Apply for a virtual card.If this application is approved,a new virtual card is created by SCIS,the PAN and token of the virtual card will be returned by the response message to APPGW.
     * 申请一张虚拟卡。如果这个应用程序被批准，SCIS将创建一个新的虚拟卡，响应消息将把虚拟卡的PAN和令牌返回给APPGW。
     */
    @Test
    public void openAccountTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("OPEN_ACCOUNT").createEntity();
        // trxInfo交易信息
        OpenAccountTrxInfo trxInfo = new OpenAccountTrxInfo().builder()
                                                            .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                                                            .setUserID("3329941324335104")
                                                            .setOrigMsgID("A3999999920190808105159700443")
                                                            .setOrigReferNo("119771")
                                                            .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * CardEnrollment 测试接口 2.4
     * This message is used to apply for a token with an existing entity card,or apply for a new virtual card with a given account no
     * 此消息用于使用现有实体卡申请令牌，或使用给定帐户号申请新的虚拟卡
     */
    @Test
    public void CardEnrollmentTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("CARD_ENROLLMENT").createEntity();
        // trxInfo交易信息
        CardEnrollmentTrxInfo trxInfo = new CardEnrollmentTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3329941324335104")
                .setCvmInfo("123123")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * Cardface Downloading 测试接口 2.5
     *
     */
    @Test
    public void CardfaceDownloadingTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("CARDFACE_DOWNLOADING").createEntity();
        // trxInfo交易信息
        CardfaceDownloadingTrxInfo trxInfo = new CardfaceDownloadingTrxInfo().builder()
                .setCardfaceID("100201")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * Account Update Notification 测试接口 2.6
     */
    @Test
    public void AccountUpdateNotificationTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("ACCOUNT_UPDATE_NOTIFICATION").createEntity();
        // trxInfo交易信息
        AccountUpdateNotificationTrxInfo trxInfo = new AccountUpdateNotificationTrxInfo().builder()
                .setToken("6292610358444335641")
                .setAccountTier("1")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }


    /**
     * Card Status Management 测试接口 2.7
     */
    @Test
    public void CardStatusManagementTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("CARD_STATUS_MANAGEMENT").createEntity();
        // trxInfo交易信息
        CardStatusManagementTrxInfo trxInfo = new CardStatusManagementTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3333800261535744")
                .setToken("6292610358444335641")
                .setTokenAction("DELETE")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }
    /**
     * Card Status Notification 2.8  SCIS调用APPGW
     *
     */

    /**
     * Card Status Inquiry测试接口 2.9
     */
    @Test
    public void cardStatusInquiryTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("CARD_STATUS_INQUIRY").createEntity();
        // trxInfo交易信息
        CardStatusInquiryTrxInfo trxInfo = new CardStatusInquiryTrxInfo().builder()
                .setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf")
                .setUserID("3301817853921280")
                .setToken("6200099880516965")
                .createEntity();
        // 调用service服务
        Map map = new UnionPayServiceImpl().unionPayService(msgInfo, trxInfo);
        printMehod(map);
    }

    /**
     * Card Balance Inquiry 测试接口 2.10
     */
    @Test
    public void cardBalanceInquiryTest() throws Exception {
        // MsgInfo公共报文
        MsgInfo msgInfo = new MsgInfo().builder().setMsgType("CARD_BALANCE_INQUIRY").createEntity();
        // trxInfo交易信息
        CardBalanceInquiryTrxInfo trxInfo = new CardBalanceInquiryTrxInfo().builder().setDeviceID("1b5ddc2562a8de5b4e175d418f5b7edf").setUserID("3333800261535744").setToken("6292610358444335641")
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
