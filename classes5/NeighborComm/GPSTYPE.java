package NeighborComm;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class GPSTYPE
  implements Serializable
{
  public static final GPSTYPE GPS_MARS;
  public static final GPSTYPE GPS_MARS_VIRTUAL;
  public static final GPSTYPE GPS_WGS84;
  public static final GPSTYPE GPS_WGS84_VIRTUAL;
  public static final GPSTYPE GPS_WGS_REAL;
  public static final int _GPS_MARS = 1;
  public static final int _GPS_MARS_VIRTUAL = 4;
  public static final int _GPS_WGS84 = 0;
  public static final int _GPS_WGS84_VIRTUAL = 3;
  public static final int _GPS_WGS_REAL = 2;
  private static GPSTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!GPSTYPE.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new GPSTYPE[5];
      GPS_WGS84 = new GPSTYPE(0, 0, "GPS_WGS84");
      GPS_MARS = new GPSTYPE(1, 1, "GPS_MARS");
      GPS_WGS_REAL = new GPSTYPE(2, 2, "GPS_WGS_REAL");
      GPS_WGS84_VIRTUAL = new GPSTYPE(3, 3, "GPS_WGS84_VIRTUAL");
      GPS_MARS_VIRTUAL = new GPSTYPE(4, 4, "GPS_MARS_VIRTUAL");
      return;
    }
  }
  
  private GPSTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static GPSTYPE convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static GPSTYPE convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NeighborComm\GPSTYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */