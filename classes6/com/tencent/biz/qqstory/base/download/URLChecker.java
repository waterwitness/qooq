package com.tencent.biz.qqstory.base.download;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.net.URL;

public class URLChecker
{
  protected static final String a = "URLChecker";
  
  public URLChecker()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static URL a(URL paramURL)
  {
    String str = paramURL.getHost();
    int k = str.indexOf(':');
    Object localObject = paramURL;
    if (k != -1)
    {
      localObject = str.substring(0, k);
      int j = paramURL.getPort();
      int i = j;
      if (j == -1) {
        i = Integer.valueOf(str.substring(k + 1)).intValue();
      }
      SLog.b("URLChecker", "url is not initilized correctly, so re-create it");
      localObject = new URL(paramURL.getProtocol(), (String)localObject, i, paramURL.getFile());
    }
    return (URL)localObject;
  }
  
  public static boolean a(URL paramURL)
  {
    return paramURL.getHost().indexOf(':') == -1;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\download\URLChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */