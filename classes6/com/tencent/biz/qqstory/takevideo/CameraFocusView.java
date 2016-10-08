package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CameraFocusView
  extends ImageView
{
  protected int a;
  protected int b;
  
  public CameraFocusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    paramContext = getResources().getDrawable(2130841397);
    if (paramContext != null)
    {
      this.a = paramContext.getMinimumWidth();
      this.b = paramContext.getMinimumHeight();
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(800L);
    localAlphaAnimation.setFillAfter(true);
    setPadding((int)paramMotionEvent.getX() - this.a / 2, (int)paramMotionEvent.getY() - this.b / 2, 0, 0);
    startAnimation(localAlphaAnimation);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\CameraFocusView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */