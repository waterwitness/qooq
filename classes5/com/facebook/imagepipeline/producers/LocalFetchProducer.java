package com.facebook.imagepipeline.producers;

import android.os.Build.VERSION;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public abstract class LocalFetchProducer
  implements Producer<EncodedImage>
{
  private final boolean mDecodeFileDescriptorEnabledForKitKat;
  private final Executor mExecutor;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  protected LocalFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, boolean paramBoolean)
  {
    this.mExecutor = paramExecutor;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    if ((paramBoolean) && (Build.VERSION.SDK_INT == 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mDecodeFileDescriptorEnabledForKitKat = paramBoolean;
      return;
    }
  }
  
  protected EncodedImage getByteBufferBackedEncodedImage(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    localObject2 = null;
    if (paramInt < 0) {}
    for (;;)
    {
      try
      {
        localCloseableReference = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(paramInputStream));
        localObject2 = localCloseableReference;
        EncodedImage localEncodedImage = new EncodedImage(localCloseableReference);
        Closeables.closeQuietly(paramInputStream);
        CloseableReference.closeSafely(localCloseableReference);
        return localEncodedImage;
      }
      finally
      {
        CloseableReference localCloseableReference;
        Closeables.closeQuietly(paramInputStream);
        CloseableReference.closeSafely((CloseableReference)localObject2);
      }
      localCloseableReference = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(paramInputStream, paramInt));
    }
  }
  
  protected abstract EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException;
  
  protected EncodedImage getEncodedImage(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    Runtime localRuntime = Runtime.getRuntime();
    long l1 = localRuntime.maxMemory();
    long l2 = Math.min(l1 - (localRuntime.totalMemory() - localRuntime.freeMemory()), 8388608L);
    if ((this.mDecodeFileDescriptorEnabledForKitKat) && ((paramInputStream instanceof FileInputStream)) && (l1 >= 64L * l2)) {
      return getInputStreamBackedEncodedImage(new File(paramInputStream.toString()), paramInt);
    }
    return getByteBufferBackedEncodedImage(paramInputStream, paramInt);
  }
  
  protected EncodedImage getInputStreamBackedEncodedImage(final File paramFile, int paramInt)
    throws IOException
  {
    new EncodedImage(new Supplier()
    {
      public FileInputStream get()
      {
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(paramFile);
          return localFileInputStream;
        }
        catch (IOException localIOException)
        {
          throw new RuntimeException(localIOException);
        }
      }
    }, paramInt);
  }
  
  protected abstract String getProducerName();
  
  public void produceResults(final Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str = paramProducerContext.getId();
    final ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener, getProducerName(), str)
    {
      protected void disposeResult(EncodedImage paramAnonymousEncodedImage)
      {
        EncodedImage.closeSafely(paramAnonymousEncodedImage);
      }
      
      protected EncodedImage getResult()
        throws Exception
      {
        EncodedImage localEncodedImage = LocalFetchProducer.this.getEncodedImage(localImageRequest);
        if (localEncodedImage == null) {
          return null;
        }
        localEncodedImage.parseMetaData();
        return localEncodedImage;
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */