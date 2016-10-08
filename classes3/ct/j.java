package ct;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.NetworkInfo;

final class j
{
  private static j d = null;
  n a;
  final BroadcastReceiver b = new k(this);
  final BroadcastReceiver c = new m(this);
  
  public static j a()
  {
    try
    {
      if (d == null) {
        d = new j();
      }
      j localj = d;
      return localj;
    }
    finally {}
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      try
      {
        j localj = j.this;
        if (localj.a != null) {
          localj.a.b();
        }
        for (;;)
        {
          bc.b();
          return;
          bc.c();
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private Intent a;
    
    b(Intent paramIntent)
    {
      this.a = paramIntent;
    }
    
    public final void run()
    {
      try
      {
        Object localObject = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
        j localj = j.this;
        if (localObject != null)
        {
          localObject = bb.b;
          bb.b();
          String str = bb.b;
          if (!((String)localObject).equals(str))
          {
            if ((((String)localObject).equals(bb.a)) && (bb.e()))
            {
              bc.b();
              if (localj.a != null)
              {
                localj.a.b();
                return;
              }
              bc.c();
              return;
            }
            if ((str.equals(bb.a)) || (!bb.e()))
            {
              bc.b();
              return;
            }
            new StringBuilder("onTrigger：  apn1：").append((String)localObject).append(" ,apn2：").append(str);
            bc.b();
            if (localj.a != null)
            {
              localj.a.b();
              return;
            }
            bc.c();
          }
        }
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */