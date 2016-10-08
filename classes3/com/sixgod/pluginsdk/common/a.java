package com.sixgod.pluginsdk.common;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public final class a
{
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getDir("SixGodPlugin", 0).getAbsolutePath() + File.separator + paramString + File.separator;
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = "optDex";
    if (!TextUtils.isEmpty(paramString2)) {
      str = "optDex" + "_" + paramString2;
    }
    paramContext = a(paramContext, paramString1) + str + File.separator;
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString) + "data" + File.separator;
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    String str = "lib";
    if (!TextUtils.isEmpty(paramString2)) {
      str = "lib" + "_" + paramString2;
    }
    paramContext = a(paramContext, paramString1) + str + File.separator;
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */