package com.tencent.theme;

import android.content.Context;
import java.lang.reflect.Method;

public class m
{
  public static String a(Context paramContext, String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\theme\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */