package ct;

import android.location.Location;
import java.util.LinkedList;

public final class bz
{
  private static bz a = new bz();
  private int b = a.a;
  private LinkedList<cl> c = new LinkedList();
  
  public static bz a()
  {
    return a;
  }
  
  public final int a(cl paramcl)
  {
    if (paramcl != null)
    {
      try
      {
        while (this.c.size() > 9) {
          this.c.remove(0);
        }
        if (this.c.size() <= 0) {
          break label136;
        }
      }
      finally {}
      for (;;)
      {
        cl localcl = (cl)this.c.getFirst();
        long l1 = paramcl.b;
        long l2 = localcl.b;
        double d = b.a(localcl.a.getLatitude(), localcl.a.getLongitude(), paramcl.a.getLatitude(), paramcl.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      paramcl = new cl(paramcl);
      this.c.add(paramcl);
    }
    int i = this.c.size();
    return i;
  }
  
  public final long b()
  {
    for (;;)
    {
      double d1;
      long l;
      double d2;
      try
      {
        int j;
        int i;
        cl localcl2;
        if (this.c.size() < 2)
        {
          d1 = 0.0D;
          if (this.c.size() < 2) {
            continue;
          }
          j = this.c.size();
          l = 0L;
          d2 = 0.0D;
          i = 1;
          if (i < j)
          {
            localcl1 = (cl)this.c.get(i);
            localcl2 = (cl)this.c.get(i - 1);
            double d3 = b.a(localcl2.a.getLatitude(), localcl2.a.getLongitude(), localcl1.a.getLatitude(), localcl1.a.getLongitude());
            l = localcl1.b - localcl2.b + l;
            d2 += d3;
            i += 1;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localcl1 = (cl)this.c.get(i);
          localcl2 = (cl)this.c.get(i - 1);
          if (localcl1.b == localcl2.b) {
            break label477;
          }
          l = localcl1.b - localcl2.b;
          d1 = b.a(localcl2.a.getLatitude(), localcl2.a.getLongitude(), localcl1.a.getLatitude(), localcl1.a.getLongitude()) / l * 1000.0D;
          continue;
        }
        if (l > 0L)
        {
          d2 = d2 / l * 1000.0D;
          if (this.c.size() < 2)
          {
            l = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = a.a;
            i = this.b;
            j = a.c;
            if (i != j) {
              break label469;
            }
            l = 90000L;
            return l;
          }
        }
        else
        {
          d2 = 0.0D;
          continue;
        }
        cl localcl1 = (cl)this.c.getFirst();
        l = ((cl)this.c.getLast()).b - localcl1.b;
        continue;
        if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D))
        {
          this.b = a.c;
          continue;
        }
        if (l <= 60000L) {
          break label459;
        }
      }
      finally {}
      if ((d1 < 3.0D) && (d2 < 3.0D))
      {
        this.b = a.c;
      }
      else
      {
        label459:
        this.b = a.b;
        continue;
        label469:
        l = 30000L;
        continue;
        label477:
        l = 500L;
      }
    }
  }
  
  static enum a {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */