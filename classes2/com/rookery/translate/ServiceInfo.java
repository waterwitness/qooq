package com.rookery.translate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.Cryptor;

public class ServiceInfo
{
  private final String a;
  
  public ServiceInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "ZaDA32%dkn_vs4dAjg";
  }
  
  protected String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new String(new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2));
  }
  
  protected byte[] a()
  {
    return "ZaDA32%dkn_vs4dAjg".getBytes();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\ServiceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */