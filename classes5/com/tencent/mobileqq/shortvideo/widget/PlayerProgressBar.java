package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PlayerProgressBar
  extends View
{
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public int b;
  public int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public PlayerProgressBar(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1;
    this.b = 1;
    this.c = 1;
    this.d = -14342358;
    this.e = -15550475;
    this.f = -10066330;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public PlayerProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 1;
    this.b = 1;
    this.c = 1;
    this.d = -14342358;
    this.e = -15550475;
    this.f = -10066330;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  private int a(int paramInt)
  {
    if (this.g == this.c) {
      return paramInt;
    }
    int i = this.g * paramInt / this.c;
    paramInt = i;
    if (i <= 0) {
      paramInt = 1;
    }
    return paramInt;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.jdField_a_of_type_Int) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.jdField_a_of_type_Int;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {}
    int j;
    int i;
    do
    {
      return;
      if (this.b > this.jdField_a_of_type_Int) {
        this.b = this.jdField_a_of_type_Int;
      }
      j = super.getWidth();
      int k = super.getHeight();
      i = a(this.b, j);
      this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = k;
      this.jdField_a_of_type_AndroidGraphicsRect.left = i;
      this.jdField_a_of_type_AndroidGraphicsRect.right = j;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      j = a(i);
      this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
      this.jdField_a_of_type_AndroidGraphicsRect.right = j;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    } while (j >= i);
    this.jdField_a_of_type_AndroidGraphicsRect.left = j;
    this.jdField_a_of_type_AndroidGraphicsRect.right = i;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setCurrentProgress(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.g = this.c;; this.g = paramInt)
    {
      super.postInvalidate();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\widget\PlayerProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */