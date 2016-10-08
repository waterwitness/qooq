package com.tencent.util;

import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CameraUtil
{
  private static final String a = "CameraUtil";
  
  public CameraUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Camera a()
  {
    return a(-1);
  }
  
  public static Camera a(int paramInt)
  {
    int i = 5;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      i = 1;
    }
    int j = 0;
    while (j < i) {
      try
      {
        if ((Build.VERSION.SDK_INT >= 9) && (paramInt != -1)) {
          return Camera.open(paramInt);
        }
        Camera localCamera = Camera.open();
        return localCamera;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraUtil", 2, "openCameraWithRetry. Fail to open camera. " + localException.getMessage());
        }
        j += 1;
        if (j < i) {
          try
          {
            Thread.currentThread();
            Thread.sleep('Ǵ');
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        } else {
          throw new RuntimeException(localInterruptedException);
        }
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\CameraUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */