package com.tencent.av.widget.stageview;

import android.content.Context;
import android.util.FloatMath;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hck;

public class OverScroller
{
  private static float jdField_a_of_type_Float = 0.0F;
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static float jdField_b_of_type_Float = 0.0F;
  private static final int jdField_b_of_type_Int = 250;
  private static float jdField_c_of_type_Float = 0.0F;
  private static final int jdField_c_of_type_Int = 0;
  private static float jdField_d_of_type_Float = 0.0F;
  private static final int jdField_d_of_type_Int = 1;
  private static final int e = 100;
  private int jdField_a_of_type_Int;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final hck jdField_a_of_type_Hck;
  private final boolean jdField_a_of_type_Boolean;
  private final hck jdField_b_of_type_Hck;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Float = 0.4F;
    jdField_b_of_type_Float = 1.0F - jdField_a_of_type_Float;
    jdField_a_of_type_ArrayOfFloat = new float[101];
    float f1 = 0.0F;
    int i = 0;
    if (i <= 100)
    {
      float f4 = i / 100.0F;
      float f2 = 1.0F;
      for (;;)
      {
        float f3 = (f2 - f1) / 2.0F + f1;
        float f5 = 3.0F * f3 * (1.0F - f3);
        float f6 = ((1.0F - f3) * jdField_a_of_type_Float + jdField_b_of_type_Float * f3) * f5 + f3 * f3 * f3;
        if (Math.abs(f6 - f4) < 1.0E-5D)
        {
          jdField_a_of_type_ArrayOfFloat[i] = (f3 * f3 * f3 + f5);
          i += 1;
          break;
        }
        if (f6 > f4) {
          f2 = f3;
        } else {
          f1 = f3;
        }
      }
    }
    jdField_a_of_type_ArrayOfFloat[100] = 1.0F;
    c = 8.0F;
    d = 1.0F;
    d = 1.0F / a(1.0F);
  }
  
  public OverScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, float paramFloat1, float paramFloat2)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this(paramContext, paramInterpolator, paramBoolean);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Hck = new hck();
    this.jdField_b_of_type_Hck = new hck();
    hck.a(paramContext);
  }
  
  public static float a(float paramFloat)
  {
    paramFloat = c * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.36787945F) + 0.36787945F) {
      return paramFloat * d;
    }
  }
  
  public float a()
  {
    return FloatMath.sqrt(hck.a(this.jdField_a_of_type_Hck) * hck.a(this.jdField_a_of_type_Hck) + hck.a(this.jdField_b_of_type_Hck) * hck.a(this.jdField_b_of_type_Hck));
  }
  
  public final int a()
  {
    return hck.a(this.jdField_a_of_type_Hck);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Hck.a();
    this.jdField_b_of_type_Hck.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Hck.a(paramFloat);
    this.jdField_b_of_type_Hck.a(paramFloat);
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Hck.b(paramInt);
    this.jdField_b_of_type_Hck.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Hck.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Hck.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Hck.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = hck.a(this.jdField_a_of_type_Hck);
      float f2 = hck.a(this.jdField_b_of_type_Hck);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Hck.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Hck.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = hck.a(this.jdField_a_of_type_Hck);
      float f2 = hck.a(this.jdField_b_of_type_Hck);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Hck.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9, paramInt11);
      this.jdField_b_of_type_Hck.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10, paramInt12);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    hck.a(this.jdField_a_of_type_Hck, paramLong);
    hck.a(this.jdField_b_of_type_Hck, paramLong);
  }
  
  public final void a(boolean paramBoolean)
  {
    hck.a(this.jdField_a_of_type_Hck, hck.a(this.jdField_b_of_type_Hck, paramBoolean));
  }
  
  public final boolean a()
  {
    return (hck.a(this.jdField_a_of_type_Hck)) && (hck.a(this.jdField_b_of_type_Hck));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = hck.c(this.jdField_a_of_type_Hck);
    int j = hck.b(this.jdField_a_of_type_Hck);
    int k = hck.c(this.jdField_b_of_type_Hck);
    int m = hck.b(this.jdField_b_of_type_Hck);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Hck.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Hck.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public final int b()
  {
    return hck.a(this.jdField_b_of_type_Hck);
  }
  
  @Deprecated
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Hck.a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Hck.b(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean b()
  {
    if (a()) {
      return false;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return true;
      long l = AnimationUtils.currentAnimationTimeMillis() - hck.a(this.jdField_a_of_type_Hck);
      int i = hck.d(this.jdField_a_of_type_Hck);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!hck.a(this.jdField_a_of_type_Hck)) {
            this.jdField_a_of_type_Hck.b(f);
          }
          if (hck.a(this.jdField_b_of_type_Hck)) {
            break;
          }
          this.jdField_b_of_type_Hck.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!hck.a(this.jdField_a_of_type_Hck)) && (!this.jdField_a_of_type_Hck.b()) && (!this.jdField_a_of_type_Hck.a())) {
        this.jdField_a_of_type_Hck.a();
      }
      if ((!hck.a(this.jdField_b_of_type_Hck)) && (!this.jdField_b_of_type_Hck.b()) && (!this.jdField_b_of_type_Hck.a())) {
        this.jdField_b_of_type_Hck.a();
      }
    }
  }
  
  public final int c()
  {
    return hck.b(this.jdField_a_of_type_Hck);
  }
  
  @Deprecated
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Hck.a(paramInt);
  }
  
  public boolean c()
  {
    return ((!hck.a(this.jdField_a_of_type_Hck)) && (hck.e(this.jdField_a_of_type_Hck) != 0)) || ((!hck.a(this.jdField_b_of_type_Hck)) && (hck.e(this.jdField_b_of_type_Hck) != 0));
  }
  
  public final int d()
  {
    return hck.b(this.jdField_b_of_type_Hck);
  }
  
  public final int e()
  {
    return hck.c(this.jdField_a_of_type_Hck);
  }
  
  public final int f()
  {
    return hck.c(this.jdField_b_of_type_Hck);
  }
  
  @Deprecated
  public final int g()
  {
    return Math.max(hck.d(this.jdField_a_of_type_Hck), hck.d(this.jdField_b_of_type_Hck));
  }
  
  public int h()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - Math.min(hck.a(this.jdField_a_of_type_Hck), hck.a(this.jdField_b_of_type_Hck)));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\stageview\OverScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */