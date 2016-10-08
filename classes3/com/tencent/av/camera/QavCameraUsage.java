package com.tencent.av.camera;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ggv;
import java.util.Iterator;
import java.util.List;

public class QavCameraUsage
{
  public static final String a = "QavCameraUsage";
  public static final String b = "qav_camera_usage_sp";
  public static final String c = "camera_used";
  private static final String d = "com.tencent.mobileqq:video";
  
  public QavCameraUsage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("qav_camera_usage_sp", 4).edit();
    paramContext.putBoolean("camera_used", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return paramContext.getSharedPreferences("qav_camera_usage_sp", 4).getBoolean("camera_used", false);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramContext == null) {
      return bool2;
    }
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    label39:
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label79;
      }
      if (!((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video")) {
        break label140;
      }
      i = 1;
    }
    label79:
    label140:
    for (;;)
    {
      break label39;
      j = 0;
      if (j != 0) {
        bool1 = a(paramContext);
      }
      for (;;)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        bool2 = bool1;
        if (!paramBoolean) {
          break;
        }
        new Handler(Looper.getMainLooper()).post(new ggv(paramContext));
        return bool1;
        a(paramContext, false);
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\camera\QavCameraUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */