package cooperation.qzone.video.interact;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CircleProgressBar
  extends View
{
  public static final int a = 2;
  private static final String jdField_a_of_type_JavaLangString = "CircleProgressBar";
  public static final int b = 6;
  public static final int c = 3;
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private float c;
  private int d;
  private int e;
  
  public CircleProgressBar(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b();
  }
  
  public CircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt / 100.0F * 360.0F);
  }
  
  private void b()
  {
    float f = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Float = (2.0F * f);
    this.jdField_b_of_type_Float = (6.0F * f);
    this.c = (f * 3.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(57088);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.c, 0.0F, 0.0F, 16767279);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(855638016);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    setBackgroundColor(0);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a()
  {
    setVisibility(4);
    this.d = 0;
    this.e = 0;
  }
  
  public boolean a()
  {
    return getVisibility() == 0;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = f1 - this.jdField_b_of_type_Float / 2.0F;
    paramCanvas.drawCircle(f1, f1, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(f1 - f2, f1 - f2, f1 + f2, f2 + f1);
    paramCanvas.rotate(-90.0F, f1, f1);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, this.e, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setProgress(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CircleProgressBar", 4, "setProgress() progress = " + paramInt);
    }
    if ((paramInt <= 0) || (paramInt > 100)) {
      return;
    }
    if (!a()) {
      setVisibility(0);
    }
    int i = paramInt;
    if (paramInt <= 2) {
      i = 2;
    }
    this.d = i;
    this.e = a(this.d);
    postInvalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\interact\CircleProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */