package com.tencent.widget;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SwipListView$SmoothInterpolator
  implements Interpolator
{
  public SwipListView$SmoothInterpolator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(paramFloat - 1.0D, 5.0D) + 1.0D);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\SwipListView$SmoothInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */