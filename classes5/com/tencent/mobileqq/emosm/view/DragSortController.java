package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import rhe;

public class DragSortController
  extends SimpleFloatViewManager
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int j = -1;
  public float a;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new rhe(this);
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public DragSortListView a;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private float jdField_b_of_type_Float = 500.0F;
  GestureDetector jdField_b_of_type_AndroidViewGestureDetector;
  boolean jdField_b_of_type_Boolean = false;
  public boolean c = false;
  private boolean d = true;
  private boolean e;
  private boolean f;
  public int i;
  int k;
  int l;
  public int m;
  private int n = 0;
  private int o;
  private int p;
  private int q = -1;
  private int r = -1;
  private int s = -1;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  
  public DragSortController(DragSortListView paramDragSortListView)
  {
    this(paramDragSortListView, 0, 0, 1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.jdField_a_of_type_Float = (ViewConfiguration.getTouchSlop() + 2);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = paramDragSortListView;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramDragSortListView.getContext(), this);
    this.jdField_b_of_type_AndroidViewGestureDetector = new GestureDetector(paramDragSortListView.getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_b_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    this.p = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.v = paramInt1;
    this.w = paramInt4;
    this.x = paramInt5;
    b(paramInt3);
    a(paramInt2);
    this.i = 3;
  }
  
  public int a()
  {
    return this.n;
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    return c(paramMotionEvent);
  }
  
  public int a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    i1 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b(i1, i2);
    i2 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.m();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.n();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d_();
    if ((i1 != -1) && (i1 >= i2) && (i1 < i4 - i3))
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.s());
      i3 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = localView; paramMotionEvent != null; paramMotionEvent = localView.findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
        if ((i3 <= this.jdField_a_of_type_ArrayOfInt[0]) || (i2 <= this.jdField_a_of_type_ArrayOfInt[1]) || (i3 >= this.jdField_a_of_type_ArrayOfInt[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        if (i2 >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.t = localView.getLeft();
        this.u = localView.getTop();
        return i1;
      }
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void a(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      this.y = paramPoint1.x;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = 0;
    int i1 = i2;
    if (this.d)
    {
      i1 = i2;
      if (!this.jdField_b_of_type_Boolean) {
        i1 = 12;
      }
    }
    i2 = i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i2 = i1;
      if (this.jdField_b_of_type_Boolean) {
        i2 = i1 | 0x1 | 0x2;
      }
    }
    this.c = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(paramInt1 - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.m(), i2, paramInt2, paramInt3);
    return this.c;
  }
  
  public int b()
  {
    return this.o;
  }
  
  public int b(MotionEvent paramMotionEvent)
  {
    if (this.o == 1) {
      return d(paramMotionEvent);
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent, this.v);
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public int d(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent, this.x);
  }
  
  public void d(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void f(int paramInt)
  {
    this.w = paramInt;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.o == 0)) {
      this.s = a(paramMotionEvent, this.w);
    }
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    this.m = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b(i1, i2);
    this.q = a(paramMotionEvent);
    if ((this.q != -1) && (this.n == 0)) {
      a(this.q, (int)paramMotionEvent.getX() - this.t, (int)paramMotionEvent.getY() - this.u);
    }
    this.jdField_b_of_type_Boolean = false;
    this.e = true;
    this.y = 0;
    this.r = b(paramMotionEvent);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.q != -1) && (this.n == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.performHapticFeedback(0);
      a(this.q, this.k - this.t, this.l - this.u);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int i2;
    int i4;
    do
    {
      int i1;
      int i3;
      int i5;
      int i6;
      do
      {
        do
        {
          do
          {
            return false;
            i1 = (int)paramMotionEvent1.getX();
            i2 = (int)paramMotionEvent1.getY();
            i3 = (int)paramMotionEvent2.getX();
            i4 = (int)paramMotionEvent2.getY();
            i5 = i3 - this.t;
            i6 = i4 - this.u;
          } while ((!this.e) || (this.c) || ((this.q == -1) && (this.r == -1)));
          if (this.q == -1) {
            break;
          }
          if ((this.n == 1) && (Math.abs(i4 - i2) > this.p) && (this.d))
          {
            a(this.q, i5, i6);
            return false;
          }
        } while ((this.n == 0) || (Math.abs(i3 - i1) <= this.p) || (!this.jdField_a_of_type_Boolean));
        this.jdField_b_of_type_Boolean = true;
        a(this.r, i5, i6);
        return false;
      } while (this.r == -1);
      if ((Math.abs(i3 - i1) > this.p) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = true;
        a(this.r, i5, i6);
        return false;
      }
    } while (Math.abs(i4 - i2) <= this.p);
    this.e = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.o == 0) && (this.s != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(this.s - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.m());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b()) || (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a()))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b())
      {
        if (paramMotionEvent.getAction() == 0)
        {
          i1 = (int)paramMotionEvent.getX();
          int i2 = (int)paramMotionEvent.getY();
          this.m = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b(i1, i2);
        }
        return this.jdField_b_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      return false;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        return false;
        this.k = ((int)paramMotionEvent.getX());
        this.l = ((int)paramMotionEvent.getY());
      }
    case 1: 
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
        if (this.y < 0) {
          break label209;
        }
      }
      break;
    }
    label209:
    for (int i1 = this.y;; i1 = -this.y)
    {
      if (i1 > this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getWidth() / 2) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(false, 0.0F);
      }
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\view\DragSortController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */