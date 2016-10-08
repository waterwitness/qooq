package com.tencent.tmassistant.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.tmassistantbase.a.m;

public abstract class b
  implements ServiceConnection
{
  public static final String CONNTECTSTATE_CONNECTING = "CONNECTING";
  public static final String CONNTECTSTATE_FINISH = "FINISH";
  public static final String CONNTECTSTATE_INIT = "INIT";
  protected static final String TAG = "TMAssistantDownloadSDKClientBase";
  protected String connectState = "INIT";
  public String mClientKey;
  protected Context mContext;
  protected String mDwonloadServiceName = null;
  protected IInterface mServiceCallback = null;
  protected IInterface mServiceInterface = null;
  protected final Object mThreadlock = new Object();
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mClientKey = paramString1;
    this.mDwonloadServiceName = paramString2;
  }
  
  protected abstract Intent getBindServiceIntent();
  
  protected IInterface getServiceInterface()
  {
    if ((this.mContext != null) && (this.mContext.getMainLooper().getThread().getId() == Thread.currentThread().getId())) {
      throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
    if (this.mServiceInterface == null)
    {
      initTMAssistantDownloadSDK();
      this.connectState = "CONNECTING";
    }
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.wait(10000L);
      if (this.mServiceInterface == null) {
        throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
      }
    }
    return this.mServiceInterface;
  }
  
  public boolean initTMAssistantDownloadSDK()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        String str = this.connectState;
        if (str == "FINISH") {
          return bool1;
        }
        m.c("TMAssistantDownloadSDKClientBase", "initTMAssistantDownloadSDK,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
        this.connectState = "INIT";
        if (this.mServiceInterface != null)
        {
          this.connectState = "FINISH";
          continue;
        }
        bool2 = false;
      }
      finally {}
      boolean bool2;
      boolean bool3 = false;
      bool1 = bool3;
      if (this.mContext == null) {
        continue;
      }
      Object localObject2 = this.mDwonloadServiceName;
      bool1 = bool3;
      if (localObject2 == null) {
        continue;
      }
      try
      {
        localObject2 = getBindServiceIntent();
        bool1 = this.mContext.bindService((Intent)localObject2, this, 1);
        m.c("TMAssistantDownloadSDKClientBase", "initTMAssistantDownloadSDK bindResult:" + bool1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          bool1 = bool2;
        }
      }
    }
  }
  
  protected abstract void onDownloadSDKServiceInvalid();
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    stubAsInterface(paramIBinder);
    this.connectState = "FINISH";
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.notifyAll();
      m.c("TMAssistantDownloadSDKClientBase", "onServiceConnected,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",IBinder:" + paramIBinder + ",threadId:" + Thread.currentThread().getId());
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName arg1)
  {
    // Byte code:
    //   0: ldc 19
    //   2: new 95	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   9: ldc -95
    //   11: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 48	com/tencent/tmassistant/common/b:mClientKey	Ljava/lang/String;
    //   18: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 122	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: monitorenter
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   34: aload_0
    //   35: ldc 16
    //   37: putfield 38	com/tencent/tmassistant/common/b:connectState	Ljava/lang/String;
    //   40: aload_0
    //   41: getfield 44	com/tencent/tmassistant/common/b:mThreadlock	Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 44	com/tencent/tmassistant/common/b:mThreadlock	Ljava/lang/Object;
    //   51: invokevirtual 148	java/lang/Object:notifyAll	()V
    //   54: aload_1
    //   55: monitorexit
    //   56: aload_0
    //   57: invokevirtual 157	com/tencent/tmassistant/common/b:onDownloadSDKServiceInvalid	()V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_2
    //   64: aload_1
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	b
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	56	63	finally
    //   64	66	63	finally
    //   29	47	68	finally
    //   56	62	68	finally
    //   66	68	68	finally
    //   69	71	68	finally
  }
  
  protected abstract void registerServiceCallback();
  
  protected abstract void stubAsInterface(IBinder paramIBinder);
  
  /* Error */
  public void unInitTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 19
    //   4: new 95	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   11: ldc -92
    //   13: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 48	com/tencent/tmassistant/common/b:mClientKey	Ljava/lang/String;
    //   20: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 104
    //   25: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   32: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: ldc 109
    //   37: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 74	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   43: invokevirtual 71	java/lang/Thread:getId	()J
    //   46: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 122	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   59: ifnull +16 -> 75
    //   62: aload_0
    //   63: getfield 42	com/tencent/tmassistant/common/b:mServiceCallback	Landroid/os/IInterface;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 167	com/tencent/tmassistant/common/b:unRegisterServiceCallback	()V
    //   75: aload_0
    //   76: getfield 46	com/tencent/tmassistant/common/b:mContext	Landroid/content/Context;
    //   79: ifnull +22 -> 101
    //   82: aload_0
    //   83: ifnull +18 -> 101
    //   86: aload_0
    //   87: getfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   90: ifnull +11 -> 101
    //   93: aload_0
    //   94: getfield 46	com/tencent/tmassistant/common/b:mContext	Landroid/content/Context;
    //   97: aload_0
    //   98: invokevirtual 171	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 42	com/tencent/tmassistant/common/b:mServiceCallback	Landroid/os/IInterface;
    //   111: aload_0
    //   112: ldc 16
    //   114: putfield 38	com/tencent/tmassistant/common/b:connectState	Ljava/lang/String;
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: astore_1
    //   121: goto -46 -> 75
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	b
    //   66	2	1	localIInterface	IInterface
    //   120	1	1	localRemoteException	RemoteException
    //   124	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   71	75	120	android/os/RemoteException
    //   2	67	124	finally
    //   71	75	124	finally
    //   75	82	124	finally
    //   86	101	124	finally
    //   101	117	124	finally
  }
  
  protected abstract void unRegisterServiceCallback();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistant\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */