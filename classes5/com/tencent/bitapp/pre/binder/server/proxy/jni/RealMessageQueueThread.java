package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.common.logging.FLog;
import com.tencent.bitapp.pre.binder.MessageQueueThread;
import com.tencent.bitapp.thread.ThreadManager;

public class RealMessageQueueThread
  implements MessageQueueThread
{
  public static final String TAG = "RealMessageQueueThread";
  
  public void assertIsOnThread() {}
  
  public boolean isOnThread()
  {
    return true;
  }
  
  public void runOnQueue(Runnable paramRunnable)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("RealMessageQueueThread", "RealMessageQueueThread runOnQueue");
    }
    ThreadManager.INSTANCE.execute(paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\RealMessageQueueThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */