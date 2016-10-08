package com.tencent.mobileqq.service.qwallet;

import VipRecommend.MQQ.CommPayInfo;
import VipRecommend.MQQ.UserInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VIPRecommendService
  extends BaseProtocolCoder
{
  public static final String a = "MQQ.VipPayLogicServer.VipPayLogicObj";
  public static final String b = "getCommPayInfo";
  public static final String c = "VIPRecommendPayRequest";
  
  public VIPRecommendService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("VipPayLogicServer.getCommPayInfo ".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramFromServiceMsg == null) {
        return null;
      }
      paramToServiceMsg = new UniPacket(true);
      try
      {
        paramToServiceMsg.setEncodeName("utf-8");
        paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = (CommPayInfo)paramToServiceMsg.getByClass("payInfo", new CommPayInfo());
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
    paramUniPacket.setServantName("MQQ.VipPayLogicServer.VipPayLogicObj");
    paramUniPacket.setFuncName("getCommPayInfo");
    paramUniPacket.put("userInfo", (UserInfo)paramToServiceMsg.extraData.getSerializable("VIPRecommendPayRequest"));
    return true;
  }
  
  public String[] a()
  {
    return new String[] { "VipPayLogicServer" };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\qwallet\VIPRecommendService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */