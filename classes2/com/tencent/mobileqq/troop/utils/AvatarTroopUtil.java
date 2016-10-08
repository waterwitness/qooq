package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AvatarTroopUtil
{
  public static final int a = 140;
  public static final String a = "http://p.qlogo.cn/gh/dir/file/";
  public static final int b = 640;
  public static final String b = "http://p.qlogo.cn/gh/";
  public static final int c = 0;
  public static final String c = "http://s.url.cn/pub/img/qb_group_normal.png";
  public static final int d = 0;
  public static final int e = 1;
  
  public AvatarTroopUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if (a(paramString)) {
      return paramString + 140;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    String str = "http://p.qlogo.cn/gh/dir/file/";
    if (1 == paramInt) {
      paramString1 = "http://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2 + "_" + paramString1);
    }
    do
    {
      return paramString1;
      paramString1 = str;
    } while (paramInt != 0);
    return "http://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("http://p.qlogo.cn/gh/");
  }
  
  public static String b(String paramString)
  {
    if (a(paramString)) {
      return paramString + 0;
    }
    return null;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (((paramString.length() > 1) && (paramString.startsWith("+"))) || (paramString.startsWith("-"))) {}
    for (int i = 1;; i = 0)
    {
      int j = paramString.length();
      int k;
      do
      {
        k = j - 1;
        if (k < i) {
          break;
        }
        j = k;
      } while (Character.isDigit(paramString.charAt(k)));
      return false;
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\AvatarTroopUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */