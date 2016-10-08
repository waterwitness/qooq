package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RadioButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class RedDotRadioButton
  extends RadioButton
{
  private static final int jdField_a_of_type_Int = 9;
  private static final int b = 2;
  private static final int c = 2;
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  private int d = (int)(this.jdField_a_of_type_Float * 9.0F + 0.5D);
  
  public RedDotRadioButton(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843321);
    }
    invalidate();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
      float f1 = Layout.getDesiredWidth(getText(), getPaint());
      float f2 = localFontMetrics.descent;
      float f3 = localFontMetrics.ascent;
      int j = getWidth();
      int i = getHeight();
      float f4 = j / 2;
      int k = (int)Math.ceil(f1 / 2.0F + f4 - this.jdField_a_of_type_Float * 2.0F);
      j = (int)Math.ceil(i / 2 - (f2 - f3) / 2.0F - this.d + 4.0F * this.jdField_a_of_type_Float);
      if (QLog.isColorLevel()) {
        QLog.i(RedDotRadioButton.class.getSimpleName(), 2, "reddot y:" + j);
      }
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, this.d + k, this.d + i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\RedDotRadioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */