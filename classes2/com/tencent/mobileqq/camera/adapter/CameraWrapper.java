package com.tencent.mobileqq.camera.adapter;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CameraWrapper
{
  private static CameraWrapper jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper;
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.CameraWrapper";
  
  private CameraWrapper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public static CameraWrapper a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new CameraWrapper();
      }
      return a;
    }
    finally {}
  }
  
  public float a(Camera.Parameters paramParameters)
  {
    QLog.w("Q.camera.CameraWrapper", 2, "[getExposureCompensationStep] return = " + 0.0F);
    return 0.0F;
  }
  
  public int a()
  {
    return 16;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    QLog.d("Q.camera.CameraWrapper", 2, "[getCameraOrientation] cameraId = " + paramInt1 + ", cameraOrientation = " + paramInt2);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt1, localCameraInfo);
    paramInt1 = localCameraInfo.orientation;
    if (localCameraInfo.facing == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "is FRONT camera, orientation = " + paramInt1);
      }
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "return orientation = " + paramInt1);
      }
      return paramInt1;
      if (CameraAttrs.a().h != -1)
      {
        paramInt1 = CameraAttrs.a().h;
        QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate0 = " + paramInt1);
        continue;
        if (CameraAttrs.a().jdField_i_of_type_Int != -1)
        {
          paramInt1 = CameraAttrs.a().jdField_i_of_type_Int;
          QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate90 = " + paramInt1);
          continue;
          if (CameraAttrs.a().j != -1)
          {
            paramInt1 = CameraAttrs.a().j;
            QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate180 = " + paramInt1);
            continue;
            if (CameraAttrs.a().k != -1)
            {
              paramInt1 = CameraAttrs.a().k;
              QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate270 = " + paramInt1);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("Q.camera.CameraWrapper", 2, "is BACK camera, orientation = " + paramInt1);
              }
              switch (paramInt2)
              {
              default: 
                break;
              case -1: 
              case 0: 
                if (CameraAttrs.a().jdField_l_of_type_Int != -1)
                {
                  paramInt1 = CameraAttrs.a().jdField_l_of_type_Int;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate0 = " + paramInt1);
                }
                break;
              case 90: 
                if (CameraAttrs.a().jdField_m_of_type_Int != -1)
                {
                  paramInt1 = CameraAttrs.a().jdField_m_of_type_Int;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate90 = " + paramInt1);
                }
                break;
              case 180: 
                if (CameraAttrs.a().jdField_n_of_type_Int != -1)
                {
                  paramInt1 = CameraAttrs.a().jdField_n_of_type_Int;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate180 = " + paramInt1);
                }
                break;
              case 270: 
                if (CameraAttrs.a().jdField_o_of_type_Int != -1)
                {
                  paramInt1 = CameraAttrs.a().jdField_o_of_type_Int;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate270 = " + paramInt1);
                }
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public CameraAttrs a()
  {
    return CameraAttrs.a();
  }
  
  public String a(boolean paramBoolean, Camera.Parameters paramParameters)
  {
    Object localObject = null;
    paramParameters = paramParameters.getFlashMode();
    if (paramBoolean)
    {
      QLog.w("Q.camera.CameraWrapper", 2, "[getFlashMode] isFrontCamera, close flash");
      paramParameters = (Camera.Parameters)localObject;
    }
    for (;;)
    {
      QLog.d("Q.camera.CameraWrapper", 2, "[getFlashMode] return = " + paramParameters);
      return paramParameters;
      if (CameraAttrs.a().jdField_i_of_type_Boolean)
      {
        QLog.w("Q.camera.CameraWrapper", 2, "[getFlashMode] disableBackFlashMode");
        paramParameters = (Camera.Parameters)localObject;
      }
    }
  }
  
  public List a(Camera.Parameters paramParameters)
  {
    List localList = paramParameters.getSupportedFocusModes();
    if (CameraAttrs.a().jdField_o_of_type_Boolean)
    {
      QLog.w("Q.camera.CameraWrapper", 2, "[getSupportedFocusMode] disableFocusMode");
      paramParameters = localList;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "[getSupportedFocusMode] focusList = " + paramParameters);
      }
      return (List)paramParameters;
      if (CameraAttrs.a().q)
      {
        QLog.w("Q.camera.CameraWrapper", 2, "[getSupportedFocusMode] disableFocusModeContinuousPicture");
        paramParameters = paramParameters.getSupportedFocusModes();
        if ((paramParameters != null) && (((List)paramParameters).contains("continuous-picture"))) {
          ((List)paramParameters).remove("continuous-picture");
        }
      }
      else
      {
        paramParameters = paramParameters.getSupportedFocusModes();
      }
    }
  }
  
  public List a(Boolean paramBoolean, Camera.Parameters paramParameters)
  {
    paramParameters = paramParameters.getSupportedFlashModes();
    if (paramBoolean.booleanValue())
    {
      QLog.w("Q.camera.CameraWrapper", 2, "[getSupportedFlashMode] isFrontCamera, close flash mode");
      if (paramParameters == null) {
        break label264;
      }
      ((List)paramParameters).clear();
      paramBoolean = paramParameters;
    }
    for (;;)
    {
      QLog.w("Q.camera.CameraWrapper", 2, "[getSupportedFlashMode] flashList = " + paramBoolean);
      return (List)paramBoolean;
      if (CameraAttrs.a().jdField_i_of_type_Boolean)
      {
        QLog.w("Q.camera.CameraWrapper", 2, "[getSupportedFlashMode] disableBackFlashMode");
        if (paramParameters != null) {
          ((List)paramParameters).clear();
        }
      }
      if (CameraAttrs.a().jdField_l_of_type_Boolean)
      {
        QLog.w("Q.camera.CameraWrapper", 2, "[getSupportedFlashMode] readFlashModeException");
        paramParameters = new ArrayList();
        ((List)paramParameters).clear();
        ((List)paramParameters).add("off");
        ((List)paramParameters).add("on");
        ((List)paramParameters).add("auto");
      }
      if (CameraAttrs.a().jdField_m_of_type_Boolean)
      {
        QLog.w("Q.camera.CameraWrapper", 2, "[getSupportedFlashMode] cannotSetFlashOn");
        if ((paramParameters != null) && (((List)paramParameters).contains("on"))) {
          ((List)paramParameters).remove("on");
        }
      }
      if (CameraAttrs.a().jdField_n_of_type_Boolean)
      {
        QLog.w("Q.camera.CameraWrapper", 2, "[getSupportedFlashMode] backFlashNoAuto");
        if ((paramParameters != null) && (((List)paramParameters).contains("auto"))) {
          ((List)paramParameters).remove("auto");
        }
      }
      paramBoolean = paramParameters;
      continue;
      label264:
      paramBoolean = paramParameters;
    }
  }
  
  public void a()
  {
    CameraAttrs.a().a(CameraUtils.a(BaseApplicationImpl.getContext()));
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraWrapper", 2, "[isSysVersionValid] ENTER sysCamerOn=" + CameraAttrs.a().b + " sysMinVersion=" + CameraAttrs.a().jdField_d_of_type_JavaLangString + " sysMaxVersion=" + CameraAttrs.a().e + " currVersion=" + Build.VERSION.RELEASE);
    }
    boolean bool1 = bool3;
    if (CameraAttrs.a().b) {}
    try
    {
      String[] arrayOfString2 = CameraAttrs.a().jdField_d_of_type_JavaLangString.split("\\.");
      String[] arrayOfString3 = CameraAttrs.a().e.split("\\.");
      String[] arrayOfString1;
      int j;
      int i;
      if (Build.VERSION.RELEASE != null)
      {
        arrayOfString1 = Build.VERSION.RELEASE.split("\\.");
        bool1 = bool3;
        if (arrayOfString1 != null)
        {
          bool1 = bool3;
          if (arrayOfString2.length == 3)
          {
            bool1 = bool3;
            if (arrayOfString3.length == 3)
            {
              j = Integer.parseInt(arrayOfString2[0]);
              int i3 = Integer.parseInt(arrayOfString2[1]);
              int i4 = Integer.parseInt(arrayOfString2[2]);
              int k = Integer.parseInt(arrayOfString1[0]);
              int m = Integer.parseInt(arrayOfString1[1]);
              if (arrayOfString1.length != 3) {
                break label354;
              }
              i = Integer.parseInt(arrayOfString1[2]);
              label218:
              int n = Integer.parseInt(arrayOfString3[0]);
              int i1 = Integer.parseInt(arrayOfString3[1]);
              int i2 = Integer.parseInt(arrayOfString3[2]);
              if ((k <= j) && ((k != j) || (m <= i3)) && ((j != k) || (i3 != m) || (i < i4))) {
                break label360;
              }
              j = 1;
              label287:
              if ((k >= n) && ((k != n) || (m >= i1)) && ((n != k) || (i1 != m) || (i > i2))) {
                break label366;
              }
              i = 1;
              label332:
              if ((j == 0) || (i == 0)) {
                break label372;
              }
            }
          }
        }
      }
      label354:
      label360:
      label366:
      label372:
      for (bool1 = bool2;; bool1 = false)
      {
        return bool1;
        arrayOfString1 = null;
        break;
        i = 0;
        break label218;
        j = 0;
        break label287;
        i = 0;
        break label332;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int b()
  {
    int i = Camera.getNumberOfCameras();
    if ((CameraAttrs.a().jdField_d_of_type_Boolean) || (CameraAttrs.a().f))
    {
      QLog.w("Q.camera.CameraWrapper", 2, "[getNumberOfCameras] readCamNumWrong || cannotOpenFrontCam");
      i = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraWrapper", 2, "[getNumberOfCameras] return = " + i);
    }
    return i;
  }
  
  public boolean b()
  {
    return CameraAttrs.a().s;
  }
  
  public boolean c()
  {
    return CameraAttrs.a().r;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public boolean e()
  {
    return CameraAttrs.a().c;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\adapter\CameraWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */