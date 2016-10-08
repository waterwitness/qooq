package com.facebook.react.animation;

import android.view.View;

public abstract interface AnimationPropertyUpdater
{
  public abstract void onFinish(View paramView);
  
  public abstract void onUpdate(View paramView, float paramFloat);
  
  public abstract void prepare(View paramView);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\animation\AnimationPropertyUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */