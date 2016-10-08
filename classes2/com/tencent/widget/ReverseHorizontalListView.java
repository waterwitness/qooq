package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReverseHorizontalListView
  extends HorizontalListView
{
  private boolean a;
  
  public ReverseHorizontalListView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReverseHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_i_of_type_Boolean = true;
    this.k = Integer.MIN_VALUE;
  }
  
  protected void a()
  {
    super.a();
    this.h = getMeasuredWidth();
    this.j = getMeasuredWidth();
    this.jdField_i_of_type_Int = this.h;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 + paramInt2 + this.jdField_g_of_type_Int < getWidth()) && (this.m >= 1))
    {
      this.m -= 1;
      View localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(this.m, a(this.m), this);
      a(localView, 0);
      int i;
      label72:
      int j;
      if (this.m == 0)
      {
        i = 0;
        i = paramInt1 + (i + localView.getMeasuredWidth());
        j = this.f;
        if (getWidth() - (i + paramInt2) != 0) {
          break label129;
        }
      }
      label129:
      for (paramInt1 = localView.getMeasuredWidth();; paramInt1 = this.jdField_g_of_type_Int + localView.getMeasuredWidth())
      {
        this.f = (j - paramInt1);
        paramInt1 = i;
        break;
        i = this.jdField_g_of_type_Int;
        break label72;
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (((paramBoolean) || (paramInt1 + paramInt2 - this.jdField_g_of_type_Int > 0)) && (this.l + 1 < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()))
    {
      this.l += 1;
      if (this.m < 0) {
        this.m = this.l;
      }
      View localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(this.l, a(this.l), this);
      a(localView, -1);
      if (this.l == 0) {}
      for (int i = getWidth() - localView.getMeasuredWidth();; i = -(localView.getMeasuredWidth() + i))
      {
        paramInt1 += i;
        paramBoolean = false;
        break;
        i = this.jdField_g_of_type_Int;
      }
    }
  }
  
  protected View b()
  {
    return getChildAt(getChildCount() - 1);
  }
  
  protected View c()
  {
    return getChildAt(0);
  }
  
  protected void c(int paramInt)
  {
    int j = 0;
    View localView = b();
    int i;
    boolean bool;
    if (localView != null)
    {
      i = localView.getLeft();
      bool = false;
    }
    for (;;)
    {
      a(i, paramInt, bool);
      localView = c();
      i = j;
      if (localView != null) {
        i = localView.getRight();
      }
      a(i, paramInt);
      return;
      bool = true;
      i = 0;
    }
  }
  
  protected boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(this.l))
    {
      View localView = b();
      bool1 = bool2;
      if (localView != null)
      {
        int i = this.k;
        int j = this.h;
        this.k = (localView.getLeft() - getPaddingLeft() + j);
        if (this.k > 0) {
          this.k = 0;
        }
        bool1 = bool2;
        if (this.k != i) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void d(int paramInt)
  {
    View localView = c();
    if ((localView != null) && (localView.getLeft() + paramInt >= getWidth()))
    {
      int j = this.f;
      if (a(this.m)) {}
      for (int i = localView.getMeasuredWidth();; i = this.jdField_g_of_type_Int + localView.getMeasuredWidth())
      {
        this.f = (i + j);
        a(this.m, localView);
        removeViewInLayout(localView);
        this.m += 1;
        localView = c();
        break;
      }
    }
    for (localView = b(); (localView != null) && (localView.getRight() + paramInt <= 0); localView = b())
    {
      a(this.l, localView);
      removeViewInLayout(localView);
      this.l -= 1;
    }
  }
  
  protected void e(int paramInt)
  {
    int j = 0;
    int k = getChildCount();
    if (k > 0)
    {
      if (jdField_g_of_type_Boolean) {
        a("positionChildren", new Object[] { Integer.valueOf(this.f), Integer.valueOf(paramInt), Integer.valueOf(this.f + paramInt) });
      }
      this.f -= paramInt;
      int i = getWidth() - this.f;
      paramInt = j;
      while (paramInt < k)
      {
        View localView = getChildAt(paramInt);
        j = getPaddingRight() + i;
        int m = localView.getMeasuredWidth();
        int n = getPaddingTop();
        localView.layout(j - m, n, j, localView.getMeasuredHeight() + n);
        i -= localView.getMeasuredWidth() + this.jdField_g_of_type_Int;
        paramInt += 1;
      }
    }
  }
  
  public int getFirstVisiblePosition()
  {
    return this.m;
  }
  
  public int getLastVisiblePosition()
  {
    return this.l;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_i_of_type_Boolean))
    {
      this.h = getMeasuredWidth();
      this.j = getMeasuredWidth();
      this.jdField_i_of_type_Int = this.h;
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ReverseHorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */