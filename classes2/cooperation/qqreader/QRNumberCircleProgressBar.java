package cooperation.qqreader;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QRNumberCircleProgressBar
  extends View
{
  private static final String jdField_c_of_type_JavaLangString = "saved_instance";
  private static final String jdField_d_of_type_JavaLangString = "full_mode";
  private static final String jdField_e_of_type_JavaLangString = "text_color";
  private static final String jdField_f_of_type_JavaLangString = "text_size";
  private static final int jdField_g_of_type_Int = 270;
  private static final String jdField_g_of_type_JavaLangString = "circle_radius";
  private static final String jdField_h_of_type_JavaLangString = "reached_bar_color";
  private static final String jdField_i_of_type_JavaLangString = "unreached_bar_color";
  private static final String jdField_j_of_type_JavaLangString = "max";
  private static final String jdField_k_of_type_JavaLangString = "progress";
  private static final int jdField_l_of_type_Int = 0;
  private static final String jdField_l_of_type_JavaLangString = "suffix";
  private static final int jdField_m_of_type_Int = 1;
  private static final String jdField_m_of_type_JavaLangString = "prefix";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 100;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private String jdField_a_of_type_JavaLangString = "%";
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private final float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private final float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private float jdField_h_of_type_Float;
  private final int jdField_h_of_type_Int = Color.rgb(255, 255, 255);
  private float jdField_i_of_type_Float;
  private final int jdField_i_of_type_Int = Color.rgb(66, 145, 241);
  private float jdField_j_of_type_Float;
  private final int jdField_j_of_type_Int = Color.rgb(204, 204, 204);
  private final int jdField_k_of_type_Int;
  private String n;
  
  public QRNumberCircleProgressBar(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QRNumberCircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QRNumberCircleProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_d_of_type_Float = a(65.0F);
    this.jdField_c_of_type_Float = a(15.0F);
    this.k = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.V);
    try
    {
      this.jdField_f_of_type_Int = paramContext.getInt(8, this.k);
      this.jdField_b_of_type_Float = paramContext.getDimension(6, this.jdField_d_of_type_Float);
      this.jdField_c_of_type_Int = paramContext.getColor(3, this.jdField_i_of_type_Int);
      this.jdField_d_of_type_Int = paramContext.getColor(2, this.jdField_j_of_type_Int);
      this.jdField_e_of_type_Int = paramContext.getColor(5, this.jdField_h_of_type_Int);
      this.jdField_a_of_type_Float = paramContext.getDimension(4, this.jdField_c_of_type_Float);
      if (paramContext.getInt(7, 0) != 0) {
        this.jdField_b_of_type_Boolean = false;
      }
      setProgress(paramContext.getInt(0, 0));
      setMax(paramContext.getInt(1, 100));
      paramContext.recycle();
      d();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    if (paramBoolean) {}
    for (paramInt = getPaddingLeft() + getPaddingRight(); i1 == 1073741824; paramInt = getPaddingTop() + getPaddingBottom()) {
      return i2;
    }
    paramInt += getSuggestedMinimumHeight();
    if (i1 == Integer.MIN_VALUE) {
      return Math.min(paramInt, i2);
    }
    return paramInt;
  }
  
  private void a()
  {
    this.jdField_e_of_type_Float = ((getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) / 2.0F + getPaddingLeft());
    this.jdField_f_of_type_Float = ((getMeasuredHeight() - getPaddingTop() - getPaddingBottom()) / 2.0F + getPaddingTop());
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_e_of_type_Float - this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_f_of_type_Float - this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_e_of_type_Float + this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_f_of_type_Float + this.jdField_b_of_type_Float);
  }
  
  private void c()
  {
    this.n = String.format("%d", new Object[] { Integer.valueOf(a() * 100 / b()) });
    this.n = (this.jdField_b_of_type_JavaLangString + this.n + this.jdField_a_of_type_JavaLangString);
    Rect localRect = new Rect();
    this.jdField_d_of_type_AndroidGraphicsPaint.getTextBounds(this.n, 0, 1, localRect);
    this.g = localRect.width();
    this.jdField_h_of_type_Float = localRect.height();
    this.jdField_i_of_type_Float = (this.jdField_e_of_type_Float + this.g / 2.0F);
    float f1 = this.jdField_e_of_type_Float;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    this.jdField_j_of_type_Float = a(114.0F);
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(200, 24, 180, 237));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130841620);
      return;
    }
    catch (Exception localException) {}catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  public float a(float paramFloat)
  {
    return getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return (int)this.jdField_b_of_type_Float * 2;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return (int)this.jdField_a_of_type_Float;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean) {
      switch (this.jdField_f_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        c();
      }
      paramCanvas.drawText(this.n, this.jdField_i_of_type_Float, this.jdField_j_of_type_Float, this.jdField_d_of_type_AndroidGraphicsPaint);
      return;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, a() * 360 / b(), true, this.jdField_c_of_type_AndroidGraphicsPaint);
      continue;
      float f1 = (b() - a()) * 1.0F / b();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        float f2 = (a(130.0F) - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2.0F;
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, f2, 32.0F, null);
        paramCanvas.drawRect(f2, a(17.0F) + 32.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + f2, 32.0F + a(17.0F) + f1 * (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() - a(34.0F)), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
    a();
    b();
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_Int = paramInt;
      invalidate();
    }
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt <= b()) && (paramInt >= 0))
    {
      this.jdField_b_of_type_Int = paramInt;
      invalidate();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRNumberCircleProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */