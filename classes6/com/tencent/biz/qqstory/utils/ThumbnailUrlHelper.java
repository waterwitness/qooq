package com.tencent.biz.qqstory.utils;

import android.content.Context;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ThumbnailUrlHelper
{
  public static final int a = 1000;
  public static final String a = "Q.qqstory.home.ThumbnailUrlHelper";
  public static final int[] a = { 120, 200, 320, 512, 640, 750, 1000 };
  public static final int b = 2;
  public static String b;
  public static final int c = 3;
  public static String c;
  public static final int d = 4;
  public static String d;
  public static int e = 0;
  public static String e;
  public static String f = Integer.toString(a[0]);
  public static String g = Integer.toString(a[1]);
  public static final String h = "/qqstory_pic/";
  public static final String i = "http://p.qpic.cn";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    int k = Integer.MAX_VALUE;
    int n = a.length - 1;
    int j = 0;
    while (j < a.length)
    {
      int i1 = Math.abs(a[j] - paramInt);
      int m = k;
      if (i1 <= k)
      {
        n = j;
        m = i1;
      }
      j += 1;
      k = m;
    }
    return a[n];
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!b(paramString));
    paramString = c(paramString);
    if (b == null)
    {
      jdField_e_of_type_Int = a(UIUtils.a(paramContext));
      b = String.valueOf(jdField_e_of_type_Int);
      SLog.b("Q.qqstory.home.ThumbnailUrlHelper", "full screen thumbnail size: %s", b);
    }
    if (b == null)
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "can not find suitable size for full screen");
      return paramString + 0;
    }
    return paramString + b;
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!b(paramString));
    paramString = c(paramString);
    return paramString + f;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while ((!b(paramString)) || (paramString.endsWith("/")) || (paramString.endsWith("/0"))) {
      return true;
    }
    return false;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!b(paramString));
    paramString = c(paramString);
    if (c == null)
    {
      c = String.valueOf(a(UIUtils.a(paramContext) / 2));
      SLog.b("Q.qqstory.home.ThumbnailUrlHelper", "1/2 thumbnail size: %s", c);
    }
    if (c == null)
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "can not find suitable size for 1/2 screen");
      return paramString + 0;
    }
    return paramString + c;
  }
  
  public static String b(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!b(paramString));
    paramString = c(paramString);
    return paramString + g;
  }
  
  public static boolean b(String paramString)
  {
    if ((paramString.length() >= "http://p.qpic.cn".length() + "/qqstory_pic/".length()) && (paramString.startsWith("/qqstory_pic/", "http://p.qpic.cn".length()))) {
      return true;
    }
    return paramString.contains("/qqstory_pic/");
  }
  
  public static String c(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!b(paramString));
    paramString = c(paramString);
    if (d == null)
    {
      d = String.valueOf(a(UIUtils.a(paramContext) / 3));
      SLog.b("Q.qqstory.home.ThumbnailUrlHelper", "1/3 thumbnail size: %s", d);
    }
    if (d == null)
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "can not find suitable size for 1/3 screen");
      return paramString + 0;
    }
    return paramString + d;
  }
  
  public static String c(String paramString)
  {
    if (paramString.endsWith("/")) {
      return paramString;
    }
    int m = paramString.lastIndexOf("/");
    String str;
    int k;
    if ((m >= 0) && (m < paramString.length() - 1))
    {
      str = paramString.substring(m + 1, paramString.length());
      k = str.length() - 1;
      j = 0;
      if (k >= 0) {
        if (Character.isDigit(str.charAt(k))) {
          break label108;
        }
      }
    }
    for (int j = 0;; j = 0)
    {
      str = paramString;
      if (j != 0) {
        str = paramString.substring(0, m);
      }
      return str + "/";
      label108:
      k -= 1;
      j = 1;
      break;
    }
  }
  
  public static String d(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!b(paramString));
    paramString = c(paramString);
    if (jdField_e_of_type_JavaLangString == null)
    {
      jdField_e_of_type_JavaLangString = String.valueOf(a(UIUtils.a(paramContext) / 4));
      SLog.b("Q.qqstory.home.ThumbnailUrlHelper", "1/4 thumbnail size: %s", jdField_e_of_type_JavaLangString);
    }
    if (jdField_e_of_type_JavaLangString == null)
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "can not find suitable size for 1/4 screen");
      return paramString + 0;
    }
    return paramString + jdField_e_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\ThumbnailUrlHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */