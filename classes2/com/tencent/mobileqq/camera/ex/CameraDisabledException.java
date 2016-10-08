package com.tencent.mobileqq.camera.ex;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CameraDisabledException
  extends Exception
{
  public CameraDisabledException()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\ex\CameraDisabledException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */