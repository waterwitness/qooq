package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.Nullable;

public abstract interface DraweeController
{
  public abstract Animatable getAnimatable();
  
  @Nullable
  public abstract DraweeHierarchy getHierarchy();
  
  public abstract void onAttach();
  
  public abstract void onDetach();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\interfaces\DraweeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */