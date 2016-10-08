package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;

public abstract interface AnimatedDrawableDiagnostics
{
  public abstract void drawDebugOverlay(Canvas paramCanvas, Rect paramRect);
  
  public abstract void incrementDrawnFrames(int paramInt);
  
  public abstract void incrementDroppedFrames(int paramInt);
  
  public abstract void onDrawMethodBegin();
  
  public abstract void onDrawMethodEnd();
  
  public abstract void onNextFrameMethodBegin();
  
  public abstract void onNextFrameMethodEnd();
  
  public abstract void onStartMethodBegin();
  
  public abstract void onStartMethodEnd();
  
  public abstract void setBackend(AnimatedDrawableCachingBackend paramAnimatedDrawableCachingBackend);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedDrawableDiagnostics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */