package com.tencent.mobileqq.gesturelock;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Array;

public class LockPatternView$Cell
{
  static Cell[][] jdField_a_of_type_Array2dOfComTencentMobileqqGesturelockLockPatternView$Cell;
  int jdField_a_of_type_Int;
  int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Array2dOfComTencentMobileqqGesturelockLockPatternView$Cell = (Cell[][])Array.newInstance(Cell.class, new int[] { 3, 3 });
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        jdField_a_of_type_Array2dOfComTencentMobileqqGesturelockLockPatternView$Cell[i][j] = new Cell(i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private LockPatternView$Cell(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static Cell a(int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt1, paramInt2);
      Cell localCell = jdField_a_of_type_Array2dOfComTencentMobileqqGesturelockLockPatternView$Cell[paramInt1][paramInt2];
      return localCell;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 2)) {
      throw new IllegalArgumentException("row must be in range 0-2");
    }
    if ((paramInt2 < 0) || (paramInt2 > 2)) {
      throw new IllegalArgumentException("column must be in range 0-2");
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "(row=" + this.jdField_a_of_type_Int + ",clmn=" + this.b + ")";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\gesturelock\LockPatternView$Cell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */