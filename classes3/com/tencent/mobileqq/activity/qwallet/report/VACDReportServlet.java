package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportReq;
import VACDReport.ReportRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class VACDReportServlet
  extends MSFServlet
{
  public static final int a = 1;
  public static final String a = "cmd_type";
  public static final String b = "QQWalletPayReportSvc.vacdReportProxy";
  public static final String c = "vacdReportProxy";
  public static final String d = "MQQ.VACDReportServer.VACDReportObj";
  private static final String e = "VACDReport";
  
  public VACDReportServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg == null) || (paramIntent == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "onReceive request or response is null");
      }
    }
    while (!"QQWalletPayReportSvc.vacdReportProxy".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VACDReport", 2, "QQWalletPayReportSvc onReceive");
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (ReportRsp localReportRsp = (ReportRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ReportRsp());; localReportRsp = null)
    {
      Bundle localBundle = new Bundle();
      if (localReportRsp != null) {
        localBundle.putSerializable("rsp", localReportRsp);
      }
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      notifyObserver(paramIntent, 1, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getExtras().getInt("cmd_type"))
    {
    default: 
      return;
    }
    paramPacket.addRequestPacket("req", (ReportReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQWalletPayReportSvc.vacdReportProxy");
    paramPacket.setFuncName("vacdReportProxy");
    paramPacket.setServantName("MQQ.VACDReportServer.VACDReportObj");
    paramPacket.setTimeout(15000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\report\VACDReportServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */