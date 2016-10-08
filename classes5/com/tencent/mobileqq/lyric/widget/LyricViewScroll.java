package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Timer;
import tae;

public class LyricViewScroll
  extends ScrollView
{
  protected static final int a = 100;
  private static final String jdField_a_of_type_JavaLangString = "LyricViewScroll";
  private static final int jdField_c_of_type_Int = 500;
  protected Scroller a;
  private LyricViewScroll.LyricViewScrollListener jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener;
  public Timer a;
  public volatile boolean a;
  public volatile int b;
  private volatile boolean b;
  private volatile boolean jdField_c_of_type_Boolean;
  
  public LyricViewScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      paramInt -= this.jdField_b_of_type_Int;
      if (paramInt != 0)
      {
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), this.jdField_b_of_type_Int, 0, paramInt, 500);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getFinalY();
        invalidate();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      Log.v("LyricViewScroll", "default:" + paramMotionEvent.getAction());
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        Log.e("LyricViewScroll", paramMotionEvent.toString());
      }
      Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
      this.c = true;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilTimer != null))
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_Boolean = false;
        continue;
        this.c = true;
        if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener.a(getScrollY());
          continue;
          Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_JavaUtilTimer = new Timer();
            this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new tae(this), 100L, 100L);
            continue;
            Log.v("LyricViewScroll", "onTouchEvent -> ACTION_CANCEL");
            this.jdField_b_of_type_Int = getScrollY();
            this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener.b(this.jdField_b_of_type_Int);
            this.c = false;
            if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilTimer != null))
            {
              this.jdField_a_of_type_JavaUtilTimer.cancel();
              this.jdField_a_of_type_Boolean = false;
            }
          }
        }
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (!this.c)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      this.jdField_b_of_type_Int = paramInt;
      scrollTo(0, paramInt);
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) && (!this.c))
    {
      smoothScrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setScrollListener(LyricViewScroll.LyricViewScrollListener paramLyricViewScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener = paramLyricViewScrollListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\widget\LyricViewScroll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */