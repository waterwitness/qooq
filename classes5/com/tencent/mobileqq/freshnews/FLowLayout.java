package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FLowLayout
  extends ViewGroup
{
  public FLowLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FLowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FLowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getWidth();
    paramInt1 = 0;
    paramInt2 = 0;
    paramInt3 = 0;
    int k = getChildCount();
    paramInt4 = 0;
    while (paramInt4 < k)
    {
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8)
      {
        paramInt4 += 1;
      }
      else
      {
        int m = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        int i = localMarginLayoutParams.topMargin + n + localMarginLayoutParams.bottomMargin;
        if (localMarginLayoutParams.leftMargin + paramInt1 + m + localMarginLayoutParams.rightMargin > j)
        {
          paramInt2 += paramInt3;
          paramInt1 = 0;
        }
        for (paramInt3 = i;; paramInt3 = Math.max(paramInt3, i))
        {
          localView.layout(localMarginLayoutParams.leftMargin + paramInt1, localMarginLayoutParams.topMargin + paramInt2, localMarginLayoutParams.leftMargin + paramInt1 + m, n + (localMarginLayoutParams.topMargin + paramInt2));
          i = localMarginLayoutParams.leftMargin;
          paramInt1 += localMarginLayoutParams.rightMargin + (i + m);
          break;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    measureChildren(paramInt1, paramInt2);
    paramInt1 = 0;
    paramInt2 = 0;
    int i = 0;
    int j = 0;
    int i6 = getChildCount();
    int n = 0;
    if (n < i6)
    {
      Object localObject = getChildAt(n);
      int k = ((View)localObject).getMeasuredWidth();
      int m = ((View)localObject).getMeasuredHeight();
      localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      k = k + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      int i3 = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      i3 = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + (m + i3);
      if (i + k > i1)
      {
        m = Math.max(i, k);
        paramInt1 = i3;
        i = k;
        k = paramInt2 + j;
        j = paramInt1;
        label156:
        paramInt2 = k;
        paramInt1 = m;
        if (n == i6 - 1)
        {
          paramInt1 = Math.max(i, m);
          paramInt2 = k + j;
        }
        if (i4 != 1073741824) {
          break label249;
        }
        k = i1;
        label196:
        if (i5 != 1073741824) {
          break label255;
        }
      }
      label249:
      label255:
      for (m = i2;; m = paramInt2)
      {
        setMeasuredDimension(k, m);
        n += 1;
        break;
        j = Math.max(j, i3);
        i = k + i;
        k = paramInt2;
        m = paramInt1;
        break label156;
        k = paramInt1;
        break label196;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FLowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */