package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;

public class VasH5PayUtil
{
  private static Long a = Long.valueOf(0L);
  public static final String a = "http://imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=";
  public static String b = "sendUin";
  public static String c = "openMonth";
  public static String d = "aid";
  public static String e = "offerId";
  public static String f = "serviceName";
  public static String g = "serviceCode";
  public static String h = "type";
  public static String i = "callbacksn";
  public static String j = "payUrl";
  private static final String k = "VasH5PayUtil";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (System.currentTimeMillis() - a.longValue() > 1000L)
    {
      a = Long.valueOf(System.currentTimeMillis());
      localStringBuilder = new StringBuilder("http://imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=");
      localStringBuilder.append(paramString1);
      if (!"CJCLUBT".equals(paramString2)) {
        break label119;
      }
      localStringBuilder.append("&type=svip");
    }
    for (;;)
    {
      if (paramInt > 0) {
        localStringBuilder.append("&month=" + paramInt);
      }
      paramString1 = new Intent(paramContext, QQVasH5PayBrowserActivity.class);
      paramString1.putExtra("url", localStringBuilder.toString());
      paramContext.startActivity(paramString1);
      return;
      label119:
      if ("LTMCLUB".equals(paramString2)) {
        localStringBuilder.append("&type=vip");
      }
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder;
    if (System.currentTimeMillis() - a.longValue() > 1000L)
    {
      a = Long.valueOf(System.currentTimeMillis());
      localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(paramString4)) {
        break label185;
      }
      localStringBuilder.append("http://imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=");
      if (!TextUtils.isEmpty(paramString1)) {
        localStringBuilder.append(paramString1);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        localStringBuilder.append("&type=" + paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localStringBuilder.append("&sendServiceUin=" + paramString3);
      }
      localStringBuilder.append("&month=" + paramInt);
      paramString1 = new Intent(paramContext, QQVasH5PayBrowserActivity.class);
      paramString1.putExtra("url", localStringBuilder.toString());
      paramContext.startActivity(paramString1);
      return;
      label185:
      localStringBuilder.append(paramString4);
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString4.contains("aid="))) {
        if (paramString4.contains("?")) {
          localStringBuilder.append("&aid=" + paramString1);
        } else {
          localStringBuilder.append("?aid=" + paramString1);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramBundle == null)) {
      return;
    }
    paramQQAppInterface = paramBundle.getString(d);
    String str1 = paramBundle.getString(h);
    int i1 = paramBundle.getInt(c);
    String str2 = paramBundle.getString(b);
    paramBundle.getString(e);
    paramBundle.getString(f);
    paramBundle.getString(g);
    paramBundle.getString(i);
    paramBundle = paramBundle.getString(j);
    int n = 0;
    int m = 36200;
    if (ClubContentJsonTask.a != null)
    {
      n = ClubContentJsonTask.a.a;
      m = ClubContentJsonTask.a.b;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasH5PayUtil", 2, "enter2 H5pay H5switch = " + n + " X5Version = " + QbSdk.getTbsVersion(paramContext) + " minVersion = " + m);
    }
    a(paramContext, paramQQAppInterface, str1, i1, str2, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(paramContext, paramString1, paramString3, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\VasH5PayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */