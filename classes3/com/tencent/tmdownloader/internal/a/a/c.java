package com.tencent.tmdownloader.internal.a.a;

import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmdownloader.internal.a.d;
import com.tencent.tmdownloader.internal.a.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements l
{
  protected List<b> a = Collections.synchronizedList(new ArrayList());
  protected a b = null;
  
  public c(ArrayList<b> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      synchronized (this.a)
      {
        this.a.addAll(paramArrayList);
        return;
      }
    }
  }
  
  private TMAssistantDownloadTaskInfo a(d paramd)
  {
    if (paramd == null) {
      return null;
    }
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(paramd.b, com.tencent.tmdownloader.internal.d.b.b(paramd.l), paramd.i, paramd.j, paramd.k, paramd.a);
    localTMAssistantDownloadTaskInfo.mAppId = paramd.t;
    localTMAssistantDownloadTaskInfo.mTaskPackageName = paramd.u;
    localTMAssistantDownloadTaskInfo.mTaskVersionCode = paramd.v;
    localTMAssistantDownloadTaskInfo.mIconUrl = paramd.H;
    localTMAssistantDownloadTaskInfo.mAppName = paramd.I;
    localTMAssistantDownloadTaskInfo.mVia = paramd.B;
    localTMAssistantDownloadTaskInfo.mChannelid = paramd.C;
    localTMAssistantDownloadTaskInfo.mStartTime = paramd.x;
    localTMAssistantDownloadTaskInfo.mEndTime = paramd.y;
    localTMAssistantDownloadTaskInfo.showNotification = paramd.J;
    m.c("ServiceDownloadTaskManager", "TMAssistantDownloadTaskInfo pkg is: " + localTMAssistantDownloadTaskInfo.mTaskPackageName);
    m.c("ServiceDownloadTaskManager", "TMAssistantDownloadTaskInfo mAppName is: " + localTMAssistantDownloadTaskInfo.mAppName + " dt mAppName is: " + paramd.I);
    return localTMAssistantDownloadTaskInfo;
  }
  
  private List<TMAssistantDownloadTaskInfo> a(List<d> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((d)paramList.next()));
    }
    return localArrayList;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 3;
    }
    m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1);
    if (e(paramString1, paramString2) != null)
    {
      m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is not null");
      return com.tencent.tmdownloader.internal.a.a.b().a(paramString2, paramInt, paramString3, paramString4, paramMap);
    }
    m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is null");
    Object localObject2 = c(paramString2);
    b localb = new b(paramString1, paramString2);
    localb.c = 1;
    for (;;)
    {
      int j;
      int i;
      int k;
      synchronized (this.a)
      {
        this.a.add(localb);
        m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",add newTask");
        ??? = ((ArrayList)localObject2).iterator();
        j = 0;
        i = 0;
        if (!((Iterator)???).hasNext()) {
          break label288;
        }
        localObject2 = (b)((Iterator)???).next();
        if (((b)localObject2).c == 2)
        {
          k = 1;
          j = i;
          i = k;
          k = j;
          j = i;
          i = k;
        }
      }
      if (((b)localObject2).c == 1)
      {
        i = j;
        j = 1;
        continue;
        label288:
        if ((j == 1) || (i == 1))
        {
          if (j == 1) {
            localb.c = 2;
          }
          for (;;)
          {
            if (this.b != null) {
              this.b.OnDownloadStateChanged(paramString1, paramString2, localb.c, 0, null);
            }
            m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",newTask is downloading");
            return 0;
            if (i == 1) {
              localb.c = 1;
            }
          }
        }
        m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",start newTask download");
        return com.tencent.tmdownloader.internal.a.a.b().a(paramString2, paramInt, paramString3, paramString4, paramMap);
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    paramString1 = com.tencent.tmdownloader.internal.a.a.b().f(paramString2);
    if (paramString1 != null) {
      return a(paramString1);
    }
    Object localObject;
    if (com.tencent.tmdownloader.internal.a.c.b(paramString2, "application/vnd.android.package-archive"))
    {
      localObject = com.tencent.tmdownloader.internal.a.c.c(paramString2);
      paramString1 = com.tencent.tmdownloader.internal.d.b.b((String)localObject);
      localObject = new com.tencent.tmdownloader.internal.d.b((String)localObject, (String)localObject);
      paramString1 = new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((com.tencent.tmdownloader.internal.d.b)localObject).c(), ((com.tencent.tmdownloader.internal.d.b)localObject).c(), "application/vnd.android.package-archive");
      m.c("ServiceDownloadTaskManager", "getDownloadTaskInfo downloadTaskInfo savePath | " + paramString1.mSavePath);
      return paramString1;
    }
    if (com.tencent.tmdownloader.internal.a.c.b(paramString2, "application/tm.android.apkdiff"))
    {
      localObject = com.tencent.tmdownloader.internal.a.c.a(paramString2, "application/tm.android.apkdiff");
      paramString1 = com.tencent.tmdownloader.internal.d.b.b((String)localObject);
      localObject = new com.tencent.tmdownloader.internal.d.b((String)localObject, (String)localObject);
      return new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((com.tencent.tmdownloader.internal.d.b)localObject).c(), ((com.tencent.tmdownloader.internal.d.b)localObject).c(), "application/tm.android.apkdiff");
    }
    d(paramString2);
    return null;
  }
  
  public void a()
  {
    if (this != null) {
      com.tencent.tmdownloader.internal.a.a.b().a(this);
    }
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      Object localObject = c(paramString1);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          b localb = (b)((Iterator)localObject).next();
          m.c("ServiceDownloadTaskManager", "clientKey:" + localb.a + ",state:" + paramInt1 + ",errorcode:" + paramInt2 + ",url:" + paramString1.hashCode());
          localb.c = paramInt1;
          this.b.OnDownloadStateChanged(localb.a, paramString1, paramInt1, paramInt2, paramString2);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      Object localObject = c(paramString);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        long l = System.currentTimeMillis();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          b localb = (b)((Iterator)localObject).next();
          if (localb.a(paramLong1, paramLong2, l) == true)
          {
            m.c("ServiceDownloadTaskManager", "clientKey:" + localb.a + ",receivedLen:" + paramLong1 + ",url:" + paramString.hashCode());
            this.b.OnDownloadProgressChanged(localb.a, paramString, paramLong1, paramLong2);
          }
        }
      }
    }
  }
  
  public List<TMAssistantDownloadTaskInfo> b(String paramString)
  {
    return a(com.tencent.tmdownloader.internal.a.a.b().g(paramString));
  }
  
  public void b()
  {
    if (this != null) {
      com.tencent.tmdownloader.internal.a.a.b().b(this);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    m.c("ServiceDownloadTaskManager", "enter");
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    m.c("ServiceDownloadTaskManager", "pauseDownload clientKey:" + paramString1 + "; url: " + paramString2);
    b localb = e(paramString1, paramString2);
    m.c("ServiceDownloadTaskManager", "pauseDownload taskItem:" + localb);
    if (localb != null) {
      localb.c = 3;
    }
    for (;;)
    {
      synchronized (this.a)
      {
        this.a.remove(localb);
        m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",remove taskItem");
        ??? = c(paramString2);
        if ((??? == null) || (((ArrayList)???).size() == 0))
        {
          m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is the only on pauseAll");
          com.tencent.tmdownloader.internal.a.a.b().a(paramString2);
        }
        if (this.b != null) {
          this.b.OnDownloadStateChanged(paramString1, paramString2, localb.c, 0, null);
        }
        m.c("ServiceDownloadTaskManager", "exit");
        return;
      }
      m.d("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is null");
    }
  }
  
  protected ArrayList<b> c(String paramString)
  {
    if (paramString == null) {}
    ArrayList localArrayList;
    for (paramString = null;; paramString = localArrayList)
    {
      return paramString;
      try
      {
        localArrayList = new ArrayList();
        synchronized (this.a)
        {
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            if (localb.b.equals(paramString)) {
              localArrayList.add(localb);
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    m.c("ServiceDownloadTaskManager", "cancelDownload clientKey:" + paramString1);
    b localb = e(paramString1, paramString2);
    m.c("ServiceDownloadTaskManager", "cancelDownload taskItem:" + localb);
    if (localb != null) {
      localb.c = 6;
    }
    for (;;)
    {
      synchronized (this.a)
      {
        this.a.remove(localb);
        m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",remove taskItem");
        ??? = c(paramString2);
        if ((??? != null) && (((ArrayList)???).size() != 0)) {
          break label245;
        }
        m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is the only on cancelAll");
        com.tencent.tmdownloader.internal.a.a.b().b(paramString2);
        if (this.b == null) {
          break;
        }
        this.b.OnDownloadStateChanged(paramString1, paramString2, 6, 0, null);
        return;
      }
      m.d("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is null");
    }
    label245:
    m.d("ServiceDownloadTaskManager", "cancelDownload clientKey:" + paramString1 + ",taskItem is null");
  }
  
  protected void d(String arg1)
  {
    if (??? == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        synchronized (this.a)
        {
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            if (localb.b.equals(???)) {
              localArrayList.add(localb);
            }
          }
        }
      }
      finally {}
      if (localArrayList.size() <= 0) {
        continue;
      }
      synchronized (this.a)
      {
        this.a.removeAll(localArrayList);
      }
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    m.c("ServiceDownloadTaskManager", "deleteDownload clientKey:" + paramString1);
    b localb = e(paramString1, paramString2);
    m.c("ServiceDownloadTaskManager", "deleteDownload taskItem:" + localb);
    if (localb != null) {
      localb.c = 6;
    }
    for (;;)
    {
      synchronized (this.a)
      {
        this.a.remove(localb);
        m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",remove taskItem");
        ??? = c(paramString2);
        if ((??? != null) && (((ArrayList)???).size() != 0)) {
          break label245;
        }
        m.c("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is the only on deleteAll");
        com.tencent.tmdownloader.internal.a.a.b().e(paramString2);
        if (this.b == null) {
          break;
        }
        this.b.OnDownloadStateChanged(paramString1, paramString2, 6, 0, null);
        return;
      }
      m.d("ServiceDownloadTaskManager", "clientKey:" + paramString1 + ",taskItem is null");
    }
    label245:
    m.d("ServiceDownloadTaskManager", "deleteDownload clientKey:" + paramString1 + ",taskItem is null");
  }
  
  protected b e(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (paramString1 = null;; paramString1 = null)
    {
      return paramString1;
      try
      {
        synchronized (this.a)
        {
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            m.b("ServiceDownloadTaskManager", "taskItem mClientKey is: " + localb.a + " mUrl is: " + localb.b);
            if ((localb.a != null) && (localb.a.equals(paramString1)) && (localb.b.equals(paramString2))) {
              paramString1 = localb;
            }
          }
        }
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */