package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LyricView
  extends FrameLayout
{
  private static final String a = "LyricView";
  protected LyricViewAttribute a;
  protected LyricViewInternal a;
  protected LyricViewScroll a;
  protected boolean a;
  protected boolean b;
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.S, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewAttribute = new LyricViewAttribute();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewAttribute.a(paramContext);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(15, false);
    paramContext.recycle();
  }
  
  public LyricViewInternal a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal;
  }
  
  public LyricViewScroll a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.a(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(paramInt4 - paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
    {
      a(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void setIsDealTouchEvent(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\widget\LyricView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */