package com.tencent.mobileqq.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PagingScrollView$YScrollDetector
  extends GestureDetector.SimpleOnGestureListener
{
  protected PagingScrollView$YScrollDetector()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (paramFloat2 > paramFloat1)
    {
      if (paramFloat1 < 0.01F) {}
      while (paramFloat2 / paramFloat1 > 1.73205F) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\PagingScrollView$YScrollDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */