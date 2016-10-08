package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  public float a;
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public float b;
  int jdField_b_of_type_Int;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  protected int h;
  protected int i;
  public int j;
  
  public PaParticleView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt5);
    this.i = paramInt4;
    this.g = paramInt3;
  }
  
  private void a(PaWeatherPaticle paramPaWeatherPaticle)
  {
    if (this.j == 0) {
      if ((paramPaWeatherPaticle.jdField_a_of_type_Float > this.c) || (paramPaWeatherPaticle.jdField_b_of_type_Float > this.d)) {
        paramPaWeatherPaticle.jdField_b_of_type_Float = 0.0F;
      }
    }
    for (paramPaWeatherPaticle.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.c);; paramPaWeatherPaticle.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.c))
    {
      do
      {
        paramPaWeatherPaticle.jdField_a_of_type_Float += paramPaWeatherPaticle.d;
        paramPaWeatherPaticle.jdField_b_of_type_Float += paramPaWeatherPaticle.c;
        return;
      } while ((paramPaWeatherPaticle.jdField_a_of_type_Float <= this.c) && (paramPaWeatherPaticle.jdField_b_of_type_Float >= this.j));
      paramPaWeatherPaticle.jdField_b_of_type_Float = this.d;
    }
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int))
    {
      int k = 0;
      while (k < this.jdField_b_of_type_Int)
      {
        float f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
        float f2 = this.e - this.f;
        float f3 = this.f;
        this.jdField_b_of_type_JavaUtilArrayList.add(new PaWeatherPaticle((Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(k % this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.c, this.jdField_a_of_type_JavaUtilRandom.nextFloat() * (this.d - this.j) + this.j, f1 * f2 + f3, this.g));
        k += 1;
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.e = paramInt1;
    this.f = paramInt2;
    this.j = paramInt3;
    a(paramInt4);
    a();
  }
  
  protected void a(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      if (localBitmap != null)
      {
        int k = localBitmap.getWidth();
        int m = localBitmap.getHeight();
        if ((k > 0) && (m > 0))
        {
          paramInt = 0;
          while (paramInt < this.jdField_a_of_type_Int)
          {
            Matrix localMatrix = new Matrix();
            localMatrix.postScale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
            this.jdField_a_of_type_JavaUtilArrayList.add(Bitmap.createBitmap(localBitmap, 0, 0, k, m, localMatrix, true));
            this.jdField_a_of_type_Float += this.jdField_b_of_type_Float;
            paramInt += 1;
          }
        }
        localBitmap.recycle();
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        System.gc();
      } while (!QLog.isColorLevel());
      QLog.e("PaParticleView", 2, "oome", localOutOfMemoryError);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() >= this.jdField_b_of_type_Int))
    {
      int k = 0;
      while (k < this.jdField_b_of_type_Int)
      {
        PaWeatherPaticle localPaWeatherPaticle = (PaWeatherPaticle)this.jdField_b_of_type_JavaUtilArrayList.get(k);
        a(localPaWeatherPaticle);
        paramCanvas.drawBitmap(localPaWeatherPaticle.jdField_a_of_type_AndroidGraphicsBitmap, localPaWeatherPaticle.jdField_a_of_type_Float, localPaWeatherPaticle.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
        k += 1;
      }
    }
    postInvalidateDelayed(this.i);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\PaParticleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */