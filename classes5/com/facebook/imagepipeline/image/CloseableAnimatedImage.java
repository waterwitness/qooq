package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImageResult;

public class CloseableAnimatedImage
  extends CloseableImage
{
  private AnimatedImageResult mImageResult;
  
  public CloseableAnimatedImage(AnimatedImageResult paramAnimatedImageResult)
  {
    this.mImageResult = paramAnimatedImageResult;
  }
  
  public void close()
  {
    try
    {
      if (this.mImageResult == null) {
        return;
      }
      AnimatedImageResult localAnimatedImageResult = this.mImageResult;
      this.mImageResult = null;
      localAnimatedImageResult.dispose();
      return;
    }
    finally {}
  }
  
  /* Error */
  public int getHeight()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 26	com/facebook/imagepipeline/image/CloseableAnimatedImage:isClosed	()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   21: invokevirtual 30	com/facebook/imagepipeline/animated/base/AnimatedImageResult:getImage	()Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   24: invokeinterface 34 1 0
    //   29: istore_2
    //   30: goto -17 -> 13
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	CloseableAnimatedImage
    //   33	4	1	localObject	Object
    //   12	18	2	i	int
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   17	30	33	finally
  }
  
  /* Error */
  public com.facebook.imagepipeline.animated.base.AnimatedImage getImage()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 26	com/facebook/imagepipeline/image/CloseableAnimatedImage:isClosed	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   21: invokevirtual 30	com/facebook/imagepipeline/animated/base/AnimatedImageResult:getImage	()Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	CloseableAnimatedImage
    //   12	13	1	localAnimatedImage	com.facebook.imagepipeline.animated.base.AnimatedImage
    //   28	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  public AnimatedImageResult getImageResult()
  {
    try
    {
      AnimatedImageResult localAnimatedImageResult = this.mImageResult;
      return localAnimatedImageResult;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int getSizeInBytes()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 26	com/facebook/imagepipeline/image/CloseableAnimatedImage:isClosed	()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   21: invokevirtual 30	com/facebook/imagepipeline/animated/base/AnimatedImageResult:getImage	()Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   24: invokeinterface 39 1 0
    //   29: istore_2
    //   30: goto -17 -> 13
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	CloseableAnimatedImage
    //   33	4	1	localObject	Object
    //   12	18	2	i	int
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   17	30	33	finally
  }
  
  /* Error */
  public int getWidth()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 26	com/facebook/imagepipeline/image/CloseableAnimatedImage:isClosed	()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   21: invokevirtual 30	com/facebook/imagepipeline/animated/base/AnimatedImageResult:getImage	()Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   24: invokeinterface 42 1 0
    //   29: istore_2
    //   30: goto -17 -> 13
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	CloseableAnimatedImage
    //   33	4	1	localObject	Object
    //   12	18	2	i	int
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   17	30	33	finally
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	CloseableAnimatedImage
    //   6	2	1	localAnimatedImageResult	AnimatedImageResult
    //   22	4	1	localObject	Object
    //   12	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean isStateful()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\image\CloseableAnimatedImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */