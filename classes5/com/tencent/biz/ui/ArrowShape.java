package com.tencent.biz.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RectShape;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArrowShape
  extends RectShape
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  private int c;
  
  public ArrowShape()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 2;
    this.b = 50;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    float f1 = this.jdField_a_of_type_Float * 2.0F;
    RectF localRectF = new RectF(rect());
    localRectF.bottom -= f1 / 2.0F;
    localRectF.top += f1 / 2.0F;
    paramPaint.setStrokeWidth(f1);
    paramPaint.setColor(this.c);
    float f2 = (float)Math.tan(0.8726646676090568D) * (localRectF.bottom - localRectF.top);
    if (this.jdField_a_of_type_Boolean)
    {
      localPointF = new PointF((localRectF.left + localRectF.right) / 2.0F, localRectF.top);
      f3 = localPointF.x;
      paramCanvas.drawLine(f1 / 3.0F + f3, localPointF.y, localPointF.x - f2, localRectF.bottom, paramPaint);
      paramCanvas.drawLine(localPointF.x - f1 / 3.0F, localPointF.y, localPointF.x + f2, localRectF.bottom, paramPaint);
      return;
    }
    PointF localPointF = new PointF((localRectF.left + localRectF.right) / 2.0F, localRectF.bottom);
    float f3 = localPointF.x;
    paramCanvas.drawLine(f1 / 3.0F + f3, localPointF.y, localPointF.x - f2, localRectF.top, paramPaint);
    paramCanvas.drawLine(localPointF.x - f1 / 3.0F, localPointF.y, localPointF.x + f2, localRectF.top, paramPaint);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\ArrowShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */