package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopMemberListSlideItem
  extends FrameLayout
{
  protected int a;
  protected View a;
  protected Scroller a;
  private boolean a;
  protected View b;
  
  public TroopMemberListSlideItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(paramContext);
  }
  
  public TroopMemberListSlideItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    if (getScrollX() > 0) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, this.jdField_a_of_type_Int, 0);
    }
    for (;;)
    {
      invalidate();
      return;
      scrollTo(this.jdField_a_of_type_Int, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if (getScrollX() == 0) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_Int, 0, -this.jdField_a_of_type_Int, 0);
    }
    for (;;)
    {
      invalidate();
      return;
      scrollTo(0, 0);
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), 0);
      invalidate();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    this.b = getChildAt(1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
    this.b.layout(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + this.b.getMeasuredWidth(), this.b.getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = this.b.getMeasuredWidth();
  }
  
  public void setSlideEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      setClickable(true);
      return;
    }
    setClickable(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\TroopMemberListSlideItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */