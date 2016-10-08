package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import ct.b;
import ct.bl;
import ct.bm;
import ct.cb;
import ct.cr;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final bl b;
  private final cb c;
  
  private TencentLocationManager(Context paramContext)
  {
    this.b = bl.a(paramContext);
    this.c = new cb(this.b);
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
    throws NullPointerException, IllegalArgumentException
  {
    try
    {
      if (d != null) {
        break label60;
      }
      if (paramContext == null) {
        throw new NullPointerException("context is null");
      }
    }
    finally {}
    if (paramContext.getApplicationContext() == null) {
      throw new NullPointerException("application context is null");
    }
    d = new TencentLocationManager(paramContext.getApplicationContext());
    label60:
    paramContext = d;
    return paramContext;
  }
  
  public static boolean isAllowGps(TencentLocationRequest paramTencentLocationRequest)
  {
    if (paramTencentLocationRequest == null) {
      return true;
    }
    return paramTencentLocationRequest.getExtras().getBoolean("allow_gps", true);
  }
  
  public static TencentLocationRequest setAllowGps(TencentLocationRequest paramTencentLocationRequest, boolean paramBoolean)
  {
    if (paramTencentLocationRequest != null) {
      paramTencentLocationRequest.getExtras().putBoolean("allow_gps", paramBoolean);
    }
    return paramTencentLocationRequest;
  }
  
  public final String getBuild()
  {
    bm localbm = this.b.a(-1L);
    if (localbm != null) {
      return localbm.e();
    }
    return "None";
  }
  
  public final int getCoordinateType()
  {
    return this.c.a;
  }
  
  public final String getKey()
  {
    return b.a(this.b.b.g);
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    cb localcb = this.c;
    if (localcb.l == 0)
    {
      localcb.a(localcb.k);
      return localcb.k;
    }
    return null;
  }
  
  public final String getVersion()
  {
    bm localbm = this.b.a(-1L);
    if (localbm != null) {
      return localbm.d();
    }
    return "None";
  }
  
  public final String pauseLocationUpdates()
  {
    cb localcb = this.c;
    if (localcb.c.equalsIgnoreCase("start"))
    {
      localcb.c();
      localcb.c = "pause";
      return "success";
    }
    return "warning!!!pause failed.only when the machine has started, can pause!";
  }
  
  public final void removeUpdates(TencentLocationListener arg1)
  {
    synchronized (this.a)
    {
      this.c.b();
      return;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    return requestLocationUpdates(paramTencentLocationRequest, paramTencentLocationListener, Looper.myLooper());
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (paramTencentLocationRequest == null) {
      throw new NullPointerException("request is null");
    }
    if (paramTencentLocationListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentLocationRequest, paramTencentLocationListener, paramLooper);
      return i;
    }
  }
  
  public final String resumeLocationUpdates()
  {
    cb localcb = this.c;
    if (localcb.c.equalsIgnoreCase("pause"))
    {
      localcb.a();
      localcb.c = "start";
      return "success";
    }
    return "warning!!!resume failed.only when the machine has paused, can resume!";
  }
  
  public final void setCoordinateType(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      synchronized (this.a)
      {
        cb localcb = this.c;
        if (localcb.a != paramInt) {
          localcb.a = paramInt;
        }
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: " + paramInt);
  }
  
  public final void setKey(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      throw new IllegalArgumentException("bad key: " + paramString);
    }
    this.b.b.g = paramString;
  }
  
  public final int startDistanceCalculate(TencentDistanceListener paramTencentDistanceListener)
  {
    int i = 1;
    if (paramTencentDistanceListener == null) {
      throw new NullPointerException("listener is null");
    }
    synchronized (this.a)
    {
      cb localcb = this.c;
      if (localcb.b == null) {}
      for (;;)
      {
        return i;
        if (!localcb.d) {
          break;
        }
        i = 2;
      }
      localcb.d = true;
      localcb.j = paramTencentDistanceListener;
      i = 0;
    }
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      cb localcb = this.c;
      localcb.j = null;
      localcb.e = 0.0D;
      localcb.d = false;
      localcb.i = null;
      cr localcr = new cr();
      localcr.a = (b.a((localcb.f + 1) / (localcb.h + 1), 4) * 100.0D);
      localcr.b = localcb.f;
      localcr.c = localcb.g;
      localcb.f = 0;
      localcb.g = 0;
      localcb.h = 0;
      return localcr;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\map\geolocation\TencentLocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */