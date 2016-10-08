package com.tencent.util;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import xrm;

public class ProfilePerformanceReport
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 60000L;
  public static ProfilePerformanceReport a;
  public static final String a = "ProfilePerformanceReport";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "param_click2create", "param_first_draw", "param_first_show", "param_open", "param_run_delay", "param_init_data", "param_fetch_data", "param_prepare_res", "param_refresh_from_cache", "param_refresh_from_net" };
  public static final int b = 0;
  private static final long jdField_b_of_type_Long = 20000L;
  public static ProfilePerformanceReport b;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 9;
  private static final int m = 0;
  private static final int n = 1;
  private static final int o = 2;
  private static final int p = 3;
  private static final int q = 4;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(100);
  private final long[] jdField_a_of_type_ArrayOfLong;
  private final String jdField_b_of_type_JavaLangString;
  private final long[] jdField_b_of_type_ArrayOfLong;
  private long c;
  private int r;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfilePerformanceReport(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfLong = new long[10];
    this.jdField_b_of_type_ArrayOfLong = new long[10];
    a();
  }
  
  public static void b() {}
  
  public static void c() {}
  
  public void a()
  {
    int i1 = 0;
    this.c = 0L;
    this.r = 0;
    while (i1 <= 9)
    {
      long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
      this.jdField_b_of_type_ArrayOfLong[i1] = 0L;
      arrayOfLong[i1] = 0L;
      i1 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ArrayOfLong[paramInt] != 0L);
      this.jdField_a_of_type_ArrayOfLong[paramInt] = SystemClock.elapsedRealtime();
      if (paramInt == 0)
      {
        this.r = 2;
        this.jdField_a_of_type_ArrayOfLong[3] = this.jdField_a_of_type_ArrayOfLong[paramInt];
      }
    } while (!QLog.isDevelopLevel());
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    this.jdField_a_of_type_JavaLangStringBuilder.append("markStart, [").append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]).append(",").append(this.jdField_a_of_type_ArrayOfLong[paramInt]).append(",").append(this.r).append("]");
    QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    long l2 = 0L;
    long l1 = 0L;
    if (i1 <= 9)
    {
      label65:
      String str;
      if ((this.jdField_b_of_type_ArrayOfLong[i1] != 0L) && (this.jdField_a_of_type_ArrayOfLong[i1] != 0L))
      {
        l1 = this.jdField_b_of_type_ArrayOfLong[i1] - this.jdField_a_of_type_ArrayOfLong[i1];
        if (i1 == 3) {
          l2 = l1;
        }
        str = jdField_a_of_type_ArrayOfJavaLangString[i1];
        if (l1 <= 0L) {
          break label119;
        }
      }
      label119:
      for (long l3 = l1;; l3 = 0L)
      {
        localHashMap.put(str, String.valueOf(l3));
        i1 += 1;
        break;
        l1 = 0L;
        break label65;
      }
    }
    this.c = SystemClock.elapsedRealtime();
    this.r = 1;
    if (QLog.isDevelopLevel())
    {
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_a_of_type_JavaLangStringBuilder.append("reportPerformance, [").append(l1).append(",").append(localHashMap.toString()).append("]");
      QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    ThreadManager.b().post(new xrm(this, paramString, l2, localHashMap));
  }
  
  public boolean a()
  {
    if (this.r == 4) {
      if (Math.abs(SystemClock.elapsedRealtime() - this.c) >= 60000L) {}
    }
    do
    {
      return true;
      return false;
      if (this.r != 2) {
        break;
      }
    } while (Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_ArrayOfLong[0]) < 20000L);
    return false;
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    while (this.jdField_a_of_type_ArrayOfLong[paramInt] == 0L) {
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.r < 3) {}
    while ((this.r != 4) && (!paramBoolean)) {
      return false;
    }
    return true;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ArrayOfLong[paramInt] != 0L) && (this.jdField_b_of_type_ArrayOfLong[paramInt] == 0L))
      {
        this.jdField_b_of_type_ArrayOfLong[paramInt] = SystemClock.elapsedRealtime();
        if (paramInt == 1)
        {
          this.jdField_b_of_type_ArrayOfLong[3] = this.jdField_b_of_type_ArrayOfLong[paramInt];
          this.r = 3;
        }
        while (QLog.isDevelopLevel())
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          this.jdField_a_of_type_JavaLangStringBuilder.append("markEnd, [").append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]).append(",").append(this.jdField_b_of_type_ArrayOfLong[paramInt]).append(",").append(this.jdField_b_of_type_ArrayOfLong[paramInt] - this.jdField_a_of_type_ArrayOfLong[paramInt]).append(",").append(this.r).append("]");
          QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
          return;
          if (paramInt == 9) {
            this.r = 4;
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    return (this.r == 2) || (this.r == 3);
  }
  
  public boolean b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    while ((this.jdField_a_of_type_ArrayOfLong[paramInt] == 0L) || (this.jdField_b_of_type_ArrayOfLong[paramInt] == 0L)) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\ProfilePerformanceReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */