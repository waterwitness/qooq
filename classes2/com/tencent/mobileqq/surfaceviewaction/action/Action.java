package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class Action
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 4;
  public static final int e = 8;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public float a;
  protected long a;
  private Action.OnActionEndListener a;
  public boolean a;
  public boolean b;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  
  public Action(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 1.0F;
    this.k = 255;
    this.o = 0;
    this.m = paramInt1;
    this.n = paramInt2;
    this.o = paramInt3;
  }
  
  public void a()
  {
    this.b = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    if ((paramInt >= this.m) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction$OnActionEndListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction$OnActionEndListener.a();
    }
  }
  
  public void a(Action.OnActionEndListener paramOnActionEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction$OnActionEndListener = paramOnActionEndListener;
  }
  
  public boolean a()
  {
    if (this.b) {
      return false;
    }
    int i1 = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    float f1 = i1 / this.m;
    if (this.o == 1) {
      f1 = i1 * i1 / (this.m * this.m);
    }
    for (;;)
    {
      a(i1, f1);
      if (i1 >= this.m) {
        b();
      }
      return true;
      if (this.o == 2)
      {
        f1 = i1 / this.m;
        f1 *= (2.0F - f1);
      }
    }
  }
  
  public void b()
  {
    this.b = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\action\Action.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */