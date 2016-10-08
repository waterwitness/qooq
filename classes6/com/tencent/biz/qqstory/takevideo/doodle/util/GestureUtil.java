package com.tencent.biz.qqstory.takevideo.doodle.util;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GestureUtil
{
  public GestureUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static double a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    return (paramPointF1.x - paramPointF3.x) * (paramPointF2.y - paramPointF3.y) - (paramPointF2.x - paramPointF3.x) * (paramPointF1.y - paramPointF3.y);
  }
  
  public static float a(MotionEvent paramMotionEvent)
  {
    float f1 = 1.0F;
    if (paramMotionEvent.getPointerCount() > 1)
    {
      f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      f2 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      f1 = f2;
      if (Float.isNaN(f2)) {}
    }
    return f1;
  }
  
  public static boolean a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    if (Math.max(paramPointF1.x, paramPointF2.x) < Math.min(paramPointF3.x, paramPointF4.x)) {}
    while ((Math.max(paramPointF1.y, paramPointF2.y) < Math.min(paramPointF3.y, paramPointF4.y)) || (Math.max(paramPointF3.x, paramPointF4.x) < Math.min(paramPointF1.x, paramPointF2.x)) || (Math.max(paramPointF3.y, paramPointF4.y) < Math.min(paramPointF1.y, paramPointF2.y)) || (a(paramPointF3, paramPointF2, paramPointF1) * a(paramPointF2, paramPointF4, paramPointF1) < 0.0D) || (a(paramPointF1, paramPointF4, paramPointF3) * a(paramPointF4, paramPointF2, paramPointF3) < 0.0D)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(PointF paramPointF1, PointF paramPointF2, RectF paramRectF)
  {
    PointF localPointF1 = new PointF(paramRectF.left, paramRectF.top);
    PointF localPointF2 = new PointF(paramRectF.right, paramRectF.top);
    PointF localPointF3 = new PointF(paramRectF.right, paramRectF.bottom);
    paramRectF = new PointF(paramRectF.left, paramRectF.bottom);
    if (a(paramPointF1, paramPointF2, localPointF1, localPointF2)) {}
    while ((a(paramPointF1, paramPointF2, localPointF2, localPointF3)) || (a(paramPointF1, paramPointF2, localPointF3, paramRectF)) || (a(paramPointF1, paramPointF2, paramRectF, localPointF1))) {
      return true;
    }
    return false;
  }
  
  public static float[] a(MotionEvent paramMotionEvent)
  {
    float[] arrayOfFloat = new float[2];
    if (paramMotionEvent.getPointerCount() > 1)
    {
      arrayOfFloat[0] = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
      arrayOfFloat[1] = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
    }
    return arrayOfFloat;
  }
  
  public static float b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      float f1 = paramMotionEvent.getX(1) - paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(1) - paramMotionEvent.getY(0);
      float f3 = (float)Math.toDegrees(Math.asin(f2 / a(paramMotionEvent)));
      if (!Float.isNaN(f3))
      {
        if ((f2 >= 0.0F) && (f1 >= 0.0F)) {}
        do
        {
          return f3;
          if ((f2 >= 0.0F) && (f1 <= 0.0F)) {
            return 180.0F - f3;
          }
        } while ((f2 <= 0.0F) && (f1 >= 0.0F));
        if ((f2 <= 0.0F) && (f1 <= 0.0F)) {
          return -180.0F - f3;
        }
      }
    }
    else
    {
      return 0.0F;
    }
    return 0.0F;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\util\GestureUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */