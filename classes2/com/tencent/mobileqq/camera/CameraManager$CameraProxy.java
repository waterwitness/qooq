package com.tencent.mobileqq.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.view.SurfaceHolder;

public abstract interface CameraManager$CameraProxy
{
  public abstract Camera.Parameters a();
  
  public abstract Camera a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture);
  
  public abstract void a(Camera.ErrorCallback paramErrorCallback);
  
  public abstract void a(Camera.OnZoomChangeListener paramOnZoomChangeListener);
  
  public abstract void a(Camera.Parameters paramParameters);
  
  public abstract void a(Handler paramHandler, CameraManager.CameraAFCallback paramCameraAFCallback);
  
  public abstract void a(Handler paramHandler, CameraManager.CameraAFMoveCallback paramCameraAFMoveCallback);
  
  public abstract void a(Handler paramHandler, CameraManager.CameraFaceDetectionCallback paramCameraFaceDetectionCallback);
  
  public abstract void a(Handler paramHandler, CameraManager.CameraPreviewDataCallback paramCameraPreviewDataCallback);
  
  public abstract void a(Handler paramHandler, CameraManager.CameraShutterCallback paramCameraShutterCallback, CameraManager.CameraPictureCallback paramCameraPictureCallback1, CameraManager.CameraPictureCallback paramCameraPictureCallback2, CameraManager.CameraPictureCallback paramCameraPictureCallback3);
  
  public abstract void a(SurfaceHolder paramSurfaceHolder);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract boolean a(Handler paramHandler, CameraManager.CameraOpenErrorCallback paramCameraOpenErrorCallback);
  
  public abstract void b();
  
  public abstract void b(Handler paramHandler, CameraManager.CameraPreviewDataCallback paramCameraPreviewDataCallback);
  
  public abstract void b(SurfaceHolder paramSurfaceHolder);
  
  public abstract void c();
  
  public abstract void c(Handler paramHandler, CameraManager.CameraPreviewDataCallback paramCameraPreviewDataCallback);
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\CameraManager$CameraProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */