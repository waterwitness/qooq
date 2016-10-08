package com.tencent.biz.pubaccount.util;

import android.os.Environment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public final class ScreenshotContentObserver$ScreenShotPath
{
  public static final String a = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator;
  public static final String b = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator;
  public static final String c = Environment.getExternalStorageDirectory() + File.separator + "截屏" + File.separator;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\ScreenshotContentObserver$ScreenShotPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */