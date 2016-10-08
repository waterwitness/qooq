package com.tencent.mobileqq.troop.text;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ReplyClickMovementMethod
  extends LinkMovementMethod
{
  private static ReplyClickMovementMethod a;
  
  public ReplyClickMovementMethod()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static MovementMethod a()
  {
    if (a == null) {
      a = new ReplyClickMovementMethod();
    }
    return a;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (paramTextView.getTag(2131296537) != null)
      {
        ReplyedMessageSpan localReplyedMessageSpan = (ReplyedMessageSpan)paramTextView.getTag(2131296537);
        Drawable localDrawable = localReplyedMessageSpan.getDrawable();
        if ((localDrawable != null) && (new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight()).contains(i, j)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("zivonchen", 2, "我擦呢,命中------------------");
          }
          localReplyedMessageSpan.a(paramTextView);
          return true;
        }
      }
    }
    return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\text\ReplyClickMovementMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */