package com.tencent.mobileqq.camera;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.camera.ex.CameraDisabledException;
import com.tencent.mobileqq.camera.utils.ApiHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import qxo;
import qxr;

public class CameraManagerImpl
  implements CameraManager
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.CameraManagerImpl";
  private static final int jdField_b_of_type_Int = 2;
  private static final int c = 3;
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 101;
  private static final int g = 102;
  private static final int h = 103;
  private static final int i = 104;
  private static final int j = 105;
  private static final int k = 106;
  private static final int l = 107;
  private static final int m = 108;
  private static final int n = 201;
  private static final int o = 202;
  private static final int p = 203;
  private static final int q = 301;
  private static final int r = 302;
  private static final int s = 303;
  private static final int t = 304;
  private static final int u = 461;
  private static final int v = 462;
  private static final int w = 463;
  private static final int x = 464;
  private static final int y = 501;
  private static final int z = 502;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private IOException jdField_a_of_type_JavaIoIOException;
  private qxo jdField_a_of_type_Qxo;
  private boolean jdField_a_of_type_Boolean;
  private Camera.Parameters jdField_b_of_type_AndroidHardwareCamera$Parameters;
  
  CameraManagerImpl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Qxo == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("CameraThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_Qxo = new qxo(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  private static void a(Activity paramActivity)
  {
    if ((ApiHelper.h) && (((DevicePolicyManager)paramActivity.getSystemService("device_policy")).getCameraDisabled(null))) {
      throw new CameraDisabledException();
    }
  }
  
  public CameraManager.CameraProxy a(Handler paramHandler, int paramInt, CameraManager.CameraOpenErrorCallback paramCameraOpenErrorCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraManagerImpl", 2, "[cameraOpen] + ENTER cameraId = " + paramInt);
    }
    this.jdField_a_of_type_Qxo.obtainMessage(1, paramInt, 0, qxr.a(paramHandler, paramCameraOpenErrorCallback)).sendToTarget();
    this.jdField_a_of_type_Qxo.a();
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      return new CameraManagerImpl.CameraProxyImpl(this, null);
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\CameraManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */