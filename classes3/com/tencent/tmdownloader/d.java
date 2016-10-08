package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCSDKDownloadInfo;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class d
  implements ITMAssistantDownloadClientListener
{
  protected ReferenceQueue<a> a;
  protected ArrayList<WeakReference<a>> b;
  private List<TMAssistantDownloadTaskInfo> c = new ArrayList();
  private List<String> d = new ArrayList();
  private TMAssistantDownloadClient e;
  private Context f;
  private String g;
  
  public d(Context paramContext, String paramString)
  {
    m.c("TMAssistantDownloadQQGameClient", "TMAssistantDownloadQQGameClient init.......");
    this.f = paramContext;
    this.g = paramString;
    if (paramContext != null) {
      b();
    }
    this.a = new ReferenceQueue();
    this.b = new ArrayList();
  }
  
  private TMAssistantDownloadTaskInfo a(String paramString)
  {
    if ((paramString == null) || (this.c.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo)localIterator.next();
      if (paramString.equals(localTMAssistantDownloadTaskInfo.mUrl)) {
        return localTMAssistantDownloadTaskInfo;
      }
    }
    return null;
  }
  
  private void a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    m.c("TMAssistantDownloadQQGameClient", "syncDownloadTaskInfo......");
    if (paramTMAssistantDownloadTaskInfo == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          locala.a(paramTMAssistantDownloadTaskInfo);
        }
      }
    }
  }
  
  private void b()
  {
    if (this.e != null) {
      return;
    }
    this.e = new TMAssistantDownloadClient(this.f, this.g);
    if (this.e.initTMAssistantDownloadSDK())
    {
      m.c("TMAssistantDownloadQQGameClient", "TMAssistantDownloadQQGameClient registerDownloadTaskListener......." + this.e);
      this.e.registerDownloadTaskListener(this);
      return;
    }
    this.e = null;
  }
  
  private void b(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    if (paramTMAssistantDownloadTaskInfo == null) {}
    while ((paramTMAssistantDownloadTaskInfo.mState != 4) || (TextUtils.isEmpty(paramTMAssistantDownloadTaskInfo.mSavePath))) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + paramTMAssistantDownloadTaskInfo.mSavePath), "application/vnd.android.package-archive");
    localIntent.setFlags(268435456);
    this.f.startActivity(localIntent);
  }
  
  private boolean b(String paramString)
  {
    try
    {
      Intent localIntent2 = this.f.getPackageManager().getLaunchIntentForPackage(paramString);
      Intent localIntent1 = localIntent2;
      if (localIntent2 == null)
      {
        localIntent1 = localIntent2;
        if (this.f.getPackageManager().getPackageInfo(paramString, 1) != null) {
          localIntent1 = new Intent(paramString);
        }
      }
      if (localIntent1 != null)
      {
        localIntent1.setFlags(268435456);
        this.f.startActivity(localIntent1);
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void c(List<TMAssistantDownloadTaskInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          locala.a(this.d, paramList);
        }
      }
    }
  }
  
  public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    m.c("jimluo", "OnDownloadSDKTaskProgressChanged......");
    paramTMAssistantDownloadClient = a(paramString);
    if (paramTMAssistantDownloadClient != null)
    {
      m.c("jimluo", "OnDownloadSDKTaskProgressChanged taskInfo is null......");
      paramTMAssistantDownloadClient.mReceiveDataLen = paramLong1;
      paramTMAssistantDownloadClient.mTotalDataLen = paramLong2;
      a(paramTMAssistantDownloadClient);
    }
    for (;;)
    {
      return;
      try
      {
        paramTMAssistantDownloadClient = this.e.getDownloadTaskState(paramString);
        if (paramTMAssistantDownloadClient != null)
        {
          a(paramTMAssistantDownloadClient);
          return;
        }
      }
      catch (Exception paramTMAssistantDownloadClient)
      {
        paramTMAssistantDownloadClient.printStackTrace();
      }
    }
  }
  
  public void OnDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    m.c("TMAssistantDownloadQQGameClient", "OnDownloadSDKTaskStateChanged......");
    paramTMAssistantDownloadClient = a(paramString1);
    if (paramTMAssistantDownloadClient != null)
    {
      paramTMAssistantDownloadClient.mState = paramInt1;
      a(paramTMAssistantDownloadClient);
    }
    for (;;)
    {
      return;
      try
      {
        paramTMAssistantDownloadClient = this.e.getDownloadTaskState(paramString1);
        if (paramTMAssistantDownloadClient != null)
        {
          a(paramTMAssistantDownloadClient);
          return;
        }
      }
      catch (Exception paramTMAssistantDownloadClient)
      {
        paramTMAssistantDownloadClient.printStackTrace();
      }
    }
  }
  
  public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    paramTMAssistantDownloadClient = this.b.iterator();
    while (paramTMAssistantDownloadClient.hasNext())
    {
      a locala = (a)((WeakReference)paramTMAssistantDownloadClient.next()).get();
      if (locala != null) {
        locala.a();
      }
    }
  }
  
  public List<TMAssistantDownloadTaskInfo> a(List<String> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      try
      {
        paramList = this.c;
        return paramList;
      }
      finally {}
      this.d.clear();
      this.d.addAll(paramList);
      this.c.clear();
      paramList = this.d.iterator();
      if (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        localObject = this.e.getDownloadTaskInfosByVia((String)localObject);
        if (localObject != null) {
          this.c.addAll((Collection)localObject);
        }
      }
      else
      {
        c(this.c);
        paramList = this.c;
      }
    }
  }
  
  public void a()
  {
    if (this.e != null)
    {
      this.e.unInitTMAssistantDownloadSDK();
      this.e = null;
    }
  }
  
  public void a(BatchSDKDownloadActionResponse paramBatchSDKDownloadActionResponse)
  {
    for (;;)
    {
      try
      {
        if (this.e == null) {
          b();
        }
        m.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction downloadClient:" + this.e);
        if (paramBatchSDKDownloadActionResponse == null) {
          return;
        }
        switch (paramBatchSDKDownloadActionResponse.batchRequestType)
        {
        case 2: 
          m.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction undo anythings......");
          continue;
          paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
        }
      }
      finally {}
      IPCSDKDownloadInfo localIPCSDKDownloadInfo;
      while (paramBatchSDKDownloadActionResponse.hasNext())
      {
        localIPCSDKDownloadInfo = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
        m.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction PAUSE url:" + localIPCSDKDownloadInfo.url);
        this.e.pauseDownloadTask(localIPCSDKDownloadInfo.url);
      }
      continue;
      paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
      while (paramBatchSDKDownloadActionResponse.hasNext())
      {
        localIPCSDKDownloadInfo = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
        m.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction start url:" + localIPCSDKDownloadInfo.url);
        HashMap localHashMap = new HashMap();
        this.e.startDownloadTask(localIPCSDKDownloadInfo.url, "application/vnd.android.package-archive", localHashMap);
      }
      continue;
      paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
      while (paramBatchSDKDownloadActionResponse.hasNext())
      {
        localIPCSDKDownloadInfo = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
        m.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction cancel url:" + localIPCSDKDownloadInfo.url);
        this.e.cancelDownloadTask(localIPCSDKDownloadInfo.url);
      }
      continue;
      paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
      while (paramBatchSDKDownloadActionResponse.hasNext())
      {
        localIPCSDKDownloadInfo = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
        m.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction delete url:" + localIPCSDKDownloadInfo.url);
        this.e.deleteDownloadTask(localIPCSDKDownloadInfo.url);
      }
      continue;
      paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
      while (paramBatchSDKDownloadActionResponse.hasNext())
      {
        localIPCSDKDownloadInfo = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
        m.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction install package:" + localIPCSDKDownloadInfo.packageName);
        b(this.e.getDownloadTaskState(localIPCSDKDownloadInfo.url));
      }
      continue;
      paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
      while (paramBatchSDKDownloadActionResponse.hasNext())
      {
        localIPCSDKDownloadInfo = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
        m.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction open package:" + localIPCSDKDownloadInfo.packageName);
        if (!TextUtils.isEmpty(localIPCSDKDownloadInfo.packageName)) {
          b(localIPCSDKDownloadInfo.packageName);
        }
      }
    }
  }
  
  public void a(SubScribeSDKDownloadTaskByViaResponse paramSubScribeSDKDownloadTaskByViaResponse)
  {
    if (this.e == null) {
      b();
    }
    if (paramSubScribeSDKDownloadTaskByViaResponse.subscribeType == 1)
    {
      a(paramSubScribeSDKDownloadTaskByViaResponse.viaList);
      return;
    }
    b(paramSubScribeSDKDownloadTaskByViaResponse.viaList);
  }
  
  public boolean a(a parama)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        m.c("TMAssistantDownloadQQGameClient", "enter");
        if (parama == null)
        {
          m.c("TMAssistantDownloadQQGameClient", "listener == null");
          m.c("TMAssistantDownloadQQGameClient", "returnValue: false");
          m.c("TMAssistantDownloadQQGameClient", "exit");
          bool = false;
          return bool;
        }
        localObject = this.a.poll();
        if (localObject != null)
        {
          m.c("TMAssistantDownloadQQGameClient", "registerDownloadTaskListener removed listener!!!!");
          this.b.remove(localObject);
          continue;
        }
        localObject = this.b.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((a)((WeakReference)((Iterator)localObject).next()).get() == parama)
          {
            m.c("TMAssistantDownloadQQGameClient", "returnValue: true");
            m.c("TMAssistantDownloadQQGameClient", "exit");
            bool = true;
            break;
          }
        }
      }
      parama = new WeakReference(parama, this.a);
      this.b.add(parama);
      m.c("TMAssistantDownloadQQGameClient", "returnValue: true");
      m.c("TMAssistantDownloadQQGameClient", "exit");
      boolean bool = true;
    }
  }
  
  public void b(List<String> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        int i = paramList.size();
        if (i == 0) {
          return;
        }
        this.d.removeAll(paramList);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.c.iterator();
        if (localIterator.hasNext())
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo)localIterator.next();
          if (paramList.contains(localTMAssistantDownloadTaskInfo.mVia)) {
            localArrayList.add(localTMAssistantDownloadTaskInfo);
          }
        }
        else
        {
          this.c.removeAll(localArrayList);
        }
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */