package com.tencent.util;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ViscousFluidInterpolator
  implements Interpolator
{
  public ViscousFluidInterpolator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return AnimateUtils.a(paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\ViscousFluidInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */