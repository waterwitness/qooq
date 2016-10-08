package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.strategy.DownloadConnectionReuseStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy.KeepAlive;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.cache.a.b;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.a.e.a;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.AbstractHttpClient;

public final class c
  extends Downloader
  implements a.a
{
  public static int a;
  public static final TimeUnit b = TimeUnit.SECONDS;
  private static volatile int c = 0;
  private static int d;
  private static final KeepAliveStrategy.KeepAlive e = KeepAliveStrategy.KeepAlive.DISABLE;
  private static final KeepAliveStrategy.KeepAlive f = KeepAliveStrategy.KeepAlive.DISABLE;
  private static final DownloadPreprocessStrategy.DownloadPool g = DownloadPreprocessStrategy.DownloadPool.COMMON;
  private static final b h = new b("download");
  private final b i = h;
  private final b j = com.tencent.component.network.module.cache.a.a(this.mContext, "download_cache", 100, 50);
  private HttpClient k;
  private final com.tencent.component.network.utils.c<String, DownloadRequest> l = new com.tencent.component.network.utils.c();
  private final HashMap<String, Future<DownloadResult>> m = new HashMap();
  private Map<String, List<WeakReference<a>>> n = new HashMap();
  private Object o = new Object();
  private a p = new a((byte)0);
  
  static
  {
    a = DownloadPreprocessStrategy.DownloadPool.size() * 3 * 5;
    d = 2;
  }
  
  public c(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  private Collection<DownloadRequest> a(String paramString, boolean paramBoolean, Collection<DownloadRequest> paramCollection)
  {
    com.tencent.component.network.utils.c localc = this.l;
    if (paramBoolean) {}
    try
    {
      for (paramString = (HashSet)this.l.remove(paramString); paramCollection != null; paramString = (HashSet)this.l.get(paramString))
      {
        paramCollection.clear();
        if (paramString != null) {
          paramCollection.addAll(paramString);
        }
        return paramCollection;
      }
      return paramString;
    }
    finally {}
  }
  
  private static void a(Collection<DownloadRequest> paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled()))
        {
          Downloader.DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadCanceled(localDownloadRequest.getUrl());
          }
        }
      }
    }
  }
  
  private static void a(Collection<DownloadRequest> paramCollection, long paramLong, float paramFloat)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled()))
        {
          Downloader.DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadProgress(localDownloadRequest.getUrl(), paramLong, paramFloat);
          }
        }
      }
    }
  }
  
  private boolean a(String paramString, DownloadRequest paramDownloadRequest)
  {
    if (paramDownloadRequest == null) {
      return false;
    }
    for (;;)
    {
      Object localObject;
      int i1;
      boolean bool;
      synchronized (this.l)
      {
        this.l.a(paramString);
        localObject = (Collection)this.l.get(paramString);
        if (localObject == null) {
          break label134;
        }
        localObject = ((Collection)localObject).iterator();
        i1 = 0;
        if (!((Iterator)localObject).hasNext())
        {
          this.l.a(paramString, paramDownloadRequest);
          if (i1 != 0) {
            break label128;
          }
          bool = true;
          return bool;
        }
      }
      DownloadRequest localDownloadRequest = (DownloadRequest)((Iterator)localObject).next();
      if (localDownloadRequest != null)
      {
        bool = localDownloadRequest.isCanceled();
        if (!bool)
        {
          i1 += 1;
          continue;
          label128:
          bool = false;
          continue;
          label134:
          i1 = 0;
        }
      }
    }
  }
  
  private boolean a(String paramString, DownloadRequest paramDownloadRequest, Collection<DownloadRequest> paramCollection)
  {
    if (paramDownloadRequest == null) {
      return false;
    }
    for (;;)
    {
      int i2;
      int i1;
      boolean bool;
      synchronized (this.l)
      {
        i2 = this.l.a(paramString);
        if (paramCollection != null) {
          paramCollection.clear();
        }
        paramString = (Collection)this.l.get(paramString);
        if (paramString == null) {
          break label154;
        }
        paramString = paramString.iterator();
        i1 = 0;
        if (!paramString.hasNext())
        {
          break label157;
          return bool;
        }
      }
      DownloadRequest localDownloadRequest = (DownloadRequest)paramString.next();
      if (paramDownloadRequest.equals(localDownloadRequest))
      {
        localDownloadRequest.cancel();
        if (paramCollection != null) {
          paramCollection.add(paramDownloadRequest);
        }
      }
      if (localDownloadRequest != null)
      {
        bool = localDownloadRequest.isCanceled();
        if (!bool)
        {
          i1 += 1;
          continue;
          label154:
          label157:
          do
          {
            bool = false;
            break;
            i1 = 0;
          } while ((i2 <= 0) || (i1 != 0));
          bool = true;
        }
      }
    }
  }
  
  private HttpClient d()
  {
    if (this.k != null) {
      return this.k;
    }
    try
    {
      if (this.k != null)
      {
        HttpClient localHttpClient = this.k;
        return localHttpClient;
      }
    }
    finally {}
    Object localObject2 = new e.a();
    ((e.a)localObject2).a = true;
    ((e.a)localObject2).d = a;
    ((e.a)localObject2).e = d;
    ((e.a)localObject2).b = 120L;
    ((e.a)localObject2).c = b;
    this.k = com.tencent.component.network.utils.a.e.a((e.a)localObject2);
    localObject2 = this.k;
    if ((localObject2 != null) && ((localObject2 instanceof AbstractHttpClient))) {
      ((AbstractHttpClient)localObject2).setReuseStrategy(new DownloadConnectionReuseStrategy());
    }
    localObject2 = this.k;
    return (HttpClient)localObject2;
  }
  
  private boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      synchronized (this.o)
      {
        paramString = (List)this.n.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private com.tencent.component.network.utils.c<String, DownloadRequest> e()
  {
    synchronized (this.l)
    {
      if (this.l.isEmpty()) {
        return null;
      }
      com.tencent.component.network.utils.c localc2 = new com.tencent.component.network.utils.c();
      localc2.putAll(this.l);
      this.l.clear();
      return localc2;
    }
  }
  
  private boolean e(String paramString)
  {
    if (!com.tencent.component.network.downloader.common.a.a(paramString)) {
      return false;
    }
    synchronized (this.o)
    {
      Object localObject2;
      if (this.n.containsKey(paramString))
      {
        localObject2 = (List)this.n.get(paramString);
        this.n.remove(paramString);
        if (localObject2 != null) {
          localObject2 = ((List)localObject2).iterator();
        }
      }
      a locala;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          return true;
        }
        locala = (a)((WeakReference)((Iterator)localObject2).next()).get();
      } while ((locala == null) || (!paramString.equals(locala.j())));
      locala.h();
    }
  }
  
  public final int a()
  {
    return c;
  }
  
  public final String a(String paramString)
  {
    paramString = generateStorageName(paramString);
    paramString = this.j.b(paramString);
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  public final void a(String paramString, long paramLong, float paramFloat)
  {
    a(a(paramString, false, new ArrayList()), paramLong, paramFloat);
  }
  
  public final void a(String paramString, DownloadResult paramDownloadResult)
  {
    String str2 = generateStorageName(paramString);
    String str1 = this.j.a(str2);
    try
    {
      File localFile = new File(paramDownloadResult.getPath());
      boolean bool2 = FileUtils.copyFiles(localFile, new File(str1));
      boolean bool1 = bool2;
      paramDownloadResult = str1;
      if (!bool2)
      {
        paramDownloadResult = this.j.a(str2, false);
        bool1 = FileUtils.copyFiles(localFile, new File(paramDownloadResult));
      }
      if (com.tencent.component.network.downloader.common.a.b()) {
        com.tencent.component.network.downloader.common.a.b("Downloader", "download cache entry to: " + paramDownloadResult + " " + paramString + " result:" + bool1);
      }
      return;
    }
    catch (Throwable paramDownloadResult)
    {
      com.tencent.component.network.downloader.common.a.a("Downloader", "download ------- copy exception!!! " + paramString, paramDownloadResult);
    }
  }
  
  public final void a(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if (this.pProcessStrategy != null) {
      this.pProcessStrategy.prepareRequest(paramString1, paramString2, paramHttpRequest);
    }
  }
  
  public final boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    com.tencent.component.network.downloader.handler.a locala = this.pContentHandler;
    if (locala != null) {
      return locala.handleContentType(paramDownloadResult, paramHttpResponse);
    }
    return true;
  }
  
  public final void abort(String arg1, Downloader.DownloadListener paramDownloadListener)
  {
    e(???);
    Object localObject = generateUrlKey(???);
    paramDownloadListener = new ArrayList();
    a((String)localObject, true, paramDownloadListener);
    synchronized (this.m)
    {
      localObject = (Future)this.m.remove(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel();
      }
      a(paramDownloadListener);
      return;
    }
  }
  
  public final String b(String paramString)
  {
    return super.generateStorageName(paramString);
  }
  
  public final HttpHost b()
  {
    return getMobileProxy();
  }
  
  public final void b(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    boolean bool;
    if ((paramString1 != null) && (paramString2 != null) && (paramHttpRequest != null))
    {
      bool = true;
      label15:
      AssertUtil.assertTrue(bool);
      paramString1 = this.pKeepAliveStrategy;
      if (paramString1 == null) {
        break label91;
      }
      paramString1 = paramString1.keepAlive(paramString2, paramHttpRequest);
      label38:
      paramString2 = paramString1;
      if (paramString1 == null) {
        if (!com.tencent.component.network.utils.a.e.a(paramHttpRequest)) {
          break label96;
        }
      }
    }
    label91:
    label96:
    for (paramString2 = f;; paramString2 = e) {
      switch (f()[paramString2.ordinal()])
      {
      default: 
        return;
        bool = false;
        break label15;
        paramString1 = null;
        break label38;
      }
    }
    com.tencent.component.network.utils.a.e.a(paramHttpRequest, true);
    return;
    com.tencent.component.network.utils.a.e.a(paramHttpRequest, false);
  }
  
  public final String c(String paramString)
  {
    if (this.pProcessStrategy == null) {
      return null;
    }
    return this.pProcessStrategy.prepareUrl(paramString);
  }
  
  public final void cancel(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (!com.tencent.component.network.downloader.common.a.a(paramString)) {
      return;
    }
    if (com.tencent.component.network.downloader.common.a.b()) {
      com.tencent.component.network.downloader.common.a.b("Downloader", "download cancel url:" + paramString + " listener:" + paramDownloadListener);
    }
    Object localObject1 = generateUrlKey(paramString);
    ??? = new DownloadRequest(paramString, new String[0], false, paramDownloadListener);
    paramDownloadListener = new ArrayList();
    if (a((String)localObject1, (DownloadRequest)???, paramDownloadListener)) {}
    synchronized (this.m)
    {
      localObject1 = (Future)this.m.remove(localObject1);
      if ((localObject1 != null) && (!d(paramString))) {
        ((Future)localObject1).cancel();
      }
      a(paramDownloadListener);
      return;
    }
  }
  
  public final void cancelAll()
  {
    com.tencent.component.network.utils.c localc = e();
    Object localObject1 = null;
    for (;;)
    {
      synchronized (this.m)
      {
        if (!this.m.isEmpty())
        {
          localObject1 = new ArrayList(this.m.values());
          this.m.clear();
        }
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          if (((Iterator)localObject1).hasNext()) {}
        }
        else
        {
          if (localc != null)
          {
            localObject1 = localc.keySet().iterator();
            if (((Iterator)localObject1).hasNext()) {
              break label118;
            }
          }
          return;
        }
      }
      ??? = (Future)((Iterator)localObject2).next();
      if (??? != null)
      {
        ((Future)???).cancel();
        continue;
        label118:
        ??? = (String)((Iterator)localObject2).next();
        if (??? != null) {
          a((Collection)localc.get(???));
        }
      }
    }
  }
  
  public final void cleanCache()
  {
    this.j.b();
    if (this.pResumeTransfer != null) {
      this.pResumeTransfer.cleanCache();
    }
  }
  
  public final void cleanCache(String paramString)
  {
    this.j.d(super.generateStorageName(paramString));
    if (this.pResumeTransfer != null) {
      this.pResumeTransfer.cleanCache(paramString);
    }
  }
  
  public final boolean download(DownloadRequest arg1, boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject1 = ???.getUrl();
    boolean bool1;
    if ((!com.tencent.component.network.downloader.common.a.a((String)localObject1)) || (???.getPaths() == null)) {
      bool1 = false;
    }
    Object localObject2;
    do
    {
      do
      {
        return bool1;
        localObject2 = generateUrlKey((String)localObject1);
        if (com.tencent.component.network.downloader.common.a.b()) {
          com.tencent.component.network.downloader.common.a.b("downloader", "download :" + (String)localObject1 + " urlKey:" + (String)localObject2 + " listener:" + ???.getListener());
        }
        bool1 = bool2;
      } while (!a((String)localObject2, ???));
      bool1 = bool2;
    } while (d((String)localObject1));
    if (???.range > 0L) {
      ???.addParam("Range", "bytes=" + ???.range);
    }
    if (???.mode == Downloader.DownloadMode.StrictMode)
    {
      localObject1 = new h(this.mContext, d(), (String)localObject1, (String)localObject2, paramBoolean);
      ((a)localObject1).a(12);
      ((a)localObject1).a(???.getParams());
      ((a)localObject1).a(this, this.pDirectIPConfig, this.pBackupIPConfig, this.pPortConfigStrategy, this.pResumeTransfer, this.pReportHandler, this.pExternalReportHandler, this.pNetworkFlowStatistics, this.pTmpFileCache);
      ??? = ((a)localObject1).j();
      localObject2 = ((a)localObject1).k();
      if (??? == null) {
        break label346;
      }
    }
    label346:
    for (paramBoolean = true;; paramBoolean = false)
    {
      AssertUtil.assertTrue(paramBoolean);
      if (this.pExternalThreadPool == null) {
        break label351;
      }
      ??? = this.pExternalThreadPool;
      a.c();
      localObject2 = ???.submit((ThreadPool.Job)localObject1, new d(this, (a)localObject1), ((a)localObject1).i());
      synchronized (this.m)
      {
        this.m.put(((a)localObject1).l(), localObject2);
        return true;
      }
      e locale = new e(this.mContext, d(), str, (String)localObject2, paramBoolean);
      locale.a(8);
      break;
    }
    label351:
    DownloadPreprocessStrategy localDownloadPreprocessStrategy = this.pProcessStrategy;
    if (localDownloadPreprocessStrategy != null) {}
    for (??? = localDownloadPreprocessStrategy.downloadPool(???, (String)localObject2);; ??? = null)
    {
      localObject2 = ???;
      if (??? == null) {
        localObject2 = g;
      }
      ??? = this.i.a(((DownloadPreprocessStrategy.DownloadPool)localObject2).getName());
      break;
    }
  }
  
  public final void setHttpConnectionParam(int paramInt1, int paramInt2)
  {
    super.setHttpConnectionParam(paramInt1, paramInt2);
    if (this.pMaxConnectionPerRoute > 0) {
      d = this.pMaxConnectionPerRoute;
    }
    if (this.pMaxConnection > 0) {
      a = this.pMaxConnection;
    }
  }
  
  public final class a
  {
    private Object a = new Object();
    private List<Object> b = new ArrayList();
    private Map<String, Object> c = new HashMap();
    
    public static void a(Downloader paramDownloader)
    {
      if (paramDownloader == null) {
        return;
      }
      paramDownloader.setPreprocessStrategy(new f(paramDownloader));
      paramDownloader.setContentHandler(new g());
    }
    
    private static boolean d(String paramString)
    {
      boolean bool1 = false;
      try
      {
        if ((!"m.qpic.cn".equalsIgnoreCase(paramString)) && (!"a1.qpic.cn".equalsIgnoreCase(paramString)) && (!"a2.qpic.cn".equalsIgnoreCase(paramString)) && (!"a3.qpic.cn".equalsIgnoreCase(paramString)))
        {
          boolean bool2 = "a4.qpic.cn".equalsIgnoreCase(paramString);
          if (!bool2) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      catch (Exception paramString) {}
      return false;
    }
    
    public final Object a(String paramString)
    {
      for (;;)
      {
        synchronized (this.a)
        {
          if (this.c.containsKey(paramString))
          {
            paramString = this.c.get(paramString);
            return paramString;
          }
          if (this.b.size() > 0)
          {
            localObject1 = this.b.remove(0);
            this.c.put(paramString, localObject1);
            return localObject1;
          }
        }
        Object localObject1 = new Object();
      }
    }
    
    public final void b(String paramString)
    {
      synchronized (this.a)
      {
        if (!this.c.containsKey(paramString)) {
          return;
        }
        paramString = this.c.remove(paramString);
        if ((paramString != null) && (!this.b.contains(paramString))) {
          this.b.add(paramString);
        }
        return;
      }
    }
  }
  
  static final class b
  {
    private final String a;
    private final HashMap<String, PriorityThreadPool> b = new HashMap();
    
    b(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.a = str;
    }
    
    public final PriorityThreadPool a(String paramString)
    {
      paramString = this.a + "-" + paramString;
      ??? = (PriorityThreadPool)this.b.get(paramString);
      if (??? != null) {
        return (PriorityThreadPool)???;
      }
      synchronized (this.b)
      {
        localPriorityThreadPool = (PriorityThreadPool)this.b.get(paramString);
        if (localPriorityThreadPool != null) {
          return localPriorityThreadPool;
        }
      }
      PriorityThreadPool localPriorityThreadPool = new PriorityThreadPool(paramString, 2);
      this.b.put(paramString, localPriorityThreadPool);
      return localPriorityThreadPool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\impl\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */