package com.facebook.stetho.common;

public final class StringUtil
{
  public static String removePrefix(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.startsWith(paramString2)) {
      str = paramString1.substring(paramString2.length());
    }
    return str;
  }
  
  public static String removePrefix(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != paramString3) {
      return paramString3;
    }
    return removePrefix(paramString1, paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */