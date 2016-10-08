package com.tencent.mobileqq.intervideo.now;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import svq;

public class HorizontalLoadingView
  extends FrameLayout
{
  private ValueAnimator a;
  
  public HorizontalLoadingView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public HorizontalLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public HorizontalLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(new svq(this));
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.a != null) {
      this.a.cancel();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramView != this) || (this.a == null)) {
      return;
    }
    if (paramInt == 0)
    {
      this.a.start();
      return;
    }
    this.a.cancel();
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (this.a == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.a.start();
      return;
    }
    this.a.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\HorizontalLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */