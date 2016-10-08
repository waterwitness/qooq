package com.tencent.biz.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CustomScrollView$TopGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private float jdField_a_of_type_Float;
  
  public CustomScrollView$TopGestureDetector(CustomScrollView paramCustomScrollView, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomScrollView.setGestureFlag(0);
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_ComTencentBizUiCustomScrollView.b()) || (this.jdField_a_of_type_ComTencentBizUiCustomScrollView.c())) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if ((this.jdField_a_of_type_ComTencentBizUiCustomScrollView.a(1)) && (!CustomScrollView.a(this.jdField_a_of_type_ComTencentBizUiCustomScrollView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomScrollView", 2, "onFling(MotionEvent  rawX = " + paramMotionEvent1.getX() + " disx =" + f1 + "  screenwidth=" + this.jdField_a_of_type_ComTencentBizUiCustomScrollView.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels + "  inch=" + Math.abs(paramMotionEvent1.getX()) / this.jdField_a_of_type_ComTencentBizUiCustomScrollView.jdField_a_of_type_AndroidUtilDisplayMetrics.xdpi * 25.4D);
      }
      if ((f1 < 0.0F) && (f2 < 0.5F) && (this.jdField_a_of_type_ComTencentBizUiCustomScrollView.jdField_a_of_type_AndroidUtilDisplayMetrics != null) && (Math.abs(paramMotionEvent1.getX()) / this.jdField_a_of_type_ComTencentBizUiCustomScrollView.jdField_a_of_type_AndroidUtilDisplayMetrics.xdpi * 25.4D < 8.0D) && (this.jdField_a_of_type_ComTencentBizUiCustomScrollView.jdField_a_of_type_ComTencentBizUiCustomScrollView$OnGestureListener != null))
      {
        this.jdField_a_of_type_ComTencentBizUiCustomScrollView.setGestureFlag(-1);
        this.jdField_a_of_type_ComTencentBizUiCustomScrollView.jdField_a_of_type_ComTencentBizUiCustomScrollView$OnGestureListener.c();
      }
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomScrollView.c()) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if (this.jdField_a_of_type_ComTencentBizUiCustomScrollView.b()) {
      if ((Math.abs(f1) > this.jdField_a_of_type_Float) && (paramFloat1 < 0.0F) && (f2 < 0.5F)) {
        this.jdField_a_of_type_ComTencentBizUiCustomScrollView.setGestureFlag(1);
      }
    }
    for (;;)
    {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      if ((this.jdField_a_of_type_ComTencentBizUiCustomScrollView.a(1)) && ((paramFloat1 > 0.0F) || (f2 >= 0.5F))) {
        this.jdField_a_of_type_ComTencentBizUiCustomScrollView.setGestureFlag(-1);
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomScrollView.setGestureFlag(-1);
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\CustomScrollView$TopGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */