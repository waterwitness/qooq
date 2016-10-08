package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class DatingLocaleInfo$DatingGPS
  implements Serializable
{
  public int alt;
  public int lat;
  public int lon;
  public int type;
  
  public DatingLocaleInfo$DatingGPS(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.lat = paramInt1;
    this.lon = paramInt2;
    this.alt = paramInt3;
    this.type = paramInt4;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\DatingLocaleInfo$DatingGPS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */