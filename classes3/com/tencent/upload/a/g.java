package com.tencent.upload.a;

import android.content.Context;
import android.net.wifi.WifiManager.WifiLock;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.upload.common.c;
import com.tencent.upload.common.f;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.IUploadTaskType;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class g
  implements IUploadService
{
  private static g a;
  private boolean b;
  private boolean c;
  private SparseArray<a> d;
  private b e;
  private HandlerThread f;
  private c g;
  private final byte[] h = new byte[0];
  private int i = 0;
  private final byte[] j = new byte[0];
  private SparseArray<AbstractUploadTask> k = new SparseArray();
  private final ReentrantReadWriteLock l = new ReentrantReadWriteLock();
  private final ReentrantReadWriteLock.ReadLock m = this.l.readLock();
  private final ReentrantReadWriteLock.WriteLock n = this.l.writeLock();
  private volatile boolean o;
  private long p;
  private boolean q;
  private final com.tencent.upload.network.b.b r = new com.tencent.upload.network.b.b(this.s);
  private final com.tencent.upload.network.a s = new h(this);
  private final IUploadService.IUploadServiceContext t = new i(this);
  private PowerManager.WakeLock u;
  private WifiManager.WifiLock v = null;
  
  public static IUploadService a()
  {
    return a.a();
  }
  
  public static IUploadService b()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g();
      }
      return a;
    }
    finally {}
  }
  
  private void c()
  {
    f();
    if (!this.c) {
      b.a("ServiceImpl", "checkToSetCloseTimer() !mNetworkIdle");
    }
    do
    {
      return;
      if (this.g.hasMessages(0))
      {
        b.a("ServiceImpl", "checkToSetCloseTimer() has MSG_UPLOAD_TASK");
        return;
      }
      if ((this.d != null) && (this.d.size() > 0))
      {
        b.a("ServiceImpl", "checkToSetCloseTimer() has mImageCompressingTasks");
        return;
      }
      b.a("ServiceImpl", "setCloseTimer()");
      this.g.removeMessages(2);
      this.g.sendMessageDelayed(this.g.obtainMessage(2), 300000L);
      this.g.sendMessageDelayed(this.g.obtainMessage(9), 30000L);
      this.b = true;
      h();
    } while (!this.q);
    this.p = SystemClock.elapsedRealtime();
    b.a("ServiceImpl", "mEnterBackgroundIdleTime=" + this.p);
  }
  
  private void d()
  {
    synchronized (this.h)
    {
      if ((this.f != null) && (this.f.isAlive())) {
        return;
      }
      b.a("ServiceImpl", "initWorkerThread()");
      this.f = new HandlerThread("uploadHandle");
      this.f.start();
      this.g = new j(this, this.f.getLooper());
      return;
    }
  }
  
  private void e()
  {
    if (this.d != null)
    {
      int i2 = this.d.size();
      int i1 = 0;
      if (i1 < i2)
      {
        if (!(this.d.valueAt(i1) instanceof a)) {
          b.e("ServiceImpl", "destroyCompressPendingTasks() find element not instance of ImageCompressPendingTask");
        }
        for (;;)
        {
          i1 += 1;
          break;
          AbstractUploadTask localAbstractUploadTask = ((a)this.d.valueAt(i1)).a;
          if (localAbstractUploadTask.uploadTaskCallback != null) {
            localAbstractUploadTask.uploadTaskCallback.onUploadStateChange(localAbstractUploadTask, 2);
          }
        }
      }
      this.d.clear();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.b();
      this.e = null;
    }
  }
  
  private void f()
  {
    if (!this.b) {
      return;
    }
    this.g.removeMessages(2);
    this.g.removeMessages(9);
    this.b = false;
    b.a("ServiceImpl", "removeCloseTimer");
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.g.hasMessages(0)) {
      if (this.d != null)
      {
        bool1 = bool2;
        if (this.d.size() != 0) {}
      }
      else
      {
        bool1 = bool2;
        if (this.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void h()
  {
    if ((this.u != null) && (this.u.isHeld()))
    {
      this.u.release();
      this.u = null;
      b.b("ServiceImpl", "releaseWakeLock()");
    }
    if ((this.v != null) && (this.v.isHeld()))
    {
      this.v.release();
      this.v = null;
      b.b("ServiceImpl", "releaseWifiLock()");
    }
  }
  
  public boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    if (!this.o)
    {
      b.b("ServiceImpl", "cancel !mInit");
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      b.b("ServiceImpl", "cancel() task==null");
      return false;
    }
    if (this.g == null)
    {
      b.b("ServiceImpl", "cancel() mWorkerThreadHandler==null");
      return false;
    }
    this.g.obtainMessage(8, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public boolean clearCacheWhenIdle(Context paramContext)
  {
    b.b("ServiceImpl", "clearCacheWhenIdle");
    synchronized (this.h)
    {
      if (this.g == null)
      {
        com.tencent.upload.common.b.a(paramContext, 0L, 0L);
        b.b("ServiceImpl", "clearUploadDir isUploadIdle");
        return true;
      }
      return false;
    }
  }
  
  public boolean commit(AbstractUploadTask paramAbstractUploadTask)
  {
    if (!this.o)
    {
      b.b("ServiceImpl", "commit !mInit");
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      b.b("ServiceImpl", "commit() task==null");
      return false;
    }
    if (this.g == null)
    {
      b.b("ServiceImpl", "commit() mWorkerThreadHandler==null");
      return false;
    }
    this.g.obtainMessage(15, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv)
  {
    long l1 = System.currentTimeMillis();
    f.a(paramContext, paramIUploadConfig, paramIUploadLog, paramIUploadReport, paramIUploadEnv);
    boolean bool = this.o;
    this.o = true;
    b.b("ServiceImpl", "init! ms:" + (System.currentTimeMillis() - l1) + " oldInitialization:" + bool);
  }
  
  public boolean isInitialized()
  {
    return this.o;
  }
  
  public void pauseAllTask()
  {
    if (!this.o) {
      return;
    }
    if (this.g == null)
    {
      b.b("ServiceImpl", "close() mWorkerThreadHandler==null");
      return;
    }
    this.g.obtainMessage(7).sendToTarget();
  }
  
  public void prepare(IUploadTaskType paramIUploadTaskType)
  {
    if (!this.o)
    {
      b.b("ServiceImpl", "prepare !mInit");
      return;
    }
    b.b("ServiceImpl", "prepare() type=" + paramIUploadTaskType);
    d();
    int i1 = paramIUploadTaskType.getServerCategory();
    this.g.obtainMessage(3, i1, 0).sendToTarget();
  }
  
  public void setBackgroundMode(boolean paramBoolean)
  {
    if (!this.o) {
      b.b("ServiceImpl", "setBackgroundMode !mInit");
    }
    while (this.g == null) {
      return;
    }
    c localc = this.g;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      localc.obtainMessage(10, i1, 0).sendToTarget();
      return;
    }
  }
  
  public void setTestServer(int paramInt)
  {
    if (!this.o) {
      b.b("ServiceImpl", "setTestServer !mInit");
    }
    while (this.g == null) {
      return;
    }
    this.g.obtainMessage(12, paramInt, 0).sendToTarget();
  }
  
  public boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    synchronized (this.j)
    {
      this.k.append(paramAbstractUploadTask.flowId, paramAbstractUploadTask);
      if (!this.o)
      {
        b.b("ServiceImpl", "upload !mInit");
        return false;
      }
    }
    if (!b.c(paramAbstractUploadTask))
    {
      b.b("ServiceImpl", "upload !verifyUploadTask");
      synchronized (this.j)
      {
        this.k.remove(paramAbstractUploadTask.flowId);
        return false;
      }
    }
    this.m.lock();
    try
    {
      d();
      this.g.obtainMessage(0, paramAbstractUploadTask).sendToTarget();
      return true;
    }
    finally
    {
      this.m.unlock();
    }
  }
  
  static final class a
  {
    private static final g a = new g((byte)0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */