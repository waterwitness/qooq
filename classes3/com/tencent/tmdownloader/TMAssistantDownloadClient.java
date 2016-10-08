package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.a;
import com.tencent.tmassistant.aidl.d;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.a.g;
import com.tencent.tmassistantbase.a.m;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TMAssistantDownloadClient
  extends com.tencent.tmassistant.common.b
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
  protected static final String TAG = "TMAssistantDownloadSDKClient";
  protected ReferenceQueue<ITMAssistantDownloadClientListener> mListenerReferenceQueue;
  private g mLogListener = new c(this);
  ReferenceQueue<ITMAssistantDownloadLogListener> mLogListenerReferenceQueue;
  protected ArrayList<WeakReference<ITMAssistantDownloadClientListener>> mWeakListenerArrayList;
  ArrayList<WeakReference<ITMAssistantDownloadLogListener>> mWeakLogListenerArrayList;
  boolean registered = false;
  
  public TMAssistantDownloadClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmdownloader.TMAssistantDownloadService");
    m.c("TMAssistantDownloadSDKClient", "enter");
    m.c("TMAssistantDownloadSDKClient", "context: " + paramContext + "; clientKey: " + paramString);
    this.mListenerReferenceQueue = new ReferenceQueue();
    this.mWeakListenerArrayList = new ArrayList();
    this.mServiceCallback = new b(this);
    m.c("TMAssistantDownloadSDKClient", "exit");
  }
  
  private ArrayList<TMAssistantDownloadLogInfo> convert2LogInfo(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        if (!TextUtils.isEmpty(paramList))
        {
          String[] arrayOfString = paramList.split("&");
          if (arrayOfString != null)
          {
            Object localObject1 = null;
            int j = arrayOfString.length;
            int i = 0;
            if (i < j)
            {
              Object localObject3 = arrayOfString[i].split("'");
              Object localObject2 = localObject1;
              if (localObject3 != null)
              {
                localObject2 = localObject1;
                if (localObject3.length == 2)
                {
                  paramList = (List<String>)localObject1;
                  if (localObject1 == null) {
                    paramList = new TMAssistantDownloadLogInfo();
                  }
                  localObject2 = paramList;
                  if (!TextUtils.isEmpty(localObject3[0]))
                  {
                    localObject1 = localObject3[0];
                    localObject3 = localObject3[1];
                    if (!((String)localObject1).equals("LL")) {
                      break label191;
                    }
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      break label180;
                    }
                    paramList.logLevel = ((String)localObject3);
                    localObject2 = paramList;
                  }
                }
              }
              for (;;)
              {
                i += 1;
                localObject1 = localObject2;
                break;
                label180:
                paramList.logLevel = "D";
                localObject2 = paramList;
                continue;
                label191:
                if (((String)localObject1).equals("LT"))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    paramList.logTag = ((String)localObject3);
                    localObject2 = paramList;
                  }
                  else
                  {
                    paramList.logTag = " TMAssistantDownloadSDK";
                    localObject2 = paramList;
                  }
                }
                else if (((String)localObject1).equals("LTS"))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    paramList.logTime = Long.valueOf((String)localObject3).longValue();
                    localObject2 = paramList;
                  }
                  else
                  {
                    paramList.logTime = 0L;
                    localObject2 = paramList;
                  }
                }
                else if (((String)localObject1).equals("LM"))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    paramList.logMsg = ((String)localObject3);
                    localObject2 = paramList;
                  }
                  else
                  {
                    paramList.logMsg = " msg lost!!!";
                    localObject2 = paramList;
                  }
                }
                else
                {
                  localObject2 = paramList;
                  if (((String)localObject1).equals("LW")) {
                    if (!TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      paramList.logThrowableMsg = ((String)localObject3);
                      localObject2 = paramList;
                    }
                    else
                    {
                      paramList.logThrowableMsg = " log ThrowableMsg lost!!!";
                      localObject2 = paramList;
                    }
                  }
                }
              }
            }
            if (localObject1 != null) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void cancelDownloadTask(String paramString)
  {
    try
    {
      m.c("TMAssistantDownloadSDKClient", "enter");
      m.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        m.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      locald.c(this.mClientKey, paramString);
      m.c("TMAssistantDownloadSDKClient", "cancelDownloadTask");
    }
    for (;;)
    {
      m.c("TMAssistantDownloadSDKClient", "exit");
      return;
      super.initTMAssistantDownloadSDK();
      m.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
    }
  }
  
  public void deleteDownloadTask(String paramString)
  {
    try
    {
      m.c("TMAssistantDownloadSDKClient", "deleteDownloadTask enter");
      m.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        m.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      locald.d(this.mClientKey, paramString);
      m.c("TMAssistantDownloadSDKClient", "deleteDownloadTask");
    }
    for (;;)
    {
      m.c("TMAssistantDownloadSDKClient", "deleteDownloadTask exit");
      return;
      super.initTMAssistantDownloadSDK();
      m.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
    }
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
  }
  
  public List<TMAssistantDownloadTaskInfo> getDownloadTaskInfosByVia(String paramString)
  {
    try
    {
      m.c("TMAssistantDownloadSDKClient", "enter");
      m.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",mVia:" + paramString);
      if (paramString == null)
      {
        m.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      paramString = locald.a(paramString);
      m.c("TMAssistantDownloadSDKClient", "returnValue(taskInfo): " + paramString);
    }
    for (;;)
    {
      return paramString;
      super.initTMAssistantDownloadSDK();
      m.c("TMAssistantDownloadSDKClient", "returnValue: null");
      m.c("TMAssistantDownloadSDKClient", "exit");
      paramString = null;
    }
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(String paramString)
  {
    try
    {
      m.c("TMAssistantDownloadSDKClient", "enter");
      m.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        m.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      paramString = locald.a(this.mClientKey, paramString);
      m.c("TMAssistantDownloadSDKClient", "returnValue(taskInfo): " + paramString);
    }
    for (;;)
    {
      return paramString;
      super.initTMAssistantDownloadSDK();
      m.c("TMAssistantDownloadSDKClient", "returnValue: null");
      m.c("TMAssistantDownloadSDKClient", "exit");
      paramString = null;
    }
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    m.c("TMAssistantDownloadSDKClient", "enter");
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantDownloadClientListener localITMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener)((WeakReference)localIterator.next()).get();
      com.tencent.tmassistant.common.c.a().a(this, localITMAssistantDownloadClientListener);
    }
    m.c("TMAssistantDownloadSDKClient", "exit");
  }
  
  public void pauseDownloadTask(String paramString)
  {
    try
    {
      m.c("TMAssistantDownloadSDKClient", "enter");
      m.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        m.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      locald.b(this.mClientKey, paramString);
      m.c("TMAssistantDownloadSDKClient", "pauseDownloadTask");
    }
    for (;;)
    {
      m.c("TMAssistantDownloadSDKClient", "exit");
      return;
      super.initTMAssistantDownloadSDK();
      m.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
    }
  }
  
  public boolean registerDownloadTaskListener(ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        m.c("TMAssistantDownloadSDKClient", "enter");
        if (paramITMAssistantDownloadClientListener == null)
        {
          m.c("TMAssistantDownloadSDKClient", "listener is null");
          m.c("TMAssistantDownloadSDKClient", "returnValue: false");
          m.c("TMAssistantDownloadSDKClient", "exit");
          bool = false;
          return bool;
        }
        localObject = this.mListenerReferenceQueue.poll();
        if (localObject != null)
        {
          m.c("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
          this.mWeakListenerArrayList.remove(localObject);
          continue;
        }
        localObject = this.mWeakListenerArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((ITMAssistantDownloadClientListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMAssistantDownloadClientListener)
          {
            m.c("TMAssistantDownloadSDKClient", "returnValue: true");
            m.c("TMAssistantDownloadSDKClient", "exit");
            bool = true;
            break;
          }
        }
      }
      paramITMAssistantDownloadClientListener = new WeakReference(paramITMAssistantDownloadClientListener, this.mListenerReferenceQueue);
      this.mWeakListenerArrayList.add(paramITMAssistantDownloadClientListener);
      m.c("TMAssistantDownloadSDKClient", "returnValue: true");
      m.c("TMAssistantDownloadSDKClient", "exit");
      boolean bool = true;
    }
  }
  
  public boolean registerLogListener(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    boolean bool;
    if (paramITMAssistantDownloadLogListener == null) {
      bool = false;
    }
    label222:
    for (;;)
    {
      return bool;
      try
      {
        if (this.mWeakLogListenerArrayList == null) {
          this.mWeakLogListenerArrayList = new ArrayList();
        }
        if (this.mLogListenerReferenceQueue == null) {
          this.mLogListenerReferenceQueue = new ReferenceQueue();
        }
        Object localObject;
        for (;;)
        {
          localObject = this.mLogListenerReferenceQueue.poll();
          if (localObject == null) {
            break;
          }
          m.c("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
          this.mWeakLogListenerArrayList.remove(localObject);
        }
        try
        {
          localObject = (d)super.getServiceInterface();
          if (localObject != null)
          {
            m.c("TMAssistantDownloadSDKClient", "openLogListener");
            ((d)localObject).c();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          paramITMAssistantDownloadLogListener = new WeakReference(paramITMAssistantDownloadLogListener, this.mLogListenerReferenceQueue);
          this.mWeakLogListenerArrayList.add(paramITMAssistantDownloadLogListener);
          if (this.registered) {
            break label222;
          }
          this.registered = true;
          m.a(this.mLogListener);
          bool = true;
        }
      }
      finally {}
      for (;;)
      {
        localObject = this.mWeakLogListenerArrayList.iterator();
        ITMAssistantDownloadLogListener localITMAssistantDownloadLogListener;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localITMAssistantDownloadLogListener = (ITMAssistantDownloadLogListener)((WeakReference)((Iterator)localObject).next()).get();
        } while (localITMAssistantDownloadLogListener != paramITMAssistantDownloadLogListener);
        bool = true;
        break;
        super.initTMAssistantDownloadSDK();
        m.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
      }
    }
  }
  
  protected void registerServiceCallback()
  {
    ((d)this.mServiceInterface).a(this.mClientKey, (a)this.mServiceCallback);
  }
  
  public int startDownloadTask(String paramString1, int paramInt, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        m.c("TMAssistantDownloadSDKClient", "enter");
        m.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString1 + "; priority: " + paramInt + "; contentType: " + paramString2 + "; fileName ： " + paramString3);
        if (paramMap != null)
        {
          m.c("TMAssistantDownloadSDKClient", "params.size: " + paramMap.size());
          if (paramString1 != null) {
            break;
          }
          m.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
          throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
      }
      finally {}
      m.c("TMAssistantDownloadSDKClient", "params: null");
    }
    if ((paramString2.equals("resource/tm.android.unknown")) && (TextUtils.isEmpty(paramString3)))
    {
      m.e("TMAssistantDownloadSDKClient", "exception: if contentType is others, filename shouldn't be null!");
      throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
    }
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      m.c("TMAssistantDownloadSDKClient", "startDownloadTask");
      paramInt = locald.a(this.mClientKey, paramString1, 0, paramString2, paramString3, paramMap);
      m.c("TMAssistantDownloadSDKClient", "returnValue: " + paramInt);
      m.c("TMAssistantDownloadSDKClient", "exit");
    }
    for (;;)
    {
      return paramInt;
      super.initTMAssistantDownloadSDK();
      m.c("TMAssistantDownloadSDKClient", "super.initTMAssistantDownloadSDK");
      m.c("TMAssistantDownloadSDKClient", "returnValue: 0");
      m.c("TMAssistantDownloadSDKClient", "exit");
      paramInt = 0;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2)
  {
    try
    {
      m.c("TMAssistantDownloadSDKClient", "enter");
      m.c("TMAssistantDownloadSDKClient", "url: " + paramString1 + "; contentType: " + paramString2);
      int i = startDownloadTask(paramString1, 0, paramString2, null, null);
      m.c("TMAssistantDownloadSDKClient", "returnValue: " + i);
      m.c("TMAssistantDownloadSDKClient", "exit");
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      m.c("TMAssistantDownloadSDKClient", "enter");
      m.c("TMAssistantDownloadSDKClient", "url: " + paramString1 + "; contentType: " + paramString2 + "; fileName: " + paramString3);
      int i = startDownloadTask(paramString1, 0, paramString2, paramString3, null);
      m.c("TMAssistantDownloadSDKClient", "returnValue: " + i);
      m.c("TMAssistantDownloadSDKClient", "exit");
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public int startDownloadTask(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: new 49	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 383
    //   14: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: ldc 11
    //   29: ldc 41
    //   31: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: ldc 11
    //   36: new 49	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 375
    //   46: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 343
    //   56: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_2
    //   60: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_3
    //   70: ifnull +82 -> 152
    //   73: ldc 11
    //   75: new 49	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 347
    //   85: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokeinterface 353 1 0
    //   94: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: aload_1
    //   105: iconst_0
    //   106: aload_2
    //   107: aconst_null
    //   108: aload_3
    //   109: invokevirtual 377	com/tencent/tmdownloader/TMAssistantDownloadClient:startDownloadTask	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)I
    //   112: istore 4
    //   114: ldc 11
    //   116: new 49	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   123: ldc_w 367
    //   126: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload 4
    //   131: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 11
    //   142: ldc 86
    //   144: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_0
    //   148: monitorexit
    //   149: iload 4
    //   151: ireturn
    //   152: ldc 11
    //   154: ldc_w 355
    //   157: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -57 -> 103
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	TMAssistantDownloadClient
    //   0	168	1	paramString1	String
    //   0	168	2	paramString2	String
    //   0	168	3	paramMap	Map<String, String>
    //   112	38	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	69	163	finally
    //   73	103	163	finally
    //   103	147	163	finally
    //   152	160	163	finally
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = e.a(paramIBinder);
  }
  
  /* Error */
  public boolean unRegisterDownloadTaskListener(ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 41
    //   6: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: ifnonnull +34 -> 44
    //   13: ldc 11
    //   15: ldc_w 289
    //   18: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 11
    //   23: ldc_w 291
    //   26: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc 11
    //   31: ldc 86
    //   33: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: iconst_0
    //   37: istore 4
    //   39: aload_0
    //   40: monitorexit
    //   41: iload 4
    //   43: ireturn
    //   44: aload_0
    //   45: getfield 77	com/tencent/tmdownloader/TMAssistantDownloadClient:mWeakListenerArrayList	Ljava/util/ArrayList;
    //   48: invokevirtual 265	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   51: astore_2
    //   52: aload_2
    //   53: invokeinterface 105 1 0
    //   58: ifeq +54 -> 112
    //   61: aload_2
    //   62: invokeinterface 109 1 0
    //   67: checkcast 267	java/lang/ref/WeakReference
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual 270	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   75: checkcast 272	com/tencent/tmdownloader/ITMAssistantDownloadClientListener
    //   78: aload_1
    //   79: if_acmpne -27 -> 52
    //   82: aload_0
    //   83: getfield 77	com/tencent/tmdownloader/TMAssistantDownloadClient:mWeakListenerArrayList	Ljava/util/ArrayList;
    //   86: aload_3
    //   87: invokevirtual 300	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   90: pop
    //   91: ldc 11
    //   93: ldc_w 302
    //   96: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: ldc 11
    //   101: ldc 86
    //   103: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: iconst_1
    //   107: istore 4
    //   109: goto -70 -> 39
    //   112: ldc 11
    //   114: ldc_w 291
    //   117: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: ldc 11
    //   122: ldc 86
    //   124: invokestatic 47	com/tencent/tmassistantbase/a/m:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: iconst_0
    //   128: istore 4
    //   130: goto -91 -> 39
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	TMAssistantDownloadClient
    //   0	138	1	paramITMAssistantDownloadClientListener	ITMAssistantDownloadClientListener
    //   51	11	2	localIterator	Iterator
    //   70	17	3	localWeakReference	WeakReference
    //   37	92	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	133	finally
    //   13	36	133	finally
    //   44	52	133	finally
    //   52	106	133	finally
    //   112	127	133	finally
  }
  
  public boolean unRegisterLogListener(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    if (paramITMAssistantDownloadLogListener == null) {}
    for (boolean bool = false;; bool = false) {
      for (;;)
      {
        return bool;
        try
        {
          Iterator localIterator = this.mWeakLogListenerArrayList.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              WeakReference localWeakReference = (WeakReference)localIterator.next();
              if ((ITMAssistantDownloadLogListener)localWeakReference.get() == paramITMAssistantDownloadLogListener)
              {
                this.mWeakLogListenerArrayList.remove(localWeakReference);
                if (this.mWeakLogListenerArrayList.size() == 0) {
                  m.b(this.mLogListener);
                }
                try
                {
                  paramITMAssistantDownloadLogListener = (d)super.getServiceInterface();
                  if (paramITMAssistantDownloadLogListener != null) {
                    paramITMAssistantDownloadLogListener.d();
                  }
                }
                catch (Exception paramITMAssistantDownloadLogListener)
                {
                  for (;;)
                  {
                    paramITMAssistantDownloadLogListener.printStackTrace();
                  }
                }
                bool = true;
                break;
              }
            }
          }
        }
        finally {}
      }
    }
  }
  
  protected void unRegisterServiceCallback()
  {
    ((d)this.mServiceInterface).b(this.mClientKey, (a)this.mServiceCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\TMAssistantDownloadClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */