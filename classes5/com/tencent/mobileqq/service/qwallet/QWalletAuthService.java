package com.tencent.mobileqq.service.qwallet;

import QQWalletPay.ReqCheckChangePwdAuth;
import QQWalletPay.RespCheckChangePwdAuth;
import Wallet.AdvRequest;
import Wallet.AuthCodeReq;
import Wallet.AuthCodeRsp;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QWalletAuthService
  extends BaseProtocolCoder
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qwallet.auth.AuthService";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new String[] { "QQWalletPayAuthServer", "AdvRuleSvrCmd", "WalletGestureSvc", "VacThirdCodeSvc" };
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
      paramToServiceMsg = (RespCheckChangePwdAuth)paramToServiceMsg.getByClass("resp", new RespCheckChangePwdAuth());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeModifyPassAuthWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeModifyPassAuthWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.OpenPayServer.QQWalletPayAuthObj");
    paramUniPacket.setFuncName("checkChangePwdAuth");
    paramUniPacket.put("req", (ReqCheckChangePwdAuth)paramToServiceMsg.extraData.getSerializable("ReqCheckChangePwdAuth"));
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getWupBuffer() == null)) {
      return null;
    }
    paramToServiceMsg = new Bundle();
    paramToServiceMsg.putByteArray("resp", paramFromServiceMsg.getWupBuffer());
    return paramToServiceMsg;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.AdvRuleServer.AdvRuleObj");
    paramUniPacket.setFuncName("getAdList");
    paramUniPacket.put("req", (AdvRequest)paramToServiceMsg.extraData.getSerializable("AdvRequest"));
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (GetPasswordRsp)paramToServiceMsg.getByClass("rsp", new GetPasswordRsp());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetPasswordWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetPasswordWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("Wallet.GesturePasswordServer.GesturePasswordObj");
    paramUniPacket.setFuncName("GetPassword");
    paramUniPacket.put("req", (GetPasswordReq)paramToServiceMsg.extraData.getSerializable("GetPasswordReq"));
    return true;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (AuthCodeRsp)paramToServiceMsg.getByClass("rsp", new AuthCodeRsp());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetAuthCode error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetAuthCode error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VAC.AuthCodeCoroServer.AuthCodeCoroObj");
    paramUniPacket.setFuncName("fetchCodes");
    paramUniPacket.put("req", (AuthCodeReq)paramToServiceMsg.extraData.getSerializable("AuthCodeReq"));
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      if (str.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
        return b(paramToServiceMsg, paramFromServiceMsg);
      }
      if (str.compareTo("AdvRuleSvrCmd.getAdList") == 0) {
        return c(paramToServiceMsg, paramFromServiceMsg);
      }
      if (str.compareTo("WalletGestureSvc.GetPassword") == 0) {
        return d(paramToServiceMsg, paramFromServiceMsg);
      }
    } while (str.compareTo("VacThirdCodeSvc.fetchCodes") != 0);
    return e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return false;
      if (str.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
        return b(paramToServiceMsg, paramUniPacket);
      }
      if (str.compareTo("AdvRuleSvrCmd.getAdList") == 0) {
        return c(paramToServiceMsg, paramUniPacket);
      }
      if (str.compareTo("WalletGestureSvc.GetPassword") == 0) {
        return d(paramToServiceMsg, paramUniPacket);
      }
    } while (str.compareTo("VacThirdCodeSvc.fetchCodes") != 0);
    return e(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\qwallet\QWalletAuthService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */