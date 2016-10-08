package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CircleProgress
  extends ImageView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  
  public CircleProgress(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public CircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.b = getResources().getColor(2131427421);
    this.d = getResources().getColor(2131427492);
    this.c = 51;
    this.e = 255;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.f = getWidth();
    this.g = getHeight();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.c * 255 / 100);
    paramCanvas.drawArc(new RectF(this.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Int / 2, this.f - this.jdField_a_of_type_Int / 2, this.g - this.jdField_a_of_type_Int / 2), -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.e * 255 / 100);
    paramCanvas.drawArc(new RectF(this.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Int / 2, this.f - this.jdField_a_of_type_Int / 2, this.g - this.jdField_a_of_type_Int / 2), -90.0F, (float)(3.6D * this.h), false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setBgAndProgressColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt2;
    this.c = paramInt1;
    this.d = paramInt4;
    this.e = paramInt3;
  }
  
  public void setProgress(int paramInt)
  {
    int i = 100;
    if (paramInt > 100) {}
    for (;;)
    {
      this.h = i;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.h = i;
      invalidate();
      return;
      i = paramInt;
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * paramFloat + 0.5D));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\CircleProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */