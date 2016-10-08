package com.facebook.imagepipeline.gif;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class GifFrame
  implements AnimatedImageFrame
{
  @DoNotStrip
  private long mNativeContext;
  
  @DoNotStrip
  GifFrame(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  private native void nativeDispose();
  
  private native void nativeFinalize();
  
  private native int nativeGetDisposalMode();
  
  private native int nativeGetDurationMs();
  
  private native int nativeGetHeight();
  
  private native int nativeGetWidth();
  
  private native int nativeGetXOffset();
  
  private native int nativeGetYOffset();
  
  private native boolean nativeHasTransparency();
  
  private native void nativeRenderFrame(int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  public void dispose()
  {
    nativeDispose();
  }
  
  protected void finalize()
  {
    nativeFinalize();
  }
  
  public int getDisposalMode()
  {
    return nativeGetDisposalMode();
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
  
  public boolean hasTransparency()
  {
    return nativeHasTransparency();
  }
  
  public void renderFrame(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    nativeRenderFrame(paramInt1, paramInt2, paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\gif\GifFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */