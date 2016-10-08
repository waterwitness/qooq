package com.facebook.imagepipeline.webp;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WebPImage
  implements AnimatedImage
{
  private static volatile boolean sInitialized;
  @DoNotStrip
  private long mNativeContext;
  
  @DoNotStrip
  WebPImage(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  public static WebPImage create(long paramLong, int paramInt)
  {
    
    if (paramLong != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return nativeCreateFromNativeMemory(paramLong, paramInt);
    }
  }
  
  public static WebPImage create(byte[] paramArrayOfByte)
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
      if (!sInitialized) {
        sInitialized = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer paramByteBuffer)
  {
    return null;
  }
  
  private static WebPImage nativeCreateFromNativeMemory(long paramLong, int paramInt)
  {
    return null;
  }
  
  private void nativeDispose() {}
  
  private void nativeFinalize() {}
  
  private int nativeGetDuration()
  {
    return 0;
  }
  
  private WebPFrame nativeGetFrame(int paramInt)
  {
    return null;
  }
  
  private int nativeGetFrameCount()
  {
    return 0;
  }
  
  private int[] nativeGetFrameDurations()
  {
    return null;
  }
  
  private int nativeGetHeight()
  {
    return 0;
  }
  
  private int nativeGetLoopCount()
  {
    return 0;
  }
  
  private int nativeGetSizeInBytes()
  {
    return 0;
  }
  
  private int nativeGetWidth()
  {
    return 0;
  }
  
  public void dispose()
  {
    nativeDispose();
  }
  
  public boolean doesRenderSupportScaling()
  {
    return true;
  }
  
  protected void finalize()
  {
    nativeFinalize();
  }
  
  public int getDuration()
  {
    return nativeGetDuration();
  }
  
  public WebPFrame getFrame(int paramInt)
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
  
  /* Error */
  public com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo getFrameInfo(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokevirtual 88	com/facebook/imagepipeline/webp/WebPImage:getFrame	(I)Lcom/facebook/imagepipeline/webp/WebPFrame;
    //   5: astore_3
    //   6: aload_3
    //   7: invokevirtual 103	com/facebook/imagepipeline/webp/WebPFrame:getXOffset	()I
    //   10: istore 4
    //   12: aload_3
    //   13: invokevirtual 106	com/facebook/imagepipeline/webp/WebPFrame:getYOffset	()I
    //   16: istore 5
    //   18: aload_3
    //   19: invokevirtual 109	com/facebook/imagepipeline/webp/WebPFrame:getWidth	()I
    //   22: istore 6
    //   24: aload_3
    //   25: invokevirtual 112	com/facebook/imagepipeline/webp/WebPFrame:getHeight	()I
    //   28: istore 7
    //   30: aload_3
    //   31: invokevirtual 115	com/facebook/imagepipeline/webp/WebPFrame:shouldBlendWithPreviousFrame	()Z
    //   34: istore 8
    //   36: aload_3
    //   37: invokevirtual 118	com/facebook/imagepipeline/webp/WebPFrame:shouldDisposeToBackgroundColor	()Z
    //   40: ifeq +33 -> 73
    //   43: getstatic 124	com/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod:DISPOSE_TO_BACKGROUND	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod;
    //   46: astore_2
    //   47: new 126	com/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo
    //   50: dup
    //   51: iload_1
    //   52: iload 4
    //   54: iload 5
    //   56: iload 6
    //   58: iload 7
    //   60: iload 8
    //   62: aload_2
    //   63: invokespecial 129	com/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo:<init>	(IIIIIZLcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod;)V
    //   66: astore_2
    //   67: aload_3
    //   68: invokevirtual 131	com/facebook/imagepipeline/webp/WebPFrame:dispose	()V
    //   71: aload_2
    //   72: areturn
    //   73: getstatic 134	com/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod:DISPOSE_DO_NOT	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod;
    //   76: astore_2
    //   77: goto -30 -> 47
    //   80: astore_2
    //   81: aload_3
    //   82: invokevirtual 131	com/facebook/imagepipeline/webp/WebPFrame:dispose	()V
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	WebPImage
    //   0	87	1	paramInt	int
    //   46	31	2	localObject1	Object
    //   80	6	2	localObject2	Object
    //   5	77	3	localWebPFrame	WebPFrame
    //   10	43	4	i	int
    //   16	39	5	j	int
    //   22	35	6	k	int
    //   28	31	7	m	int
    //   34	27	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	47	80	finally
    //   47	67	80	finally
    //   73	77	80	finally
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\webp\WebPImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */