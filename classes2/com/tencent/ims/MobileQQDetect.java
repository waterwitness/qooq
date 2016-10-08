package com.tencent.ims;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MobileQQDetect
{
  public static final int BASELINE_BACKTOFRONT = 4;
  public static final int BASELINE_LOGIN = 2;
  public static final int BASELINE_NOW = 1;
  public static final int BUSINESS_LUCKYMONEY = 1;
  public static final int NETWORK_2G = 2;
  public static final int NETWORK_3G = 3;
  public static final int NETWORK_4G = 4;
  public static final int NETWORK_UNKNOWN = 0;
  public static final int NETWORK_WIFI = 1;
  public static final int PLATFORM_ALL = 3;
  public static final int PLATFORM_ANDROID = 1;
  public static final int PLATFORM_IOS = 2;
  public static final int TYPE_INSTALLED_APPINFO = 48;
  public static final int TYPE_MANIFESTINFO = 80;
  public static final int TYPE_RUNNING_APPINFO = 64;
  public static final int TYPE_SELF_MODULEINFO = 32;
  public static final int TYPE_SIGNATURE = 16;
  
  private MobileQQDetect()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\ims\MobileQQDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */