package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class FetchState
{
  private final Consumer<EncodedImage> mConsumer;
  private final ProducerContext mContext;
  private long mLastIntermediateResultTimeMs;
  
  public FetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mConsumer = paramConsumer;
    this.mContext = paramProducerContext;
    this.mLastIntermediateResultTimeMs = 0L;
  }
  
  public Consumer<EncodedImage> getConsumer()
  {
    return this.mConsumer;
  }
  
  public ProducerContext getContext()
  {
    return this.mContext;
  }
  
  public String getId()
  {
    return this.mContext.getId();
  }
  
  public long getLastIntermediateResultTimeMs()
  {
    return this.mLastIntermediateResultTimeMs;
  }
  
  public ProducerListener getListener()
  {
    return this.mContext.getListener();
  }
  
  public Uri getUri()
  {
    return this.mContext.getImageRequest().getSourceUri();
  }
  
  public void setLastIntermediateResultTimeMs(long paramLong)
  {
    this.mLastIntermediateResultTimeMs = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\FetchState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */