package com.tencent.mobileqq.transfile;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ProtoServlet
  extends MSFServlet
{
  public static final String a = "key_cmd";
  public static final String b = "key_body";
  public static final String c = "key_timeout";
  public static final String d = "key_fastresend";
  public static final String e = "quickSendEnable";
  public static final String f = "quickSendStrategy";
  
  public ProtoServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (("LongConn.OffPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
      QLog.d("Q.richmedia.ProtoReqManager", 1, "onRecieve." + paramFromServiceMsg.getStringForLog());
    }
    ((AppInterface)getAppRuntime()).a().a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramPacket.setSSOCommand(paramIntent.getStringExtra("key_cmd"));
      paramPacket.putSendData(paramIntent.getByteArrayExtra("key_body"));
      paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 30000L));
      boolean bool = paramIntent.getBooleanExtra("key_fastresend", false);
      paramPacket.addAttribute("fastresend", Boolean.valueOf(bool));
      paramPacket.autoResend = bool;
      paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(paramIntent.getBooleanExtra("remind_slown_network", true)));
      paramPacket.setQuickSend(paramIntent.getBooleanExtra("quickSendEnable", false), paramIntent.getIntExtra("quickSendStrategy", 0));
    }
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
      QLog.d("Q.richmedia.ProtoReqManager", 1, "onSend." + paramToServiceMsg.getStringForLog());
    }
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\ProtoServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */