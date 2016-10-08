package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import xug;

public class PinnedFooterExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  private static final String jdField_a_of_type_JavaLangString = "PinnedFooterExpandableListView";
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public View a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private PinnedFooterExpandableListView.FooterExpandListViewListener jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$FooterExpandListViewListener;
  PinnedFooterExpandableListView.OnLayoutListener jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$OnLayoutListener;
  PinnedHeaderExpandableListView.ExpandableListAdapter jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  public int g;
  
  public PinnedFooterExpandableListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$OnLayoutListener = null;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
    this.g = -1;
    a(paramContext);
  }
  
  public PinnedFooterExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$OnLayoutListener = null;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
    this.g = -1;
    a(paramContext);
  }
  
  public PinnedFooterExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$OnLayoutListener = null;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
    this.g = -1;
    a(paramContext);
  }
  
  private View a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (!(paramView instanceof ViewGroup)) {
      localObject = paramView;
    }
    label58:
    label89:
    label101:
    for (;;)
    {
      return (View)localObject;
      localObject = (ViewGroup)paramView;
      int k = ((ViewGroup)localObject).getChildCount();
      boolean bool = isChildrenDrawingOrderEnabled();
      int i = k - 1;
      int j;
      if (i >= 0) {
        if (bool)
        {
          j = getChildDrawingOrder(k, i);
          paramView = ((ViewGroup)localObject).getChildAt(j);
          if (!a(paramView, paramInt1, paramInt2)) {
            break label89;
          }
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label101;
        }
        return paramView;
        j = i;
        break label58;
        i -= 1;
        break;
        paramView = null;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    return (paramView.isClickable()) && (paramInt2 >= paramView.getTop()) && (paramInt2 <= paramView.getBottom()) && (paramInt1 >= paramView.getLeft()) && (paramInt1 <= paramView.getRight());
  }
  
  private void d()
  {
    Object localObject = a();
    if (!(localObject instanceof PinnedHeaderExpandableListView.ExpandableListAdapter)) {
      return;
    }
    localObject = (PinnedHeaderExpandableListView.ExpandableListAdapter)localObject;
    int i2 = s();
    int k = t();
    int i3 = c(b(k));
    int n = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int i1 = getHeight();
    int i4 = i1 - n;
    int j = k - 2;
    int m = k - 1;
    int i5 = c(b(j));
    int i;
    if (i3 == ((PinnedHeaderExpandableListView.ExpandableListAdapter)localObject).getGroupCount() - 1)
    {
      i = 1;
      label97:
      if ((j < 0) || (i5 == i3)) {
        break label420;
      }
      if (c(b(m)) != i3) {
        break label516;
      }
    }
    label420:
    label516:
    for (j = m;; j = k)
    {
      localObject = getChildAt(j - i2);
      if (i1 - ((View)localObject).getTop() >= n)
      {
        j = i3 + 1;
        if ((this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter != null) && (j < this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.getGroupCount()))
        {
          this.g = j;
          this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, j);
        }
        k = ((View)localObject).getTop() + n;
        j = k;
        if (k < i1 - n) {
          j = i1 - n;
        }
        if (i != 0)
        {
          this.g = -1;
          this.jdField_a_of_type_AndroidViewView.layout(0, -n, this.jdField_a_of_type_Int, -n);
          return;
          i = 0;
          break label97;
        }
        this.jdField_a_of_type_AndroidViewView.layout(0, j, this.jdField_a_of_type_Int, j + n);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter != null) && (i3 < this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.getGroupCount()))
      {
        this.g = i3;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, i3);
      }
      if ((i != 0) && (j != k))
      {
        this.g = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -n, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
        return;
      }
      if (b(b(m)) == 0)
      {
        setFooterEnable(false);
        if (this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$FooterExpandListViewListener != null) {
          this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$FooterExpandListViewListener.a();
        }
        this.g = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -n, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.layout(0, i4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int + i4);
      return;
      if (i != 0)
      {
        this.g = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        i = i3 + 1;
        if ((this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter == null) || (i >= this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.getGroupCount())) {
          break;
        }
        this.g = i;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, i);
        return;
        this.jdField_a_of_type_AndroidViewView.layout(0, i4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int + i4);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    int i;
    do
    {
      ExpandableListAdapter localExpandableListAdapter;
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_Boolean);
        localExpandableListAdapter = a();
      } while (!(localExpandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter));
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)localExpandableListAdapter);
      i = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a();
    } while (i == 0);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new xug(this, this));
    }
    requestLayout();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = b(i, j);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (j >= this.jdField_a_of_type_AndroidViewView.getTop()) && (j <= this.jdField_a_of_type_AndroidViewView.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_b_of_type_AndroidViewView = a(this.jdField_a_of_type_AndroidViewView, i, j);
        this.jdField_b_of_type_Boolean = true;
      }
      while (paramMotionEvent.getAction() != 1) {
        return true;
      }
      if ((a(this.jdField_a_of_type_AndroidViewView, i, j) == this.jdField_b_of_type_AndroidViewView) && (this.jdField_b_of_type_AndroidViewView.isClickable()))
      {
        this.jdField_b_of_type_AndroidViewView.performClick();
        invalidate(new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = false;
        return true;
        if (this.c)
        {
          i = c(b(k));
          if ((i != -1) && (this.jdField_b_of_type_Boolean)) {
            if (e(i)) {
              d(i);
            } else {
              a(i);
            }
          }
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.refreshDrawableState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$OnLayoutListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$OnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      measureChild(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    c();
  }
  
  public void setFooterEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setListener(PinnedFooterExpandableListView.FooterExpandListViewListener paramFooterExpandListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$FooterExpandListViewListener = paramFooterExpandListViewListener;
  }
  
  public void setOnLayoutListener(PinnedFooterExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\PinnedFooterExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */