package com.tencent.mobileqq.servlet;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneMsfPushAckRequest;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZonePushAckServlet
  extends MSFServlet
{
  private static final int a = 60000;
  public static final String a = "timestamp";
  public static final String b = "hostuin";
  public static final String c = "mark";
  public static final String d = "flag";
  private static final String e = "SQQzoneSvc.";
  private static final String f = QZonePushAckServlet.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("timestamp", 0L);
    byte[] arrayOfByte = new QZoneMsfPushAckRequest(paramIntent.getLongExtra("hostuin", 0L), l, paramIntent.getStringExtra("refer"), paramIntent.getLongExtra("flag", 0L), paramIntent.getStringExtra("mark")).encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "wns.pushrsp");
    paramPacket.putSendData(paramIntent);
    QLog.d("MessageSvc.WNSQzone.Push", 2, "发送push ack 时间:" + l);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\QZonePushAckServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */