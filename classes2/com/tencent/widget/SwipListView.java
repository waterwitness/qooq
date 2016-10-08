package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SwipListView
  extends XListView
  implements Handler.Callback
{
  private static final byte jdField_a_of_type_Byte = 0;
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "SwipListView";
  private static final byte jdField_b_of_type_Byte = 1;
  private static final int jdField_b_of_type_Int = 1;
  private static final byte jdField_c_of_type_Byte = 2;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 300;
  public static final int k = -3;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private SwipListView.RightIconMenuListener jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener;
  private SwipListView.SwipListListener jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private byte jdField_d_of_type_Byte;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private final int l;
  
  public SwipListView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new SwipListView.SmoothInterpolator());
    paramContext = ViewConfiguration.get(getContext());
    this.l = paramContext.getScaledTouchSlop();
    this.i = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.e = -1;
    this.g = -1;
    this.f = -1;
    this.h = -1;
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
    paramInt2 = this.g;
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
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
  
  private boolean a(float paramFloat)
  {
    return paramFloat < getWidth() - this.j;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.l) || (paramFloat2 > this.l))
    {
      if ((paramFloat1 > this.l) && (paramFloat2 / paramFloat1 < 0.6F))
      {
        this.d = 1;
        return true;
      }
      this.d = 2;
      return true;
    }
    return false;
  }
  
  private void c()
  {
    int m = a();
    int n = this.jdField_b_of_type_AndroidViewView.getScrollX();
    if (m > this.i)
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (m < -this.i)
    {
      e(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((m > 0) && (n < this.j * 0.7F))
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((m < 0) && (n > this.j * 0.3F))
    {
      e(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && (n < this.j * 0.7F))
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (n > this.j * 0.3F)
    {
      e(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    d(this.jdField_b_of_type_AndroidViewView);
  }
  
  private boolean c(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.l);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.c = null;
  }
  
  private void d(View paramView)
  {
    if (paramView != null) {}
    for (int m = paramView.getScrollX();; m = 0)
    {
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener.a(null);
      }
      if (m != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label142;
        }
      }
      label142:
      for (int n = ((Integer)paramView.getTag(-3)).intValue();; n = 0)
      {
        if ((this.c != paramView) && (this.c != null)) {
          this.c.scrollTo(0, 0);
        }
        d();
        this.c = paramView;
        int i1 = -m;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(m, 0, i1, 0, a(n, i1));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener == null);
        this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener.b(this.c);
        return;
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void e(View paramView)
  {
    int n;
    if (paramView != null)
    {
      n = paramView.getScrollX();
      m = n;
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener.a(paramView);
      }
    }
    for (int m = n;; m = 0)
    {
      n = this.j;
      if ((n == 0) && (paramView != null) && ((paramView.getTag(-3) instanceof Integer))) {
        n = ((Integer)paramView.getTag(-3)).intValue();
      }
      for (;;)
      {
        if (m != n)
        {
          if ((this.c != paramView) && (this.c != null)) {
            this.c.scrollTo(0, 0);
          }
          d();
          this.c = paramView;
          i1 = n - m;
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(m, 0, i1, 0, a(n, i1));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        }
        while (this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener == null)
        {
          int i1;
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener.a(paramView);
        return;
      }
    }
  }
  
  public void N()
  {
    int m;
    int n;
    if (!c(this.jdField_b_of_type_AndroidViewView))
    {
      m = s() - m();
      n = t();
    }
    for (;;)
    {
      if (m <= n)
      {
        View localView = getChildAt(m);
        if (c(localView)) {
          this.jdField_b_of_type_AndroidViewView = localView;
        }
      }
      else
      {
        d(this.jdField_b_of_type_AndroidViewView);
        return;
      }
      m += 1;
    }
  }
  
  public void c(View paramView)
  {
    N();
    e(paramView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      float f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if ((this.c != null) && (this.c.getScrollX() < (int)f1))
      {
        this.c.scrollTo((int)f1, 0);
        invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener.a(this.c);
      }
      this.c = null;
      return true;
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if ((this.c != null) && (this.c.getScrollX() > (int)f1))
      {
        this.c.scrollTo((int)f1, 0);
        invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener.b(this.c);
      }
      this.c = null;
      return true;
    } while (this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener == null);
    this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener.d();
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool2;
    }
    int n = (int)(paramMotionEvent.getX() + 0.5F);
    int m = (int)(paramMotionEvent.getY() + 0.5F);
    int i1 = paramMotionEvent.getAction();
    label76:
    boolean bool1;
    switch (i1)
    {
    default: 
      bool1 = false;
      label79:
      if ((i1 == 0) && (this.jdField_b_of_type_Boolean))
      {
        if (this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener != null) {
          this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener.d(true);
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
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.d = 0;
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener.a(null);
      }
      this.e = n;
      this.g = n;
      this.f = m;
      this.h = m;
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      this.jdField_b_of_type_Boolean = c(this.jdField_a_of_type_AndroidViewView);
      int i2;
      int i3;
      if (!this.jdField_b_of_type_Boolean)
      {
        i2 = s();
        i3 = m();
        m = t();
      }
      for (;;)
      {
        if (m >= i2 - i3)
        {
          View localView = getChildAt(m);
          this.jdField_b_of_type_Boolean = c(localView);
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_AndroidViewView = localView;
          }
        }
        else
        {
          this.j = 0;
          this.jdField_b_of_type_AndroidViewView = null;
          m = this.f;
          if (c()) {
            m = this.f + getScrollY();
          }
          m = b(this.e, m);
          if (m >= 0)
          {
            this.jdField_b_of_type_AndroidViewView = getChildAt(m - s());
            if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView.getTag(-3) instanceof Integer))) {
              this.j = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(-3)).intValue();
            }
          }
          if ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView) && (!a(n)))) {
            break label393;
          }
          bool1 = true;
          break;
        }
        m -= 1;
      }
      label393:
      bool1 = false;
      break label79;
      if (this.j <= 0) {
        break label76;
      }
      if (this.d == 0) {
        a(Math.abs(n - this.e), Math.abs(m - this.f));
      }
      if (this.d != 1) {
        break label76;
      }
      if (n < this.e) {}
      for (bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        bool1 = bool2;
        break;
      }
      if (this.jdField_b_of_type_Boolean) {
        d(this.jdField_a_of_type_AndroidViewView);
      }
      this.e = -1;
      this.g = -1;
      this.f = -1;
      this.h = -1;
      break label76;
      if (((i1 == 1) || (i1 == 3)) && (this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener != null)) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener.d(false);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool2 = super.onTouchEvent(paramMotionEvent);
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
        if ((i1 == 0) && (this.jdField_b_of_type_Boolean))
        {
          if (this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener != null) {
            this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener.d(true);
          }
          label112:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return super.onTouchEvent(paramMotionEvent);
          if ((this.jdField_b_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))) {}
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!this.jdField_b_of_type_Boolean) {
              break;
            }
            bool1 = bool2;
            if (this.jdField_a_of_type_AndroidViewView == this.jdField_b_of_type_AndroidViewView) {
              break;
            }
            d(this.jdField_a_of_type_AndroidViewView);
            bool1 = bool2;
            break;
          }
          if (this.jdField_b_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))
            {
              bool2 = true;
              label234:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.d == 0)
                {
                  bool1 = bool2;
                  if (!a(Math.abs(m - this.e), Math.abs(n - this.f))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.d == 1)
                {
                  a(m, n, this.jdField_b_of_type_AndroidViewView, this.j);
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
      this.g = m;
      this.h = n;
      break;
      bool2 = false;
      break label234;
      if (this.j == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.d == 0) && (!a(Math.abs(m - this.e), Math.abs(n - this.f))))
        {
          bool1 = false;
          break;
        }
        if (this.d == 1)
        {
          a(m, n, this.jdField_b_of_type_AndroidViewView, this.j);
          bool1 = true;
          continue;
          if (this.jdField_b_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))
            {
              bool2 = true;
              label446:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.d != 1) {
                  break label509;
                }
                c();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            e();
            this.e = -1;
            this.g = -1;
            this.f = -1;
            this.h = -1;
            break;
            bool2 = false;
            break label446;
            label509:
            d(this.jdField_b_of_type_AndroidViewView);
            bool1 = bool2;
            continue;
            if (this.j == 0)
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
                if (((i1 != 1) && (i1 != 3)) || (this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener == null)) {
                  break label112;
                }
                this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener.d(false);
                break label112;
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
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter instanceof SwipListView.SwipListListener)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener = ((SwipListView.SwipListListener)paramListAdapter);
    }
  }
  
  public void setDragEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!this.jdField_a_of_type_Boolean) {
      N();
    }
  }
  
  public void setRightIconMenuListener(SwipListView.RightIconMenuListener paramRightIconMenuListener)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener = paramRightIconMenuListener;
  }
  
  public void setSwipListListener(SwipListView.SwipListListener paramSwipListListener)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipListView$SwipListListener = paramSwipListListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\SwipListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */