package com.facebook.stetho.inspector.network;

import android.content.Context;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import javax.annotation.Nullable;

public class NetworkPeerManager
  extends ChromePeerManager
{
  private static NetworkPeerManager sInstance;
  private AsyncPrettyPrinterRegistry mAsyncPrettyPrinterRegistry;
  private AsyncPrettyPrinterInitializer mPrettyPrinterInitializer;
  private final ResponseBodyFileManager mResponseBodyFileManager;
  private final PeersRegisteredListener mTempFileCleanup = new PeersRegisteredListener()
  {
    protected void onFirstPeerRegistered()
    {
      
      if ((NetworkPeerManager.this.mAsyncPrettyPrinterRegistry == null) && (NetworkPeerManager.this.mPrettyPrinterInitializer != null))
      {
        NetworkPeerManager.this.mAsyncPrettyPrinterRegistry = new AsyncPrettyPrinterRegistry();
        NetworkPeerManager.this.mPrettyPrinterInitializer.populatePrettyPrinters(NetworkPeerManager.this.mAsyncPrettyPrinterRegistry);
      }
      NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
    }
    
    protected void onLastPeerUnregistered()
    {
      NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
      AsyncPrettyPrinterExecutorHolder.shutdown();
    }
  };
  
  public NetworkPeerManager(ResponseBodyFileManager paramResponseBodyFileManager)
  {
    this.mResponseBodyFileManager = paramResponseBodyFileManager;
    setListener(this.mTempFileCleanup);
  }
  
  @Nullable
  public static NetworkPeerManager getInstanceOrNull()
  {
    try
    {
      NetworkPeerManager localNetworkPeerManager = sInstance;
      return localNetworkPeerManager;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static NetworkPeerManager getOrCreateInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NetworkPeerManager(new ResponseBodyFileManager(paramContext.getApplicationContext()));
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  @Nullable
  public AsyncPrettyPrinterRegistry getAsyncPrettyPrinterRegistry()
  {
    return this.mAsyncPrettyPrinterRegistry;
  }
  
  public ResponseBodyFileManager getResponseBodyFileManager()
  {
    return this.mResponseBodyFileManager;
  }
  
  public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer paramAsyncPrettyPrinterInitializer)
  {
    Util.throwIfNotNull(this.mPrettyPrinterInitializer);
    this.mPrettyPrinterInitializer = ((AsyncPrettyPrinterInitializer)Util.throwIfNull(paramAsyncPrettyPrinterInitializer));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\NetworkPeerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */