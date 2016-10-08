package com.tencent.biz.qqstory.takevideo.doodle.ui.animation;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ixo;
import ixp;

public class AnimatorFactory
{
  public AnimatorFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, AnimatorFactory.AnimatorListener paramAnimatorListener)
  {
    float f = (paramFloat2 - paramFloat1) / 5.0F;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2, paramFloat2 - 3.0F * f, paramFloat2, paramFloat2 - f, paramFloat2 });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new ixo(paramAnimatorListener));
    localValueAnimator.addListener(new ixp(paramAnimatorListener, localValueAnimator));
    localValueAnimator.setDuration(paramLong);
    return localValueAnimator;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\animation\AnimatorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */