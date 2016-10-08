package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Arrays;

public abstract class RoundRectImageView
  extends URLImageView
{
  private static final String jdField_a_of_type_JavaLangString = "RoundRectImageView";
  private static final int e = 1;
  private static final int f = 2;
  int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  ComposeShader jdField_a_of_type_AndroidGraphicsComposeShader;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Shader jdField_a_of_type_AndroidGraphicsShader;
  private Shape jdField_a_of_type_AndroidGraphicsDrawableShapesShape;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  public int d;
  private int g;
  
  public RoundRectImageView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = ((int)(Math.random() * 1000.0D));
    a();
  }
  
  public RoundRectImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundRectImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = ((int)(Math.random() * 1000.0D));
    a();
  }
  
  private void a()
  {
    if (VersionUtils.e())
    {
      this.g = 1;
      this.jdField_a_of_type_AndroidContentResResources = getResources();
      if (this.g != 1) {
        break label146;
      }
      if (VersionUtils.e()) {
        setLayerType(2, null);
      }
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("RoundRectImageView" + this.d, 4, "init(): ");
      }
      return;
      this.g = 2;
      break;
      label146:
      if (this.g == 2)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_Int = getWidth();
    this.jdField_b_of_type_Int = getHeight();
    if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0))
    {
      super.draw(paramCanvas);
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != this.jdField_b_of_type_Int)))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsRectF.setEmpty();
      this.jdField_a_of_type_AndroidGraphicsShader = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.RGB_565);
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = null;
      this.jdField_a_of_type_AndroidGraphicsComposeShader = null;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        super.onDraw(paramCanvas);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_4444);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          URLDrawable.clearMemoryCache();
          try
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_4444);
          }
          catch (OutOfMemoryError localOutOfMemoryError3) {}
        }
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
      {
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label405;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsComposeShader == null) {
      this.jdField_a_of_type_AndroidGraphicsComposeShader = new ComposeShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader, a(), PorterDuff.Mode.SRC_OVER);
    }
    label405:
    for (this.jdField_a_of_type_AndroidGraphicsShader = this.jdField_a_of_type_AndroidGraphicsComposeShader;; this.jdField_a_of_type_AndroidGraphicsShader = this.jdField_a_of_type_AndroidGraphicsBitmapShader)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsShader);
      super.onDraw(this.jdField_a_of_type_AndroidGraphicsCanvas);
      System.currentTimeMillis();
      if (this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()) {
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      System.currentTimeMillis();
      if (!VersionUtils.e()) {
        break;
      }
      paramCanvas.isHardwareAccelerated();
      return;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_c_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_c_of_type_AndroidGraphicsPaint.setShader(a());
      }
      paramCanvas.drawPaint(this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableShapesShape.draw(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    System.currentTimeMillis();
    if (VersionUtils.e()) {
      paramCanvas.isHardwareAccelerated();
    }
  }
  
  public abstract Shader a();
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.g == 1) && (VersionUtils.e())) {
      setLayerType(0, null);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.g == 2)
    {
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.g == 1) && (paramBoolean))
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableShapesShape == null)
      {
        float[] arrayOfFloat = new float[8];
        Arrays.fill(arrayOfFloat, this.jdField_c_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsDrawableShapesShape = new RoundRectShape(arrayOfFloat, null, null);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableShapesShape.resize(getWidth(), getHeight());
    }
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_c_of_type_Int = AIOUtils.a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\RoundRectImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */