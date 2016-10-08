package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;

public class PTVSwitchControl
{
  public static boolean a = false;
  public static final boolean b = true;
  public static final boolean c = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = false;
    if (CameraCompatibleList.e(CameraCompatibleList.B)) {
      a = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\PTVSwitchControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */