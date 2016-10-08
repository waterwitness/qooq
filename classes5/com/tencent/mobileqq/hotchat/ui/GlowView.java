package com.tencent.mobileqq.hotchat.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import svd;
import sve;
import svf;
import svg;
import svh;
import svi;

public class GlowView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final String a;
  public static final int b = -13733144;
  public static final float c = 0.05F;
  public static final int c = -13733144;
  public static final int d = -1169032;
  public static final int e = -1169032;
  public float a;
  int jdField_a_of_type_Int;
  public long a;
  public ValueAnimator a;
  Context jdField_a_of_type_AndroidContentContext;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  public LinearInterpolator a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  GlowView.InnerViewOnClickListener jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener;
  public RedDotTextView a;
  boolean jdField_a_of_type_Boolean;
  public float b;
  private long b;
  public ValueAnimator b;
  public ImageView b;
  public boolean b;
  public ValueAnimator c;
  public boolean c;
  public boolean d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = GlowView.class.getSimpleName();
  }
  
  public GlowView(Context paramContext)
  {
    this(paramContext, null);
    c();
  }
  
  public GlowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_c_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationLinearInterpolator = new LinearInterpolator();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  private void b(long paramLong, int paramInt)
  {
    long l = 500L;
    float f = paramInt * 1.0F / (float)paramLong;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 360.0F * f + 0.0F, 370.0F });
    paramLong = ((1.0F - f) * (float)(paramLong - 300L));
    if (paramLong < 500L) {
      paramLong = l;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(paramLong);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new svf(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new svg(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationLinearInterpolator);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (!VersionUtils.e()) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "stopAnim mIsDoingAnim: " + this.jdField_b_of_type_Boolean);
      }
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = false;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllListeners();
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      }
      if (this.jdField_c_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleX(1.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleY(1.0F);
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_AndroidAnimationValueAnimator != null)) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = AIOUtils.a(62.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_b_of_type_Float = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840834);
    this.jdField_b_of_type_AndroidWidgetImageView.setMinimumHeight(i);
    this.jdField_b_of_type_AndroidWidgetImageView.setMinimumWidth(i);
    super.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131296557);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumHeight(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumWidth(this.jdField_a_of_type_Int);
    localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject1).setGravity(17);
    ((LinearLayout)localObject1).setOrientation(0);
    ((LinearLayout)localObject1).setBackgroundResource(2130840829);
    i = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Object localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setMinimumHeight(i);
    ((ImageView)localObject2).setMinimumWidth(i);
    ((ImageView)localObject2).setImageResource(2130840828);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.rightMargin = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = AIOUtils.a(0.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = new RedDotTextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextSize(1, 10.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setIncludeFontPadding(false);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(0.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((LinearLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(52.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(16.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131296557);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.d = VersionUtils.e();
    if (this.d) {
      setLayerType(1, null);
    }
  }
  
  private void d()
  {
    float f2 = 1.0F;
    if (!VersionUtils.e()) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getScaleX() >= 1.0F) {}
    for (float f1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getScaleX();; f1 = 1.0F)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView.getScaleX() >= 1.0F) {
        f2 = this.jdField_b_of_type_AndroidWidgetImageView.getScaleX();
      }
      this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new svh(this, f1, f2));
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new svi(this));
      this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.5F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setRepeatMode(2);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if ((!VersionUtils.e()) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.25F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new svd(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new sve(this, paramLong, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.d) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramInt, 0);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!this.d) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.25F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.25F);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleX(1.2741935F);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleY(1.2741935F);
    b(paramInt1, paramInt2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      if (!this.jdField_a_of_type_Boolean) {
        break label344;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-13733144);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.jdField_b_of_type_Float, 0.0F, 0.0F, -13733144);
    }
    for (;;)
    {
      float f1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTop();
      float f5 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBottom();
      float f2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft();
      float f6 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getRight();
      float f3 = this.jdField_b_of_type_Float / 2.0F;
      float f4 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() * 0.25F / 2.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f2 - f3 - f4, f1 - f3 - f4, f6 + f3 + f4, f5 + f3 + f4);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.jdField_a_of_type_Float, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
      f5 = (f6 - f2) * 1.25F / 2.0F;
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2 + f2, f1 - f4 - f3, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2 + f2 + (f5 + f3) * (float)Math.sin(1.0F * this.jdField_a_of_type_Float / 180.0F * 3.141592653589793D), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2 + f1 - (f5 + f3) * (float)Math.cos(1.0F * this.jdField_a_of_type_Float / 180.0F * 3.141592653589793D), f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      label344:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1169032);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.jdField_b_of_type_Float, 0.0F, 0.0F, -1169032);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener != null)
      {
        if (l1 - l2 < 600L) {
          break label54;
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener.a(paramView);
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      }
    }
    return;
    label54:
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "操作过于频繁！", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_AndroidWidgetImageView) && (this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener.a(paramView);
    }
    return false;
  }
  
  public void setInnerOnClickListener(GlowView.InnerViewOnClickListener paramInnerViewOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView$InnerViewOnClickListener = paramInnerViewOnClickListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\ui\GlowView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */