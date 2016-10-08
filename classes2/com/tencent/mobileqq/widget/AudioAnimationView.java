package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import wku;

public class AudioAnimationView
  extends View
{
  static final int jdField_a_of_type_Int = 2;
  static final String jdField_a_of_type_JavaLangString = "AudioAnimationView";
  static final int b = 2;
  static final int c = 12;
  static final int d = 100;
  public static final int e = 1;
  public static final int f = 2;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public volatile boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Rect[] jdField_a_of_type_ArrayOfAndroidGraphicsRect;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public AudioAnimationView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 7;
    this.k = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    a();
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.j = 7;
    this.k = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    a();
  }
  
  public static int a(int paramInt, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    this.g = a(2, getResources());
    this.h = a(2, getResources());
    this.i = a(12, getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(4.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(204);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    int n = (int)(this.i * 0.6777F);
    int m = 0;
    while (m < this.j)
    {
      this.jdField_a_of_type_ArrayOfInt[m] = ((int)(n * Math.random()));
      m += 1;
    }
  }
  
  public void c()
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioAnimationView", 2, "startAnimation(), mRunning= " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new wku(this, null));
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioAnimationView", 2, "stopAnimation(), mRunning= " + this.jdField_a_of_type_Boolean);
    }
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      requestLayout();
      invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      int m = 0;
      if (m < this.j)
      {
        Rect localRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[m];
        int i1 = this.g;
        int i2 = this.h;
        int i3 = this.jdField_a_of_type_ArrayOfInt[m];
        int i4 = this.g;
        int i5 = this.h;
        int n = this.i;
        if (this.k == 1) {}
        for (n = this.i - this.jdField_a_of_type_ArrayOfInt[m];; n = this.i)
        {
          localRect.set((i1 + i2) * m, i3, i5 * m + i4 * (m + 1), n);
          paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          m += 1;
          break;
        }
      }
    }
    else if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt1 = this.j;
      paramInt2 = this.g;
      paramInt2 = (this.j - 1) * this.h + paramInt1 * paramInt2;
      paramInt1 = this.i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        paramInt2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      }
      else
      {
        paramInt2 = 0;
        paramInt1 = m;
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    }
    requestLayout();
    invalidate();
  }
  
  public void setRectCount(int paramInt)
  {
    this.j = paramInt;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = new Rect[this.j];
    this.jdField_a_of_type_ArrayOfInt = new int[this.j];
    paramInt = 0;
    while (paramInt <= this.j - 1)
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt] = new Rect();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
      paramInt += 1;
    }
    b();
    requestLayout();
    invalidate();
  }
  
  public void setRectHeightMax(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setRectInterval(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setRectWidth(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setSyle(int paramInt)
  {
    this.k = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\AudioAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */