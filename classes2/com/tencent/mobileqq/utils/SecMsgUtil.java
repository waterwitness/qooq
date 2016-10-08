package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class SecMsgUtil
{
  public static int a;
  
  public SecMsgUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    if (Build.VERSION.SDK_INT > 10) {
      return 4;
    }
    return 0;
  }
  
  public static long a()
  {
    long l2 = (int)NetConnInfoCenter.getServerTime();
    long l1 = l2;
    if (l2 == 0L) {
      l1 = (int)(System.currentTimeMillis() / 1000L);
    }
    l2 = Math.abs(new Random().nextInt());
    int i = a;
    a = i + 1;
    return (l1 << 32 | l2 << 16 | i) & 0x7FFFFFFFFFFFFFFF;
  }
  
  public static boolean a()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mobileqq")) && (localRunningAppProcessInfo.importance == 100) && ("com.tencent.mobileqq:secmsg".equalsIgnoreCase(localRunningAppProcessInfo.processName))) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\SecMsgUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */