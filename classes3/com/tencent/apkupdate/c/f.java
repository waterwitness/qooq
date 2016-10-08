package com.tencent.apkupdate.c;

import android.util.Log;
import java.util.HashMap;

public final class f
{
  private static boolean a = true;
  
  static
  {
    new HashMap();
    new HashMap();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      Log.i(paramString1, str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\apkupdate\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */