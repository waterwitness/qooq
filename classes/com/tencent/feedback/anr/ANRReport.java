package com.tencent.feedback.anr;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.c;

public class ANRReport
{
  public static void startANRMonitor(Context paramContext)
  {
    paramContext = c.a();
    if (paramContext != null) {
      paramContext.f();
    }
  }
  
  public static void stopANRMonitor()
  {
    c localc = c.a();
    if (localc != null) {
      localc.g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\feedback\anr\ANRReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */