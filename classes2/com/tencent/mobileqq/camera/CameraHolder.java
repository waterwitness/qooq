package com.tencent.mobileqq.camera;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CameraHolder
{
  private static CameraHolder jdField_a_of_type_ComTencentMobileqqCameraCameraHolder;
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.CameraHolder";
  private static CameraManager.CameraProxy[] jdField_a_of_type_ArrayOfComTencentMobileqqCameraCameraManager$CameraProxy;
  private static Camera.CameraInfo[] jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  private final int jdField_a_of_type_Int;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  private CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  private CameraWrapper jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper;
  private boolean jdField_a_of_type_Boolean;
  private final Camera.CameraInfo[] jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  
  private CameraHolder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
    this.d = -1;
    this.jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper = CameraWrapper.a();
    int i;
    if (jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo != null)
    {
      this.jdField_a_of_type_Int = jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo.length;
      this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
      i = k;
      if (i >= this.jdField_a_of_type_Int) {
        return;
      }
      if ((this.c != -1) || (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[i].facing != 0)) {
        break label191;
      }
      this.c = i;
    }
    for (;;)
    {
      i += 1;
      break;
      this.jdField_a_of_type_Int = a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraHolder", 1, "[CameraHolder] mNumberOfCameras = " + this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = new Camera.CameraInfo[this.jdField_a_of_type_Int];
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= this.jdField_a_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[j] = new Camera.CameraInfo();
        Camera.getCameraInfo(j, this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[j]);
        j += 1;
      }
      label191:
      if ((this.d == -1) && (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[i].facing == 1)) {
        this.d = i;
      }
    }
  }
  
  /* Error */
  public static CameraHolder a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 91	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraHolder	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 91	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraHolder	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/mobileqq/camera/CameraHolder
    //   21: dup
    //   22: invokespecial 92	com/tencent/mobileqq/camera/CameraHolder:<init>	()V
    //   25: putstatic 91	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraHolder	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 91	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraHolder	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localCameraHolder	CameraHolder
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private static void a(Camera.CameraInfo[] paramArrayOfCameraInfo, CameraManager.CameraProxy[] paramArrayOfCameraProxy)
  {
    jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = paramArrayOfCameraInfo;
    jdField_a_of_type_ArrayOfComTencentMobileqqCameraCameraManager$CameraProxy = paramArrayOfCameraProxy;
  }
  
  public int a()
  {
    return CameraWrapper.a().b();
  }
  
  public CameraManager.CameraProxy a(Handler paramHandler, int paramInt, CameraManager.CameraOpenErrorCallback paramCameraOpenErrorCallback)
  {
    Object localObject = null;
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          CameraUtils.a(bool);
          if ((this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null) && (this.jdField_b_of_type_Int != paramInt))
          {
            this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a();
            this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = null;
            this.jdField_b_of_type_Int = -1;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null) {
            break label295;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.CameraHolder", 1, "invoke open camera " + paramInt);
          }
          if (jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = CameraManagerFactory.a().a(paramHandler, paramInt, paramCameraOpenErrorCallback);
            if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null) {
              break;
            }
            QLog.e("Q.camera.CameraHolder", 1, "fail to connect Camera:" + paramInt + ", aborting.");
            paramHandler = (Handler)localObject;
            return paramHandler;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        if (jdField_a_of_type_ArrayOfComTencentMobileqqCameraCameraManager$CameraProxy != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = jdField_a_of_type_ArrayOfComTencentMobileqqCameraCameraManager$CameraProxy[paramInt];
          continue;
        }
        QLog.e("Q.camera.CameraHolder", 1, "MockCameraInfo found, but no MockCamera provided.");
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = null;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidHardwareCamera$Parameters = this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a();
    if (QLog.isColorLevel())
    {
      QLog.d("Q.camera.CameraHolder", 1, "open camera mCameraId " + this.jdField_b_of_type_Int);
      QLog.d("Q.camera.CameraHolder", 1, "open camera mParameters " + this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      paramHandler = this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
      break;
      label295:
      if (!this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(paramHandler, paramCameraOpenErrorCallback))
      {
        QLog.e("Q.camera.CameraHolder", 1, "fail to reconnect Camera:" + this.jdField_b_of_type_Int + ", aborting.");
        paramHandler = (Handler)localObject;
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    }
  }
  
  public CameraWrapper a()
  {
    return CameraWrapper.a();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy	Lcom/tencent/mobileqq/camera/CameraManager$CameraProxy;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 100	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_Boolean	Z
    //   18: ifeq +17 -> 35
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 100	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_Boolean	Z
    //   26: aload_0
    //   27: getfield 107	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy	Lcom/tencent/mobileqq/camera/CameraManager$CameraProxy;
    //   30: invokeinterface 153 1 0
    //   35: aload_0
    //   36: invokevirtual 155	com/tencent/mobileqq/camera/CameraHolder:b	()V
    //   39: goto -28 -> 11
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	CameraHolder
    //   6	2	1	localCameraProxy	CameraManager.CameraProxy
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	42	finally
    //   14	35	42	finally
    //   35	39	42	finally
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int == this.d;
  }
  
  public Camera.CameraInfo[] a()
  {
    return this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  }
  
  public int b()
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo != null)
    {
      Camera.CameraInfo localCameraInfo = this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[this.jdField_b_of_type_Int];
      i = j;
      if (localCameraInfo != null) {
        i = localCameraInfo.facing;
      }
    }
    return i;
  }
  
  /* Error */
  public CameraManager.CameraProxy b(Handler paramHandler, int paramInt, CameraManager.CameraOpenErrorCallback paramCameraOpenErrorCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 100	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_Boolean	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: aload_1
    //   11: iload_2
    //   12: aload_3
    //   13: invokevirtual 157	com/tencent/mobileqq/camera/CameraHolder:a	(Landroid/os/Handler;ILcom/tencent/mobileqq/camera/CameraManager$CameraOpenErrorCallback;)Lcom/tencent/mobileqq/camera/CameraManager$CameraProxy;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	CameraHolder
    //   0	31	1	paramHandler	Handler
    //   0	31	2	paramInt	int
    //   0	31	3	paramCameraOpenErrorCallback	CameraManager.CameraOpenErrorCallback
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy	Lcom/tencent/mobileqq/camera/CameraManager$CameraProxy;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 100	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_Boolean	Z
    //   19: aload_0
    //   20: getfield 107	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy	Lcom/tencent/mobileqq/camera/CameraManager$CameraProxy;
    //   23: invokeinterface 111 1 0
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 107	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy	Lcom/tencent/mobileqq/camera/CameraManager$CameraProxy;
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 136	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_AndroidHardwareCamera$Parameters	Landroid/hardware/Camera$Parameters;
    //   38: aload_0
    //   39: iconst_m1
    //   40: putfield 30	com/tencent/mobileqq/camera/CameraHolder:jdField_b_of_type_Int	I
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 41	com/tencent/mobileqq/camera/CameraHolder:jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper	Lcom/tencent/mobileqq/camera/adapter/CameraWrapper;
    //   48: goto -37 -> 11
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	CameraHolder
    //   6	2	1	localCameraProxy	CameraManager.CameraProxy
    //   51	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	51	finally
    //   14	48	51	finally
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\CameraHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */