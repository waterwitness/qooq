package com.tencent.mobileqq.shortvideo.util;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MotionEventUtil
{
  public MotionEventUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2)
    {
      float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return 0.0F;
  }
  
  public static int a(MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT >= 5) {
      return paramMotionEvent.getAction() & 0xFF;
    }
    return paramMotionEvent.getAction();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\MotionEventUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */