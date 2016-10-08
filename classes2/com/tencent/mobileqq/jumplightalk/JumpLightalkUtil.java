package com.tencent.mobileqq.jumplightalk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class JumpLightalkUtil
{
  public static final int a = 1;
  public static final String a = "com.tencent.lightalk";
  public static final int b = 2;
  public static final String b = "laidian.qq.com";
  public static final int c = 2;
  public static final String c = "tencentlightalk://local/call?phone_num=%s&app_id=%s&package_name=%s";
  public static final String d = "&app_name=%s";
  public static final String e = "&call_type=%s";
  public static final String f = "&need_back=%s";
  
  public JumpLightalkUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("tencentlightalk://local/call?phone_num=%s&app_id=%s&package_name=%s", new Object[] { paramString1, paramString2, paramString3 }));
    if (!TextUtils.isEmpty(paramString4)) {
      localStringBuilder.append(String.format("&app_name=%s", new Object[] { paramString4 }));
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localStringBuilder.append(String.format("&call_type=%s", new Object[] { paramString5 }));
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localStringBuilder.append(String.format("&need_back=%s", new Object[] { paramString6 }));
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    if ((paramString != null) && (!"".equals(paramString))) {
      localIntent.putExtra("url", paramString);
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      localIntent.putExtra("url", "laidian.qq.com");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse(a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6)));
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramString1)
    {
      Toast.makeText(paramContext, "buildJumpLightalkScheme is failed! " + paramString1.toString(), 1).show();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getApplicationInfo("com.tencent.lightalk", 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jumplightalk\JumpLightalkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */