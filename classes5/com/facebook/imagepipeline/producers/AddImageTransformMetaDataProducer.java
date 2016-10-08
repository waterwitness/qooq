package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

public class AddImageTransformMetaDataProducer
  implements Producer<EncodedImage>
{
  private final Producer<EncodedImage> mInputProducer;
  
  public AddImageTransformMetaDataProducer(Producer<EncodedImage> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new AddImageTransformMetaDataConsumer(paramConsumer, null), paramProducerContext);
  }
  
  private static class AddImageTransformMetaDataConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private AddImageTransformMetaDataConsumer(Consumer<EncodedImage> paramConsumer)
    {
      super();
    }
    
    protected void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if (paramEncodedImage == null)
      {
        getConsumer().onNewResult(null, paramBoolean);
        return;
      }
      if (!EncodedImage.isMetaDataAvailable(paramEncodedImage)) {
        paramEncodedImage.parseMetaData();
      }
      getConsumer().onNewResult(paramEncodedImage, paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\AddImageTransformMetaDataProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */