package ct;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class ay
{
  public int a = 1;
  public int b = 1;
  public int c = 20000;
  public ArrayList d = null;
  public ArrayList e = null;
  public String f = "dispatcher.3g.qq.com";
  public Socket g;
  public int h;
  public String i;
  public int j;
  public int k;
  public s l;
  private int m = 3;
  private int n = 0;
  private boolean o = false;
  private int p = 0;
  private boolean q = false;
  private int r;
  
  public ay()
  {
    int[] arrayOfInt = c.a;
    this.g = null;
    this.h = 0;
    this.r = 0;
    this.j = -1;
    this.k = -1;
  }
  
  private static ArrayList a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (paramInt1 >= paramArrayList.size())) {}
    do
    {
      return paramArrayList;
      paramInt2 = Math.min(paramInt2, paramArrayList.size() - paramInt1);
    } while (paramInt2 <= 0);
    ArrayList localArrayList = new ArrayList(paramInt2);
    paramArrayList = paramArrayList.subList(paramInt1, paramInt1 + paramInt2);
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      s locals = (s)paramArrayList.get(paramInt1);
      localArrayList.add(new s(locals.a, locals.b));
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public static void a(int[] paramArrayOfInt)
  {
    paramArrayOfInt.clone();
  }
  
  public final void a()
  {
    boolean bool;
    if ((this.d == null) || (this.d.size() <= 0))
    {
      bool = true;
      this.o = bool;
      if (this.e != null) {
        break label185;
      }
      bool = true;
      label36:
      this.q = bool;
      bc.a();
    }
    for (;;)
    {
      Object localObject;
      if (((!this.o) || (!this.q)) && (this.r <= this.m))
      {
        this.r += 1;
        if (!bb.f()) {
          break label191;
        }
        localObject = ax.a(this.f, this.c);
        if (localObject != null)
        {
          this.g = ((aw)localObject).c;
          this.i = ((aw)localObject).d;
        }
      }
      for (;;)
      {
        if ((this.g != null) && (this.g.isConnected()) && (!this.g.isClosed()))
        {
          this.l = new s(this.g.getInetAddress().getHostAddress(), this.g.getPort());
          this.h = 0;
          return;
          bool = false;
          break;
          label185:
          bool = false;
          break label36;
          label191:
          if (!this.o)
          {
            long l1 = System.currentTimeMillis();
            localObject = a(this.d, this.n, this.a);
            if ((localObject != null) && (((ArrayList)localObject).size() > 0))
            {
              this.n += ((ArrayList)localObject).size();
              if (this.n < this.d.size()) {}
            }
            else
            {
              this.o = true;
            }
            localObject = ax.a((ArrayList)localObject, this.c);
            if (localObject != null)
            {
              this.g = ((aw)localObject).c;
              this.i = ((aw)localObject).d;
            }
            this.j = 0;
            this.k = ((int)(System.currentTimeMillis() - l1));
            new StringBuilder("use IpList, dnsTime: 0 ,connectTime：").append(this.k);
            bc.a();
          }
          else
          {
            ArrayList localArrayList = new ArrayList();
            localObject = localArrayList;
            if (!this.q)
            {
              localObject = localArrayList;
              if (this.e != null)
              {
                localObject = localArrayList;
                if (this.e.size() > 0)
                {
                  localObject = localArrayList;
                  if (this.p < this.e.size())
                  {
                    localArrayList = a(this.e, this.p, this.b);
                    if ((localArrayList == null) || (localArrayList.size() <= 0)) {
                      break label527;
                    }
                    this.p += localArrayList.size();
                    localObject = localArrayList;
                    if (this.p < this.e.size()) {
                      break label445;
                    }
                    localObject = localArrayList;
                  }
                }
              }
              this.q = true;
            }
            for (;;)
            {
              label445:
              localObject = ax.a((ArrayList)localObject, this.f, this.c);
              if (localObject != null)
              {
                this.g = ((aw)localObject).c;
                this.i = ((aw)localObject).d;
              }
              this.j = ax.a;
              this.k = ax.b;
              new StringBuilder("use IpList DNS parallel , dnsTime:").append(this.j).append(",connectTime：").append(this.k);
              bc.a();
              break;
              label527:
              this.q = true;
              localObject = localArrayList;
            }
          }
        }
      }
      if (bb.e()) {
        this.h = -3;
      }
      try
      {
        Thread.sleep(3000L);
        for (;;)
        {
          this.g = null;
          break;
          this.h = -4;
          this.i = "netWork  Fail when Connect";
          try
          {
            Thread.sleep(5000L);
          }
          catch (Exception localException1) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */