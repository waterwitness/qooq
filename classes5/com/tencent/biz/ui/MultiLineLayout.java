package com.tencent.biz.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MultiLineLayout
  extends ViewGroup
{
  public static boolean a;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
  }
  
  public MultiLineLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiLineLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MultiLineLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(5.0F * this.jdField_a_of_type_Float));
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int b()
  {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = 0;
    paramInt2 = 0;
    int k = getChildCount();
    label28:
    View localView;
    int m;
    int i;
    if (k > 0)
    {
      paramInt1 = 1;
      this.d = paramInt1;
      paramInt4 = 0;
      paramInt1 = 0;
      if (paramInt4 >= k) {
        break label289;
      }
      localView = getChildAt(paramInt4);
      if (((this.e != -1) && (this.d > this.e)) || (localView.getVisibility() == 8)) {
        break label271;
      }
      localView.setVisibility(0);
      m = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
      int j = paramInt3 + m + this.jdField_a_of_type_Int;
      if (j > this.b) {
        break label184;
      }
      localView.layout(paramInt3, paramInt1, m + paramInt3, paramInt1 + i);
      i = (int)Math.max(paramInt2, i + 5.0F * this.jdField_a_of_type_Float);
      paramInt3 = j;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      i = paramInt4 + 1;
      paramInt4 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = i;
      break label28;
      paramInt1 = 0;
      break;
      label184:
      this.d += 1;
      if ((this.e == -1) || (this.d <= this.e))
      {
        paramInt1 += paramInt2;
        localView.layout(0, paramInt1, m, paramInt1 + i);
      }
      for (;;)
      {
        paramInt3 = this.jdField_a_of_type_Int + m;
        i = (int)(i + 5.0F * this.jdField_a_of_type_Float);
        paramInt2 = paramInt1;
        paramInt1 = i;
        break;
        localView.setVisibility(8);
      }
      label271:
      localView.setVisibility(8);
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    label289:
    if (this.c == 0)
    {
      this.c = (paramInt1 + paramInt2);
      return;
    }
    this.c = (paramInt1 + paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    this.b = View.MeasureSpec.getSize(paramInt1);
    measureChildren(paramInt1, paramInt2);
    int i1 = getChildCount();
    int k;
    int j;
    int i;
    label49:
    View localView;
    if (i1 > 0)
    {
      paramInt1 = 1;
      this.d = paramInt1;
      k = 0;
      j = 0;
      paramInt1 = 0;
      i = 0;
      paramInt2 = m;
      if (k >= i1) {
        break label253;
      }
      localView = getChildAt(k);
      if (localView.getVisibility() != 8) {
        break label114;
      }
      m = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
      i = m;
    }
    label114:
    int n;
    for (;;)
    {
      m = k + 1;
      k = i;
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = k;
      k = m;
      break label49;
      paramInt1 = 0;
      break;
      m = localView.getMeasuredHeight();
      if ((this.e != -1) && (this.d > this.e)) {
        break label253;
      }
      n = localView.getMeasuredWidth();
      paramInt2 = this.jdField_a_of_type_Int + (i + n);
      if (paramInt2 > this.b) {
        break label195;
      }
      j = (int)Math.max(j, m + 5.0F * this.jdField_a_of_type_Float);
      i = paramInt1;
      paramInt1 += m;
    }
    label195:
    this.d += 1;
    if ((this.e == -1) || (this.d <= this.e)) {
      paramInt1 += j;
    }
    for (paramInt2 = paramInt1;; paramInt2 = paramInt1)
    {
      n = this.jdField_a_of_type_Int + n;
      j = m;
      i = paramInt2;
      paramInt2 = n;
      break;
      label253:
      setMeasuredDimension(this.b, paramInt2);
      return;
    }
  }
  
  public void setShowLine(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\MultiLineLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */