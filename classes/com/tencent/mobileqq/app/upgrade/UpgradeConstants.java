package com.tencent.mobileqq.app.upgrade;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UpgradeConstants
{
  public static final int a = 1;
  public static final String a = "nt";
  public static final int b = 0;
  public static final int c = 2;
  
  public UpgradeConstants()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    switch ()
    {
    default: 
      return "X";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    case 4: 
      return "4g";
    }
    return "wifi";
  }
  
  public static String b()
  {
    int i = 4;
    switch (HttpUtil.a())
    {
    }
    for (;;)
    {
      return String.valueOf(i);
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\upgrade\UpgradeConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */