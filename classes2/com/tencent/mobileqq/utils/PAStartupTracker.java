package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class PAStartupTracker
{
  public static final String a = "PAMonitor.TimeCost";
  private static ConcurrentHashMap a = new ConcurrentHashMap(new HashMap(8));
  public static final boolean a = false;
  public static final String b = "pubAcc_aio_open";
  public static final String c = "pubAcc_profile_display";
  public static final String d = "pubAcc_follow_confirm";
  public static final String e = " pubAcc_follow_cancel";
  public static final String f = "pubAcc_follow_list_display";
  public static final String g = "pubAcc_structMsg_display";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\PAStartupTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */