package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import itp;
import itq;
import itr;
import its;
import itt;

public class StoryDownloadView
  extends View
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public float a;
  public AnimatorSet a;
  public boolean a;
  public float b;
  public AnimatorSet b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public int h;
  public float i;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p;
  public float q;
  public float r = -45.0F;
  public float s = 0.1F;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = Color.parseColor("#FFFFFF");
    jdField_b_of_type_Int = Color.parseColor("#BCBFC4");
    jdField_c_of_type_Int = Color.parseColor("#CFCFCF");
  }
  
  public StoryDownloadView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StoryDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    a(this.jdField_a_of_type_Float);
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (getContext().getResources().getDisplayMetrics().density * paramFloat1 + 0.5F) * paramFloat2;
  }
  
  private void a(float paramFloat)
  {
    this.jdField_b_of_type_Float = a(46.0F, paramFloat);
    this.jdField_c_of_type_Float = a(46.0F, paramFloat);
    this.d = a(5.0F, paramFloat);
    this.e = a(5.0F, paramFloat);
    this.f = a(6.0F, paramFloat);
    this.g = a(4.0F, paramFloat);
    this.jdField_h_of_type_Float = a(5.0F, paramFloat);
    this.i = a(2.0F, paramFloat);
    this.j = a(18.0F, paramFloat);
    this.k = (this.jdField_c_of_type_Float - a(7.0F, paramFloat));
    this.l = a(6.0F, paramFloat);
    this.m = a(28.0F, paramFloat);
    this.n = (this.jdField_b_of_type_Float - a(8.0F, paramFloat));
    this.o = a(20.0F, paramFloat);
    this.p = this.f;
    this.q = (this.jdField_c_of_type_Float - this.g - this.jdField_h_of_type_Float / 2.0F);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_h_of_type_Int = 2;
      c(true);
      return;
    }
    this.jdField_h_of_type_Int = 3;
  }
  
  public void a()
  {
    super.setEnabled(false);
    this.jdField_h_of_type_Int = 1;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
    }
    c();
  }
  
  public void a(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = jdField_a_of_type_Int;; i1 = jdField_c_of_type_Int)
    {
      localPaint.setColor(i1);
      localPaint.setAntiAlias(true);
      Object localObject = new Path();
      ((Path)localObject).moveTo(this.jdField_b_of_type_Float / 2.0F - this.jdField_h_of_type_Float / 2.0F, this.p + this.i);
      ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F - this.jdField_h_of_type_Float / 2.0F, this.p + this.i + this.jdField_c_of_type_Float * 13.0F / 46.0F);
      ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F - this.jdField_h_of_type_Float / 2.0F - this.jdField_b_of_type_Float * 8.0F / 46.0F, this.p + this.i + this.jdField_c_of_type_Float * 13.0F / 46.0F);
      ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F, this.p + this.i + this.jdField_c_of_type_Float * 25.0F / 46.0F);
      ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F + this.jdField_h_of_type_Float / 2.0F + this.jdField_b_of_type_Float * 8.0F / 46.0F, this.p + this.i + this.jdField_c_of_type_Float * 13.0F / 46.0F);
      ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F + this.jdField_h_of_type_Float / 2.0F, this.p + this.i + this.jdField_c_of_type_Float * 13.0F / 46.0F);
      ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F + this.jdField_h_of_type_Float / 2.0F, this.p + this.i);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath((Path)localObject, localPaint);
      paramCanvas.drawArc(new RectF(this.jdField_b_of_type_Float / 2.0F - this.jdField_h_of_type_Float / 2.0F, this.p, this.jdField_b_of_type_Float / 2.0F + this.jdField_h_of_type_Float / 2.0F, this.p + this.i * 2.0F), 180.0F, 360.0F, true, localPaint);
      float f1 = this.jdField_b_of_type_Float - this.e - this.i;
      float f2 = this.jdField_c_of_type_Float - this.g - this.jdField_h_of_type_Float;
      float f3 = this.jdField_c_of_type_Float - this.g;
      localObject = new Path();
      ((Path)localObject).moveTo(this.d + this.i, this.jdField_c_of_type_Float - this.g - this.jdField_h_of_type_Float / 2.0F);
      ((Path)localObject).quadTo(this.jdField_b_of_type_Float / 2.0F, this.q, f1, this.jdField_c_of_type_Float - this.g - this.jdField_h_of_type_Float / 2.0F);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(this.jdField_h_of_type_Float);
      paramCanvas.drawPath((Path)localObject, localPaint);
      localObject = new RectF(this.d, f2, this.d + this.i * 2.0F, f3);
      RectF localRectF = new RectF(f1 - this.i, f2, f1 + this.i, f3);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawArc((RectF)localObject, 90.0F, 360.0F, true, localPaint);
      paramCanvas.drawArc(localRectF, -90.0F, 360.0F, true, localPaint);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_h_of_type_Int = 2;
    d();
    c(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_h_of_type_Int = 0;
    super.setEnabled(true);
    d();
    invalidate();
  }
  
  public void b(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    Path localPath = new Path();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = jdField_a_of_type_Int;; i1 = jdField_c_of_type_Int)
    {
      localPaint.setColor(i1);
      localPaint.setAntiAlias(true);
      localPaint.setStrokeWidth(this.jdField_h_of_type_Float);
      localPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.save();
      paramCanvas.rotate(this.r, this.j, this.k);
      paramCanvas.scale(this.s, this.s, this.j, this.k);
      localPath.moveTo(this.l, this.m);
      localPath.lineTo(this.j, this.k);
      localPath.moveTo(this.j, this.k);
      localPath.lineTo(this.n, this.o);
      paramCanvas.drawPath(localPath, localPaint);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(this.l, this.m, this.jdField_h_of_type_Float / 2.0F, localPaint);
      paramCanvas.drawCircle(this.n, this.o, this.jdField_h_of_type_Float / 2.0F, localPaint);
      paramCanvas.drawCircle(this.j, this.k, this.jdField_h_of_type_Float / 2.0F, localPaint);
      paramCanvas.restore();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_h_of_type_Int = 3;
    d();
    b();
  }
  
  public void c()
  {
    float f1 = this.jdField_c_of_type_Float - this.g - this.jdField_h_of_type_Float / 2.0F;
    float f2 = this.g + this.jdField_h_of_type_Float / 2.0F;
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { f1, f1 + f2, f2 * 3.0F / 2.0F + f1, f1 - f2 / 2.0F, f2 / 4.0F + f1, f1 });
    localValueAnimator1.addUpdateListener(new itp(this));
    localValueAnimator1.setRepeatCount(-1);
    localValueAnimator1.setRepeatMode(-1);
    f1 = this.f;
    f2 = this.g * 3.0F / 2.0F;
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { f1, f2 / 2.0F + f1, 6.0F * f2 / 5.0F + f1, f1 - f2 * 2.0F / 3.0F, f1 - f2, f1 - f2 * 1.0F / 5.0F });
    localValueAnimator2.addUpdateListener(new itq(this));
    localValueAnimator2.setRepeatCount(-1);
    localValueAnimator2.setRepeatMode(-1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localValueAnimator1).with(localValueAnimator2);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(1000L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void c(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { -6.0F, 10.0F, 0.0F });
    localValueAnimator1.addUpdateListener(new itr(this));
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.1F, 1.0F, 1.0F });
    localValueAnimator2.addUpdateListener(new its(this));
    localValueAnimator2.addListener(new itt(this, paramBoolean));
    this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.play(localValueAnimator1).with(localValueAnimator2);
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.setDuration(800L);
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.end();
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_b_of_type_AndroidAnimationAnimatorSet = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.jdField_h_of_type_Int == 2) {
      b(paramCanvas);
    }
    do
    {
      return;
      if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 0))
      {
        a(paramCanvas);
        return;
      }
    } while (this.jdField_h_of_type_Int != 3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    float f3 = 1.0F;
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    float f1;
    if (i1 == 1073741824) {
      f1 = paramInt1 / a(46.0F, 1.0F);
    }
    for (;;)
    {
      float f2;
      if (i2 == 1073741824) {
        f2 = paramInt2 / a(46.0F, 1.0F);
      }
      for (;;)
      {
        a(Math.min(f1, f2));
        setMeasuredDimension(getPaddingLeft() + (int)this.jdField_b_of_type_Float + getPaddingRight(), getPaddingTop() + (int)this.jdField_c_of_type_Float + getPaddingBottom());
        return;
        if (i1 == Integer.MIN_VALUE)
        {
          f1 = 1.0F;
          break;
        }
        if (i1 != 0) {
          break label160;
        }
        f1 = 1.0F;
        break;
        f2 = f3;
        if (i2 != Integer.MIN_VALUE)
        {
          f2 = f3;
          if (i2 == 0) {
            f2 = f3;
          }
        }
      }
      label160:
      f1 = 1.0F;
    }
  }
  
  public void setWhiteMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\StoryDownloadView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */