package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class LayoutAnimationController
{
  private static final boolean ENABLED = true;
  private final AbstractLayoutAnimation mLayoutCreateAnimation = new LayoutCreateAnimation();
  private final AbstractLayoutAnimation mLayoutUpdateAnimation = new LayoutUpdateAnimation();
  private boolean mShouldAnimateLayout;
  
  public void applyLayoutUpdate(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0)) {}
    for (Object localObject = this.mLayoutCreateAnimation;; localObject = this.mLayoutUpdateAnimation)
    {
      localObject = ((AbstractLayoutAnimation)localObject).createAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((localObject == null) || (!(localObject instanceof HandleLayout))) {
        paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      }
      if (localObject != null) {
        paramView.startAnimation((Animation)localObject);
      }
      return;
    }
  }
  
  public void initializeFromConfig(@Nullable ReadableMap paramReadableMap)
  {
    int i = 0;
    if (paramReadableMap == null) {
      reset();
    }
    do
    {
      return;
      this.mShouldAnimateLayout = false;
      if (paramReadableMap.hasKey("duration")) {
        i = paramReadableMap.getInt("duration");
      }
      if (paramReadableMap.hasKey(LayoutAnimationType.CREATE.toString()))
      {
        this.mLayoutCreateAnimation.initializeFromConfig(paramReadableMap.getMap(LayoutAnimationType.CREATE.toString()), i);
        this.mShouldAnimateLayout = true;
      }
    } while (!paramReadableMap.hasKey(LayoutAnimationType.UPDATE.toString()));
    this.mLayoutUpdateAnimation.initializeFromConfig(paramReadableMap.getMap(LayoutAnimationType.UPDATE.toString()), i);
    this.mShouldAnimateLayout = true;
  }
  
  public void reset()
  {
    this.mLayoutCreateAnimation.reset();
    this.mLayoutUpdateAnimation.reset();
    this.mShouldAnimateLayout = false;
  }
  
  public boolean shouldAnimateLayout(View paramView)
  {
    return (this.mShouldAnimateLayout) && (paramView.getParent() != null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\layoutanimation\LayoutAnimationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */