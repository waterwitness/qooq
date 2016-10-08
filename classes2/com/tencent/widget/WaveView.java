package com.tencent.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import xvl;
import xvm;
import xvn;

public class WaveView
  extends ImageView
{
  public static final int a = 40;
  public static final String a;
  public static int b = 0;
  public static int c = 0;
  public static final int g = 1001;
  public static final int h = 1002;
  public static final int i = 1003;
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new xvl(this));
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  public int d;
  public int e;
  public int f;
  private int j = -1249807;
  private int k = -1249807;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = WaveView.class.getSimpleName();
  }
  
  public WaveView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public WaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(102);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.k);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(38);
    this.m = getResources().getDisplayMetrics().widthPixels;
    this.l = getResources().getDimensionPixelSize(2131493621);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    jdField_b_of_type_Int = (int)(this.jdField_a_of_type_Float * 4.0F + 0.5D);
    this.d = jdField_b_of_type_Int;
    this.e = (jdField_b_of_type_Int * 3);
    this.f = (this.e - this.d);
    int i1 = this.m / 125;
    c = i1;
    this.w = i1;
    this.o = 0;
    this.n = (-this.m);
    this.p = (this.m / 4);
    this.q = (this.m / 2);
    this.r = (this.m * 3 / 4);
    this.s = (this.m * 5 / 4);
    this.t = (this.m * 3 / 2);
    this.u = (this.m * 7 / 4);
    this.v = (this.m * 2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.n, this.e);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.n + this.p, this.e - this.d * 2, this.n + this.q, this.e);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.n + this.r, this.e + this.d * 2, this.n + this.m, this.e);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.n + this.s, this.e - this.d * 2, this.n + this.t, this.e);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.n + this.u, this.e + this.d * 2, this.n + this.v, this.e);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.n + this.v, this.l);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.n, this.l);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsPath.moveTo(this.o, this.f);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.o + this.p, this.f - this.d * 2, this.o + this.q, this.f);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.o + this.r, this.f + this.d * 2, this.o + this.m, this.f);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.o + this.s, this.f - this.d * 2, this.o + this.t, this.f);
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.o + this.u, this.f + this.d * 2, this.o + this.v, this.f);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.o + this.v, this.l);
    this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.o, this.l);
    this.jdField_b_of_type_AndroidGraphicsPath.close();
  }
  
  private void f()
  {
    if (!VersionUtils.e()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
  }
  
  private void g()
  {
    if (!VersionUtils.e()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
  }
  
  public void a()
  {
    if (!VersionUtils.e()) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { jdField_b_of_type_Int, jdField_b_of_type_Int * 2 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new xvm(this));
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.start();
    this.w = ((int)(c * 1.6D));
  }
  
  public void b()
  {
    if (!VersionUtils.e()) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { jdField_b_of_type_Int * 2, jdField_b_of_type_Int });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new xvn(this));
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.start();
    this.w = c;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    f();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "WaveVie onAttachedToWindow.");
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    g();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "WaveView onDetachedFromWindow.");
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    d();
    e();
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\WaveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */