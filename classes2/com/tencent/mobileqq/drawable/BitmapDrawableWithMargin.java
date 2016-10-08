package com.tencent.mobileqq.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BitmapDrawableWithMargin
  extends BitmapDrawable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b;
  private int c;
  
  public BitmapDrawableWithMargin(Resources paramResources, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramResources, paramBitmap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_Float = 1920.0F;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Float = (12.0F * (paramResources.getDisplayMetrics().densityDpi / 160.0F));
    super.setGravity(17);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.c >>> 24 != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      paramCanvas.drawRoundRect(new RectF(getBounds()), this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.b > 0) {
      return this.b;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.jdField_a_of_type_Int;
    }
    return super.getIntrinsicWidth();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha()) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public void setTargetDensity(int paramInt)
  {
    this.jdField_a_of_type_Float = (12.0F * (paramInt / 160.0F));
    super.setTargetDensity(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\drawable\BitmapDrawableWithMargin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */