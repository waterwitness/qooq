package com.tencent.mobileqq.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ClickableImageSpan
  extends OffsetableImageSpan
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ClickableImageSpan.ClickableImageSpanListener jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan$ClickableImageSpanListener;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ClickableImageSpan(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    super(null, 0);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(jdField_a_of_type_ArrayOfInt, paramDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, paramDrawable1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localStateListDrawable;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, paramDrawable2.getBounds().right, paramDrawable2.getBounds().bottom);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(StateSet.WILD_CARD);
    paramView.invalidate();
  }
  
  public void a(ClickableImageSpan.ClickableImageSpanListener paramClickableImageSpanListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan$ClickableImageSpanListener = paramClickableImageSpanListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      return false;
      i = paramMotionEvent.getAction();
    } while (i == 2);
    if (i == 0) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(jdField_a_of_type_ArrayOfInt);
    }
    for (;;)
    {
      if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan$ClickableImageSpanListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan$ClickableImageSpanListener.a(this);
      }
      paramView.invalidate();
      return true;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(StateSet.WILD_CARD);
    }
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(jdField_a_of_type_ArrayOfInt);
    paramView.invalidate();
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ClickableImageSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */