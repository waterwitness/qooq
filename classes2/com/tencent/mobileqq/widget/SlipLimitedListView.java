package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SlipLimitedListView
  extends SlideDetectListView
{
  private Rect a;
  
  public SlipLimitedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new Rect();
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      i = 0;
    }
    for (;;)
    {
      View localView;
      if (i < paramView.getChildCount())
      {
        localView = paramView.getChildAt(i);
        if ((localView instanceof WorkSpaceView))
        {
          paramView = (WorkSpaceView)localView;
          paramView.getGlobalVisibleRect(this.a);
        }
      }
      else
      {
        return (paramView.isShown()) && (this.a.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      }
      if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramMotionEvent))) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) && (a(this, paramMotionEvent))) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\SlipLimitedListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */