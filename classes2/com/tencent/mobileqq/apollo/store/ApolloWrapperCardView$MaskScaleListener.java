package com.tencent.mobileqq.apollo.store;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class ApolloWrapperCardView$MaskScaleListener
  implements Animator.AnimatorListener
{
  WeakReference a;
  
  public ApolloWrapperCardView$MaskScaleListener(ApolloWrapperCardView.ApolloCardView paramApolloCardView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramApolloCardView);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (ApolloWrapperCardView.ApolloCardView)this.a.get();
    if (paramAnimator == null) {}
    while ((paramAnimator == null) || (ApolloWrapperCardView.ApolloCardView.a(paramAnimator) == null) || (paramAnimator.a == null)) {
      return;
    }
    paramAnimator.a.setVisibility(0);
    ApolloWrapperCardView.ApolloCardView.a(paramAnimator).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloWrapperCardView$MaskScaleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */