package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ProtoServlet
  extends MSFServlet
{
  public static final int a = 1;
  public static final String a = "MSFServlet";
  public static final int b = 2;
  public static final String b = "cmd";
  public static final int c = -1;
  public static final String c = "data";
  public static final String d = "timeout";
  public static final String e = "DataType";
  public static final String f = "RequestType";
  public static final String g = "isResend";
  
  public ProtoServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onReceive");
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = WupUtil.b(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      Bundle localBundle = paramIntent.getExtras();
      localBundle.putByteArray("data", arrayOfByte);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
      if (QLog.isColorLevel()) {
        QLog.i("MSFServlet", 2, "onReceive exit");
      }
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onSend");
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(WupUtil.a(arrayOfByte));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onSend exit");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ProtoServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */