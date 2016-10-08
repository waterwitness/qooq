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
import android.widget.ExpandableListAdapter;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SwipPinnedHeaderExpandableListView
  extends PinnedHeaderExpandableListView
  implements Handler.Callback
{
  private static final byte jdField_a_of_type_Byte = 0;
  public static final int a = -3;
  public static final String a = "SwipListView";
  private static final byte jdField_b_of_type_Byte = 1;
  private static final int jdField_b_of_type_Int = 0;
  private static final byte jdField_c_of_type_Byte = 2;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 300;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private SwipPinnedHeaderExpandableListView.RightIconMenuListener jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener;
  private SwipPinnedHeaderExpandableListView.SwipListListener jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private byte d;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private final int p;
  
  public SwipPinnedHeaderExpandableListView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SwipPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public SwipPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new SwipPinnedHeaderExpandableListView.SmoothInterpolator());
    paramContext = ViewConfiguration.get(getContext());
    this.p = paramContext.getScaledTouchSlop();
    this.n = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.j = -1;
    this.l = -1;
    this.k = -1;
    this.m = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private int a()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    return (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = 300;
    if (paramInt1 > 0) {
      i1 = (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return i1;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.l;
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
    return paramFloat < getWidth() - this.o;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.p) || (paramFloat2 > this.p))
    {
      if ((paramFloat1 > this.p) && (paramFloat2 / paramFloat1 < 0.6F))
      {
        this.d = 1;
        return true;
      }
      this.d = 2;
      return true;
    }
    return false;
  }
  
  private void c(View paramView)
  {
    if (paramView != null) {}
    for (int i1 = paramView.getScrollX();; i1 = 0)
    {
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.a(null);
      }
      if (i1 != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label142;
        }
      }
      label142:
      for (int i2 = ((Integer)paramView.getTag(-3)).intValue();; i2 = 0)
      {
        if ((this.c != paramView) && (this.c != null)) {
          this.c.scrollTo(0, 0);
        }
        f();
        this.c = paramView;
        int i3 = -i1;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, 0, i3, 0, a(i2, i3));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener == null);
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener.b(this.c);
        return;
      }
    }
  }
  
  private void d(View paramView)
  {
    int i2;
    if (paramView != null)
    {
      i2 = paramView.getScrollX();
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.a(paramView);
      }
    }
    for (int i1 = i2;; i1 = 0)
    {
      i2 = this.o;
      if ((i2 == 0) && (paramView != null) && ((paramView.getTag(-3) instanceof Integer))) {
        i2 = ((Integer)paramView.getTag(-3)).intValue();
      }
      for (;;)
      {
        if (i1 != i2)
        {
          if ((this.c != paramView) && (this.c != null)) {
            this.c.scrollTo(0, 0);
          }
          f();
          this.c = paramView;
          i3 = i2 - i1;
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, 0, i3, 0, a(i2, i3));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        }
        while (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener == null)
        {
          int i3;
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener.a(paramView);
        return;
      }
    }
  }
  
  private boolean d(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.p);
  }
  
  private void e()
  {
    int i1 = a();
    int i2 = this.jdField_b_of_type_AndroidViewView.getScrollX();
    if (i1 > this.n)
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (i1 < -this.n)
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((i1 > 0) && (i2 < this.o * 0.7F))
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((i1 < 0) && (i2 > this.o * 0.3F))
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && (i2 < this.o * 0.7F))
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (i2 > this.o * 0.3F)
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    c(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.c = null;
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void c()
  {
    int i1;
    int i2;
    if (!d(this.jdField_b_of_type_AndroidViewView))
    {
      i1 = s() - m();
      i2 = t();
    }
    for (;;)
    {
      if (i1 <= i2)
      {
        View localView = getChildAt(i1);
        if (d(localView)) {
          this.jdField_b_of_type_AndroidViewView = localView;
        }
      }
      else
      {
        c(this.jdField_b_of_type_AndroidViewView);
        return;
      }
      i1 += 1;
    }
  }
  
  public boolean c(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener != null) {
      return this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.a(paramView);
    }
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.j = -1;
    this.l = -1;
    this.k = -1;
    this.m = -1;
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
      float f = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.c != null)
      {
        this.c.scrollTo((int)f, 0);
        invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener.a(this.c);
      }
      this.c = null;
      return true;
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      f = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.c != null)
      {
        this.c.scrollTo((int)f, 0);
        invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener.b(this.c);
      }
      this.c = null;
      return true;
    } while (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener == null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.f();
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
    int i2 = (int)(paramMotionEvent.getX() + 0.5F);
    int i1 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = paramMotionEvent.getAction();
    label76:
    boolean bool1;
    switch (i3)
    {
    default: 
      bool1 = false;
      label79:
      if ((i3 == 0) && (this.jdField_b_of_type_Boolean))
      {
        if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener != null) {
          this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.a(true);
        }
        f();
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
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.a(null);
      }
      this.j = i2;
      this.l = i2;
      this.k = i1;
      this.m = i1;
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      this.jdField_b_of_type_Boolean = d(this.jdField_a_of_type_AndroidViewView);
      int i4;
      int i5;
      if (!this.jdField_b_of_type_Boolean)
      {
        i4 = s();
        i5 = m();
        i1 = t();
      }
      for (;;)
      {
        if (i1 >= i4 - i5)
        {
          View localView = getChildAt(i1);
          this.jdField_b_of_type_Boolean = d(localView);
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_AndroidViewView = localView;
          }
        }
        else
        {
          this.o = 0;
          this.jdField_b_of_type_AndroidViewView = null;
          i1 = this.k;
          if (c()) {
            i1 = this.k + getScrollY();
          }
          i1 = b(this.j, i1);
          if (i1 >= 0)
          {
            this.jdField_b_of_type_AndroidViewView = getChildAt(i1 - s());
            if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView.getTag(-3) instanceof Integer))) {
              this.o = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(-3)).intValue();
            }
            if ((this.o > 0) && (!c(this.jdField_b_of_type_AndroidViewView))) {
              this.o = 0;
            }
          }
          if ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView) && (!a(i2)))) {
            break label416;
          }
          bool1 = true;
          break;
        }
        i1 -= 1;
      }
      label416:
      bool1 = false;
      break label79;
      if (this.o <= 0) {
        break label76;
      }
      if (this.d == 0) {
        a(Math.abs(i2 - this.j), Math.abs(i1 - this.k));
      }
      if (this.d != 1) {
        break label76;
      }
      if (i2 < this.j) {}
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
        c(this.jdField_a_of_type_AndroidViewView);
      }
      this.j = -1;
      this.l = -1;
      this.k = -1;
      this.m = -1;
      break label76;
      if (((i3 == 1) || (i3 == 3)) && (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener != null)) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.a(false);
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
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i2 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = paramMotionEvent.getAction();
    boolean bool1;
    switch (i3)
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((i3 == 0) && (this.jdField_b_of_type_Boolean))
        {
          if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener != null) {
            this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.a(true);
          }
          label112:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return super.onTouchEvent(paramMotionEvent);
          if ((this.jdField_b_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i1)))) {}
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
            c(this.jdField_a_of_type_AndroidViewView);
            bool1 = bool2;
            break;
          }
          if (this.jdField_b_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i1)))
            {
              bool2 = true;
              label234:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.d == 0)
                {
                  bool1 = bool2;
                  if (!a(Math.abs(i1 - this.j), Math.abs(i2 - this.k))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.d == 1)
                {
                  a(i1, i2, this.jdField_b_of_type_AndroidViewView, this.o);
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
      this.l = i1;
      this.m = i2;
      break;
      bool2 = false;
      break label234;
      if (this.o == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.d == 0) && (!a(Math.abs(i1 - this.j), Math.abs(i2 - this.k))))
        {
          bool1 = false;
          break;
        }
        if (this.d == 1)
        {
          a(i1, i2, this.jdField_b_of_type_AndroidViewView, this.o);
          bool1 = true;
          continue;
          if (this.jdField_b_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i1)))
            {
              bool2 = true;
              label446:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.d != 1) {
                  break label509;
                }
                e();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            g();
            this.j = -1;
            this.l = -1;
            this.k = -1;
            this.m = -1;
            break;
            bool2 = false;
            break label446;
            label509:
            c(this.jdField_b_of_type_AndroidViewView);
            bool1 = bool2;
            continue;
            if (this.o == 0)
            {
              bool1 = false;
            }
            else
            {
              if (this.d == 1)
              {
                e();
                bool1 = true;
                continue;
                if (((i3 != 1) && (i3 != 3)) || (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener == null)) {
                  break label112;
                }
                this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener.a(false);
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
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof SwipPinnedHeaderExpandableListView.SwipListListener)) {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener = ((SwipPinnedHeaderExpandableListView.SwipListListener)paramExpandableListAdapter);
    }
  }
  
  public void setDragEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
  }
  
  public void setRightIconMenuListener(SwipPinnedHeaderExpandableListView.RightIconMenuListener paramRightIconMenuListener)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$RightIconMenuListener = paramRightIconMenuListener;
  }
  
  public void setSwipListListener(SwipPinnedHeaderExpandableListView.SwipListListener paramSwipListListener)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView$SwipListListener = paramSwipListListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\SwipPinnedHeaderExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */