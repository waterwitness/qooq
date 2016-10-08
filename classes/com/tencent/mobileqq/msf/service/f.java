package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class f
  extends Thread
{
  private static String c = "MSF.S.RespHandler";
  public volatile boolean a = true;
  MsfCore b;
  
  public f(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
  }
  
  public void run()
  {
    while (this.a)
    {
      String str;
      for (;;)
      {
        try
        {
          MsfMessagePair localMsfMessagePair = (MsfMessagePair)this.b.getMsfMessagePairs().take();
          if (localMsfMessagePair == null) {
            break;
          }
          if (localMsfMessagePair.toServiceMsg == null) {
            break label200;
          }
          str = g.b(localMsfMessagePair.toServiceMsg);
          if ((!"LongConn.OffPicUp".equals(localMsfMessagePair.toServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equals(localMsfMessagePair.toServiceMsg.getServiceCmd()))) {
            break label149;
          }
          QLog.d(c, 1, "recv " + str + " req:" + localMsfMessagePair.toServiceMsg.getStringForLog() + "resp:" + localMsfMessagePair.fromServiceMsg.getStringForLog());
          c.a(str, localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        break;
        label149:
        QLog.d(c, 2, str + " add resp to queue:" + localInterruptedException.toServiceMsg.getRequestSsoSeq() + " from:" + localInterruptedException.fromServiceMsg);
      }
      label200:
      if (localInterruptedException.fromServiceMsg != null)
      {
        str = g.a(localInterruptedException.fromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, str + " add push to queue: from:" + localInterruptedException.fromServiceMsg);
        }
        c.a(str, localInterruptedException.toServiceMsg, localInterruptedException.fromServiceMsg);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\service\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */