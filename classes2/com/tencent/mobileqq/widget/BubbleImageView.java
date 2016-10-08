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
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Arrays;

public class BubbleImageView
  extends ChatThumbView
{
  public static final float a = 10.0F;
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "BubbleImageView";
  public static final int b = 2;
  private Resources jdField_a_of_type_AndroidContentResResources;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  ComposeShader jdField_a_of_type_AndroidGraphicsComposeShader;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Shader jdField_a_of_type_AndroidGraphicsShader;
  float[] jdField_a_of_type_ArrayOfFloat;
  private float jdField_b_of_type_Float;
  Paint jdField_b_of_type_AndroidGraphicsPaint;
  Path jdField_b_of_type_AndroidGraphicsPath;
  RectF jdField_b_of_type_AndroidGraphicsRectF;
  public boolean b;
  public int c;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  Path jdField_c_of_type_AndroidGraphicsPath;
  RectF jdField_c_of_type_AndroidGraphicsRectF;
  protected boolean c;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  public BubbleImageView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 1610612736;
    this.jdField_e_of_type_Int = ((int)(Math.random() * 1000.0D));
    a();
  }
  
  public BubbleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 1610612736;
    this.jdField_e_of_type_Int = ((int)(Math.random() * 1000.0D));
    a();
  }
  
  public BubbleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 1610612736;
    this.jdField_e_of_type_Int = ((int)(Math.random() * 1000.0D));
    a();
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    if (VersionUtils.e())
    {
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_AndroidContentResResources = getResources();
      if (this.jdField_c_of_type_Int != 1) {
        break label144;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        setLayerType(2, null);
      }
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_a_of_type_ArrayOfFloat = new float[8];
    }
    label144:
    while (this.jdField_c_of_type_Int != 2)
    {
      return;
      this.jdField_c_of_type_Int = 2;
      break;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  private void a(Canvas paramCanvas)
  {
    long l1 = System.currentTimeMillis();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    super.draw(paramCanvas);
    if (this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_c_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_c_of_type_AndroidGraphicsPaint.setShader(a());
      }
      paramCanvas.drawPaint(this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    if (this.f) {
      paramCanvas.drawColor(this.jdField_d_of_type_Int);
    }
    paramCanvas.drawPath(this.jdField_c_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    long l2 = System.currentTimeMillis();
    boolean bool = false;
    if (VersionUtils.e()) {
      bool = paramCanvas.isHardwareAccelerated();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleImageView" + this.jdField_e_of_type_Int, 2, "drawBubbleByXfermode(): isHardwaveAccelerated= " + bool + ", cost =" + (l2 - l1));
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    long l1 = System.currentTimeMillis();
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) || (j <= 0))
    {
      super.draw(paramCanvas);
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != i) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != j)))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsRectF.setEmpty();
      this.jdField_a_of_type_AndroidGraphicsPath = null;
      this.jdField_b_of_type_AndroidGraphicsRectF.setEmpty();
      this.jdField_b_of_type_AndroidGraphicsPath = null;
      this.jdField_a_of_type_AndroidGraphicsShader = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        super.draw(paramCanvas);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          URLDrawable.clearMemoryCache();
          try
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
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
      if (!this.jdField_e_of_type_Boolean) {
        break label422;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsComposeShader == null) {
      this.jdField_a_of_type_AndroidGraphicsComposeShader = new ComposeShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader, a(), PorterDuff.Mode.SRC_OVER);
    }
    label422:
    for (this.jdField_a_of_type_AndroidGraphicsShader = this.jdField_a_of_type_AndroidGraphicsComposeShader;; this.jdField_a_of_type_AndroidGraphicsShader = this.jdField_a_of_type_AndroidGraphicsBitmapShader)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsShader);
      super.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
      if (this.f) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.jdField_d_of_type_Int);
      }
      c(paramCanvas);
      long l2 = System.currentTimeMillis();
      boolean bool = false;
      if (VersionUtils.e()) {
        bool = paramCanvas.isHardwareAccelerated();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BubbleImageView" + this.jdField_e_of_type_Int, 2, "drawBubbleByShader(): isHardwaveAccelerated=" + bool + ", cost =" + (l2 - l1));
      return;
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentResResources;
    int i = getWidth();
    int j = getHeight();
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    float f1;
    Path localPath;
    float f2;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty())
      {
        f1 = a(10.0F, localResources);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i - f1, j);
      }
      if (this.jdField_a_of_type_AndroidGraphicsPath == null)
      {
        f1 = a(5.0F, localResources);
        localPath = new Path();
        localPath.moveTo(i - a(14.0F, localResources), a(8.0F, localResources));
        f2 = i;
        localPath.quadTo(i - a(4.0F, localResources), a(10.0F, localResources), f2, f1);
        f1 = i - a(10.0F, localResources);
        f2 = a(16.0F, localResources);
        localPath.quadTo(i - a(1.0F, localResources), a(14.0F, localResources), f1, f2);
        localPath.close();
        this.jdField_a_of_type_AndroidGraphicsPath = localPath;
      }
    }
    while (this.jdField_b_of_type_Boolean)
    {
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      if (this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty())
      {
        f1 = a(10.0F, localResources);
        this.jdField_b_of_type_AndroidGraphicsRectF.set(f1, 0.0F, i, j);
      }
      if (this.jdField_b_of_type_AndroidGraphicsPath == null)
      {
        f1 = a(5.0F, localResources);
        localPath = new Path();
        localPath.moveTo(a(14.0F, localResources), a(8.0F, localResources));
        localPath.quadTo(a(4.0F, localResources), a(10.0F, localResources), 0.0F, f1);
        f1 = a(10.0F, localResources);
        f2 = a(16.0F, localResources);
        localPath.quadTo(a(1.0F, localResources), a(14.0F, localResources), f1, f2);
        localPath.close();
        this.jdField_b_of_type_AndroidGraphicsPath = localPath;
      }
    }
    paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public Shader a()
  {
    return null;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      this.jdField_c_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      return;
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentResResources;
    float f1 = a(10.0F, localResources);
    float f2;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
      this.jdField_c_of_type_AndroidGraphicsPath.reset();
      paramFloat2 = a(5.0F, localResources);
      if (!this.jdField_b_of_type_Boolean) {
        break label259;
      }
      this.jdField_c_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      f1 = a(14.0F, localResources);
      f2 = a(8.0F, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.moveTo(paramFloat1 - f1, f2);
      f1 = a(4.0F, localResources);
      f2 = a(10.0F, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.quadTo(paramFloat1 - f1, f2, paramFloat1, paramFloat2);
      paramFloat2 = a(10.0F, localResources);
      f1 = a(16.0F, localResources);
      f2 = a(1.0F, localResources);
      float f3 = a(14.0F, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.quadTo(paramFloat1 - f2, f3, paramFloat1 - paramFloat2, f1);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsPath.close();
      return;
      this.jdField_c_of_type_AndroidGraphicsRectF.set(f1, 0.0F, paramFloat1, paramFloat2);
      break;
      label259:
      this.jdField_c_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CCW);
      paramFloat1 = a(14.0F, localResources);
      f1 = a(8.0F, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.moveTo(paramFloat1, f1);
      paramFloat1 = a(4.0F, localResources);
      f1 = a(10.0F, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.quadTo(paramFloat1, f1, 0.0F, paramFloat2);
      paramFloat1 = a(10.0F, localResources);
      paramFloat2 = a(16.0F, localResources);
      f1 = a(1.0F, localResources);
      f2 = a(14.0F, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f1, f2, paramFloat1, paramFloat2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      super.draw(paramCanvas);
      return;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      a(paramCanvas);
      return;
    }
    if (this.jdField_c_of_type_Int == 2)
    {
      b(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.jdField_c_of_type_Int == 1)) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setColorMask(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_b_of_type_Float = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_a_of_type_ArrayOfFloat != null) {
      Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_Float);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\BubbleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */