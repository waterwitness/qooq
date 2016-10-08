package com.tencent.biz.qqstory.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RingView$DrawInfo
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public RingView$DrawInfo(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, int paramInt4, float paramFloat2, int paramInt5, int paramInt6, Paint.Style paramStyle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Int = paramInt4;
    this.jdField_b_of_type_Float = paramFloat2;
    this.e = paramInt5;
    this.f = paramInt6;
    c();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(paramStyle);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Int <= 0) && ((this.jdField_a_of_type_Float <= 0.0F) || (this.jdField_a_of_type_Float > 1.0F))) {
      throw new IllegalArgumentException("radius/radiusRatio = " + this.jdField_a_of_type_Int + "/" + this.jdField_a_of_type_Float + " is invalid !");
    }
    if ((this.jdField_b_of_type_Int <= 0) && ((this.jdField_b_of_type_Float <= 0.0F) || (this.jdField_b_of_type_Float > 1.0F))) {
      throw new IllegalArgumentException("mThickness/mThicknessRatio = " + this.jdField_b_of_type_Int + "/" + this.jdField_b_of_type_Float + " is invalid !");
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat;
    if ((this.jdField_a_of_type_Int <= 0) && ((this.jdField_a_of_type_Float <= 0.0F) || (this.jdField_a_of_type_Float > 1.0F))) {
      throw new IllegalArgumentException("radius/radiusRatio = " + this.jdField_a_of_type_Int + "/" + this.jdField_a_of_type_Float + " is invalid !");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (!this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getStyle() == Paint.Style.STROKE) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, bool, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.c, this.d - this.c, bool, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.g == paramInt1) && (this.h == paramInt2) && (this.i == paramInt3)) {
      return false;
    }
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    int j;
    if (this.jdField_a_of_type_Int > 0)
    {
      j = this.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Int <= 0) {
        break label153;
      }
    }
    label153:
    for (paramInt3 = this.jdField_b_of_type_Int;; paramInt3 = (int)(this.jdField_b_of_type_Float * paramInt3))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt3);
      paramInt3 = j - paramInt3 / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (paramInt1 - paramInt3);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (paramInt1 + paramInt3);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (paramInt2 - paramInt3);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (paramInt3 + paramInt2);
      this.jdField_a_of_type_Boolean = false;
      return true;
      j = (int)(this.jdField_a_of_type_Float * paramInt3);
      break;
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(int paramInt, float paramFloat)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Float = paramFloat;
    if ((this.jdField_b_of_type_Int <= 0) && ((this.jdField_b_of_type_Float <= 0.0F) || (this.jdField_b_of_type_Float > 1.0F))) {
      throw new IllegalArgumentException("mThickness/mThicknessRatio = " + this.jdField_b_of_type_Int + "/" + this.jdField_b_of_type_Float + " is invalid !");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    return this == paramObject;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DrawInfo{mAngleStart=" + this.c + ", mAngleEnd=" + this.d + ", mRadius=" + this.jdField_a_of_type_Int + ", mRadiusRatio=" + this.jdField_a_of_type_Float + ", mThickness=" + this.jdField_b_of_type_Int + ", mThicknessRatio=" + this.jdField_b_of_type_Float + ", mForeground=" + this.e + ", mBackground=" + this.f + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\RingView$DrawInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */