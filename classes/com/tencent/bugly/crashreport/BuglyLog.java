package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.b;
import com.tencent.bugly.proguard.w;

public class BuglyLog
{
  public static void d(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.b) {
      Log.d(str, paramString1);
    }
    w.a("D", str, paramString1);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.b) {
      Log.e(str, paramString1);
    }
    w.a("E", str, paramString1);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.b) {
      Log.e(str, paramString1, paramThrowable);
    }
    w.a("E", str, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.b) {
      Log.i(str, paramString1);
    }
    w.a("I", str, paramString1);
  }
  
  public static void setCache(int paramInt)
  {
    w.a(paramInt);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.b) {
      Log.v(str, paramString1);
    }
    w.a("V", str, paramString1);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.b) {
      Log.w(str, paramString1);
    }
    w.a("W", str, paramString1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\BuglyLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */