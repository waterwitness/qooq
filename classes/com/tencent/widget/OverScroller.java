package com.tencent.widget;

import android.content.Context;
import android.util.FloatMath;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.AnimateUtils;
import xue;

public class OverScroller
{
  public static int b = 0;
  private static final int c = 250;
  private static final int d = 0;
  private static final int e = 1;
  private int jdField_a_of_type_Int;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final xue jdField_a_of_type_Xue;
  private final boolean jdField_a_of_type_Boolean;
  private final xue b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = 400;
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
    this.jdField_a_of_type_Xue = new xue();
    this.jdField_b_of_type_Xue = new xue();
    xue.a(paramContext);
  }
  
  public float a()
  {
    return FloatMath.sqrt(xue.a(this.jdField_a_of_type_Xue) * xue.a(this.jdField_a_of_type_Xue) + xue.a(this.jdField_b_of_type_Xue) * xue.a(this.jdField_b_of_type_Xue));
  }
  
  public final int a()
  {
    return xue.a(this.jdField_a_of_type_Xue);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xue.a();
    this.jdField_b_of_type_Xue.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Xue.a(paramFloat);
    this.jdField_b_of_type_Xue.a(paramFloat);
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Xue.b(paramInt);
    this.jdField_b_of_type_Xue.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Xue.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Xue.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Xue.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = xue.a(this.jdField_a_of_type_Xue);
      float f2 = xue.a(this.jdField_b_of_type_Xue);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Xue.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Xue.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    xue.a(this.jdField_a_of_type_Xue, paramLong);
    xue.a(this.jdField_b_of_type_Xue, paramLong);
  }
  
  public final void a(boolean paramBoolean)
  {
    xue.a(this.jdField_a_of_type_Xue, xue.a(this.jdField_b_of_type_Xue, paramBoolean));
  }
  
  public final boolean a()
  {
    return (xue.a(this.jdField_a_of_type_Xue)) && (xue.a(this.jdField_b_of_type_Xue));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = xue.c(this.jdField_a_of_type_Xue);
    int j = xue.b(this.jdField_a_of_type_Xue);
    int k = xue.c(this.jdField_b_of_type_Xue);
    int m = xue.b(this.jdField_b_of_type_Xue);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Xue.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Xue.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public final int b()
  {
    return xue.a(this.jdField_b_of_type_Xue);
  }
  
  @Deprecated
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Xue.a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Xue.b(paramInt1, paramInt2, paramInt3);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - xue.a(this.jdField_a_of_type_Xue);
      int i = xue.d(this.jdField_a_of_type_Xue);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = AnimateUtils.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!xue.a(this.jdField_a_of_type_Xue)) {
            this.jdField_a_of_type_Xue.b(f);
          }
          if (xue.a(this.jdField_b_of_type_Xue)) {
            break;
          }
          this.jdField_b_of_type_Xue.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!xue.a(this.jdField_a_of_type_Xue)) && (!this.jdField_a_of_type_Xue.b()) && (!this.jdField_a_of_type_Xue.a())) {
        this.jdField_a_of_type_Xue.a();
      }
      if ((!xue.a(this.jdField_b_of_type_Xue)) && (!this.jdField_b_of_type_Xue.b()) && (!this.jdField_b_of_type_Xue.a())) {
        this.jdField_b_of_type_Xue.a();
      }
    }
  }
  
  public final int c()
  {
    return xue.b(this.jdField_a_of_type_Xue);
  }
  
  @Deprecated
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Xue.a(paramInt);
  }
  
  public boolean c()
  {
    return ((!xue.a(this.jdField_a_of_type_Xue)) && (xue.e(this.jdField_a_of_type_Xue) != 0)) || ((!xue.a(this.jdField_b_of_type_Xue)) && (xue.e(this.jdField_b_of_type_Xue) != 0));
  }
  
  public final int d()
  {
    return xue.b(this.jdField_b_of_type_Xue);
  }
  
  public final int e()
  {
    return xue.c(this.jdField_a_of_type_Xue);
  }
  
  public final int f()
  {
    return xue.c(this.jdField_b_of_type_Xue);
  }
  
  @Deprecated
  public final int g()
  {
    return Math.max(xue.d(this.jdField_a_of_type_Xue), xue.d(this.jdField_b_of_type_Xue));
  }
  
  public int h()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - Math.min(xue.a(this.jdField_a_of_type_Xue), xue.a(this.jdField_b_of_type_Xue)));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\OverScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */