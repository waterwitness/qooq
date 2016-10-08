package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GradientProgressView
  extends View
{
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  SweepGradient jdField_a_of_type_AndroidGraphicsSweepGradient;
  int b;
  int c;
  int d;
  
  public GradientProgressView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 5;
    this.b = 0;
    this.c = 0;
    this.d = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public GradientProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 5;
    this.b = 0;
    this.c = 0;
    this.d = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int i = this.c;
      int j = this.d;
      this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(paramInt1 / 2, paramInt2 / 2, new int[] { i, j }, new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, paramInt1 - this.jdField_a_of_type_Int, paramInt2 - this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsSweepGradient == null) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.b += 3;
    if (this.b > 360) {
      this.b -= 360;
    }
    paramCanvas.rotate(this.b, i / 2, j / 2);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, true, this.jdField_a_of_type_AndroidGraphicsPaint);
    postInvalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void setEndColor(int paramInt)
  {
    this.d = paramInt;
    a(getWidth(), getHeight());
  }
  
  public void setStartColor(int paramInt)
  {
    this.c = paramInt;
    a(getWidth(), getHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\GradientProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */