package com.tencent.mobileqq.service.qwallet;

import VIP.ReqCheckPayAuth;
import VIP.RespCheckPayAuth;
import Wallet.PrePayRqt;
import Wallet.PrePayRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QWalletOpenService
  extends BaseProtocolCoder
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qwallet.open.OpenPayService";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new String[] { "OpenPayServer", "QPaySvc" };
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (PrePayRsp)paramToServiceMsg.getByClass("rsp", new PrePayRsp());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeQPayAuthWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeQPayAuthWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("Wallet.QPayAuthServer.QPayAuthObj");
    paramUniPacket.setFuncName("prePay");
    paramUniPacket.put("rqt", (PrePayRqt)paramToServiceMsg.extraData.getSerializable("rqt"));
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (RespCheckPayAuth)paramToServiceMsg.getByClass("resp", new RespCheckPayAuth());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.OpenPayServer.OpenPayObj");
    paramUniPacket.setFuncName("checkPayAuth");
    ReqCheckPayAuth localReqCheckPayAuth = (ReqCheckPayAuth)paramToServiceMsg.extraData.getSerializable("reqCheckPayAuth");
    paramToServiceMsg.setTimeout(20000L);
    paramUniPacket.put("req", localReqCheckPayAuth);
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      if (str.compareTo("OpenPayServer.checkPayAuth") == 0) {
        return c(paramToServiceMsg, paramFromServiceMsg);
      }
    } while (str.compareTo("QPaySvc.prePay") != 0);
    return b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return false;
      if (str.compareTo("OpenPayServer.checkPayAuth") == 0) {
        return c(paramToServiceMsg, paramUniPacket);
      }
    } while (str.compareTo("QPaySvc.prePay") != 0);
    return b(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\qwallet\QWalletOpenService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */