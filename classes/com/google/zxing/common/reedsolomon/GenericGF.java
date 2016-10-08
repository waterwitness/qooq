package com.google.zxing.common.reedsolomon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tm;

public final class GenericGF
{
  private static final int jdField_a_of_type_Int = 0;
  public static final GenericGF a;
  private tm jdField_a_of_type_Tm;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private tm jdField_b_of_type_Tm;
  private int[] jdField_b_of_type_ArrayOfInt;
  private final int c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF = new GenericGF(285, 256);
  }
  
  public GenericGF(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramInt2 <= 0) {
      a();
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_b_of_type_Int];
    this.jdField_b_of_type_ArrayOfInt = new int[this.jdField_b_of_type_Int];
    int j = 0;
    int i = 1;
    while (j < this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfInt[j] = i;
      int k = i << 1;
      i = k;
      if (k >= this.jdField_b_of_type_Int) {
        i = (k ^ this.c) & this.jdField_b_of_type_Int - 1;
      }
      j += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_Int - 1)
    {
      this.jdField_b_of_type_ArrayOfInt[this.jdField_a_of_type_ArrayOfInt[i]] = i;
      i += 1;
    }
    this.jdField_a_of_type_Tm = new tm(this, new int[] { 0 });
    this.jdField_b_of_type_Tm = new tm(this, new int[] { 1 });
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  int a(int paramInt)
  {
    b();
    return this.jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public tm a()
  {
    b();
    return this.jdField_a_of_type_Tm;
  }
  
  public tm a(int paramInt1, int paramInt2)
  {
    b();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_Tm;
    }
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new tm(this, arrayOfInt);
  }
  
  public int b(int paramInt)
  {
    b();
    if (paramInt == 0) {
      throw new IllegalArgumentException();
    }
    return this.jdField_b_of_type_ArrayOfInt[paramInt];
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    b();
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfInt[((this.jdField_b_of_type_ArrayOfInt[paramInt1] + this.jdField_b_of_type_ArrayOfInt[paramInt2]) % (this.jdField_b_of_type_Int - 1))];
  }
  
  tm b()
  {
    b();
    return this.jdField_b_of_type_Tm;
  }
  
  public int c(int paramInt)
  {
    b();
    if (paramInt == 0) {
      throw new ArithmeticException();
    }
    return this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int - this.jdField_b_of_type_ArrayOfInt[paramInt] - 1)];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\google\zxing\common\reedsolomon\GenericGF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */