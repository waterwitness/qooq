package com.dataline.util;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DatalinePlatformUtil
{
  public DatalinePlatformUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\DatalinePlatformUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */