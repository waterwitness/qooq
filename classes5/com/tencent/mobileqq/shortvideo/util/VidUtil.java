package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class VidUtil
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    synchronized (a)
    {
      int i = new Random().nextInt(10000);
      String str = a.format(new Date()) + "_" + i;
      return str;
    }
  }
  
  public static String a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    return paramFile.getName();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\VidUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */