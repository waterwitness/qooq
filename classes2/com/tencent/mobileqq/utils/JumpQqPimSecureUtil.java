package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class JumpQqPimSecureUtil
{
  public static final String a = "com.tencent.qqpimsecure";
  public static final String b = "platform_Id";
  public static final String c = "launchParam";
  public static final String d = "dest_view";
  public static final String e = "dest_apk";
  
  public JumpQqPimSecureUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext != null)
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpimsecure");
      if (localIntent != null)
      {
        Bundle localBundle = new Bundle();
        if ((paramString != null) && (paramString.length() > 0)) {
          localBundle.putString("platform_Id", paramString);
        }
        if (paramInt > 0) {
          localBundle.putInt("dest_view", paramInt);
        }
        localIntent.putExtras(localBundle);
        localIntent.setFlags(402653184);
        paramContext.startActivity(localIntent);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 64).signatures;
      Object localObject = MessageDigest.getInstance("MD5");
      if ((paramContext != null) && (paramContext.length > 0)) {
        ((MessageDigest)localObject).update(paramContext[0].toByteArray());
      }
      paramContext = ((MessageDigest)localObject).digest();
      localObject = new char[16];
      Object tmp54_53 = localObject;
      tmp54_53[0] = 48;
      Object tmp59_54 = tmp54_53;
      tmp59_54[1] = 49;
      Object tmp64_59 = tmp59_54;
      tmp64_59[2] = 50;
      Object tmp69_64 = tmp64_59;
      tmp69_64[3] = 51;
      Object tmp74_69 = tmp69_64;
      tmp74_69[4] = 52;
      Object tmp79_74 = tmp74_69;
      tmp79_74[5] = 53;
      Object tmp84_79 = tmp79_74;
      tmp84_79[6] = 54;
      Object tmp90_84 = tmp84_79;
      tmp90_84[7] = 55;
      Object tmp96_90 = tmp90_84;
      tmp96_90[8] = 56;
      Object tmp102_96 = tmp96_90;
      tmp102_96[9] = 57;
      Object tmp108_102 = tmp102_96;
      tmp108_102[10] = 65;
      Object tmp114_108 = tmp108_102;
      tmp114_108[11] = 66;
      Object tmp120_114 = tmp114_108;
      tmp120_114[12] = 67;
      Object tmp126_120 = tmp120_114;
      tmp126_120[13] = 68;
      Object tmp132_126 = tmp126_120;
      tmp132_126[14] = 69;
      Object tmp138_132 = tmp132_126;
      tmp138_132[15] = 70;
      tmp138_132;
      StringBuilder localStringBuilder = new StringBuilder(paramContext.length * 2);
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder.append(localObject[((paramContext[i] & 0xF0) >>> 4)]);
        localStringBuilder.append(localObject[(paramContext[i] & 0xF)]);
        i += 1;
      }
      if (!"00B1208638DE0FCD3E920886D658DAF6".equalsIgnoreCase(localStringBuilder.toString()))
      {
        boolean bool2 = "7CC749CFC0FB5677E6ABA342EDBDBA5A".equalsIgnoreCase(localStringBuilder.toString());
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        do
        {
          if (!paramContext.hasNext()) {
            break;
          }
        } while (!"com.tencent.qqpimsecure".equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName));
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (Build.VERSION.SDK_INT < 21) {}
      }
      try
      {
        paramContext = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "ps" }).getInputStream()));
        do
        {
          do
          {
            localObject = paramContext.readLine();
            bool2 = bool1;
            if (localObject == null) {
              break;
            }
          } while (((String)localObject).indexOf("com.tencent.qqpimsecure") == -1);
          Object localObject = new StringTokenizer((String)localObject, " ");
          ((StringTokenizer)localObject).nextToken();
          ((StringTokenizer)localObject).nextToken();
          ((StringTokenizer)localObject).nextToken();
          ((StringTokenizer)localObject).nextToken();
          ((StringTokenizer)localObject).nextToken();
          ((StringTokenizer)localObject).nextToken();
          ((StringTokenizer)localObject).nextToken();
          ((StringTokenizer)localObject).nextToken();
          bool2 = TextUtils.equals(((StringTokenizer)localObject).nextToken().trim(), "com.tencent.qqpimsecure");
        } while (!bool2);
        bool2 = true;
        return bool2;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return bool1;
      }
    }
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        bool1 = bool2;
        if (paramContext != null)
        {
          boolean bool3 = paramContext.contains("mini");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        bool1 = bool2;
        if (paramContext != null)
        {
          boolean bool3 = paramContext.contains("minipay");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        int i = paramContext.versionCode;
        bool1 = bool2;
        if (i >= 198) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    return ((a(paramContext)) && (e(paramContext)) && (!c(paramContext))) || (d(paramContext));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\JumpQqPimSecureUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */