package mqq.app;

import com.tencent.qphone.base.util.QLog;

public class CrashHandler
  implements Thread.UncaughtExceptionHandler
{
  private boolean isCrahing;
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      if (this.isCrahing) {
        return;
      }
      this.isCrahing = true;
      paramThread = (MobileQQ)MobileQQ.getContext();
      if (paramThread != null)
      {
        String str = paramThread.getProcessName();
        QLog.e("crash", 1, str + " has crashed.", paramThrowable);
        paramThread.closeAllActivitys();
        QLog.flushLog();
        return;
      }
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\CrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */