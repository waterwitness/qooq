package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Arrays;

public class GapDataCollector
{
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private int b;
  
  public GapDataCollector(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private int a(float paramFloat)
  {
    if ((paramFloat > 1.0F) || (paramFloat <= 0.0F)) {
      throw new IndexOutOfBoundsException("the percent out of index");
    }
    int j = (int)(this.jdField_a_of_type_JavaUtilArrayList.size() * paramFloat - 1.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  private long a(int paramInt)
  {
    long[] arrayOfLong = new long[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      arrayOfLong[i] = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
      i += 1;
    }
    Arrays.sort(arrayOfLong);
    return arrayOfLong[paramInt];
  }
  
  public double a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return 0.0D;
    }
    double d = 0.0D;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      d += ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
      i += 1;
    }
    return d / this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      throw new IndexOutOfBoundsException("the container is empty");
    }
    return a(0);
  }
  
  public GapDataCollector.RefreshData a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return new GapDataCollector.RefreshData(-1L, -1L, -1L, -1L, -1L, -1.0D, 0);
    }
    long[] arrayOfLong = new long[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      arrayOfLong[i] = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
      i += 1;
    }
    Arrays.sort(arrayOfLong);
    long l1 = arrayOfLong[a(0.9F)];
    long l2 = arrayOfLong[a(0.8F)];
    long l3 = arrayOfLong[a(0.7F)];
    long l4 = arrayOfLong[0];
    long l5 = arrayOfLong[(arrayOfLong.length - 1)];
    double d = 0.0D;
    i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      d += arrayOfLong[i];
      i += 1;
    }
    return new GapDataCollector.RefreshData(l1, l2, l3, l4, l5, d / arrayOfLong.length, this.b);
  }
  
  public Long a(float paramFloat)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      throw new IndexOutOfBoundsException("the container is empty");
    }
    if ((paramFloat > 1.0F) || (paramFloat <= 0.0F)) {
      throw new IndexOutOfBoundsException("the percent out of index");
    }
    int j = (int)(this.jdField_a_of_type_JavaUtilArrayList.size() * paramFloat - 1.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return Long.valueOf(a(i));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b = 0;
  }
  
  public boolean a(long paramLong)
  {
    while (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.get(i) + " - ");
      i += 1;
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong))) {
      return false;
    }
    this.b += 1;
    return true;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      throw new IndexOutOfBoundsException("the container is empty");
    }
    return a(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\GapDataCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */