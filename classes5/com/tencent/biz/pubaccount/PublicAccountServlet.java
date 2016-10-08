package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class PublicAccountServlet
  extends MSFServlet
{
  public static final String a = "PubAccountAdSvc.";
  private static final String b = "PubAccountSvc.";
  private static final String d = "need_handler";
  private String c;
  
  public PublicAccountServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "com.tencent.biz.pubaccount.PublicAccountServlet";
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("need_handler", true);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onReceive");
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = WupUtil.b(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putByteArray("data", arrayOfByte);
      if (paramIntent.getBooleanExtra("need_handler", false))
      {
        localObject = (PublicAccountHandler)((QQAppInterface)super.getAppRuntime()).a(11);
        if (localObject != null) {
          ((PublicAccountHandler)localObject).a(paramIntent, paramFromServiceMsg, arrayOfByte);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "onReceive exit");
        }
        return;
        super.notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject, null);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onSend");
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    if (paramIntent.equals("get_business_recommend")) {
      paramPacket.setSSOCommand("PubAccBusiRecSvc." + paramIntent);
    }
    for (;;)
    {
      paramPacket.putSendData(WupUtil.a(arrayOfByte));
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "onSend exit");
      }
      return;
      if (paramIntent.equals("post_punchcard_info"))
      {
        paramPacket.setSSOCommand("PubAccountSSOProxySvc." + paramIntent);
      }
      else if ((paramIntent.equals("PubAccountFollowSvc.follow")) || (paramIntent.equals("PubAccountFollowSvc.subscribe")))
      {
        paramPacket.setTimeout(10000L);
        paramPacket.setSSOCommand(paramIntent);
      }
      else if (paramIntent.equals("PubAccountAdSvc.recent_list_report"))
      {
        paramPacket.setSSOCommand(paramIntent);
      }
      else if (paramIntent.equals("PubAccountArticleCenter.GetUrlByVid"))
      {
        paramPacket.setTimeout(15000L);
        paramPacket.setSSOCommand(paramIntent);
      }
      else if (paramIntent.equals("PubAccountSvc.mp_is_admin_uin"))
      {
        paramPacket.setSSOCommand(paramIntent);
      }
      else if (paramIntent.equals("PubAccountSvc.mp_get_notifycation"))
      {
        paramPacket.setSSOCommand(paramIntent);
      }
      else if (paramIntent.equals("PubAccountAdSvc."))
      {
        paramPacket.setSSOCommand("PubAccountAdSvc.ad_report");
      }
      else if (paramIntent.equals("set_message_configuration"))
      {
        paramPacket.setSSOCommand("PubAccountSvc.set_message_configuration");
      }
      else
      {
        paramPacket.setSSOCommand("PubAccountSvc." + paramIntent);
        if ("get_follow_list".equals(paramIntent)) {
          paramPacket.autoResend = true;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */