package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.widget.OnSizeChangeListener;
import com.tencent.widget.ScrollView;
import wky;

public class BounceScrollView
  extends ScrollView
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private BounceScrollView.MotionEventInterceptor jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor;
  protected BounceScrollView.OnScrollChangedListener a;
  ScrollListener jdField_a_of_type_ComTencentMobileqqWidgetScrollListener;
  OnSizeChangeListener jdField_a_of_type_ComTencentWidgetOnSizeChangeListener;
  private boolean jdField_a_of_type_Boolean;
  
  public BounceScrollView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new wky(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener = null;
  }
  
  public BounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new wky(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener = null;
    setOverScrollMode(0);
    setFadingEdgeLength(0);
    if (AppSetting.j) {
      AccessibilityUtil.a(this, false);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.a(this, paramInt);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor.a(this, localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    for (;;)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener.a(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      for (;;)
      {
        if (!bool1)
        {
          bool1 = bool2;
          if (!super.dispatchTouchEvent(paramMotionEvent)) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        if (i == 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
          }
        }
        else if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.b(this, paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      bool1 = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        super.onInterceptTouchEvent(paramMotionEvent);
        return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener != null) {
      this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener.a(paramInt1, paramInt2, paramInt3, paramInt4, false, 0);
    }
  }
  
  public void setMotionEventInterceptor(BounceScrollView.MotionEventInterceptor paramMotionEventInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor = paramMotionEventInterceptor;
  }
  
  public void setNeedHorizontalGesture(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollChangedListener(BounceScrollView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener = paramOnScrollChangedListener;
  }
  
  public void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener)
  {
    this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener = paramOnSizeChangeListener;
  }
  
  public void setScrollListener(ScrollListener paramScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener = paramScrollListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\BounceScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */