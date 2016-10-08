package com.tencent.mobileqq.webview.webso;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import wns_proxy.HttpReq;

public class WebSoServlet
  extends MSFServlet
{
  private static final int a = 60000;
  public static final String a = "hostUin";
  public static final String b = "key_req";
  public static final String c = "refer";
  public static final String d = "rsp_data";
  public static final String e = "rsp_code";
  public static final String f = "rsp_message";
  public static final String g = "key_request_code";
  public static final String h = "key_time_out";
  public static final String i = "key_receive_class";
  private static final String j = WebSoServlet.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Intent a(Intent paramIntent, long paramLong, String paramString1, HttpReq paramHttpReq, String paramString2)
  {
    return a(paramIntent, paramLong, paramString1, paramHttpReq, paramString2, 60000, 100, WebSoService.class);
  }
  
  public static Intent a(Intent paramIntent, long paramLong, String paramString1, HttpReq paramHttpReq, String paramString2, int paramInt1, int paramInt2, Class paramClass)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("hostUin", paramLong);
    localIntent.putExtra("key_req", paramHttpReq);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("key_time_out", paramInt1);
    localIntent.putExtra("key_request_code", paramInt2);
    localIntent.putExtra("key_receive_class", paramClass);
    return localIntent;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    String str = paramIntent.getStringExtra("url");
    localBundle.putString("url", str);
    if (paramFromServiceMsg != null)
    {
      localBundle.putInt("rsp_code", paramFromServiceMsg.getResultCode());
      localBundle.putString("rsp_message", paramFromServiceMsg.getBusinessFailMsg());
    }
    int k = paramIntent.getIntExtra("key_request_code", 100);
    paramIntent = (Class)paramIntent.getSerializableExtra("key_receive_class");
    if (paramIntent == null) {}
    do
    {
      return;
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
        break;
      }
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      str = WebSoRequest.a(WebSoUtils.d(str));
    } while (TextUtils.isEmpty(str));
    localBundle.putInt("rsp_code", 0);
    paramFromServiceMsg = WebSoRequest.a(paramFromServiceMsg, str);
    if (paramFromServiceMsg != null)
    {
      localBundle.putSerializable("rsp_data", paramFromServiceMsg);
      notifyObserver(null, k, true, localBundle, paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(j, 2, "inform WebSoServlet isSuccess false");
    }
    notifyObserver(null, k, false, localBundle, paramIntent);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(j, 2, "inform WebSoServlet resultcode fail.");
    }
    notifyObserver(null, k, false, localBundle, paramIntent);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("hostUin", 0L);
    HttpReq localHttpReq = (HttpReq)paramIntent.getSerializableExtra("key_req");
    String str2 = paramIntent.getStringExtra("refer");
    String str1 = paramIntent.getStringExtra("url");
    int k = paramIntent.getIntExtra("key_time_out", 60000);
    paramIntent = new WebSoRequest(WebSoUtils.d(str1), l, localHttpReq, str2).encode();
    if (paramIntent == null) {
      paramIntent = new byte[4];
    }
    for (;;)
    {
      if (k <= 0) {}
      for (l = 60000L;; l = k)
      {
        paramPacket.setTimeout(l);
        paramPacket.setSSOCommand(WebSoUtils.e(str1));
        paramPacket.putSendData(paramIntent);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\webso\WebSoServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */