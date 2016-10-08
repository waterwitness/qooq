package com.tencent.commonsdk.soload;

import android.content.Context;
import android.os.SystemClock;

public class SoLoadUtilNew
{
  private static SoLoadReport sReport;
  
  private static boolean getLoadResult(int paramInt)
  {
    boolean bool = false;
    if ((paramInt & 0x2) == 2) {
      bool = true;
    }
    while ((paramInt & 0x40000) != 262144) {
      return bool;
    }
    return true;
  }
  
  public static boolean loadSoByName(Context paramContext, String paramString)
  {
    long l1 = SystemClock.uptimeMillis();
    int i = SoLoadCore.loadSo(paramContext, paramString);
    long l2 = SystemClock.uptimeMillis();
    if (sReport != null) {
      sReport.report(i, paramString, l2 - l1);
    }
    return getLoadResult(i);
  }
  
  public static void setReport(SoLoadReport paramSoLoadReport)
  {
    sReport = paramSoLoadReport;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\soload\SoLoadUtilNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */