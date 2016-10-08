package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class NetworkCenter
{
  public static NetworkCenter a;
  public static final String a = "NetworkCenter";
  
  public NetworkCenter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static NetworkCenter a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new NetworkCenter();
      }
      return a;
    }
    finally {}
  }
  
  public int a()
  {
    return NetworkUtil.a(BaseApplication.getContext());
  }
  
  public String a()
  {
    try
    {
      String str = AppNetConnInfo.getCurrentAPN();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\NetworkCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */