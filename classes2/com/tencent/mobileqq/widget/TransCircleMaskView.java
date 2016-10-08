package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TransCircleMaskView
  extends View
{
  public static final int a = 116;
  private static final String jdField_a_of_type_JavaLangString = "TransCircleMaskView";
  public static final int b = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  private Paint b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public TransCircleMaskView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = -1;
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public static int a(Context paramContext)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * 11.0F + 0.5F);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.e = getResources().getColor(2131428326);
    this.b = new Paint();
    this.b.setStyle(Paint.Style.FILL);
    this.b.setAntiAlias(true);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.f = getWidth();
    this.g = getHeight();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.e);
    if (this.h == -1) {}
    for (int i = a(getContext());; i = this.h)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawCircle(this.f / 2, i + this.g / 2, this.c, this.b);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != paramInt3)) || (paramInt2 != paramInt4)) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.c = ((int)(paramInt2 * 0.5F * 0.83F));
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        continue;
        this.c = ((int)(paramInt2 * 0.5F) - this.d);
      }
    }
  }
  
  public void setIsUseMaskRadiusRatios(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
  
  public void setMaskRadius(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
  
  public void setUITopOffset(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setmMaskRadiusBless(int paramInt)
  {
    this.d = paramInt;
    this.e = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\TransCircleMaskView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */