package com.facebook.stetho.inspector.jsonrpc;

import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse;

public abstract interface PendingRequestCallback
{
  public abstract void onResponse(JsonRpcPeer paramJsonRpcPeer, JsonRpcResponse paramJsonRpcResponse);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\PendingRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */