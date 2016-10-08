package com.tencent.tmassistantsdk.internal.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.assistant.sdk.remote.BaseService;
import com.tencent.assistant.sdk.remote.BaseService.Stub;
import com.tencent.assistant.sdk.remote.SDKActionCallback;
import com.tencent.tmassistantbase.a.e;
import com.tencent.tmassistantbase.a.m;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  extends com.tencent.tmassistant.common.b
{
  protected boolean a = false;
  protected int b = 0;
  ArrayList<a> c = new ArrayList();
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    this.mServiceCallback = new c(this);
  }
  
  public void a(a parama)
  {
    m.c("TMAssistantDownloadOpenSDKClient", "addAssistantOnActionListener");
    if ((parama != null) && (!this.c.contains(parama))) {
      this.c.add(parama);
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      BaseService localBaseService = (BaseService)super.getServiceInterface();
      if (localBaseService != null) {
        return localBaseService.sendSyncData(this.mClientKey, paramArrayOfByte);
      }
      super.initTMAssistantDownloadSDK();
      m.c("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK");
    }
    return null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    m.c("TMAssistantDownloadOpenSDKClient", "sendAsyncData");
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      BaseService localBaseService = (BaseService)super.getServiceInterface();
      m.c("TMAssistantDownloadOpenSDKClient", "sendAsyncData baseService:" + localBaseService);
      if (localBaseService != null)
      {
        m.c("TMAssistantDownloadOpenSDKClient", "baseService sendAsyncData");
        localBaseService.sendAsyncData(this.mClientKey, paramArrayOfByte);
      }
    }
    else
    {
      return;
    }
    super.initTMAssistantDownloadSDK();
    m.c("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK");
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mDwonloadServiceName).setClassName("com.tencent.android.qqdownloader", "com.tencent.assistant.sdk.SDKSupportService");
  }
  
  /* Error */
  public boolean initTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 83	com/tencent/tmassistant/common/b:initTMAssistantDownloadSDK	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +78 -> 86
    //   11: new 112	android/content/Intent
    //   14: dup
    //   15: invokespecial 129	android/content/Intent:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: ldc 120
    //   22: ldc -125
    //   24: invokevirtual 126	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   27: pop
    //   28: aload_1
    //   29: ldc -124
    //   31: invokevirtual 136	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   34: pop
    //   35: aload_0
    //   36: getfield 41	com/tencent/tmassistantsdk/internal/b/b:mContext	Landroid/content/Context;
    //   39: aload_1
    //   40: invokevirtual 142	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   43: new 144	android/os/HandlerThread
    //   46: dup
    //   47: ldc -110
    //   49: invokespecial 147	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 150	android/os/HandlerThread:start	()V
    //   57: new 152	android/os/Handler
    //   60: dup
    //   61: aload_1
    //   62: invokevirtual 156	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   65: invokespecial 159	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   68: astore_1
    //   69: aload_1
    //   70: new 161	com/tencent/tmassistantsdk/internal/b/d
    //   73: dup
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 164	com/tencent/tmassistantsdk/internal/b/d:<init>	(Lcom/tencent/tmassistantsdk/internal/b/b;Landroid/os/Handler;)V
    //   79: ldc2_w 165
    //   82: invokevirtual 170	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   85: pop
    //   86: aload_0
    //   87: monitorexit
    //   88: iload_2
    //   89: ireturn
    //   90: astore_1
    //   91: ldc 44
    //   93: ldc -84
    //   95: aload_1
    //   96: invokestatic 175	com/tencent/tmassistantbase/a/m:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: goto -56 -> 43
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	b
    //   18	58	1	localObject1	Object
    //   90	6	1	localException	Exception
    //   102	4	1	localObject2	Object
    //   6	83	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	43	90	java/lang/Exception
    //   2	7	102	finally
    //   11	43	102	finally
    //   43	86	102	finally
    //   91	99	102	finally
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    if ((this.c != null) && (this.c.size() > 0))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.a();
        }
      }
    }
  }
  
  protected void registerServiceCallback()
  {
    Object localObject = String.valueOf(System.currentTimeMillis()).getBytes();
    localObject = com.tencent.tmassistantbase.a.a.b(new e().b((byte[])localObject, this.mClientKey.getBytes()), 0);
    int i = ((BaseService)this.mServiceInterface).registerActionCallback(this.mClientKey, (String)localObject, (SDKActionCallback)this.mServiceCallback);
    m.c("TMAssistantDownloadOpenSDKClient", "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + (String)localObject + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + i);
    if (i == 2) {
      onDownloadSDKServiceInvalid();
    }
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = BaseService.Stub.asInterface(paramIBinder);
  }
  
  protected void unRegisterServiceCallback()
  {
    if (((BaseService)this.mServiceInterface).unregisterActionCallback((SDKActionCallback)this.mServiceCallback) == 2) {
      onDownloadSDKServiceInvalid();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */