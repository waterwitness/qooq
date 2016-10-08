package com.tencent.mobileqq.activity.book;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ogm;

public class ResizeLayout
  extends ScrollView
{
  private ResizeLayout.OnResizeListener jdField_a_of_type_ComTencentMobileqqActivityBookResizeLayout$OnResizeListener;
  private boolean jdField_a_of_type_Boolean;
  
  public ResizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isInEditMode()) {}
    for (;;)
    {
      return;
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramInt2 > paramInt4) {}
      for (this.jdField_a_of_type_Boolean = false; this.jdField_a_of_type_ComTencentMobileqqActivityBookResizeLayout$OnResizeListener != null; this.jdField_a_of_type_Boolean = true)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new ogm(this, paramInt1, paramInt2, paramInt3, paramInt4), 50L);
        return;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnResizeListener(ResizeLayout.OnResizeListener paramOnResizeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBookResizeLayout$OnResizeListener = paramOnResizeListener;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\book\ResizeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */