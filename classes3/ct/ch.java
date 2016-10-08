package ct;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

public final class ch
{
  private int a = 10;
  private int b = 4;
  private LinkedList<a> c = new LinkedList();
  private bu d = new bu();
  
  private boolean a(a parama, bl parambl, boolean paramBoolean)
  {
    if (parambl == null)
    {
      paramBoolean = true;
      return paramBoolean;
    }
    for (;;)
    {
      int i;
      int k;
      try
      {
        if (parama.d == 1)
        {
          if ((!dd.a(parambl)) && (!dd.b(parambl)) && (!paramBoolean))
          {
            paramBoolean = true;
            break;
          }
          if ((this.c == null) || ((this.c != null) && (this.c.size() == 0))) {
            break label279;
          }
          if (parama.c - ((a)this.c.getLast()).c < 120000L)
          {
            paramBoolean = false;
            break;
          }
        }
        if (this.c.size() >= this.b)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          i = 0;
          parambl = this.c.listIterator(this.c.size());
          int j = 0;
          if (!parambl.hasPrevious()) {
            break label270;
          }
          a locala = (a)parambl.previous();
          if (b.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D) <= 40.0D) {
            continue;
          }
          k = 0;
          break label284;
          label218:
          j += 1;
          k = this.b;
          if (j <= k) {
            break label273;
          }
          if (i <= 1) {
            continue;
          }
          paramBoolean = false;
          break;
        }
        i = 0;
        continue;
        k = 1;
        break label284;
        paramBoolean = true;
        break;
      }
      finally {}
      label270:
      continue;
      label273:
      continue;
      label279:
      label284:
      do
      {
        break label218;
        paramBoolean = true;
        break;
      } while (k != 0);
      i += 1;
    }
  }
  
  public final void a()
  {
    try
    {
      this.c.clear();
      bu localbu = this.d;
      localbu.c = -1.0D;
      localbu.d = -1.0D;
      localbu.e = -1.0D;
      localbu.a = -1.0F;
      localbu.b = -1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(a.a(paramTencentLocation));
      if (this.c.size() > this.a) {
        this.c.removeFirst();
      }
      return;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  public final void a(cw paramcw)
  {
    try
    {
      double d1;
      bu localbu;
      double d3;
      double d4;
      double d2;
      long l3;
      if (paramcw.getProvider().equalsIgnoreCase("gps"))
      {
        d1 = paramcw.getSpeed();
        localbu = this.d;
        d3 = paramcw.getLatitude();
        d4 = paramcw.getLongitude();
        d2 = paramcw.getAccuracy();
        l3 = paramcw.getTime();
        if (d2 >= 1.0D) {
          break label427;
        }
        d2 = 1.0D;
      }
      for (;;)
      {
        localbu.a = ((float)d1);
        if (localbu.e < 0.0D)
        {
          localbu.b = l3;
          localbu.c = d3;
          localbu.d = d4;
        }
        for (localbu.e = (d2 * d2);; localbu.e = ((1.0D - d1) * localbu.e))
        {
          if (paramcw.getProvider().equals("network"))
          {
            d1 = this.d.c;
            d2 = this.d.d;
            paramcw.b.a = (Math.round(d1 * 1000000.0D) / 1000000.0D);
            paramcw.b.b = (Math.round(d2 * 1000000.0D) / 1000000.0D);
          }
          do
          {
            return;
          } while ((this.c == null) || ((this.c != null) && (this.c.size() == 0)));
          d1 = b.a(((a)this.c.getLast()).a, ((a)this.c.getLast()).b, paramcw.getLatitude(), paramcw.getLongitude()) / ((Math.abs(paramcw.getTime() - ((a)this.c.getLast()).c) + 1L) / 1000.0D);
          break;
          long l2 = l3 - localbu.b;
          long l1 = l2;
          if (l2 < 1L) {
            l1 = 1L;
          }
          if (l1 > 0L)
          {
            d1 = localbu.e;
            localbu.e = ((float)l1 * localbu.a + d1);
            localbu.b = l3;
          }
          d1 = 1.03D * localbu.e / (d2 * d2 + localbu.e * 1.03D);
          localbu.c += (d3 - localbu.c) * d1;
          localbu.d += (d4 - localbu.d) * d1;
        }
      }
    }
    finally {}
  }
  
  public final boolean a(TencentLocation paramTencentLocation, bl parambl, boolean paramBoolean)
  {
    try
    {
      paramBoolean = a(a.a(paramTencentLocation), parambl, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  static final class a
  {
    double a;
    double b;
    long c;
    int d;
    
    static a a(TencentLocation paramTencentLocation)
    {
      int i = 2;
      a locala = new a();
      locala.a = paramTencentLocation.getLatitude();
      locala.b = paramTencentLocation.getLongitude();
      locala.c = paramTencentLocation.getTime();
      paramTencentLocation.getSpeed();
      if (TencentLocationUtils.isFromGps(paramTencentLocation))
      {
        if (paramTencentLocation.getAccuracy() < 100.0F) {
          i = 3;
        }
        locala.d = i;
        return locala;
      }
      if (paramTencentLocation.getAccuracy() < 500.0F) {}
      for (;;)
      {
        locala.d = i;
        return locala;
        i = 1;
      }
    }
    
    public final String toString()
    {
      return "[" + this.a + "," + this.b + "]";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */