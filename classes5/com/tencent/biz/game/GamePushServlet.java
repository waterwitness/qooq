package com.tencent.biz.game;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class GamePushServlet
  extends MSFServlet
{
  private String[] a;
  
  public GamePushServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new String[] { "OnlinePush.ReqPush.GameStatusPush" };
  }
  
  public String[] getPreferSSOCommands()
  {
    return this.a;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    MSFToWebViewConnector localMSFToWebViewConnector = SensorAPIJavaScript.getMsfToWebViewConnector();
    if (localMSFToWebViewConnector != null) {
      localMSFToWebViewConnector.a(paramIntent, paramFromServiceMsg);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GamePushServlet", 2, "WebView not connect to msf");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\game\GamePushServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */