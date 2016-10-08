package com.tencent.mobileqq.mqsafeedit;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CodecWarpper
{
  public static final String NATIVE_LIB_NAME = "codecwrapperV2";
  private static AtomicBoolean isSoLoaded = new AtomicBoolean(false);
  
  static
  {
    loadSo();
  }
  
  public static void loadSo()
  {
    if (!isSoLoaded.get()) {
      try
      {
        if (CoreUtil.loadLibrary("codecwrapperV2", BaseApplication.getContext()))
        {
          isSoLoaded.set(true);
          return;
        }
        String str = BaseApplication.getContext().getPackageName().replace(".", "_");
        isSoLoaded.set(CoreUtil.loadLibrary(str + "_" + "codecwrapperV2", BaseApplication.getContext()));
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\mqsafeedit\CodecWarpper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */