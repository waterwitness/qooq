package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OffsetableImageSpan
  extends ImageSpan
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  
  public OffsetableImageSpan(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OffsetableImageSpan a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    return this;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramInt2 = paramInt5 - paramCharSequence.getBounds().bottom;
    paramInt1 = paramInt2;
    if (this.mVerticalAlignment == 1) {
      paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Float != 0.0F)) {
      this.jdField_a_of_type_Int = ((int)((paramInt5 - paramInt3) * this.jdField_a_of_type_Float));
    }
    paramCanvas.translate(paramFloat, paramInt1 + this.jdField_a_of_type_Int);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\OffsetableImageSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */