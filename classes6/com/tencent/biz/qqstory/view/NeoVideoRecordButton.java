package com.tencent.biz.qqstory.view;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import izs;
import izt;
import izu;

public class NeoVideoRecordButton
  extends RingView
{
  public static final int a = -90;
  public static final int b = 270;
  public float a;
  public AnimatorSet a;
  public ValueAnimator a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public RingView.DrawInfo a;
  boolean jdField_a_of_type_Boolean = true;
  public ValueAnimator b;
  public RingView.DrawInfo b;
  final int c;
  public ValueAnimator c;
  public RingView.DrawInfo c;
  final int d;
  final int e;
  final int f;
  final int g;
  final int h;
  
  public NeoVideoRecordButton(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NeoVideoRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_c_of_type_Int = a(paramContext, 36.0F);
    this.d = a(paramContext, 4.0F);
    this.e = a(paramContext, 28.8F);
    this.h = a(paramContext, 52.0F);
    this.g = a(paramContext, 6.0F);
    this.f = a(paramContext, 28.8F);
    paramAttributeSet = new RingView.DrawInfo(-90, 270, this.jdField_c_of_type_Int, 0.0F, this.d, 0.0F, -15550475, -1, Paint.Style.STROKE);
    this.jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo = paramAttributeSet;
    super.a(paramAttributeSet);
    paramAttributeSet = new RingView.DrawInfo(-90, 270, 1, 0.0F, 1, 0.0F, 1090519039, 0, Paint.Style.FILL);
    this.jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo = paramAttributeSet;
    super.a(paramAttributeSet);
    paramAttributeSet = new RingView.DrawInfo(-90, 270, this.e, 0.0F, 1, 0.0F, -1, 0, Paint.Style.FILL);
    this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo = paramAttributeSet;
    super.a(paramAttributeSet);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("border", new IntEvaluator(), new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.h) }), PropertyValuesHolder.ofObject("ring", new IntEvaluator(), new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.g) }), PropertyValuesHolder.ofObject("center", new IntEvaluator(), new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f) }), PropertyValuesHolder.ofObject("color", new ArgbEvaluator(), new Object[] { Integer.valueOf(-1), Integer.valueOf(-15550475) }) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new izs(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("radius", new IntEvaluator(), new Object[] { Integer.valueOf(1), Integer.valueOf(this.h - this.d) }), PropertyValuesHolder.ofObject("color", new ArgbEvaluator(), new Object[] { Integer.valueOf(16777215), Integer.valueOf(16777215), Integer.valueOf(16777215), Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(16777215) }) });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(1500L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new izt(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(this.jdField_a_of_type_AndroidAnimationValueAnimator).before(this.jdField_b_of_type_AndroidAnimationValueAnimator);
    this.jdField_c_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new izu(this));
    setProgress(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841582);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_c_of_type_Int * 2, this.jdField_c_of_type_Int * 2);
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  private int a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return -90;
    }
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = paramFloat - 1.0F;
    }
    return (int)(360.0F * f1) - 90;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(a(paramContext) * paramFloat + 0.5F);
  }
  
  private void d()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.invalidate();
      return;
    }
    super.postInvalidate();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("border", new IntEvaluator(), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.a()), Integer.valueOf(this.jdField_c_of_type_Int) }), PropertyValuesHolder.ofObject("ring", new IntEvaluator(), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b()), Integer.valueOf(this.d) }), PropertyValuesHolder.ofObject("center", new IntEvaluator(), new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.a()), Integer.valueOf(this.e) }), PropertyValuesHolder.ofObject("color", new ArgbEvaluator(), new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.c()), Integer.valueOf(-1) }) });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Log.d("NeoRecord", "mStubDrawable : " + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        int i = paramCanvas.getSaveCount();
        paramCanvas.save();
        int j = (getWidth() - this.jdField_c_of_type_Int * 2) / 2;
        int k = (getHeight() - this.jdField_c_of_type_Int * 2) / 2;
        paramCanvas.translate(j, k);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
      }
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setProgress(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b(a(this.jdField_a_of_type_Float));
    d();
  }
  
  public void setStubDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      d();
    }
  }
  
  public void setStubMode(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\NeoVideoRecordButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */