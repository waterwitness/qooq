package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class AutoFitScrollView
  extends FrameLayout
{
  private static final int jdField_c_of_type_Int = 0;
  private static final int d = 1;
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private AutoFitScroller jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int e;
  private int f;
  private int g;
  
  public AutoFitScrollView(Context paramContext)
  {
    super(paramContext);
    this.e = 0;
    a(paramContext);
  }
  
  public AutoFitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = 0;
    a(paramContext);
  }
  
  public AutoFitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 0;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller = new AutoFitScroller(getContext());
    this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setFitWidth(paramContext.getResources().getDisplayMetrics().widthPixels, 10);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.c(), paramInt1, paramInt2);
    }
    for (;;)
    {
      scrollTo(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.c());
      postInvalidate();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.c(), paramInt1 - this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b(), paramInt2);
    }
  }
  
  public void b()
  {
    setBackgroundColor(-1315602);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b())
    {
      scrollTo(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.c());
      postInvalidate();
    }
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65539);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65540);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
      i = this.jdField_a_of_type_Int - getWidth();
      if (getScrollX() <= i) {
        break label151;
      }
      if (i <= 0) {
        break label159;
      }
    }
    for (;;)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(65540, i, getScrollX() - this.g, Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      this.jdField_a_of_type_Boolean = false;
      return;
      label151:
      i = getScrollX();
      break;
      label159:
      i = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 2) && (this.e != 0)) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (i)
      {
      }
      while (this.e == 0)
      {
        return false;
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a()) {}
        for (i = 0;; i = 1)
        {
          this.e = i;
          break;
        }
        i = (int)(f1 - this.jdField_a_of_type_Float);
        if ((Math.abs((int)(f2 - this.jdField_b_of_type_Float)) < Math.abs(i)) && (Math.abs(i) > this.f))
        {
          this.e = 1;
          continue;
          this.e = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0) {
      getChildAt(0).layout(0, 0, this.jdField_a_of_type_Int, paramInt4 - paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    super.onTouchEvent(paramMotionEvent);
    if (this.jdField_b_of_type_Boolean) {}
    long l;
    do
    {
      return true;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      float f1 = paramMotionEvent.getX();
      paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
      case 0: 
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a();
        }
        this.c = f1;
        this.jdField_a_of_type_Boolean = false;
        this.g = getScrollX();
        return true;
      case 2: 
        scrollBy((int)(this.c - f1), 0);
        this.c = f1;
        this.jdField_a_of_type_Boolean = false;
        l = System.currentTimeMillis();
      }
    } while ((this.jdField_a_of_type_MqqOsMqqHandler == null) || (l - this.jdField_a_of_type_Long <= 50L));
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65539);
    int i = this.jdField_a_of_type_Int - getWidth();
    if (getScrollX() > i) {}
    for (;;)
    {
      if (i > 0) {
        j = i;
      }
      paramMotionEvent = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(65539, j, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramMotionEvent);
      return true;
      i = getScrollX();
    }
    paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
    paramMotionEvent.computeCurrentVelocity(1000);
    int k = (int)paramMotionEvent.getXVelocity();
    boolean bool;
    if (getChildCount() > 0)
    {
      if (Math.abs(k) <= 1000) {
        break label473;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(k);
      i = j;
      if (k > 0) {
        i = -j;
      }
      i = Math.round((i + getScrollX()) / this.jdField_b_of_type_Int);
      j = this.jdField_b_of_type_Int;
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller;
      if (k >= 0) {
        break label436;
      }
      bool = true;
      i = paramMotionEvent.a(bool, Math.abs(j * i - getScrollX()));
      if (i >= 0) {
        break label442;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(getScrollX(), getScrollY(), -i, 0, 0, this.jdField_a_of_type_Int - getWidth(), 0, 0);
      label401:
      postInvalidate();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      this.e = 0;
      this.jdField_a_of_type_Boolean = true;
      return true;
      label436:
      bool = false;
      break;
      label442:
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(getScrollX(), getScrollY(), -i, 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.b(), 0, 0);
      break label401;
      label473:
      i = getScrollX();
      j = Math.max(Math.min(Math.round((i + 0.1F) / this.jdField_b_of_type_Int) * this.jdField_b_of_type_Int, this.jdField_a_of_type_Int - getWidth()), 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScroller.a(i, getScrollY(), j - i, 0);
      postInvalidate();
    }
  }
  
  public void setCallback(MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void setFitWidth(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AutoFitScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */