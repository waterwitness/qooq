package com.tencent.biz.qqstory.support;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageDownloader$HTTP
{
  public ImageDownloader$HTTP()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if (paramString != null) {
      return "http://" + paramString;
    }
    return null;
  }
  
  public static boolean a(String paramString)
  {
    return paramString.startsWith("http://");
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!a(paramString)) {
      throw new IllegalArgumentException(paramString);
    }
    return paramString.substring("http://".length());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\support\ImageDownloader$HTTP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */