package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import xuo;
import xup;

public class PullToZoomListView
  extends XListView
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new xuo();
  private static final String jdField_a_of_type_JavaLangString = "PullToZoomListView";
  private static final int e = -1;
  protected float a;
  protected int a;
  public FrameLayout a;
  public ImageView a;
  protected xup a;
  public boolean a;
  protected float b;
  public int b;
  protected float c;
  public int c;
  protected int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PullToZoomListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    a(paramContext);
  }
  
  public PullToZoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    a(paramContext);
  }
  
  public PullToZoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.d = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_Xup = new xup(this);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() >> 8;
    if ((paramMotionEvent.getPointerId(i) == this.jdField_a_of_type_Int) && (i != 0))
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY(0);
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() >= this.jdField_b_of_type_Int) && (QLog.isColorLevel())) {
      QLog.d("PullToZoomListView", 2, "endScraling");
    }
    this.jdField_a_of_type_Xup.a(200L);
  }
  
  private void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PullToZoomListView", 2, "initHeaderView");
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
  }
  
  public void a(View paramView)
  {
    c(paramView);
    super.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  public void a(View paramView, Object paramObject, boolean paramBoolean)
  {
    c(paramView);
    super.a(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramObject, paramBoolean);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (!this.jdField_a_of_type_Xup.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Xup.a();
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
      this.jdField_c_of_type_Float = (this.d * 1.0F / this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() / this.jdField_b_of_type_Int);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight() != this.jdField_a_of_type_AndroidWidgetImageView.getHeight()))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
      this.jdField_c_of_type_Int = (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
      if (QLog.isColorLevel()) {
        QLog.d("PullToZoomListView", 2, "mHeaderHeight:" + this.jdField_b_of_type_Int + " mHeaderBottomHeight:" + this.jdField_c_of_type_Int);
      }
      if (this.jdField_b_of_type_Int > 0) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      int i = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
      if (i == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PullToZoomListView", 2, "Invalid pointerId=" + this.jdField_a_of_type_Int + " in onTouchEvent");
        }
      }
      else
      {
        if (this.jdField_a_of_type_Float == -1.0F) {
          this.jdField_a_of_type_Float = paramMotionEvent.getY(i);
        }
        if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() >= this.jdField_b_of_type_Int)
        {
          ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          float f = ((paramMotionEvent.getY(i) - this.jdField_a_of_type_Float + this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom()) / this.jdField_b_of_type_Int - this.jdField_b_of_type_Float) / 2.0F + this.jdField_b_of_type_Float;
          if ((this.jdField_b_of_type_Float <= 1.0D) && (f < this.jdField_b_of_type_Float))
          {
            localLayoutParams1.height = this.jdField_b_of_type_Int;
            localLayoutParams2.height = (this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams1);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
            return super.onTouchEvent(paramMotionEvent);
          }
          this.jdField_b_of_type_Float = Math.min(Math.max(f, 1.0F), this.jdField_c_of_type_Float);
          localLayoutParams1.height = ((int)(this.jdField_b_of_type_Int * this.jdField_b_of_type_Float));
          localLayoutParams1.height -= this.jdField_c_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("PullToZoomListView", 2, "new height:" + localLayoutParams1.height + " imgHeight:" + localLayoutParams2.height + " mLastScale:" + this.jdField_b_of_type_Float);
          }
          if (localLayoutParams1.height < this.d)
          {
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams1);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getY(i);
          return true;
        }
        this.jdField_a_of_type_Float = paramMotionEvent.getY(i);
        continue;
        d();
        c();
        continue;
        i = paramMotionEvent.getActionIndex();
        this.jdField_a_of_type_Float = paramMotionEvent.getY(i);
        this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(i);
      }
    }
  }
  
  public void setHeaderImage(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\PullToZoomListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */