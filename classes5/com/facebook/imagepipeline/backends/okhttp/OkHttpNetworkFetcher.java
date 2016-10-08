package com.facebook.imagepipeline.backends.okhttp;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.squareup.okhttp.CacheControl.Builder;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class OkHttpNetworkFetcher
  extends BaseNetworkFetcher<OkHttpNetworkFetchState>
{
  private static final String FETCH_TIME = "fetch_time";
  private static final String IMAGE_SIZE = "image_size";
  private static final String QUEUE_TIME = "queue_time";
  private static final String TAG = "OkHttpNetworkFetchProducer";
  private static final String TOTAL_TIME = "total_time";
  private Executor mCancellationExecutor;
  private final OkHttpClient mOkHttpClient;
  
  public OkHttpNetworkFetcher(OkHttpClient paramOkHttpClient)
  {
    this.mOkHttpClient = paramOkHttpClient;
    this.mCancellationExecutor = paramOkHttpClient.getDispatcher().getExecutorService();
  }
  
  private void handleException(Call paramCall, Exception paramException, NetworkFetcher.Callback paramCallback)
  {
    if (paramCall.isCanceled())
    {
      paramCallback.onCancellation();
      return;
    }
    paramCallback.onFailure(paramException);
  }
  
  public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new OkHttpNetworkFetchState(paramConsumer, paramProducerContext);
  }
  
  public void fetch(final OkHttpNetworkFetchState paramOkHttpNetworkFetchState, final NetworkFetcher.Callback paramCallback)
  {
    paramOkHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
    final Object localObject = paramOkHttpNetworkFetchState.getUri();
    localObject = new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(((Uri)localObject).toString()).get().build();
    localObject = this.mOkHttpClient.newCall((Request)localObject);
    paramOkHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          localObject.cancel();
          return;
        }
        OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new Runnable()
        {
          public void run()
          {
            this.val$call.cancel();
          }
        });
      }
    });
    ((Call)localObject).enqueue(new Callback()
    {
      public void onFailure(Request paramAnonymousRequest, IOException paramAnonymousIOException)
      {
        OkHttpNetworkFetcher.this.handleException(localObject, paramAnonymousIOException, paramCallback);
      }
      
      public void onResponse(Response paramAnonymousResponse)
      {
        paramOkHttpNetworkFetchState.responseTime = SystemClock.elapsedRealtime();
        paramAnonymousResponse = paramAnonymousResponse.body();
        try
        {
          long l2 = paramAnonymousResponse.contentLength();
          long l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          paramCallback.onResponse(paramAnonymousResponse.byteStream(), (int)l1);
          return;
        }
        catch (Exception localException)
        {
          localException = localException;
          OkHttpNetworkFetcher.this.handleException(localObject, localException, paramCallback);
          try
          {
            paramAnonymousResponse.close();
            return;
          }
          catch (Exception paramAnonymousResponse)
          {
            FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymousResponse);
            return;
          }
        }
        finally
        {
          try
          {
            paramAnonymousResponse.close();
            throw ((Throwable)localObject);
          }
          catch (Exception paramAnonymousResponse)
          {
            for (;;)
            {
              FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymousResponse);
            }
          }
        }
      }
    });
  }
  
  public Map<String, String> getExtraMap(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, int paramInt)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("queue_time", Long.toString(paramOkHttpNetworkFetchState.responseTime - paramOkHttpNetworkFetchState.submitTime));
    localHashMap.put("fetch_time", Long.toString(paramOkHttpNetworkFetchState.fetchCompleteTime - paramOkHttpNetworkFetchState.responseTime));
    localHashMap.put("total_time", Long.toString(paramOkHttpNetworkFetchState.fetchCompleteTime - paramOkHttpNetworkFetchState.submitTime));
    localHashMap.put("image_size", Integer.toString(paramInt));
    return localHashMap;
  }
  
  public void onFetchCompletion(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, int paramInt)
  {
    paramOkHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
  }
  
  public static class OkHttpNetworkFetchState
    extends FetchState
  {
    public long fetchCompleteTime;
    public long responseTime;
    public long submitTime;
    
    public OkHttpNetworkFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
    {
      super(paramProducerContext);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\backends\okhttp\OkHttpNetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */