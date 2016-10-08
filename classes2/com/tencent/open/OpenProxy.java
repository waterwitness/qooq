package com.tencent.open;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.data.SharedPrefs;

public class OpenProxy
{
  private static OpenProxy a;
  
  private OpenProxy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static OpenProxy a()
  {
    try
    {
      if (a == null) {
        a = new OpenProxy();
      }
      OpenProxy localOpenProxy = a;
      return localOpenProxy;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    SharedPrefs.a(paramString);
  }
  
  public void b(String paramString)
  {
    SharedPrefs.b(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\OpenProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */