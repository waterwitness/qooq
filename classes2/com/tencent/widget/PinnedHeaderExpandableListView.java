package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import xuj;

public class PinnedHeaderExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  private static final int jdField_a_of_type_Int = -1;
  private static final int jdField_b_of_type_Int = 0;
  private static final int g = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ExpandableListView.OnGroupClickListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener;
  private PinnedHeaderExpandableListView.ExpandableListAdapter jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter;
  private PinnedHeaderExpandableListView.OnLayoutListener jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private int h;
  private int i;
  private int j;
  
  public PinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = 0;
    this.j = -1;
    a(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = 0;
    this.j = -1;
    a(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.h = 0;
    this.j = -1;
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int k = b(b(paramInt));
    int m;
    if (k != 2) {
      if (k == 0) {
        if ((b(b(paramInt + 1)) == 0) || (b(b(paramInt + 1)) == 2))
        {
          this.h = -1;
          if (this.h == -1) {
            break label307;
          }
          if (this.h != 1) {
            break label299;
          }
          View localView = getChildAt(1);
          m = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
          if (localView == null) {
            break label293;
          }
          k = localView.getTop();
        }
      }
    }
    label94:
    label293:
    label299:
    for (this.i = (m - k);; this.i = 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramInt = c(b(paramInt));
      if ((paramInt != this.j) || (paramBoolean) || (this.b))
      {
        this.b = false;
        this.j = paramInt;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), 1073741824);
        k = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
        this.jdField_a_of_type_AndroidViewView.measure(paramInt, k);
        this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      }
      return;
      this.h = 0;
      break;
      if (getChildAt(0).getBottom() > this.jdField_a_of_type_AndroidViewView.getMeasuredHeight())
      {
        this.h = 0;
        break;
      }
      if (b(b(paramInt + 1)) == 0)
      {
        this.h = 1;
        break;
      }
      this.h = 0;
      break;
      this.h = -1;
      break;
      k = 0;
      break label94;
    }
    label307:
    if (paramBoolean) {
      this.b = true;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  private void c(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int k = 0;
      while (k < localViewGroup.getChildCount())
      {
        c(localViewGroup.getChildAt(k));
        k += 1;
      }
    }
    paramView.refreshDrawableState();
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
      a(paramInt1, false);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.i);
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
      paramCanvas.restore();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent))) {}
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          this.jdField_a_of_type_Boolean = false;
        }
        return bool;
      }
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (f1 >= 0.0F) && (f1 <= this.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.i) && (paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      c(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public View e()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(s(), true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      measureChild(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int k = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a();
      if (k != 0)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(k, this, false);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new xuj(this));
        }
        requestLayout();
      }
    }
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = paramOnGroupClickListener;
    super.setOnGroupClickListener(paramOnGroupClickListener);
  }
  
  public void setOnLayoutListener(PinnedHeaderExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\PinnedHeaderExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */