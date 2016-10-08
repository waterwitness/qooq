package com.rookery.translate.google;

import com.rookery.translate.ServiceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GoogleInfo
  extends ServiceInfo
{
  private final byte[] a;
  
  public GoogleInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new byte[] { -89, -34, -67, 60, 35, 96, 30, -47, 119, 15, 33, -8, 27, -105, 120, -21, -107, 19, 72, 121, 115, 87, -7, 41, -2, 121, -54, -113, 33, -87, -47, 43, -103, -61, 84, -9, 115, 74, 69, 19, -31, -19, 67, 12, -110, -104, 34, -109, 48, -110, 20, -113, 71, 84, -39, -90 };
  }
  
  public String a()
  {
    return a(this.a, a());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\google\GoogleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */