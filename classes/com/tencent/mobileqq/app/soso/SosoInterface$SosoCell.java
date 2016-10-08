package com.tencent.mobileqq.app.soso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SosoInterface$SosoCell
  implements Comparable
{
  public int a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public SosoInterface$SosoCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(SosoCell paramSosoCell)
  {
    return this.d - paramSosoCell.d;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\soso\SosoInterface$SosoCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */