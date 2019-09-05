package com.rrtx.service;

import com.rrtx.dataobject.MsgInfo;
import com.rrtx.fap.frame.exception.FAPBusinessException;
import com.rrtx.fap.frame.service.IFAPLocalService;
import java.io.IOException;
import java.util.Map;

public interface IUnionPayService extends IFAPLocalService {
    /**
     *
     * @param msgInfo
     * @param trxInfo
     * @return
     * @throws FAPBusinessException
     */
    Map unionPayService(MsgInfo msgInfo ,Object trxInfo) throws FAPBusinessException, IOException;


}

