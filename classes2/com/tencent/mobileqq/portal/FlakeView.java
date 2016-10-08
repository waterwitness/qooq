package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class FlakeView
  extends View
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  
  public FlakeView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[] { null, null, null, null, null, null, null, null };
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2130840757, 2130840758, 2130840759, 2130840760, 2130840761, 2130840762, 2130840763, 2130840764 };
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 1200L;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 1000L;
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if ((i >= paramInt) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {}
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130840752);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Flake.a(getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap, 0, getResources()));
          this.jdField_b_of_type_Int += 1;
          this.jdField_c_of_type_Int += 1;
        }
        i += 1;
        continue;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Long = l;
      this.jdField_b_of_type_Long = l;
      invalidate();
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - (1000.0F * this.jdField_a_of_type_Float));
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int j;
      if (i < paramInt)
      {
        j = (int)(8.0D * Math.random());
        if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] != null) {}
      }
      try
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_ArrayOfInt[j]);
        if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Flake.a(getWidth(), this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], 1, getResources()));
          this.jdField_a_of_type_Int += 1;
          this.jdField_c_of_type_Int += 1;
        }
        i += 1;
        continue;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;) {}
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long > this.jdField_c_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int < 10)) {
        a(4);
      }
      if (this.jdField_a_of_type_Int < AIOUtils.a(10.0F, getResources())) {
        b(AIOUtils.a(3.0F, getResources()));
      }
    }
    int m = getHeight();
    int n = getWidth();
    this.jdField_a_of_type_Float = ((float)(l - this.jdField_a_of_type_Long) / 1000.0F);
    this.jdField_a_of_type_Long = l;
    int i = 0;
    int j = k;
    Flake localFlake;
    if (i < this.jdField_c_of_type_Int)
    {
      localFlake = (Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localFlake.jdField_b_of_type_Float += localFlake.d * this.jdField_a_of_type_Float;
      if (localFlake.jdField_b_of_type_Float > localFlake.jdField_b_of_type_Int + m)
      {
        localFlake.jdField_a_of_type_Float = ((float)Math.random() * (n - localFlake.jdField_a_of_type_Int));
        if ((!this.jdField_a_of_type_Boolean) && (localFlake.jdField_c_of_type_Int == 0)) {
          break label253;
        }
        localFlake.jdField_b_of_type_Float = (0 - localFlake.jdField_b_of_type_Int);
        localFlake.jdField_a_of_type_Float = ((float)Math.random() * (getWidth() - localFlake.jdField_a_of_type_Int));
      }
      for (;;)
      {
        i += 1;
        break;
        label253:
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        this.jdField_c_of_type_Int -= 1;
        this.jdField_b_of_type_Int -= 1;
      }
    }
    while (j < this.jdField_c_of_type_Int)
    {
      localFlake = (Flake)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localFlake.jdField_a_of_type_Int / 2, -localFlake.jdField_b_of_type_Int / 2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localFlake.jdField_c_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localFlake.jdField_a_of_type_Int / 2 + localFlake.jdField_a_of_type_Float, localFlake.jdField_b_of_type_Int / 2 + localFlake.jdField_b_of_type_Float);
      paramCanvas.drawBitmap(localFlake.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
      j += 1;
    }
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public void setHonhBaoSpeed(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_c_of_type_Int)
    {
      if (((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_c_of_type_Int == 0) {
        switch (paramInt)
        {
        default: 
          ((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = (AIOUtils.a(240.0F, getResources()) + (float)Math.random() * AIOUtils.a(100.0F, getResources()));
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Long = (1200 - (paramInt - 1) * 200);
        i += 1;
        break;
        ((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = (AIOUtils.a(240.0F, getResources()) + (float)Math.random() * AIOUtils.a(100.0F, getResources()));
        continue;
        ((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = (AIOUtils.a(290.0F, getResources()) + (float)Math.random() * AIOUtils.a(100.0F, getResources()));
        continue;
        ((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = (AIOUtils.a(340.0F, getResources()) + (float)Math.random() * AIOUtils.a(100.0F, getResources()));
        continue;
        switch (paramInt)
        {
        default: 
          ((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = (AIOUtils.a(85.0F, getResources()) + (float)Math.random() * AIOUtils.a(55.0F, getResources()));
          break;
        case 1: 
          ((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = (AIOUtils.a(85.0F, getResources()) + (float)Math.random() * AIOUtils.a(55.0F, getResources()));
          break;
        case 2: 
          ((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = (AIOUtils.a(100.0F, getResources()) + (float)Math.random() * AIOUtils.a(55.0F, getResources()));
          break;
        case 3: 
          ((Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = (AIOUtils.a(115.0F, getResources()) + (float)Math.random() * AIOUtils.a(55.0F, getResources()));
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\FlakeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */