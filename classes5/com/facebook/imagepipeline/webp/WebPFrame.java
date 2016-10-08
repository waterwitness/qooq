package com.facebook.imagepipeline.webp;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WebPFrame
  implements AnimatedImageFrame
{
  @DoNotStrip
  private long mNativeContext;
  
  @DoNotStrip
  WebPFrame(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  private native void nativeDispose();
  
  private native void nativeFinalize();
  
  private native int nativeGetDurationMs();
  
  private native int nativeGetHeight();
  
  private native int nativeGetWidth();
  
  private native int nativeGetXOffset();
  
  private native int nativeGetYOffset();
  
  private native void nativeRenderFrame(int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  private native boolean nativeShouldBlendWithPreviousFrame();
  
  private native boolean nativeShouldDisposeToBackgroundColor();
  
  public void dispose()
  {
    nativeDispose();
  }
  
  protected void finalize()
  {
    nativeFinalize();
  }
  
  public int getDurationMs()
  {
    return nativeGetDurationMs();
  }
  
  public int getHeight()
  {
    return nativeGetHeight();
  }
  
  public int getWidth()
  {
    return nativeGetWidth();
  }
  
  public int getXOffset()
  {
    return nativeGetXOffset();
  }
  
  public int getYOffset()
  {
    return nativeGetYOffset();
  }
  
  public void renderFrame(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    nativeRenderFrame(paramInt1, paramInt2, paramBitmap);
  }
  
  public boolean shouldBlendWithPreviousFrame()
  {
    return nativeShouldBlendWithPreviousFrame();
  }
  
  public boolean shouldDisposeToBackgroundColor()
  {
    return nativeShouldDisposeToBackgroundColor();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\webp\WebPFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */