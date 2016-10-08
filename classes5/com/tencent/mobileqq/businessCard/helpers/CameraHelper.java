package com.tencent.mobileqq.businessCard.helpers;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qwu;
import qwv;
import qww;

public class CameraHelper
{
  static CameraHelper jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper;
  public static String a;
  int jdField_a_of_type_Int = 0;
  Camera.AutoFocusCallback jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new qwv(this);
  public Camera a;
  qww jdField_a_of_type_Qww;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!CameraHelper.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      jdField_a_of_type_JavaLangString = "BusinessCard_" + CameraHelper.class.getSimpleName();
      return;
    }
  }
  
  public CameraHelper()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static CameraHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper == null) {
        jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper = new CameraHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper;
    }
    finally {}
  }
  
  Camera.Parameters a()
  {
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    String str2 = "continuous-video";
    String str1 = str2;
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
    {
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 14) {
        str1 = "continuous-picture";
      }
    }
    return str1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "release camera");
    }
    CameraAbility.a().a();
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    try
    {
      d();
      b();
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(null);
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(File paramFile, CameraHelper.CameraHelperCallback paramCameraHelperCallback, Rect paramRect)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "camera is null");
      }
    }
    do
    {
      return;
      Rect localRect = new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, null, new qwu(this, paramFile, localRect, paramRect, paramCameraHelperCallback));
        return;
      }
      catch (RuntimeException paramFile) {}
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, null, paramFile);
  }
  
  public boolean a()
  {
    if (!CameraAbility.a()) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "openCamera failed hasCameras=false");
      }
    }
    for (;;)
    {
      return false;
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
        if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
          continue;
        }
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidHardwareCamera != null)
          {
            this.jdField_a_of_type_AndroidHardwareCamera.release();
            this.jdField_a_of_type_AndroidHardwareCamera = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "openCamera failed " + localException.toString());
          }
        }
      }
    }
  }
  
  public boolean a(Camera.Parameters paramParameters)
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (paramParameters == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters) {}
    return false;
  }
  
  public boolean a(SurfaceHolder paramSurfaceHolder)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramSurfaceHolder == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[@] startPreview[failed] mCamera=" + this.jdField_a_of_type_AndroidHardwareCamera + " holder=" + paramSurfaceHolder);
      }
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
      return true;
    }
    catch (Exception paramSurfaceHolder)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramSurfaceHolder.getMessage());
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    boolean bool1;
    if (!d()) {
      bool1 = bool2;
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          try
          {
            this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
            Camera.Parameters localParameters = a();
            bool1 = bool2;
            if (localParameters != null)
            {
              String str = localParameters.getFocusMode();
              if ((str != null) && (str.equals(paramString))) {
                return true;
              }
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i(jdField_a_of_type_JavaLangString, 2, "", localRuntimeException);
              }
            }
            bool1 = bool2;
          }
        }
      } while (!CameraAbility.a().a(paramString));
      localRuntimeException.setFocusMode(paramString);
      bool2 = a(localRuntimeException);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "[@] setParamsFocusMode isSupportFocus=true  success=" + bool2);
    return bool2;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initCamera");
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      if (Build.VERSION.SDK_INT <= 10) {
        b();
      }
    }
    for (;;)
    {
      Object localObject3;
      int i;
      try
      {
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        localObject3 = localParameters.getSupportedPictureSizes();
        Object localObject4 = localParameters.getSupportedPreviewSizes();
        float f2 = this.jdField_b_of_type_Int / this.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "screen w:" + this.jdField_a_of_type_Int + " h:" + this.jdField_b_of_type_Int + " ratio:" + f2);
        }
        float f1 = Float.MAX_VALUE;
        int j = this.jdField_a_of_type_Int;
        Object localObject1;
        Iterator localIterator;
        if (localObject4 != null)
        {
          localObject1 = (Camera.Size)((List)localObject4).get(0);
          i = 0;
          localIterator = ((List)localObject4).iterator();
          if (localIterator.hasNext())
          {
            localObject2 = (Camera.Size)localIterator.next();
            if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - f2) > 0.1F) {
              continue;
            }
            if (Math.abs(((Camera.Size)localObject2).height - j) >= f1) {
              break label835;
            }
            f1 = Math.abs(((Camera.Size)localObject2).height - j);
            localObject1 = localObject2;
            i = 1;
            break label835;
          }
          if (i != 0) {
            break label841;
          }
          localObject4 = ((List)localObject4).iterator();
          f1 = Float.MAX_VALUE;
          localObject2 = localObject1;
          if (((Iterator)localObject4).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject4).next();
            if (Math.abs(((Camera.Size)localObject2).height - j) >= f1) {
              break label832;
            }
            f1 = Math.abs(((Camera.Size)localObject2).height - j);
            localObject1 = localObject2;
            break label838;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "initCamera customPreviewSize width=" + ((Camera.Size)localObject2).width + " height=" + ((Camera.Size)localObject2).height);
          localParameters.setPreviewSize(((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height);
        }
        localObject4 = new ArrayList();
        if (localObject3 != null)
        {
          i = 0;
          if (i < ((List)localObject3).size())
          {
            localObject1 = (Camera.Size)((List)localObject3).get(i);
            if (Math.abs(((Camera.Size)localObject1).width / ((Camera.Size)localObject1).height - f2) > 0.1F) {
              break label847;
            }
            ((List)localObject4).add(localObject1);
            break label847;
          }
          if (((List)localObject4).isEmpty())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "expectList is empty~~");
            }
            localObject1 = (Camera.Size)((List)localObject3).get(0);
            f1 = Float.MAX_VALUE;
            localObject4 = ((List)localObject3).iterator();
            localObject3 = localObject1;
            if (((Iterator)localObject4).hasNext())
            {
              localObject2 = (Camera.Size)((Iterator)localObject4).next();
              if (Math.abs(((Camera.Size)localObject2).height - j) >= f1) {
                break label829;
              }
              f1 = Math.abs(((Camera.Size)localObject2).height - j);
              localObject1 = localObject2;
              break label856;
            }
          }
          else
          {
            localObject1 = (Camera.Size)((List)localObject4).get(0);
            localObject2 = (Camera.Size)((List)localObject4).get(0);
            f1 = Float.MAX_VALUE;
            localIterator = ((List)localObject4).iterator();
            if (localIterator.hasNext())
            {
              localObject4 = (Camera.Size)localIterator.next();
              localObject3 = localObject2;
              if (((Camera.Size)localObject2).width < ((Camera.Size)localObject4).width) {
                localObject3 = localObject4;
              }
              if ((((Camera.Size)localObject4).height < 1020) || (((Camera.Size)localObject4).height - 1020 >= f1)) {
                break label826;
              }
              f1 = ((Camera.Size)localObject4).height - 920;
              localObject1 = localObject4;
              break label859;
            }
            localObject3 = localObject1;
            if (((Camera.Size)localObject1).height < 1020) {
              localObject3 = localObject2;
            }
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "initCamera customPictureSize width=" + ((Camera.Size)localObject3).width + " height=" + ((Camera.Size)localObject3).height);
          localParameters.setPictureSize(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(90);
          localParameters.setFocusMode("auto");
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "setParameters exception", localException);
        return;
      }
      label826:
      break label859;
      label829:
      break label856;
      label832:
      break label838;
      label835:
      continue;
      label838:
      continue;
      label841:
      Object localObject2 = localException;
      continue;
      label847:
      i += 1;
      continue;
      label856:
      continue;
      label859:
      localObject2 = localObject3;
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/tencent/mobileqq/businessCard/helpers/CameraHelper:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 52	com/tencent/mobileqq/businessCard/helpers/CameraHelper:jdField_a_of_type_Boolean	Z
    //   14: aload_0
    //   15: invokevirtual 205	com/tencent/mobileqq/businessCard/helpers/CameraHelper:d	()Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +10 -> 30
    //   23: aload_0
    //   24: getfield 72	com/tencent/mobileqq/businessCard/helpers/CameraHelper:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   27: invokevirtual 208	android/hardware/Camera:cancelAutoFocus	()V
    //   30: aload_0
    //   31: getfield 72	com/tencent/mobileqq/businessCard/helpers/CameraHelper:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   34: invokevirtual 333	android/hardware/Camera:stopPreview	()V
    //   37: aload_0
    //   38: getfield 72	com/tencent/mobileqq/businessCard/helpers/CameraHelper:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   41: aconst_null
    //   42: invokevirtual 191	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   45: aload_0
    //   46: getfield 72	com/tencent/mobileqq/businessCard/helpers/CameraHelper:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   49: aconst_null
    //   50: invokevirtual 129	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   53: iconst_1
    //   54: ireturn
    //   55: astore_1
    //   56: iconst_0
    //   57: ireturn
    //   58: astore_1
    //   59: goto -29 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	CameraHelper
    //   55	1	1	localIOException	java.io.IOException
    //   58	1	1	localRuntimeException	RuntimeException
    //   18	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	19	55	java/io/IOException
    //   23	30	55	java/io/IOException
    //   30	53	55	java/io/IOException
    //   23	30	58	java/lang/RuntimeException
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Qww != null) && (this.jdField_a_of_type_Qww.isAlive())) {
      this.jdField_a_of_type_Qww.interrupt();
    }
    this.jdField_a_of_type_Qww = new qww(this);
    this.jdField_a_of_type_Qww.start();
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!this.jdField_a_of_type_Boolean) || (!d())) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Qww != null) && (this.jdField_a_of_type_Qww.isAlive()))
    {
      this.jdField_a_of_type_Qww.interrupt();
      this.jdField_a_of_type_Qww = null;
    }
  }
  
  boolean d()
  {
    return !CameraCompatibleList.d(CameraCompatibleList.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\helpers\CameraHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */