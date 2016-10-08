package com.tencent.mobileqq.activity;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mty;

public class TroopMemberCardActivity$ClickableMovementMethod
  extends LinkMovementMethod
{
  public static ClickableMovementMethod a;
  
  public TroopMemberCardActivity$ClickableMovementMethod()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static ClickableMovementMethod a()
  {
    if (a == null) {
      a = new ClickableMovementMethod();
    }
    return a;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      paramMotionEvent = paramTextView.getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramMotionEvent = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      mty[] arrayOfmty = (mty[])paramSpannable.getSpans(j, j, mty.class);
      if (paramMotionEvent.length != 0)
      {
        if (i == 1) {
          paramMotionEvent[0].onClick(paramTextView);
        }
        for (;;)
        {
          return true;
          if (i == 0) {
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramMotionEvent[0]), paramSpannable.getSpanEnd(paramMotionEvent[0]));
          }
        }
      }
      if (arrayOfmty.length != 0)
      {
        if (i == 1) {
          arrayOfmty[0].onClick(paramTextView);
        }
        for (;;)
        {
          return true;
          if (i == 0) {
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(arrayOfmty[0]), paramSpannable.getSpanEnd(arrayOfmty[0]));
          }
        }
      }
      Selection.removeSelection(paramSpannable);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopMemberCardActivity$ClickableMovementMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */