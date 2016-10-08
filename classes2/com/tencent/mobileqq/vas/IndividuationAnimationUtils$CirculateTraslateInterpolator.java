package com.tencent.mobileqq.vas;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class IndividuationAnimationUtils$CirculateTraslateInterpolator
  implements Interpolator
{
  public IndividuationAnimationUtils$CirculateTraslateInterpolator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.25D) {}
    do
    {
      return paramFloat;
      if ((paramFloat >= 0.25D) && (paramFloat < 0.5D)) {
        return (float)(0.5D - paramFloat);
      }
      if ((paramFloat >= 0.5D) && (paramFloat < 0.75D)) {
        return (float)(0.5D - paramFloat);
      }
    } while (paramFloat < 0.75D);
    return paramFloat - 1.0F;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationAnimationUtils$CirculateTraslateInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */