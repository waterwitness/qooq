package com.tencent.mapsdk.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.mapsdk.a.c.b;
import com.tencent.mapsdk.a.c.e;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Stack;

public class d
{
  private static d c;
  private String a = "firllq.dat";
  private int b = 3164;
  private int d = 0;
  private int e = 20;
  
  public static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    double d4 = paramLatLng1.getLongitude();
    double d3 = paramLatLng1.getLatitude();
    double d2 = paramLatLng2.getLongitude();
    double d1 = paramLatLng2.getLatitude();
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramLatLng1 = new double[3];
    paramLatLng2 = new double[3];
    paramLatLng1[0] = (d5 * d6);
    paramLatLng1[1] = (d6 * d1);
    paramLatLng1[2] = d2;
    paramLatLng2[0] = (d4 * d3);
    paramLatLng2[1] = (d4 * d7);
    paramLatLng2[2] = d8;
    return Math.asin(Math.sqrt((paramLatLng1[0] - paramLatLng2[0]) * (paramLatLng1[0] - paramLatLng2[0]) + (paramLatLng1[1] - paramLatLng2[1]) * (paramLatLng1[1] - paramLatLng2[1]) + (paramLatLng1[2] - paramLatLng2[2]) * (paramLatLng1[2] - paramLatLng2[2])) / 2.0D) * 1.27420015798544E7D;
  }
  
  private long a(int paramInt)
  {
    Object localObject = com.tencent.mapsdk.a.e.a.c();
    if (localObject == null) {}
    for (;;)
    {
      return -1L;
      localObject = (String)localObject + File.separator + this.a;
      try
      {
        localObject = new RandomAccessFile((String)localObject, "rw");
        ((RandomAccessFile)localObject).seek(paramInt);
        paramInt = ((RandomAccessFile)localObject).readInt();
        long l = ((RandomAccessFile)localObject).readLong();
        int i = ((RandomAccessFile)localObject).readInt();
        ((RandomAccessFile)localObject).close();
        if (paramInt == i) {
          return l;
        }
      }
      catch (Exception localException) {}
    }
    return -1L;
  }
  
  public static com.tencent.mapsdk.a.b.c a(PointF paramPointF1, com.tencent.mapsdk.a.b.c paramc, PointF paramPointF2, com.tencent.mapsdk.a.b.a parama)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF2.x;
    float f3 = paramPointF1.y;
    float f4 = paramPointF2.y;
    double d1 = paramc.b;
    double d2 = f1 - f2;
    double d3 = parama.d();
    return new com.tencent.mapsdk.a.b.c(paramc.a - (f3 - f4) * parama.d(), d1 + d2 * d3);
  }
  
  public static com.tencent.mapsdk.a.b.c a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    double d1 = paramLatLng.getLatitude();
    double d2 = paramLatLng.getLongitude() * 2.003750834E7D / 180.0D;
    return new com.tencent.mapsdk.a.b.c(Math.log(Math.tan((d1 + 90.0D) * 3.141592653589793D / 360.0D)) / 0.017453292519943295D * 2.003750834E7D / 180.0D, d2);
  }
  
  public static com.tencent.mapsdk.a.c.a a(float paramFloat, Point paramPoint)
  {
    e locale = new e();
    locale.a(paramFloat);
    locale.a(paramPoint);
    return locale;
  }
  
  public static com.tencent.mapsdk.a.c.a a(CameraPosition paramCameraPosition)
  {
    com.tencent.mapsdk.a.c.c localc = new com.tencent.mapsdk.a.c.c();
    localc.a(paramCameraPosition);
    return localc;
  }
  
  public static com.tencent.mapsdk.a.c.a a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b();
    localb.a(paramLatLngBounds);
    localb.c(paramInt3);
    localb.a(paramInt1);
    localb.b(paramInt2);
    return localb;
  }
  
  public static d a()
  {
    if (c == null) {
      c = new d();
    }
    return c;
  }
  
  public static LatLng a(com.tencent.mapsdk.a.b.c paramc)
  {
    float f = (float)(paramc.b * 180.0D / 2.003750834E7D);
    return new LatLng((float)(57.29577951308232D * (2.0D * Math.atan(Math.exp((float)(paramc.a * 180.0D / 2.003750834E7D) * 3.141592653589793D / 180.0D)) - 1.5707963267948966D)), f);
  }
  
  public static LatLng a(GeoPoint paramGeoPoint)
  {
    return new LatLng(paramGeoPoint.getLatitudeE6() * 1.0D / 1000000.0D, paramGeoPoint.getLongitudeE6() * 1.0D / 1000000.0D);
  }
  
  public static String a(String paramString, Object paramObject)
  {
    return paramString + "=" + String.valueOf(paramObject);
  }
  
  public static String a(String... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramVarArgs.length;
    int j = 0;
    while (i < k)
    {
      localStringBuilder.append(paramVarArgs[i]);
      if (j != paramVarArgs.length - 1) {
        localStringBuilder.append(",");
      }
      j += 1;
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = com.tencent.mapsdk.a.e.a.c();
    if (localObject == null) {
      return;
    }
    localObject = (String)localObject + File.separator + this.a;
    try
    {
      localObject = new RandomAccessFile((String)localObject, "rw");
      ((RandomAccessFile)localObject).seek(paramInt);
      ((RandomAccessFile)localObject).writeInt(this.b);
      ((RandomAccessFile)localObject).writeLong(paramLong);
      ((RandomAccessFile)localObject).writeInt(this.b);
      ((RandomAccessFile)localObject).close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Stack localStack = new Stack();
    localStack.push(paramString);
    while (!localStack.isEmpty())
    {
      File localFile = new File((String)localStack.peek());
      if (localFile.exists())
      {
        if (localFile.isDirectory())
        {
          paramString = localFile.listFiles();
          if ((paramString == null) || (paramString.length == 0))
          {
            localFile.delete();
            localStack.pop();
          }
          else
          {
            int j = paramString.length;
            int i = 0;
            label92:
            if (i < j)
            {
              localFile = paramString[i];
              if (!localFile.isDirectory()) {
                break label125;
              }
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break label92;
              break;
              label125:
              localFile.delete();
            }
          }
        }
        else
        {
          localFile.delete();
          localStack.pop();
        }
      }
      else {
        localStack.pop();
      }
    }
    return true;
  }
  
  public static GeoPoint b(LatLng paramLatLng)
  {
    return new GeoPoint((int)(paramLatLng.getLatitude() * 1000000.0D), (int)(paramLatLng.getLongitude() * 1000000.0D));
  }
  
  public final void a(long paramLong)
  {
    a(0, paramLong);
  }
  
  public final long b()
  {
    return a(0);
  }
  
  public final void b(long paramLong)
  {
    a(this.e, paramLong);
  }
  
  public final long c()
  {
    return a(this.e);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */