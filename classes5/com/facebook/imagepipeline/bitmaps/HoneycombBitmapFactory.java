package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
public class HoneycombBitmapFactory
  extends PlatformBitmapFactory
{
  private final EmptyJpegGenerator mJpegGenerator;
  private final PlatformDecoder mPurgeableDecoder;
  
  public HoneycombBitmapFactory(EmptyJpegGenerator paramEmptyJpegGenerator, PlatformDecoder paramPlatformDecoder)
  {
    this.mJpegGenerator = paramEmptyJpegGenerator;
    this.mPurgeableDecoder = paramPlatformDecoder;
  }
  
  /* Error */
  public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int paramInt1, int paramInt2, android.graphics.Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mJpegGenerator	Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;
    //   4: iload_1
    //   5: i2s
    //   6: iload_2
    //   7: i2s
    //   8: invokevirtual 30	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:generate	(SS)Lcom/facebook/common/references/CloseableReference;
    //   11: astore 4
    //   13: new 32	com/facebook/imagepipeline/image/EncodedImage
    //   16: dup
    //   17: aload 4
    //   19: invokespecial 35	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   22: astore 5
    //   24: aload 5
    //   26: getstatic 41	com/facebook/imageformat/ImageFormat:JPEG	Lcom/facebook/imageformat/ImageFormat;
    //   29: invokevirtual 45	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
    //   32: aload_0
    //   33: getfield 21	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mPurgeableDecoder	Lcom/facebook/imagepipeline/platform/PlatformDecoder;
    //   36: aload 5
    //   38: aload_3
    //   39: aload 4
    //   41: invokevirtual 51	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   44: checkcast 53	com/facebook/imagepipeline/memory/PooledByteBuffer
    //   47: invokeinterface 57 1 0
    //   52: invokeinterface 63 4 0
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 51	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   62: checkcast 65	android/graphics/Bitmap
    //   65: iconst_0
    //   66: invokevirtual 69	android/graphics/Bitmap:eraseColor	(I)V
    //   69: aload 5
    //   71: invokestatic 73	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   74: aload 4
    //   76: invokevirtual 76	com/facebook/common/references/CloseableReference:close	()V
    //   79: aload_3
    //   80: areturn
    //   81: astore_3
    //   82: aload 5
    //   84: invokestatic 73	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   87: aload_3
    //   88: athrow
    //   89: astore_3
    //   90: aload 4
    //   92: invokevirtual 76	com/facebook/common/references/CloseableReference:close	()V
    //   95: aload_3
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	HoneycombBitmapFactory
    //   0	97	1	paramInt1	int
    //   0	97	2	paramInt2	int
    //   0	97	3	paramConfig	android.graphics.Bitmap.Config
    //   11	80	4	localCloseableReference	com.facebook.common.references.CloseableReference
    //   22	61	5	localEncodedImage	com.facebook.imagepipeline.image.EncodedImage
    // Exception table:
    //   from	to	target	type
    //   32	69	81	finally
    //   13	32	89	finally
    //   69	74	89	finally
    //   82	89	89	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\bitmaps\HoneycombBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */