package com.tencent.mobileqq.fts.logger;

import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Logger
  implements ILogger
{
  public Logger()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ("d".equals(paramString2))
    {
      Log.d(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("e".equals(paramString2))
    {
      Log.e(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("w".equals(paramString2))
    {
      Log.w(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("i".equals(paramString2))
    {
      Log.i(paramString1, paramString3, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString3, paramThrowable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\logger\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */