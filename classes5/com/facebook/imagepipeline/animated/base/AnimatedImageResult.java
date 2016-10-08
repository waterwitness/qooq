package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import javax.annotation.Nullable;

public class AnimatedImageResult
{
  @Nullable
  private List<CloseableReference<Bitmap>> mDecodedFrames;
  private final int mFrameForPreview;
  private final AnimatedImage mImage;
  @Nullable
  private CloseableReference<Bitmap> mPreviewBitmap;
  
  private AnimatedImageResult(AnimatedImage paramAnimatedImage)
  {
    this.mImage = ((AnimatedImage)Preconditions.checkNotNull(paramAnimatedImage));
    this.mFrameForPreview = 0;
  }
  
  AnimatedImageResult(AnimatedImageResultBuilder paramAnimatedImageResultBuilder)
  {
    this.mImage = ((AnimatedImage)Preconditions.checkNotNull(paramAnimatedImageResultBuilder.getImage()));
    this.mFrameForPreview = paramAnimatedImageResultBuilder.getFrameForPreview();
    this.mPreviewBitmap = paramAnimatedImageResultBuilder.getPreviewBitmap();
    this.mDecodedFrames = paramAnimatedImageResultBuilder.getDecodedFrames();
  }
  
  public static AnimatedImageResult forAnimatedImage(AnimatedImage paramAnimatedImage)
  {
    return new AnimatedImageResult(paramAnimatedImage);
  }
  
  public static AnimatedImageResultBuilder newBuilder(AnimatedImage paramAnimatedImage)
  {
    return new AnimatedImageResultBuilder(paramAnimatedImage);
  }
  
  public void dispose()
  {
    try
    {
      CloseableReference.closeSafely(this.mPreviewBitmap);
      this.mPreviewBitmap = null;
      CloseableReference.closeSafely(this.mDecodedFrames);
      this.mDecodedFrames = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  @Nullable
  public CloseableReference<Bitmap> getDecodedFrame(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/facebook/imagepipeline/animated/base/AnimatedImageResult:mDecodedFrames	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 56	com/facebook/imagepipeline/animated/base/AnimatedImageResult:mDecodedFrames	Ljava/util/List;
    //   13: iload_1
    //   14: invokeinterface 81 2 0
    //   19: checkcast 66	com/facebook/common/references/CloseableReference
    //   22: invokestatic 85	com/facebook/common/references/CloseableReference:cloneOrNull	(Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/common/references/CloseableReference;
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AnimatedImageResult
    //   0	40	1	paramInt	int
    //   25	7	2	localCloseableReference	CloseableReference
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  public int getFrameForPreview()
  {
    return this.mFrameForPreview;
  }
  
  public AnimatedImage getImage()
  {
    return this.mImage;
  }
  
  public CloseableReference<Bitmap> getPreviewBitmap()
  {
    try
    {
      CloseableReference localCloseableReference = CloseableReference.cloneOrNull(this.mPreviewBitmap);
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean hasDecodedFrame(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/facebook/imagepipeline/animated/base/AnimatedImageResult:mDecodedFrames	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 56	com/facebook/imagepipeline/animated/base/AnimatedImageResult:mDecodedFrames	Ljava/util/List;
    //   13: iload_1
    //   14: invokeinterface 81 2 0
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +9 -> 30
    //   24: iconst_1
    //   25: istore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_3
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AnimatedImageResult
    //   0	40	1	paramInt	int
    //   19	2	2	localObject1	Object
    //   35	4	2	localObject2	Object
    //   25	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	35	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedImageResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */