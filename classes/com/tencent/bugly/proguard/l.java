package com.tencent.bugly.proguard;

import android.content.Context;

public final class l
{
  private static l a = null;
  
  static
  {
    System.currentTimeMillis();
  }
  
  private l(Context paramContext) {}
  
  public static l a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new l(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */