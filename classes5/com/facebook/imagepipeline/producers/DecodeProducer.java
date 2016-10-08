package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class DecodeProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  private static final String BITMAP_SIZE_KEY = "bitmapSize";
  private static final String HAS_GOOD_QUALITY_KEY = "hasGoodQuality";
  private static final String IS_FINAL_KEY = "isFinal";
  public static final String PRODUCER_NAME = "DecodeProducer";
  private final ByteArrayPool mByteArrayPool;
  private final boolean mDownsampleEnabled;
  private final boolean mDownsampleEnabledForNetwork;
  private final Executor mExecutor;
  private final ImageDecoder mImageDecoder;
  private final Producer<EncodedImage> mInputProducer;
  private final ProgressiveJpegConfig mProgressiveJpegConfig;
  
  public DecodeProducer(ByteArrayPool paramByteArrayPool, Executor paramExecutor, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, Producer<EncodedImage> paramProducer)
  {
    this.mByteArrayPool = ((ByteArrayPool)Preconditions.checkNotNull(paramByteArrayPool));
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mImageDecoder = ((ImageDecoder)Preconditions.checkNotNull(paramImageDecoder));
    this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(paramProgressiveJpegConfig));
    this.mDownsampleEnabled = paramBoolean1;
    this.mDownsampleEnabledForNetwork = paramBoolean2;
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
  }
  
  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    if (!UriUtil.isNetworkUri(paramProducerContext.getImageRequest().getSourceUri())) {}
    for (paramConsumer = new LocalImagesProgressiveDecoder(paramConsumer, paramProducerContext);; paramConsumer = new NetworkImagesProgressiveDecoder(paramConsumer, paramProducerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig))
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
  }
  
  private class LocalImagesProgressiveDecoder
    extends DecodeProducer.ProgressiveDecoder
  {
    public LocalImagesProgressiveDecoder(ProducerContext paramProducerContext)
    {
      super(paramProducerContext, localProducerContext);
    }
    
    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return paramEncodedImage.getSize();
    }
    
    protected QualityInfo getQualityInfo()
    {
      return ImmutableQualityInfo.of(0, false, false);
    }
    
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if (!paramBoolean) {
        paramBoolean = false;
      }
      for (;;)
      {
        return paramBoolean;
        try
        {
          paramBoolean = super.updateDecodeJob(paramEncodedImage, paramBoolean);
        }
        finally {}
      }
    }
  }
  
  private class NetworkImagesProgressiveDecoder
    extends DecodeProducer.ProgressiveDecoder
  {
    private int mLastScheduledScanNumber;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    private final ProgressiveJpegParser mProgressiveJpegParser;
    
    public NetworkImagesProgressiveDecoder(ProducerContext paramProducerContext, ProgressiveJpegParser paramProgressiveJpegParser, ProgressiveJpegConfig paramProgressiveJpegConfig)
    {
      super(paramProducerContext, paramProgressiveJpegParser);
      this.mProgressiveJpegParser = ((ProgressiveJpegParser)Preconditions.checkNotNull(paramProgressiveJpegConfig));
      Object localObject;
      this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(localObject));
      this.mLastScheduledScanNumber = 0;
    }
    
    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return this.mProgressiveJpegParser.getBestScanEndOffset();
    }
    
    protected QualityInfo getQualityInfo()
    {
      return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
    }
    
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      for (;;)
      {
        try
        {
          boolean bool2 = super.updateDecodeJob(paramEncodedImage, paramBoolean);
          boolean bool1 = bool2;
          if (!paramBoolean)
          {
            bool1 = bool2;
            if (EncodedImage.isValid(paramEncodedImage))
            {
              paramBoolean = this.mProgressiveJpegParser.parseMoreData(paramEncodedImage);
              if (paramBoolean) {
                continue;
              }
              bool1 = false;
            }
          }
          return bool1;
          int i = this.mProgressiveJpegParser.getBestScanNumber();
          if ((i > this.mLastScheduledScanNumber) && (i >= this.mProgressiveJpegConfig.getNextScanNumberToDecode(this.mLastScheduledScanNumber)))
          {
            this.mLastScheduledScanNumber = i;
            bool1 = bool2;
          }
          else
          {
            bool1 = false;
          }
        }
        finally {}
      }
    }
  }
  
  private abstract class ProgressiveDecoder
    extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>>
  {
    private final ImageDecodeOptions mImageDecodeOptions;
    @GuardedBy("this")
    private boolean mIsFinished;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    private final ProducerListener mProducerListener;
    
    public ProgressiveDecoder(ProducerContext paramProducerContext)
    {
      super();
      final ProducerContext localProducerContext;
      this.mProducerContext = localProducerContext;
      this.mProducerListener = localProducerContext.getListener();
      this.mImageDecodeOptions = localProducerContext.getImageRequest().getImageDecodeOptions();
      this.mIsFinished = false;
      paramProducerContext = new JobScheduler.JobRunnable()
      {
        public void run(EncodedImage paramAnonymousEncodedImage, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousEncodedImage != null)
          {
            if (DecodeProducer.this.mDownsampleEnabled)
            {
              ImageRequest localImageRequest = localProducerContext.getImageRequest();
              if ((DecodeProducer.this.mDownsampleEnabledForNetwork) || (!UriUtil.isNetworkUri(localImageRequest.getSourceUri()))) {
                paramAnonymousEncodedImage.setSampleSize(DownsampleUtil.determineSampleSize(localImageRequest, paramAnonymousEncodedImage));
              }
            }
            DecodeProducer.ProgressiveDecoder.this.doDecode(paramAnonymousEncodedImage, paramAnonymousBoolean);
          }
        }
      };
      this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, paramProducerContext, this.mImageDecodeOptions.minDecodeIntervalMs);
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onIsIntermediateResultExpectedChanged()
        {
          if (DecodeProducer.ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
            DecodeProducer.ProgressiveDecoder.this.mJobScheduler.scheduleJob();
          }
        }
      });
    }
    
    /* Error */
    private void doDecode(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 105	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:isFinished	()Z
      //   4: ifne +10 -> 14
      //   7: aload_1
      //   8: invokestatic 111	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
      //   11: ifne +4 -> 15
      //   14: return
      //   15: aload_0
      //   16: getfield 78	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mJobScheduler	Lcom/facebook/imagepipeline/producers/JobScheduler;
      //   19: invokevirtual 115	com/facebook/imagepipeline/producers/JobScheduler:getQueuedTime	()J
      //   22: lstore 6
      //   24: iload_2
      //   25: ifeq +101 -> 126
      //   28: aload_1
      //   29: invokevirtual 119	com/facebook/imagepipeline/image/EncodedImage:getSize	()I
      //   32: istore 5
      //   34: iload_2
      //   35: ifeq +101 -> 136
      //   38: getstatic 125	com/facebook/imagepipeline/image/ImmutableQualityInfo:FULL_QUALITY	Lcom/facebook/imagepipeline/image/QualityInfo;
      //   41: astore_3
      //   42: aload_0
      //   43: getfield 44	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerListener	Lcom/facebook/imagepipeline/producers/ProducerListener;
      //   46: aload_0
      //   47: getfield 36	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   50: invokeinterface 129 1 0
      //   55: ldc -125
      //   57: invokeinterface 137 3 0
      //   62: aload_0
      //   63: getfield 31	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:this$0	Lcom/facebook/imagepipeline/producers/DecodeProducer;
      //   66: invokestatic 140	com/facebook/imagepipeline/producers/DecodeProducer:access$3	(Lcom/facebook/imagepipeline/producers/DecodeProducer;)Lcom/facebook/imagepipeline/decoder/ImageDecoder;
      //   69: aload_1
      //   70: iload 5
      //   72: aload_3
      //   73: aload_0
      //   74: getfield 56	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mImageDecodeOptions	Lcom/facebook/imagepipeline/common/ImageDecodeOptions;
      //   77: invokevirtual 146	com/facebook/imagepipeline/decoder/ImageDecoder:decodeImage	(Lcom/facebook/imagepipeline/image/EncodedImage;ILcom/facebook/imagepipeline/image/QualityInfo;Lcom/facebook/imagepipeline/common/ImageDecodeOptions;)Lcom/facebook/imagepipeline/image/CloseableImage;
      //   80: astore 4
      //   82: aload_0
      //   83: aload 4
      //   85: lload 6
      //   87: aload_3
      //   88: iload_2
      //   89: invokespecial 150	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:getExtraMap	(Lcom/facebook/imagepipeline/image/CloseableImage;JLcom/facebook/imagepipeline/image/QualityInfo;Z)Ljava/util/Map;
      //   92: astore_3
      //   93: aload_0
      //   94: getfield 44	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerListener	Lcom/facebook/imagepipeline/producers/ProducerListener;
      //   97: aload_0
      //   98: getfield 36	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   101: invokeinterface 129 1 0
      //   106: ldc -125
      //   108: aload_3
      //   109: invokeinterface 154 4 0
      //   114: aload_0
      //   115: aload 4
      //   117: iload_2
      //   118: invokespecial 158	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:handleResult	(Lcom/facebook/imagepipeline/image/CloseableImage;Z)V
      //   121: aload_1
      //   122: invokestatic 162	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   125: return
      //   126: aload_0
      //   127: aload_1
      //   128: invokevirtual 166	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:getIntermediateImageEndOffset	(Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   131: istore 5
      //   133: goto -99 -> 34
      //   136: aload_0
      //   137: invokevirtual 170	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:getQualityInfo	()Lcom/facebook/imagepipeline/image/QualityInfo;
      //   140: astore_3
      //   141: goto -99 -> 42
      //   144: astore 4
      //   146: aload_0
      //   147: aconst_null
      //   148: lload 6
      //   150: aload_3
      //   151: iload_2
      //   152: invokespecial 150	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:getExtraMap	(Lcom/facebook/imagepipeline/image/CloseableImage;JLcom/facebook/imagepipeline/image/QualityInfo;Z)Ljava/util/Map;
      //   155: astore_3
      //   156: aload_0
      //   157: getfield 44	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerListener	Lcom/facebook/imagepipeline/producers/ProducerListener;
      //   160: aload_0
      //   161: getfield 36	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   164: invokeinterface 129 1 0
      //   169: ldc -125
      //   171: aload 4
      //   173: aload_3
      //   174: invokeinterface 174 5 0
      //   179: aload_0
      //   180: aload 4
      //   182: invokespecial 178	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:handleError	(Ljava/lang/Throwable;)V
      //   185: aload_1
      //   186: invokestatic 162	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   189: return
      //   190: astore_3
      //   191: aload_1
      //   192: invokestatic 162	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   195: aload_3
      //   196: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	197	0	this	ProgressiveDecoder
      //   0	197	1	paramEncodedImage	EncodedImage
      //   0	197	2	paramBoolean	boolean
      //   41	133	3	localObject1	Object
      //   190	6	3	localObject2	Object
      //   80	36	4	localCloseableImage	CloseableImage
      //   144	37	4	localException	Exception
      //   32	100	5	i	int
      //   22	127	6	l	long
      // Exception table:
      //   from	to	target	type
      //   62	82	144	java/lang/Exception
      //   15	24	190	finally
      //   28	34	190	finally
      //   38	42	190	finally
      //   42	62	190	finally
      //   62	82	190	finally
      //   82	121	190	finally
      //   126	133	190	finally
      //   136	141	190	finally
      //   146	185	190	finally
    }
    
    private Map<String, String> getExtraMap(@Nullable CloseableImage paramCloseableImage, long paramLong, QualityInfo paramQualityInfo, boolean paramBoolean)
    {
      if (!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId())) {
        return null;
      }
      String str1 = String.valueOf(paramLong);
      paramQualityInfo = String.valueOf(paramQualityInfo.isOfGoodEnoughQuality());
      String str2 = String.valueOf(paramBoolean);
      if ((paramCloseableImage instanceof CloseableStaticBitmap))
      {
        paramCloseableImage = ((CloseableStaticBitmap)paramCloseableImage).getUnderlyingBitmap();
        return ImmutableMap.of("bitmapSize", paramCloseableImage.getWidth() + "x" + paramCloseableImage.getHeight(), "queueTime", str1, "hasGoodQuality", paramQualityInfo, "isFinal", str2);
      }
      return ImmutableMap.of("queueTime", str1, "hasGoodQuality", paramQualityInfo, "isFinal", str2);
    }
    
    private void handleCancellation()
    {
      maybeFinish(true);
      getConsumer().onCancellation();
    }
    
    private void handleError(Throwable paramThrowable)
    {
      maybeFinish(true);
      getConsumer().onFailure(paramThrowable);
    }
    
    private void handleResult(CloseableImage paramCloseableImage, boolean paramBoolean)
    {
      paramCloseableImage = CloseableReference.of(paramCloseableImage);
      try
      {
        maybeFinish(paramBoolean);
        getConsumer().onNewResult(paramCloseableImage, paramBoolean);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(paramCloseableImage);
      }
    }
    
    private boolean isFinished()
    {
      try
      {
        boolean bool = this.mIsFinished;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private void maybeFinish(boolean paramBoolean)
    {
      if (paramBoolean) {}
      try
      {
        if (this.mIsFinished) {
          return;
        }
        this.mIsFinished = true;
        this.mJobScheduler.clearJob();
        return;
      }
      finally {}
    }
    
    protected abstract int getIntermediateImageEndOffset(EncodedImage paramEncodedImage);
    
    protected abstract QualityInfo getQualityInfo();
    
    public void onCancellationImpl()
    {
      handleCancellation();
    }
    
    public void onFailureImpl(Throwable paramThrowable)
    {
      handleError(paramThrowable);
    }
    
    public void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((paramBoolean) && (!EncodedImage.isValid(paramEncodedImage))) {
        handleError(new NullPointerException("Encoded image is not valid."));
      }
      while ((!updateDecodeJob(paramEncodedImage, paramBoolean)) || ((!paramBoolean) && (!this.mProducerContext.isIntermediateResultExpected()))) {
        return;
      }
      this.mJobScheduler.scheduleJob();
    }
    
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      return this.mJobScheduler.updateJob(paramEncodedImage, paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\DecodeProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */