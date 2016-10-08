package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import wlb;

public class CircleProgressView
  extends View
{
  public static final int a = 3;
  private static final String jdField_a_of_type_JavaLangString = "CircleProgressView";
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public CircleProgressView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 10;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.g = 4;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    d();
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = 10;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.g = 4;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    d();
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt / 100.0F * 360.0F);
  }
  
  private void d()
  {
    this.e = ((int)(getResources().getDisplayMetrics().density * 3.0F + 0.5F));
    this.g = ((int)(getResources().getDisplayMetrics().density * 2.0F + 0.5F));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFlags(1);
    setBackgroundColor(0);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "showLoading() mIndeterminate = " + this.jdField_b_of_type_Boolean + ",mAnimationRuning = " + this.jdField_c_of_type_Boolean);
    }
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.e("CircleProgressView", 2, "showLoading()  just return");
      }
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_c_of_type_Boolean = true;
    this.f = 0;
    this.d = 0;
    this.jdField_a_of_type_AndroidOsHandler.post(new wlb(this, null));
  }
  
  public boolean a()
  {
    return getVisibility() == 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "dismissLoading() mIndeterminate = " + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CircleProgressView", 2, "dismissLoading() mIndeterminate = false, just return");
      }
      return;
    }
    setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_c_of_type_Boolean = false;
    this.f = 0;
    this.d = 0;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "hide() mIndeterminate = " + this.jdField_b_of_type_Boolean);
    }
    setVisibility(4);
    if (this.jdField_b_of_type_Boolean)
    {
      b();
      return;
    }
    this.d = 0;
    this.f = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_Boolean)
      {
        paramCanvas.rotate(-36.0F, this.jdField_b_of_type_Int / 2, this.jdField_c_of_type_Int / 2);
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, this.f, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      for (;;)
      {
        paramCanvas.restore();
        return;
        paramCanvas.rotate(222.0F, this.jdField_b_of_type_Int / 2, this.jdField_c_of_type_Int / 2);
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, this.f, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    paramCanvas.save();
    paramCanvas.rotate(this.f, this.jdField_b_of_type_Int / 2, this.jdField_c_of_type_Int / 2);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 40.0F, false, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.e -= this.g;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.e, this.e, this.jdField_b_of_type_Int - this.e, this.jdField_c_of_type_Int - this.e);
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CircleProgressView", 2, "setIndeterminate() change mIndeterminate = " + this.jdField_b_of_type_Boolean);
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "setProgress() progress = " + paramInt);
    }
    if ((paramInt < 0) || (paramInt > 100)) {}
    do
    {
      return;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("CircleProgressView", 2, "setProgress() mIndeterminate = true, just return");
    return;
    if (!a()) {
      setVisibility(0);
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    int i = paramInt;
    if (paramInt <= 2) {
      i = 2;
    }
    this.d = i;
    this.f = a(this.d);
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\CircleProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */