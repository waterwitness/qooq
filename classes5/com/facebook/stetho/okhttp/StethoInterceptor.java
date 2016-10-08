package com.facebook.stetho.okhttp;

import com.facebook.stetho.inspector.network.DefaultResponseHandler;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse;
import com.facebook.stetho.inspector.network.NetworkEventReporterImpl;
import com.facebook.stetho.inspector.network.RequestBodyHelper;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class StethoInterceptor
  implements Interceptor
{
  private final NetworkEventReporter mEventReporter = NetworkEventReporterImpl.get();
  private final AtomicInteger mNextRequestId = new AtomicInteger(0);
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    String str = String.valueOf(this.mNextRequestId.getAndIncrement());
    Object localObject4 = paramChain.request();
    Object localObject3 = null;
    Object localObject1;
    if (this.mEventReporter.isEnabled())
    {
      localObject3 = new RequestBodyHelper(this.mEventReporter, str);
      localObject1 = new OkHttpInspectorRequest(str, (Request)localObject4, (RequestBodyHelper)localObject3);
      this.mEventReporter.requestWillBeSent((NetworkEventReporter.InspectorRequest)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = paramChain.proceed((Request)localObject4);
        localObject2 = localObject1;
        if (this.mEventReporter.isEnabled())
        {
          if ((localObject3 != null) && (((RequestBodyHelper)localObject3).hasBody())) {
            ((RequestBodyHelper)localObject3).reportDataSent();
          }
          paramChain = paramChain.connection();
          this.mEventReporter.responseHeadersReceived(new OkHttpInspectorResponse(str, (Request)localObject4, (Response)localObject1, paramChain));
          localObject3 = ((Response)localObject1).body();
          localObject2 = null;
          paramChain = null;
          if (localObject3 != null)
          {
            localObject2 = ((ResponseBody)localObject3).contentType();
            paramChain = ((ResponseBody)localObject3).byteStream();
          }
          localObject4 = this.mEventReporter;
          if (localObject2 == null) {
            break label276;
          }
          localObject2 = ((MediaType)localObject2).toString();
          paramChain = ((NetworkEventReporter)localObject4).interpretResponseStream(str, (String)localObject2, ((Response)localObject1).header("Content-Encoding"), paramChain, new DefaultResponseHandler(this.mEventReporter, str));
          localObject2 = localObject1;
          if (paramChain != null) {
            localObject2 = ((Response)localObject1).newBuilder().body(new ForwardingResponseBody((ResponseBody)localObject3, paramChain)).build();
          }
        }
        return (Response)localObject2;
      }
      catch (IOException paramChain)
      {
        if (this.mEventReporter.isEnabled()) {
          this.mEventReporter.httpExchangeFailed(str, paramChain.toString());
        }
        throw paramChain;
      }
      label276:
      Object localObject2 = null;
    }
  }
  
  private static class ForwardingResponseBody
    extends ResponseBody
  {
    private final ResponseBody mBody;
    private final BufferedSource mInterceptedSource;
    
    public ForwardingResponseBody(ResponseBody paramResponseBody, InputStream paramInputStream)
    {
      this.mBody = paramResponseBody;
      this.mInterceptedSource = Okio.buffer(Okio.source(paramInputStream));
    }
    
    public long contentLength()
    {
      try
      {
        long l = this.mBody.contentLength();
        return l;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      return 0L;
    }
    
    public MediaType contentType()
    {
      return this.mBody.contentType();
    }
    
    public BufferedSource source()
    {
      return this.mInterceptedSource;
    }
  }
  
  private static class OkHttpInspectorRequest
    implements NetworkEventReporter.InspectorRequest
  {
    private final Request mRequest;
    private RequestBodyHelper mRequestBodyHelper;
    private final String mRequestId;
    
    public OkHttpInspectorRequest(String paramString, Request paramRequest, RequestBodyHelper paramRequestBodyHelper)
    {
      this.mRequestId = paramString;
      this.mRequest = paramRequest;
      this.mRequestBodyHelper = paramRequestBodyHelper;
    }
    
    @Nullable
    public byte[] body()
      throws IOException
    {
      RequestBody localRequestBody = this.mRequest.body();
      if (localRequestBody == null) {
        return null;
      }
      BufferedSink localBufferedSink = Okio.buffer(Okio.sink(this.mRequestBodyHelper.createBodySink(firstHeaderValue("Content-Encoding"))));
      try
      {
        localRequestBody.writeTo(localBufferedSink);
        return this.mRequestBodyHelper.getDisplayBody();
      }
      finally
      {
        localBufferedSink.close();
      }
    }
    
    @Nullable
    public String firstHeaderValue(String paramString)
    {
      return this.mRequest.header(paramString);
    }
    
    public String friendlyName()
    {
      return null;
    }
    
    @Nullable
    public Integer friendlyNameExtra()
    {
      return null;
    }
    
    public int headerCount()
    {
      return this.mRequest.headers().size();
    }
    
    public String headerName(int paramInt)
    {
      return this.mRequest.headers().name(paramInt);
    }
    
    public String headerValue(int paramInt)
    {
      return this.mRequest.headers().value(paramInt);
    }
    
    public String id()
    {
      return this.mRequestId;
    }
    
    public String method()
    {
      return this.mRequest.method();
    }
    
    public String url()
    {
      return this.mRequest.urlString();
    }
  }
  
  private static class OkHttpInspectorResponse
    implements NetworkEventReporter.InspectorResponse
  {
    private final Connection mConnection;
    private final Request mRequest;
    private final String mRequestId;
    private final Response mResponse;
    
    public OkHttpInspectorResponse(String paramString, Request paramRequest, Response paramResponse, Connection paramConnection)
    {
      this.mRequestId = paramString;
      this.mRequest = paramRequest;
      this.mResponse = paramResponse;
      this.mConnection = paramConnection;
    }
    
    public int connectionId()
    {
      return this.mConnection.hashCode();
    }
    
    public boolean connectionReused()
    {
      return false;
    }
    
    @Nullable
    public String firstHeaderValue(String paramString)
    {
      return this.mResponse.header(paramString);
    }
    
    public boolean fromDiskCache()
    {
      return this.mResponse.cacheResponse() != null;
    }
    
    public int headerCount()
    {
      return this.mResponse.headers().size();
    }
    
    public String headerName(int paramInt)
    {
      return this.mResponse.headers().name(paramInt);
    }
    
    public String headerValue(int paramInt)
    {
      return this.mResponse.headers().value(paramInt);
    }
    
    public String reasonPhrase()
    {
      return this.mResponse.message();
    }
    
    public String requestId()
    {
      return this.mRequestId;
    }
    
    public int statusCode()
    {
      return this.mResponse.code();
    }
    
    public String url()
    {
      return this.mRequest.urlString();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\okhttp\StethoInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */