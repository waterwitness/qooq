package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TriangleView
  extends View
{
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  Paint b;
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.b = new Paint();
    this.b.setColor(-2170912);
    this.b.setStrokeWidth(2.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredHeight();
    int j = 150 + i * 2;
    int k = 150 + i;
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(k, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo('', i);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(j, i);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.b.setStrokeWidth(1.0F);
    paramCanvas.drawLine(k, 0.0F, '', i, this.b);
    paramCanvas.drawLine(k, 0.0F, j, i, this.b);
    this.b.setStrokeWidth(2.0F);
    paramCanvas.drawLine(0.0F, i, '', i, this.b);
    paramCanvas.drawLine(j, i, getMeasuredWidth(), i, this.b);
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\widgets\TriangleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */