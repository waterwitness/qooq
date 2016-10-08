package com.tencent.mobileqq.service;

import VIP.AIOSendReq;
import VIP.AIOSendRes;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VIPAioSendService
  extends BaseProtocolCoder
{
  public static final String a = "VIP.AIOSendTipsServer.AIOSendTipsObj";
  public static final String b = "CheckPopGrayStips";
  public static final String c = "VIPAioSendRequest";
  
  public VIPAioSendService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (VIPAioSendHandler.a.equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramFromServiceMsg == null) {
        return null;
      }
      paramToServiceMsg = new UniPacket(true);
      try
      {
        paramToServiceMsg.setEncodeName("utf-8");
        paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = (AIOSendRes)paramToServiceMsg.getByClass("response", new AIOSendRes());
        return paramToServiceMsg;
      }
      catch (RuntimeException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return null;
      }
      catch (Exception paramToServiceMsg)
      {
        return null;
      }
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VIP.AIOSendTipsServer.AIOSendTipsObj");
    paramUniPacket.setFuncName("CheckPopGrayStips");
    paramUniPacket.put("request", (AIOSendReq)paramToServiceMsg.extraData.getSerializable("VIPAioSendRequest"));
    return true;
  }
  
  public String[] a()
  {
    return new String[] { "AIOSendSvc" };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\VIPAioSendService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */