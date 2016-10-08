package com.tencent.tmdownloader;

import android.content.Context;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadManager
{
  protected static final String TAG = "TMAssistantDownloadManager";
  protected static TMAssistantDownloadManager mInstance = null;
  protected static ArrayList<TMAssistantDownloadClient> mSDKClientList = new ArrayList();
  protected static TMAssistantDownloadSettingClient mSDKSettingClient = null;
  protected Context mContext = null;
  
  protected TMAssistantDownloadManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static void closeAllService(Context paramContext)
  {
    for (;;)
    {
      try
      {
        m.c("TMAssistantDownloadManager", "enter");
        if (paramContext == null)
        {
          m.c("TMAssistantDownloadManager", "you must input an application or activity context!");
          m.c("TMAssistantDownloadManager", "exit");
          return;
        }
        if (mInstance == null)
        {
          m.c("TMAssistantDownloadManager", "manager minstance == null");
          m.c("TMAssistantDownloadManager", "exit");
          continue;
        }
        if (mSDKClientList == null) {
          break label126;
        }
      }
      finally {}
      if (mSDKClientList.size() > 0)
      {
        m.c("TMAssistantDownloadManager", "mSDKClientList != null && mSDKClientList.size() > 0");
        Iterator localIterator = mSDKClientList.iterator();
        while (localIterator.hasNext())
        {
          TMAssistantDownloadClient localTMAssistantDownloadClient = (TMAssistantDownloadClient)localIterator.next();
          if (localTMAssistantDownloadClient != null) {
            localTMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
          }
        }
        mSDKClientList.clear();
      }
      label126:
      MobileQQCloseServiceReceiver.a().b(paramContext);
      if (mSDKSettingClient != null)
      {
        mSDKSettingClient.unInitTMAssistantDownloadSDK();
        mSDKSettingClient = null;
      }
      mInstance = null;
      m.c("TMAssistantDownloadManager", "exit");
    }
  }
  
  public static TMAssistantDownloadManager getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
      {
        mInstance = new TMAssistantDownloadManager(paramContext);
        MobileQQCloseServiceReceiver.a().a(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public TMAssistantDownloadClient getDownloadSDKClient(String paramString)
  {
    for (;;)
    {
      try
      {
        m.c("TMAssistantDownloadManager", "enter");
        if ((paramString == null) || (paramString.length() <= 0))
        {
          m.c("TMAssistantDownloadManager", "clientKey == null || clientKey.length() <= 0");
          m.c("TMAssistantDownloadManager", "exit");
          paramString = null;
          return paramString;
        }
        m.c("TMAssistantDownloadManager", "clientKey: " + paramString);
        Iterator localIterator = mSDKClientList.iterator();
        if (localIterator.hasNext())
        {
          TMAssistantDownloadClient localTMAssistantDownloadClient = (TMAssistantDownloadClient)localIterator.next();
          if (localTMAssistantDownloadClient.mClientKey.equals(paramString) != true) {
            continue;
          }
          m.c("TMAssistantDownloadManager", "SDKClient exists");
          m.c("TMAssistantDownloadManager", "returnValue(clientItem): " + localTMAssistantDownloadClient);
          m.c("TMAssistantDownloadManager", "exit");
          paramString = localTMAssistantDownloadClient;
          continue;
        }
        paramString = new TMAssistantDownloadClient(this.mContext, paramString);
      }
      finally {}
      paramString.initTMAssistantDownloadSDK();
      mSDKClientList.add(paramString);
      m.c("TMAssistantDownloadManager", "add new SDKClient");
      m.c("TMAssistantDownloadManager", "returnValue(client): " + paramString);
      m.c("TMAssistantDownloadManager", "exit");
    }
  }
  
  public TMAssistantDownloadSettingClient getDownloadSDKSettingClient()
  {
    try
    {
      m.c("TMAssistantDownloadManager", "enter");
      if (mSDKSettingClient == null)
      {
        m.c("TMAssistantDownloadManager", "mSDKSettingClient is null create a new for TMAssistantDownloadSettingClient");
        mSDKSettingClient = new TMAssistantDownloadSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
        mSDKSettingClient.initTMAssistantDownloadSDK();
      }
      m.c("TMAssistantDownloadManager", "returnValue(settingclient): " + mSDKSettingClient);
      m.c("TMAssistantDownloadManager", "exit");
      TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = mSDKSettingClient;
      return localTMAssistantDownloadSettingClient;
    }
    finally {}
  }
  
  /* Error */
  public boolean releaseDownloadSDKClient(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 8
    //   4: ldc 38
    //   6: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: ldc 8
    //   11: new 107	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   18: ldc -97
    //   20: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: getstatic 28	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKClientList	Ljava/util/ArrayList;
    //   36: invokevirtual 60	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_2
    //   40: aload_2
    //   41: invokeinterface 66 1 0
    //   46: ifeq +85 -> 131
    //   49: aload_2
    //   50: invokeinterface 70 1 0
    //   55: checkcast 72	com/tencent/tmdownloader/TMAssistantDownloadClient
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -20 -> 40
    //   63: aload_3
    //   64: getfield 121	com/tencent/tmdownloader/TMAssistantDownloadClient:mClientKey	Ljava/lang/String;
    //   67: aload_1
    //   68: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: iconst_1
    //   72: if_icmpne -32 -> 40
    //   75: aload_3
    //   76: invokevirtual 75	com/tencent/tmdownloader/TMAssistantDownloadClient:unInitTMAssistantDownloadSDK	()V
    //   79: aload_2
    //   80: invokeinterface 162 1 0
    //   85: ldc 8
    //   87: ldc -92
    //   89: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc 8
    //   94: new 107	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   101: ldc -90
    //   103: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iconst_1
    //   107: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: ldc 8
    //   118: ldc 48
    //   120: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iconst_1
    //   124: istore 4
    //   126: aload_0
    //   127: monitorexit
    //   128: iload 4
    //   130: ireturn
    //   131: getstatic 30	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   134: ifnull +71 -> 205
    //   137: getstatic 30	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   140: getfield 170	com/tencent/tmdownloader/TMAssistantDownloadSettingClient:mClientKey	Ljava/lang/String;
    //   143: aload_1
    //   144: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   147: iconst_1
    //   148: if_icmpne +57 -> 205
    //   151: getstatic 30	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   154: invokevirtual 90	com/tencent/tmdownloader/TMAssistantDownloadSettingClient:unInitTMAssistantDownloadSDK	()V
    //   157: aconst_null
    //   158: putstatic 30	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   161: ldc 8
    //   163: ldc -84
    //   165: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: ldc 8
    //   170: new 107	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   177: ldc -90
    //   179: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iconst_1
    //   183: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: ldc 8
    //   194: ldc 48
    //   196: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: iconst_1
    //   200: istore 4
    //   202: goto -76 -> 126
    //   205: ldc 8
    //   207: new 107	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   214: ldc -82
    //   216: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_1
    //   220: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: ldc 8
    //   231: new 107	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   238: ldc -90
    //   240: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iconst_0
    //   244: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   247: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: ldc 8
    //   255: ldc 48
    //   257: invokestatic 44	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: iconst_0
    //   261: istore 4
    //   263: goto -137 -> 126
    //   266: astore_1
    //   267: aload_0
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	TMAssistantDownloadManager
    //   0	271	1	paramString	String
    //   39	41	2	localIterator	Iterator
    //   58	18	3	localTMAssistantDownloadClient	TMAssistantDownloadClient
    //   124	138	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	40	266	finally
    //   40	59	266	finally
    //   63	123	266	finally
    //   131	199	266	finally
    //   205	260	266	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\TMAssistantDownloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */