package com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.util.Log;
import android.view.Surface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class OutputSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  static final int jdField_a_of_type_Int = 4;
  static final String jdField_a_of_type_JavaLangString = "OutputSurface";
  static final boolean jdField_a_of_type_Boolean = false;
  SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  public Surface a;
  TextureRender jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterTextureRender;
  Object jdField_a_of_type_JavaLangObject;
  EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  boolean b;
  
  public OutputSurface()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    a();
  }
  
  public OutputSurface(int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    a(paramInt1, paramInt2);
    c();
    a();
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterTextureRender = new TextureRender();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterTextureRender.a();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterTextureRender.a());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, null)) {
      throw new RuntimeException("unable to initialize EGL10");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglChooseConfig(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12339, 1, 12352, 4, 12344 }, arrayOfEGLConfig, 1, arrayOfInt)) {
      throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
    }
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, arrayOfEGLConfig[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    b("eglCreateContext");
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext == null) {
      throw new RuntimeException("null context");
    }
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreatePbufferSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, arrayOfEGLConfig[0], new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    b("eglCreatePbufferSurface");
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterTextureRender.a(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 != null)
    {
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentContext().equals(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)) {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    }
    this.jdField_a_of_type_AndroidViewSurface.release();
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = null;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterTextureRender = null;
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  void b(String paramString)
  {
    for (int i = 0;; i = 1)
    {
      int j = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError();
      if (j == 12288) {
        break;
      }
      Log.e("OutputSurface", paramString + ": EGL error: 0x" + Integer.toHexString(j));
    }
    if (i != 0) {
      throw new RuntimeException("EGL error encountered (see log)");
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 == null) {
      throw new RuntimeException("not configured for makeCurrent");
    }
    b("before makeCurrent");
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        boolean bool = this.b;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait(5000L);
            if (!this.b) {
              throw new RuntimeException("Surface frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
    }
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterTextureRender.b("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterTextureRender.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.b) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.b = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\videoconverter\OutputSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */