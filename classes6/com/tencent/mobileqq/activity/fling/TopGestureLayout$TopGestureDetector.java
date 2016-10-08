package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TopGestureLayout$TopGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private float jdField_a_of_type_Float;
  
  public TopGestureLayout$TopGestureDetector(TopGestureLayout paramTopGestureLayout, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(0);
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.isGestureIdle()) || (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.isGestureEnd())) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.hasGestureFlag(1)) && (f1 < 0.0F) && (f2 < 0.5F) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.mOnFlingGesture != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.mOnFlingGesture.flingLToR();
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.isGestureEnd()) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.isGestureIdle())
    {
      if ((Math.abs(f1) > this.jdField_a_of_type_Float) && (paramFloat1 < 0.0F) && (f2 < 0.5F))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(1);
        return true;
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.hasGestureFlag(1)) && ((paramFloat1 > 0.0F) || (f2 >= 0.5F))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(-1);
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setGestureFlag(-1);
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\fling\TopGestureLayout$TopGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */