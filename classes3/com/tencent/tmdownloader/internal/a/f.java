package com.tencent.tmdownloader.internal.a;

import android.text.TextUtils;
import java.util.HashMap;

public class f
{
  protected static f a = null;
  protected boolean b = true;
  protected boolean c = false;
  protected int d = 5;
  
  public f()
  {
    e();
  }
  
  static int a(String paramString)
  {
    if (paramString.equalsIgnoreCase("WIFI")) {
      throw new UnsupportedOperationException("Split is not allowed in current version. netType: " + paramString);
    }
    if (paramString.contains("net")) {}
    while (!paramString.contains("wap")) {
      return 921600;
    }
    return 409600;
  }
  
  public static f a()
  {
    try
    {
      if (a == null) {
        a = new f();
      }
      f localf = a;
      return localf;
    }
    finally {}
  }
  
  private void e()
  {
    boolean bool2 = false;
    Object localObject = com.tencent.tmdownloader.internal.d.c.c.c();
    String str = (String)((HashMap)localObject).get("isTaskAutoResume");
    if ((str != null) && (str.length() > 0))
    {
      if (str.equals("false"))
      {
        bool1 = false;
        this.b = bool1;
      }
    }
    else
    {
      str = (String)((HashMap)localObject).get("isDownloadWifiOnly");
      if ((str != null) && (str.length() > 0)) {
        if (!str.equals("false")) {
          break label120;
        }
      }
    }
    label120:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      this.c = bool1;
      localObject = (String)((HashMap)localObject).get("maxTaskNum");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.d = Integer.valueOf((String)localObject).intValue();
      }
      return;
      bool1 = true;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    if (a.d == paramInt) {
      return;
    }
    a.d = paramInt;
    com.tencent.tmdownloader.internal.d.c.c.a("maxTaskNum", String.valueOf(paramInt), "Integer");
  }
  
  public void a(boolean paramBoolean)
  {
    if (a.b == paramBoolean) {
      return;
    }
    a.b = paramBoolean;
    com.tencent.tmdownloader.internal.d.c.c.a("isTaskAutoResume", String.valueOf(paramBoolean), "boolean");
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return false;
      if (paramString2.equalsIgnoreCase("WIFI")) {
        return true;
      }
    } while ((!paramString2.contains("net")) || (paramString1.equalsIgnoreCase("WIFI")));
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (a.c == paramBoolean) {
      return;
    }
    a.c = paramBoolean;
    com.tencent.tmdownloader.internal.d.c.c.a("isDownloadWifiOnly", String.valueOf(paramBoolean), "boolean");
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    if (this.b)
    {
      String str = c.b();
      if ((str.contains("wifi")) || (str.contains("net"))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */