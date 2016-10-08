package com.tencent.qqlive.mediaplayer.dex;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.sdkupdate.UpdateUtils;
import com.tencent.qqlive.mediaplayer.sdkupdate.UpdateUtils.LogType;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;

public class Dexloader
{
  private static Dexloader a = null;
  private static Context b;
  
  public static Dexloader a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new Dexloader();
        b = paramContext;
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public ClassLoader a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      UpdateUtils.a(UpdateUtils.LogType.e, "", "Dexloader", "filePath error, jarPath: " + paramString1 + ", soPath: " + paramString2);
      return null;
    }
    UpdateUtils.a(UpdateUtils.LogType.c, "", "Dexloader", "jarPath: " + paramString1 + ", soPath: " + paramString2);
    String str1 = b.getApplicationContext().getDir("assets", 0).getAbsolutePath();
    if (new File(paramString1).exists()) {
      try
      {
        paramString2 = new DexClassLoader(paramString1, str1, paramString2, b.getApplicationContext().getClassLoader());
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          try
          {
            Constructor localConstructor = Class.forName("dalvik.system.LexClassLoader").getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class });
            String str2 = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
            paramString1 = (ClassLoader)localConstructor.newInstance(new Object[] { str1 + File.separator + str2, str1, paramString1, b.getApplicationContext().getClassLoader() });
            return paramString1;
          }
          catch (Exception paramString1)
          {
            return paramString2;
          }
          paramString2 = paramString2;
          UpdateUtils.a(UpdateUtils.LogType.e, "", "Dexloader", "DexClassLoader failed! ");
          paramString2 = null;
        }
      }
    }
    UpdateUtils.a(UpdateUtils.LogType.c, "", "Dexloader", "files do not exist, creat dexclassloader failed");
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\qqlive\mediaplayer\dex\Dexloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */