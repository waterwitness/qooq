package com.tencent.mobileqq.unifiedebug;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class UnifiedDebugReportServlet
  extends MSFServlet
{
  public static final String a = "extra_cmd";
  public static final String b = "extra_data";
  public static final String c = "extra_result_code";
  private static final String d = UnifiedDebugReportServlet.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "onReceive");
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
      localBundle.putByteArray("extra_data", arrayOfByte);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "onSend");
    }
    Object localObject = paramIntent.getStringExtra("extra_cmd");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return;
      paramIntent = paramIntent.getByteArrayExtra("extra_data");
      paramPacket.setSSOCommand((String)localObject);
    } while (paramIntent == null);
    localObject = new byte[paramIntent.length + 4];
    PkgTools.a((byte[])localObject, 0, paramIntent.length + 4);
    PkgTools.a((byte[])localObject, 4, paramIntent, paramIntent.length);
    paramPacket.putSendData((byte[])localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\UnifiedDebugReportServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */