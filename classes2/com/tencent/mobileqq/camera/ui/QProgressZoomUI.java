package com.tencent.mobileqq.camera.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QProgressZoomUI
  extends View
{
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.ui.QProgressZoomUI";
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect;
  int jdField_c_of_type_Int;
  Rect jdField_c_of_type_AndroidGraphicsRect;
  int jdField_d_of_type_Int;
  Rect jdField_d_of_type_AndroidGraphicsRect;
  int jdField_e_of_type_Int;
  Rect jdField_e_of_type_AndroidGraphicsRect;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  
  public QProgressZoomUI(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QProgressZoomUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QProgressZoomUI(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.aK, 0, 0);
    this.j = 12;
    this.jdField_e_of_type_Int = 40;
    this.f = this.j;
    this.g = 40;
    this.h = this.j;
    this.k = 24;
    this.l = 24;
    this.jdField_a_of_type_Int = 0;
    try
    {
      this.j = ((int)paramContext.getDimension(0, 12.0F));
      this.jdField_e_of_type_Int = ((int)paramContext.getDimension(1, 40.0F));
      this.f = this.j;
      this.g = ((int)paramContext.getDimension(2, 40.0F));
      this.h = this.j;
      this.k = ((int)paramContext.getDimension(3, 24.0F));
      this.l = ((int)paramContext.getDimension(4, 24.0F));
    }
    catch (Exception paramAttributeSet)
    {
      for (;;)
      {
        paramAttributeSet.printStackTrace();
        paramContext.recycle();
      }
    }
    finally
    {
      paramContext.recycle();
    }
    this.k = Math.round(this.k);
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.ui.QProgressZoomUI", 4, "[init] progressHigh=" + this.j + " minusWidth=" + this.jdField_e_of_type_Int + " plusWidth=" + this.g + " Radius=" + this.k + " padding=" + this.l);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_d_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_e_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (this.jdField_b_of_type_Int <= 0) {
      return;
    }
    this.jdField_d_of_type_AndroidGraphicsRect.set(0, 0, 0, 0);
    this.jdField_e_of_type_AndroidGraphicsRect.set(0, 0, 0, 0);
    getLeft();
    getTop();
    getRight();
    getBottom();
    int i3 = this.jdField_d_of_type_Int / 2;
    int n = this.jdField_c_of_type_Int - this.jdField_e_of_type_Int - this.g - this.l * 2;
    int m;
    int i1;
    int i5;
    int i2;
    int i4;
    if (this.jdField_b_of_type_Int > 0)
    {
      m = this.jdField_b_of_type_Int;
      m = n / m;
      i1 = this.jdField_b_of_type_Int * m;
      i5 = i1 + (n - i1);
      i2 = this.jdField_e_of_type_Int + this.l;
      i4 = i2 + i5;
      i1 = this.jdField_a_of_type_Int * m + i2 - this.k / 2;
      n = this.jdField_a_of_type_Int * m + i2 + this.k / 2;
      m = m * this.jdField_a_of_type_Int + i2;
      if (this.jdField_a_of_type_Int != 0) {
        break label620;
      }
      m = this.k / 2 + i2;
      n = this.k + i2;
      i1 = i2;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, i3 - this.f / 2, this.jdField_e_of_type_Int, this.f / 2 + i3);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      if (i2 < i1) {
        this.jdField_d_of_type_AndroidGraphicsRect.set(i2, i3 - this.j / 2, i1, this.j / 2 + i3);
      }
      paramCanvas.drawRect(this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      if (i4 > n) {
        this.jdField_e_of_type_AndroidGraphicsRect.set(n, i3 - this.j / 2, i4, this.j / 2 + i3);
      }
      paramCanvas.drawRect(this.jdField_e_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_b_of_type_AndroidGraphicsRect.set(this.l + i4, i3 - this.j / 2, this.l + i4 + this.g, this.j / 2 + i3);
      paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_AndroidGraphicsRect.left + this.g / 2 - this.h / 2, i3 - this.g / 2, this.jdField_b_of_type_AndroidGraphicsRect.left + this.g / 2 + this.h / 2, this.g / 2 + i3);
      paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.k / 4);
      paramCanvas.drawCircle(m, i3, this.k / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      m = 0;
      break;
      label620:
      if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int - 1)
      {
        m = i2 + i5 - this.k / 2;
        n = i2 + i5;
        i1 = n - this.k;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.ui.QProgressZoomUI", 4, "[onMeasure] widthMode is EXACTLY size=" + paramInt1);
      }
      if (n != 1073741824) {
        break label229;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.ui.QProgressZoomUI", 4, "[onMeasure] heightMode is EXACTLY size=" + paramInt2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.ui.QProgressZoomUI", 4, "[onMeasure] " + getLeft() + " " + getTop() + " " + getRight() + " " + getBottom());
      }
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramInt2;
      super.setMeasuredDimension(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      return;
      if ((m != Integer.MIN_VALUE) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("Q.camera.ui.QProgressZoomUI", 4, "[onMeasure] widthMode is AT_MOST size=" + paramInt1);
      break;
      label229:
      if ((n == Integer.MIN_VALUE) && (QLog.isColorLevel())) {
        QLog.d("Q.camera.ui.QProgressZoomUI", 4, "[onMeasure] heightMode is AT_MOST size=" + paramInt2);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setMax(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      if ((paramInt != this.jdField_a_of_type_Int) && (paramInt >= 0) && (paramInt <= this.jdField_b_of_type_Int))
      {
        this.jdField_a_of_type_Int = paramInt;
        postInvalidate();
      }
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\ui\QProgressZoomUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */