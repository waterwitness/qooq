package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hcd;

public class ChildLockCircle
  extends View
{
  public static long a;
  int jdField_a_of_type_Int;
  public Bitmap a;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public ChildLockCircle.AnimationListener a;
  hcd jdField_a_of_type_Hcd = null;
  public String a;
  public boolean a;
  public int b;
  public Bitmap b;
  public String b;
  public int c;
  public Bitmap c;
  public String c;
  public String d;
  public String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = 300L;
  }
  
  public ChildLockCircle(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 0;
    a(null, 0);
  }
  
  public ChildLockCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 0;
    a(paramAttributeSet, 0);
  }
  
  public ChildLockCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 0;
    a(paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Hcd = new hcd(this);
    this.jdField_a_of_type_Hcd.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Hcd.start();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getResources();
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(2131363889);
    this.jdField_b_of_type_JavaLangString = paramAttributeSet.getString(2131363890);
    this.jdField_c_of_type_JavaLangString = paramAttributeSet.getString(2131363891);
    this.d = paramAttributeSet.getString(2131363892);
    this.jdField_a_of_type_Int = -1;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130839104);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130839105);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(2130839103);
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      return;
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      for (;;)
      {
        paramAttributeSet.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Hcd != null)
    {
      this.jdField_a_of_type_Hcd.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Hcd = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = getPaddingLeft();
    int i1 = getPaddingRight();
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int i = getWidth();
    int j = getHeight();
    if (i != j)
    {
      j = Math.min(i, j);
      i = j;
    }
    for (;;)
    {
      i1 = i - k - i1;
      j = j - m - n;
      paramCanvas.drawColor(0);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, m, k + i1, m + j);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(8);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (k + 4 + 18);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (m + 4 + 18);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (k + i1 - 4 - 18);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (m + j - 4 - 18);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(50);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F * (this.jdField_c_of_type_Int / this.jdField_b_of_type_Int), false, this.jdField_a_of_type_AndroidGraphicsPaint);
      i /= 3;
      n = (i1 - i) / 2 + k;
      int i2 = (j - i) / 2 + m - i1 / 12;
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, new RectF(n, i2, n + i, i + i2), this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      i = j / 12;
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(i);
      n = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.e, 0, this.e.length());
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(this.e, (i1 - n) / 2 + k, (j - i) / 2 + m + i1 / 4, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void setAnimationListener(ChildLockCircle.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener = paramAnimationListener;
  }
  
  public void setIsLock(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Int = 0;
      this.e = this.jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      return;
    }
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.e = this.jdField_c_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\ChildLockCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */