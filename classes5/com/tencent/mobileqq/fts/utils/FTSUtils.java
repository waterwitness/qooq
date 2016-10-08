package com.tencent.mobileqq.fts.utils;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FTSUtils
{
  public FTSUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\utils\FTSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */