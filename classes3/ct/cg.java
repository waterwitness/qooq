package ct;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

final class cg
{
  final LinkedBlockingQueue<a> a;
  final bl b;
  long c;
  long d;
  long e;
  long f;
  volatile boolean g;
  
  cg(bl parambl)
  {
    this.b = parambl;
    this.a = new LinkedBlockingQueue(3);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TencentLogImpl.isDebugEnabled()) && (paramArrayOfByte != null)) {}
    try
    {
      if (e.o(paramArrayOfByte, 1) < 0) {
        return bw.a(paramInt, 0);
      }
      paramArrayOfByte = bw.a(paramInt, 1);
      return paramArrayOfByte;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte) {}
    return null;
  }
  
  final void a(a parama)
  {
    a.c(parama);
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (a.d((a)localIterator.next()) != a.d(parama));
    for (int i = 1;; i = 0)
    {
      if ((a.e(parama) > 0) && (i == 0))
      {
        new StringBuilder("retryIfNeed: times=").append(a.e(parama));
        this.a.offer(parama);
      }
      return;
    }
  }
  
  public final void a(String paramString, cm paramcm, int paramInt)
  {
    SystemClock.elapsedRealtime();
    try
    {
      byte[] arrayOfByte = b.a(paramString.getBytes("GBK"));
      paramcm = new a(arrayOfByte, a(arrayOfByte, paramInt), paramcm);
      paramcm.b = paramString;
      boolean bool = false;
      if (a.a(paramcm) != null) {
        bool = this.a.offer(paramcm);
      }
      if (!bool)
      {
        this.a.clear();
        this.a.offer(paramcm);
      }
      return;
    }
    catch (UnsupportedEncodingException paramString) {}
  }
  
  static final class a
  {
    public static final a d = new a();
    final Object a;
    public String b;
    public long c;
    private final int e;
    private final byte[] f;
    private final String g;
    private int h = 1;
    
    private a()
    {
      this.e = 0;
      this.f = null;
      this.g = null;
      this.a = null;
    }
    
    a(byte[] paramArrayOfByte, String paramString, Object paramObject)
    {
      this.e = 1;
      this.f = paramArrayOfByte;
      this.g = paramString;
      this.a = paramObject;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */