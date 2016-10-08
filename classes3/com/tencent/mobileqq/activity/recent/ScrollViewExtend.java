package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ScrollView;

public class ScrollViewExtend
  extends ScrollView
{
  private float a;
  private float c;
  private float d;
  private float e;
  
  public ScrollViewExtend(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ScrollViewExtend(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollViewExtend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      setFillViewport(true);
      setFadingEdgeLength(0);
      setHorizontalFadingEdgeEnabled(false);
      setVerticalFadingEdgeEnabled(false);
      setHorizontalScrollBarEnabled(false);
      setVerticalScrollBarEnabled(false);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.c = 0.0F;
        this.a = 0.0F;
        this.d = paramMotionEvent.getX();
        this.e = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.a += Math.abs(f1 - this.d);
      this.c += Math.abs(f2 - this.e);
      this.d = f1;
      this.e = f2;
    } while (this.a <= this.c);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\ScrollViewExtend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */