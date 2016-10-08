package com.tencent.mobileqq.widget;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ContainerView$NoSelLinkMovementMethod
  extends LinkMovementMethod
{
  private static NoSelLinkMovementMethod a;
  
  public ContainerView$NoSelLinkMovementMethod()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static MovementMethod a()
  {
    if (a == null) {
      a = new NoSelLinkMovementMethod();
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
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (localObject.length != 0)
      {
        if (i == 1) {
          localObject[0].onClick(paramTextView);
        }
        for (;;)
        {
          return true;
          if (i == 0)
          {
            Rect localRect = new Rect();
            paramTextView.getGlobalVisibleRect(localRect);
            if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
              Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]));
            }
          }
        }
      }
      Selection.removeSelection(paramSpannable);
    }
    return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ContainerView$NoSelLinkMovementMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */