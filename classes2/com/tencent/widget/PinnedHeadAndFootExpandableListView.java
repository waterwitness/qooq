package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import xuh;
import xui;

public class PinnedHeadAndFootExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  private static final String jdField_a_of_type_JavaLangString = "PinnedHeadAndFootExpandableListView";
  static final int g = -1;
  static final int h = 0;
  static final int i = 1;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public View a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  public ExpandableListView.OnGroupClickListener a;
  public PinnedHeadAndFootExpandableListView.ExpandableListAdapter a;
  public PinnedHeadAndFootExpandableListView.FooterExpandListViewListener a;
  PinnedHeadAndFootExpandableListView.OnLayoutListener jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean;
  boolean d;
  private boolean e;
  int j;
  int k;
  int l;
  public int m;
  public int n;
  
  public PinnedHeadAndFootExpandableListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    this.j = 0;
    this.k = 0;
    this.l = -1;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener = null;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = null;
    this.m = -1;
    a(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    this.j = 0;
    this.k = 0;
    this.l = -1;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener = null;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = null;
    this.m = -1;
    a(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    this.j = 0;
    this.k = 0;
    this.l = -1;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener = null;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = null;
    this.m = -1;
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
      int i3 = ((ViewGroup)localObject).getChildCount();
      boolean bool = isChildrenDrawingOrderEnabled();
      int i1 = i3 - 1;
      int i2;
      if (i1 >= 0) {
        if (bool)
        {
          i2 = getChildDrawingOrder(i3, i1);
          paramView = ((ViewGroup)localObject).getChildAt(i2);
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
        i2 = i1;
        break label58;
        i1 -= 1;
        break;
        paramView = null;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter != null) && (this.jdField_a_of_type_AndroidViewView != null) && (paramInt < this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.getGroupCount()))
    {
      this.m = paramInt;
      if (paramInt < 1) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i1 = ExpandableListView.b(b(paramInt));
    int i2;
    if (i1 != 2) {
      if (i1 == 0) {
        if ((ExpandableListView.b(b(paramInt + 1)) == 0) || (ExpandableListView.b(b(paramInt + 1)) == 2))
        {
          this.j = -1;
          if (this.j == -1) {
            break label309;
          }
          if (this.j != 1) {
            break label301;
          }
          View localView = getChildAt(1);
          i2 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
          if (localView == null) {
            break label295;
          }
          i1 = localView.getTop();
        }
      }
    }
    label94:
    label295:
    label301:
    for (this.k = (i2 - i1);; this.k = 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramInt = ExpandableListView.c(b(paramInt));
      if ((paramInt != this.l) || (paramBoolean) || (this.e))
      {
        this.e = false;
        this.l = paramInt;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.a(this.jdField_b_of_type_AndroidViewView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_AndroidViewView.getMeasuredWidth(), 1073741824);
        i1 = View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
        this.jdField_b_of_type_AndroidViewView.measure(paramInt, i1);
        this.jdField_b_of_type_AndroidViewView.layout(0, 0, this.jdField_b_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_b_of_type_AndroidViewView.getMeasuredHeight());
      }
      return;
      this.j = 0;
      break;
      if (getChildAt(0).getBottom() > this.jdField_b_of_type_AndroidViewView.getMeasuredHeight())
      {
        this.j = 0;
        break;
      }
      if (ExpandableListView.b(b(paramInt + 1)) == 0)
      {
        this.j = 1;
        break;
      }
      this.j = 0;
      break;
      this.j = -1;
      break;
      i1 = 0;
      break label94;
    }
    label309:
    if (paramBoolean) {
      this.e = true;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
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
  
  private void c(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = 0;
      while (i1 < localViewGroup.getChildCount())
      {
        c(localViewGroup.getChildAt(i1));
        i1 += 1;
      }
    }
    paramView.refreshDrawableState();
  }
  
  private void d()
  {
    setFooterEnable(false);
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$FooterExpandListViewListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$FooterExpandListViewListener.a();
    }
  }
  
  public int a(int paramInt)
  {
    int i1 = this.n + paramInt;
    int i3 = i1;
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter != null)
    {
      int i2 = 0;
      for (;;)
      {
        i3 = i1;
        if (i2 >= paramInt) {
          break;
        }
        i3 = i1;
        if (e(i2)) {
          i3 = i1 + this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.getChildrenCount(i2);
        }
        i2 += 1;
        i1 = i3;
      }
    }
    return i3;
  }
  
  public void a(View paramView)
  {
    this.n = 1;
    super.a(paramView);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      a(paramInt1, false);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      c();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean a(View paramView)
  {
    this.n = 0;
    return super.a(paramView);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PinnedHeadAndFootExpandableListView", 2, "mHeaderView null");
      }
    }
    do
    {
      return;
      localObject = super.a();
      if ((localObject instanceof PinnedHeadAndFootExpandableListView.ExpandableListAdapter)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PinnedHeadAndFootExpandableListView", 2, "object null");
    return;
    Object localObject = (PinnedHeadAndFootExpandableListView.ExpandableListAdapter)localObject;
    int i7 = s();
    int i3 = t();
    int i8 = ExpandableListView.c(b(i3));
    int i5 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int i6 = getHeight();
    int i9 = i6 - i5;
    int i2 = i3 - 2;
    int i4 = i3 - 1;
    int i10 = ExpandableListView.c(b(i2));
    int i1;
    if (i8 == ((PinnedHeadAndFootExpandableListView.ExpandableListAdapter)localObject).getGroupCount() - 1)
    {
      i1 = 1;
      if ((i2 < 0) || (i10 == i8)) {
        break label377;
      }
      if (ExpandableListView.c(b(i4)) != i8) {
        break label441;
      }
    }
    label377:
    label441:
    for (i2 = i4;; i2 = i3)
    {
      localObject = getChildAt(i2 - i7);
      if (i6 - ((View)localObject).getTop() >= i5)
      {
        a(i8 + 1);
        i3 = ((View)localObject).getTop() + i5;
        i2 = i3;
        if (i3 < i6 - i5) {
          i2 = i6 - i5;
        }
        if (i1 != 0)
        {
          this.m = -1;
          this.jdField_a_of_type_AndroidViewView.layout(0, -i5, this.jdField_a_of_type_Int, -i5);
          return;
          i1 = 0;
          break;
        }
        this.jdField_a_of_type_AndroidViewView.layout(0, i2, this.jdField_a_of_type_Int, i2 + i5);
        return;
      }
      a(i8);
      if ((i1 != 0) && (i2 != i3))
      {
        this.m = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -i5, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
        return;
      }
      if (ExpandableListView.b(b(i4)) == 0)
      {
        d();
        this.m = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -i5, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.layout(0, i9, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int + i9);
      return;
      if (i1 != 0)
      {
        this.m = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        a(i8 + 1);
        return;
        this.jdField_a_of_type_AndroidViewView.layout(0, i9, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int + i9);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.k);
      drawChild(paramCanvas, this.jdField_b_of_type_AndroidViewView, getDrawingTime());
      paramCanvas.restore();
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = (int)f1;
    int i2 = (int)f2;
    int i3 = b(i1, i2);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (i2 >= this.jdField_a_of_type_AndroidViewView.getTop()) && (i2 <= this.jdField_a_of_type_AndroidViewView.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_c_of_type_AndroidViewView = a(this.jdField_a_of_type_AndroidViewView, i1, i2);
        this.jdField_c_of_type_Boolean = true;
      }
      while (paramMotionEvent.getAction() != 1) {
        return true;
      }
      if ((a(this.jdField_a_of_type_AndroidViewView, i1, i2) == this.jdField_c_of_type_AndroidViewView) && (this.jdField_c_of_type_AndroidViewView.isClickable()))
      {
        this.jdField_c_of_type_AndroidViewView.performClick();
        invalidate(new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        return true;
        if ((!this.d) || (ExpandableListView.c(b(i3)) == -1) || (!this.jdField_c_of_type_Boolean)) {}
      }
    }
    this.jdField_c_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent))) {}
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          this.jdField_a_of_type_Boolean = false;
        }
        return bool;
      }
    }
    if ((this.jdField_b_of_type_AndroidViewView != null) && (f1 >= 0.0F) && (f1 <= this.jdField_b_of_type_AndroidViewView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.jdField_b_of_type_AndroidViewView.getMeasuredHeight() - this.k) && (paramMotionEvent.getAction() == 0) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_b_of_type_AndroidViewView != null) {
      c(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      c(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      a(s(), true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      measureChild(this.jdField_b_of_type_AndroidViewView, paramInt1, paramInt2);
    }
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
    if ((paramExpandableListAdapter instanceof PinnedHeadAndFootExpandableListView.ExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter = ((PinnedHeadAndFootExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int i1 = this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.a();
      if (i1 != 0)
      {
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i1, this, false);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          this.jdField_b_of_type_AndroidViewView.setTag("headerView");
          this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new xuh(this));
        }
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView == null))
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i1, this, false);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            this.jdField_a_of_type_AndroidViewView.setTag("footerView");
            this.jdField_a_of_type_AndroidViewView.setOnClickListener(new xui(this, this));
          }
        }
        requestLayout();
      }
    }
  }
  
  public void setFooterEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setFooterListener(PinnedHeadAndFootExpandableListView.FooterExpandListViewListener paramFooterExpandListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$FooterExpandListViewListener = paramFooterExpandListViewListener;
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = paramOnGroupClickListener;
    super.setOnGroupClickListener(paramOnGroupClickListener);
  }
  
  public void setOnLayoutListener(PinnedHeadAndFootExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\PinnedHeadAndFootExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */