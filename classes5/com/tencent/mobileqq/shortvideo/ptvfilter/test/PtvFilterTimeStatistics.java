package com.tencent.mobileqq.shortvideo.ptvfilter.test;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class PtvFilterTimeStatistics
{
  public static int a = 0;
  public static final String a = "PtvFilterTimeStatistics";
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static long[] jdField_a_of_type_ArrayOfLong = new long[20];
  public static int b = 0;
  private static volatile boolean jdField_b_of_type_Boolean = false;
  private static long[] jdField_b_of_type_ArrayOfLong = new long[20];
  private static final int jdField_c_of_type_Int = 20;
  private static boolean jdField_c_of_type_Boolean;
  private static long[] jdField_c_of_type_ArrayOfLong = new long[20];
  private static int jdField_d_of_type_Int;
  private static long[] jdField_d_of_type_ArrayOfLong = new long[20];
  private static int jdField_e_of_type_Int;
  private static long[] jdField_e_of_type_ArrayOfLong = new long[20];
  private static int f;
  private static int g;
  private static int h;
  private static int i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    if (!jdField_b_of_type_Boolean) {
      i += 1;
    }
    if (i >= 5) {
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public static void a(long paramLong)
  {
    int j;
    if (jdField_d_of_type_Int < 20)
    {
      long[] arrayOfLong = jdField_a_of_type_ArrayOfLong;
      j = jdField_d_of_type_Int;
      jdField_d_of_type_Int = j + 1;
      arrayOfLong[j] = paramLong;
    }
    if ((!jdField_a_of_type_Boolean) && (jdField_d_of_type_Int == 20))
    {
      jdField_a_of_type_Boolean = true;
      paramLong = 0L;
      j = 0;
      while (j < 20)
      {
        paramLong += jdField_a_of_type_ArrayOfLong[j];
        j += 1;
      }
      PerformenceDataTag.a("sv_filter_face_detect", paramLong / 1000L / 20L);
    }
  }
  
  public static void b()
  {
    long l2 = 0L;
    int k = 0;
    if ((h == 20) && (!jdField_c_of_type_Boolean))
    {
      if ((h == jdField_e_of_type_Int) && (h == f) && (h == g))
      {
        jdField_c_of_type_Boolean = true;
        int j = 0;
        long l1 = 0L;
        while (j < jdField_e_of_type_Int)
        {
          l1 += jdField_b_of_type_ArrayOfLong[j];
          j += 1;
        }
        double d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[FaceTotalTime=" + d1 + "ms]" + " avg=" + d1 / 20.0D);
        }
        PerformenceDataTag.a("sv_filter_face_track", d1 / 20L);
        j = 0;
        l1 = 0L;
        while (j < f)
        {
          l1 += jdField_c_of_type_ArrayOfLong[j];
          j += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[FilterTotalTime=" + d1 + "ms]" + " avg=" + d1 / 20.0D);
        }
        PerformenceDataTag.a("sv_filter_draw_frame", d1 / 20L);
        j = 0;
        l1 = 0L;
        while (j < g)
        {
          l1 += jdField_d_of_type_ArrayOfLong[j];
          j += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowTotalDrawTime=" + d1 + "ms]" + " avg=" + d1 / 20.0D);
        }
        PerformenceDataTag.a("sv_filter_total_draw", d1 / 20L);
        l1 = l2;
        j = k;
        while (j < h)
        {
          l1 += jdField_e_of_type_ArrayOfLong[j];
          j += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowTotalTime=" + d1 + "ms]" + " avg=" + d1 / 20.0D);
        }
        PerformenceDataTag.a("sv_filter_total_process_frame", d1 / 20L);
        if (jdField_b_of_type_Int == 0) {
          jdField_b_of_type_Int = 1;
        }
        PerformenceDataTag.a("sv_filter_track_ratio", jdField_a_of_type_Int * 1000 / jdField_b_of_type_Int);
      }
      return;
    }
    jdField_b_of_type_Boolean = false;
    i = 0;
    jdField_c_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
  }
  
  public static void b(long paramLong)
  {
    if ((jdField_b_of_type_Boolean) && (jdField_e_of_type_Int < 20))
    {
      long[] arrayOfLong = jdField_b_of_type_ArrayOfLong;
      int j = jdField_e_of_type_Int;
      jdField_e_of_type_Int = j + 1;
      arrayOfLong[j] = paramLong;
    }
  }
  
  public static void c(long paramLong)
  {
    if ((jdField_b_of_type_Boolean) && (f < 20))
    {
      long[] arrayOfLong = jdField_c_of_type_ArrayOfLong;
      int j = f;
      f = j + 1;
      arrayOfLong[j] = paramLong;
    }
  }
  
  public static void d(long paramLong)
  {
    if ((jdField_b_of_type_Boolean) && (g < 20))
    {
      long[] arrayOfLong = jdField_d_of_type_ArrayOfLong;
      int j = g;
      g = j + 1;
      arrayOfLong[j] = paramLong;
    }
  }
  
  public static void e(long paramLong)
  {
    if ((jdField_b_of_type_Boolean) && (h < 20))
    {
      long[] arrayOfLong = jdField_e_of_type_ArrayOfLong;
      int j = h;
      h = j + 1;
      arrayOfLong[j] = paramLong;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ptvfilter\test\PtvFilterTimeStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */