package com.tencent.widget.calloutpopupwindow;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.shapes.Shape;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TriangleShape
  extends Shape
{
  private int jdField_a_of_type_Int;
  Path jdField_a_of_type_AndroidGraphicsPath;
  
  public TriangleShape(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    PointF localPointF1 = null;
    PointF localPointF3;
    PointF localPointF2;
    if (paramInt == 33)
    {
      localPointF3 = new PointF(0.0F, paramFloat2);
      localPointF2 = new PointF(paramFloat1, paramFloat2);
      localPointF1 = new PointF(paramFloat1 / 2.0F, 0.0F);
    }
    for (;;)
    {
      if (localPointF3 != null) {
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localPointF3.x, localPointF3.y);
      }
      if (localPointF2 != null) {
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localPointF2.x, localPointF2.y);
      }
      if (localPointF1 != null) {
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localPointF1.x, localPointF1.y);
      }
      return;
      localPointF2 = null;
      localPointF3 = null;
    }
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    a(getWidth(), getHeight(), this.jdField_a_of_type_Int);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, paramPaint);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\calloutpopupwindow\TriangleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */