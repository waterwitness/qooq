package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GapDataCollector$RefreshData
{
  public int a;
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public GapDataCollector$RefreshData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, double paramDouble, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
    this.f = ((0.9D + paramDouble));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "70% :  " + this.c + " --------- 80% : " + this.b + " --------- 90% : " + this.jdField_a_of_type_Long + " --------- min : " + this.d + " --------- max : " + this.e + " --------- num : " + this.jdField_a_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\GapDataCollector$RefreshData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */