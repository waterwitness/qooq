package com.tencent.mobileqq.service.qwallet;

import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class UniPayService
  extends BaseProtocolCoder
{
  public UniPayService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (UniPayResponse)paramToServiceMsg.getByClass("stResponse", new UniPayResponse());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      return null;
    }
    catch (Exception paramToServiceMsg) {}
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.VipSTCheckServer.VipSTCheckObj");
    paramUniPacket.setFuncName("mobileUniPayCheck");
    paramUniPacket.put("stRequest", (UniPayRequest)paramToServiceMsg.extraData.getSerializable("UniPayRequest"));
    return true;
  }
  
  public String[] a()
  {
    return new String[] { "VipSTCheckServer" };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\qwallet\UniPayService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */