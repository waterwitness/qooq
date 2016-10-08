package com.tencent.mobileqq.surfaceviewaction;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import java.util.ArrayList;
import java.util.List;

public class Sprite
{
  public Bitmap a;
  protected Matrix a;
  protected Paint a;
  protected List a;
  public float e;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public Sprite()
  {
    this.jdField_e_of_type_Float = 1.0F;
    this.g = 255;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public Sprite(Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_Float = 1.0F;
    this.g = 255;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public Point a()
  {
    return new Point(this.jdField_e_of_type_Int, this.f);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.f = paramInt2;
  }
  
  public void a(Canvas paramCanvas)
  {
    int m = a();
    int k = b();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Action localAction = (Action)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localAction.a())
      {
        if ((localAction.n & 0x1) != 0)
        {
          this.jdField_e_of_type_Int = localAction.i;
          this.f = localAction.j;
        }
        if ((localAction.n & 0x2) != 0) {
          this.jdField_e_of_type_Float = localAction.jdField_a_of_type_Float;
        }
        if ((localAction.n & 0x4) != 0) {
          this.g = localAction.k;
        }
        if ((localAction.n & 0x8) != 0) {
          this.h = localAction.l;
        }
      }
      j = i;
      if (localAction.b)
      {
        if (!localAction.jdField_a_of_type_Boolean) {
          break label157;
        }
        localAction.a();
      }
      for (j = i;; j = i - 1)
      {
        i = j + 1;
        break;
        label157:
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
    }
    i = (int)(m * this.jdField_e_of_type_Float);
    int j = (int)(k * this.jdField_e_of_type_Float);
    if ((this.jdField_e_of_type_Float == 0.0F) || (this.g == 0) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.g);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_e_of_type_Float, this.jdField_e_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(this.h, i / 2, j / 2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_e_of_type_Int - i / 2, this.f - j / 2);
    } while ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()));
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(Action... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Action localAction = paramVarArgs[i];
      localAction.a();
      this.jdField_a_of_type_JavaUtilList.add(localAction);
      i += 1;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\Sprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */