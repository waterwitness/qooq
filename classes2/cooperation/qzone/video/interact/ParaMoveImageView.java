package cooperation.qzone.video.interact;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import ypz;
import yqa;

public class ParaMoveImageView
  extends View
{
  public static final int a;
  public static final int b;
  private float jdField_a_of_type_Float;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = ScreenUtil.a(200.0F);
    jdField_b_of_type_Int = ScreenUtil.a(1.0F);
  }
  
  public ParaMoveImageView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ParaMoveImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ParaMoveImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private float c(float paramFloat)
  {
    return this.e * paramFloat;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 127.0F, 0.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setEvaluator(new ParaMoveImageView.ParaMoveEvaluator(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ypz(this));
  }
  
  private float d(float paramFloat)
  {
    paramFloat = c(paramFloat);
    return paramFloat * paramFloat * this.g;
  }
  
  private float e(float paramFloat)
  {
    return this.h + this.j * paramFloat;
  }
  
  public float a(float paramFloat)
  {
    return c(paramFloat) + this.jdField_a_of_type_Float;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.d = paramFloat4;
    this.e = (paramFloat3 - paramFloat1);
    this.f = (paramFloat4 - paramFloat2);
    this.g = (this.f / this.e / this.e);
    this.h = (jdField_a_of_type_Int / 2);
    this.i = paramInt;
    this.j = (this.i - this.h);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_Int = jdField_a_of_type_Int;
    paramBitmap = getLayoutParams();
    paramInt = jdField_a_of_type_Int;
    paramBitmap.width = paramInt;
    paramBitmap.height = paramInt;
    setX(this.jdField_a_of_type_Float);
    setY(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramLong);
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(paramAnimatorListener);
    }
  }
  
  public float b(float paramFloat)
  {
    return d(paramFloat) + this.jdField_b_of_type_Float;
  }
  
  public void b()
  {
    if ((getVisibility() == 0) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new yqa(this), 100L);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawOval(new RectF(jdField_b_of_type_Int, jdField_b_of_type_Int, this.jdField_c_of_type_Int - jdField_b_of_type_Int, this.jdField_c_of_type_Int - jdField_b_of_type_Int), this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\interact\ParaMoveImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */