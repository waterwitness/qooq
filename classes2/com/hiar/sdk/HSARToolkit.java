package com.hiar.sdk;

import android.opengl.Matrix;
import com.hiar.sdk.core.NativeInterface;
import com.hiar.sdk.renderer.HSRenderer;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARScene3DScene;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.MatrixUtil;
import com.tencent.mobileqq.ar.ReportUtil;
import com.tencent.mobileqq.ar.TraceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;

public class HSARToolkit
{
  private static HSARToolkit jdField_a_of_type_ComHiarSdkHSARToolkit;
  public int a;
  public long a;
  ARArguments jdField_a_of_type_ComTencentMobileqqArARArguments;
  public ARTarget a;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  float[] jdField_a_of_type_ArrayOfFloat;
  public int b;
  public long b;
  float[] b;
  public int c;
  public long c;
  float[] c;
  public long d;
  float[] d;
  public long e;
  float[] e;
  public long f;
  private float[] f;
  
  private HSARToolkit()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 5;
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    this.jdField_c_of_type_ArrayOfFloat = new float[16];
    this.d = new float[16];
    this.e = null;
    this.f = new float[2];
  }
  
  public static HSARToolkit a()
  {
    try
    {
      if (jdField_a_of_type_ComHiarSdkHSARToolkit == null) {
        jdField_a_of_type_ComHiarSdkHSARToolkit = new HSARToolkit();
      }
      HSARToolkit localHSARToolkit = jdField_a_of_type_ComHiarSdkHSARToolkit;
      return localHSARToolkit;
    }
    finally {}
  }
  
  public void a()
  {
    this.e = null;
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
  }
  
  public void a(ARArguments paramARArguments)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARArguments = paramARArguments;
  }
  
  public void a(ARScene3DScene paramARScene3DScene, GL10 paramGL10)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (this.e != null)
    {
      MatrixUtil.a(this.e, this.jdField_b_of_type_ArrayOfFloat);
      float f1 = this.f[1] / 23.5F;
      Matrix.rotateM(this.jdField_b_of_type_ArrayOfFloat, 0, 90.0F, 1.0F, 0.0F, 0.0F);
      Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, f1, f1, f1);
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, HSRenderer.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
      MatrixUtil.a(this.jdField_b_of_type_ArrayOfFloat, this.jdField_c_of_type_ArrayOfFloat);
      MatrixUtil.b(this.jdField_c_of_type_ArrayOfFloat, this.d);
      f1 = this.d[12];
      float f2 = this.d[13];
      float f3 = this.d[14];
      l2 = System.currentTimeMillis();
      paramARScene3DScene.a(this.jdField_a_of_type_ArrayOfFloat, new float[] { f1, f2, f3 });
      long l3 = System.currentTimeMillis();
      ReportUtil.a("modelRender", a().jdField_a_of_type_Int, l3 - l2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    long l2 = System.currentTimeMillis();
    TraceUtil.b("State.renderWidgets cost = " + (l2 - l1));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARArguments != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArARArguments.alreadyIsTorchbearer;
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (paramInt1 != 0) {}
    for (this.e = new float[16];; this.e = null) {
      try
      {
        NativeInterface.hiarqGetGLPose(paramArrayOfFloat, this.e);
        Matrix.translateM(this.e, 0, paramInt1 / 2.0F, paramInt2 / 2.0F, 0.0F);
        this.f[0] = paramInt1;
        this.f[1] = paramInt2;
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return true;
      }
      catch (Exception paramArrayOfFloat)
      {
        for (;;)
        {
          paramArrayOfFloat.printStackTrace();
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int == 1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\HSARToolkit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */