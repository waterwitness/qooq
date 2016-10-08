package com.rookery.translate;

import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class TranslateClient
{
  private static AsyncHttpClient a;
  
  public TranslateClient()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static AsyncHttpClient a()
  {
    try
    {
      if (a == null) {
        a = new AsyncHttpClient();
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return a != null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\TranslateClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */