package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PeersRegisteredListener
  implements PeerRegistrationListener
{
  private AtomicInteger mPeers = new AtomicInteger(0);
  
  protected abstract void onFirstPeerRegistered();
  
  protected abstract void onLastPeerUnregistered();
  
  protected void onPeerAdded(JsonRpcPeer paramJsonRpcPeer) {}
  
  public final void onPeerRegistered(JsonRpcPeer paramJsonRpcPeer)
  {
    if (this.mPeers.incrementAndGet() == 1) {
      onFirstPeerRegistered();
    }
    onPeerAdded(paramJsonRpcPeer);
  }
  
  protected void onPeerRemoved(JsonRpcPeer paramJsonRpcPeer) {}
  
  public final void onPeerUnregistered(JsonRpcPeer paramJsonRpcPeer)
  {
    if (this.mPeers.decrementAndGet() == 0) {
      onLastPeerUnregistered();
    }
    onPeerRemoved(paramJsonRpcPeer);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\helper\PeersRegisteredListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */