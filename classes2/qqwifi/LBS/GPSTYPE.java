package qqwifi.LBS;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class GPSTYPE
  implements Serializable
{
  public static final int _GPS_GCJ02 = 1;
  public static final int _GPS_WGS84 = 0;
  public static final int _GPS_WGS_REAL = 2;
  
  public GPSTYPE()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qqwifi\LBS\GPSTYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */