package com.tencent.av.opengl.utils;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class Utils
{
  public static final boolean A;
  public static final boolean B;
  public static final boolean C;
  public static final boolean D;
  public static final boolean E;
  public static final boolean F;
  public static final boolean G;
  public static final boolean H;
  public static final boolean I;
  public static final boolean J;
  public static final boolean K;
  public static final boolean L;
  public static final boolean M;
  public static final boolean N;
  public static final boolean O;
  public static final boolean P;
  public static final boolean Q;
  public static final boolean R;
  public static final boolean S;
  public static final boolean T;
  private static final String a = "Utils";
  public static final boolean a;
  public static final boolean b;
  public static final boolean c;
  public static final boolean d;
  public static final boolean e;
  public static final boolean f;
  public static final boolean g;
  public static final boolean h;
  public static final boolean i;
  public static final boolean j;
  public static final boolean k;
  public static final boolean l;
  public static final boolean m;
  public static final boolean n;
  public static final boolean o;
  public static final boolean p;
  public static final boolean q;
  public static final boolean r;
  public static final boolean s;
  public static final boolean t;
  public static final boolean u;
  public static final boolean v;
  public static final boolean w;
  public static final boolean x;
  public static final boolean y;
  public static final boolean z = false;
  
  static
  {
    boolean bool2 = true;
    bool1 = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = true;
      a = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label707;
      }
      bool1 = true;
      label30:
      b = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label712;
      }
      bool1 = true;
      label44:
      c = bool1;
      d = a(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
      e = a(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION");
      f = a(MediaStore.MediaColumns.class, "WIDTH");
      if (Build.VERSION.SDK_INT < 16) {
        break label717;
      }
      bool1 = true;
      label88:
      g = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label722;
      }
      bool1 = true;
      label102:
      h = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label727;
      }
      bool1 = true;
      label116:
      i = bool1;
      j = a("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
      k = a("android.graphics.SurfaceTexture", "release", new Class[0]);
      if (Build.VERSION.SDK_INT < 11) {
        break label732;
      }
      bool1 = true;
      label170:
      l = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label737;
      }
      bool1 = true;
      label184:
      m = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label742;
      }
      bool1 = true;
      label198:
      n = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label747;
      }
      bool1 = true;
      label212:
      o = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label752;
      }
      bool1 = true;
      label226:
      p = bool1;
      q = a(View.class, "setSystemUiVisibility", new Class[] { Integer.TYPE });
    }
    for (;;)
    {
      try
      {
        if ((!a(Camera.class, "setFaceDetectionListener", new Class[] { Class.forName("android.hardware.Camera$FaceDetectionListener") })) || (!a(Camera.class, "startFaceDetection", new Class[0])) || (!a(Camera.class, "stopFaceDetection", new Class[0]))) {
          continue;
        }
        bool1 = a(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Throwable localThrowable)
      {
        label707:
        label712:
        label717:
        label722:
        label727:
        label732:
        label737:
        label742:
        label747:
        label752:
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      r = bool1;
      s = a(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      t = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      u = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      bool1 = true;
      v = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      bool1 = true;
      w = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      bool1 = true;
      x = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      y = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        continue;
      }
      bool1 = true;
      A = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      B = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      C = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      D = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      E = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      F = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      G = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        continue;
      }
      bool1 = true;
      H = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      I = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      bool1 = true;
      J = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        continue;
      }
      bool1 = true;
      K = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      L = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      M = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      N = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      O = bool1;
      P = a(WindowManager.LayoutParams.class, "rotationAnimation");
      if (Build.VERSION.SDK_INT < 18) {
        continue;
      }
      bool1 = true;
      Q = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      R = bool1;
      if (Build.VERSION.SDK_INT < 18) {
        continue;
      }
      bool1 = true;
      S = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        continue;
      }
      bool1 = bool2;
      T = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
      bool1 = false;
      break label44;
      bool1 = false;
      break label88;
      bool1 = false;
      break label102;
      bool1 = false;
      break label116;
      bool1 = false;
      break label170;
      bool1 = false;
      break label184;
      bool1 = false;
      break label198;
      bool1 = false;
      break label212;
      bool1 = false;
      break label226;
      bool1 = false;
    }
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static int a()
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Utils", 2, "WL_DEBUG checkError error = " + i1);
      }
      SmallScreenUtils.a();
    }
    return i1;
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 1073741824)) {
      throw new IllegalArgumentException("n is invalid: " + paramInt);
    }
    paramInt -= 1;
    paramInt |= paramInt >> 16;
    paramInt |= paramInt >> 8;
    paramInt |= paramInt >> 4;
    paramInt |= paramInt >> 2;
    return (paramInt | paramInt >> 1) + 1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static int a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9) {}
    for (;;)
    {
      return 1;
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
        if (paramContext == null) {
          continue;
        }
        int i1 = paramContext.reqGlEsVersion;
        if (i1 >= 131072) {}
        for (i1 = 2;; i1 = 1) {
          return i1;
        }
        return 1;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
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
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 > paramLong3) {
      return paramLong3;
    }
    if (paramLong1 < paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt >>> 24 == 255;
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
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 == null) {}
      while (!paramObject1.equals(paramObject2)) {
        return false;
      }
    }
    return true;
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
  
  public static int b(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    return Integer.highestOneBit(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */