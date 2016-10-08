package com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils;

import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FormatDetector
{
  public FormatDetector()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    return TrimNative.detect(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\trimvideo\video\utils\FormatDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */