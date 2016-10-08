package com.tencent.wstt.SSCM;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

public class SSCM
{
  private static final int jdField_f_of_type_Int = 0;
  private static final int jdField_g_of_type_Int = 1;
  private static final int h = 2;
  protected double a;
  protected float a;
  public int a;
  protected long a;
  protected boolean a;
  private float jdField_b_of_type_Float;
  protected int b;
  protected long b;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  protected int c;
  private float d;
  protected int d;
  private float e;
  protected int e;
  private float jdField_f_of_type_Float;
  private float jdField_g_of_type_Float;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public SSCM()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  private long a()
  {
    return new Date().getTime();
  }
  
  private long b()
  {
    return new Date().getTime();
  }
  
  public int a(Context paramContext, long paramLong)
  {
    this.jdField_b_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
    if (!this.jdField_a_of_type_Boolean) {
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        this.jdField_c_of_type_Int = 4096;
      }
    }
    for (;;)
    {
      if (paramLong < 102400L) {
        this.jdField_c_of_type_Int *= 4;
      }
      if (paramLong - this.jdField_c_of_type_Int <= this.jdField_c_of_type_Int / 2) {
        this.jdField_c_of_type_Int = ((int)paramLong);
      }
      return this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = 32768;
      continue;
      this.jdField_c_of_type_Int = 16384;
      continue;
      this.jdField_c_of_type_Int = 8192;
    }
  }
  
  public int a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Long = a();
    if (paramLong1 < 102400L) {}
    for (this.k = 1; true == this.jdField_b_of_type_Boolean; this.k = 2)
    {
      a();
      this.jdField_d_of_type_Int = a(paramContext, paramLong1);
      this.jdField_b_of_type_Boolean = false;
      return this.jdField_d_of_type_Int;
    }
    this.jdField_c_of_type_Float = ((float)(this.jdField_d_of_type_Int / this.jdField_a_of_type_Double));
    label144:
    label176:
    float f1;
    if (0.0F == this.jdField_e_of_type_Float)
    {
      this.jdField_e_of_type_Float = this.jdField_c_of_type_Float;
      if (this.jdField_a_of_type_Int != 2)
      {
        this.l += 1;
        if (this.jdField_d_of_type_Float != 0.0F) {
          break label278;
        }
        this.jdField_a_of_type_Float = 1.0F;
        if (this.l == this.k) {
          this.jdField_b_of_type_Float = this.jdField_e_of_type_Float;
        }
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (paramLong1 - paramLong2 - this.jdField_d_of_type_Int <= this.jdField_d_of_type_Int / 2) {
          this.jdField_d_of_type_Int = ((int)(paramLong1 - paramLong2));
        }
        if (this.l == 0)
        {
          f1 = this.jdField_d_of_type_Float;
          label219:
          if ((paramInt <= 0) || ((this.jdField_d_of_type_Int >= 0) && (this.jdField_d_of_type_Int <= paramInt))) {
            break label646;
          }
          this.jdField_d_of_type_Int = paramInt;
        }
        break;
      }
    }
    for (;;)
    {
      return this.jdField_d_of_type_Int;
      this.jdField_e_of_type_Float = ((float)(0.8D * this.jdField_c_of_type_Float + 0.19999999999999996D * this.jdField_e_of_type_Float));
      break;
      label278:
      if (this.l != this.k) {
        break label144;
      }
      this.jdField_a_of_type_Float = ((float)((this.jdField_e_of_type_Float - this.jdField_d_of_type_Float) / this.jdField_b_of_type_Float / ((this.jdField_d_of_type_Int - this.jdField_e_of_type_Int) / (this.jdField_c_of_type_Int + 0.0D))));
      break label144;
      if (this.l != this.k) {
        break label176;
      }
      if (this.jdField_a_of_type_Float < 0.09D)
      {
        this.jdField_a_of_type_Int = 1;
        this.jdField_d_of_type_Int = ((int)(1.05D * this.jdField_e_of_type_Int));
      }
      for (;;)
      {
        this.jdField_e_of_type_Float = 0.0F;
        this.l = 0;
        break;
        this.jdField_a_of_type_Int = 0;
        this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
        this.jdField_d_of_type_Int = (this.jdField_e_of_type_Int * 2);
        this.jdField_d_of_type_Float = this.jdField_e_of_type_Float;
      }
      if (this.l != this.k) {
        break label176;
      }
      if (this.jdField_a_of_type_Float < 0.09D)
      {
        this.jdField_a_of_type_Int = 2;
        this.f = this.jdField_e_of_type_Float;
        this.jdField_d_of_type_Float = 0.0F;
        this.jdField_e_of_type_Int = 0;
        this.g = this.jdField_e_of_type_Float;
        break label176;
      }
      this.jdField_a_of_type_Int = 1;
      this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_d_of_type_Int = ((int)(1.05D * this.jdField_e_of_type_Int));
      this.jdField_d_of_type_Float = this.jdField_e_of_type_Float;
      this.g = this.jdField_e_of_type_Float;
      this.jdField_e_of_type_Float = 0.0F;
      this.l = 0;
      break label176;
      if (Math.abs(this.jdField_e_of_type_Float - this.f) > 0.2D * this.f) {}
      for (this.i += 1;; this.i = 0)
      {
        if (this.i >= this.j) {
          break label596;
        }
        this.jdField_a_of_type_Int = 2;
        break;
      }
      label596:
      this.i = 0;
      this.jdField_a_of_type_Int = 0;
      this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_d_of_type_Float = 0.0F;
      this.jdField_e_of_type_Int = 0;
      this.jdField_e_of_type_Float = 0.0F;
      this.l = 0;
      break label176;
      f1 = this.jdField_e_of_type_Float;
      break label219;
      label646:
      if (this.jdField_d_of_type_Int < 0)
      {
        this.i = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
        this.jdField_d_of_type_Float = 0.0F;
        this.jdField_e_of_type_Int = 0;
        this.jdField_e_of_type_Float = 0.0F;
        this.l = 0;
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.g = 0.0F;
    this.i = 0;
    this.l = 0;
    this.j = 3;
    this.k = 2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Long = b();
    this.jdField_a_of_type_Double = ((this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000.0D);
    QLog.d("upload", 2, "sendFilePakage time:" + this.jdField_a_of_type_Double);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\wstt\SSCM\SSCM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */