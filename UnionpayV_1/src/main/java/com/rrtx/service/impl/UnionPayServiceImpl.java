package com.rrtx.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rrtx.dataobject.EncCertId;
import com.rrtx.dataobject.MsgInfo;
import com.rrtx.dataobject.MsgResponse;
import com.rrtx.fap.frame.exception.FAPBusinessException;
import com.rrtx.onlinemessages.KYCVerificationTrxInfo;
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
        String headerSign = JWTUtil.jwsSignature(onlineMessage);
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
        if (!JavaUtil.isEmpty(upi_jws)) {
            //验签
            boolean attestationResult = jwsAttestation(resultMessage, upi_jws);
            if(!attestationResult){
                throw new Exception("Signature verification failed and data was tampered with!");
            }
        }else{
            System.out.println("返回错误,不验签");
        }
        //组装返回实体类
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

}
