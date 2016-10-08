package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;

public class TroopSidesSlippingMaker
  implements Handler.Callback
{
  public static final byte a = 0;
  public static final int a = -3;
  public static final String a = "TroopFileExpandableListView";
  public static final byte b = 1;
  public static final int b = 0;
  public static final byte c = 2;
  public static final int c = 1;
  public static final int d = 300;
  private static final int e = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private TroopSidesSlippingMaker.SlidingListener jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener;
  private TroopSidesSlippingMaker.SuperTouchListener jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private byte d;
  private final int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public TroopSidesSlippingMaker(Context paramContext, ListView paramListView, TroopSidesSlippingMaker.SuperTouchListener paramSuperTouchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener = paramSuperTouchListener;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new TroopSidesSlippingMaker.SmoothInterpolator());
    paramContext = ViewConfiguration.get(paramContext);
    this.f = paramContext.getScaledTouchSlop();
    this.g = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.i = -1;
    this.k = -1;
    this.j = -1;
    this.l = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private int a()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    return (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int m = 300;
    if (paramInt1 > 0) {
      m = (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return m;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.k;
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(true);
        }
        this.jdField_a_of_type_Boolean = true;
      }
      paramView.scrollTo(paramInt3, 0);
      return;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = paramInt1;
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {}
    for (int m = paramView.getScrollX();; m = 0)
    {
      if (m != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label104;
        }
      }
      label104:
      for (int n = ((Integer)paramView.getTag(-3)).intValue();; n = 0)
      {
        if ((this.jdField_c_of_type_AndroidViewView != paramView) && (this.jdField_c_of_type_AndroidViewView != null)) {
          this.jdField_c_of_type_AndroidViewView.scrollTo(0, 0);
        }
        d();
        this.jdField_c_of_type_AndroidViewView = paramView;
        int i1 = -m;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(m, 0, i1, 0, a(n, i1));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  private boolean a(float paramFloat)
  {
    return paramFloat < this.jdField_a_of_type_ComTencentWidgetListView.getWidth() - this.h;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.f) || (paramFloat2 > this.f))
    {
      if ((paramFloat1 > this.f) && (paramFloat2 / paramFloat1 < 0.6F))
      {
        this.d = 1;
        return true;
      }
      this.d = 2;
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.f);
  }
  
  private void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int n = paramView.getScrollX();
    int m = this.h;
    if ((m == 0) && ((paramView.getTag(-3) instanceof Integer))) {
      m = ((Integer)paramView.getTag(-3)).intValue();
    }
    for (;;)
    {
      if (n != m)
      {
        if ((this.jdField_c_of_type_AndroidViewView != paramView) && (this.jdField_c_of_type_AndroidViewView != null)) {
          this.jdField_c_of_type_AndroidViewView.scrollTo(0, 0);
        }
        d();
        this.jdField_c_of_type_AndroidViewView = paramView;
        int i1 = m - n;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(n, 0, i1, 0, a(m, i1));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(paramView);
      }
      if ((!AppSetting.j) || (!(paramView instanceof LinearLayout))) {
        break;
      }
      paramView = (LinearLayout)paramView;
      paramView = paramView.getChildAt(paramView.getChildCount() - 1);
      if (paramView == null) {
        break;
      }
      paramView.sendAccessibilityEvent(8);
      return;
    }
  }
  
  private void c()
  {
    int m = a();
    int n = this.jdField_b_of_type_AndroidViewView.getScrollX();
    if (m > this.g)
    {
      a(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (m < -this.g)
    {
      b(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((m > 0) && (n < this.h * 0.7F))
    {
      a(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((m < 0) && (n > this.h * 0.3F))
    {
      b(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((this.jdField_c_of_type_Boolean) && (n < this.h * 0.7F))
    {
      a(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (n > this.h * 0.3F)
    {
      b(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    a(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_c_of_type_AndroidViewView = null;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a()
  {
    int m;
    int n;
    if (!a(this.jdField_b_of_type_AndroidViewView))
    {
      m = this.jdField_a_of_type_ComTencentWidgetListView.s() - this.jdField_a_of_type_ComTencentWidgetListView.m();
      n = this.jdField_a_of_type_ComTencentWidgetListView.t();
    }
    for (;;)
    {
      if (m <= n)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(m);
        if (a(localView)) {
          this.jdField_b_of_type_AndroidViewView = localView;
        }
      }
      else
      {
        a(this.jdField_b_of_type_AndroidViewView);
        return;
      }
      m += 1;
    }
  }
  
  public void a(TroopSidesSlippingMaker.SlidingListener paramSlidingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener = paramSlidingListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!this.jdField_b_of_type_Boolean) {
      a();
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.a(paramMotionEvent);
      return bool2;
    }
    int n = (int)(paramMotionEvent.getX() + 0.5F);
    int m = (int)(paramMotionEvent.getY() + 0.5F);
    int i1 = paramMotionEvent.getAction();
    label80:
    boolean bool1;
    switch (i1)
    {
    default: 
      bool1 = false;
      label83:
      if ((i1 == 0) && (this.jdField_c_of_type_Boolean))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(true);
        }
        d();
      }
      break;
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.a(paramMotionEvent);
      this.d = 0;
      this.i = n;
      this.k = n;
      this.j = m;
      this.l = m;
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_AndroidViewView);
      int i2;
      int i3;
      if (!this.jdField_c_of_type_Boolean)
      {
        i2 = this.jdField_a_of_type_ComTencentWidgetListView.s();
        i3 = this.jdField_a_of_type_ComTencentWidgetListView.m();
        m = this.jdField_a_of_type_ComTencentWidgetListView.t();
      }
      for (;;)
      {
        if (m >= i2 - i3)
        {
          View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(m);
          this.jdField_c_of_type_Boolean = a(localView);
          if (this.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_AndroidViewView = localView;
          }
        }
        else
        {
          this.h = 0;
          this.jdField_b_of_type_AndroidViewView = null;
          m = this.j;
          if (this.jdField_a_of_type_ComTencentWidgetListView.c()) {
            m = this.j + this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
          }
          m = this.jdField_a_of_type_ComTencentWidgetListView.b(this.i, m);
          if (m >= 0)
          {
            this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(m - this.jdField_a_of_type_ComTencentWidgetListView.s());
            if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView.getTag(-3) instanceof Integer))) {
              this.h = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(-3)).intValue();
            }
          }
          if ((!this.jdField_c_of_type_Boolean) || ((this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView) && (!a(n)))) {
            break label412;
          }
          bool1 = true;
          break;
        }
        m -= 1;
      }
      label412:
      bool1 = false;
      break label83;
      if ((this.h > 0) && (this.d == 0)) {
        a(Math.abs(n - this.i), Math.abs(m - this.j));
      }
      if (this.d != 1) {
        break label80;
      }
      if (n < this.i)
      {
        bool1 = true;
        break label83;
      }
      bool1 = false;
      break label83;
      if (this.jdField_c_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidViewView);
      }
      this.i = -1;
      this.k = -1;
      this.j = -1;
      this.l = -1;
      break label80;
      if (((i1 == 1) || (i1 == 3)) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(false);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener = null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.b(paramMotionEvent);
      return bool2;
    }
    a(paramMotionEvent);
    int m = (int)(paramMotionEvent.getX() + 0.5F);
    int n = (int)(paramMotionEvent.getY() + 0.5F);
    int i1 = paramMotionEvent.getAction();
    boolean bool1;
    switch (i1)
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((i1 == 0) && (this.jdField_c_of_type_Boolean))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(true);
          }
          label116:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.b(paramMotionEvent);
          if ((this.jdField_c_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))) {}
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!this.jdField_c_of_type_Boolean) {
              break;
            }
            bool1 = bool2;
            if (this.jdField_a_of_type_AndroidViewView == this.jdField_b_of_type_AndroidViewView) {
              break;
            }
            a(this.jdField_a_of_type_AndroidViewView);
            bool1 = bool2;
            break;
          }
          if (this.jdField_c_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))
            {
              bool2 = true;
              label243:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.d == 0)
                {
                  bool1 = bool2;
                  if (!a(Math.abs(m - this.i), Math.abs(n - this.j))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.d == 1)
                {
                  a(m, n, this.jdField_b_of_type_AndroidViewView, this.h);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.k = m;
      this.l = n;
      break;
      bool2 = false;
      break label243;
      if (this.h == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.d == 0) && (!a(Math.abs(m - this.i), Math.abs(n - this.j))))
        {
          bool1 = false;
          break;
        }
        if (this.d == 1)
        {
          a(m, n, this.jdField_b_of_type_AndroidViewView, this.h);
          bool1 = true;
          continue;
          if (this.jdField_c_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))
            {
              bool2 = true;
              label455:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.d != 1) {
                  break label518;
                }
                c();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            e();
            this.i = -1;
            this.k = -1;
            this.j = -1;
            this.l = -1;
            break;
            bool2 = false;
            break label455;
            label518:
            a(this.jdField_b_of_type_AndroidViewView);
            bool1 = bool2;
            continue;
            if (this.h == 0)
            {
              bool1 = false;
            }
            else
            {
              if (this.d == 1)
              {
                c();
                bool1 = true;
                continue;
                if (((i1 != 1) && (i1 != 3)) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener == null)) {
                  break label116;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(false);
                this.jdField_a_of_type_Boolean = false;
                break label116;
              }
              bool1 = false;
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 2: 
      return bool;
    case 0: 
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.scrollTo((int)f1, 0);
        this.jdField_a_of_type_ComTencentWidgetListView.invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return true;
      }
      this.jdField_c_of_type_AndroidViewView = null;
      return true;
    }
    bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
    float f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_c_of_type_AndroidViewView.scrollTo((int)f1, 0);
      this.jdField_a_of_type_ComTencentWidgetListView.invalidate();
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return true;
    }
    this.jdField_c_of_type_AndroidViewView = null;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\TroopSidesSlippingMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */