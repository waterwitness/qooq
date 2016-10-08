package com.facebook.imagepipeline.image;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class EncodedImage
  implements Closeable
{
  public static final int DEFAULT_SAMPLE_SIZE = 1;
  public static final int UNKNOWN_HEIGHT = -1;
  public static final int UNKNOWN_ROTATION_ANGLE = -1;
  public static final int UNKNOWN_STREAM_SIZE = -1;
  public static final int UNKNOWN_WIDTH = -1;
  private int mHeight = -1;
  private ImageFormat mImageFormat = ImageFormat.UNKNOWN;
  @Nullable
  private final Supplier<FileInputStream> mInputStreamSupplier;
  @Nullable
  private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
  private int mRotationAngle = -1;
  private int mSampleSize = 1;
  private int mStreamSize = -1;
  private int mWidth = -1;
  
  public EncodedImage(Supplier<FileInputStream> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    this.mPooledByteBufferRef = null;
    this.mInputStreamSupplier = paramSupplier;
  }
  
  public EncodedImage(Supplier<FileInputStream> paramSupplier, int paramInt)
  {
    this(paramSupplier);
    this.mStreamSize = paramInt;
  }
  
  public EncodedImage(CloseableReference<PooledByteBuffer> paramCloseableReference)
  {
    Preconditions.checkArgument(CloseableReference.isValid(paramCloseableReference));
    this.mPooledByteBufferRef = paramCloseableReference.clone();
    this.mInputStreamSupplier = null;
  }
  
  public static EncodedImage cloneOrNull(EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null) {
      return paramEncodedImage.cloneOrNull();
    }
    return null;
  }
  
  public static void closeSafely(@Nullable EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null) {
      paramEncodedImage.close();
    }
  }
  
  public static boolean isMetaDataAvailable(EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage.mRotationAngle >= 0) && (paramEncodedImage.mWidth >= 0) && (paramEncodedImage.mHeight >= 0);
  }
  
  public static boolean isValid(@Nullable EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage != null) && (paramEncodedImage.isValid());
  }
  
  /* Error */
  public EncodedImage cloneOrNull()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/facebook/imagepipeline/image/EncodedImage:mInputStreamSupplier	Lcom/facebook/common/internal/Supplier;
    //   4: ifnull +30 -> 34
    //   7: new 2	com/facebook/imagepipeline/image/EncodedImage
    //   10: dup
    //   11: aload_0
    //   12: getfield 61	com/facebook/imagepipeline/image/EncodedImage:mInputStreamSupplier	Lcom/facebook/common/internal/Supplier;
    //   15: aload_0
    //   16: getfield 51	com/facebook/imagepipeline/image/EncodedImage:mStreamSize	I
    //   19: invokespecial 102	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/internal/Supplier;I)V
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +8 -> 32
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 105	com/facebook/imagepipeline/image/EncodedImage:copyMetaDataFrom	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   32: aload_1
    //   33: areturn
    //   34: aload_0
    //   35: getfield 59	com/facebook/imagepipeline/image/EncodedImage:mPooledByteBufferRef	Lcom/facebook/common/references/CloseableReference;
    //   38: invokestatic 108	com/facebook/common/references/CloseableReference:cloneOrNull	(Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/common/references/CloseableReference;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnonnull +12 -> 55
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_2
    //   49: invokestatic 110	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   52: goto -29 -> 23
    //   55: new 2	com/facebook/imagepipeline/image/EncodedImage
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 112	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   63: astore_1
    //   64: goto -16 -> 48
    //   67: astore_1
    //   68: aload_2
    //   69: invokestatic 110	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	EncodedImage
    //   22	42	1	localEncodedImage	EncodedImage
    //   67	6	1	localObject	Object
    //   41	28	2	localCloseableReference	CloseableReference
    // Exception table:
    //   from	to	target	type
    //   55	64	67	finally
  }
  
  public void close()
  {
    CloseableReference.closeSafely(this.mPooledByteBufferRef);
  }
  
  public void copyMetaDataFrom(EncodedImage paramEncodedImage)
  {
    this.mImageFormat = paramEncodedImage.getImageFormat();
    this.mWidth = paramEncodedImage.getWidth();
    this.mHeight = paramEncodedImage.getHeight();
    this.mRotationAngle = paramEncodedImage.getRotationAngle();
    this.mSampleSize = paramEncodedImage.getSampleSize();
    this.mStreamSize = paramEncodedImage.getSize();
  }
  
  public CloseableReference<PooledByteBuffer> getByteBufferRef()
  {
    return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public ImageFormat getImageFormat()
  {
    return this.mImageFormat;
  }
  
  public InputStream getInputStream()
  {
    if (this.mInputStreamSupplier != null) {
      return (InputStream)this.mInputStreamSupplier.get();
    }
    CloseableReference localCloseableReference = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    if (localCloseableReference != null) {
      try
      {
        PooledByteBufferInputStream localPooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer)localCloseableReference.get());
        return localPooledByteBufferInputStream;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }
    return null;
  }
  
  public int getRotationAngle()
  {
    return this.mRotationAngle;
  }
  
  public int getSampleSize()
  {
    return this.mSampleSize;
  }
  
  public int getSize()
  {
    if ((this.mPooledByteBufferRef != null) && (this.mPooledByteBufferRef.get() != null)) {
      return ((PooledByteBuffer)this.mPooledByteBufferRef.get()).size();
    }
    return this.mStreamSize;
  }
  
  /* Error */
  @com.facebook.common.internal.VisibleForTesting
  public com.facebook.common.references.SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/facebook/imagepipeline/image/EncodedImage:mPooledByteBufferRef	Lcom/facebook/common/references/CloseableReference;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 59	com/facebook/imagepipeline/image/EncodedImage:mPooledByteBufferRef	Lcom/facebook/common/references/CloseableReference;
    //   13: invokevirtual 160	com/facebook/common/references/CloseableReference:getUnderlyingReferenceTestOnly	()Lcom/facebook/common/references/SharedReference;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	EncodedImage
    //   16	7	1	localSharedReference	com.facebook.common.references.SharedReference
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isCompleteAt(int paramInt)
  {
    if (this.mImageFormat != ImageFormat.JPEG) {}
    PooledByteBuffer localPooledByteBuffer;
    do
    {
      do
      {
        return true;
      } while (this.mInputStreamSupplier != null);
      Preconditions.checkNotNull(this.mPooledByteBufferRef);
      localPooledByteBuffer = (PooledByteBuffer)this.mPooledByteBufferRef.get();
    } while ((localPooledByteBuffer.read(paramInt - 2) == -1) && (localPooledByteBuffer.read(paramInt - 1) == -39));
    return false;
  }
  
  /* Error */
  public boolean isValid()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/facebook/imagepipeline/image/EncodedImage:mPooledByteBufferRef	Lcom/facebook/common/references/CloseableReference;
    //   6: invokestatic 75	com/facebook/common/references/CloseableReference:isValid	(Lcom/facebook/common/references/CloseableReference;)Z
    //   9: ifne +18 -> 27
    //   12: aload_0
    //   13: getfield 61	com/facebook/imagepipeline/image/EncodedImage:mInputStreamSupplier	Lcom/facebook/common/internal/Supplier;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +9 -> 27
    //   21: iconst_0
    //   22: istore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: iconst_1
    //   28: istore_2
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	EncodedImage
    //   16	2	1	localSupplier	Supplier
    //   32	4	1	localObject	Object
    //   22	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public void parseMetaData()
  {
    ImageFormat localImageFormat = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
    this.mImageFormat = localImageFormat;
    if (!ImageFormat.isWebpFormat(localImageFormat))
    {
      Pair localPair = BitmapUtil.decodeDimensions(getInputStream());
      if (localPair != null)
      {
        this.mWidth = ((Integer)localPair.first).intValue();
        this.mHeight = ((Integer)localPair.second).intValue();
        if (localImageFormat != ImageFormat.JPEG) {
          break label90;
        }
        if (this.mRotationAngle == -1) {
          this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(JfifUtil.getOrientation(getInputStream()));
        }
      }
    }
    return;
    label90:
    this.mRotationAngle = 0;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setImageFormat(ImageFormat paramImageFormat)
  {
    this.mImageFormat = paramImageFormat;
  }
  
  public void setRotationAngle(int paramInt)
  {
    this.mRotationAngle = paramInt;
  }
  
  public void setSampleSize(int paramInt)
  {
    this.mSampleSize = paramInt;
  }
  
  public void setStreamSize(int paramInt)
  {
    this.mStreamSize = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\image\EncodedImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */