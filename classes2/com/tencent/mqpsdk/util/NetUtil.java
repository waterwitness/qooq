package com.tencent.mqpsdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class NetUtil
{
  public static final int a = 0;
  public static String a = "ctnet";
  public static final int b = 1;
  public static String b = "ctwap";
  public static final int c = 2;
  public static String c = "cmnet";
  public static final int d = 3;
  public static String d = "cmwap";
  public static final int e = 4;
  public static String e = "uninet";
  public static final int f = 5;
  public static String f = "uniwap";
  private static final int g = 17;
  public static String g = "3gnet";
  public static String h = "3gwap";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Context paramContext)
  {
    switch ()
    {
    default: 
      return 0;
    case 0: 
      switch (AppNetConnInfo.getMobileInfo())
      {
      default: 
        return 0;
      case 0: 
        return 2;
      case 1: 
        return 3;
      }
      return 4;
    }
    return 1;
  }
  
  public static String a(Context paramContext)
  {
    String str1 = "nomatch";
    String str2 = AppNetConnInfo.getCurrentAPN();
    paramContext = str1;
    if (!TextUtils.isEmpty(str2))
    {
      if (!str2.startsWith(a)) {
        break label32;
      }
      paramContext = a;
    }
    label32:
    do
    {
      return paramContext;
      if (str2.startsWith(b)) {
        return b;
      }
      if (str2.startsWith(c)) {
        return c;
      }
      if (str2.startsWith(d)) {
        return d;
      }
      if (str2.startsWith(e)) {
        return e;
      }
      if (str2.startsWith(f)) {
        return f;
      }
      if (str2.startsWith(g)) {
        return g;
      }
      paramContext = str1;
    } while (!str2.startsWith(h));
    return h;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqpsdk\util\NetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */