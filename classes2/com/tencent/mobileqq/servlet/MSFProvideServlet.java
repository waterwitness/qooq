package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppConstants.Action;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class MSFProvideServlet
  extends MSFServlet
  implements AppConstants
{
  public MSFProvideServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AppConstants.Action localAction = (AppConstants.Action)paramIntent.getSerializableExtra("action");
    Bundle localBundle = paramIntent.getExtras();
    switch (upm.a[localAction.ordinal()])
    {
    }
    do
    {
      return;
    } while (!paramFromServiceMsg.isSuccess());
    localBundle.putString("info", (String)paramFromServiceMsg.getAttribute("App_NerworkTrafficDebugInfo"));
    notifyObserver(paramIntent, 0, true, localBundle, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = (AppConstants.Action)paramIntent.getSerializableExtra("action");
    switch (upm.a[paramPacket.ordinal()])
    {
    default: 
      return;
    }
    sendToMSF(paramIntent, MsfMsgUtil.getNetworkTrafficDebugInfo(null));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\MSFProvideServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */