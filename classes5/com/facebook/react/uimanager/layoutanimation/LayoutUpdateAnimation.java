package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import javax.annotation.Nullable;

class LayoutUpdateAnimation
  extends AbstractLayoutAnimation
{
  private static final boolean USE_TRANSLATE_ANIMATION = false;
  
  @Nullable
  Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if ((paramView.getX() != paramInt1) || (paramView.getY() != paramInt2))
    {
      i = 1;
      if ((paramView.getWidth() == paramInt3) && (paramView.getHeight() == paramInt4)) {
        break label62;
      }
    }
    label62:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        break label68;
      }
      return null;
      i = 0;
      break;
    }
    label68:
    if ((i != 0) && (j == 0)) {}
    return new PositionAndSizeAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  boolean isValid()
  {
    return this.mDurationMs > 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\layoutanimation\LayoutUpdateAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */