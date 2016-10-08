package com.tencent.mobileqq.camera.utils;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;

public class ApiHelper
{
  public static final boolean a;
  public static final boolean b;
  public static final boolean c;
  public static final boolean d;
  public static final boolean e;
  public static boolean f;
  public static final boolean g;
  public static final boolean h;
  public static final boolean i;
  public static final boolean j;
  public static final boolean k;
  public static final boolean l;
  public static final boolean m;
  public static final boolean n;
  
  static
  {
    boolean bool2 = true;
    boolean bool1 = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT >= 14)
    {
      bool1 = true;
      a = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label255;
      }
      bool1 = true;
      label30:
      b = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label260;
      }
      bool1 = true;
      label44:
      c = bool1;
      if (Build.VERSION.SDK_INT < 15) {
        break label265;
      }
      bool1 = a("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
      label80:
      d = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label270;
      }
      bool1 = a("android.graphics.SurfaceTexture", "release", new Class[0]);
      label104:
      e = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label275;
      }
      bool1 = true;
      label118:
      f = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label280;
      }
      bool1 = true;
      label132:
      g = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label285;
      }
      bool1 = a(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
      label161:
      h = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label290;
      }
      bool1 = true;
      label175:
      i = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label295;
      }
      bool1 = true;
      label189:
      j = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label300;
      }
      bool1 = true;
      label203:
      k = bool1;
      if (Build.VERSION.SDK_INT < 19) {
        break label305;
      }
      bool1 = true;
      label217:
      l = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label310;
      }
      bool1 = true;
      label231:
      m = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label315;
      }
    }
    label255:
    label260:
    label265:
    label270:
    label275:
    label280:
    label285:
    label290:
    label295:
    label300:
    label305:
    label310:
    label315:
    for (bool1 = bool2;; bool1 = false)
    {
      n = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
      bool1 = false;
      break label44;
      bool1 = false;
      break label80;
      bool1 = false;
      break label104;
      bool1 = false;
      break label118;
      bool1 = false;
      break label132;
      bool1 = false;
      break label161;
      bool1 = false;
      break label175;
      bool1 = false;
      break label189;
      bool1 = false;
      break label203;
      bool1 = false;
      break label217;
      bool1 = false;
      break label231;
    }
  }
  
  public static int a(Class paramClass1, String paramString, Class paramClass2, int paramInt)
  {
    try
    {
      int i1 = paramClass1.getDeclaredField(paramString).getInt(paramClass2);
      return i1;
    }
    catch (Exception paramClass1) {}
    return paramInt;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  private static boolean a(Class paramClass, String paramString)
  {
    try
    {
      paramClass.getDeclaredField(paramString);
      return true;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  private static boolean a(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass) {}
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2, Class... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 12;
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean e()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean f()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\utils\ApiHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */