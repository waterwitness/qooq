package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

public class ExtendInputMethodRelativeLayout
  extends InputMethodRelativeLayout
{
  private ExtendInputMethodRelativeLayout.OnDownListener a;
  
  public ExtendInputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.a == null) || (!this.a.a(paramMotionEvent))) {}
    }
    else {
      while ((this.a != null) && (this.a.b(paramMotionEvent))) {
        return true;
      }
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public void setOnDownListener(ExtendInputMethodRelativeLayout.OnDownListener paramOnDownListener)
  {
    this.a = paramOnDownListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\ExtendInputMethodRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */