package com.facebook.stetho.inspector.network;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

public abstract interface NetworkEventReporter
{
  public abstract void dataReceived(String paramString, int paramInt1, int paramInt2);
  
  public abstract void dataSent(String paramString, int paramInt1, int paramInt2);
  
  public abstract void httpExchangeFailed(String paramString1, String paramString2);
  
  @Nullable
  public abstract InputStream interpretResponseStream(String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable InputStream paramInputStream, ResponseHandler paramResponseHandler);
  
  public abstract boolean isEnabled();
  
  public abstract void requestWillBeSent(InspectorRequest paramInspectorRequest);
  
  public abstract void responseHeadersReceived(InspectorResponse paramInspectorResponse);
  
  public abstract void responseReadFailed(String paramString1, String paramString2);
  
  public abstract void responseReadFinished(String paramString);
  
  public static abstract interface InspectorHeaders
  {
    @Nullable
    public abstract String firstHeaderValue(String paramString);
    
    public abstract int headerCount();
    
    public abstract String headerName(int paramInt);
    
    public abstract String headerValue(int paramInt);
  }
  
  public static abstract interface InspectorRequest
    extends NetworkEventReporter.InspectorHeaders
  {
    @Nullable
    public abstract byte[] body()
      throws IOException;
    
    public abstract String friendlyName();
    
    @Nullable
    public abstract Integer friendlyNameExtra();
    
    public abstract String id();
    
    public abstract String method();
    
    public abstract String url();
  }
  
  public static abstract interface InspectorResponse
    extends NetworkEventReporter.InspectorHeaders
  {
    public abstract int connectionId();
    
    public abstract boolean connectionReused();
    
    public abstract boolean fromDiskCache();
    
    public abstract String reasonPhrase();
    
    public abstract String requestId();
    
    public abstract int statusCode();
    
    public abstract String url();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\NetworkEventReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */