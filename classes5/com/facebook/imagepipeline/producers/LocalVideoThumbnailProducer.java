package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalVideoThumbnailProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  @VisibleForTesting
  static final String CREATED_THUMBNAIL = "createdThumbnail";
  @VisibleForTesting
  static final String PRODUCER_NAME = "VideoThumbnailProducer";
  private final Executor mExecutor;
  
  public LocalVideoThumbnailProducer(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
  }
  
  private static int calculateKind(ImageRequest paramImageRequest)
  {
    if ((paramImageRequest.getPreferredWidth() > 96) || (paramImageRequest.getPreferredHeight() > 96)) {
      return 1;
    }
    return 3;
  }
  
  public void produceResults(final Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer = new StatefulProducerRunnable(paramConsumer, paramProducerContext.getListener(), "VideoThumbnailProducer", paramProducerContext.getId())
    {
      protected void disposeResult(CloseableReference<CloseableImage> paramAnonymousCloseableReference)
      {
        CloseableReference.closeSafely(paramAnonymousCloseableReference);
      }
      
      protected Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> paramAnonymousCloseableReference)
      {
        if (paramAnonymousCloseableReference != null) {}
        for (boolean bool = true;; bool = false) {
          return ImmutableMap.of("createdThumbnail", String.valueOf(bool));
        }
      }
      
      protected CloseableReference<CloseableImage> getResult()
        throws Exception
      {
        Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(this.val$imageRequest.getSourceFile().getPath(), LocalVideoThumbnailProducer.calculateKind(this.val$imageRequest));
        if (localBitmap == null) {
          return null;
        }
        return CloseableReference.of(new CloseableStaticBitmap(localBitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalVideoThumbnailProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */