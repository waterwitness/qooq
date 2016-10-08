package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public class NetworkFetchProducer
  implements Producer<EncodedImage>
{
  public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
  @VisibleForTesting
  static final String PRODUCER_NAME = "NetworkFetchProducer";
  private static final int READ_SIZE = 16384;
  @VisibleForTesting
  static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100L;
  private final ByteArrayPool mByteArrayPool;
  private final NetworkFetcher mNetworkFetcher;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  public NetworkFetchProducer(PooledByteBufferFactory paramPooledByteBufferFactory, ByteArrayPool paramByteArrayPool, NetworkFetcher paramNetworkFetcher)
  {
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mByteArrayPool = paramByteArrayPool;
    this.mNetworkFetcher = paramNetworkFetcher;
  }
  
  private static float calculateProgress(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      return paramInt1 / paramInt2;
    }
    return 1.0F - (float)Math.exp(-paramInt1 / 50000.0D);
  }
  
  @Nullable
  private Map<String, String> getExtraMap(FetchState paramFetchState, int paramInt)
  {
    if (!paramFetchState.getListener().requiresExtraMap(paramFetchState.getId())) {
      return null;
    }
    return this.mNetworkFetcher.getExtraMap(paramFetchState, paramInt);
  }
  
  private void handleFinalResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    Map localMap = getExtraMap(paramFetchState, paramPooledByteBufferOutputStream.size());
    paramFetchState.getListener().onProducerFinishWithSuccess(paramFetchState.getId(), "NetworkFetchProducer", localMap);
    notifyConsumer(paramPooledByteBufferOutputStream, true, paramFetchState.getConsumer());
  }
  
  private void maybeHandleIntermediateResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    long l = SystemClock.elapsedRealtime();
    if ((shouldPropagateIntermediateResults(paramFetchState)) && (l - paramFetchState.getLastIntermediateResultTimeMs() >= 100L))
    {
      paramFetchState.setLastIntermediateResultTimeMs(l);
      paramFetchState.getListener().onProducerEvent(paramFetchState.getId(), "NetworkFetchProducer", "intermediate_result");
      notifyConsumer(paramPooledByteBufferOutputStream, false, paramFetchState.getConsumer());
    }
  }
  
  /* Error */
  private void notifyConsumer(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, boolean paramBoolean, Consumer<EncodedImage> paramConsumer)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 146	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/imagepipeline/memory/PooledByteBuffer;
    //   4: invokestatic 152	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_1
    //   11: new 154	com/facebook/imagepipeline/image/EncodedImage
    //   14: dup
    //   15: aload 5
    //   17: invokespecial 157	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   20: astore 4
    //   22: aload 4
    //   24: invokevirtual 160	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
    //   27: aload_3
    //   28: aload 4
    //   30: iload_2
    //   31: invokeinterface 166 3 0
    //   36: aload 4
    //   38: invokestatic 170	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   41: aload 5
    //   43: invokestatic 172	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   46: return
    //   47: astore_3
    //   48: aload_1
    //   49: invokestatic 170	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   52: aload 5
    //   54: invokestatic 172	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   57: aload_3
    //   58: athrow
    //   59: astore_3
    //   60: aload 4
    //   62: astore_1
    //   63: goto -15 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	NetworkFetchProducer
    //   0	66	1	paramPooledByteBufferOutputStream	PooledByteBufferOutputStream
    //   0	66	2	paramBoolean	boolean
    //   0	66	3	paramConsumer	Consumer<EncodedImage>
    //   20	41	4	localEncodedImage	EncodedImage
    //   7	46	5	localCloseableReference	com.facebook.common.references.CloseableReference
    // Exception table:
    //   from	to	target	type
    //   11	22	47	finally
    //   22	36	59	finally
  }
  
  private void onCancellation(FetchState paramFetchState)
  {
    paramFetchState.getListener().onProducerFinishWithCancellation(paramFetchState.getId(), "NetworkFetchProducer", null);
    paramFetchState.getConsumer().onCancellation();
  }
  
  private void onFailure(FetchState paramFetchState, Throwable paramThrowable)
  {
    paramFetchState.getListener().onProducerFinishWithFailure(paramFetchState.getId(), "NetworkFetchProducer", paramThrowable, null);
    paramFetchState.getConsumer().onFailure(paramThrowable);
  }
  
  /* Error */
  private void onResponse(FetchState paramFetchState, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: iload_3
    //   1: ifle +84 -> 85
    //   4: aload_0
    //   5: getfield 37	com/facebook/imagepipeline/producers/NetworkFetchProducer:mPooledByteBufferFactory	Lcom/facebook/imagepipeline/memory/PooledByteBufferFactory;
    //   8: iload_3
    //   9: invokeinterface 191 2 0
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 39	com/facebook/imagepipeline/producers/NetworkFetchProducer:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   20: sipush 16384
    //   23: invokeinterface 197 2 0
    //   28: checkcast 199	[B
    //   31: astore 6
    //   33: aload_2
    //   34: aload 6
    //   36: invokevirtual 205	java/io/InputStream:read	([B)I
    //   39: istore 7
    //   41: iload 7
    //   43: ifge +56 -> 99
    //   46: aload_0
    //   47: getfield 41	com/facebook/imagepipeline/producers/NetworkFetchProducer:mNetworkFetcher	Lcom/facebook/imagepipeline/producers/NetworkFetcher;
    //   50: aload_1
    //   51: aload 5
    //   53: invokevirtual 107	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:size	()I
    //   56: invokeinterface 209 3 0
    //   61: aload_0
    //   62: aload 5
    //   64: aload_1
    //   65: invokespecial 211	com/facebook/imagepipeline/producers/NetworkFetchProducer:handleFinalResult	(Lcom/facebook/imagepipeline/memory/PooledByteBufferOutputStream;Lcom/facebook/imagepipeline/producers/FetchState;)V
    //   68: aload_0
    //   69: getfield 39	com/facebook/imagepipeline/producers/NetworkFetchProducer:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   72: aload 6
    //   74: invokeinterface 215 2 0
    //   79: aload 5
    //   81: invokevirtual 218	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:close	()V
    //   84: return
    //   85: aload_0
    //   86: getfield 37	com/facebook/imagepipeline/producers/NetworkFetchProducer:mPooledByteBufferFactory	Lcom/facebook/imagepipeline/memory/PooledByteBufferFactory;
    //   89: invokeinterface 221 1 0
    //   94: astore 5
    //   96: goto -80 -> 16
    //   99: iload 7
    //   101: ifle -68 -> 33
    //   104: aload 5
    //   106: aload 6
    //   108: iconst_0
    //   109: iload 7
    //   111: invokevirtual 225	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:write	([BII)V
    //   114: aload_0
    //   115: aload 5
    //   117: aload_1
    //   118: invokespecial 227	com/facebook/imagepipeline/producers/NetworkFetchProducer:maybeHandleIntermediateResult	(Lcom/facebook/imagepipeline/memory/PooledByteBufferOutputStream;Lcom/facebook/imagepipeline/producers/FetchState;)V
    //   121: aload 5
    //   123: invokevirtual 107	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:size	()I
    //   126: iload_3
    //   127: invokestatic 229	com/facebook/imagepipeline/producers/NetworkFetchProducer:calculateProgress	(II)F
    //   130: fstore 4
    //   132: aload_1
    //   133: invokevirtual 116	com/facebook/imagepipeline/producers/FetchState:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
    //   136: fload 4
    //   138: invokeinterface 233 2 0
    //   143: goto -110 -> 33
    //   146: astore_1
    //   147: aload_0
    //   148: getfield 39	com/facebook/imagepipeline/producers/NetworkFetchProducer:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   151: aload 6
    //   153: invokeinterface 215 2 0
    //   158: aload 5
    //   160: invokevirtual 218	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:close	()V
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	NetworkFetchProducer
    //   0	165	1	paramFetchState	FetchState
    //   0	165	2	paramInputStream	InputStream
    //   0	165	3	paramInt	int
    //   130	7	4	f	float
    //   14	145	5	localPooledByteBufferOutputStream	PooledByteBufferOutputStream
    //   31	121	6	arrayOfByte	byte[]
    //   39	71	7	i	int
    // Exception table:
    //   from	to	target	type
    //   33	41	146	finally
    //   46	68	146	finally
    //   104	143	146	finally
  }
  
  private boolean shouldPropagateIntermediateResults(FetchState paramFetchState)
  {
    if (!paramFetchState.getContext().getImageRequest().getProgressiveRenderingEnabled()) {
      return false;
    }
    return this.mNetworkFetcher.shouldPropagate(paramFetchState);
  }
  
  public void produceResults(final Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "NetworkFetchProducer");
    paramConsumer = this.mNetworkFetcher.createFetchState(paramConsumer, paramProducerContext);
    this.mNetworkFetcher.fetch(paramConsumer, new NetworkFetcher.Callback()
    {
      public void onCancellation()
      {
        NetworkFetchProducer.this.onCancellation(paramConsumer);
      }
      
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        NetworkFetchProducer.this.onFailure(paramConsumer, paramAnonymousThrowable);
      }
      
      public void onResponse(InputStream paramAnonymousInputStream, int paramAnonymousInt)
        throws IOException
      {
        NetworkFetchProducer.this.onResponse(paramConsumer, paramAnonymousInputStream, paramAnonymousInt);
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\NetworkFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */