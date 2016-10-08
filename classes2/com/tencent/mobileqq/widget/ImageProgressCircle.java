package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageProgressCircle
  extends View
{
  private int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  private int d;
  
  public ImageProgressCircle(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = true;
    a(paramContext);
  }
  
  public ImageProgressCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = true;
    a(paramContext);
  }
  
  public ImageProgressCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = true;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130842480);
      int i = (int)(paramContext.getResources().getDisplayMetrics().density * 12.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(i);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.DEFAULT_BOLD);
      this.jdField_c_of_type_Boolean = true;
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131493107);
      this.jdField_a_of_type_Int = (this.jdField_c_of_type_Int / 2);
      this.jdField_b_of_type_Int = (this.jdField_c_of_type_Int / 2);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i;
    int j;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      paramCanvas.save();
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2;
      j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_Int - i, this.jdField_b_of_type_Int - j);
        this.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(5.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
      if (this.jdField_c_of_type_Boolean)
      {
        if (this.d < 10) {
          break label189;
        }
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, (float)(this.jdField_a_of_type_Int - i * 0.66D), (float)(this.jdField_b_of_type_Int + j * 0.25D), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      postInvalidate();
      return;
      label189:
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, (float)(this.jdField_a_of_type_Int - i * 0.25D), (float)(this.jdField_b_of_type_Int + j * 0.25D), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 - paramInt1 == 0)
    {
      layout(paramInt1 - this.jdField_c_of_type_Int / 2, paramInt2, this.jdField_c_of_type_Int / 2 + paramInt3, paramInt4);
      return;
    }
    if (paramInt4 - paramInt2 == 0)
    {
      layout(paramInt1, paramInt2 - this.jdField_c_of_type_Int / 2, paramInt3, this.jdField_c_of_type_Int / 2 + paramInt4);
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setProgress(int paramInt)
  {
    int i = 99;
    if (paramInt >= 100) {
      this.jdField_a_of_type_Boolean = false;
    }
    paramInt = paramInt * 100 / 85;
    if (paramInt > 99) {
      paramInt = i;
    }
    for (;;)
    {
      this.d = paramInt;
      this.jdField_a_of_type_JavaLangString = (this.d + "%");
      postInvalidate();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ImageProgressCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */