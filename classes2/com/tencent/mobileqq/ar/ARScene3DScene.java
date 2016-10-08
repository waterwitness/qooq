package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.hiar.sdk.HSARToolkit;
import com.hiar.sdk.renderer.HSRenderer;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import qpd;
import qpe;

public class ARScene3DScene
  extends ARScene
{
  public static final String a = "ClipBeforeFire";
  public static final long b = 1500L;
  public static final String b = "ClipAfterFire";
  public static final int c = 1;
  public static final String c = "ClipIdle2";
  public static final int d = 2;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public HSRenderer a;
  public ARMusicController a;
  public ARTarget a;
  public boolean a;
  public long c;
  public long d;
  public int k;
  
  public ARScene3DScene(ARGLSurfaceView paramARGLSurfaceView, HSRenderer paramHSRenderer, ARTarget paramARTarget)
  {
    super(paramARGLSurfaceView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = 1;
    this.jdField_a_of_type_ComHiarSdkRendererHSRenderer = paramHSRenderer;
    this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "setupSceneDelayed");
    }
    a(new qpd(this));
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.b))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.b);
      if (this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_a_of_type_Boolean) {
        a(this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.d, this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.jdField_a_of_type_Long);
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "setupSceneDelayed span = " + (l2 - l1));
    }
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 7: 
    default: 
    case 2: 
    case 4: 
    case 5: 
      do
      {
        return;
        super.a();
        return;
        this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARFragment.d();
        this.d = System.currentTimeMillis();
        return;
        j();
      } while (!HSARToolkit.a().b());
      a(6);
      return;
    case 6: 
      if (this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARListener != null) {
        this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARListener.b(0, this.jdField_a_of_type_ComTencentMobileqqArARTarget);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.c == 1) {
        this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARFragment.a(this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.a() == 3) {
        b("ClipBeforeFire", null);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqArARMusicController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARMusicController.a();
        return;
        b("ClipBeforeFire", "ClipIdle2");
      }
    }
    if (this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARListener != null) {
      this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARListener.b(3, this.jdField_a_of_type_ComTencentMobileqqArARTarget);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.c)) {
      b(this.jdField_a_of_type_ComTencentMobileqqArARSceneResConfig.c);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARMusicController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARMusicController.b();
    }
    b("ClipAfterFire", "ClipIdle2");
  }
  
  public void a(int paramInt, ARTarget paramARTarget)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "ARScene3DScene onARStateChanged  " + paramInt + "," + this + ", " + paramARTarget);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Boolean = false;
      if ((this.k != 1) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.c == 1)) {
        this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARFragment.e();
      }
    }
    do
    {
      return;
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.c != 1);
    this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARFragment.c();
  }
  
  public void a(String paramString, long paramLong)
  {
    a("attachEnergyBallOnNode", paramString + ":" + paramLong);
  }
  
  public boolean a()
  {
    return this.k >= 5;
  }
  
  public void b()
  {
    if (this.k != 1)
    {
      this.d = 0L;
      e();
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqArARMusicController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARMusicController.c();
        this.jdField_a_of_type_ComTencentMobileqqArARMusicController.d();
      }
      a(null);
      super.b();
      a(1);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "setupScene totalDuration = " + this.jdField_a_of_type_Long);
    }
    a(4);
  }
  
  public void f()
  {
    if (1 == this.k)
    {
      ARTarget localARTarget = this.jdField_a_of_type_ComTencentMobileqqArARTarget;
      this.jdField_a_of_type_ComTencentMobileqqArARMusicController = new ARMusicController(localARTarget.a.h, localARTarget.a.i);
      a(2);
    }
  }
  
  public void g()
  {
    switch (this.k)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) && (1500L <= System.currentTimeMillis() - this.c))
      {
        b();
        if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.c == 1) {
          this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARFragment.b();
        }
        if (this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARListener != null) {
          this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.jdField_a_of_type_ComTencentMobileqqArARListener.b(2, this.jdField_a_of_type_ComTencentMobileqqArARTarget);
        }
      }
      return;
      if (System.currentTimeMillis() - this.d > 0L)
      {
        a(5);
        continue;
        if (HSARToolkit.a().b()) {
          a(6);
        }
      }
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "ARScene3DScene onPause " + this);
    }
    a(new qpe(this));
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "ARScene3DScene onResume " + this);
    }
  }
  
  public String toString()
  {
    return "ARScene3DScene," + this.k + "," + this.jdField_a_of_type_ComTencentMobileqqArARTarget;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARScene3DScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */