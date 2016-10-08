package com.tencent.mobileqq.camera.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class PreviewBackground
  extends View
{
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.ui.PreviewBackground";
  private int jdField_a_of_type_Int = 130;
  public Bitmap a;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_a_of_type_AndroidGraphicsRect;
  private int jdField_b_of_type_Int = 360;
  private LinearGradient jdField_b_of_type_AndroidGraphicsLinearGradient;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_c_of_type_Int;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private int d;
  
  public PreviewBackground(Context paramContext)
  {
    this(paramContext, (AttributeSet)null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PreviewBackground(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreviewBackground(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.aK, 0, 0);
    try
    {
      this.jdField_a_of_type_Int = ((int)paramAttributeSet.getDimension(5, this.jdField_a_of_type_Int));
      this.jdField_b_of_type_Int = ((int)paramAttributeSet.getDimension(6, this.jdField_b_of_type_Int));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.ui.PreviewBackground", 2, "PreviewBackground init scaled=" + paramContext.getResources().getDisplayMetrics().density + " topsize=" + this.jdField_a_of_type_Int + " bottomSize=" + this.jdField_b_of_type_Int);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, getWidth(), getHeight());
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(100);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(100);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_b_of_type_AndroidGraphicsLinearGradient);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int i = this.jdField_c_of_type_Int;
    int j = this.d;
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
    if ((this.jdField_c_of_type_Int > 0) && (this.d > 0) && ((i != this.jdField_c_of_type_Int) || (j != this.d)))
    {
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int);
      this.jdField_c_of_type_AndroidGraphicsRect.set(0, this.d - this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.d);
    }
    if ((i != this.jdField_c_of_type_Int) || (j != this.d))
    {
      this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Int, -16777216, 0, Shader.TileMode.MIRROR);
      this.jdField_b_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, this.d, 0.0F, this.d - this.jdField_b_of_type_Int, -16777216, 0, Shader.TileMode.MIRROR);
    }
    super.setMeasuredDimension(paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\ui\PreviewBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */