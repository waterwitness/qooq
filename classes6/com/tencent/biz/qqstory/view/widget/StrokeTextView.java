package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;

public class StrokeTextView
  extends TextView
{
  protected int a;
  protected TextPaint a;
  protected boolean a;
  protected int b;
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = -16777216;
    this.jdField_a_of_type_AndroidTextTextPaint = getPaint();
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mCurTextColor");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      localField.setAccessible(false);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.b);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(true);
      super.onDraw(paramCanvas);
      a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(0.0F);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(false);
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.b = paramInt;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.setTextColor(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\StrokeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */