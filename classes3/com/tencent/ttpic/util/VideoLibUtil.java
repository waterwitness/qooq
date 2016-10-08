package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;

public class VideoLibUtil
{
  public static int getFaceDetectLibVersion()
  {
    return nativeGetFaceDetectLibVersion();
  }
  
  public static int getFilterLibVersion()
  {
    return BaseFilter.getVersionCode();
  }
  
  private static native int nativeGetFaceDetectLibVersion();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoLibUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */