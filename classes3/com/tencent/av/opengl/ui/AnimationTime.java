package com.tencent.av.opengl.ui;

import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AnimationTime
{
  private static volatile long a;
  
  public AnimationTime()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a()
  {
    return a;
  }
  
  public static void a()
  {
    a = SystemClock.uptimeMillis();
  }
  
  public static long b()
  {
    a = SystemClock.uptimeMillis();
    return a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\ui\AnimationTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */