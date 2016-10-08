package com.tencent.av.smallscreen;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SmallScreenInterpolator
  implements Interpolator
{
  static final float a = 0.85714287F;
  
  public SmallScreenInterpolator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (0.85714287F < paramFloat) {
      return 1.0F;
    }
    return (float)(Math.cos((1.0F + 7.0F * paramFloat / 6.0F) * 3.141592653589793D) / 2.0D) + 0.5F;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */