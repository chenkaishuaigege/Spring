package com.rrtx.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rrtx.dataobject.EncCertId;
import com.rrtx.dataobject.MsgInfo;
import com.rrtx.dataobject.MsgResponse;
import com.rrtx.fap.frame.exception.FAPBusinessException;
import com.rrtx.service.IUnionPayService;
import com.rrtx.util.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.rrtx.util.JWTUtil.jwsAttestation;

public class UnionPayServiceImpl implements IUnionPayService {

    public static final String msgInfoConstant = "msgInfo";
    public static final String trxInfoConstant = "trxInfo";
    public static final String encCertIdConstant = "encCertId";
    public static final String msgResponseConstant = "msgResponse";



    @Override
    public Map unionPayService(MsgInfo msgInfo, Object trxInfo) throws Exception {

        Map map = new HashMap();
        //实体类序列化
        String msgInfoSerialize = SerializeUtil.serialize(msgInfo);
        String trxInfoSerialize = SerializeUtil.serialize(trxInfo);
        //组装发送请求的MAP(key值需要和接口文档中对应)
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(msgInfoConstant , msgInfoSerialize);
        paramMap.put(trxInfoConstant , trxInfoSerialize);

        //交易数据的 json字符串
        //String onlineMessage = JsonMapCoverUtill.coverMap2JsonString(paramMap);

        JSONObject jsonobject = JSONUtil.parseFromMap(paramMap);
        String onlineMessage = jsonobject.toString();
        onlineMessage = onlineMessage.replace("\"{" , "{");
        onlineMessage = onlineMessage.replace("}\"" , "}");
        onlineMessage = onlineMessage.replace("\\" , "");
        System.out.println("发送online message 信息:");
        System.out.println(onlineMessage);
        //TODO 签名 constructSignedMethod方法需要去掉
        //String headerSign = SignUtil.constructSignedMethod(onlineMessage);
        String headerSign = JWTUtil.jwsSignatureNew(onlineMessage);
        //获取Service_URL_suffix
        String service_URL_suffix = ConversionUtil.msgTypeToUrlSuffix(msgInfo.getMsgType());
        if(StrUtil.isEmpty(service_URL_suffix)){
            return map;
        }
        HttpResponse response = HttpUtil.postMethod(service_URL_suffix, onlineMessage, headerSign);
        String upi_jws = response.header("UPI-JWS");
        String resultMessage = response.body();
        System.out.println("scis返回信息------:");
        System.out.println(resultMessage);
        // TODO 验签
        //jwsAttestation(resultMessage , upi_jws);
        // TODO 模拟返回信息
        //resultMessage = getResultMessage(msgInfo.getMsgType());

        Map<String, Object> resultMap = JsonMapCoverUtill.coverJsonString2Map(resultMessage);
        if(resultMap.containsKey(msgInfoConstant)){
            MsgInfo msgInfoRes = (MsgInfo)SerializeUtil.deserialize(MsgInfo.class, resultMap.get(msgInfoConstant).toString());
            map.put(msgInfoConstant , msgInfoRes);
        }
        if(resultMap.containsKey(trxInfoConstant)){
            Object trxInfoRes = SerializeUtil.deserialize(trxInfo.getClass(), resultMap.get(trxInfoConstant).toString());
            map.put(trxInfoConstant , trxInfoRes);
        }
        if(resultMap.containsKey(msgResponseConstant)){
            MsgResponse msgResponseRes = (MsgResponse)SerializeUtil.deserialize(MsgResponse.class , resultMap.get(msgResponseConstant).toString());
            map.put(msgResponseConstant , msgResponseRes);
        }
        if(resultMap.containsKey(encCertIdConstant)){
            EncCertId encCertIdRes = (EncCertId)SerializeUtil.deserialize(EncCertId.class , resultMap.get(encCertIdConstant).toString());
            map.put(encCertIdConstant , encCertIdRes);
        }
        return map;
    }



    public String getResultMessage(String msgType) {
        switch (msgType) {
            case "CVM_INQUIRY":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808154804701987\",\"timeStamp\":\"20190808154804\",\"msgType\":\"CVM_INQUIRY\",\"insID\":\"39999999\"},\"trxInfo\":{\"cvm\":[\"firstName\",\"midName\",\"lastName\",\"idType\",\"idNo\",\"idCountry\"]},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "OPEN_ACCOUNT":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808105201114935\",\"timeStamp\":\"20190808105201\",\"msgType\":\"OPEN_ACCOUNT\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"token\":\"6292610354932071335\",\"tokenExpiry\":\"801230235959\",\"pan\":\"eyJhqwertyuiopasdfghjklzxcvbnm8s0g\",\"panExpiry\":\"08/22\",\"maskedPan\":\"6233********0060\",\"cardType\":\"Virtual Card\",\"cardFaceID\":\"100101\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "KYC_VERIFICATION":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808105159700443\",\"timeStamp\":\"20190808105159\",\"msgType\":\"KYC_VERIFICATION\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"referNo\":\"119771\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "CARD_ENROLLMENT":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190812095028771330\",\"timeStamp\":\"20190812095028\",\"msgType\":\"CARD_ENROLLMENT\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"token\":\"6292610354932071335\",\"tokenExpiry\":\"801230235959\",\"pan\":\"eyJhbGciOiJSU0ExXzUiLCJlbmMiOiJBMTI4Q0JDLUhTMjU2Iiwia2lkIjoiMzE4NTU2OTg5NjkyNTE4NCJ9.dY26VIT2Pm7aT5IZx8EQCYSe1qCp1I1lFVF1FI4 2NvxfupQCJouZhJzTSUrFjQoGDd_NY89ov3WBGQftiR6s9hBoWtyv6OF-Cd8a7Cf1BAqp7gJw1d44ytCcuv1GucxrVLWvis_Ol3Ndlci4dM1OZEBnokGzbzTM3-GaH0j3 vyRit1Ax6RbS9x49I1X7pl5fpvtG7WuyBZUHED74J86Vga9xBzHch1BsaF57i5WSbzdzoIvRhUcqmnCfV4f6Xsv8788LQerwRbLA-A68tLxA8jSRGxUPOt0du_R4CJP9nZu Ldg15eKf3dufTfIDepjBay5tb4ZGYUI4eX6sDZA0Lhw.M2IzMjhiMTcxMmYyNDMyYw.nesZ5D7h9a7Mjl9hwg0PQFYl2yCITQ_HbchMtS-R19s.8Ku1KLU1Ne1TS0PVIYC SVQ\",\"panExpiry\":\"08/22\",\"maskedPan\":\"6233********0060\",\"cardType\":\"Virtual Card\",\"cardFaceID\":\"100101\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "CARDFACE_DOWNLOADING":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\", \"msgID\":\"A39990052190809145501096991\", \"timeStamp\":\"20190809145501\", \"msgType\":\"CARDFACE_DOWNLOADING\", \"insID\":\"39990052\" },\"trxInfo\": { \"cardfaceID\":\"100201\", \"cardfaceType\":\"0\", \"panPosX\":\"20\", \"panPosY\":\"200\", \"panFontSize\":\"10\", \"color\":\"#fff467\", \"cardfaceData\":\"aVZCT1J3MEtHZ29BQUFBTlNVaEVVZ0FBQVVvQUFBRGNDQVlBQUFBV1ll\" },\"msgResponse\": { \"responseCode\":\"00\", \"responseMsg\":\"Approved\" } }";
            case "ACCOUNT_UPDATE_NOTIFICATION":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"M39999999000000000000479353\",\"timeStamp\":\"20190808105942\",\"msgType\":\"ACCOUNT_UPDATE_NOTIFICATION\",\"insID\":\"39999999\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "CARD_STATUS_MANAGEMENT":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110438843465\",\"timeStamp\":\"20190808110438\",\"msgType\":\"CARD_STATUS_MANAGEMENT\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"tokenState\":\"DELETED\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "CARD_STATUS_INQUIRY":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999006620190809153254831192\",\"timeStamp\":\"20190809153254\",\"msgType\":\"CARD_STATUS_INQUIRY\",\"insID\":\"39990066\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"cardStatus\":\"ACTIVE\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "CARD_BALANCE_INQUIRY":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110431161957\",\"timeStamp\":\"20190808110431\",\"msgType\":\"CARD_BALANCE_INQUIRY\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"accountTier\":\"1\",\"balAmt\":\"73.00\",\"balCurrency\":\"156\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "EXCHANGE_RATE_INQUIRY":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110431161957\",\"timeStamp\":\"20190808110431\",\"msgType\":\"EXCHANGE_RATE_INQUIRY\",\"insID\":\"39999999\"},\"trxInfo\":{\"exchangeAmt\":\"90\",},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "P2P_TRANSFER":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110338387931\",\"timeStamp\":\"20190808110338\",\"msgType\":\"P2P_TRANSFER\",\"insID\":\"39999999\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "QRC_GENERATION":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808105821706450\",\"timeStamp\":\"20190808105821\",\"msgType\":\"QRC_GENERATION\",\"insID\":\"39999999\"},\"trxInfo\":{\"cpqrcNo\":\"01\",\"emvCpqrcPayload\":[\"hQVDUFYwMWFYTwigAAADMwEBAVcTYpJhA1hEQzVkHSIQIBAAABiAH180AQBjM58mCFaLEtnaC9l/nycBgJ8QEQcAAQOgAAABCDM5 OTk5OTk5nzYCAAGCAgAAnzcE6gZYyA==\"],\"barcodeCpqrcPayload\":[\"6236098835899996543\"]},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "ADDITIONAL_PROCESSING_RESULT":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110025381863\",\"timeStamp\":\"20190808110025\",\"msgType\":\"ADDITIONAL_PROCESSING_RESULT\",\"insID\":\"39999999\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "GET_CASH_OUT_TOKEN":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190809161518242996\",\"timeStamp\":\"20190809161518\",\"msgType\":\"GET_CASH_OUT_TOKEN\",\"insID\":\"39999999\"},\"trxInfo\":{\"trxToken\":\"123456789012345678\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "QRC_INFO_INQUIRY":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110302170477\",\"timeStamp\":\"20190808110302\",\"msgType\":\"QRC_INFO_INQUIRY\",\"insID\":\"39999999\"},\"trxInfo\":{\"trxCurrency\":\"156\",\"qrcUseCase\":\"10\",\"merchantName\":\"Test Merchant\",\"mcc\":\"5811\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "MPQRC_PAYMENT_EMV":
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110216974867\",\"timeStamp\":\"20190808110216\",\"msgType\":\"MPQRC_PAYMENT_EMV\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"trxAmt\":\"1.00\",\"trxCurrency\":\"344\",\"qrcVoucherNo\":\"20196220855800073135\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "MPQRC_PAYMENT_URL" :
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110320732976\",\"timeStamp\":\"20190808110320\",\"msgType\":\"MPQRC_PAYMENT_URL\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"trxAmt\":\"1\",\"trxCurrency\":\"156\",\"qrcVoucherNo\":\"32190808397825339521\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "BILL_PAYMENT" :
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110428241642\",\"timeStamp\":\"20190808110428\",\"msgType\":\"BILL_PAYMENT\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "CREDIT_TRANSACTION" :
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110403771258\",\"timeStamp\":\"20190808110403\",\"msgType\":\"CREDIT_TRANSACTION\",\"insID\":\"39999999\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            case "TRX_RESULT_INQUIRY" :
                return "{\"msgInfo\":{\"versionNo\":\"1.0.0\",\"msgID\":\"A3999999920190808110226603697\",\"timeStamp\":\"20190808110226\",\"msgType\":\"TRX_RESULT_INQUIRY\",\"insID\":\"39999999\"},\"trxInfo\":{\"deviceID\":\"1b5ddc2562a8de5b4e175d418f5b7edf\",\"origMsgType\":\"MPQRC_PAYMENT_EMV\",\"trxAmt\":\"1.00\",\"trxCurrency\":\"344\",\"paymentStatus\":\"APPROVED\"},\"msgResponse\":{\"responseCode\":\"00\",\"responseMsg\":\"Approved\"}}";
            default:
                return "";
        }
    }
}
