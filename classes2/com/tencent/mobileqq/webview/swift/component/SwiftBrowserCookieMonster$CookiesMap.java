package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Hashtable;

public class SwiftBrowserCookieMonster$CookiesMap
  extends Hashtable
{
  public SwiftBrowserCookieMonster$CookiesMap()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void addCookie(String paramString1, String paramString2)
  {
    try
    {
      getCookies(paramString1).add(paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public ArrayList getCookies(String paramString)
  {
    try
    {
      ArrayList localArrayList2 = (ArrayList)get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        put(paramString, localArrayList1);
      }
      return localArrayList1;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserCookieMonster$CookiesMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */