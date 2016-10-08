package com.tencent.mobileqq.service;

import MQQ.VipUserInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VIPService
  extends BaseProtocolCoder
{
  private static final String[] a = { "ClubInfoSvc" };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (VipUserInfo)a(paramFromServiceMsg.getWupBuffer(), "stVipInfo", new VipUserInfo());
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.PrivInfoServer.PrivInfoObj");
    paramUniPacket.setFuncName("queryQQInfo");
    String str = paramToServiceMsg.extraData.getString("k_uin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("k_skey");
    paramUniPacket.put("sQQNo", str);
    paramUniPacket.put("sKey", paramToServiceMsg);
    paramUniPacket.put("iGetType", Integer.valueOf(0));
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ClubInfoSvc.GetVipInfoReq".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("ClubInfoSvc.GetVipInfoReq".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\VIPService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */