package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;

public class AnimatedDrawableDiagnosticsNoop
  implements AnimatedDrawableDiagnostics
{
  private static AnimatedDrawableDiagnosticsNoop sInstance = new AnimatedDrawableDiagnosticsNoop();
  
  public static AnimatedDrawableDiagnosticsNoop getInstance()
  {
    return sInstance;
  }
  
  public void drawDebugOverlay(Canvas paramCanvas, Rect paramRect) {}
  
  public void incrementDrawnFrames(int paramInt) {}
  
  public void incrementDroppedFrames(int paramInt) {}
  
  public void onDrawMethodBegin() {}
  
  public void onDrawMethodEnd() {}
  
  public void onNextFrameMethodBegin() {}
  
  public void onNextFrameMethodEnd() {}
  
  public void onStartMethodBegin() {}
  
  public void onStartMethodEnd() {}
  
  public void setBackend(AnimatedDrawableCachingBackend paramAnimatedDrawableCachingBackend) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\impl\AnimatedDrawableDiagnosticsNoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */