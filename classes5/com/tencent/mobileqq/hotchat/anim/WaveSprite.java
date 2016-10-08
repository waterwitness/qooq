package com.tencent.mobileqq.hotchat.anim;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.Sprite;

public class WaveSprite
  extends Sprite
{
  public static final float a = 0.3F;
  public static int a = 0;
  public static final float b = 0.4F;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private View jdField_a_of_type_AndroidViewView;
  public boolean a;
  public int b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  public float c;
  public int c;
  private Paint c;
  public float d;
  public int d;
  private float f;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public WaveSprite()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = -1249807;
    this.j = -1249807;
    this.jdField_c_of_type_Float = 0.4F;
    this.jdField_d_of_type_Float = 0.3F;
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.i);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.j);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(114);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i1 = 0;
    while (i1 < this.l)
    {
      int i2 = (int)(this.jdField_b_of_type_Int * Math.cos((i1 * this.jdField_c_of_type_Float + this.m % 360) * 3.141592653589793D / 180.0D) + this.jdField_c_of_type_Int);
      if (i1 == 0) {
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(i1, i2);
      }
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(i1, i2, i1 + 1, i2);
      i1 += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.l, this.k);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(0.0F, this.k);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    int i1 = 0;
    while (i1 < this.l)
    {
      int i2 = (int)(this.jdField_b_of_type_Int * Math.sin((i1 * this.jdField_c_of_type_Float + this.n % 360) * 3.141592653589793D / 180.0D) + this.jdField_d_of_type_Int);
      if (i1 == 0) {
        this.jdField_b_of_type_AndroidGraphicsPath.moveTo(i1, i2);
      }
      this.jdField_b_of_type_AndroidGraphicsPath.quadTo(i1, i2, i1 + 1, i2);
      i1 += 1;
    }
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.l, this.k);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(0.0F, this.k);
    this.jdField_b_of_type_AndroidGraphicsPath.close();
  }
  
  protected void a(Canvas paramCanvas)
  {
    super.a(paramCanvas);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b();
    c();
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_c_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    int i2 = (int)(this.f * this.jdField_d_of_type_Float);
    int i1 = i2;
    if (i2 == 0) {
      i1 = 1;
    }
    this.m += i1;
    this.n -= i1;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.l = paramView.getResources().getDisplayMetrics().widthPixels;
    this.k = paramView.getResources().getDimensionPixelSize(2131493620);
    this.f = paramView.getResources().getDisplayMetrics().density;
    jdField_a_of_type_Int = (int)(this.f * 4.0F + 0.5D);
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_c_of_type_Int = (jdField_a_of_type_Int * 4 + paramView.getResources().getDimensionPixelSize(2131493619) + paramView.getResources().getDimensionPixelSize(2131493622));
    this.jdField_d_of_type_Int = (this.jdField_c_of_type_Int - this.jdField_b_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\anim\WaveSprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */