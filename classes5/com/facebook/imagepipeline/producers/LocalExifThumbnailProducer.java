package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalExifThumbnailProducer
  implements Producer<EncodedImage>
{
  @VisibleForTesting
  static final String CREATED_THUMBNAIL = "createdThumbnail";
  @VisibleForTesting
  static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
  private final ContentResolver mContentResolver;
  private final Executor mExecutor;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  public LocalExifThumbnailProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    this.mExecutor = paramExecutor;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mContentResolver = paramContentResolver;
  }
  
  private EncodedImage buildEncodedImage(PooledByteBuffer paramPooledByteBuffer, ExifInterface paramExifInterface)
  {
    int j = -1;
    Pair localPair = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(paramPooledByteBuffer));
    int k = getRotationAngle(paramExifInterface);
    if (localPair != null) {}
    for (int i = ((Integer)localPair.first).intValue();; i = -1)
    {
      if (localPair != null) {
        j = ((Integer)localPair.second).intValue();
      }
      paramPooledByteBuffer = new EncodedImage(CloseableReference.of(paramPooledByteBuffer));
      paramPooledByteBuffer.setImageFormat(ImageFormat.JPEG);
      paramPooledByteBuffer.setRotationAngle(k);
      paramPooledByteBuffer.setWidth(i);
      paramPooledByteBuffer.setHeight(j);
      return paramPooledByteBuffer;
    }
  }
  
  private String getRealPathFromUri(Uri paramUri)
  {
    String str = null;
    if (UriUtil.isLocalContentUri(paramUri))
    {
      paramUri = this.mContentResolver.query(paramUri, null, null, null, null);
      if (paramUri != null)
      {
        paramUri.moveToFirst();
        str = paramUri.getString(paramUri.getColumnIndex("_data"));
        paramUri.close();
      }
    }
    while (!UriUtil.isLocalFileUri(paramUri)) {
      return str;
    }
    return paramUri.getPath();
  }
  
  private int getRotationAngle(ExifInterface paramExifInterface)
  {
    return JfifUtil.getAutoRotateAngleFromOrientation(Integer.parseInt(paramExifInterface.getAttribute("Orientation")));
  }
  
  @VisibleForTesting
  boolean canReadAsFile(String paramString)
    throws IOException
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.canRead()));
    return true;
  }
  
  @VisibleForTesting
  ExifInterface getExifInterface(Uri paramUri)
    throws IOException
  {
    paramUri = getRealPathFromUri(paramUri);
    if (canReadAsFile(paramUri)) {
      return new ExifInterface(paramUri);
    }
    return null;
  }
  
  public void produceResults(final Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer = new StatefulProducerRunnable(paramConsumer, paramProducerContext.getListener(), "LocalExifThumbnailProducer", paramProducerContext.getId())
    {
      protected void disposeResult(EncodedImage paramAnonymousEncodedImage)
      {
        EncodedImage.closeSafely(paramAnonymousEncodedImage);
      }
      
      protected Map<String, String> getExtraMapOnSuccess(EncodedImage paramAnonymousEncodedImage)
      {
        if (paramAnonymousEncodedImage != null) {}
        for (boolean bool = true;; bool = false) {
          return ImmutableMap.of("createdThumbnail", Boolean.toString(bool));
        }
      }
      
      protected EncodedImage getResult()
        throws Exception
      {
        Object localObject1 = this.val$imageRequest.getSourceUri();
        localObject1 = LocalExifThumbnailProducer.this.getExifInterface((Uri)localObject1);
        if ((localObject1 == null) || (!((ExifInterface)localObject1).hasThumbnail())) {
          return null;
        }
        Object localObject2 = ((ExifInterface)localObject1).getThumbnail();
        localObject2 = LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer((byte[])localObject2);
        return LocalExifThumbnailProducer.this.buildEncodedImage((PooledByteBuffer)localObject2, (ExifInterface)localObject1);
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramConsumer.cancel();
      }
    });
    this.mExecutor.execute(paramConsumer);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalExifThumbnailProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */