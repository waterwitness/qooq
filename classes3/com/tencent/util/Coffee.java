package com.tencent.util;

public class Coffee
{
  private static native String getDESSignKey();
  
  public static String getSignkey()
  {
    return getDESSignKey();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\util\Coffee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */