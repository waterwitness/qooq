package com.tencent.upload.network.b;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.a;
import com.tencent.upload.network.c.b;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.Utility.ServerCategory;
import com.tencent.upload.uinterface.Utility.TestServerCategory;
import java.lang.ref.WeakReference;

public final class b
  implements c.b
{
  private final SparseArray<com.tencent.upload.network.b> a = new SparseArray();
  private final SparseBooleanArray b = new SparseBooleanArray();
  private Looper c = null;
  private final WeakReference<a> d;
  private final byte[] e = new byte[0];
  
  public b(a parama)
  {
    this.d = new WeakReference(parama);
  }
  
  public static void a(String paramString, a parama)
  {
    com.tencent.upload.a.b.c("DomainParser", "parse: start, domainName:" + paramString);
    if (paramString == null)
    {
      com.tencent.upload.a.b.c("DomainParser", "parse: return, domainName == null");
      return;
    }
    synchronized (new byte[0])
    {
      new Thread(new c(paramString, ???, parama), "domainParser").start();
    }
    try
    {
      ???.wait(UploadConfiguration.getDomainNameParseTimeout());
      com.tencent.upload.a.b.c("DomainParser", "parse return, get domainName:" + paramString + " to ip:" + parama.a);
      return;
      paramString = finally;
      throw paramString;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        com.tencent.upload.a.b.d("DomainParser", "parse: wait:" + localInterruptedException);
      }
    }
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "unknown";
    case 0: 
      return "connectionFailed";
    case 1: 
      return "handshakeFailed";
    case 2: 
      return "unpacketFailed";
    }
    return "socketFailed";
  }
  
  private com.tencent.upload.network.b c(int paramInt)
  {
    if (this.c == null)
    {
      ??? = new HandlerThread("uploadCore");
      ((HandlerThread)???).start();
      this.c = ((HandlerThread)???).getLooper();
    }
    ??? = (com.tencent.upload.network.b)this.a.get(paramInt);
    if (??? != null) {
      return (com.tencent.upload.network.b)???;
    }
    int i = UploadConfiguration.getTestRouteServer();
    boolean bool = Utility.TestServerCategory.useTestServer(i);
    ??? = UploadConfiguration.createRouteStrategy(paramInt);
    if (bool) {
      ??? = UploadConfiguration.createTestRouteStrategy(paramInt, i);
    }
    for (;;)
    {
      if (??? == null) {
        return null;
      }
      com.tencent.upload.network.c localc = new com.tencent.upload.network.c((d)???, this.c, this);
      this.a.put(paramInt, localc);
      synchronized (this.e)
      {
        this.b.append(paramInt, true);
        return localc;
      }
    }
  }
  
  public final void a()
  {
    com.tencent.upload.a.b.b("SessionService", hashCode() + " close");
    while (this.a.size() > 0)
    {
      com.tencent.upload.network.b localb = (com.tencent.upload.network.b)this.a.valueAt(0);
      this.a.delete(this.a.keyAt(0));
      if (localb != null) {
        localb.c();
      }
    }
    if (this.c != null)
    {
      this.c.quit();
      this.c = null;
    }
  }
  
  public final void a(com.tencent.upload.network.b paramb, m paramm, String paramString)
  {
    int i = paramb.a();
    paramb = (a)this.d.get();
    if (paramb == null) {
      return;
    }
    paramb.a(paramm, "serverCategory:" + i + " " + paramString);
  }
  
  public final void a(com.tencent.upload.network.b arg1, boolean paramBoolean)
  {
    int j = 0;
    for (int i = ???.a();; i = 1) {
      for (;;)
      {
        synchronized (this.e)
        {
          this.b.put(i, paramBoolean);
          if (paramBoolean)
          {
            int k = this.b.size();
            i = 0;
            if (i >= k) {
              break;
            }
            if (!this.b.valueAt(i))
            {
              i = j;
              if (i != 0) {}
            }
            else
            {
              i += 1;
              continue;
            }
          }
          a locala = (a)this.d.get();
          if (locala == null) {
            continue;
          }
          StringBuilder localStringBuilder = new StringBuilder().append(hashCode()).append(" callback onCloseCountdown:");
          if (paramBoolean)
          {
            ??? = "startCloseCountdown";
            com.tencent.upload.a.b.b("SessionService", ???);
            locala.a(paramBoolean);
            return;
          }
        }
        ??? = "stopCloseCountdown";
      }
    }
  }
  
  public final boolean a(int paramInt)
  {
    com.tencent.upload.network.b localb = c(paramInt);
    if (localb == null) {
      return false;
    }
    return localb.b();
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    com.tencent.upload.a.b.b("SessionService", hashCode() + " cancel: actionSequence:" + paramInt1 + " cancelState:" + paramInt2);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      com.tencent.upload.network.b localb = (com.tencent.upload.network.b)this.a.valueAt(i);
      if (localb != null) {
        localb.a(paramInt1, paramInt2);
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean a(IUploadAction paramIUploadAction)
  {
    if (paramIUploadAction == null) {
      return false;
    }
    int i = paramIUploadAction.getServerCategory();
    com.tencent.upload.network.b localb = c(i);
    StringBuilder localStringBuilder = new StringBuilder().append(hashCode()).append(" upload: ");
    if (paramIUploadAction == null) {}
    for (String str = "null";; str = paramIUploadAction.getClass().getSimpleName())
    {
      com.tencent.upload.a.b.b("SessionService", str + " actSeq:" + com.tencent.upload.a.b.a(paramIUploadAction) + " " + Utility.ServerCategory.print(i));
      if (localb != null) {
        break;
      }
      return false;
    }
    return localb.a(paramIUploadAction);
  }
  
  public final void b()
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      com.tencent.upload.network.b localb = (com.tencent.upload.network.b)this.a.get(this.a.keyAt(i));
      if (localb != null) {
        localb.d();
      }
      i += 1;
    }
  }
  
  public final void b(com.tencent.upload.network.b paramb, m paramm, String paramString)
  {
    int i = paramb.a();
    paramb = (a)this.d.get();
    if (paramb == null) {
      return;
    }
    paramb.b(paramm, "serverCategory:" + i + " " + paramString);
  }
  
  public final boolean b(int paramInt1, int paramInt2)
  {
    com.tencent.upload.a.b.b("SessionService", hashCode() + " switchServer:" + Utility.ServerCategory.print(paramInt1) + " testServer:" + paramInt2);
    com.tencent.upload.network.b localb = c(paramInt1);
    if (localb == null) {}
    for (;;)
    {
      return false;
      if (Utility.TestServerCategory.useTestServer(paramInt2)) {}
      for (d locald = UploadConfiguration.createTestRouteStrategy(paramInt1, paramInt2); locald != null; locald = UploadConfiguration.createRouteStrategy(paramInt1)) {
        return localb.a(locald);
      }
    }
  }
  
  public static final class a
  {
    public String a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */