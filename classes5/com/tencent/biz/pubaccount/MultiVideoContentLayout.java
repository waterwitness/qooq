package com.tencent.biz.pubaccount;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hoh;

public class MultiVideoContentLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private hoh jdField_a_of_type_Hoh;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  
  public MultiVideoContentLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public MultiVideoContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public MultiVideoContentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_a_of_type_Hoh != null) {
        this.jdField_a_of_type_Hoh.a();
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramMotionEvent.getAction() != 2) {
        break label118;
      }
      if (paramMotionEvent.getY() <= this.jdField_b_of_type_Float) {}
    }
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getY();
      float f2 = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_a_of_type_Hoh != null) {
        this.jdField_a_of_type_Hoh.a(f1 - f2);
      }
      while (!this.jdField_b_of_type_Boolean)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        label118:
        if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Hoh != null)) {
          this.jdField_a_of_type_Hoh.b();
        }
      }
    }
  }
  
  public void setIsCatchTouchEvent(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setIsInterceptTouchEvent(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setListener(hoh paramhoh)
  {
    this.jdField_a_of_type_Hoh = paramhoh;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\MultiVideoContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */