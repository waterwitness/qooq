package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class WebSSOAgentServlet
  extends MSFServlet
{
  public static long a = 0L;
  public static final String a = "extra_cmd";
  public static long b = 0L;
  public static final String b = "extra_data";
  public static long c = 0L;
  public static final String c = "extra_callbackid";
  public static long d = 0L;
  public static final String d = "extra_timeout";
  public static final String e = "extra_result_code";
  private static final String f = "WebSSOAgentServlet";
  
  public WebSSOAgentServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    c = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("WebSSOAgentServlet", 2, "onReceive");
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("extra_result_code", paramFromServiceMsg.getResultCode());
      localBundle.putString("extra_cmd", paramIntent.getStringExtra("extra_cmd"));
      localBundle.putString("extra_callbackid", paramIntent.getStringExtra("extra_callbackid"));
      localBundle.putByteArray("extra_data", arrayOfByte);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSSOAgentServlet", 2, "onSend");
    }
    String str = paramIntent.getStringExtra("extra_cmd");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("extra_data");
    paramPacket.setSSOCommand(str);
    long l = paramIntent.getLongExtra("extra_timeout", -1L);
    if (l > 0L) {
      paramPacket.setTimeout(l);
    }
    if (arrayOfByte != null)
    {
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.a(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.a(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    b = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\WebSSOAgentServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */