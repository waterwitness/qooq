package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class SanHuaView
  extends View
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Resources jdField_a_of_type_AndroidContentResResources;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  int c;
  
  public SanHuaView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[5];
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2130840758, 2130840759, 2130840760, 2130840763, 2130840764 };
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
    paramInt1 = i;
    try
    {
      while (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt1] = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, this.jdField_a_of_type_ArrayOfInt[paramInt1]);
        paramInt1 += 1;
      }
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    invalidate();
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = (int)(5.0D * Math.random());
      this.jdField_a_of_type_JavaUtilArrayList.add(SanHua.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidContentResResources));
      i += 1;
    }
    this.jdField_a_of_type_Int += paramInt;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      super.onDraw(paramCanvas);
      float f1 = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F;
      int i = 0;
      SanHua localSanHua;
      if (i < this.jdField_a_of_type_Int)
      {
        localSanHua = (SanHua)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        float f2;
        float f3;
        float f4;
        if (localSanHua.jdField_a_of_type_Double < 0.0D)
        {
          f2 = localSanHua.c;
          f3 = localSanHua.d;
          f4 = AIOUtils.a(270.0F, this.jdField_a_of_type_AndroidContentResResources);
          localSanHua.jdField_a_of_type_ArrayOfFloat[0] = (this.jdField_a_of_type_Float - f2 * f1);
          localSanHua.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float + (f3 * f1 + f4 * 0.5F * f1 * f1));
        }
        for (;;)
        {
          i += 1;
          break;
          f2 = localSanHua.c;
          f3 = localSanHua.d;
          f4 = AIOUtils.a(270.0F, this.jdField_a_of_type_AndroidContentResResources);
          localSanHua.jdField_a_of_type_ArrayOfFloat[0] = (f2 * f1 + this.jdField_a_of_type_Float);
          localSanHua.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float - (f3 * f1 - f4 * 0.5F * f1 * f1));
        }
      }
      i = 0;
      int k;
      for (int j = 0; i < this.jdField_a_of_type_Int; j = k)
      {
        localSanHua = (SanHua)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        k = j;
        if (localSanHua.jdField_a_of_type_ArrayOfFloat[0] < this.jdField_b_of_type_Int)
        {
          k = j;
          if (localSanHua.jdField_a_of_type_ArrayOfFloat[0] > 0.0F)
          {
            k = j;
            if (localSanHua.jdField_a_of_type_ArrayOfFloat[1] < this.c)
            {
              k = j;
              if (localSanHua.jdField_a_of_type_ArrayOfFloat[1] > 0.0F)
              {
                this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localSanHua.jdField_a_of_type_Int / 2, -localSanHua.jdField_b_of_type_Int / 2);
                this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localSanHua.jdField_a_of_type_Float);
                this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localSanHua.jdField_a_of_type_Int / 2 + localSanHua.jdField_a_of_type_ArrayOfFloat[0], localSanHua.jdField_b_of_type_Int / 2 + localSanHua.jdField_a_of_type_ArrayOfFloat[1]);
                paramCanvas.drawBitmap(localSanHua.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
                k = j + 1;
              }
            }
          }
        }
        i += 1;
      }
      if (j == 0) {
        b();
      }
    } while (!this.jdField_a_of_type_Boolean);
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\SanHuaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */