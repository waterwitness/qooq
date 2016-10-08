package com.tencent.component.network.downloader.impl;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class d
  implements FutureListener<DownloadResult>
{
  d(c paramc, a parama) {}
  
  public final void onFutureBegin(Future<DownloadResult> arg1)
  {
    c.a(c.c() + 1);
    for (;;)
    {
      Iterator localIterator;
      int i;
      synchronized (c.a(this.a).a(this.b.j()))
      {
        synchronized (c.b(this.a))
        {
          WeakReference localWeakReference = new WeakReference(this.b);
          Object localObject4 = (List)c.c(this.a).get(this.b.j());
          if (localObject4 == null)
          {
            localObject4 = new ArrayList();
            ((List)localObject4).add(localWeakReference);
            c.c(this.a).put(this.b.j(), localObject4);
            return;
          }
          localIterator = ((List)localObject4).iterator();
          if (!localIterator.hasNext())
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            ((List)localObject4).add(localWeakReference);
          }
        }
      }
      Object localObject5 = (WeakReference)localIterator.next();
      if (localObject5 != null)
      {
        localObject5 = (a)((WeakReference)localObject5).get();
        a locala = this.b;
        if (localObject5 == locala) {
          i = 0;
        }
      }
    }
  }
  
  public final void onFutureDone(Future<DownloadResult> paramFuture)
  {
    if (com.tencent.component.network.downloader.common.a.a()) {
      com.tencent.component.network.downloader.common.a.a("Downloader", "download onFutureDone " + this.b.j());
    }
    c.a(c.c() - 1);
    Object localObject3 = this.b.l();
    DownloadResult localDownloadResult;
    Object localObject2;
    synchronized (c.d(this.a))
    {
      c.d(this.a).remove(localObject3);
      localDownloadResult = (DownloadResult)paramFuture.get();
      localObject2 = c.a(this.a).a(this.b.j());
    }
    try
    {
      Object localObject5;
      Object localObject6;
      a locala;
      Object localObject7;
      synchronized (c.b(this.a))
      {
        if (c.c(this.a).containsKey(this.b.j()))
        {
          localObject5 = (List)c.c(this.a).get(this.b.j());
          if (localObject5 != null) {
            localObject6 = ((List)localObject5).iterator();
          }
        }
        do
        {
          do
          {
            if (!((Iterator)localObject6).hasNext())
            {
              ??? = null;
              if (??? != null)
              {
                ((List)localObject5).remove(???);
                if (((List)localObject5).size() <= 0) {
                  c.c(this.a).remove(this.b.j());
                }
              }
              if ((localDownloadResult == null) || (!localDownloadResult.getStatus().isRetrying())) {
                break label601;
              }
              if (com.tencent.component.network.downloader.common.a.a()) {
                com.tencent.component.network.downloader.common.a.a("Downloader", "download result: " + this.b.j() + " isRetrying");
              }
              if (localDownloadResult == null) {}
            }
            for (;;)
            {
              try
              {
                if (c.e(this.a) != null) {
                  c.e(this.a).onDownloadResult(localDownloadResult.getUrl(), localDownloadResult.getStatus().isSucceed());
                }
                if (((localDownloadResult.getStatus().isSucceed()) || (c.e(this.a) == null)) && (!TextUtils.isEmpty(localDownloadResult.getPath()))) {
                  FileUtils.delete(new File(localDownloadResult.getPath()));
                }
              }
              catch (Throwable paramFuture)
              {
                c.a(this.a).b(this.b.j());
                continue;
              }
              finally
              {
                c.a(this.a).b(this.b.j());
              }
              try
              {
                c.a(this.a).b(this.b.j());
                return;
              }
              finally {}
            }
            paramFuture = finally;
            throw paramFuture;
            ??? = (WeakReference)((Iterator)localObject6).next();
          } while (??? == null);
          locala = (a)((WeakReference)???).get();
          localObject7 = this.b;
        } while (locala != localObject7);
      }
      try
      {
        if (c.e(this.a) != null) {
          c.e(this.a).onDownloadResult(localDownloadResult.getUrl(), localDownloadResult.getStatus().isSucceed());
        }
        if (((localDownloadResult.getStatus().isSucceed()) || (c.e(this.a) == null)) && (!TextUtils.isEmpty(localDownloadResult.getPath()))) {
          FileUtils.delete(new File(localDownloadResult.getPath()));
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          c.a(this.a).b(this.b.j());
        }
      }
      finally
      {
        c.a(this.a).b(this.b.j());
      }
    }
    finally
    {
      if (localDownloadResult == null) {}
    }
    throw paramFuture;
    label601:
    boolean bool = paramFuture.isCancelled();
    if (bool)
    {
      if (localDownloadResult != null) {}
      try
      {
        if (c.e(this.a) != null) {
          c.e(this.a).onDownloadResult(localDownloadResult.getUrl(), localDownloadResult.getStatus().isSucceed());
        }
        if (((localDownloadResult.getStatus().isSucceed()) || (c.e(this.a) == null)) && (!TextUtils.isEmpty(localDownloadResult.getPath()))) {
          FileUtils.delete(new File(localDownloadResult.getPath()));
        }
      }
      catch (Throwable paramFuture)
      {
        for (;;)
        {
          c.a(this.a).b(this.b.j());
        }
      }
      finally
      {
        c.a(this.a).b(this.b.j());
      }
      return;
    }
    paramFuture = c.a(this.a, (String)localObject3);
    if ((localDownloadResult == null) || (!localDownloadResult.getStatus().isSucceed()))
    {
      ??? = this.a;
      c.a(paramFuture, localDownloadResult);
      if (localDownloadResult == null) {}
    }
    try
    {
      if (c.e(this.a) != null) {
        c.e(this.a).onDownloadResult(localDownloadResult.getUrl(), localDownloadResult.getStatus().isSucceed());
      }
      if (((localDownloadResult.getStatus().isSucceed()) || (c.e(this.a) == null)) && (!TextUtils.isEmpty(localDownloadResult.getPath()))) {
        FileUtils.delete(new File(localDownloadResult.getPath()));
      }
    }
    catch (Throwable paramFuture)
    {
      for (;;)
      {
        int i;
        c.a(this.a).b(this.b.j());
      }
    }
    finally
    {
      c.a(this.a).b(this.b.j());
    }
    return;
    i = 0;
    if (paramFuture != null)
    {
      ??? = new ArrayList();
      localObject3 = paramFuture.iterator();
      i = 0;
    }
    do
    {
      if (!((Iterator)localObject3).hasNext())
      {
        ??? = this.a;
        c.b(paramFuture, localDownloadResult);
        if (i == 0) {
          break;
        }
        this.a.a(this.b.j(), localDownloadResult);
        break;
      }
      ??? = (DownloadRequest)((Iterator)localObject3).next();
    } while (??? == null);
    label1005:
    int k;
    int m;
    int j;
    label1031:
    long l1;
    int n;
    if (((DownloadRequest)???).shouldCacheEntry())
    {
      i = 1;
      localObject5 = ((DownloadRequest)???).getPaths();
      if (localObject5 != null)
      {
        k = 0;
        m = localObject5.length;
        j = 0;
        break label1480;
        for (;;)
        {
          if (j == 0)
          {
            localObject6 = new File(localDownloadResult.getPath());
            l1 = ((File)localObject6).length();
            n = localObject5.length;
            j = 0;
            break label1494;
            label1068:
            if (!((List)???).contains(localObject5[j])) {
              break label1504;
            }
            j = 1;
            continue;
            label1088:
            locala = localObject5[j];
            if ((!TextUtils.isEmpty(locala)) && (!c.a(this.a, localDownloadResult, (DownloadRequest)???)) && (localDownloadResult.getPath() != null))
            {
              bool = ((List)???).contains(locala);
              if (!bool)
              {
                k = 0;
                m = 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label1146:
      long l2;
      if (((m >= 0) && (k == 0)) || (k != 0))
      {
        try
        {
          ((List)???).add(locala);
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.component.network.downloader.common.a.a("Downloader", "download ------- copy exception!!! " + this.b.j(), localThrowable2);
        }
        m -= 1;
        localObject7 = new File(locala);
        bool = FileUtils.copyFiles((File)localObject6, (File)localObject7);
        l2 = ((File)localObject7).length();
        if (!com.tencent.component.network.downloader.common.a.b()) {
          break label1513;
        }
        com.tencent.component.network.downloader.common.a.b("Downloader", "download copy from " + localDownloadResult.getPath() + " to:" + locala + " " + this.b.j() + " result:" + bool + " src-length:" + l1 + " dst-length:" + l2 + " retry:" + m);
      }
      label1480:
      label1494:
      label1504:
      label1511:
      label1513:
      while ((!bool) || (l1 != l2))
      {
        FileUtils.delete((File)localObject7);
        break label1146;
        for (;;)
        {
          j += 1;
          break;
          FileUtils.delete(new File(localThrowable2));
        }
        if (((DownloadRequest)???).outputStream != null) {
          FileUtils.copyFile(localDownloadResult.getPath(), ((DownloadRequest)???).outputStream);
        }
        break;
        break label1005;
        for (;;)
        {
          if (j < m) {
            break label1511;
          }
          j = k;
          break label1031;
          if (j < n) {
            break label1088;
          }
          break;
          j += 1;
        }
        break label1068;
      }
      k = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\impl\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */