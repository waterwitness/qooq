package com.tencent.theme;

import android.graphics.Paint;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class b
  extends Drawable.ConstantState
{
  static final Paint a = new Paint();
  static final Paint b = new Paint();
  public static final int c = 0;
  public static final int d = 1;
  static final int f = 0;
  static final int g = 1;
  static final int h = 2;
  int e = 0;
  k i;
  boolean j;
  int[] k;
  
  static
  {
    a.setColor(-65536);
    a.setStrokeWidth(4.0F);
    b.setColor(1358888960);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt3 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\theme\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */