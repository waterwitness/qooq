package com.tencent.mobileqq.apollo.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CanvasDrawer
  extends AbsDrawer
{
  private static final String jdField_a_of_type_JavaLangString = "CanvasDisplay";
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Rect b;
  
  public CanvasDrawer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.b = new Rect();
  }
  
  public boolean a(Canvas paramCanvas, float paramFloat)
  {
    boolean bool = false;
    if (paramCanvas == null) {
      return bool;
    }
    label25:
    Barrage localBarrage;
    Bitmap localBitmap;
    do
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label360;
          }
          localBarrage = (Barrage)localIterator.next();
          localBarrage.b();
          if (localBarrage.a()) {
            break;
          }
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("CanvasDisplay", 2, "remove invalidate barrage:" + localBarrage);
          }
        }
        localBitmap = localBarrage.a();
      }
      finally {}
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    paramCanvas.save();
    if (paramFloat == 1.0F)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() != localBarrage.d) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(localBarrage.d);
      }
      label165:
      if (localBarrage.h <= 0.0F) {
        break label388;
      }
    }
    label360:
    label388:
    for (float f1 = localBarrage.h;; f1 = 1.0F)
    {
      float f2 = localBarrage.jdField_e_of_type_Float;
      float f3 = localBarrage.jdField_f_of_type_Float;
      float f4 = localBarrage.jdField_e_of_type_Float;
      float f5 = localBarrage.jdField_e_of_type_Int;
      float f6 = localBarrage.jdField_f_of_type_Float;
      paramCanvas.clipRect(f2, f3, f4 + f5 * f1, f1 * localBarrage.jdField_f_of_type_Int + f6);
      paramCanvas.translate(localBarrage.jdField_e_of_type_Float, localBarrage.jdField_f_of_type_Float);
      if (localBarrage.h != 0.0F) {
        paramCanvas.scale(localBarrage.h, localBarrage.h);
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      this.b.set(0, 0, localBarrage.jdField_e_of_type_Int, localBarrage.jdField_f_of_type_Int);
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
      break label25;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F * paramFloat));
      break label165;
      bool = this.jdField_a_of_type_JavaUtilList.isEmpty();
      if (!bool) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\barrage\CanvasDrawer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */