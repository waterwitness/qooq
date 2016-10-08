package com.tencent.mobileqq.camera.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QCameraFocusUI
  extends View
{
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.ui.QCameraFocusUI";
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private int b = 7;
  private int c = 50;
  
  public QCameraFocusUI(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QCameraFocusUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCameraFocusUI(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsRect != null)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, 0, 0);
        this.c = 0;
        this.jdField_a_of_type_Int = 0;
        invalidate();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidGraphicsRect.left;
    i = this.jdField_a_of_type_AndroidGraphicsRect.top;
    i = this.jdField_a_of_type_AndroidGraphicsRect.right;
    i = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    i = this.jdField_a_of_type_Int / 2;
    int j = this.jdField_a_of_type_Int / 3;
    int k = this.jdField_a_of_type_Int - j;
    int m = this.jdField_a_of_type_Int / 4;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.b + 0, 0 + j);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0 + k, this.b + 0, this.jdField_a_of_type_Int + 0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, 0 + j, this.b + 0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0 + k, 0, this.jdField_a_of_type_Int + 0, this.b + 0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_Int + 0 - this.b, 0, this.jdField_a_of_type_Int + 0, this.jdField_a_of_type_Int / 3 + 0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_Int + 0 - this.b, 0 + k, this.jdField_a_of_type_Int + 0, this.jdField_a_of_type_Int + 0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, this.jdField_a_of_type_Int + 0 - this.b, j + 0, this.jdField_a_of_type_Int + 0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(k + 0, this.jdField_a_of_type_Int + 0 - this.b, this.jdField_a_of_type_Int + 0, this.jdField_a_of_type_Int + 0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0 + i - m / 2, 0 + i - this.b / 2, 0 + i + m / 2, 0 + i + this.b / 2);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0 + i - this.b / 2, 0 + i - m / 2, 0 + i + this.b / 2, i + 0 + m / 2);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = i;
    if (i > this.jdField_a_of_type_Int) {
      paramInt1 = this.jdField_a_of_type_Int;
    }
    i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = i;
    if (i > this.jdField_a_of_type_Int) {
      paramInt2 = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = Math.min(paramInt1, paramInt2);
    super.setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setParameter(Rect paramRect, int paramInt)
  {
    if (paramRect != null) {}
    try
    {
      if ((!paramRect.equals(this.jdField_a_of_type_AndroidGraphicsRect)) || (this.c != paramInt))
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
        this.c = paramInt;
        this.jdField_a_of_type_Int = Math.abs(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right);
        invalidate();
      }
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\ui\QCameraFocusUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */