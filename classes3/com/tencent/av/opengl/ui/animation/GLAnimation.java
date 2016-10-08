package com.tencent.av.opengl.ui.animation;

import com.tencent.av.opengl.ui.GLView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class GLAnimation
{
  public static final byte a = 1;
  public static final byte b = 2;
  public static final byte c = 3;
  private static final byte jdField_d_of_type_Byte = 0;
  private float A;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private GLView jdField_a_of_type_ComTencentAvOpenglUiGLView;
  private GLAnimation.AnimationListenerGL jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v;
  private float w;
  private float x;
  private float y;
  private float z;
  
  public GLAnimation()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1000;
    this.j = 1.0F;
    this.k = 1.0F;
    this.m = 1.0F;
    this.n = 1.0F;
    this.o = 1.0F;
    this.p = 1.0F;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static GLAnimation a(List paramList)
  {
    GLAnimation localGLAnimation1 = null;
    if (paramList != null) {
      label475:
      label530:
      for (;;)
      {
        int i2;
        float f6;
        float f5;
        float f4;
        int i3;
        try
        {
          if (paramList.size() != 0)
          {
            localGLAnimation1 = new GLAnimation();
            i4 = 0;
            f12 = 0.0F;
            f9 = 0.0F;
            f7 = 0.0F;
            i6 = 0;
            f8 = 0.0F;
            i5 = 0;
            f11 = 0.0F;
            f10 = 0.0F;
            f1 = 0.0F;
            f3 = 0.0F;
            f2 = 0.0F;
            int i1 = 0;
            i2 = 0;
            if (i2 >= paramList.size()) {
              break label530;
            }
            GLAnimation localGLAnimation2 = (GLAnimation)paramList.get(i2);
            f6 = f7;
            f5 = f9;
            f4 = f12;
            i3 = i4;
            if (localGLAnimation2.jdField_b_of_type_Boolean)
            {
              localGLAnimation1.jdField_b_of_type_Boolean = true;
              i3 = i4 + 1;
              f4 = f12 + localGLAnimation2.jdField_c_of_type_Float;
              f5 = f9 + localGLAnimation2.f;
              f6 = f7 + localGLAnimation2.i;
            }
            f7 = f8;
            i4 = i6;
            if (localGLAnimation2.jdField_c_of_type_Boolean)
            {
              localGLAnimation1.jdField_c_of_type_Boolean = true;
              i4 = i6 + 1;
              f7 = f8 + localGLAnimation2.l;
            }
            f9 = f10;
            f8 = f11;
            i6 = i5;
            if (localGLAnimation2.jdField_d_of_type_Boolean)
            {
              localGLAnimation1.jdField_d_of_type_Boolean = true;
              i6 = i5 + 1;
              f8 = f11 + localGLAnimation2.q;
              f9 = f10 + localGLAnimation2.r;
            }
            if (localGLAnimation2.jdField_e_of_type_Boolean)
            {
              localGLAnimation1.jdField_e_of_type_Boolean = true;
              f12 = localGLAnimation2.y;
              f10 = localGLAnimation2.z;
              f11 = localGLAnimation2.A;
              f10 = f3 + f10;
              f3 = f1 + f12;
              f1 = f11 + f2;
              i1 += 1;
              f2 = f10;
              if (i2 != paramList.size() - 1) {
                break label475;
              }
              if (localGLAnimation1.jdField_b_of_type_Boolean)
              {
                localGLAnimation1.jdField_c_of_type_Float = (f4 / i3);
                localGLAnimation1.f = (f5 / i3);
                localGLAnimation1.i = (f6 / i3);
              }
              if (localGLAnimation1.jdField_c_of_type_Boolean) {
                localGLAnimation1.l = (f7 / i4);
              }
              if (localGLAnimation1.jdField_d_of_type_Boolean)
              {
                localGLAnimation1.q = (f8 / i6);
                localGLAnimation1.r = (f9 / i6);
              }
              if (!localGLAnimation1.jdField_e_of_type_Boolean) {
                break label475;
              }
              localGLAnimation1.y = (f3 / i1);
              localGLAnimation1.z = (f2 / i1);
              localGLAnimation1.A = (f1 / i1);
              break label475;
            }
          }
          else
          {
            return localGLAnimation1;
          }
        }
        finally {}
        float f10 = f1;
        float f1 = f2;
        float f2 = f3;
        float f3 = f10;
        continue;
        i2 += 1;
        f10 = f3;
        f3 = f2;
        f2 = f1;
        f1 = f10;
        f10 = f9;
        float f11 = f8;
        int i5 = i6;
        float f8 = f7;
        int i6 = i4;
        float f7 = f6;
        float f9 = f5;
        float f12 = f4;
        int i4 = i3;
      }
    }
    return null;
  }
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_c_of_type_Boolean = true;
    this.j = paramFloat1;
    this.l = paramFloat1;
    this.k = paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_d_of_type_Boolean = true;
    this.m = paramFloat1;
    this.q = paramFloat1;
    this.n = paramFloat2;
    this.r = paramFloat2;
    this.o = paramFloat3;
    this.p = paramFloat4;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat1;
    this.jdField_d_of_type_Float = paramFloat2;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.i = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_e_of_type_Float = paramFloat5;
    this.h = paramFloat6;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(GLView paramGLView)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView = paramGLView;
  }
  
  public void a(GLAnimation.AnimationListenerGL paramAnimationListenerGL)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL = paramAnimationListenerGL;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    long l1 = paramLong - this.jdField_a_of_type_Long;
    if (l1 == 0L) {
      return false;
    }
    paramLong = l1;
    if (l1 >= this.jdField_b_of_type_Int)
    {
      paramLong = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Boolean = true;
      b();
    }
    float f1;
    if (this.jdField_a_of_type_Int == 0) {
      f1 = (float)paramLong * 1.0F / this.jdField_b_of_type_Int;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float + (this.jdField_b_of_type_Float - this.jdField_a_of_type_Float) * f1);
        this.f = (this.jdField_d_of_type_Float + (this.jdField_e_of_type_Float - this.jdField_d_of_type_Float) * f1);
        this.i = (this.g + (this.h - this.g) * f1);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.q = (this.m + (this.o - this.m) * f1);
        this.r = (this.n + (this.p - this.n) * f1);
      }
      if (this.jdField_e_of_type_Boolean)
      {
        this.y = (this.s + (this.t - this.s) * f1);
        this.z = (this.u + (this.v - this.u) * f1);
        this.A = (this.w + (this.x - this.w) * f1);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      float f2 = this.j;
      this.l = (f1 * (this.k - this.j) + f2);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        f1 = (float)paramLong;
        f1 = (float)paramLong * (1.0F * f1) / this.jdField_b_of_type_Int / this.jdField_b_of_type_Int;
      }
      else if (this.jdField_a_of_type_Int == 2)
      {
        l1 = this.jdField_b_of_type_Int;
        if (paramLong == 0L)
        {
          f1 = 0.0F;
        }
        else
        {
          f1 = (float)paramLong * 1.0F * (float)paramLong / (float)l1 / (float)l1;
          f1 = ((float)l1 * 2.0F / (float)paramLong - 1.0F) * f1;
        }
      }
      else
      {
        f1 = 1.0F;
      }
    }
  }
  
  public float b()
  {
    return this.f;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) {}
    synchronized (this.jdField_a_of_type_ComTencentAvOpenglUiGLView.a())
    {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.a().remove(this);
      if (this.jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL.a();
        this.jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL = null;
      }
      return;
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_e_of_type_Boolean = true;
    this.s = paramFloat1;
    this.y = paramFloat1;
    this.t = paramFloat2;
    this.u = paramFloat3;
    this.z = paramFloat3;
    this.v = paramFloat4;
    this.w = paramFloat5;
    this.A = paramFloat5;
    this.x = paramFloat6;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = Math.abs(paramInt);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public float c()
  {
    return this.i;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public float d()
  {
    return this.l;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public float e()
  {
    return this.q;
  }
  
  public boolean e()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public float f()
  {
    return this.r;
  }
  
  public float g()
  {
    return this.y;
  }
  
  public float h()
  {
    return this.z;
  }
  
  public float i()
  {
    return this.A;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\ui\animation\GLAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */