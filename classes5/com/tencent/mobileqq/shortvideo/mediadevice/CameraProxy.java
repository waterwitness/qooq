package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.Observer;
import java.io.File;
import urb;
import urc;
import urd;
import ure;
import urf;
import urg;
import urh;
import uri;
import urj;
import urk;
import url;
import urm;
import urn;
import uro;
import urp;
import urq;
import urt;

public class CameraProxy
{
  public static HandlerThread a;
  public static DispatchThread a;
  static final String jdField_a_of_type_JavaLangString = "CameraProxy";
  public static final int d = 3500;
  public volatile int a;
  Context jdField_a_of_type_AndroidContentContext;
  public CameraExceptionHandler a;
  public final CameraProxy.CameraPreviewObservable a;
  public CameraProxy.ParamCache a;
  public final urq a;
  public boolean a;
  public int b;
  public CameraProxy.ParamCache b;
  public int c;
  public CameraProxy.ParamCache c;
  public CameraProxy.ParamCache d;
  public CameraProxy.ParamCache e;
  public CameraProxy.ParamCache f;
  public CameraProxy.ParamCache g;
  
  public CameraProxy(Context paramContext, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
    this.b = new CameraProxy.ParamCache();
    this.c = new CameraProxy.ParamCache();
    this.d = new CameraProxy.ParamCache();
    this.e = new CameraProxy.ParamCache();
    this.f = new CameraProxy.ParamCache();
    this.g = new CameraProxy.ParamCache();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Camera2 Handler Thread");
      jdField_a_of_type_AndroidOsHandlerThread.start();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable = new CameraProxy.CameraPreviewObservable(paramHandler);
    this.jdField_a_of_type_Urq = new urq(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread == null)
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread = new DispatchThread(jdField_a_of_type_AndroidOsHandlerThread);
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.start();
    }
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urb(this));
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new uri(this, paramInt2, paramInt3, paramInt1));
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void a(Rect paramRect)
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new ure(this, paramRect));
      return;
    }
    catch (RuntimeException paramRect)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramRect);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urm(this, paramSurfaceTexture));
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceTexture);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    a(paramSurfaceTexture);
    a(paramPreviewCallback, paramBoolean);
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urp(this));
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceTexture);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null)
    {
      a(paramSurfaceTexture, paramPreviewCallback, paramBoolean);
      return;
    }
    a(paramSurfaceHolder, paramPreviewCallback, paramBoolean);
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new uro(this, paramBoolean, paramPreviewCallback));
      return;
    }
    catch (RuntimeException paramPreviewCallback)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramPreviewCallback);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urn(this, paramSurfaceHolder));
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceHolder);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    a(paramSurfaceHolder);
    a(paramPreviewCallback, paramBoolean);
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urc(this));
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceHolder);
    }
  }
  
  public void a(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(paramObserver, new int[] { 1, 2, 3, 4, 6, 7, 10, 11, 12 });
  }
  
  public void a(CameraExceptionHandler paramCameraExceptionHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler = paramCameraExceptionHandler;
  }
  
  public void a(File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt)
  {
    urt localurt = new urt(this, null);
    localurt.jdField_a_of_type_JavaIoFile = paramFile;
    localurt.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    localurt.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback = paramPictureCallback;
    localurt.jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urh(this, localurt));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urk(this));
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraProxy.WaitDoneBundle localWaitDoneBundle;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
    localWaitDoneBundle = new CameraProxy.WaitDoneBundle();
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new url(this, localWaitDoneBundle), localWaitDoneBundle.a, 3500L, "release camera");
    return;
  }
  
  public void b()
  {
    try
    {
      CameraProxy.WaitDoneBundle localWaitDoneBundle = new CameraProxy.WaitDoneBundle();
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urj(this, localWaitDoneBundle), localWaitDoneBundle.a, 3500L, "stop preview");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urg(this, paramBoolean));
  }
  
  public void c()
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urd(this));
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void d()
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceDispatchThread.a(new urf(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CameraProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */