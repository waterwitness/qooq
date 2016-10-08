package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ResizeAndRotateProducer
  implements Producer<EncodedImage>
{
  @VisibleForTesting
  static final int DEFAULT_JPEG_QUALITY = 85;
  private static final String FRACTION_KEY = "Fraction";
  @VisibleForTesting
  static final int MAX_JPEG_SCALE_NUMERATOR = 8;
  @VisibleForTesting
  static final int MIN_TRANSFORM_INTERVAL_MS = 100;
  private static final String ORIGINAL_SIZE_KEY = "Original size";
  private static final String PRODUCER_NAME = "ResizeAndRotateProducer";
  private static final String REQUESTED_SIZE_KEY = "Requested size";
  private static final float ROUNDUP_FRACTION = 0.6666667F;
  private final Executor mExecutor;
  private final Producer<EncodedImage> mInputProducer;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  public ResizeAndRotateProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, Producer<EncodedImage> paramProducer)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mPooledByteBufferFactory = ((PooledByteBufferFactory)Preconditions.checkNotNull(paramPooledByteBufferFactory));
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
  }
  
  @VisibleForTesting
  static float determineResizeRatio(ResizeOptions paramResizeOptions, int paramInt1, int paramInt2)
  {
    float f2;
    if (paramResizeOptions == null) {
      f2 = 1.0F;
    }
    float f1;
    do
    {
      return f2;
      f2 = Math.max(paramResizeOptions.width / paramInt1, paramResizeOptions.height / paramInt2);
      f1 = f2;
      if (paramInt1 * f2 > 2048.0F) {
        f1 = 2048.0F / paramInt1;
      }
      f2 = f1;
    } while (paramInt2 * f1 <= 2048.0F);
    return 2048.0F / paramInt2;
  }
  
  private static int getRotationAngle(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    boolean bool = false;
    if (!paramImageRequest.getAutoRotateEnabled()) {
      return 0;
    }
    int i = paramEncodedImage.getRotationAngle();
    if ((i != 0) && (i != 90) && (i != 180) && (i != 270)) {}
    for (;;)
    {
      Preconditions.checkArgument(bool);
      return i;
      bool = true;
    }
  }
  
  private static int getScaleNumerator(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    ResizeOptions localResizeOptions = paramImageRequest.getResizeOptions();
    int i;
    if (localResizeOptions == null) {
      i = 8;
    }
    int j;
    label46:
    label85:
    label93:
    label102:
    do
    {
      return i;
      i = getRotationAngle(paramImageRequest, paramEncodedImage);
      if ((i != 90) && (i != 270))
      {
        j = 0;
        if (j == 0) {
          break label85;
        }
        i = paramEncodedImage.getHeight();
        if (j == 0) {
          break label93;
        }
      }
      for (j = paramEncodedImage.getWidth();; j = paramEncodedImage.getHeight())
      {
        j = roundNumerator(determineResizeRatio(localResizeOptions, i, j));
        if (j <= 8) {
          break label102;
        }
        return 8;
        j = 1;
        break;
        i = paramEncodedImage.getWidth();
        break label46;
      }
      i = j;
    } while (j >= 1);
    return 1;
  }
  
  @VisibleForTesting
  static int roundNumerator(float paramFloat)
  {
    return (int)(0.6666667F + 8.0F * paramFloat);
  }
  
  private static boolean shouldResize(int paramInt)
  {
    return paramInt < 8;
  }
  
  private static TriState shouldTransform(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    if ((paramEncodedImage == null) || (paramEncodedImage.getImageFormat() == ImageFormat.UNKNOWN)) {
      return TriState.UNSET;
    }
    if (paramEncodedImage.getImageFormat() != ImageFormat.JPEG) {
      return TriState.NO;
    }
    if ((getRotationAngle(paramImageRequest, paramEncodedImage) == 0) && (!shouldResize(getScaleNumerator(paramImageRequest, paramEncodedImage)))) {}
    for (boolean bool = false;; bool = true) {
      return TriState.valueOf(bool);
    }
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new TransformingConsumer(paramConsumer, paramProducerContext), paramProducerContext);
  }
  
  private class TransformingConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private boolean mIsCancelled = false;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    
    public TransformingConsumer(final ProducerContext paramProducerContext)
    {
      super();
      this.mProducerContext = local1;
      JobScheduler.JobRunnable local1 = new JobScheduler.JobRunnable()
      {
        public void run(EncodedImage paramAnonymousEncodedImage, boolean paramAnonymousBoolean)
        {
          ResizeAndRotateProducer.TransformingConsumer.this.doTransform(paramAnonymousEncodedImage, paramAnonymousBoolean);
        }
      };
      this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, local1, 100);
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.clearJob();
          ResizeAndRotateProducer.TransformingConsumer.this.mIsCancelled = true;
          paramProducerContext.onCancellation();
        }
        
        public void onIsIntermediateResultExpectedChanged()
        {
          if (ResizeAndRotateProducer.TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
            ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.scheduleJob();
          }
        }
      });
    }
    
    /* Error */
    private void doTransform(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   4: invokeinterface 75 1 0
      //   9: aload_0
      //   10: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   13: invokeinterface 79 1 0
      //   18: ldc 81
      //   20: invokeinterface 87 3 0
      //   25: aload_0
      //   26: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   29: invokeinterface 91 1 0
      //   34: astore 10
      //   36: aload_0
      //   37: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   40: invokestatic 94	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$2	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Lcom/facebook/imagepipeline/memory/PooledByteBufferFactory;
      //   43: invokeinterface 100 1 0
      //   48: astore 9
      //   50: aconst_null
      //   51: astore 7
      //   53: aconst_null
      //   54: astore 8
      //   56: aconst_null
      //   57: astore_3
      //   58: aload 7
      //   60: astore 5
      //   62: aload_3
      //   63: astore 6
      //   65: aload 8
      //   67: astore 4
      //   69: aload 10
      //   71: aload_1
      //   72: invokestatic 103	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$3	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   75: istore 11
      //   77: aload 7
      //   79: astore 5
      //   81: aload_3
      //   82: astore 6
      //   84: aload 8
      //   86: astore 4
      //   88: aload_0
      //   89: aload_1
      //   90: aload 10
      //   92: iload 11
      //   94: invokespecial 107	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getExtraMap	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/request/ImageRequest;I)Ljava/util/Map;
      //   97: astore 7
      //   99: aload 7
      //   101: astore 5
      //   103: aload_3
      //   104: astore 6
      //   106: aload 8
      //   108: astore 4
      //   110: aload_1
      //   111: invokevirtual 113	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
      //   114: astore_3
      //   115: aload 7
      //   117: astore 5
      //   119: aload_3
      //   120: astore 6
      //   122: aload_3
      //   123: astore 4
      //   125: aload_3
      //   126: aload 9
      //   128: aload 10
      //   130: aload_1
      //   131: invokestatic 115	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$4	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   134: iload 11
      //   136: bipush 85
      //   138: invokestatic 121	com/facebook/imagepipeline/nativecode/JpegTranscoder:transcodeJpeg	(Ljava/io/InputStream;Ljava/io/OutputStream;III)V
      //   141: aload 7
      //   143: astore 5
      //   145: aload_3
      //   146: astore 6
      //   148: aload_3
      //   149: astore 4
      //   151: aload 9
      //   153: invokevirtual 127	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/imagepipeline/memory/PooledByteBuffer;
      //   156: invokestatic 133	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
      //   159: astore 8
      //   161: new 109	com/facebook/imagepipeline/image/EncodedImage
      //   164: dup
      //   165: aload 8
      //   167: invokespecial 136	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
      //   170: astore_1
      //   171: aload_1
      //   172: getstatic 142	com/facebook/imageformat/ImageFormat:JPEG	Lcom/facebook/imageformat/ImageFormat;
      //   175: invokevirtual 146	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
      //   178: aload_1
      //   179: invokevirtual 150	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
      //   182: aload_0
      //   183: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   186: invokeinterface 75 1 0
      //   191: aload_0
      //   192: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   195: invokeinterface 79 1 0
      //   200: ldc 81
      //   202: aload 7
      //   204: invokeinterface 154 4 0
      //   209: aload_0
      //   210: invokevirtual 158	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   213: aload_1
      //   214: iload_2
      //   215: invokeinterface 164 3 0
      //   220: aload_1
      //   221: invokestatic 168	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   224: aload 8
      //   226: invokestatic 170	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   229: aload_3
      //   230: invokestatic 176	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   233: aload 9
      //   235: invokevirtual 179	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:close	()V
      //   238: return
      //   239: astore 4
      //   241: aload_1
      //   242: invokestatic 168	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   245: aload 4
      //   247: athrow
      //   248: astore_1
      //   249: aload 7
      //   251: astore 5
      //   253: aload_3
      //   254: astore 6
      //   256: aload_3
      //   257: astore 4
      //   259: aload 8
      //   261: invokestatic 170	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   264: aload 7
      //   266: astore 5
      //   268: aload_3
      //   269: astore 6
      //   271: aload_3
      //   272: astore 4
      //   274: aload_1
      //   275: athrow
      //   276: astore_1
      //   277: aload 6
      //   279: astore_3
      //   280: aload_3
      //   281: astore 4
      //   283: aload_0
      //   284: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   287: invokeinterface 75 1 0
      //   292: aload_0
      //   293: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   296: invokeinterface 79 1 0
      //   301: ldc 81
      //   303: aload_1
      //   304: aload 5
      //   306: invokeinterface 183 5 0
      //   311: aload_3
      //   312: astore 4
      //   314: aload_0
      //   315: invokevirtual 158	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   318: aload_1
      //   319: invokeinterface 187 2 0
      //   324: aload_3
      //   325: invokestatic 176	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   328: aload 9
      //   330: invokevirtual 179	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:close	()V
      //   333: return
      //   334: astore_1
      //   335: aload 4
      //   337: astore_3
      //   338: aload_3
      //   339: invokestatic 176	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   342: aload 9
      //   344: invokevirtual 179	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:close	()V
      //   347: aload_1
      //   348: athrow
      //   349: astore_1
      //   350: goto -12 -> 338
      //   353: astore_1
      //   354: aload 7
      //   356: astore 5
      //   358: goto -78 -> 280
      //   361: astore_1
      //   362: goto -113 -> 249
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	365	0	this	TransformingConsumer
      //   0	365	1	paramEncodedImage	EncodedImage
      //   0	365	2	paramBoolean	boolean
      //   57	282	3	localObject1	Object
      //   67	83	4	localObject2	Object
      //   239	7	4	localObject3	Object
      //   257	79	4	localObject4	Object
      //   60	297	5	localMap1	Map
      //   63	215	6	localObject5	Object
      //   51	304	7	localMap2	Map
      //   54	206	8	localCloseableReference	com.facebook.common.references.CloseableReference
      //   48	295	9	localPooledByteBufferOutputStream	com.facebook.imagepipeline.memory.PooledByteBufferOutputStream
      //   34	95	10	localImageRequest	ImageRequest
      //   75	60	11	i	int
      // Exception table:
      //   from	to	target	type
      //   178	220	239	finally
      //   171	178	248	finally
      //   220	224	248	finally
      //   241	248	248	finally
      //   69	77	276	java/lang/Exception
      //   88	99	276	java/lang/Exception
      //   110	115	276	java/lang/Exception
      //   125	141	276	java/lang/Exception
      //   151	161	276	java/lang/Exception
      //   259	264	276	java/lang/Exception
      //   274	276	276	java/lang/Exception
      //   69	77	334	finally
      //   88	99	334	finally
      //   110	115	334	finally
      //   125	141	334	finally
      //   151	161	334	finally
      //   259	264	334	finally
      //   274	276	334	finally
      //   283	311	334	finally
      //   314	324	334	finally
      //   224	229	349	finally
      //   224	229	353	java/lang/Exception
      //   161	171	361	finally
    }
    
    private Map<String, String> getExtraMap(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, int paramInt)
    {
      if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
        return null;
      }
      String str = paramEncodedImage.getWidth() + "x" + paramEncodedImage.getHeight();
      if (paramImageRequest.getResizeOptions() != null)
      {
        paramEncodedImage = paramImageRequest.getResizeOptions().width + "x" + paramImageRequest.getResizeOptions().height;
        if (paramInt <= 0) {
          break label159;
        }
      }
      label159:
      for (paramImageRequest = paramInt + "/8";; paramImageRequest = "")
      {
        return ImmutableMap.of("Original size", str, "Requested size", paramEncodedImage, "Fraction", paramImageRequest, "queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
        paramEncodedImage = "Unspecified";
        break;
      }
    }
    
    protected void onNewResultImpl(@Nullable EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if (this.mIsCancelled) {}
      do
      {
        TriState localTriState;
        do
        {
          do
          {
            return;
            if (paramEncodedImage != null) {
              break;
            }
          } while (!paramBoolean);
          getConsumer().onNewResult(null, true);
          return;
          localTriState = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), paramEncodedImage);
        } while ((!paramBoolean) && (localTriState == TriState.UNSET));
        if (localTriState != TriState.YES)
        {
          getConsumer().onNewResult(paramEncodedImage, paramBoolean);
          return;
        }
      } while ((!this.mJobScheduler.updateJob(paramEncodedImage, paramBoolean)) || ((!paramBoolean) && (!this.mProducerContext.isIntermediateResultExpected())));
      this.mJobScheduler.scheduleJob();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\ResizeAndRotateProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */