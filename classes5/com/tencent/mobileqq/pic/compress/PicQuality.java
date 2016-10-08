package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class PicQuality
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  
  public PicQuality()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\compress\PicQuality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */