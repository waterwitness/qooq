package com.tencent.biz.qqstory.takevideo.rmw;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.SystemUtil;
import java.lang.reflect.Method;

public class Utils
{
  private static final String a = "RMWUtils";
  
  public Utils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(a(paramContext) * paramFloat + 0.5F);
  }
  
  public static boolean a(Context paramContext)
  {
    return true;
  }
  
  private static boolean a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      try
      {
        Class.forName(localAppOpsManager.getClass().getName());
        paramInt = ((Integer)localAppOpsManager.getClass().getDeclaredMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Binder.getCallingUid()), paramContext.getApplicationContext().getPackageName() })).intValue();
        SLog.c("RMWUtils", "0 invoke " + paramInt);
        return paramInt == 0;
      }
      catch (Exception paramContext)
      {
        SLog.b("RMWUtils", "checkOp failed.", paramContext);
      }
    }
    return false;
  }
  
  private static boolean b(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if ((SystemUtil.b()) && (i >= 19)) {
      return a(paramContext, 24);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */