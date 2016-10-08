package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class DataLineServlet
  extends MSFServlet
{
  static final String a = "DataLineServlet";
  
  public DataLineServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineServlet", 2, "onReceive called");
    }
    if (paramIntent == null)
    {
      QLog.e("DataLineServlet", 1, "onReceive : req is null");
      return;
    }
    paramIntent.getExtras().putParcelable("response", paramFromServiceMsg);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    ((DataLineHandler)localQQAppInterface.a(8)).a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineServlet", 2, "onSend called");
    }
    if (paramIntent == null) {
      QLog.e("DataLineServlet", 1, "onSend : req is null");
    }
    do
    {
      return;
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent == null) {
        break;
      }
      paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      paramPacket.putSendData(paramIntent.getWupBuffer());
      paramPacket.setTimeout(paramIntent.getTimeout());
    } while (paramIntent.isNeedCallback());
    paramPacket.setNoResponse();
    return;
    QLog.e("DataLineServlet", 1, "onSend : toMsg is null");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\DataLineServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */