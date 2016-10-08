package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ProgressViewRed
  extends TimeDownTextView
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
  int e;
  public int f;
  
  public ProgressViewRed(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 10000L;
    this.d = 5;
    this.e = 0;
    a();
  }
  
  public ProgressViewRed(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = 10000L;
    this.d = 5;
    this.e = 0;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_Int = Color.parseColor("#385381");
    this.jdField_b_of_type_Int = Color.parseColor("#222448");
    this.jdField_c_of_type_Int = Color.parseColor("#222448");
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(this.jdField_a_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(this.jdField_c_of_type_Int);
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_b_of_type_Long = (paramLong2 - paramLong1);
    setText(paramCharSequence);
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_b_of_type_Long = (paramLong2 - paramLong1);
    setText2(paramCharSequence1, paramCharSequence2);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.f == 0) {
      return;
    }
    int m = getWidth();
    int i = getHeight();
    int j = m / 2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, m, i);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    if (this.e <= 0)
    {
      this.e = j;
      Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
    }
    int k = (int)(m * this.jdField_b_of_type_Long / this.jdField_a_of_type_Long / 2L);
    m = (int)(m - m * this.jdField_b_of_type_Long / this.jdField_a_of_type_Long / 2L);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, 0, m, i);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    int n = j - this.e;
    if (n > k) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(n, 0, j + this.e, i);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      this.e -= this.d;
      super.draw(paramCanvas);
      return;
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, 0, m, i);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.d = (paramInt1 / 90);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
    setTextColor(Color.argb(paramInt, 255, 255, 255));
    this.f = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\ProgressViewRed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */