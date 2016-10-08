package com.tencent.mobileqq.camera.report;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QCameraRuntimeReport
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private long jdField_g_of_type_Long;
  private int jdField_h_of_type_Int;
  private long jdField_h_of_type_Long;
  private int jdField_i_of_type_Int;
  private long jdField_i_of_type_Long;
  private int jdField_j_of_type_Int;
  private long jdField_j_of_type_Long;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private long v;
  private long w;
  private long x;
  private long y;
  private long z;
  
  public QCameraRuntimeReport(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
  
  public void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.report", 4, "[report] phone_mode:" + this.jdField_a_of_type_JavaLangString + " present_times:" + String.valueOf(this.jdField_f_of_type_Long - this.jdField_e_of_type_Long) + " open_camera_times:" + String.valueOf(this.x - this.w) + " preview_times:" + String.valueOf(this.l - this.k) + " switch_times:" + String.valueOf(this.p - this.o) + " focus_times:" + String.valueOf(this.t - this.s) + " capture_times:" + String.valueOf(this.v - this.u) + " stop_preview_times:" + String.valueOf(this.n - this.m) + " close_camera_times:" + String.valueOf(this.z - this.y) + " camera_state:" + String.valueOf(this.jdField_i_of_type_Int) + " last_action:" + String.valueOf(this.jdField_j_of_type_Int) + " display_orientation:" + String.valueOf(this.jdField_f_of_type_Int) + " camera_orientation:" + String.valueOf(this.jdField_g_of_type_Int) + " picture_orientation:" + String.valueOf(this.jdField_h_of_type_Int));
    }
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
    this.s = 0L;
    this.t = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.w = 0L;
    this.x = 0L;
    this.y = 0L;
    this.z = 0L;
    this.q = 0L;
    this.r = 0L;
    this.u = 0L;
    this.v = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.t = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void b(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void c(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void d(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void e()
  {
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  public void e(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_Long = System.currentTimeMillis();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void h()
  {
    this.jdField_g_of_type_Long = System.currentTimeMillis();
  }
  
  public void i()
  {
    this.jdField_h_of_type_Long = System.currentTimeMillis();
  }
  
  public void j() {}
  
  public void k() {}
  
  public void l()
  {
    this.w = System.currentTimeMillis();
  }
  
  public void m()
  {
    this.x = System.currentTimeMillis();
  }
  
  public void n()
  {
    this.jdField_b_of_type_Boolean = true;
    this.k = System.currentTimeMillis();
  }
  
  public void o()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.l = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void p()
  {
    this.m = System.currentTimeMillis();
  }
  
  public void q()
  {
    this.n = System.currentTimeMillis();
  }
  
  public void r()
  {
    this.y = System.currentTimeMillis();
  }
  
  public void s()
  {
    this.z = System.currentTimeMillis();
  }
  
  public void t()
  {
    this.o = System.currentTimeMillis();
  }
  
  public void u()
  {
    this.p = System.currentTimeMillis();
  }
  
  public void v()
  {
    this.q = System.currentTimeMillis();
  }
  
  public void w()
  {
    this.r = System.currentTimeMillis();
  }
  
  public void x()
  {
    this.s = System.currentTimeMillis();
  }
  
  public void y()
  {
    this.u = System.currentTimeMillis();
  }
  
  public void z()
  {
    this.v = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\report\QCameraRuntimeReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */