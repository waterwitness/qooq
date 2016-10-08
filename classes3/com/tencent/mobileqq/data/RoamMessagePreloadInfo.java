package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Calendar;

public class RoamMessagePreloadInfo
{
  public static final int TYPE_PRELOAD_CURDAY = 0;
  public static final int TYPE_PRELOAD_NEXTDAY = 2;
  public static final int TYPE_PRELOAD_PREVIOUSDAY = 1;
  public Calendar curday;
  public Calendar nextday;
  public int preloadType;
  public Calendar previousday;
  
  public RoamMessagePreloadInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RoamMessagePreloadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */