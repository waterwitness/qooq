package com.tencent.tmassistantbase.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public class l
{
  protected static String b = "NA";
  protected Context a = null;
  
  public l(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private StringBuffer a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      return localStringBuffer;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if ((paramString[i] > ' ') && (paramString[i] != '/') && (paramString[i] != '_') && (paramString[i] != '&') && (paramString[i] != '|') && (paramString[i] != '-')) {
        localStringBuffer.append(paramString[i]);
      }
      i += 1;
    }
    return localStringBuffer;
  }
  
  public static String b()
  {
    if ("100".contains("BuildNo")) {
      return "0000";
    }
    return "100";
  }
  
  private int c()
  {
    return this.a.getResources().getDisplayMetrics().widthPixels;
  }
  
  private int d()
  {
    return this.a.getResources().getDisplayMetrics().heightPixels;
  }
  
  private int e()
  {
    return 0;
  }
  
  private String f()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(Build.BRAND));
    localStringBuffer.append("_");
    localStringBuffer.append(a(Build.MODEL));
    return localStringBuffer.toString();
  }
  
  private String g()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Build.VERSION.RELEASE;
    if (TextUtils.isEmpty(str)) {
      localStringBuffer.append("NA");
    }
    for (;;)
    {
      localStringBuffer.append("_");
      localStringBuffer.append(Build.VERSION.SDK_INT);
      return localStringBuffer.toString();
      localStringBuffer.append(str);
    }
  }
  
  public String a()
  {
    k localk = new k();
    localk.c = b();
    localk.d = "";
    localk.e = b;
    localk.f = g();
    localk.h = d();
    localk.g = c();
    localk.i = e();
    localk.a = f();
    localk.b = "100";
    return localk.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */