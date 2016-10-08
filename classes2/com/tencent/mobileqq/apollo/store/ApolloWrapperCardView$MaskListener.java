package com.tencent.mobileqq.apollo.store;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class ApolloWrapperCardView$MaskListener
  implements Animator.AnimatorListener
{
  WeakReference a;
  
  public ApolloWrapperCardView$MaskListener(ApolloWrapperCardView.ApolloCardView paramApolloCardView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramApolloCardView);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (ApolloWrapperCardView.ApolloCardView)this.a.get();
    if (paramAnimator == null) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(ApolloWrapperCardView.ApolloCardView.a(paramAnimator), "scaleX", new float[] { 0.4F, 0.42F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(ApolloWrapperCardView.ApolloCardView.a(paramAnimator), "scaleY", new float[] { 0.4F, 0.42F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(ApolloWrapperCardView.ApolloCardView.a(paramAnimator), "scaleX", new float[] { 0.42F, 0.4F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(ApolloWrapperCardView.ApolloCardView.a(paramAnimator), "scaleY", new float[] { 0.42F, 0.4F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator3).after(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator4).after(localObjectAnimator2);
    localAnimatorSet.addListener(new ApolloWrapperCardView.MaskScaleListener(paramAnimator));
    localAnimatorSet.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloWrapperCardView$MaskListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */