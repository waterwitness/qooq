package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import xuq;

public class RangeButtonView$Title
{
  float jdField_a_of_type_Float;
  public Point a;
  String jdField_a_of_type_JavaLangString;
  
  public RangeButtonView$Title(String paramString, float paramFloat)
  {
    this(paramString, paramFloat, null);
  }
  
  public RangeButtonView$Title(String paramString, float paramFloat, Point paramPoint)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a()
  {
    return (int)RangeButtonView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, xuq paramxuq)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPoint == null) {
      return;
    }
    paramPaint.setTextSize(this.jdField_a_of_type_Float);
    int i = paramPaint.getColor();
    paramPaint.setColor(paramxuq.a);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, paramPaint);
    paramPaint.setColor(i);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\RangeButtonView$Title.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */