package com.tencent.mobileqq.ar;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.hiar.sdk.camera.CameraParameters;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qor;
import qot;
import qou;
import qov;
import qow;

public class ARGLSurfaceView
  extends GLSurfaceView
  implements Camera.AutoFocusCallback
{
  private static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 3000L;
  private static final String jdField_a_of_type_JavaLangString = "ARGLSurfaceView";
  private static final int b = 200;
  private static final int c = 400;
  public Camera a;
  Handler jdField_a_of_type_AndroidOsHandler;
  public ARNativeBridge a;
  ARRender jdField_a_of_type_ComTencentMobileqqArARRender;
  public boolean a;
  
  public ARGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new qor(this);
    e();
  }
  
  public ARGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new qor(this);
    e();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private Rect a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = Float.valueOf(paramFloat3 * paramFloat4).intValue();
    int k = getWidth();
    int j = getHeight();
    k = (int)-(paramFloat1 / k * 2000.0F - 1000.0F);
    j = a((int)(paramFloat2 / j * 2000.0F - 1000.0F) - i / 2, 64536, 1000);
    k = a(k - i / 2, 64536, 1000);
    RectF localRectF = new RectF(j, k, Math.min(j + i, 1000), Math.min(i + k, 1000));
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = new ARNativeBridge();
    setEGLContextFactory(new qot(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGLSurfaceView", 2, "onGlDestoryContext");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRender.b();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
    for (;;)
    {
      return;
      if (a()) {
        try
        {
          Camera.Parameters localParameters1 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
          if (localParameters1.getSupportedFocusModes().contains("auto"))
          {
            Object localObject = a(paramFloat1, paramFloat2, paramFloat3, 1.0F);
            Rect localRect = a(paramFloat1, paramFloat2, paramFloat3, 1.2F);
            localParameters1.setFocusMode("auto");
            if (localParameters1.getMaxNumFocusAreas() > 0)
            {
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(new Camera.Area((Rect)localObject, 600));
              localParameters1.setFocusAreas(localArrayList);
            }
            if (localParameters1.getMaxNumMeteringAreas() > 0)
            {
              localObject = new ArrayList();
              ((List)localObject).add(new Camera.Area(localRect, 600));
              localParameters1.setMeteringAreas((List)localObject);
            }
            this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
            this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters1);
            this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this);
            return;
          }
        }
        catch (Exception localException)
        {
          try
          {
            this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
            Camera.Parameters localParameters2 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
            CameraParameters.a(localParameters2);
            this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters2);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
          }
        }
      }
    }
  }
  
  boolean a()
  {
    return !CameraCompatibleList.d(CameraCompatibleList.a);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {}
    try
    {
      if (a()) {
        this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      }
      this.jdField_a_of_type_AndroidHardwareCamera = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    f();
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGLSurfaceView", 2, "onAutoFocus. success = " + paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      Camera.Parameters localParameters = paramCamera.getParameters();
      CameraParameters.a(localParameters);
      paramCamera.setParameters(localParameters);
      return;
    }
    catch (RuntimeException paramCamera)
    {
      paramCamera.printStackTrace();
    }
  }
  
  public void onPause()
  {
    queueEvent(new qow(this));
    if (this.jdField_a_of_type_ComTencentMobileqqArARRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRender.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    queueEvent(new qov(this));
    if (this.jdField_a_of_type_ComTencentMobileqqArARRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRender.c();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat1 = new float[j];
    float[] arrayOfFloat2 = new float[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramMotionEvent.getPointerId(i);
      arrayOfFloat1[i] = paramMotionEvent.getX(i);
      arrayOfFloat2[i] = paramMotionEvent.getY(i);
      i += 1;
    }
    ThreadManager.a(new qou(this, paramMotionEvent), 8, null, true);
    return true;
  }
  
  public void setARRender(ARRender paramARRender)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRender = paramARRender;
    setRenderer(paramARRender);
  }
  
  public void setCamera(Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    this.jdField_a_of_type_Boolean = false;
    f();
  }
  
  @Deprecated
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    super.setRenderer(paramRenderer);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */