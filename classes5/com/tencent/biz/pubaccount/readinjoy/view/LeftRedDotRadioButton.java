package com.tencent.biz.pubaccount.readinjoy.view;

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

public class LeftRedDotRadioButton
  extends RadioButton
{
  private static final int jdField_a_of_type_Int = 9;
  private static final int b = 2;
  private static final int c = 2;
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  private int d = (int)(this.jdField_a_of_type_Float * 9.0F + 0.5D);
  
  public LeftRedDotRadioButton(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LeftRedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LeftRedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
      Layout.getDesiredWidth(getText(), getPaint());
      float f1 = localFontMetrics.descent;
      float f2 = localFontMetrics.ascent;
      getWidth();
      int j = (int)Math.ceil(getHeight() / 2 - (f1 - f2) / 2.0F - this.d + 4.0F * this.jdField_a_of_type_Float);
      if (QLog.isColorLevel()) {
        QLog.i(LeftRedDotRadioButton.class.getSimpleName(), 2, "reddot y:" + j);
      }
      int i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, i, this.d + 0, this.d + i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\LeftRedDotRadioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */