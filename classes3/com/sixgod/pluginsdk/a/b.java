package com.sixgod.pluginsdk.a;

import com.sixgod.pluginsdk.log.SixGodReporter;

public final class b
{
  public static Class a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      paramClassLoader.printStackTrace();
      SixGodReporter.reportException("ReflectExp", paramClassLoader);
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */