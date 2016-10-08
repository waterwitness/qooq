package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class DatingLocaleInfo
  implements Serializable
{
  public String city;
  public String country;
  public DatingLocaleInfo.DatingGPS gps;
  public String name;
  public String poi;
  public String province;
  public String region;
  
  public DatingLocaleInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, DatingLocaleInfo.DatingGPS paramDatingGPS)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = paramString1;
    this.country = paramString2;
    this.province = paramString3;
    this.city = paramString4;
    this.region = paramString5;
    this.poi = paramString6;
    this.gps = paramDatingGPS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\DatingLocaleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */