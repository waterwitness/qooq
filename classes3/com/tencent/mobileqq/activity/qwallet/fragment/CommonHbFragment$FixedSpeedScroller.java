package com.tencent.mobileqq.activity.qwallet.fragment;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CommonHbFragment$FixedSpeedScroller
  extends Scroller
{
  private int jdField_a_of_type_Int;
  
  public CommonHbFragment$FixedSpeedScroller(CommonHbFragment paramCommonHbFragment, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 300;
  }
  
  public CommonHbFragment$FixedSpeedScroller(CommonHbFragment paramCommonHbFragment, Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
    this.jdField_a_of_type_Int = 300;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_a_of_type_Int);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\fragment\CommonHbFragment$FixedSpeedScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */