package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BitmapAnimTask
{
  private static final int jdField_a_of_type_Int = 60;
  public float a;
  public Paint a;
  public Rect a;
  public DecelerateInterpolator a;
  public ArrayList a;
  public List a;
  Random jdField_a_of_type_JavaUtilRandom;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  
  public BitmapAnimTask(int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilRandom = new Random(666L);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  int a()
  {
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(6);
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      float f = (paramInt - ((BitmapAnimTask.BitmapAnimItem)this.jdField_a_of_type_JavaUtilList.get(i)).d) / ((BitmapAnimTask.BitmapAnimItem)this.jdField_a_of_type_JavaUtilList.get(i)).c;
      ((BitmapAnimTask.BitmapAnimItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Float = this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator.getInterpolation(f);
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Float = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt1 - this.jdField_b_of_type_Int, paramInt2 - this.jdField_b_of_type_Int, this.jdField_b_of_type_Int + paramInt1, this.jdField_b_of_type_Int + paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    if (paramInt3 + paramInt4 > this.jdField_a_of_type_Float) {
      paramInt3 = (int)this.jdField_a_of_type_Float - paramInt4;
    }
    for (;;)
    {
      if (paramInt2 > this.jdField_b_of_type_Int) {
        paramInt2 = this.jdField_b_of_type_Int;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() >= 60) {
          return;
        }
        this.jdField_a_of_type_JavaUtilList.add(new BitmapAnimTask.BitmapAnimItem(paramInt1, paramInt2, paramInt3, paramInt4, paramInt4 + paramInt3 - 50, paramFloat, paramInt5));
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, int paramInt6)
  {
    if (paramInt3 + paramInt4 > this.jdField_a_of_type_Float) {
      paramInt3 = (int)this.jdField_a_of_type_Float - paramInt4;
    }
    for (;;)
    {
      if (paramInt2 > this.jdField_b_of_type_Int) {
        paramInt2 = this.jdField_b_of_type_Int;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() >= 60) {
          return;
        }
        this.jdField_a_of_type_JavaUtilList.add(new BitmapAnimTask.BitmapAnimItem(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat, paramInt6));
        return;
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    Log.d("test", "do drawFrame : " + paramFloat);
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int j;
    while (k < this.jdField_a_of_type_JavaUtilList.size())
    {
      BitmapAnimTask.BitmapAnimItem localBitmapAnimItem = (BitmapAnimTask.BitmapAnimItem)this.jdField_a_of_type_JavaUtilList.get(k);
      if ((paramFloat < localBitmapAnimItem.d) || (paramFloat > localBitmapAnimItem.d + localBitmapAnimItem.c))
      {
        i = localBitmapAnimItem.d;
        if (paramFloat > localBitmapAnimItem.c + i) {
          localArrayList.add(Integer.valueOf(k));
        }
        k += 1;
      }
      else
      {
        float f = localBitmapAnimItem.jdField_a_of_type_Float;
        int m = this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
        if (paramFloat < localBitmapAnimItem.e) {
          i = 255;
        }
        for (;;)
        {
          j = (int)(localBitmapAnimItem.jdField_b_of_type_Int * f);
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
          f = 1.5F - (f * (localBitmapAnimItem.jdField_b_of_type_Float - 0.2F) + 0.2F);
          paramCanvas.save();
          paramCanvas.translate(this.jdField_b_of_type_Float, this.c);
          paramCanvas.rotate(localBitmapAnimItem.jdField_a_of_type_Int);
          paramCanvas.scale(f, f);
          paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(localBitmapAnimItem.f), j / f, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(m);
          break;
          i = (int)((1.0F - (paramFloat - localBitmapAnimItem.e) / (localBitmapAnimItem.c - localBitmapAnimItem.e)) * 255.0F);
          j = i;
          if (i > 255) {
            j = 255;
          }
          i = j;
          if (j < 0) {
            i = 0;
          }
        }
      }
    }
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      j = ((Integer)localArrayList.get(i)).intValue();
      this.jdField_a_of_type_JavaUtilList.remove(j);
      i -= 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\BitmapAnimTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */