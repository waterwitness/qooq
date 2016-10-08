package com.tencent.mobileqq.vas;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class IndividuationAnimationUtils
{
  public IndividuationAnimationUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, int paramInt)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, paramFloat1 * 4.0F, 0.0F, 4.0F * paramFloat2);
    localTranslateAnimation.setDuration(paramLong);
    localTranslateAnimation.setRepeatCount(paramInt);
    localTranslateAnimation.setInterpolator(new IndividuationAnimationUtils.CirculateTraslateInterpolator());
    paramView.setAnimation(localTranslateAnimation);
    localTranslateAnimation.start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationAnimationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */