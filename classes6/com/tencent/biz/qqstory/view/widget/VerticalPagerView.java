package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class VerticalPagerView
  extends ViewGroup
{
  protected float a;
  protected Scroller a;
  protected VerticalPagerView.OnPagerChangedListener a;
  protected float b;
  protected float c;
  protected float d;
  protected int h;
  protected int i;
  protected int j;
  protected boolean n;
  protected boolean o;
  
  public VerticalPagerView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.o = true;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  }
  
  public VerticalPagerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = true;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  }
  
  public int a()
  {
    return this.j;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1 - this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), paramInt2 - this.jdField_a_of_type_AndroidWidgetScroller.getFinalY(), paramInt3);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), this.jdField_a_of_type_AndroidWidgetScroller.getFinalY(), paramInt1, paramInt2, paramInt3);
    super.invalidate();
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      super.postInvalidate();
    }
    for (;;)
    {
      super.computeScroll();
      return;
      if ((!this.n) && (this.i != this.j))
      {
        a(this.j);
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener.a(this, getChildAt(this.j), this.j);
        }
        this.i = this.j;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getChildCount() < 2) || (!this.o)) {}
    int k;
    do
    {
      do
      {
        return false;
        k = paramMotionEvent.getAction();
        this.b = paramMotionEvent.getY();
        if (k == 0)
        {
          this.h = ((int)paramMotionEvent.getY());
          this.jdField_a_of_type_Float = this.b;
          this.c = this.b;
          return false;
        }
      } while (k != 2);
      if (Math.abs(this.b - this.jdField_a_of_type_Float) < DisplayUtil.a(getContext(), 10.0F))
      {
        this.h = ((int)paramMotionEvent.getY());
        return false;
      }
      k = (int)(paramMotionEvent.getY() - this.h);
      if (k > 0) {
        return b(this.j);
      }
    } while (k >= 0);
    return a(this.j);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int k = 0;
    int m = 0;
    while (k < i1)
    {
      View localView = getChildAt(k);
      int i2 = paramInt4 - paramInt2;
      localView.layout(0, m, paramInt3 - paramInt1, m + i2);
      m += i2;
      k += 1;
    }
    setCurrentPage(this.j);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int m = getChildCount();
    int k = 0;
    while (k < m)
    {
      measureChild(getChildAt(k), paramInt1, paramInt2);
      k += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    this.b = paramMotionEvent.getY();
    if (k == 0)
    {
      this.h = ((int)paramMotionEvent.getY());
      this.jdField_a_of_type_Float = this.b;
      this.n = true;
      this.c = this.b;
      return true;
    }
    if (k == 2)
    {
      this.h = ((int)(paramMotionEvent.getY() - this.h));
      k = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      if (Math.abs(this.b - this.jdField_a_of_type_Float) < DisplayUtil.a(getContext(), 10.0F))
      {
        this.h = ((int)paramMotionEvent.getY());
        this.d = (this.b - this.c);
        this.c = this.b;
        return false;
      }
      if (k < 0)
      {
        this.h = ((int)paramMotionEvent.getY());
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener.a(false, this.j);
        }
        this.d = (this.b - this.c);
        this.c = this.b;
        return false;
      }
      if (k > (getChildCount() - 1) * getHeight())
      {
        this.h = ((int)paramMotionEvent.getY());
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener.a(false, this.j);
        }
        this.d = (this.b - this.c);
        this.c = this.b;
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, this.jdField_a_of_type_AndroidWidgetScroller.getFinalY(), 0, -this.h, 0);
      this.h = ((int)paramMotionEvent.getY());
      s();
      super.invalidate();
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener.a(true, this.j);
      }
    }
    while ((k != 1) && (k != 3))
    {
      this.d = (this.b - this.c);
      this.c = this.b;
      return super.onTouchEvent(paramMotionEvent);
    }
    float f = Math.abs(this.d);
    this.c = this.b;
    k = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY() - this.j * getHeight();
    if ((k > getHeight() / 4) || ((k > 0) && (f > DisplayUtil.a(getContext(), 7.0F))))
    {
      this.j += 1;
      if (this.j >= getChildCount()) {
        this.j = (getChildCount() - 1);
      }
    }
    for (;;)
    {
      a(0, this.j * getHeight());
      this.h = ((int)paramMotionEvent.getY());
      this.n = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener.a(false, this.j);
      break;
      if ((k < -getHeight() / 4) || ((k < 0) && (f > DisplayUtil.a(getContext(), 5.0F))))
      {
        this.j -= 1;
        if (this.j < 0) {
          this.j = 0;
        }
      }
    }
  }
  
  public void s() {}
  
  public void setCurrentPage(int paramInt)
  {
    this.j = paramInt;
    a(0, this.j * getHeight());
  }
  
  public void setCurrentPage(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    a(0, this.j * getHeight(), paramInt2);
  }
  
  public void setEnableChangePage(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setOnPagerChangedListener(VerticalPagerView.OnPagerChangedListener paramOnPagerChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetVerticalPagerView$OnPagerChangedListener = paramOnPagerChangedListener;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\VerticalPagerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */