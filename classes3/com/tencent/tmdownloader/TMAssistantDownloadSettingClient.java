package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tmassistant.aidl.a;
import com.tencent.tmassistant.aidl.d;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistant.common.b;
import com.tencent.tmassistantbase.a.m;

public class TMAssistantDownloadSettingClient
  extends b
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
  protected static final String TAG = "TMAssistantDownloadSettingClient";
  
  public TMAssistantDownloadSettingClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmdownloader.TMAssistantDownloadService");
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
  }
  
  /* Error */
  public int getVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 43	com/tencent/tmassistant/common/b:getServiceInterface	()Landroid/os/IInterface;
    //   6: checkcast 45	com/tencent/tmassistant/aidl/d
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +14 -> 25
    //   14: aload_1
    //   15: invokeinterface 48 1 0
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: aload_0
    //   26: invokespecial 52	com/tencent/tmassistant/common/b:initTMAssistantDownloadSDK	()Z
    //   29: pop
    //   30: iconst_0
    //   31: istore_2
    //   32: goto -11 -> 21
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	TMAssistantDownloadSettingClient
    //   9	6	1	locald	d
    //   35	4	1	localObject	Object
    //   20	12	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	35	finally
    //   14	21	35	finally
    //   25	30	35	finally
  }
  
  /* Error */
  public boolean isAllDownloadFinished()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 55
    //   6: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokespecial 43	com/tencent/tmassistant/common/b:getServiceInterface	()Landroid/os/IInterface;
    //   13: checkcast 45	com/tencent/tmassistant/aidl/d
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +52 -> 70
    //   21: aload_1
    //   22: invokeinterface 64 1 0
    //   27: istore_2
    //   28: ldc 11
    //   30: ldc 65
    //   32: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc 11
    //   37: new 67	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   44: ldc 72
    //   46: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_2
    //   50: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 11
    //   61: ldc 85
    //   63: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: iload_2
    //   69: ireturn
    //   70: aload_0
    //   71: invokespecial 52	com/tencent/tmassistant/common/b:initTMAssistantDownloadSDK	()Z
    //   74: pop
    //   75: ldc 11
    //   77: ldc 86
    //   79: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: iconst_0
    //   83: istore_2
    //   84: goto -49 -> 35
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	TMAssistantDownloadSettingClient
    //   16	6	1	locald	d
    //   87	4	1	localObject	Object
    //   27	57	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	87	finally
    //   21	35	87	finally
    //   35	66	87	finally
    //   70	82	87	finally
  }
  
  protected void onDownloadSDKServiceInvalid() {}
  
  protected void registerServiceCallback()
  {
    ((d)this.mServiceInterface).a(this.mClientKey, (a)this.mServiceCallback);
  }
  
  public void setDownloadSDKMaxTaskNum(int paramInt)
  {
    for (;;)
    {
      try
      {
        m.c("TMAssistantDownloadSettingClient", "enter");
        m.c("TMAssistantDownloadSettingClient", "maxTaskNum: " + paramInt);
        if ((paramInt < 1) || (paramInt > 10))
        {
          m.c("TMAssistantDownloadSettingClient", "maxTaskNum < 1 || maxTaskNum > 10");
          m.c("TMAssistantDownloadSettingClient", "exit");
          return;
        }
        d locald = (d)super.getServiceInterface();
        if (locald != null)
        {
          locald.a(paramInt);
          m.c("TMAssistantDownloadSettingClient", "setServiceSetingMaxTaskNum");
          m.c("TMAssistantDownloadSettingClient", "exit");
          continue;
        }
        super.initTMAssistantDownloadSDK();
      }
      finally {}
      m.c("TMAssistantDownloadSettingClient", "initTMAssistantDownloadSDK");
    }
  }
  
  /* Error */
  public void setDownloadSDKWifiOnly(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 55
    //   6: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: ldc 11
    //   11: new 67	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   18: ldc 120
    //   20: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokespecial 43	com/tencent/tmassistant/common/b:getServiceInterface	()Landroid/os/IInterface;
    //   37: checkcast 45	com/tencent/tmassistant/aidl/d
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +27 -> 69
    //   45: aload_2
    //   46: iload_1
    //   47: invokeinterface 122 2 0
    //   52: ldc 11
    //   54: ldc 124
    //   56: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 11
    //   61: ldc 85
    //   63: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: aload_0
    //   70: invokespecial 52	com/tencent/tmassistant/common/b:initTMAssistantDownloadSDK	()Z
    //   73: pop
    //   74: ldc 11
    //   76: ldc 86
    //   78: invokestatic 61	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: goto -22 -> 59
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	TMAssistantDownloadSettingClient
    //   0	89	1	paramBoolean	boolean
    //   40	6	2	locald	d
    //   84	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	41	84	finally
    //   45	59	84	finally
    //   59	66	84	finally
    //   69	81	84	finally
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = e.a(paramIBinder);
  }
  
  protected void unRegisterServiceCallback()
  {
    ((d)this.mServiceInterface).b(this.mClientKey, (a)this.mServiceCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\TMAssistantDownloadSettingClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */