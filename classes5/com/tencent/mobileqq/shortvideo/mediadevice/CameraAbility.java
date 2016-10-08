package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Iterator;
import java.util.List;

public class CameraAbility
{
  private static final int jdField_a_of_type_Int = -1;
  private static CameraAbility jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility;
  public static final String a;
  private static int b;
  private static int c;
  private static int d;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  
  static
  {
    int i = 0;
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!CameraAbility.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaLangString = CameraAbility.class.getSimpleName();
      c = -1;
      d = -1;
      for (;;)
      {
        try
        {
          if (!VersionUtils.c()) {
            break label123;
          }
          b = Camera.getNumberOfCameras();
          if (i < b)
          {
            Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, localCameraInfo);
            if (localCameraInfo == null) {
              break label128;
            }
            if (localCameraInfo.facing == 0) {
              c = i;
            } else if (1 == localCameraInfo.facing) {
              d = i;
            }
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "", localRuntimeException);
          }
          b = 1;
        }
        return;
        label123:
        b = 1;
        return;
        label128:
        i += 1;
      }
    }
  }
  
  public static int a()
  {
    return d;
  }
  
  public static CameraAbility a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility = new CameraAbility();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraAbility;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return b > 0;
  }
  
  public static int b()
  {
    return c;
  }
  
  public static boolean b()
  {
    return (a()) && (c != -1);
  }
  
  public static boolean c()
  {
    return (a()) && (d != -1);
  }
  
  public List a()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList1 = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewSizes();
      if ((localList1 != null) && (QLog.isColorLevel()))
      {
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext())
        {
          Camera.Size localSize = (Camera.Size)localIterator.next();
          if (localSize != null) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[@] getPreviewSizes:w=" + localSize.width + ",h=" + localSize.height);
          }
        }
      }
    }
    catch (Exception localException)
    {
      List localList2;
      for (;;)
      {
        localException.printStackTrace();
        localList2 = null;
      }
      return localList2;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
  }
  
  public boolean a(int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFormats();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(Integer.valueOf(paramInt));
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(Camera paramCamera)
  {
    a();
    if (paramCamera == null) {}
    for (;;)
    {
      return false;
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters = paramCamera.getParameters();
        if (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null) {
          continue;
        }
        return true;
      }
      catch (Exception paramCamera)
      {
        for (;;)
        {
          paramCamera.printStackTrace();
          this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFocusModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(paramString);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public List b()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList1 = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPictureSizes();
      if ((localList1 != null) && (QLog.isColorLevel()))
      {
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext())
        {
          Camera.Size localSize = (Camera.Size)localIterator.next();
          if (localSize != null) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[@] getPictureSizes:w=" + localSize.width + ",h=" + localSize.height);
          }
        }
      }
    }
    catch (Exception localException)
    {
      List localList2;
      for (;;)
      {
        localException.printStackTrace();
        localList2 = null;
      }
      return localList2;
    }
  }
  
  public List c()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFpsRange();
      return localList;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean d()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.isZoomSupported();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean e()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFlashModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains("torch");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CameraAbility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */