package com.facebook.react.modules.network;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import javax.annotation.Nullable;

public final class NetworkingModule
  extends ReactContextBaseJavaModule
{
  private static final int CHUNK_TIMEOUT_NS = 100000000;
  private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
  private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
  private static final int MAX_BUFFER_SIZE = 524288;
  private static final int MIN_BUFFER_SIZE = 8192;
  private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
  private static final String REQUEST_BODY_KEY_STRING = "string";
  private static final String REQUEST_BODY_KEY_URI = "uri";
  private static final String USER_AGENT_HEADER_NAME = "user-agent";
  private final OkHttpClient mClient;
  @Nullable
  private final String mDefaultUserAgent;
  private boolean mShuttingDown;
  
  public NetworkingModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext, null, OkHttpClientProvider.getOkHttpClient());
  }
  
  public NetworkingModule(ReactApplicationContext paramReactApplicationContext, OkHttpClient paramOkHttpClient)
  {
    this(paramReactApplicationContext, null, paramOkHttpClient);
  }
  
  public NetworkingModule(ReactApplicationContext paramReactApplicationContext, String paramString)
  {
    this(paramReactApplicationContext, paramString, OkHttpClientProvider.getOkHttpClient());
  }
  
  NetworkingModule(ReactApplicationContext paramReactApplicationContext, @Nullable String paramString, OkHttpClient paramOkHttpClient)
  {
    super(paramReactApplicationContext);
    this.mClient = paramOkHttpClient;
    this.mClient.networkInterceptors().add(new StethoInterceptor());
    this.mShuttingDown = false;
    this.mDefaultUserAgent = paramString;
  }
  
  @Nullable
  private MultipartBuilder constructMultipartBody(ReadableArray paramReadableArray, String paramString, int paramInt)
  {
    MultipartBuilder localMultipartBuilder = new MultipartBuilder();
    localMultipartBuilder.type(MediaType.parse(paramString));
    int i = 0;
    int j = paramReadableArray.size();
    paramString = localMultipartBuilder;
    Object localObject2;
    Object localObject1;
    if (i < j)
    {
      localObject2 = paramReadableArray.getMap(i);
      localObject1 = extractHeaders(((ReadableMap)localObject2).getArray("headers"), null);
      if (localObject1 == null)
      {
        onRequestError(paramInt, "Missing or invalid header format for FormData part.");
        paramString = null;
      }
    }
    else
    {
      return paramString;
    }
    MediaType localMediaType = null;
    String str = ((Headers)localObject1).get("content-type");
    paramString = (String)localObject1;
    if (str != null)
    {
      localMediaType = MediaType.parse(str);
      paramString = ((Headers)localObject1).newBuilder().removeAll("content-type").build();
    }
    if (((ReadableMap)localObject2).hasKey("string")) {
      localMultipartBuilder.addPart(paramString, RequestBody.create(localMediaType, ((ReadableMap)localObject2).getString("string")));
    }
    for (;;)
    {
      i += 1;
      break;
      if (((ReadableMap)localObject2).hasKey("uri"))
      {
        if (localMediaType == null)
        {
          onRequestError(paramInt, "Binary FormData part needs a content-type header.");
          return null;
        }
        localObject1 = ((ReadableMap)localObject2).getString("uri");
        localObject2 = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), (String)localObject1);
        if (localObject2 == null)
        {
          onRequestError(paramInt, "Could not retrieve file for uri " + (String)localObject1);
          return null;
        }
        localMultipartBuilder.addPart(paramString, RequestBodyUtil.create(localMediaType, (InputStream)localObject2));
      }
      else
      {
        onRequestError(paramInt, "Unrecognized FormData part.");
      }
    }
  }
  
  @Nullable
  private Headers extractHeaders(@Nullable ReadableArray paramReadableArray, @Nullable ReadableMap paramReadableMap)
  {
    int j = 1;
    if (paramReadableArray == null) {
      return null;
    }
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int k = paramReadableArray.size();
    for (;;)
    {
      if (i >= k) {
        break label91;
      }
      ReadableArray localReadableArray = paramReadableArray.getArray(i);
      if ((localReadableArray == null) || (localReadableArray.size() != 2)) {
        break;
      }
      localBuilder.add(localReadableArray.getString(0), localReadableArray.getString(1));
      i += 1;
    }
    label91:
    if ((localBuilder.get("user-agent") == null) && (this.mDefaultUserAgent != null)) {
      localBuilder.add("user-agent", this.mDefaultUserAgent);
    }
    if ((paramReadableMap != null) && (paramReadableMap.hasKey("string"))) {}
    for (i = j;; i = 0)
    {
      if (i == 0) {
        localBuilder.removeAll("content-encoding");
      }
      return localBuilder.build();
    }
  }
  
  private static int getBufferSize(ResponseBody paramResponseBody)
    throws IOException
  {
    long l = paramResponseBody.contentLength();
    if (l == -1L) {
      return 8192;
    }
    return (int)Math.min(l, 524288L);
  }
  
  private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter()
  {
    return (DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
  }
  
  private void onDataReceived(int paramInt, String paramString)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushString(paramString);
    getEventEmitter().emit("didReceiveNetworkData", localWritableArray);
  }
  
  private void onRequestError(int paramInt, String paramString)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushString(paramString);
    getEventEmitter().emit("didCompleteNetworkResponse", localWritableArray);
  }
  
  private void onRequestSuccess(int paramInt)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushNull();
    getEventEmitter().emit("didCompleteNetworkResponse", localWritableArray);
  }
  
  private void onResponseReceived(int paramInt, Response paramResponse)
  {
    WritableMap localWritableMap = translateHeaders(paramResponse.headers());
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushInt(paramResponse.code());
    localWritableArray.pushMap(localWritableMap);
    getEventEmitter().emit("didReceiveNetworkResponse", localWritableArray);
  }
  
  private void readWithProgress(int paramInt, ResponseBody paramResponseBody)
    throws IOException
  {
    Reader localReader = paramResponseBody.charStream();
    try
    {
      paramResponseBody = new StringBuilder(getBufferSize(paramResponseBody));
      char[] arrayOfChar = new char[' '];
      long l1 = System.nanoTime();
      for (;;)
      {
        int i = localReader.read(arrayOfChar);
        if (i == -1) {
          break;
        }
        paramResponseBody.append(arrayOfChar, 0, i);
        long l2 = System.nanoTime();
        if (shouldDispatch(l2, l1))
        {
          onDataReceived(paramInt, paramResponseBody.toString());
          paramResponseBody.setLength(0);
          l1 = l2;
        }
      }
      if (paramResponseBody.length() > 0) {
        onDataReceived(paramInt, paramResponseBody.toString());
      }
      return;
    }
    finally
    {
      localReader.close();
    }
  }
  
  private static boolean shouldDispatch(long paramLong1, long paramLong2)
  {
    return 100000000L + paramLong2 < paramLong1;
  }
  
  private static WritableMap translateHeaders(Headers paramHeaders)
  {
    WritableMap localWritableMap = Arguments.createMap();
    int i = 0;
    if (i < paramHeaders.size())
    {
      String str = paramHeaders.name(i);
      if (localWritableMap.hasKey(str)) {
        localWritableMap.putString(str, localWritableMap.getString(str) + ", " + paramHeaders.value(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localWritableMap.putString(str, paramHeaders.value(i));
      }
    }
    return localWritableMap;
  }
  
  @ReactMethod
  public void abortRequest(final int paramInt)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void... paramAnonymousVarArgs)
      {
        NetworkingModule.this.mClient.cancel(Integer.valueOf(paramInt));
      }
    }.execute(new Void[0]);
  }
  
  @ReactMethod
  public void clearCookies(com.facebook.react.bridge.Callback paramCallback) {}
  
  public String getName()
  {
    return "RCTNetworking";
  }
  
  public void initialize() {}
  
  public void onCatalystInstanceDestroy()
  {
    this.mShuttingDown = true;
    this.mClient.cancel(null);
    this.mClient.setCookieHandler(null);
  }
  
  @ReactMethod
  public void sendRequest(String paramString1, String paramString2, final int paramInt, ReadableArray paramReadableArray, ReadableMap paramReadableMap, final boolean paramBoolean)
  {
    Request.Builder localBuilder = new Request.Builder().url(paramString2);
    if (paramInt != 0) {
      localBuilder.tag(Integer.valueOf(paramInt));
    }
    Headers localHeaders = extractHeaders(paramReadableArray, paramReadableMap);
    if (localHeaders == null)
    {
      onRequestError(paramInt, "Unrecognized headers format");
      return;
    }
    paramReadableArray = localHeaders.get("content-type");
    paramString2 = localHeaders.get("content-encoding");
    localBuilder.headers(localHeaders);
    if (paramReadableMap == null) {
      localBuilder.method(paramString1, null);
    }
    for (;;)
    {
      this.mClient.newCall(localBuilder.build()).enqueue(new com.squareup.okhttp.Callback()
      {
        public void onFailure(Request paramAnonymousRequest, IOException paramAnonymousIOException)
        {
          if (NetworkingModule.this.mShuttingDown) {
            return;
          }
          NetworkingModule.this.onRequestError(paramInt, paramAnonymousIOException.getMessage());
        }
        
        public void onResponse(Response paramAnonymousResponse)
          throws IOException
        {
          if (NetworkingModule.this.mShuttingDown) {
            return;
          }
          NetworkingModule.this.onResponseReceived(paramInt, paramAnonymousResponse);
          paramAnonymousResponse = paramAnonymousResponse.body();
          try
          {
            if (paramBoolean)
            {
              NetworkingModule.this.readWithProgress(paramInt, paramAnonymousResponse);
              NetworkingModule.this.onRequestSuccess(paramInt);
              return;
            }
          }
          catch (IOException paramAnonymousResponse)
          {
            NetworkingModule.this.onRequestError(paramInt, paramAnonymousResponse.getMessage());
            return;
          }
          NetworkingModule.this.onDataReceived(paramInt, paramAnonymousResponse.string());
          NetworkingModule.this.onRequestSuccess(paramInt);
        }
      });
      return;
      if (paramReadableMap.hasKey("string"))
      {
        if (paramReadableArray == null)
        {
          onRequestError(paramInt, "Payload is set but no content-type header specified");
          return;
        }
        paramReadableMap = paramReadableMap.getString("string");
        paramReadableArray = MediaType.parse(paramReadableArray);
        if (RequestBodyUtil.isGzipEncoding(paramString2))
        {
          paramString2 = RequestBodyUtil.createGzip(paramReadableArray, paramReadableMap);
          if (paramString2 == null)
          {
            onRequestError(paramInt, "Failed to gzip request body");
            return;
          }
          localBuilder.method(paramString1, paramString2);
        }
        else
        {
          localBuilder.method(paramString1, RequestBody.create(paramReadableArray, paramReadableMap));
        }
      }
      else if (paramReadableMap.hasKey("uri"))
      {
        if (paramReadableArray == null)
        {
          onRequestError(paramInt, "Payload is set but no content-type header specified");
          return;
        }
        paramString2 = paramReadableMap.getString("uri");
        paramReadableMap = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), paramString2);
        if (paramReadableMap == null)
        {
          onRequestError(paramInt, "Could not retrieve file for uri " + paramString2);
          return;
        }
        localBuilder.method(paramString1, RequestBodyUtil.create(MediaType.parse(paramReadableArray), paramReadableMap));
      }
      else
      {
        if (paramReadableMap.hasKey("formData"))
        {
          paramString2 = paramReadableArray;
          if (paramReadableArray == null) {
            paramString2 = "multipart/form-data";
          }
          paramString2 = constructMultipartBody(paramReadableMap.getArray("formData"), paramString2, paramInt);
          if (paramString2 == null) {
            break;
          }
          localBuilder.method(paramString1, paramString2.build());
          continue;
        }
        localBuilder.method(paramString1, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\network\NetworkingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */