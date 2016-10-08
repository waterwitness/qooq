package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class EcShopServlet
  extends MSFServlet
{
  public static final String a = "cmd";
  public static final String b = "data";
  public static final String c = "timeout";
  
  public EcShopServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcShopServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
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
      new Bundle().putByteArray("data", arrayOfByte);
      EcShopHandler localEcShopHandler = (EcShopHandler)((QQAppInterface)super.getAppRuntime()).a(68);
      if (localEcShopHandler != null) {
        localEcShopHandler.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EcShopServlet", 2, "onReceive exit");
      }
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    if (!TextUtils.isEmpty(str))
    {
      paramPacket.setSSOCommand("SQQShopFolderSvc." + str);
      paramPacket.setTimeout(l);
      if (arrayOfByte == null) {
        break label133;
      }
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.a(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.a(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EcShopServlet", 2, "onSend exit cmd=" + str);
      }
      return;
      label133:
      paramIntent = new byte[4];
      PkgTools.a(paramIntent, 0, 4L);
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */