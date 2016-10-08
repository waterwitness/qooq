package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneAlbumRedTouchServlet
  extends MSFServlet
{
  private static final int a = 60000;
  
  public QzoneAlbumRedTouchServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedDotServlet", 2, "resultcode:" + paramFromServiceMsg.getResultCode() + ",failMsg:" + paramFromServiceMsg.getBusinessFailMsg());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QzoneAlbumRedDotServlet", 2, "fromServiceMsg==msg");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getSerializableExtra("req");
    if ((paramIntent != null) && ((paramIntent instanceof operation_red_touch_req)))
    {
      QzoneAlbumRedTouchRequest localQzoneAlbumRedTouchRequest = new QzoneAlbumRedTouchRequest(getAppRuntime().getLongAccountUin(), (operation_red_touch_req)paramIntent);
      byte[] arrayOfByte = localQzoneAlbumRedTouchRequest.encode();
      paramIntent = arrayOfByte;
      if (arrayOfByte == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localQzoneAlbumRedTouchRequest.uniKey());
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qzonealbumreddot\QzoneAlbumRedTouchServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */