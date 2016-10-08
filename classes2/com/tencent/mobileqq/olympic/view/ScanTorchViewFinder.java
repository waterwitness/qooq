package com.tencent.mobileqq.olympic.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tsd;

public class ScanTorchViewFinder
  extends View
{
  public static final long a = 20L;
  public static final long b = 5000L;
  protected double a;
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  protected int c;
  long c;
  protected int d;
  
  public ScanTorchViewFinder(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  public ScanTorchViewFinder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  public ScanTorchViewFinder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839566);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839576);
    this.d = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1275068416);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if ((localRect == null) || (localRect.width() == 0) || (localRect.height() == 0)) {
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    do
    {
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, localRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, localRect.top, localRect.left, localRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(localRect.right, localRect.top, this.jdField_a_of_type_Int, localRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, localRect.bottom, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    } while (!this.jdField_a_of_type_Boolean);
    int i = (int)((System.currentTimeMillis() - this.jdField_c_of_type_Long) * this.jdField_a_of_type_Double) % this.jdField_c_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left, localRect.top + i, localRect.right, i + localRect.top + this.d);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    postInvalidateDelayed(20L, localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    invalidate();
  }
  
  public void postInvalidateDelayed(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.postInvalidateDelayed(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    postDelayed(new tsd(this, paramInt1, paramInt2, paramInt3, paramInt4), paramLong);
  }
  
  public void setViewFinderRect(Rect paramRect)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top - this.d);
    this.jdField_a_of_type_Double = (this.jdField_c_of_type_Int / 5000.0D);
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\view\ScanTorchViewFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */