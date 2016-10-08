package com.facebook.imagepipeline.gif;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class GifImage
  implements AnimatedImage
{
  private static volatile boolean sInitialized;
  @DoNotStrip
  private long mNativeContext;
  
  @DoNotStrip
  GifImage(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  public static GifImage create(long paramLong, int paramInt)
  {
    
    if (paramLong != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return nativeCreateFromNativeMemory(paramLong, paramInt);
    }
  }
  
  public static GifImage create(byte[] paramArrayOfByte)
  {
    ensure();
    Preconditions.checkNotNull(paramArrayOfByte);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.rewind();
    return nativeCreateFromDirectByteBuffer(localByteBuffer);
  }
  
  private static void ensure()
  {
    try
    {
      if (!sInitialized)
      {
        sInitialized = true;
        SoLoaderShim.loadLibrary("gifimage");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static AnimatedDrawableFrameInfo.DisposalMethod fromGifDisposalMethod(int paramInt)
  {
    if (paramInt == 0) {
      return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }
    if (paramInt == 1) {
      return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }
    if (paramInt == 2) {
      return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
    }
    if (paramInt == 3) {
      return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
    }
    return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
  }
  
  private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer paramByteBuffer);
  
  private static native GifImage nativeCreateFromNativeMemory(long paramLong, int paramInt);
  
  private native void nativeDispose();
  
  private native void nativeFinalize();
  
  private native int nativeGetDuration();
  
  private native GifFrame nativeGetFrame(int paramInt);
  
  private native int nativeGetFrameCount();
  
  private native int[] nativeGetFrameDurations();
  
  private native int nativeGetHeight();
  
  private native int nativeGetLoopCount();
  
  private native int nativeGetSizeInBytes();
  
  private native int nativeGetWidth();
  
  public void dispose()
  {
    nativeDispose();
  }
  
  public boolean doesRenderSupportScaling()
  {
    return false;
  }
  
  protected void finalize()
  {
    nativeFinalize();
  }
  
  public int getDuration()
  {
    return nativeGetDuration();
  }
  
  public GifFrame getFrame(int paramInt)
  {
    return nativeGetFrame(paramInt);
  }
  
  public int getFrameCount()
  {
    return nativeGetFrameCount();
  }
  
  public int[] getFrameDurations()
  {
    return nativeGetFrameDurations();
  }
  
  public AnimatedDrawableFrameInfo getFrameInfo(int paramInt)
  {
    GifFrame localGifFrame = getFrame(paramInt);
    try
    {
      AnimatedDrawableFrameInfo localAnimatedDrawableFrameInfo = new AnimatedDrawableFrameInfo(paramInt, localGifFrame.getXOffset(), localGifFrame.getYOffset(), localGifFrame.getWidth(), localGifFrame.getHeight(), true, fromGifDisposalMethod(localGifFrame.getDisposalMode()));
      return localAnimatedDrawableFrameInfo;
    }
    finally
    {
      localGifFrame.dispose();
    }
  }
  
  public int getHeight()
  {
    return nativeGetHeight();
  }
  
  public int getLoopCount()
  {
    return nativeGetLoopCount();
  }
  
  public int getSizeInBytes()
  {
    return nativeGetSizeInBytes();
  }
  
  public int getWidth()
  {
    return nativeGetWidth();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\gif\GifImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */