package com.tencent.ttpic.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Coffee
{
  public Coffee()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static String a()
  {
    return getDefaultSign();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    String str = a();
    return nDrink(paramArrayOfByte, paramArrayOfByte.length, str);
  }
  
  public static native String getDefaultSign();
  
  public static native boolean isSign(String paramString);
  
  private static native byte[] nDrink(byte[] paramArrayOfByte, int paramInt, String paramString);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ttpic\util\Coffee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */