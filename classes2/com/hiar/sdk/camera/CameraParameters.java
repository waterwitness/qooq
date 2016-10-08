package com.hiar.sdk.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import com.hiar.sdk.core.HiarqCameraCalib;
import com.hiar.sdk.core.HiarqImageSize;
import com.hiar.sdk.core.NativeInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraParameters
{
  private static Method a;
  private static Method b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public static int a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Integer)paramList.next()).intValue() == 17) {
        return 17;
      }
    }
    return -1;
  }
  
  private static void a()
  {
    try
    {
      b = Camera.Parameters.class.getMethod("getSupportedPreviewSizes", (Class[])null);
      try
      {
        a = Camera.Parameters.class.getMethod("getSupportedPreviewFormats", (Class[])null);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException1) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      for (;;) {}
    }
  }
  
  public static void a(Camera.Parameters paramParameters)
  {
    String str2 = "continuous-video";
    String str1 = str2;
    try
    {
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        str1 = str2;
        if (Build.VERSION.SDK_INT >= 14) {
          str1 = "continuous-picture";
        }
      }
      if (paramParameters.getSupportedFocusModes().contains(str1)) {
        paramParameters.setFocusMode(str1);
      }
      return;
    }
    catch (RuntimeException paramParameters)
    {
      paramParameters.printStackTrace();
    }
  }
  
  public static void a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    int i = 0;
    Camera.Parameters localParameters = paramCamera.getParameters();
    if (b != null) {}
    for (;;)
    {
      try
      {
        Object localObject1 = b.invoke(localParameters, (Object[])null);
        Object localObject4;
        Object localObject5;
        if ((localObject1 instanceof List))
        {
          localObject4 = (List)localObject1;
          localObject1 = new ArrayList();
          localObject4 = ((List)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject5 = (Camera.Size)((Iterator)localObject4).next();
          if (((((Camera.Size)localObject5).width == 980) && (((Camera.Size)localObject5).height == 800) && ("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && (("GT-I9220".equalsIgnoreCase(Build.MODEL)) || ("GT-N7000".equalsIgnoreCase(Build.MODEL)))) || (((((Camera.Size)localObject5).width != 1184) || (((Camera.Size)localObject5).height != 666)) && (((((Camera.Size)localObject5).width == 704) && (((Camera.Size)localObject5).height == 576) && ("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9300".equalsIgnoreCase(Build.MODEL))) || ((((Camera.Size)localObject5).width == 800) && (((Camera.Size)localObject5).height == 450) && ("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9100".equalsIgnoreCase(Build.MODEL)))))) {
            continue;
          }
          ((List)localObject1).add(localObject5);
          continue;
        }
        Object localObject2;
        HiarqImageSize[] arrayOfHiarqImageSize;
        Integer localInteger;
        Camera.Size localSize;
        Object localObject3 = null;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        localIllegalArgumentException1.printStackTrace();
        if (a != null) {
          try
          {
            localObject2 = (List)a.invoke(localParameters, (Object[])null);
            if (localObject2 != null)
            {
              paramInt1 = a((List)localObject2);
              if (paramInt1 != -1) {
                localParameters.setPreviewFormat(paramInt1);
              }
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            localIllegalArgumentException2.printStackTrace();
            continue;
          }
          catch (IllegalAccessException localIllegalAccessException2)
          {
            localIllegalAccessException2.printStackTrace();
            continue;
          }
          catch (InvocationTargetException localInvocationTargetException2)
          {
            localInvocationTargetException2.printStackTrace();
            continue;
          }
        }
        try
        {
          a(localParameters);
          paramCamera.setParameters(localParameters);
          return;
        }
        catch (RuntimeException paramCamera)
        {
          paramCamera.printStackTrace();
          return;
        }
        localObject4 = localParameters.getPreviewSize();
        if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
        {
          localObject2 = localObject4;
          if ((localObject2 == null) || ((((Camera.Size)localObject2).height == ((Camera.Size)localObject4).height) && (((Camera.Size)localObject2).width == ((Camera.Size)localObject4).width))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AndAR", 2, "'query preview sizes' available, setting size to: " + paramInt1 + " x " + paramInt2);
          }
          localParameters.setPreviewSize(((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height);
        }
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        localIllegalAccessException1.printStackTrace();
        continue;
        if (NativeInterface.loadNativeLibrary())
        {
          localObject5 = new HiarqCameraCalib();
          ((HiarqCameraCalib)localObject5).mat = new float[9];
          arrayOfHiarqImageSize = new HiarqImageSize[localIllegalAccessException1.size()];
          if (i < localIllegalAccessException1.size())
          {
            arrayOfHiarqImageSize[i] = new HiarqImageSize();
            arrayOfHiarqImageSize[i].width = ((Camera.Size)localIllegalAccessException1.get(i)).width;
            arrayOfHiarqImageSize[i].height = ((Camera.Size)localIllegalAccessException1.get(i)).height;
            i += 1;
            continue;
          }
          localInteger = Integer.valueOf(0);
          NativeInterface.hiarqGetPreferredCameraInfo(arrayOfHiarqImageSize, localInteger, (HiarqCameraCalib)localObject5);
          if ((localInteger.intValue() >= 0) && (localInteger.intValue() < localIllegalAccessException1.size()))
          {
            localSize = (Camera.Size)localIllegalAccessException1.get(localInteger.intValue());
            continue;
          }
        }
      }
      catch (InvocationTargetException localInvocationTargetException1)
      {
        localInvocationTargetException1.printStackTrace();
        continue;
        if (localParameters.getPreviewFormat() != 17) {
          localParameters.setPreviewFormat(17);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\camera\CameraParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */