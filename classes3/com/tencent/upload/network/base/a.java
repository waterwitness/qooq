package com.tencent.upload.network.base;

import android.util.SparseArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.b.b.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements c, d, e
{
  private static final AtomicInteger c = new AtomicInteger(0);
  private ConnectionImpl a = null;
  private WeakReference<d> b;
  private SparseArray<Object> d = new SparseArray();
  private byte[] e = new byte[0];
  private volatile boolean f = false;
  private String g;
  
  public a(d paramd)
  {
    int i = UploadConfiguration.getDoNotFragment();
    this.b = new WeakReference(paramd);
    if (!ConnectionImpl.isLibraryPrepared())
    {
      com.tencent.upload.a.b.e("Connection", "!isLibraryPrepared");
      return;
    }
    this.a = new ConnectionImpl(e(), i);
    this.a.setCallback(this);
    this.a.setMsgCallback(this);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    a locala;
    String str;
    do
    {
      synchronized (this.e)
      {
        Object localObject2 = this.d.get(paramInt2);
        this.d.remove(paramInt2);
        switch (paramInt1)
        {
        default: 
          return;
        }
      }
      if ((this.a == null) || (!(localObject3 instanceof a))) {
        break label214;
      }
      locala = (a)localObject3;
      ??? = locala.a;
      paramInt1 = UploadConfiguration.getMaxSegmentSize((String)???);
      if (com.tencent.upload.common.d.b(locala.a)) {
        break;
      }
      ??? = new b.a();
      com.tencent.upload.network.b.b.a(locala.a, (b.a)???);
      str = ((b.a)???).a;
      ((b.a)???).a = null;
      ??? = str;
      if (str != null) {
        break;
      }
      this.f = false;
      ??? = (d)this.b.get();
    } while (??? == null);
    ((d)???).a(this, false, 558, str);
    return;
    this.a.connect((String)???, locala.b, locala.c, locala.d, locala.e, paramInt1);
    this.g = ((String)???);
    return;
    label214:
    ??? = new StringBuilder(" OperationMsg.CONNECT, obj instanceof ConnectParam:").append(str instanceof a).append("mNativeConnection != null:");
    if (this.a != null) {}
    for (bool = true;; bool = false)
    {
      com.tencent.upload.a.b.d("Connection", bool);
      return;
    }
    if (this.a != null)
    {
      this.a.disconnect();
      return;
    }
    com.tencent.upload.a.b.d("Connection", " OperationMsg.DISCONNECT, mNativeConnection == null");
    return;
    if ((this.a != null) && ((str instanceof b)))
    {
      ??? = (b)str;
      this.a.SendData(((b)???).a, ((b)???).b, ((b)???).c, 60000);
      return;
    }
    ??? = new StringBuilder(" OperationMsg.SEND, obj instanceof ConnectParam:").append(str instanceof b).append("mNativeConnection != null:");
    if (this.a != null) {}
    for (;;)
    {
      com.tencent.upload.a.b.d("Connection", bool);
      return;
      bool = false;
    }
  }
  
  public final void a(d paramd)
  {
    d locald = (d)this.b.get();
    if (locald == null) {
      return;
    }
    locald.a(paramd);
  }
  
  public final void a(d paramd, int paramInt)
  {
    d locald = (d)this.b.get();
    if (locald == null) {
      return;
    }
    locald.a(paramd, paramInt);
  }
  
  public final void a(d paramd, int paramInt1, int paramInt2)
  {
    d locald = (d)this.b.get();
    if (locald == null) {
      return;
    }
    locald.a(paramd, paramInt1, paramInt2);
  }
  
  public final void a(d paramd, boolean paramBoolean, int paramInt, String paramString)
  {
    this.f = paramBoolean;
    d locald = (d)this.b.get();
    if (locald == null) {
      return;
    }
    locald.a(paramd, paramBoolean, paramInt, paramString);
  }
  
  public final void a(d paramd, byte[] paramArrayOfByte)
  {
    d locald = (d)this.b.get();
    if (locald == null) {
      return;
    }
    locald.a(paramd, paramArrayOfByte);
  }
  
  public final boolean a()
  {
    if (this.a == null) {
      return false;
    }
    if (this.a.isRunning())
    {
      com.tencent.upload.a.b.d("Connection", "start, is running, return false");
      return false;
    }
    return this.a.start();
  }
  
  public final boolean a(String arg1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (this.a == null) {
      return false;
    }
    paramString2 = new a(???, paramInt1, paramString2, paramInt2, paramInt3);
    paramInt1 = c.incrementAndGet();
    synchronized (this.e)
    {
      this.d.put(paramInt1, paramString2);
      return this.a.PostMessage(0, null, paramInt1);
    }
  }
  
  public final boolean a(byte[] arg1, int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return false;
    }
    b localb = new b(???, paramInt1, paramInt2);
    paramInt1 = c.incrementAndGet();
    synchronized (this.e)
    {
      this.d.put(paramInt1, localb);
      return this.a.PostMessage(2, null, paramInt1);
    }
  }
  
  public final void b(d paramd)
  {
    this.f = false;
    d locald = (d)this.b.get();
    if (locald == null) {
      return;
    }
    locald.b(paramd);
  }
  
  public final void b(d paramd, int paramInt)
  {
    d locald = (d)this.b.get();
    if (locald == null) {
      return;
    }
    locald.b(paramd, paramInt);
  }
  
  public final boolean b()
  {
    if (this.a == null) {
      return false;
    }
    this.a.removeAllSendData();
    boolean bool = this.a.stop();
    synchronized (this.e)
    {
      this.d.clear();
      return bool;
    }
  }
  
  public final void c()
  {
    if (this.a == null) {
      return;
    }
    this.a.wakeUp();
  }
  
  public final void c(d paramd, int paramInt)
  {
    d locald = (d)this.b.get();
    if (locald == null) {
      return;
    }
    locald.c(paramd, paramInt);
  }
  
  public final String d()
  {
    return this.g;
  }
  
  static final class a
  {
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final int e;
    
    public a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
    {
      this.a = paramString1;
      this.b = paramInt1;
      this.c = paramString2;
      this.d = paramInt2;
      this.e = paramInt3;
    }
  }
  
  static final class b
  {
    public final byte[] a;
    public final int b;
    public final int c;
    
    public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.a = paramArrayOfByte;
      this.b = paramInt1;
      this.c = paramInt2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */