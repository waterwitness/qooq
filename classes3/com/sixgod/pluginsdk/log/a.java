package com.sixgod.pluginsdk.log;

import android.util.Log;

public final class a
{
  public static ISixGodLog a = null;
  
  public static final void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (a != null)
    {
      a.d("SixGod_PluginSdk", paramString);
      return;
    }
    Log.d("SixGod_PluginSdk", paramString);
  }
  
  public static final void a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    if (a != null)
    {
      a.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static final void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (a != null)
    {
      a.e("SixGod_PluginSdk", paramString);
      return;
    }
    Log.e("SixGod_PluginSdk", paramString);
  }
  
  public static final void b(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    if (a != null)
    {
      a.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static final void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (a != null)
    {
      a.w("SixGod_PluginSdk", paramString);
      return;
    }
    Log.w("SixGod_PluginSdk", paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\log\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */