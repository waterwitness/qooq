package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONException;

public final class cb
{
  private static SparseArray<String> m;
  private final bn A;
  private ck B;
  private co C;
  private cl D;
  private final bl E;
  private final Object F = new Object();
  private final TencentLocationRequest G = TencentLocationRequest.create();
  private double H;
  private double I;
  private cw J;
  private String K;
  private boolean L;
  private long M;
  private long N;
  private boolean O = false;
  public int a = 1;
  public TencentLocationListener b;
  public String c = "start";
  public boolean d = false;
  public double e = 0.0D;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public TencentLocation i;
  public TencentDistanceListener j;
  public cw k;
  public int l = 404;
  private a n;
  private final bv o;
  private final ce p;
  private final boolean q;
  private final ca r;
  private final ci s;
  private final bx t;
  private final cd u;
  private final cg v;
  private final by w;
  private HandlerThread x;
  private int y = 0;
  private ch z;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    m = localSparseArray;
    localSparseArray.put(0, "OK");
    m.put(1, "ERROR_NETWORK");
    m.put(2, "BAD_JSON");
    m.put(4, "DEFLECT_FAILED");
  }
  
  public cb(bl parambl)
  {
    this.E = parambl;
    if (parambl.b.s) {
      cy.a(parambl.a);
    }
    this.A = bo.b();
    this.u = new cd(this.E);
    this.v = new cg(this.E);
    this.w = new by(this.E);
    this.z = new ch();
    this.t = bx.a(parambl.a);
    this.q = e();
    if (this.q)
    {
      this.o = null;
      this.s = g();
      if (!this.E.a()) {}
      for (parambl = (bl)localObject1;; parambl = new ce(this.E))
      {
        this.p = parambl;
        this.r = f();
        return;
      }
    }
    this.p = null;
    this.s = g();
    if (!this.E.a()) {}
    for (parambl = (bl)localObject2;; parambl = new bv(this.E))
    {
      this.o = parambl;
      this.r = f();
      return;
    }
  }
  
  private static String a(String paramString)
  {
    int i1 = 1;
    if (paramString.contains(",")) {}
    try
    {
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length <= 1) || (paramString[0] == null) || (paramString[1] == null) || (e.w(paramString[0], paramString[1]) <= 0)) {
        break label83;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      return null;
    }
    i1 = e.v(paramString);
    if (i1 >= 0) {
      return Integer.toString(i1);
    }
    return "";
    while (i1 != 0)
    {
      return paramString[0];
      label83:
      i1 = 0;
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if (this.n != null) {
      this.n.sendEmptyMessage(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str = null;
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      localObject2 = null;
    }
    synchronized (this.F)
    {
      for (;;)
      {
        if (this.b != null) {
          this.b.onStatusUpdate((String)localObject2, paramInt2, str);
        }
        return;
        localObject2 = "gps";
        if (paramInt2 == 1)
        {
          str = "gps enabled";
        }
        else if (paramInt2 == 0)
        {
          str = "gps disabled";
        }
        else
        {
          str = "unknown";
          continue;
          localObject2 = "gps";
          if (paramInt2 == 3) {
            str = "gps available";
          } else if (paramInt2 == 4) {
            str = "gps unavailable";
          } else {
            str = "unknown";
          }
        }
      }
      ??? = "cell";
      if (paramInt2 == 1) {
        str = "cell enabled";
      }
      for (;;)
      {
        localObject2 = ???;
        if (!cx.a) {
          break;
        }
        str = "cell permission denied";
        paramInt2 = 2;
        localObject2 = ???;
        break;
        if (paramInt2 == 0) {
          str = "cell disabled";
        } else {
          str = "unknown";
        }
      }
      ??? = "wifi";
      if (paramInt2 == 1) {}
      for (str = "wifi enabled";; str = "wifi disabled")
      {
        localObject2 = ???;
        if (!dd.a) {
          break;
        }
        str = "wifi scan permission denied";
        paramInt2 = 2;
        localObject2 = ???;
        break;
        if (paramInt2 != 0) {
          break label242;
        }
      }
      label242:
      str = "unknown";
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.n != null)
    {
      this.n.removeMessages(paramInt);
      this.n.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(int paramInt, cw paramcw)
  {
    if (paramcw == null) {}
    label421:
    label464:
    label477:
    label488:
    for (;;)
    {
      return;
      if (i())
      {
        this.l = paramInt;
        this.k = paramcw;
        if ((paramcw.getAccuracy() < 500.0F) && (paramcw.getAccuracy() > 0.0F))
        {
          this.z.a(paramcw);
          if (this.d) {
            this.i = paramcw;
          }
        }
        this.H = paramcw.getLatitude();
        this.I = paramcw.getLongitude();
        if (this.G.getInterval() == 0L)
        {
          if (this.b != null) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            a(11998);
            return;
          }
        }
        if (this.G.getInterval() > 0L) {
          a(11999, 0L);
        }
      }
      else if ((paramInt == 0) && (paramcw.getLatitude() != 0.0D) && (paramcw.getLongitude() != 0.0D) && (Math.abs(paramcw.getLatitude() - this.H) >= 1.0E-7D) && (Math.abs(paramcw.getLongitude() - this.I) >= 1.0E-7D))
      {
        if (!this.z.a(paramcw, this.E, this.r.b()))
        {
          new StringBuilder("discard ").append(paramcw);
          return;
        }
        this.H = paramcw.getLatitude();
        this.I = paramcw.getLongitude();
        if ((paramcw.getAccuracy() < 500.0F) && (paramcw.getAccuracy() > 0.0F))
        {
          this.z.a(paramcw);
          this.z.a(paramcw);
          if (this.d)
          {
            if (this.i == null) {
              break label477;
            }
            double d1 = b.a(this.i.getLatitude(), this.i.getLongitude(), paramcw.getLatitude(), paramcw.getLongitude());
            if (((paramcw.getProvider().equalsIgnoreCase("network")) && (d1 > 10.0D)) || ((paramcw.getProvider().equalsIgnoreCase("gps")) && (d1 > 3.0D)))
            {
              this.e = (d1 + this.e);
              if (!paramcw.getProvider().equalsIgnoreCase("network")) {
                break label464;
              }
              this.g += 1;
              this.h += 1;
              this.i = paramcw;
            }
          }
        }
        this.l = paramInt;
        this.k = paramcw;
        if (this.G.getInterval() == 0L)
        {
          if (this.b != null) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label488;
            }
            a(11998);
            return;
            this.f += 1;
            break;
            this.i = paramcw;
            break label421;
          }
        }
      }
    }
  }
  
  private boolean e()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      ExecutorService localExecutorService = Executors.newFixedThreadPool(1);
      Callable local1 = new Callable() {};
      try
      {
        boolean bool = ((Boolean)localExecutorService.submit(local1).get(500L, TimeUnit.MILLISECONDS)).booleanValue();
        localExecutorService.shutdown();
        return bool;
      }
      catch (TimeoutException localTimeoutException)
      {
        localTimeoutException = localTimeoutException;
        localExecutorService.shutdown();
        return false;
      }
      catch (Exception localException)
      {
        localException = localException;
        localExecutorService.shutdown();
        return false;
      }
      finally
      {
        localObject = finally;
        localExecutorService.shutdown();
        throw ((Throwable)localObject);
      }
    }
    return false;
  }
  
  @Nullable
  private ca f()
  {
    if (this.E.g != null) {}
    for (int i1 = 1; i1 == 0; i1 = 0) {
      return null;
    }
    return new ca(this.E);
  }
  
  @Nullable
  private ci g()
  {
    if (this.E.f != null) {}
    for (int i1 = 1; i1 == 0; i1 = 0) {
      return null;
    }
    return new ci(this.E);
  }
  
  private void h()
  {
    this.k = null;
    this.l = 404;
    this.C = null;
    this.B = null;
    this.D = null;
    cm.a = 0;
    this.E.a("cell").a();
  }
  
  private boolean i()
  {
    return this.l == 404;
  }
  
  private boolean j()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.r != null)
    {
      bool1 = bool2;
      if (this.r.b())
      {
        bool1 = bool2;
        if (this.r.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (this.y == 1)
    {
      b();
      this.x.quit();
      this.y = 0;
    }
    if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {}
    bm localbm;
    try
    {
      System.loadLibrary("tencentloc");
      localbm = this.E.b;
      ??? = b.a(localbm.g);
      this.K = a((String)???);
      if (TextUtils.isEmpty(this.K))
      {
        new StringBuilder("requestLocationUpdates: illegal key [").append((String)???).append("]");
        return 2;
      }
    }
    catch (Error paramTencentLocationRequest)
    {
      return 3;
    }
    h();
    for (;;)
    {
      synchronized (this.F)
      {
        this.b = paramTencentLocationListener;
        TencentLocationRequest.copy(this.G, paramTencentLocationRequest);
        localbm.f = paramTencentLocationRequest.getQQ();
        if (TextUtils.isEmpty(b.a(localbm.d))) {
          localbm.d = paramTencentLocationRequest.getPhoneNumber();
        }
        if (paramTencentLocationRequest.getInterval() == 0L)
        {
          l1 = 2L;
          localbm.l = Math.max(8000L, l1);
          if (Looper.myLooper() == null) {
            Looper.prepare();
          }
          if (this.n != null) {
            break label258;
          }
          i1 = 1;
          if (i1 == 0) {
            break label264;
          }
          this.n = new a(paramLooper);
          c();
          a();
          this.c = "start";
          return 0;
        }
      }
      long l1 = paramTencentLocationRequest.getInterval();
      continue;
      label258:
      int i1 = 0;
      continue;
      label264:
      this.n.removeCallbacksAndMessages(null);
      if (this.n.getLooper() != paramLooper) {
        this.n = new a(paramLooper);
      }
    }
  }
  
  public final void a()
  {
    boolean bool1 = false;
    this.E.a(this);
    boolean bool2 = this.G.getExtras().getBoolean("use_network", true);
    Object localObject1 = this.n;
    Object localObject2 = this.u;
    Object localObject3;
    if (!((cd)localObject2).b)
    {
      ((cd)localObject2).b = true;
      localObject3 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }
    try
    {
      ((cd)localObject2).a.a.registerReceiver((BroadcastReceiver)localObject2, (IntentFilter)localObject3);
      localObject2 = this.v;
      if (!((cg)localObject2).g)
      {
        ((cg)localObject2).g = true;
        ((cg)localObject2).b.c.execute(new cg.1((cg)localObject2, (Handler)localObject1));
        ((cg)localObject2).f = SystemClock.elapsedRealtime();
      }
      int i1;
      if (this.q) {
        if (bool2)
        {
          if (this.p == null) {
            break label663;
          }
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          localObject2 = this.p;
          if ((!((ce)localObject2).a) && (((ce)localObject2).b != null))
          {
            ((ce)localObject2).g = new HandlerThread("NewCellProvider");
            if (((ce)localObject2).g == null) {
              break label669;
            }
            ((ce)localObject2).g.start();
            ((ce)localObject2).h = new ce.a((ce)localObject2, ((ce)localObject2).g.getLooper(), (byte)0);
            ((ce)localObject2).h.sendEmptyMessageDelayed(0, 3000L);
            i1 = 1;
            label227:
            if (i1 == 0) {}
          }
        }
        try
        {
          localObject3 = cx.a(((ce)localObject2).b);
          if (((ce)localObject2).a((CellInfo)localObject3))
          {
            localck = ck.a(((ce)localObject2).b, (CellInfo)localObject3);
            if (localck != null)
            {
              ((ce)localObject2).c = ((CellInfo)localObject3);
              ((ce)localObject2).b.c(localck);
            }
          }
          ((ce)localObject2).a(1281);
          ((ce)localObject2).a = true;
        }
        catch (Exception localException3)
        {
          ck localck;
          label289:
          label304:
          label663:
          label669:
          label827:
          for (;;) {}
        }
        if (bool2)
        {
          if (this.s == null) {
            break label827;
          }
          i1 = 1;
          if (i1 != 0)
          {
            localObject2 = this.s;
            if (!((ci)localObject2).a)
            {
              ((ci)localObject2).a = true;
              ((ci)localObject2).f = false;
              ci.g = (Handler)localObject1;
              localObject3 = new IntentFilter();
              ((IntentFilter)localObject3).addAction("android.net.wifi.WIFI_STATE_CHANGED");
              ((IntentFilter)localObject3).addAction("android.net.wifi.SCAN_RESULTS");
            }
          }
        }
        try
        {
          ((ci)localObject2).b.a.registerReceiver((BroadcastReceiver)localObject2, (IntentFilter)localObject3);
          ((ci)localObject2).a(0L);
          if (this.G.getExtras().getBoolean("daemon"))
          {
            localObject2 = this.w;
            if (!((by)localObject2).b) {
              ((by)localObject2).b = true;
            }
          }
          try
          {
            ((by)localObject2).a.g.addGpsStatusListener((GpsStatus.Listener)localObject2);
            long l1;
            if (this.r != null)
            {
              i1 = 1;
              if ((i1 != 0) && (TencentExtraKeys.isAllowGps(this.G)) && (!this.G.getExtras().getBoolean("daemon", false)))
              {
                localObject2 = this.r;
                if (this.a == 1) {
                  bool1 = true;
                }
                ((ca)localObject2).g = bool1;
                localObject2 = this.r;
                l1 = this.G.getInterval();
                if (!((ca)localObject2).f)
                {
                  ((ca)localObject2).f = true;
                  ((ca)localObject2).b.a(localObject2);
                  l1 = Math.max(l1 - 2000L, 1000L);
                  localObject3 = ((ca)localObject2).b.g;
                }
              }
            }
            try
            {
              ((LocationManager)localObject3).addGpsStatusListener((GpsStatus.Listener)localObject2);
              ((LocationManager)localObject3).requestLocationUpdates("gps", l1, 0.0F, (LocationListener)localObject2, ((Handler)localObject1).getLooper());
              if (((ca)localObject2).b())
              {
                ((ca)localObject2).c = 4;
                ((ca)localObject2).c();
              }
              if (!this.G.getExtras().getBoolean("daemon")) {
                this.L = true;
              }
              if (this.G.isAllowDirection())
              {
                localObject2 = this.t;
                ((Handler)localObject1).getLooper();
                if ((!((bx)localObject2).b) || (((bx)localObject2).c)) {}
              }
              try
              {
                localObject1 = ((bx)localObject2).a.getDefaultSensor(11);
                if (localObject1 != null)
                {
                  ((bx)localObject2).a.registerListener((SensorEventListener)localObject2, (Sensor)localObject1, 3);
                  ((bx)localObject2).c = true;
                }
                return;
              }
              catch (Error localError1)
              {
                return;
              }
              catch (Exception localException1)
              {
                return;
              }
              i1 = 0;
              continue;
              i1 = 0;
              break label227;
              if (!bool2) {
                break label289;
              }
              if (this.o != null) {}
              for (i1 = 1; i1 != 0; i1 = 0)
              {
                localObject2 = this.o;
                if (((bv)localObject2).a) {
                  break;
                }
                ((bv)localObject2).a = true;
                ((bv)localObject2).g = new HandlerThread("CellProvider");
                ((bv)localObject2).g.start();
                ((bv)localObject2).h = new bv.a((bv)localObject2, ((bv)localObject2).g.getLooper(), (byte)0);
                ((bv)localObject2).h.sendEmptyMessageDelayed(0, 3000L);
                localObject3 = cx.b(((bv)localObject2).b);
                if (((bv)localObject2).a((CellLocation)localObject3))
                {
                  localck = ck.a(((bv)localObject2).b, (CellLocation)localObject3, null);
                  if (localck != null)
                  {
                    ((bv)localObject2).c = ((CellLocation)localObject3);
                    ((bv)localObject2).b.c(localck);
                  }
                }
                ((bv)localObject2).a(273);
                break;
              }
              i1 = 0;
              break label304;
              i1 = 0;
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                cx.a = true;
              }
            }
          }
          catch (Error localError2)
          {
            for (;;) {}
          }
          catch (Exception localException2)
          {
            for (;;) {}
          }
        }
        catch (Exception localException6)
        {
          for (;;) {}
        }
      }
    }
    catch (Exception localException4)
    {
      for (;;) {}
    }
  }
  
  public final void a(cw paramcw)
  {
    if (paramcw != null) {
      if (this.G.isAllowDirection()) {
        paramcw.getExtra().putDouble("direction", this.t.a());
      }
    }
    try
    {
      paramcw.getExtra().putAll(this.G.getExtras());
      return;
    }
    catch (Exception paramcw) {}
  }
  
  public final void b()
  {
    c();
    this.E.b(this);
    int i1;
    if (this.n != null)
    {
      i1 = 1;
      if (i1 != 0) {
        this.n.removeCallbacksAndMessages(null);
      }
    }
    for (;;)
    {
      synchronized (this.F)
      {
        this.b = null;
        this.A.a();
        h();
        this.c = "stop";
        if (this.y == 0) {}
        try
        {
          i1 = this.E.a.getSharedPreferences("LocationSDK", 0).getInt("control", 0);
          if (i1 == -1) {
            continue;
          }
          if (i1 > 120) {
            break label223;
          }
          this.N = 120000L;
        }
        catch (Exception localException)
        {
          TencentLocationListener local2;
          long l1;
          new StringBuilder("sp ex:").append(localException);
          continue;
        }
        this.x = new HandlerThread("daemonthread");
        this.x.start();
        ??? = TencentLocationRequest.create().setInterval(30000L).setRequestLevel(0);
        ((TencentLocationRequest)???).getExtras().putBoolean("daemon", true);
        local2 = new TencentLocationListener()
        {
          public final void onLocationChanged(TencentLocation paramAnonymousTencentLocation, int paramAnonymousInt, String paramAnonymousString) {}
          
          public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2) {}
        };
        if (dd.d(this.E).equalsIgnoreCase("{}"))
        {
          this.M = System.currentTimeMillis();
          a((TencentLocationRequest)???, local2, this.x.getLooper());
          this.y = 1;
        }
        return;
        i1 = 0;
      }
      label223:
      l1 = i1 * 1000;
      this.N = l1;
    }
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: putstatic 285	ct/cx:a	Z
    //   7: aload_0
    //   8: getfield 165	ct/cb:u	Lct/cd;
    //   11: astore_1
    //   12: aload_1
    //   13: getfield 690	ct/cd:b	Z
    //   16: ifeq +19 -> 35
    //   19: aload_1
    //   20: iconst_0
    //   21: putfield 690	ct/cd:b	Z
    //   24: aload_1
    //   25: getfield 697	ct/cd:a	Lct/bl;
    //   28: getfield 147	ct/bl:a	Landroid/content/Context;
    //   31: aload_1
    //   32: invokevirtual 905	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   35: aload_0
    //   36: getfield 170	ct/cb:v	Lct/cg;
    //   39: astore_1
    //   40: aload_1
    //   41: getfield 705	ct/cg:g	Z
    //   44: ifeq +125 -> 169
    //   47: aload_1
    //   48: iconst_0
    //   49: putfield 705	ct/cg:g	Z
    //   52: aload_1
    //   53: getfield 908	ct/cg:a	Ljava/util/concurrent/LinkedBlockingQueue;
    //   56: invokevirtual 913	java/util/concurrent/LinkedBlockingQueue:clear	()V
    //   59: aload_1
    //   60: getfield 908	ct/cg:a	Ljava/util/concurrent/LinkedBlockingQueue;
    //   63: getstatic 918	ct/cg$a:d	Lct/cg$a;
    //   66: invokevirtual 922	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: aload_1
    //   71: getfield 726	ct/cg:f	J
    //   74: lconst_0
    //   75: lcmp
    //   76: ifeq +73 -> 149
    //   79: invokestatic 724	android/os/SystemClock:elapsedRealtime	()J
    //   82: lstore 6
    //   84: aload_1
    //   85: getfield 726	ct/cg:f	J
    //   88: lstore 8
    //   90: getstatic 928	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   93: ldc_w 930
    //   96: iconst_4
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: lload 6
    //   104: lload 8
    //   106: lsub
    //   107: ldc2_w 793
    //   110: ldiv
    //   111: invokestatic 936	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_1
    //   118: getfield 938	ct/cg:d	J
    //   121: invokestatic 936	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: aload_1
    //   128: getfield 940	ct/cg:e	J
    //   131: invokestatic 936	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: aload_1
    //   138: getfield 942	ct/cg:c	J
    //   141: invokestatic 936	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: aastore
    //   145: invokestatic 946	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   148: pop
    //   149: aload_1
    //   150: lconst_0
    //   151: putfield 942	ct/cg:c	J
    //   154: aload_1
    //   155: lconst_0
    //   156: putfield 938	ct/cg:d	J
    //   159: aload_1
    //   160: lconst_0
    //   161: putfield 940	ct/cg:e	J
    //   164: aload_1
    //   165: lconst_0
    //   166: putfield 726	ct/cg:f	J
    //   169: aload_0
    //   170: getfield 180	ct/cb:z	Lct/ch;
    //   173: invokevirtual 947	ct/ch:a	()V
    //   176: aload_0
    //   177: getfield 199	ct/cb:s	Lct/ci;
    //   180: ifnull +354 -> 534
    //   183: iconst_1
    //   184: istore 4
    //   186: iload 4
    //   188: ifeq +73 -> 261
    //   191: aload_0
    //   192: getfield 199	ct/cb:s	Lct/ci;
    //   195: astore_1
    //   196: aload_1
    //   197: getfield 757	ct/ci:a	Z
    //   200: ifeq +61 -> 261
    //   203: aload_1
    //   204: iconst_0
    //   205: putfield 757	ct/ci:a	Z
    //   208: getstatic 761	ct/ci:g	Landroid/os/Handler;
    //   211: aconst_null
    //   212: invokevirtual 948	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   215: aload_1
    //   216: getfield 770	ct/ci:b	Lct/bl;
    //   219: getfield 147	ct/bl:a	Landroid/content/Context;
    //   222: aload_1
    //   223: invokevirtual 905	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   226: aload_1
    //   227: getfield 951	ct/ci:h	Lct/bt;
    //   230: getfield 956	ct/bt:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   233: invokevirtual 959	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   236: aload_1
    //   237: getfield 961	ct/ci:i	Lct/bt;
    //   240: getfield 956	ct/bt:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   243: invokevirtual 959	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   246: aload_1
    //   247: iconst_0
    //   248: putfield 962	ct/ci:e	I
    //   251: aload_1
    //   252: lconst_0
    //   253: putfield 963	ct/ci:d	J
    //   256: aload_1
    //   257: lconst_0
    //   258: putfield 964	ct/ci:c	J
    //   261: aload_0
    //   262: getfield 192	ct/cb:q	Z
    //   265: ifeq +286 -> 551
    //   268: aload_0
    //   269: getfield 203	ct/cb:p	Lct/ce;
    //   272: ifnull +268 -> 540
    //   275: iconst_1
    //   276: istore 4
    //   278: iload 4
    //   280: ifeq +82 -> 362
    //   283: aload_0
    //   284: getfield 203	ct/cb:p	Lct/ce;
    //   287: astore_1
    //   288: aload_1
    //   289: getfield 727	ct/ce:a	Z
    //   292: ifeq +70 -> 362
    //   295: aload_1
    //   296: iconst_0
    //   297: putfield 727	ct/ce:a	Z
    //   300: aload_1
    //   301: iconst_0
    //   302: invokevirtual 756	ct/ce:a	(I)V
    //   305: aload_1
    //   306: monitorenter
    //   307: aload_1
    //   308: getfield 744	ct/ce:h	Landroid/os/Handler;
    //   311: ifnull +16 -> 327
    //   314: aload_1
    //   315: getfield 744	ct/ce:h	Landroid/os/Handler;
    //   318: aconst_null
    //   319: invokevirtual 948	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   322: aload_1
    //   323: aconst_null
    //   324: putfield 744	ct/ce:h	Landroid/os/Handler;
    //   327: aload_1
    //   328: monitorexit
    //   329: aload_1
    //   330: getfield 733	ct/ce:g	Landroid/os/HandlerThread;
    //   333: invokevirtual 609	android/os/HandlerThread:quit	()Z
    //   336: pop
    //   337: aload_1
    //   338: aconst_null
    //   339: putfield 733	ct/ce:g	Landroid/os/HandlerThread;
    //   342: aload_1
    //   343: aconst_null
    //   344: putfield 753	ct/ce:c	Landroid/telephony/CellInfo;
    //   347: aload_1
    //   348: aconst_null
    //   349: putfield 967	ct/ce:d	Landroid/telephony/SignalStrength;
    //   352: aload_1
    //   353: aconst_null
    //   354: putfield 970	ct/ce:e	Landroid/telephony/ServiceState;
    //   357: aload_1
    //   358: lconst_0
    //   359: putfield 971	ct/ce:f	J
    //   362: aload_0
    //   363: getfield 208	ct/cb:r	Lct/ca;
    //   366: ifnull +293 -> 659
    //   369: iload 5
    //   371: istore 4
    //   373: iload 4
    //   375: ifeq +81 -> 456
    //   378: aload_0
    //   379: getfield 208	ct/cb:r	Lct/ca;
    //   382: astore_1
    //   383: aload_1
    //   384: getfield 789	ct/ca:f	Z
    //   387: ifeq +69 -> 456
    //   390: aload_1
    //   391: iconst_0
    //   392: putfield 789	ct/ca:f	Z
    //   395: aload_1
    //   396: lconst_0
    //   397: putfield 973	ct/ca:a	J
    //   400: aload_1
    //   401: sipush 1024
    //   404: putfield 801	ct/ca:c	I
    //   407: aload_1
    //   408: iconst_0
    //   409: putfield 974	ct/ca:d	I
    //   412: aload_1
    //   413: iconst_0
    //   414: putfield 975	ct/ca:e	I
    //   417: aload_1
    //   418: iconst_0
    //   419: putfield 788	ct/ca:g	Z
    //   422: aload_1
    //   423: getfield 978	ct/ca:h	[D
    //   426: dconst_0
    //   427: invokestatic 984	java/util/Arrays:fill	([DD)V
    //   430: aload_1
    //   431: getfield 790	ct/ca:b	Lct/bl;
    //   434: aload_1
    //   435: invokevirtual 856	ct/bl:b	(Ljava/lang/Object;)V
    //   438: aload_1
    //   439: getfield 790	ct/ca:b	Lct/bl;
    //   442: getfield 459	ct/bl:g	Landroid/location/LocationManager;
    //   445: astore_2
    //   446: aload_2
    //   447: aload_1
    //   448: invokevirtual 988	android/location/LocationManager:removeGpsStatusListener	(Landroid/location/GpsStatus$Listener;)V
    //   451: aload_2
    //   452: aload_1
    //   453: invokevirtual 992	android/location/LocationManager:removeUpdates	(Landroid/location/LocationListener;)V
    //   456: aload_0
    //   457: getfield 175	ct/cb:w	Lct/by;
    //   460: astore_1
    //   461: aload_1
    //   462: getfield 774	ct/by:b	Z
    //   465: ifeq +19 -> 484
    //   468: aload_1
    //   469: iconst_0
    //   470: putfield 774	ct/by:b	Z
    //   473: aload_1
    //   474: getfield 775	ct/by:a	Lct/bl;
    //   477: getfield 459	ct/bl:g	Landroid/location/LocationManager;
    //   480: aload_1
    //   481: invokevirtual 988	android/location/LocationManager:removeGpsStatusListener	(Landroid/location/GpsStatus$Listener;)V
    //   484: aload_0
    //   485: getfield 129	ct/cb:G	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   488: invokevirtual 805	com/tencent/map/geolocation/TencentLocationRequest:isAllowDirection	()Z
    //   491: ifeq +42 -> 533
    //   494: aload_0
    //   495: getfield 187	ct/cb:t	Lct/bx;
    //   498: astore_1
    //   499: aload_1
    //   500: getfield 806	ct/bx:b	Z
    //   503: ifeq +30 -> 533
    //   506: aload_1
    //   507: getfield 808	ct/bx:c	Z
    //   510: ifeq +23 -> 533
    //   513: aload_1
    //   514: iconst_0
    //   515: putfield 808	ct/bx:c	Z
    //   518: aload_1
    //   519: ldc2_w 993
    //   522: putfield 996	ct/bx:d	D
    //   525: aload_1
    //   526: getfield 811	ct/bx:a	Landroid/hardware/SensorManager;
    //   529: aload_1
    //   530: invokevirtual 1000	android/hardware/SensorManager:unregisterListener	(Landroid/hardware/SensorEventListener;)V
    //   533: return
    //   534: iconst_0
    //   535: istore 4
    //   537: goto -351 -> 186
    //   540: iconst_0
    //   541: istore 4
    //   543: goto -265 -> 278
    //   546: astore_2
    //   547: aload_1
    //   548: monitorexit
    //   549: aload_2
    //   550: athrow
    //   551: aload_0
    //   552: getfield 194	ct/cb:o	Lct/bv;
    //   555: ifnull +93 -> 648
    //   558: iconst_1
    //   559: istore 4
    //   561: iload 4
    //   563: ifeq -201 -> 362
    //   566: aload_0
    //   567: getfield 194	ct/cb:o	Lct/bv;
    //   570: astore_1
    //   571: aload_1
    //   572: getfield 822	ct/bv:a	Z
    //   575: ifeq -213 -> 362
    //   578: aload_1
    //   579: iconst_0
    //   580: putfield 822	ct/bv:a	Z
    //   583: aload_1
    //   584: iconst_0
    //   585: invokevirtual 839	ct/bv:a	(I)V
    //   588: aload_1
    //   589: monitorenter
    //   590: aload_1
    //   591: getfield 831	ct/bv:h	Landroid/os/Handler;
    //   594: ifnull +16 -> 610
    //   597: aload_1
    //   598: getfield 831	ct/bv:h	Landroid/os/Handler;
    //   601: aconst_null
    //   602: invokevirtual 948	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   605: aload_1
    //   606: aconst_null
    //   607: putfield 831	ct/bv:h	Landroid/os/Handler;
    //   610: aload_1
    //   611: monitorexit
    //   612: aload_1
    //   613: getfield 825	ct/bv:g	Landroid/os/HandlerThread;
    //   616: invokevirtual 609	android/os/HandlerThread:quit	()Z
    //   619: pop
    //   620: aload_1
    //   621: aconst_null
    //   622: putfield 825	ct/bv:g	Landroid/os/HandlerThread;
    //   625: aload_1
    //   626: aconst_null
    //   627: putfield 838	ct/bv:c	Landroid/telephony/CellLocation;
    //   630: aload_1
    //   631: aconst_null
    //   632: putfield 1001	ct/bv:d	Landroid/telephony/SignalStrength;
    //   635: aload_1
    //   636: aconst_null
    //   637: putfield 1002	ct/bv:e	Landroid/telephony/ServiceState;
    //   640: aload_1
    //   641: lconst_0
    //   642: putfield 1003	ct/bv:f	J
    //   645: goto -283 -> 362
    //   648: iconst_0
    //   649: istore 4
    //   651: goto -90 -> 561
    //   654: astore_2
    //   655: aload_1
    //   656: monitorexit
    //   657: aload_2
    //   658: athrow
    //   659: iconst_0
    //   660: istore 4
    //   662: goto -289 -> 373
    //   665: astore_3
    //   666: goto -215 -> 451
    //   669: astore_1
    //   670: goto -214 -> 456
    //   673: astore_1
    //   674: goto -190 -> 484
    //   677: astore_2
    //   678: goto -452 -> 226
    //   681: astore_1
    //   682: goto -647 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	cb
    //   11	645	1	localObject1	Object
    //   669	1	1	localException1	Exception
    //   673	1	1	localException2	Exception
    //   681	1	1	localException3	Exception
    //   445	7	2	localLocationManager	LocationManager
    //   546	4	2	localObject2	Object
    //   654	4	2	localObject3	Object
    //   677	1	2	localException4	Exception
    //   665	1	3	localException5	Exception
    //   184	477	4	i1	int
    //   1	369	5	i2	int
    //   82	21	6	l1	long
    //   88	17	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   307	327	546	finally
    //   327	329	546	finally
    //   547	549	546	finally
    //   590	610	654	finally
    //   610	612	654	finally
    //   655	657	654	finally
    //   446	451	665	java/lang/Exception
    //   451	456	669	java/lang/Exception
    //   473	484	673	java/lang/Exception
    //   215	226	677	java/lang/Exception
    //   24	35	681	java/lang/Exception
  }
  
  public final void onCellInfoEvent(ck paramck)
  {
    int i3 = paramck.e;
    int i4 = paramck.f;
    ck localck = this.B;
    if (localck != null) {}
    for (int i2 = localck.f;; i2 = 0)
    {
      this.B = paramck;
      int i1;
      if (this.s != null) {
        if (this.s.a()) {
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i1 != 0) {
          this.C = null;
        }
        boolean bool;
        if (i1 == 0) {
          if (i3 != 0)
          {
            bool = true;
            label72:
            this.O = bool;
            if (this.n != null)
            {
              paramck = this.n.obtainMessage(3999, "wifi_not_received");
              if (!this.G.getExtras().getBoolean("daemon")) {
                this.n.sendMessageDelayed(paramck, 5000L);
              }
            }
            label127:
            if (i1 != 0) {
              break label227;
            }
          }
        }
        label227:
        for (paramck = "scan wifi";; paramck = "prepare json. wifi is not scannable?")
        {
          String.format("onCellChanged: %d(%d)-->%d(%d) (%d)%s", new Object[] { Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i1), paramck });
          return;
          i1 = 1;
          break;
          bool = false;
          break label72;
          if (this.G.getExtras().getBoolean("daemon")) {
            break label127;
          }
          a(3999);
          break label127;
        }
        i1 = 1;
      }
    }
  }
  
  public final void onGpsInfoEvent(cl paramcl)
  {
    double d1 = 0.0D;
    int i1;
    int i2;
    cw localcw;
    Location localLocation;
    Object localObject;
    double d2;
    if (paramcl.a != bw.b)
    {
      this.D = paramcl;
      bz.a().a(paramcl);
      i1 = this.a;
      i2 = this.G.getRequestLevel();
      localcw = this.J;
      localLocation = new Location(paramcl.a);
      localObject = localLocation.getExtras();
      if (localObject == null) {
        break label294;
      }
      d2 = ((Bundle)localObject).getDouble("lat");
      d1 = ((Bundle)localObject).getDouble("lng");
    }
    for (;;)
    {
      if (i1 == 0)
      {
        i1 = 1;
        if (i1 == 0) {
          break label201;
        }
        localObject = new cw.a();
        ((cw.a)localObject).b = localcw;
        ((cw.a)localObject).d = "gps";
        ((cw.a)localObject).c = i2;
        paramcl = ((cw.a)localObject).a(new Location(paramcl.a)).a();
        localLocation.setLatitude(d2);
        localLocation.setLongitude(d1);
        paramcl.a(localLocation);
        a(0, paramcl);
      }
      for (;;)
      {
        if (this.r != null) {
          this.r.a();
        }
        return;
        i1 = 0;
        break;
        label201:
        if (i()) {
          a(3999);
        }
        localObject = new cw.a();
        ((cw.a)localObject).b = localcw;
        ((cw.a)localObject).d = "gps";
        ((cw.a)localObject).c = i2;
        paramcl = ((cw.a)localObject).a(new Location(paramcl.a)).a();
        localLocation.setLatitude(d2);
        localLocation.setLongitude(d1);
        paramcl.a(localLocation);
        a(0, paramcl);
      }
      label294:
      d2 = 0.0D;
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    int i1 = b.a(this.E.a);
    String str;
    if (i1 != -1) {
      if (i1 == 0) {
        str = "mobile";
      }
    }
    for (;;)
    {
      switch (paramInteger.intValue())
      {
      case -1: 
      default: 
        return;
        if (i1 == 1) {
          str = "wifi";
        } else {
          str = "none";
        }
        break;
      }
    }
    new StringBuilder("onNetworkEvent: ").append(str).append(" disconnected");
    return;
    new StringBuilder("onNetworkEvent: ").append(str).append(" connected");
    a(7999, 1000L);
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    a(paramMessage.arg1, paramMessage.arg2);
  }
  
  public final void onWifiInfoEvent(co paramco)
  {
    if (this.n != null) {
      this.n.removeMessages(3999, "wifi_not_received");
    }
    if (paramco == co.a)
    {
      a(555, 1500L);
      return;
    }
    Object localObject2;
    Object localObject1;
    int i1;
    if ((this.C != null) && (this.C.a(System.currentTimeMillis(), 45000L)) && (Collections.unmodifiableList(paramco.b).size() >= 3) && (!this.O))
    {
      localObject2 = this.C;
      localObject1 = paramco.b;
      localObject2 = ((co)localObject2).b;
      if ((((List)localObject1).size() != 0) && (((List)localObject2).size() != 0)) {
        break label143;
      }
      i1 = 0;
      if (i1 != 0) {}
    }
    else
    {
      this.C = paramco;
      a(3999);
    }
    this.O = false;
    return;
    label143:
    int i5 = ((List)localObject1).size();
    int i6 = ((List)localObject2).size();
    if ((i5 == 0) && (i6 == 0)) {
      i1 = 1;
    }
    label172:
    Object localObject3;
    label217:
    int i2;
    int i4;
    label234:
    label318:
    int i3;
    for (;;)
    {
      if (i1 == 0)
      {
        i1 = 1;
        break;
        if ((i5 == 0) || (i6 == 0))
        {
          i1 = 0;
        }
        else if (((List)localObject1).size() > ((List)localObject2).size())
        {
          localObject3 = localObject2;
          localObject2 = ((List)localObject3).iterator();
          i2 = 0;
          i4 = 1;
          i1 = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label393;
          }
          localObject3 = (ScanResult)((Iterator)localObject2).next();
          Iterator localIterator = ((List)localObject1).iterator();
          for (;;)
          {
            if (localIterator.hasNext()) {
              if (((ScanResult)localIterator.next()).BSSID.equals(((ScanResult)localObject3).BSSID)) {
                if ((i4 == 1) && (((ScanResult)localObject3).level > -50))
                {
                  i1 += 1;
                  i3 = i1;
                  if (i4 == 2)
                  {
                    i3 = i1;
                    if (((ScanResult)localObject3).level > -60) {
                      i3 = i1 + 1;
                    }
                  }
                  if ((i4 == 3) && (((ScanResult)localObject3).level > -60))
                  {
                    i1 = i3 + 1;
                    label370:
                    i2 += 1;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i4 += 1;
      break label234;
      localObject3 = localObject1;
      localObject1 = localObject2;
      break label217;
      label393:
      if ((i1 != 3) && ((i2 << 1 < (i5 + i6) * 0.6D) || (i2 < 13)))
      {
        i1 = 1;
        break label172;
      }
      i1 = 0;
      break label172;
      i1 = 0;
      break;
      i1 = i3;
      break label370;
      break label318;
    }
  }
  
  final class a
    extends Handler
  {
    private final cc a;
    private int b;
    
    a(Looper paramLooper)
    {
      super();
      cb.a(cb.this);
      this.a = bo.c();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int j = 1;
      int i = 1;
      Object localObject1;
      int k;
      long l;
      synchronized (cb.b(cb.this))
      {
        if (cb.c(cb.this) == null) {
          return;
        }
        localObject1 = cb.c(cb.this);
        ??? = cb.d(cb.this);
        k = ((TencentLocationRequest)???).getRequestLevel();
        l = ((TencentLocationRequest)???).getInterval();
        switch (paramMessage.what)
        {
        default: 
          return;
        case 555: 
          cb.z(cb.this);
          sendEmptyMessage(3999);
          return;
        }
      }
      if ((cb.e(cb.this) != null) && (((TencentLocationRequest)???).getInterval() > 0L) && (cb.f(cb.this) != null) && (cb.f(cb.this).equalsIgnoreCase("start")))
      {
        cb.a(cb.this, cb.e(cb.this));
        ((TencentLocationListener)localObject1).onLocationChanged(cb.e(cb.this), cb.g(cb.this), (String)cb.d().get(cb.g(cb.this)));
        if ((cb.h(cb.this)) && (cb.i(cb.this) != null)) {
          cb.i(cb.this).onDistanceChanged(cb.e(cb.this), b.a(cb.j(cb.this) / 1000.0D, 2), cb.g(cb.this), (String)cb.d().get(cb.g(cb.this)));
        }
      }
      if (l > 0L)
      {
        sendEmptyMessageDelayed(11999, l);
        return;
        if (cb.e(cb.this) != null)
        {
          cb.a(cb.this, cb.e(cb.this));
          ((TencentLocationListener)localObject1).onLocationChanged(cb.e(cb.this), cb.g(cb.this), (String)cb.d().get(cb.g(cb.this)));
          return;
          if (cb.k(cb.this)) {}
        }
      }
      for (;;)
      {
        try
        {
          if (cb.d(cb.this).getExtras().getBoolean("daemon"))
          {
            if (cb.l(cb.this) < 120000L) {
              cb.m(cb.this);
            }
            if (System.currentTimeMillis() - cb.n(cb.this) >= cb.l(cb.this)) {
              cb.a(cb.this, System.currentTimeMillis());
            }
          }
          else
          {
            if (paramMessage.obj != null) {
              new StringBuilder("wifi error.").append(paramMessage.obj.toString());
            }
            j = cb.o(cb.this);
            Object localObject3 = cb.p(cb.this);
            paramMessage = ((cm)localObject3).a(k, cb.q(cb.this), cb.a(cb.this), cb.r(cb.this));
            if (b.b(paramMessage)) {
              break label1354;
            }
            if (i != 0)
            {
              this.b += 1;
              if (this.b >= 2)
              {
                cb.a(cb.this, 2, cw.a);
                this.b = 0;
              }
            }
            else
            {
              this.b = 0;
              if (cb.s(cb.this) != null) {
                cb.s(cb.this).a();
              }
              paramMessage = cb.t(cb.this).a(paramMessage);
              if (paramMessage != "[]")
              {
                if ((!cb.d(cb.this).getExtras().getBoolean("daemon")) && (TencentExtraKeys.isRequestRawData((TencentLocationRequest)???)))
                {
                  ??? = new cw.a();
                  ((cw.a)???).b = null;
                  ((cw.a)???).c = k;
                  ??? = ((cw.a)???).a();
                  TencentExtraKeys.setRawData((TencentLocation)???, paramMessage.getBytes());
                  cb.a(cb.this, (cw)???);
                  ((TencentLocationListener)localObject1).onLocationChanged((TencentLocation)???, 0, (String)cb.d().get(0));
                  return;
                }
                if (TencentExtraKeys.MOCK_LOCATION_FILTER)
                {
                  if (!b.b(cb.a(cb.this).a))
                  {
                    cb.a(cb.this, 1, cw.a);
                    return;
                  }
                  cb.u(cb.this).a(paramMessage, (cm)localObject3, j);
                  cb.t(cb.this);
                  System.currentTimeMillis();
                  return;
                  paramMessage = new cm(null, null, new cl((Location)paramMessage.obj, System.currentTimeMillis(), 3, 3, 0));
                  localObject1 = paramMessage.a(k, cb.q(cb.this), cb.a(cb.this), cb.r(cb.this));
                  cb.u(cb.this).a((String)localObject1, paramMessage, cb.o(cb.this));
                  return;
                  removeMessages(4998);
                  if (!cb.d(cb.this).getExtras().getBoolean("daemon"))
                  {
                    localObject1 = (Pair)paramMessage.obj;
                    ??? = ((Pair)localObject1).first.toString();
                    localObject3 = (cg.a)((Pair)localObject1).second;
                    cm localcm = (cm)((cg.a)localObject3).a;
                    String str = ((cg.a)localObject3).b;
                    if (localcm.b != null)
                    {
                      i = j;
                      if (i == 0) {
                        continue;
                      }
                      localObject1 = "gps";
                    }
                    try
                    {
                      cw.a locala = new cw.a();
                      locala.a = ((String)???);
                      locala.c = k;
                      locala.d = ((String)localObject1);
                      localObject1 = locala.a();
                      ((cw)localObject1).getExtra().putString("resp_json", (String)???);
                      cw.a((cw)localObject1);
                      cw.a((cw)localObject1, cb.v(cb.this));
                      TencentExtraKeys.setRawQuery((TencentLocation)localObject1, str);
                      if (localcm.b == null) {
                        continue;
                      }
                      i = localcm.b.c;
                      ((cw)localObject1).getExtra().putInt("sat_num", i);
                      ((cw)localObject1).getExtra().putLong("req_cost", paramMessage.arg1);
                      ((cw)localObject1).getExtra().putLong("req_start", ((cg.a)localObject3).c);
                      cb.a(cb.this).a("map").b(((cw)localObject1).getExtra());
                      if (!cb.w(cb.this))
                      {
                        cb.a(cb.this, 0, (cw)localObject1);
                        if ((cb.s(cb.this) != null) && (cb.s(cb.this).b())) {
                          cb.x(cb.this);
                        }
                      }
                      if (!cb.r(cb.this)) {}
                    }
                    catch (JSONException paramMessage)
                    {
                      paramMessage = this.a.d();
                      if (paramMessage != bw.b)
                      {
                        obtainMessage(3998, paramMessage).sendToTarget();
                        return;
                      }
                      cb.a(cb.this, 404, cw.a);
                      return;
                    }
                    try
                    {
                      paramMessage = ((cw)localObject1).getExtra();
                      if (paramMessage != null)
                      {
                        i = paramMessage.getInt("icontrol", -1);
                        cb.a(cb.this).a.getSharedPreferences("LocationSDK", 0).edit().putInt("control", i).apply();
                      }
                    }
                    catch (Exception paramMessage)
                    {
                      new StringBuilder("sp:").append(paramMessage);
                      continue;
                      cb.a(cb.this, 1, cw.a);
                      return;
                    }
                    catch (Error paramMessage)
                    {
                      continue;
                    }
                    cb.y(cb.this);
                    cb.b(cb.this, (cw)localObject1);
                    return;
                    i = 0;
                    continue;
                    localObject1 = "network";
                    continue;
                    i = 0;
                    continue;
                  }
                }
              }
            }
          }
          return;
        }
        catch (Exception paramMessage)
        {
          return;
        }
        label1354:
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */