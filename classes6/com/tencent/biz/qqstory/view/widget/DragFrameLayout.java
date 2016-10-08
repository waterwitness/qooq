package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class DragFrameLayout
  extends FrameLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 4;
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private DragFrameLayout.OnDraggingListener jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener;
  protected boolean a;
  private float b;
  protected boolean b;
  private float c;
  private float d;
  public int e;
  private int f;
  private int g;
  private int h;
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = 0;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = 0;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = 1.0F;
    }
    ViewHelper.setPivotX(this.jdField_a_of_type_AndroidViewView, 0.0F);
    ViewHelper.setPivotY(this.jdField_a_of_type_AndroidViewView, 0.0F);
    ViewHelper.setScaleX(this.jdField_a_of_type_AndroidViewView, f1);
    ViewHelper.setScaleY(this.jdField_a_of_type_AndroidViewView, f1);
    ViewHelper.setX(this.jdField_a_of_type_AndroidViewView, paramInt1);
    ViewHelper.setY(this.jdField_a_of_type_AndroidViewView, paramInt2);
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener.a(paramInt1, paramInt2, this.f, this.g, (int)(this.f * f1), (int)(this.g * f1));
    }
  }
  
  public void a()
  {
    float f1 = ViewHelper.getScaleX(this.jdField_a_of_type_AndroidViewView);
    float f2 = ViewHelper.getScaleY(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0, ViewHelper.getX(this.jdField_a_of_type_AndroidViewView), 0, 0.0F, 0, ViewHelper.getY(this.jdField_a_of_type_AndroidViewView), 0, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Animation.AnimationListener paramAnimationListener)
  {
    float f1 = ViewHelper.getScaleX(this.jdField_a_of_type_AndroidViewView);
    float f2 = ViewHelper.getScaleY(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0, ViewHelper.getX(this.jdField_a_of_type_AndroidViewView), 0, paramInt1, 0, ViewHelper.getY(this.jdField_a_of_type_AndroidViewView), 0, paramInt2);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(paramInt5);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(paramAnimationListener);
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    float f3 = paramInt3 / getWidth();
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, f3, f2, f3, 0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(paramInt5);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidViewView).reset();
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = null;
    }
    removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    this.c = paramMotionEvent.getX();
    this.d = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = this.c;
      this.jdField_b_of_type_Float = this.d;
      if (this.f == 0)
      {
        this.f = getWidth();
        this.g = getHeight();
      }
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      float f1 = Math.abs(this.c - this.jdField_a_of_type_Float);
      float f2 = Math.abs(this.d - this.jdField_b_of_type_Float);
      if ((this.h == 0) && (f1 + f2 < DisplayUtil.a(getContext(), 10.0F))) {
        return false;
      }
      f1 = this.c - this.jdField_a_of_type_Float;
      f2 = this.d - this.jdField_b_of_type_Float;
      if ((f2 < 0.0F) && (Math.abs(f2) > Math.abs(f1)) && (this.h == 0))
      {
        this.jdField_a_of_type_Float = this.c;
        this.jdField_b_of_type_Float = this.d;
        return false;
      }
      if (Math.abs(f2) > 1.2D * Math.abs(f1))
      {
        if (this.h == 0)
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener.a()))
          {
            this.jdField_a_of_type_Float = this.c;
            this.jdField_b_of_type_Float = this.d;
            f1 = this.c;
            f1 = this.jdField_a_of_type_Float;
            f1 = this.d;
            f1 = this.jdField_b_of_type_Float;
            this.h = 1;
            return true;
          }
          this.jdField_a_of_type_Float = this.c;
          this.jdField_b_of_type_Float = this.d;
          return false;
        }
      }
      else if (f1 < 0.0F)
      {
        if (this.h == 0)
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener.b()))
          {
            this.jdField_a_of_type_Float = this.c;
            this.jdField_b_of_type_Float = this.d;
            f1 = this.c;
            f1 = this.jdField_a_of_type_Float;
            f1 = this.d;
            f1 = this.jdField_b_of_type_Float;
            this.h = 2;
            return true;
          }
          this.jdField_a_of_type_Float = this.c;
          this.jdField_b_of_type_Float = this.d;
          return false;
        }
      }
      else if (f1 > 0.0F)
      {
        if (this.h == 0)
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener.c()))
          {
            this.jdField_a_of_type_Float = this.c;
            this.jdField_b_of_type_Float = this.d;
            f1 = this.c;
            f1 = this.jdField_a_of_type_Float;
            f1 = this.d;
            f1 = this.jdField_b_of_type_Float;
            this.h = 4;
            return true;
          }
          this.jdField_a_of_type_Float = this.c;
          this.jdField_b_of_type_Float = this.d;
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_Float = this.c;
        this.jdField_b_of_type_Float = this.d;
        return false;
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    this.c = paramMotionEvent.getX();
    this.d = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = this.c;
      this.jdField_b_of_type_Float = this.d;
      return true;
    }
    float f3;
    float f5;
    float f1;
    float f4;
    float f2;
    if (i == 2)
    {
      f3 = this.c - this.jdField_a_of_type_Float;
      f5 = this.d - this.jdField_b_of_type_Float;
      if (this.h == 1) {
        if (f5 > 0.0F)
        {
          f1 = (int)(this.g - f5 * 1.1D);
          f4 = this.f * f1 / this.g;
          f2 = f1;
          f1 = f4;
        }
      }
    }
    for (;;)
    {
      f4 = f1;
      if (f1 <= this.e)
      {
        f4 = this.e;
        f2 = this.g * f4 / this.f;
      }
      if (this.h == 1)
      {
        f2 = f4 / this.f;
        i = (int)(f3 + this.jdField_a_of_type_Float - f4 * this.jdField_a_of_type_Float / this.f);
        if (f5 > 0.0F) {}
        for (f1 = f5;; f1 = f5 / 2.0F)
        {
          a(f2, i, (int)f1);
          return true;
          f1 = this.g;
          break;
          if (this.h == 2)
          {
            if (f3 < 0.0F) {}
            for (f1 = (int)(this.f + f3 * 1.1D);; f1 = this.f)
            {
              f2 = this.g * f1 / this.f;
              break;
            }
          }
          if (this.h != 4) {
            break label621;
          }
          if (f3 > 0.0F) {}
          for (f1 = (int)(this.f - f3 * 1.1D);; f1 = this.f)
          {
            f2 = this.g * f1 / this.f;
            break;
          }
        }
      }
      if (this.h == 2)
      {
        f1 = f4 / this.f;
        float f6 = this.f;
        if (f3 < 0.0F) {}
        for (;;)
        {
          a(f1, (int)(f3 + (f6 - f4)), (int)(this.jdField_b_of_type_Float + f5 - f2 * this.jdField_b_of_type_Float / this.g));
          return true;
          f3 /= 2.0F;
        }
      }
      if (this.h != 4) {
        break;
      }
      f1 = f4 / this.f;
      if (f3 > 0.0F) {}
      for (;;)
      {
        a(f1, (int)f3, (int)(f5 + this.jdField_b_of_type_Float - f2 * this.jdField_b_of_type_Float / this.g));
        return true;
        f3 /= 2.0F;
      }
      if ((i != 1) && (i != 3)) {
        break;
      }
      if (this.h != 0)
      {
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener != null)
        {
          f1 = ViewHelper.getScaleX(this.jdField_a_of_type_AndroidViewView);
          f2 = ViewHelper.getScaleY(this.jdField_a_of_type_AndroidViewView);
          if ((f1 > 0.0F) && (f2 > 0.0F)) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener.a(this.jdField_a_of_type_AndroidViewView, this.f, this.g, (int)(f1 * this.f), (int)(f2 * this.g), (int)ViewHelper.getX(this.jdField_a_of_type_AndroidViewView), (int)ViewHelper.getY(this.jdField_a_of_type_AndroidViewView));
          }
        }
      }
      this.h = 0;
      return true;
      label621:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void setDraggableView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnDraggingListener(DragFrameLayout.OnDraggingListener paramOnDraggingListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout$OnDraggingListener = paramOnDraggingListener;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\DragFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */