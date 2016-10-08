package com.tencent.biz.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.OverScroller;

public class CustomScrollView
  extends RelativeLayout
  implements TouchWebView.OnOverScrollHandler
{
  public static final int a = 5000;
  public static final String a = "CustomScrollView";
  public static final int b = 0;
  public static final int c = -1;
  public static final int d = 1;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  public GestureDetector a;
  public CustomScrollView.OnGestureListener a;
  private OverScroller jdField_a_of_type_ComTencentWidgetOverScroller;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private int e;
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = true;
    a(paramContext, paramAttributeSet);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = true;
    a(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX(), getScrollY(), 0, 0, 0, 0)) {
      invalidate();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.c) && (Build.VERSION.SDK_INT >= 9))
    {
      if (getScrollY() + paramInt <= 0) {
        break label60;
      }
      paramInt = -getScrollY();
    }
    label60:
    for (;;)
    {
      if (a()) {
        overScrollBy(0, paramInt, getScrollX(), getScrollY(), 0, 0, 0, 5000, true);
      }
      return;
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new CustomScrollView.TopGestureDetector(this, paramContext));
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
    this.jdField_a_of_type_ComTencentWidgetOverScroller = new OverScroller(getContext());
    try
    {
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      a(paramContext);
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      for (;;) {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return (!c()) && ((this.e & paramInt) == paramInt);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX(), getScrollY(), 0, 0, -paramInt, 0)) {
      invalidate();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.e == 0;
  }
  
  public boolean c()
  {
    return this.e == -1;
  }
  
  public void computeScroll()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetOverScroller != null) && (this.jdField_a_of_type_ComTencentWidgetOverScroller.b()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
      int m = this.jdField_a_of_type_ComTencentWidgetOverScroller.b();
      if (((i != k) || (j != m)) && (Build.VERSION.SDK_INT >= 9)) {
        overScrollBy(k - i, m - j, i, j, 0, 0, 0, 5000, false);
      }
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) || (paramMotionEvent == null)) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      this.b = true;
      continue;
      this.b = false;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a())
    {
      super.scrollTo(paramInt1, paramInt2);
      if ((paramBoolean1) || (paramBoolean2)) {
        this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX(), getScrollY(), 0, 0, 0, 0);
      }
    }
    for (;;)
    {
      awakenScrollBars();
      return;
      super.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {}
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void setGestureFlag(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.e = paramInt;
      return;
    }
    this.e = (this.e & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  public void setOnFlingGesture(CustomScrollView.OnGestureListener paramOnGestureListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomScrollView$OnGestureListener = paramOnGestureListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\CustomScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */