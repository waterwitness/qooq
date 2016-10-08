package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQViewPager
  extends ViewPager
{
  private boolean a;
  
  public QQViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    ViewGroup localViewGroup;
    if (this.a)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label43;
      }
      localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null) {
        localViewGroup.requestDisallowInterceptTouchEvent(true);
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        label43:
        paramMotionEvent.printStackTrace();
      }
      if ((i == 1) || (i == 3))
      {
        localViewGroup = (ViewGroup)getParent();
        if (localViewGroup != null) {
          localViewGroup.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\QQViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */