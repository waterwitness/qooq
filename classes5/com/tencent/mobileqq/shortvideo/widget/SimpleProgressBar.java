package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

public class SimpleProgressBar
  extends View
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = SimpleProgressBar.class.getSimpleName();
  public static final int b = 2;
  public static int e = -16737062;
  public static int f = -2083835;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public int c = 2;
  public int d;
  private int g;
  private final int h = -1;
  private final int i = ScreenUtil.a(3.0F);
  private int j = e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SimpleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.d) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.d;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  private void a(Canvas paramCanvas)
  {
    int k = super.getWidth();
    int m = super.getHeight();
    int n = a(this.g, k);
    int i1 = n / 2;
    this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = m;
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.right = i1;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (n < k)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = i1;
      this.jdField_a_of_type_AndroidGraphicsRect.right = (k - i1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = (k - i1);
    this.jdField_a_of_type_AndroidGraphicsRect.right = k;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b(Canvas paramCanvas)
  {
    int k = super.getWidth();
    int m = super.getHeight();
    int n = a(this.g, k);
    this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = m;
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.right = n;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.rgb(0, 156, 218));
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (n < k)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = n;
      this.jdField_a_of_type_AndroidGraphicsRect.right = (this.i + n);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.i + n < k)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = (n + this.i);
      this.jdField_a_of_type_AndroidGraphicsRect.right = k;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.rgb(36, 36, 45));
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {
      return;
    }
    if (this.c == 2)
    {
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }
  
  public void setCurrentProgress(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setProgress, progress = " + paramInt + ",isOver = " + paramBoolean);
    }
    if (paramBoolean) {}
    for (this.g = this.d;; this.g = paramInt)
    {
      postInvalidate();
      return;
    }
  }
  
  public void setProgressColor(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      invalidate();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\widget\SimpleProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */