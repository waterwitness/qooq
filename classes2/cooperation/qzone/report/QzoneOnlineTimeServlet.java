package cooperation.qzone.report;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneOnlineTimeServlet
  extends MSFServlet
{
  private static final int a = 60000;
  
  public QzoneOnlineTimeServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      QzoneOnlineTimeCollectRptService.a().c(paramFromServiceMsg.getResultCode());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QzoneOnlineTimeServlet", 2, "fromServiceMsg==msg");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getSerializableExtra("list");
    QLog.d("QzoneOnlineTimeServlet", 1, "uin:" + getAppRuntime().getLongAccountUin());
    QzoneOnlineTimeCollectReportRequest localQzoneOnlineTimeCollectReportRequest = new QzoneOnlineTimeCollectReportRequest(getAppRuntime().getLongAccountUin(), (ArrayList)paramIntent);
    byte[] arrayOfByte = localQzoneOnlineTimeCollectReportRequest.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localQzoneOnlineTimeCollectReportRequest.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\report\QzoneOnlineTimeServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */