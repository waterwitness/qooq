package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class TroopLabelTextView
  extends TextView
{
  protected static final int a = 2;
  private static final String jdField_a_of_type_JavaLangString = TroopLabelTextView.class.getSimpleName();
  protected static final int c = 5;
  protected static final int d = 5;
  protected static final int e = 0;
  protected static final int f = 0;
  protected static final int g = 6;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode;
  protected int b;
  private Bitmap b;
  int h;
  private int i;
  private int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopLabelTextView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = paramInt1;
    setTextColor(paramInt2);
    setMaxLines(1);
    setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = 6;
    setLayoutParams(localLayoutParams);
    paramInt1 = AIOUtils.a(5.0F, getResources());
    paramInt2 = AIOUtils.a(5.0F, getResources());
    int k = AIOUtils.a(0.0F, getResources());
    int m = AIOUtils.a(0.0F, getResources());
    if (paramInt3 == 2)
    {
      setTextSize(9.0F);
      paramInt1 = AIOUtils.a(10.0F, getResources());
    }
    for (;;)
    {
      setPadding(paramInt1, k, paramInt2, m);
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.i = paramInt3;
      this.h = AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.j = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      return;
      setTextSize(11.0F);
    }
  }
  
  public float a()
  {
    return 16.0F;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.i == 2) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3 + (getPaddingLeft() + getPaddingRight()), paramInt4);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    if (this.i == 1)
    {
      localGradientDrawable.setColor(this.jdField_b_of_type_Int);
      localGradientDrawable.setCornerRadius(this.h);
      setBackgroundDrawable(localGradientDrawable);
    }
    do
    {
      return;
      if (this.i == 0)
      {
        localGradientDrawable.setStroke(2, this.jdField_b_of_type_Int);
        localGradientDrawable.setCornerRadius(getHeight() / 2);
        setBackgroundDrawable(localGradientDrawable);
        return;
      }
    } while (this.i != 2);
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    setTextColor(paramInt2);
  }
  
  public void setMaskImage(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "TroopLabelTextView setMaskImage OOM");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\TroopLabelTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */