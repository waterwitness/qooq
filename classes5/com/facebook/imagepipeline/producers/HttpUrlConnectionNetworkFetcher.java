package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUrlConnectionNetworkFetcher
  extends BaseNetworkFetcher<FetchState>
{
  private static final int NUM_NETWORK_THREADS = 3;
  private final ExecutorService mExecutorService = Executors.newFixedThreadPool(3);
  
  public FetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new FetchState(paramConsumer, paramProducerContext);
  }
  
  public void fetch(final FetchState paramFetchState, final NetworkFetcher.Callback paramCallback)
  {
    final Future localFuture = this.mExecutorService.submit(new Runnable()
    {
      public void run()
      {
        localObject1 = null;
        Object localObject5 = paramFetchState.getUri().getScheme();
        Object localObject4 = paramFetchState.getUri().toString();
        for (;;)
        {
          localObject3 = localObject1;
          for (;;)
          {
            try
            {
              localHttpURLConnection = (HttpURLConnection)new URL((String)localObject4).openConnection();
              localObject3 = localHttpURLConnection;
              localObject1 = localHttpURLConnection;
              localObject6 = localHttpURLConnection.getHeaderField("Location");
              if (localObject6 == null)
              {
                localObject4 = null;
                if (localObject6 != null)
                {
                  localObject3 = localHttpURLConnection;
                  localObject1 = localHttpURLConnection;
                  if (!((String)localObject4).equals(localObject5)) {
                    continue;
                  }
                }
                localObject3 = localHttpURLConnection;
                localObject1 = localHttpURLConnection;
                localObject4 = localHttpURLConnection.getInputStream();
                localObject3 = localHttpURLConnection;
                localObject1 = localHttpURLConnection;
                paramCallback.onResponse((InputStream)localObject4, -1);
                if (localHttpURLConnection != null) {
                  localHttpURLConnection.disconnect();
                }
                return;
              }
            }
            catch (Exception localException)
            {
              HttpURLConnection localHttpURLConnection;
              Object localObject6;
              localObject1 = localObject3;
              paramCallback.onFailure(localException);
              return;
            }
            finally
            {
              if (localObject1 == null) {
                continue;
              }
              ((HttpURLConnection)localObject1).disconnect();
            }
            localObject3 = localHttpURLConnection;
            localObject1 = localHttpURLConnection;
            localObject4 = Uri.parse((String)localObject6).getScheme();
          }
          localObject3 = localObject6;
          localObject6 = localObject4;
          localObject1 = localHttpURLConnection;
          localObject5 = localObject6;
          localObject4 = localObject3;
          if (localHttpURLConnection != null)
          {
            localHttpURLConnection.disconnect();
            localObject1 = localHttpURLConnection;
            localObject5 = localObject6;
            localObject4 = localObject3;
          }
        }
      }
    });
    paramFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        if (localFuture.cancel(false)) {
          paramCallback.onCancellation();
        }
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\HttpUrlConnectionNetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */