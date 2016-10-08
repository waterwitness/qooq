package com.tencent.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class URLUtil
{
  public static final String a = "http://";
  public static final String b = "https://";
  
  public URLUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Map paramMap, String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt((String)paramMap.get(paramString));
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    char c = '?';
    int i = paramString1.indexOf('?');
    int j = paramString1.indexOf('#');
    if (i == -1) {}
    for (;;)
    {
      paramString2 = c + a(paramString2) + '=' + a(paramString3);
      if (j != -1) {
        break;
      }
      return paramString1 + paramString2;
      c = '&';
    }
    return paramString1.substring(0, j) + paramString2 + paramString1.substring(j);
  }
  
  public static String a(Map paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  public static String a(Map paramMap, String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)paramMap.get(paramString1);
      paramMap = paramString1;
      if (paramString1 == null) {
        paramMap = "";
      }
      return paramMap;
    }
    catch (Exception paramMap) {}
    return paramString2;
  }
  
  public static Map a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      localObject1 = localObject2;
      if (-1 != i) {
        localObject1 = b(paramString.substring(i + 1));
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new HashMap();
    }
    return paramString;
  }
  
  public static Map b(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        paramString = paramString.split("&");
        int j = paramString.length;
        if (i < j)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString == null) || (arrayOfString.length != 2)) {
            break label69;
          }
          localHashMap.put(arrayOfString[0], URLDecoder.decode(arrayOfString[1]));
        }
      }
      catch (Exception paramString) {}
      return localHashMap;
      label69:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\URLUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */