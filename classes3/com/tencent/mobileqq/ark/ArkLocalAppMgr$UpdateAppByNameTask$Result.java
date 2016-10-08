package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArkLocalAppMgr$UpdateAppByNameTask$Result
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  
  public ArkLocalAppMgr$UpdateAppByNameTask$Result()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown";
    case 0: 
      return "Fail";
    case 1: 
      return "Update";
    }
    return "NoUpdate";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkLocalAppMgr$UpdateAppByNameTask$Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */