package com.tencent.mobileqq.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import qxk;
import qxm;
import qxo;
import qxr;
import qxv;
import qxx;
import qxz;
import qyb;

public class CameraManagerImpl$CameraProxyImpl
  implements CameraManager.CameraProxy
{
  private final String jdField_a_of_type_JavaLangString;
  
  private CameraManagerImpl$CameraProxyImpl(CameraManagerImpl paramCameraManagerImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "Q.camera.CameraProxyImpl";
    if (CameraManagerImpl.a(paramCameraManagerImpl) != null) {}
    for (bool = true;; bool = false)
    {
      CameraUtils.a(bool);
      return;
    }
  }
  
  public Camera.Parameters a()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(202);
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).a();
    return CameraManagerImpl.b(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl);
  }
  
  public Camera a()
  {
    return CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraProxyImpl", 2, "[release] ENTER");
    }
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(2);
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraProxyImpl", 2, "[release] END");
    }
  }
  
  public void a(int paramInt)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(502, paramInt, 0).sendToTarget();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(101, paramSurfaceTexture).sendToTarget();
  }
  
  public void a(Camera.ErrorCallback paramErrorCallback)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(464, paramErrorCallback).sendToTarget();
  }
  
  public void a(Camera.OnZoomChangeListener paramOnZoomChangeListener)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(304, paramOnZoomChangeListener).sendToTarget();
  }
  
  public void a(Camera.Parameters paramParameters)
  {
    if (paramParameters == null)
    {
      QLog.d("Q.camera.CameraProxyImpl", 2, "null parameters in setParameters()");
      return;
    }
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(201, paramParameters.flatten()).sendToTarget();
  }
  
  public void a(Handler paramHandler, CameraManager.CameraAFCallback paramCameraAFCallback)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(301, qxk.a(paramHandler, this, paramCameraAFCallback)).sendToTarget();
  }
  
  public void a(Handler paramHandler, CameraManager.CameraAFMoveCallback paramCameraAFMoveCallback)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(303, qxm.a(paramHandler, this, paramCameraAFMoveCallback)).sendToTarget();
  }
  
  public void a(Handler paramHandler, CameraManager.CameraFaceDetectionCallback paramCameraFaceDetectionCallback)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(461, qxv.a(paramHandler, this, paramCameraFaceDetectionCallback)).sendToTarget();
  }
  
  public void a(Handler paramHandler, CameraManager.CameraPreviewDataCallback paramCameraPreviewDataCallback)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(108, qxz.a(paramHandler, this, paramCameraPreviewDataCallback)).sendToTarget();
  }
  
  public void a(Handler paramHandler, CameraManager.CameraShutterCallback paramCameraShutterCallback, CameraManager.CameraPictureCallback paramCameraPictureCallback1, CameraManager.CameraPictureCallback paramCameraPictureCallback2, CameraManager.CameraPictureCallback paramCameraPictureCallback3)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).a(qyb.a(paramHandler, this, paramCameraShutterCallback), qxx.a(paramHandler, this, paramCameraPictureCallback1), qxx.a(paramHandler, this, paramCameraPictureCallback2), qxx.a(paramHandler, this, paramCameraPictureCallback3));
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(106, paramSurfaceHolder).sendToTarget();
  }
  
  public void a(boolean paramBoolean)
  {
    qxo localqxo = CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqxo.obtainMessage(501, i, 0).sendToTarget();
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(105, paramArrayOfByte).sendToTarget();
  }
  
  public boolean a(Handler paramHandler, CameraManager.CameraOpenErrorCallback paramCameraOpenErrorCallback)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(3);
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).a();
    paramHandler = qxr.a(paramHandler, paramCameraOpenErrorCallback);
    if (CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl) != null)
    {
      if (paramHandler != null) {
        paramHandler.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl);
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(4);
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).a();
  }
  
  public void b(Handler paramHandler, CameraManager.CameraPreviewDataCallback paramCameraPreviewDataCallback)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(107, qxz.a(paramHandler, this, paramCameraPreviewDataCallback)).sendToTarget();
  }
  
  public void b(SurfaceHolder paramSurfaceHolder)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(106, paramSurfaceHolder).sendToTarget();
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).a();
  }
  
  public void c()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(5);
  }
  
  public void c(Handler paramHandler, CameraManager.CameraPreviewDataCallback paramCameraPreviewDataCallback)
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).obtainMessage(104, qxz.a(paramHandler, this, paramCameraPreviewDataCallback)).sendToTarget();
  }
  
  public void d()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(102);
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).a();
  }
  
  public void e()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(103);
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).a();
  }
  
  public void f()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).removeMessages(301);
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(302);
  }
  
  public void g()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(462);
  }
  
  public void h()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(463);
  }
  
  public void i()
  {
    CameraManagerImpl.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraManagerImpl).sendEmptyMessage(203);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\CameraManagerImpl$CameraProxyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */