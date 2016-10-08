package com.tencent.mobileqq.service.cardpay;

import CardPay.LBSInfo;
import CardPay.ReqChannel;
import CardPay.ReqPayOrder;
import CardPay.ResChannel;
import CardPay.ResPayOrder;
import android.os.Build;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public class CardPayService
  extends BaseProtocolCoder
{
  public CardPayService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("CardPayControl.queryChannel".equals(paramToServiceMsg.getServiceCmd())) {
      return (ResChannel)a(paramFromServiceMsg.getWupBuffer(), "ResChannel", new ResChannel());
    }
    if ("CardPayControl.queryPayOrder".equals(paramToServiceMsg.getServiceCmd())) {
      return (ResPayOrder)a(paramFromServiceMsg.getWupBuffer(), "ResPayOrder", new ResPayOrder());
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    for (;;)
    {
      String str;
      try
      {
        if ("CardPayControl.queryChannel".equals(paramToServiceMsg.getServiceCmd()))
        {
          i = ((Integer)paramToServiceMsg.getAttribute("subCmd")).intValue();
          int j = ((Integer)paramToServiceMsg.getAttribute("pid")).intValue();
          localObject1 = (LBSInfo)paramToServiceMsg.getAttribute("lbsInfo");
          int k = ((Integer)paramToServiceMsg.getAttribute("nfc_sup", Integer.valueOf(1))).intValue();
          paramToServiceMsg.setAttributes(new HashMap());
          if (localObject1 != null) {
            break label244;
          }
          paramToServiceMsg = new LBSInfo();
          paramToServiceMsg = new ReqChannel(i, j, paramToServiceMsg, Build.MODEL, k, "6.5.5");
          paramUniPacket.setServantName("MQQ.CardPayControlServer.CardPayControlObj");
          paramUniPacket.setFuncName("queryChannel");
          paramUniPacket.put("ReqChannel", paramToServiceMsg);
          return true;
        }
        if (!"CardPayControl.queryPayOrder".equals(paramToServiceMsg.getServiceCmd())) {
          break label242;
        }
        i = ((Integer)paramToServiceMsg.getAttribute("subCmd")).intValue();
        localObject1 = (String)paramToServiceMsg.getAttribute("payChannel");
        localObject2 = (String)paramToServiceMsg.getAttribute("payChannelSubId");
        str = (String)paramToServiceMsg.getAttribute("orderId");
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (localObject1 != null) {
          break label249;
        }
        paramToServiceMsg = "";
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        paramToServiceMsg.printStackTrace();
      }
      paramToServiceMsg = new ReqPayOrder(i, paramToServiceMsg, (String)localObject1, (String)localObject2);
      paramUniPacket.setServantName("MQQ.CardPayControlServer.CardPayControlObj");
      paramUniPacket.setFuncName("queryPayOrder");
      paramUniPacket.put("ReqPayOrder", paramToServiceMsg);
      return true;
      label242:
      return false;
      label244:
      paramToServiceMsg = (ToServiceMsg)localObject1;
      continue;
      label249:
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
    }
  }
  
  public String[] a()
  {
    return new String[] { "CardPayControl" };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\cardpay\CardPayService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */