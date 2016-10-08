package com.tencent.mobileqq.businessCard.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class BusinessCardViewTouchHandler
{
  public static final int a = 32;
  public static final int b = 128;
  static int jdField_c_of_type_Int = -1;
  float jdField_a_of_type_Float;
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  BusinessCardChildView jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardChildView = null;
  BusinessCardView jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView;
  BusinessCardViewScroller jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller;
  boolean jdField_a_of_type_Boolean;
  float b;
  float jdField_c_of_type_Float;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  int f;
  int g;
  int h = jdField_c_of_type_Int;
  int i;
  int j;
  int k;
  private int l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BusinessCardViewTouchHandler(Context paramContext, BusinessCardView paramBusinessCardView, BusinessCardViewScroller paramBusinessCardViewScroller)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.i = paramContext.getScaledMinimumFlingVelocity();
    this.j = paramContext.getScaledMaximumFlingVelocity();
    this.k = paramContext.getScaledTouchSlop();
    this.jdField_d_of_type_Float = paramContext.getScaledPagingTouchSlop();
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView = paramBusinessCardView;
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller = paramBusinessCardViewScroller;
  }
  
  MotionEvent a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
    paramMotionEvent.setLocation(0.0F, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a()));
    return paramMotionEvent;
  }
  
  BusinessCardChildView a(int paramInt1, int paramInt2)
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getChildCount() - 1;
    while (m >= 0)
    {
      BusinessCardChildView localBusinessCardChildView = (BusinessCardChildView)this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getChildAt(m);
      if ((localBusinessCardChildView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(paramInt1, paramInt2, localBusinessCardChildView))) {
        return localBusinessCardChildView;
      }
      m -= 1;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getChildCount() > 0) {}
    for (int m = 1; m == 0; m = 0) {
      return false;
    }
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.d();
    boolean bool1;
    if (BusinessCardUtils.a(11)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.jdField_a_of_type_AndroidAnimationObjectAnimator != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()))
      {
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard", 2, "onInterceptTouchEvent hasScrollAnimator:" + bool1 + " wasScrolling:" + bool2);
        }
        if ((!bool2) && (!bool1)) {
          break label184;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      label124:
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        if ((!bool1) && (!this.jdField_a_of_type_Boolean)) {
          break label486;
        }
        return true;
        bool1 = false;
        break;
        label184:
        bool1 = false;
        break label124;
        m = (int)paramMotionEvent.getX();
        this.f = m;
        this.jdField_d_of_type_Int = m;
        m = (int)paramMotionEvent.getY();
        this.g = m;
        this.jdField_e_of_type_Int = m;
        float f1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.g);
        this.b = f1;
        this.jdField_a_of_type_Float = f1;
        this.h = paramMotionEvent.getPointerId(0);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardChildView = a(this.f, this.g);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.c();
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b();
        a();
        paramMotionEvent = a(paramMotionEvent);
        this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        paramMotionEvent.recycle();
        continue;
        if (this.h != jdField_c_of_type_Int)
        {
          b();
          MotionEvent localMotionEvent = a(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(localMotionEvent);
          localMotionEvent.recycle();
          int n = paramMotionEvent.findPointerIndex(this.h);
          m = (int)paramMotionEvent.getY(n);
          n = (int)paramMotionEvent.getX(n);
          if (Math.abs(m - this.jdField_e_of_type_Int) > this.k)
          {
            this.jdField_a_of_type_Boolean = true;
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getParent();
            if (paramMotionEvent != null) {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            }
          }
          this.f = n;
          this.g = m;
          this.b = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.g);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
          this.jdField_a_of_type_Boolean = false;
          this.h = jdField_c_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardChildView = null;
          this.jdField_c_of_type_Float = 0.0F;
          c();
        }
      }
      label486:
      break;
      bool1 = bool2;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    int n = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getChildCount() > 0) {}
    for (int m = 1; m == 0; m = 0) {
      return false;
    }
    b();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
    case 1: 
    case 6: 
      for (;;)
      {
        return true;
        m = (int)paramMotionEvent.getX();
        this.f = m;
        this.jdField_d_of_type_Int = m;
        m = (int)paramMotionEvent.getY();
        this.g = m;
        this.jdField_e_of_type_Int = m;
        float f1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.g);
        this.b = f1;
        this.jdField_a_of_type_Float = f1;
        this.h = paramMotionEvent.getPointerId(0);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardChildView = a(this.f, this.g);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.c();
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b();
        a();
        paramMotionEvent = a(paramMotionEvent);
        this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        paramMotionEvent.recycle();
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getParent();
        if (paramMotionEvent != null) {
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
        }
        this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
        this.l = BusinessCardViewScroller.jdField_c_of_type_Int;
        continue;
        m = paramMotionEvent.getActionIndex();
        this.h = paramMotionEvent.getPointerId(m);
        this.f = ((int)paramMotionEvent.getX(m));
        this.g = ((int)paramMotionEvent.getY(m));
        this.b = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.g);
        this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
        this.l = BusinessCardViewScroller.jdField_c_of_type_Int;
        continue;
        if (this.h != jdField_c_of_type_Int)
        {
          MotionEvent localMotionEvent = a(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(localMotionEvent);
          localMotionEvent.recycle();
          n = paramMotionEvent.findPointerIndex(this.h);
          m = (int)paramMotionEvent.getX(n);
          n = (int)paramMotionEvent.getY(n);
          int i1 = Math.abs(n - this.jdField_e_of_type_Int);
          f1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(n);
          float f2 = this.b - f1;
          if ((!this.jdField_a_of_type_Boolean) && (i1 > this.k))
          {
            this.jdField_a_of_type_Boolean = true;
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getParent();
            if (paramMotionEvent != null) {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            }
          }
          f1 = f2;
          if (this.jdField_a_of_type_Boolean)
          {
            float f3 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
            float f4 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b(f3 + f2);
            f1 = f2;
            if (Float.compare(f4, 0.0F) != 0) {
              f1 = f2 * (1.0F - Math.min(0.0875F, f4) / 0.0875F);
            }
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(f3 + f1);
          }
          this.f = m;
          this.g = n;
          this.b = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.g);
          f2 = this.jdField_c_of_type_Float;
          this.jdField_c_of_type_Float = (Math.abs(f1) + f2);
          f1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a() - this.jdField_e_of_type_Float;
          if (f1 > 0.05F) {
            this.l = BusinessCardViewScroller.jdField_a_of_type_Int;
          }
          for (;;)
          {
            this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
            break;
            if (f1 < -0.05F) {
              this.l = BusinessCardViewScroller.b;
            } else {
              this.l = BusinessCardViewScroller.jdField_c_of_type_Int;
            }
          }
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.j);
          m = (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(this.h);
          if ((this.jdField_a_of_type_Boolean) && (Math.abs(m) > this.i))
          {
            n = (int)(Math.min(1.0F, Math.abs(m / this.j)) * 96.0F);
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.jdField_a_of_type_AndroidWidgetOverScroller.fling(0, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a()), 0, m, 0, 0, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().b), this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().jdField_c_of_type_Float), 0, n + 32);
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.c();
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.invalidate();
          }
          for (;;)
          {
            this.h = jdField_c_of_type_Int;
            this.jdField_a_of_type_Boolean = false;
            this.jdField_c_of_type_Float = 0.0F;
            c();
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b())
            {
              this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.l);
              this.l = BusinessCardViewScroller.jdField_c_of_type_Int;
            }
          }
          i1 = paramMotionEvent.getActionIndex();
          if (paramMotionEvent.getPointerId(i1) == this.h)
          {
            m = n;
            if (i1 == 0) {
              m = 1;
            }
            this.h = paramMotionEvent.getPointerId(m);
            this.f = ((int)paramMotionEvent.getX(m));
            this.g = ((int)paramMotionEvent.getY(m));
            this.b = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.g);
            this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b()) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
    }
    for (;;)
    {
      this.h = jdField_c_of_type_Int;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Float = 0.0F;
      c();
      break;
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.l);
      this.l = BusinessCardViewScroller.jdField_c_of_type_Int;
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if ((paramMotionEvent.getSource() & 0x2) == 2) {}
    boolean bool1;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!BusinessCardUtils.a(12));
        if (paramMotionEvent.getAxisValue(9) <= 0.0F) {
          break;
        }
        bool1 = bool2;
      } while (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a());
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(true, false);
      return true;
      bool1 = bool2;
    } while (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a());
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(false, false);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\views\BusinessCardViewTouchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */