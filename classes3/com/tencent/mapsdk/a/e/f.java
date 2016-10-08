package com.tencent.mapsdk.a.e;

import com.tencent.mapsdk.a.d.a.1;
import com.tencent.mapsdk.a.d.e;

public class f
{
  private static volatile f a;
  private int b = 1;
  private String[] c = { "http://p0.map.gtimg.com/maptilesv2", "http://p1.map.gtimg.com/maptilesv2", "http://p2.map.gtimg.com/maptilesv2", "http://p3.map.gtimg.com/maptilesv2" };
  private String[] d = { "http://p0.map.gtimg.com/hwaptiles", "http://p1.map.gtimg.com/hwaptiles", "http://p2.map.gtimg.com/hwaptiles", "http://p3.map.gtimg.com/hwaptiles" };
  private String[] e = { "http://p0.map.gtimg.com/sateTiles", "http://p1.map.gtimg.com/sateTiles", "http://p2.map.gtimg.com/sateTiles", "http://p3.map.gtimg.com/sateTiles" };
  private String[] f = { "http://mt0.google.com/vt", "http://mt1.google.com/vt", "http://mt2.google.com/vt", "http://mt3.google.com/vt" };
  private String g = "http://tencent";
  
  private static int a(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 % 4;
    paramInt1 = paramInt2;
    if (paramInt2 * 4 < 0) {
      paramInt1 = paramInt2 + 4;
    }
    return paramInt1;
  }
  
  public static f a(e parame)
  {
    int i = 1;
    if (a == null) {}
    try
    {
      if (a == null)
      {
        f localf = new f();
        a = localf;
        if (parame.f().a() > 1) {
          i = 2;
        }
        localf.b = i;
      }
      return a;
    }
    finally {}
  }
  
  private static int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = 1 << paramInt3;
    Object localObject;
    if ((paramInt2 < 0) || (paramInt2 >= paramInt3)) {
      localObject = null;
    }
    int[] arrayOfInt;
    do
    {
      return (int[])localObject;
      arrayOfInt = new int[2];
      arrayOfInt[0] = paramInt1;
      arrayOfInt[1] = paramInt2;
      if (paramInt1 < 0) {
        break;
      }
      localObject = arrayOfInt;
    } while (paramInt1 < paramInt3);
    arrayOfInt[0] = ((paramInt1 % paramInt3 + paramInt3) % paramInt3);
    return arrayOfInt;
  }
  
  public final String a(b paramb)
  {
    switch (paramb.e)
    {
    default: 
      return "invalid";
    case 1: 
      i = paramb.a;
      k = paramb.b;
      j = paramb.c;
      switch (this.b)
      {
      default: 
        j -= 1;
        k = (int)(Math.pow(2.0D, j + 1) - k - 1.0D);
        m = a(i + k, 4);
        paramb = a(i, k, j + 1);
        if (paramb == null) {
          return null;
        }
        break;
      case 1: 
        k = (int)(Math.pow(2.0D, j) - k - 1.0D);
        m = a(i + k, 4);
        paramb = a(i, k, j);
        if (paramb == null) {
          return null;
        }
        i = paramb[0];
        return this.c[m] + '/' + j + '/' + (i >> 4) + '/' + (k >> 4) + '/' + i + '_' + k + ".png";
      }
      i = paramb[0];
      return this.d[m] + '/' + j + '/' + (i >> 4) + '/' + (k >> 4) + '/' + i + '_' + k + ".png";
    case 2: 
      i = paramb.a;
      j = paramb.b;
      k = paramb.c;
      m = a(i + j, 4);
      paramb = this.f[m] + "/x=" + i + "&y=" + j + "&z=" + k + "&scale=";
      switch (this.b)
      {
      default: 
        return paramb + "1";
      }
      return paramb + "2";
    case 4: 
      i = paramb.c;
      return this.g + "/trafficengine/mapabc/traffictile?v=w2.61&zoom=" + (17 - i) + "&x=" + paramb.a + "&y=" + paramb.b;
    }
    int i = paramb.a;
    int k = paramb.b;
    int j = paramb.c;
    k = (int)(Math.pow(2.0D, j) - k - 1.0D);
    int m = a(i + k, 4);
    return this.e[m] + '/' + j + '/' + (i >> 4) + '/' + (k >> 4) + '/' + i + '_' + k + ".jpg";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */