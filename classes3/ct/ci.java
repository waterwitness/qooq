package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

final class ci
  extends BroadcastReceiver
{
  static Handler g;
  volatile boolean a;
  final bl b;
  long c;
  long d;
  int e;
  boolean f;
  final bt h;
  final bt i;
  private final WifiManager j;
  private final Runnable k;
  private HashMap<String, ScanResult> l = new HashMap();
  private List<ScanResult> m = new ArrayList();
  
  public ci(bl parambl)
  {
    this.b = parambl;
    this.j = parambl.f;
    this.h = new bt();
    this.i = new bt();
    this.k = new Runnable()
    {
      public final void run()
      {
        ci.a(ci.this);
        ci.a(ci.this, ci.b(ci.this).b.l);
        new StringBuilder("Interval:").append(ci.b(ci.this).b.l);
      }
    };
  }
  
  private List<ScanResult> a(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return Collections.emptyList();
    }
    this.l.clear();
    this.m.clear();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (ScanResult)paramList.next();
      if (!this.l.containsKey(((ScanResult)localObject).BSSID)) {
        this.l.put(((ScanResult)localObject).BSSID, localObject);
      }
    }
    paramList = this.l.entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (Map.Entry)paramList.next();
      this.m.add(((Map.Entry)localObject).getValue());
    }
    return this.m;
  }
  
  private void b()
  {
    Object localObject3 = this.h;
    Object localObject4 = this.i;
    int n;
    if (((bt)localObject4).a.size() == 0)
    {
      n = 1;
      if (n == 0) {
        break label113;
      }
    }
    label113:
    bt localbt;
    label199:
    label301:
    label303:
    for (Object localObject1 = new bt(((bt)localObject3).a, ((bt)localObject3).b, ((bt)localObject3).c);; localObject1 = localbt)
    {
      localObject1 = a(((bt)localObject1).a);
      long l1 = this.c;
      this.j.getWifiState();
      localObject1 = new co((List)localObject1, l1);
      this.b.c(localObject1);
      if (dd.a) {
        c();
      }
      return;
      n = 0;
      break;
      Object localObject2;
      CopyOnWriteArrayList localCopyOnWriteArrayList;
      if (((bt)localObject3).c > ((bt)localObject4).c)
      {
        localObject2 = ((bt)localObject4).a;
        localObject1 = ((bt)localObject3).a;
        localbt = new bt();
        localCopyOnWriteArrayList = localbt.a;
        localbt.b = Math.max(((bt)localObject3).b, ((bt)localObject4).b);
        localbt.c = Math.max(((bt)localObject3).c, ((bt)localObject4).c);
        localCopyOnWriteArrayList.addAll((Collection)localObject1);
        localObject1 = ((CopyOnWriteArrayList)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label303;
        }
        localObject2 = (ScanResult)((Iterator)localObject1).next();
        localObject3 = ((ScanResult)localObject2).BSSID;
        localObject4 = localbt.a.iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
        } while (!((ScanResult)((Iterator)localObject4).next()).BSSID.equals(localObject3));
        for (n = 1;; n = 0)
        {
          if (n != 0) {
            break label301;
          }
          localCopyOnWriteArrayList.add(localObject2);
          break label199;
          localObject2 = ((bt)localObject3).a;
          localObject1 = ((bt)localObject4).a;
          break;
        }
      }
    }
  }
  
  private void c()
  {
    int n = 1;
    int i1 = this.j.getWifiState();
    if (i1 == 3) {
      a(0L);
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12001;
      localMessage.arg2 = n;
      this.b.c(localMessage);
      return;
      if (i1 == 1)
      {
        n = 0;
        this.h.a.clear();
        this.i.a.clear();
        this.b.c(co.a);
      }
      else
      {
        n = -1;
      }
    }
  }
  
  final void a(long paramLong)
  {
    Handler localHandler = g;
    Runnable localRunnable = this.k;
    localHandler.removeCallbacks(localRunnable);
    localHandler.postDelayed(localRunnable, paramLong);
  }
  
  final boolean a()
  {
    boolean bool1;
    if (!dd.b(this.b)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = dd.a(this.j);
      bool1 = bool2;
    } while (!bool2);
    this.d = System.currentTimeMillis();
    return bool2;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    int i2 = 0;
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) {
        c();
      }
    } while ((!"android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) && (!"android.net.wifi.SCAN_RESULTS".equals(paramContext)));
    paramContext = cj.a(dd.b(this.j));
    this.c = System.currentTimeMillis();
    int n;
    if (this.e == 0)
    {
      this.i.a.clear();
      this.h.a.clear();
      paramIntent = this.h;
      paramIntent.a.clear();
      paramIntent.b = this.d;
      paramIntent.c = this.c;
      paramIntent.a(paramContext);
      int i1 = i2;
      if (this.f)
      {
        if (paramIntent.a.size() >= 7) {
          break label201;
        }
        n = 1;
        if ((n == 0) || (!a())) {
          break label206;
        }
        n = 1;
        label160:
        i1 = i2;
        if (n != 0) {
          i1 = 1;
        }
      }
      if (i1 != 0) {
        this.e = 1;
      }
    }
    for (;;)
    {
      this.f = true;
      a(this.b.b.l);
      return;
      label201:
      n = 0;
      break;
      label206:
      n = 0;
      break label160;
      b();
      continue;
      this.e = 0;
      paramIntent = this.i;
      paramIntent.a.clear();
      paramIntent.b = this.d;
      paramIntent.c = this.c;
      paramIntent.a(paramContext);
      b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */