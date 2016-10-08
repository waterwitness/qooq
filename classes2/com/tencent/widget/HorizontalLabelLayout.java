package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HorizontalLabelLayout
  extends ViewGroup
{
  private int[] a;
  
  public HorizontalLabelLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected FrameLayout.LayoutParams a()
  {
    return new FrameLayout.LayoutParams(-2, -2, 16);
  }
  
  public FrameLayout.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new FrameLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FrameLayout.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new FrameLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getChildCount();
    int i4 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
    int i5 = getPaddingLeft();
    int i6 = getPaddingTop();
    paramInt4 = 0;
    int j;
    label84:
    View localView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int m;
    int k;
    int i;
    int i1;
    int i2;
    int i7;
    if (((this.a == null) && (i3 > 0)) || ((this.a != null) && (this.a.length < i3)))
    {
      this.a = new int[i3];
      paramInt3 = 0;
      j = 0;
      paramInt1 = 0;
      paramInt2 = 0;
      if (j >= i3) {
        break label396;
      }
      localView = getChildAt(j);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      n = paramInt4;
      m = paramInt3;
      k = paramInt1;
      i = paramInt2;
      if (localView.getVisibility() != 8)
      {
        i = localView.getMeasuredWidth();
        i1 = localView.getMeasuredHeight();
        i = localMarginLayoutParams.leftMargin + i + localMarginLayoutParams.rightMargin;
        i2 = localMarginLayoutParams.topMargin;
        i7 = localMarginLayoutParams.bottomMargin;
        if ((paramInt2 + i <= i4) || (paramInt2 + i - localMarginLayoutParams.rightMargin > i4)) {
          break label346;
        }
        m = localMarginLayoutParams.rightMargin;
        k = paramInt1;
        paramInt1 = paramInt4;
        m = i - m;
        i = paramInt2;
        paramInt4 = k;
        paramInt2 = paramInt3;
        paramInt3 = m;
      }
    }
    for (;;)
    {
      i += paramInt3;
      k = Math.max(paramInt4, i2 + i1 + i7);
      m = paramInt2;
      n = paramInt1;
      if ((j == i3 - 1) && (n < this.a.length)) {
        this.a[n] = k;
      }
      j += 1;
      paramInt4 = n;
      paramInt3 = m;
      paramInt1 = k;
      paramInt2 = i;
      break label84;
      if (this.a == null) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.a.length)
      {
        this.a[paramInt1] = 0;
        paramInt1 += 1;
      }
      break;
      label346:
      if (paramInt2 + i > i4)
      {
        this.a[paramInt4] = paramInt1;
        paramInt2 = paramInt4 + 1;
        k = 0;
        paramInt4 = 0;
        m = paramInt3 + paramInt1;
        paramInt1 = paramInt2;
        paramInt3 = i;
        paramInt2 = m;
        i = k;
        continue;
        label396:
        j = 0;
        i = 0;
        k = 0;
        paramInt4 = 0;
        paramInt3 = 0;
        if (k < i3)
        {
          localView = getChildAt(k);
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
          paramInt1 = i;
          paramInt2 = j;
          n = paramInt4;
          m = paramInt3;
          int i8;
          int i9;
          if (localView.getVisibility() != 8)
          {
            i7 = localView.getMeasuredWidth();
            i8 = localView.getMeasuredHeight();
            i2 = localMarginLayoutParams.leftMargin + i7 + localMarginLayoutParams.rightMargin;
            paramInt1 = localMarginLayoutParams.topMargin;
            i9 = localMarginLayoutParams.bottomMargin + (paramInt1 + i8);
            if ((paramInt3 + i2 <= i4) || (paramInt3 + i2 - localMarginLayoutParams.rightMargin > i4)) {
              break label718;
            }
            m = i2 - localMarginLayoutParams.rightMargin;
            i1 = paramInt3;
            n = paramInt4;
            paramInt2 = j;
            paramInt1 = i;
            label558:
            j = localMarginLayoutParams.leftMargin + (i5 + i1);
            paramInt4 = i6 + paramInt2 + localMarginLayoutParams.topMargin;
            m = i1 + m;
            n = Math.max(n, i9);
            if (((localMarginLayoutParams instanceof FrameLayout.LayoutParams)) && (paramInt1 < this.a.length))
            {
              i = ((FrameLayout.LayoutParams)localMarginLayoutParams).gravity;
              paramInt3 = i;
              if (i == -1) {
                paramInt3 = 16;
              }
            }
            switch (paramInt3 & 0x70)
            {
            default: 
              paramInt3 = paramInt4;
            }
          }
          for (;;)
          {
            localView.layout(j, paramInt3, j + i7, paramInt3 + i8);
            k += 1;
            i = paramInt1;
            j = paramInt2;
            paramInt4 = n;
            paramInt3 = m;
            break;
            label718:
            paramInt1 = i;
            m = i2;
            paramInt2 = j;
            n = paramInt4;
            i1 = paramInt3;
            if (paramInt3 + i2 <= i4) {
              break label558;
            }
            paramInt2 = j + paramInt4;
            paramInt1 = i + 1;
            n = 0;
            i1 = 0;
            m = i2;
            break label558;
            paramInt3 = (this.a[paramInt1] - i9) / 2 + paramInt4;
            continue;
            paramInt3 = this.a[paramInt1] - i9 + paramInt4;
          }
        }
      }
      else
      {
        k = paramInt3;
        m = paramInt1;
        n = paramInt2;
        paramInt1 = paramInt4;
        paramInt3 = i;
        paramInt2 = k;
        paramInt4 = m;
        i = n;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = getChildCount();
    int i3 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    int n = 0;
    int i1;
    if (n < i2)
    {
      View localView = getChildAt(n);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      if (localView.getVisibility() == 8) {
        break label300;
      }
      measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      i1 = localView.getMeasuredWidth();
      int i4 = localView.getMeasuredHeight();
      i1 = i1 + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i5 = localMarginLayoutParams.topMargin;
      int i6 = localMarginLayoutParams.bottomMargin;
      if ((m + i1 > i3) && (m + i1 - localMarginLayoutParams.rightMargin <= i3))
      {
        i1 -= localMarginLayoutParams.rightMargin;
        label156:
        m += i1;
        k = Math.max(k, i4 + i5 + i6);
      }
    }
    label300:
    for (;;)
    {
      n += 1;
      break;
      if (m + i1 > i3)
      {
        j = Math.max(j, m);
        i += k;
        k = 0;
        m = 0;
        break label156;
        j = Math.max(j, m);
        m = getPaddingLeft();
        n = getPaddingRight();
        i = Math.max(i + k + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSize(Math.max(j + (m + n), getSuggestedMinimumWidth()), paramInt1), resolveSize(i, paramInt2));
        return;
      }
      break label156;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\HorizontalLabelLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */