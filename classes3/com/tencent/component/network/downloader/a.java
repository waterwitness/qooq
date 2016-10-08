package com.tencent.component.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;

public abstract class a
{
  public static final a a = new b((byte)0);
  
  static
  {
    new a((byte)0);
  }
  
  public final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!NetworkUtils.isNetworkUrl(paramString)) {
      return paramString;
    }
    return b(paramString);
  }
  
  public abstract String b(String paramString);
  
  static class a
    extends a
  {
    public String b(String paramString)
    {
      String str = null;
      int i;
      if (a.a(paramString, "http://")) {
        i = paramString.indexOf("/", 7);
      }
      for (;;)
      {
        if (i != -1) {
          str = paramString.substring(i);
        }
        return str;
        if (a.a(paramString, "https://")) {
          i = paramString.indexOf("/", 8);
        } else {
          i = paramString.indexOf("/");
        }
      }
    }
  }
  
  static final class b
    extends a.a
  {
    private b()
    {
      super();
    }
    
    public final String b(String paramString)
    {
      paramString = super.b(paramString);
      if (TextUtils.isEmpty(paramString)) {}
      int i;
      do
      {
        return paramString;
        i = paramString.indexOf('#');
      } while (i <= 0);
      return paramString.substring(0, i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */