package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ProgressViewYellow
  extends View
{
  public int a;
  public long a;
  public Drawable a;
  public int b;
  public long b;
  public Drawable b;
  public int c;
  public Drawable c;
  public int d;
  public int e;
  int f;
  
  public ProgressViewYellow(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 10000L;
    this.e = 5;
    this.f = 0;
    a();
  }
  
  public ProgressViewYellow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = 10000L;
    this.e = 5;
    this.f = 0;
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = Color.parseColor("#496daa");
    this.jdField_c_of_type_Int = Color.parseColor("#4efff0");
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(this.jdField_b_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(this.jdField_c_of_type_Int);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a = paramLong2;
    this.jdField_b_of_type_Long = (paramLong2 - paramLong1);
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d + getHeight() <= 0) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.d);
    int m = getWidth();
    int i = getHeight();
    int j = m / 2;
    if (this.f <= 0)
    {
      this.f = j;
      Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
    }
    int k = (int)(m * this.jdField_b_of_type_Long / this.a / 2L);
    m = (int)(m - m * this.jdField_b_of_type_Long / this.a / 2L);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, 0, m, i);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    int n = j - this.f;
    if (n > k) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(n, 0, j + this.f, i);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      this.f -= this.e;
      paramCanvas.restore();
      super.draw(paramCanvas);
      return;
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, 0, m, i);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.e = (paramInt1 / 90);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\ProgressViewYellow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */