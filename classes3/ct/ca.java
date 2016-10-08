package ct;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

final class ca
  implements GpsStatus.Listener, LocationListener
{
  long a = 0L;
  final bl b;
  int c = 1024;
  int d = 0;
  int e = 0;
  volatile boolean f;
  boolean g;
  final double[] h = new double[2];
  private bs i;
  private GpsStatus j;
  
  public ca(bl parambl)
  {
    this.b = parambl;
    this.i = bs.a();
  }
  
  private static void a(Location paramLocation, double paramDouble1, double paramDouble2, int paramInt)
  {
    Bundle localBundle2 = paramLocation.getExtras();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putDouble("lat", paramDouble1);
    localBundle1.putDouble("lng", paramDouble2);
    localBundle1.putInt("rssi", paramInt);
    paramLocation.setExtras(localBundle1);
  }
  
  private static boolean a(double paramDouble)
  {
    return Math.abs(Double.valueOf(paramDouble).longValue() - paramDouble) < Double.MIN_VALUE;
  }
  
  @SuppressLint({"NewApi"})
  private boolean a(Location paramLocation)
  {
    if (!TencentExtraKeys.MOCK_LOCATION_FILTER) {}
    for (;;)
    {
      return false;
      try
      {
        if (!this.b.g.isProviderEnabled("gps")) {
          return true;
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          boolean bool = paramLocation.isFromMockProvider();
          if (bool) {
            return true;
          }
        }
      }
      catch (NoSuchMethodError paramLocation)
      {
        return false;
      }
      catch (Exception paramLocation) {}
    }
    return false;
  }
  
  private void d()
  {
    this.e = 0;
    this.d = 0;
    Object localObject = this.b.g.getGpsStatus(null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      int k = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
      if (localObject != null) {
        while ((((Iterator)localObject).hasNext()) && (this.d <= k))
        {
          this.d += 1;
          if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
            this.e += 1;
          }
        }
      }
    }
  }
  
  private int e()
  {
    int m = -1;
    Object localObject = this.b.g.getGpsStatus(null);
    if (localObject == null) {}
    int n;
    do
    {
      return m;
      n = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
    } while (localObject == null);
    int k = 0;
    for (;;)
    {
      m = k;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      m = k;
      if (k > n) {
        break;
      }
      ((Iterator)localObject).next();
      k += 1;
    }
  }
  
  private int f()
  {
    int m = -1;
    Object localObject = this.b.g.getGpsStatus(null);
    if (localObject == null) {}
    int n;
    do
    {
      return m;
      n = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
    } while (localObject == null);
    int k = 0;
    for (;;)
    {
      m = k;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      m = k;
      if (k > n) {
        break;
      }
      if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
        k += 1;
      }
    }
  }
  
  public final boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.c & 0x2) == 2)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - this.a < bz.a().b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean b()
  {
    LocationManager localLocationManager = this.b.g;
    try
    {
      boolean bool = localLocationManager.isProviderEnabled("gps");
      return bool;
    }
    catch (Error localError)
    {
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  final void c()
  {
    int k;
    if (this.c == 4) {
      k = 1;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12002;
      localMessage.arg2 = k;
      this.b.c(localMessage);
      return;
      if (this.c == 0) {
        k = 0;
      } else {
        k = -1;
      }
    }
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        d();
        e();
        f();
        return;
        this.c |= 0x1;
        continue;
        this.c = 0;
        continue;
        this.c |= 0x2;
      }
    }
    Object localObject1 = this.b.g;
    if (this.j == null) {
      this.j = ((LocationManager)localObject1).getGpsStatus(null);
    }
    Object localObject2;
    float f1;
    for (;;)
    {
      if (this.j != null)
      {
        localObject1 = this.i;
        localObject2 = this.j;
        int k = ((GpsStatus)localObject2).getMaxSatellites();
        Object localObject3 = ((GpsStatus)localObject2).getSatellites().iterator();
        ((bs)localObject1).a.clear();
        localObject2 = new StringBuilder();
        paramInt = 0;
        Object localObject4;
        for (;;)
        {
          if ((((Iterator)localObject3).hasNext()) && (paramInt <= k))
          {
            localObject4 = (GpsSatellite)((Iterator)localObject3).next();
            paramInt += 1;
            ((bs)localObject1).a.add(Float.valueOf(((GpsSatellite)localObject4).getSnr()));
            continue;
            ((LocationManager)localObject1).getGpsStatus(this.j);
            break;
          }
        }
        ((StringBuilder)localObject2).append(paramInt + "颗卫星,");
        if (((bs)localObject1).a.size() >= 5)
        {
          localObject3 = new float[((bs)localObject1).a.size()];
          paramInt = 0;
          while (paramInt < localObject3.length)
          {
            localObject3[paramInt] = ((Float)((bs)localObject1).a.get(paramInt)).floatValue();
            paramInt += 1;
          }
          Arrays.sort((float[])localObject3);
          localObject4 = new float[5];
          f1 = 0.0F;
          paramInt = 0;
          while (paramInt < 5)
          {
            localObject4[paramInt] = localObject3[(localObject3.length - 1 - paramInt)];
            f1 += localObject4[paramInt];
            paramInt += 1;
          }
          f1 /= 5.0F;
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append("绝对判断：");
          if (localObject4[0] <= 35.0F) {
            break label781;
          }
          ((bs)localObject1).e = true;
          ((StringBuilder)localObject2).append("室外|");
          label400:
          if (f1 < 22.0F)
          {
            ((StringBuilder)localObject2).append("室内|");
            ((bs)localObject1).e = false;
          }
          ((StringBuilder)localObject2).append("avg" + f1);
          ((StringBuilder)localObject2).append("avg'" + (f1 - ((bs)localObject1).b));
          ((StringBuilder)localObject2).append("avgMax" + ((bs)localObject1).c);
          ((StringBuilder)localObject2).append("avgMin" + ((bs)localObject1).d);
          ((StringBuilder)localObject2).append(((bs)localObject1).e);
          ((StringBuilder)localObject2).append("\n");
          if (((bs)localObject1).c < f1) {
            ((bs)localObject1).c = f1;
          }
          if (((bs)localObject1).d > f1) {
            ((bs)localObject1).d = f1;
          }
          ((bs)localObject1).b = f1;
          ((StringBuilder)localObject2).append("相对判断：");
          if (f1 - ((bs)localObject1).b > 3.0F) {
            ((StringBuilder)localObject2).append("信号增强");
          }
          if (((bs)localObject1).b - f1 > 2.0F)
          {
            ((StringBuilder)localObject2).append("信号衰弱");
            ((bs)localObject1).f = false;
          }
          if (f1 <= (((bs)localObject1).c + ((bs)localObject1).d) / 2.0F) {
            break label806;
          }
          ((bs)localObject1).f = true;
          label654:
          if (((bs)localObject1).e != ((bs)localObject1).f) {
            ((StringBuilder)localObject2).append("\n冲突" + ((bs)localObject1).e + "|" + ((bs)localObject1).f);
          }
          ((StringBuilder)localObject2).append("\n最终结果" + ((bs)localObject1).f);
        }
      }
    }
    for (boolean bool = ((bs)localObject1).f;; bool = true)
    {
      if (bool) {}
      for (paramInt = 3;; paramInt = 4)
      {
        localObject1 = new Message();
        ((Message)localObject1).what = 12999;
        ((Message)localObject1).arg1 = 12004;
        ((Message)localObject1).arg2 = paramInt;
        this.b.c(localObject1);
        break;
        label781:
        if (f1 <= 30.0F) {
          break label400;
        }
        ((bs)localObject1).e = true;
        ((StringBuilder)localObject2).append("室外|");
        break label400;
        label806:
        if (f1 >= 22.0F) {
          break label654;
        }
        ((bs)localObject1).f = false;
        break label654;
      }
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    int m = 1;
    if (paramLocation != null) {}
    for (;;)
    {
      double d1;
      double d2;
      int k;
      try
      {
        if (!"gps".equals(paramLocation.getProvider())) {
          return;
        }
        d1 = paramLocation.getLatitude();
        d2 = paramLocation.getLongitude();
        if (paramLocation.getAccuracy() <= 1000.0F) {
          continue;
        }
        k = 0;
        if (k == 0) {
          continue;
        }
        d();
        this.c |= 0x2;
        if (a(paramLocation)) {
          continue;
        }
        this.a = System.currentTimeMillis();
        if (this.e != 3) {
          continue;
        }
        k = m;
      }
      catch (Error paramLocation)
      {
        return;
        k = 0;
        continue;
        return;
      }
      catch (Exception paramLocation)
      {
        return;
      }
      if (this.g)
      {
        b.a(paramLocation, this.h);
        a(paramLocation, this.h[0], this.h[1], k);
        paramLocation = new cl(paramLocation, this.a, this.d, this.e, this.c);
        this.b.c(paramLocation);
        return;
        if ((!a(d1)) || (!a(d2))) {
          break label299;
        }
        k = 0;
        continue;
        if ((Math.abs(d1) < 1.0E-8D) || (Math.abs(d2) < 1.0E-8D)) {
          break label368;
        }
        if (Math.abs(d1 - 1.0D) < 1.0E-8D) {
          break label322;
        }
        if (Math.abs(d2 - 1.0D) >= 1.0E-8D) {
          break label328;
        }
        break label322;
        if ((this.e >= 4) && (this.e <= 6))
        {
          k = 2;
          continue;
        }
        if (this.e >= 7)
        {
          k = 3;
          continue;
        }
      }
      else
      {
        a(paramLocation, paramLocation.getLatitude(), paramLocation.getLongitude(), k);
        continue;
      }
      label299:
      if ((d1 == 29.999998211860657D) || (d2 == 103.99999916553497D))
      {
        k = 0;
        continue;
        label322:
        k = 0;
        continue;
        label328:
        if ((d1 < -90.0D) || (d1 > 90.0D) || (d2 < -180.0D) || (d2 > 180.0D)) {
          k = 0;
        } else {
          label368:
          k = 1;
        }
      }
    }
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      this.e = 0;
      this.d = 0;
      this.c = 0;
      this.a = 0L;
      c();
    }
  }
  
  public final void onProviderEnabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      this.c = 4;
      c();
    }
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */