package com.tencent.av.opengl.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class IntArray
{
  private static final int jdField_a_of_type_Int = 8;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int b;
  
  public IntArray()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new int[8];
  }
  
  public int a()
  {
    this.b -= 1;
    return this.a[this.b];
  }
  
  public void a()
  {
    this.b = 0;
    if (this.a.length != 8) {
      this.a = new int[8];
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.length == this.b)
    {
      arrayOfInt = new int[this.b + this.b];
      System.arraycopy(this.a, 0, arrayOfInt, 0, this.b);
      this.a = arrayOfInt;
    }
    int[] arrayOfInt = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  public int[] a()
  {
    return this.a;
  }
  
  public int[] a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.b) {}
    }
    else
    {
      arrayOfInt = new int[this.b];
    }
    System.arraycopy(this.a, 0, arrayOfInt, 0, this.b);
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\utils\IntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */