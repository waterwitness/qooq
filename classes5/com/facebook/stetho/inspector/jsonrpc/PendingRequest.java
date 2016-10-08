package com.facebook.stetho.inspector.jsonrpc;

import javax.annotation.Nullable;

public class PendingRequest
{
  @Nullable
  public final PendingRequestCallback callback;
  public final long requestId;
  
  public PendingRequest(long paramLong, @Nullable PendingRequestCallback paramPendingRequestCallback)
  {
    this.requestId = paramLong;
    this.callback = paramPendingRequestCallback;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\PendingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */