package com.tencent.mobileqq.webview.webso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;
import wns_proxy.HttpRsp;

public class HttpResponsePackage
{
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  private final String F;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public HttpResponsePackage(HttpRsp paramHttpRsp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.F = "\r\n";
    a(paramHttpRsp.rspinfo);
    this.E = paramHttpRsp.body;
  }
  
  private void a(String paramString)
  {
    paramString = paramString.substring(0, paramString.indexOf("\r\n\r\n") - 1).split("\r\n");
    int i2 = paramString.length;
    int i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0) {
        b(paramString[i1]);
      }
      for (;;)
      {
        i1 += 1;
        break;
        Object localObject = paramString[i1];
        int i3 = ((String)localObject).indexOf(":");
        a(((String)localObject).substring(0, i3).trim(), ((String)localObject).substring(i3 + 1, ((String)localObject).length()));
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        paramString1 = HttpRequestPackage.class.getDeclaredField(paramString1);
        if (paramString1 != null)
        {
          paramString1.set(this, paramString2);
          return;
        }
      }
      catch (NoSuchFieldException paramString1) {}catch (IllegalArgumentException paramString1) {}catch (IllegalAccessException paramString1) {}
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = paramString.split(" ");
      if ((paramString != null) && (paramString.length == 3))
      {
        this.b = paramString[0];
        this.a = paramString[1];
        this.c = paramString[2];
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\webso\HttpResponsePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */