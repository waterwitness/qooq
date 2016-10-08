package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.PointF;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FaceLayer$LayerParams
{
  public float a;
  public int a;
  public PointF a;
  public String a;
  public boolean a;
  public int b;
  public PointF b;
  public PointF c;
  
  public FaceLayer$LayerParams()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF();
    this.c = new PointF();
  }
  
  public String toString()
  {
    return "LayerParams{centerP=" + this.jdField_a_of_type_AndroidGraphicsPointF + ", textStartP=" + this.jdField_b_of_type_AndroidGraphicsPointF + ", textEndP=" + this.c + ", scale=" + this.jdField_a_of_type_Float + ", text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", textColor=" + this.jdField_a_of_type_Int + ", textSize=" + this.jdField_b_of_type_Int + ", canBeZoom=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\FaceLayer$LayerParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */