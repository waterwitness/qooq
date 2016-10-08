package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ViewUtils;

public class RangeProcessor
{
  private static final int jdField_c_of_type_Int = 0;
  private static final int jdField_d_of_type_Int = 1;
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private FrameParent jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent;
  private RangeProcessor.OnRangeChangeListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener;
  private final float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private final Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final float jdField_c_of_type_Float;
  private final float jdField_d_of_type_Float;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  
  public RangeProcessor(FrameParent paramFrameParent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 4;
    this.jdField_e_of_type_Int = Color.parseColor("#298be7");
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent = paramFrameParent;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.getContext();
    this.jdField_a_of_type_Float = (ViewUtils.a() * 0.0375F);
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = (this.jdField_a_of_type_Float * 0.5F);
    this.d = paramInt3;
    paramFrameParent = a(((Context)localObject).getResources(), 2130842743, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    localObject = a(((Context)localObject).getResources(), 2130842745, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    ColorDrawable localColorDrawable = new ColorDrawable(this.jdField_e_of_type_Int);
    localColorDrawable.setBounds(0, 0, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localColorDrawable.draw(localCanvas);
    if (paramFrameParent != null) {
      localCanvas.drawBitmap(paramFrameParent, (this.jdField_a_of_type_Float - paramFrameParent.getWidth()) / 2.0F, (this.jdField_b_of_type_Float - paramFrameParent.getHeight()) / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float, Bitmap.Config.RGB_565);
    localCanvas.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    localColorDrawable.draw(localCanvas);
    if (localObject != null) {
      localCanvas.drawBitmap((Bitmap)localObject, (this.jdField_a_of_type_Float - ((Bitmap)localObject).getWidth()) / 2.0F, (this.jdField_b_of_type_Float - ((Bitmap)localObject).getHeight()) / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.h = (1.0F * paramInt4 / paramInt2 * paramFloat1 + this.jdField_a_of_type_Float);
    this.g = (2000.0F / paramInt2 * paramFloat1);
    this.j = (paramInt3 - this.jdField_a_of_type_Float);
    this.k = this.jdField_a_of_type_Float;
    this.jdField_e_of_type_Float = this.jdField_a_of_type_Float;
    this.f = this.h;
  }
  
  private void a(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, paramFloat, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (Math.abs(paramFloat1 - paramFloat3) <= this.jdField_a_of_type_Float * 2.0F) && (paramFloat2 > 0.0F) && (paramFloat2 < this.jdField_b_of_type_Float);
  }
  
  private void b(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, paramFloat - this.jdField_a_of_type_Float, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = paramOptions.outHeight;
    int i2 = paramOptions.outWidth;
    int n = 1;
    int m = 1;
    if ((i1 > paramInt2) || (i2 > paramInt1))
    {
      i1 /= 2;
      i2 /= 2;
      for (;;)
      {
        n = m;
        if (i1 / m <= paramInt2) {
          break;
        }
        n = m;
        if (i2 / m <= paramInt1) {
          break;
        }
        m *= 2;
      }
    }
    return n;
  }
  
  public Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = 1;
    if (paramResources == null) {}
    while (paramInt1 <= 0) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      if ((paramInt2 <= 0) && (paramInt3 <= 0)) {}
      for (paramInt2 = m;; paramInt2 = a(localOptions, paramInt2, paramInt3))
      {
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = paramInt2;
        return BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      }
      return null;
    }
    catch (Exception paramResources)
    {
      paramResources.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramResources)
    {
      paramResources.printStackTrace();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F) {}
    for (this.k = (this.jdField_a_of_type_Float + paramFloat1);; this.k = this.jdField_a_of_type_Float)
    {
      if (paramFloat2 >= 0.0F) {
        this.j = Math.min(this.jdField_a_of_type_Float + paramFloat2, this.d - this.jdField_a_of_type_Float);
      }
      return;
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    int m = this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
    paramCanvas.drawRect(this.jdField_e_of_type_Float, 0.0F, this.f, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_e_of_type_Float, this.jdField_b_of_type_Float - this.jdField_b_of_type_Int, this.f, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(m);
    b(this.jdField_e_of_type_Float, paramCanvas);
    a(this.f, paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_Int = -1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.i = paramMotionEvent.getX();
      return;
    }
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 2)
    {
      f2 = f1 - this.i;
      if (this.jdField_a_of_type_Int != 0) {
        break label186;
      }
      f3 = Math.max(this.f - this.h, this.k);
      if (f1 < f3)
      {
        this.jdField_e_of_type_Float = f3;
        return;
      }
      if ((f2 >= 0.0F) || (f2 + this.jdField_e_of_type_Float > this.jdField_a_of_type_Float)) {
        break label148;
      }
      this.jdField_e_of_type_Float = f3;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.invalidate();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener.a(this.jdField_e_of_type_Float, this.f);
      return;
      label148:
      if (this.f - f1 < this.g)
      {
        this.jdField_e_of_type_Float = (this.f - this.g);
      }
      else
      {
        this.jdField_e_of_type_Float = f1;
        continue;
        label186:
        if (this.jdField_a_of_type_Int == 1)
        {
          f3 = Math.min(this.jdField_e_of_type_Float + this.h, this.j);
          if (f1 > f3)
          {
            this.f = f3;
            return;
          }
          if ((f2 > 0.0F) && (f2 + this.f >= this.h)) {
            this.f = f3;
          } else if (f1 - this.jdField_e_of_type_Float < this.g) {
            this.f = (this.jdField_e_of_type_Float + this.g);
          } else {
            this.f = f1;
          }
        }
      }
    }
  }
  
  public void a(RangeProcessor.OnRangeChangeListener paramOnRangeChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener = paramOnRangeChangeListener;
  }
  
  public boolean a()
  {
    return (!b(this.jdField_e_of_type_Float, this.jdField_a_of_type_Float)) || (!b(this.f, this.h));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = a(paramFloat1, paramFloat2, this.jdField_e_of_type_Float - this.c);
    boolean bool2 = a(paramFloat1, paramFloat2, this.f + this.c);
    if (bool1)
    {
      this.jdField_a_of_type_Int = 0;
      return true;
    }
    if (bool2)
    {
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    return false;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener = null;
    this.jdField_e_of_type_Float = 0.0F;
    this.f = 0.0F;
  }
  
  public float c()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public float d()
  {
    return this.f - this.jdField_e_of_type_Float;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\trimvideo\video\widget\RangeProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */