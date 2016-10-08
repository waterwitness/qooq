package com.tencent.biz.qqstory.takevideo.doodle.util;

import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class GestureHelper$ZoomItem
  implements DoodleItem
{
  public float a;
  public boolean a;
  public float b;
  public float c;
  public PointF c;
  public float d;
  public float e;
  public float f;
  
  public GestureHelper$ZoomItem(float paramFloat1, float paramFloat2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = true;
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
  
  public GestureHelper$ZoomItem(ZoomItem paramZoomItem, float paramFloat)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidGraphicsPointF = new PointF(paramZoomItem.jdField_c_of_type_AndroidGraphicsPointF.x * paramFloat, paramZoomItem.jdField_c_of_type_AndroidGraphicsPointF.y * paramFloat);
    paramZoomItem.jdField_a_of_type_Float *= paramFloat;
    this.b = paramZoomItem.b;
    paramZoomItem.jdField_c_of_type_Float *= paramFloat;
    paramZoomItem.d *= paramFloat;
    this.e = paramZoomItem.e;
    this.f = paramZoomItem.f;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\util\GestureHelper$ZoomItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */