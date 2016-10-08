package com.tencent.biz.qqstory.takevideo.doodle.layer.config;

import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DoodleConfig
{
  public int a;
  public DoodleStrategy a;
  public int b;
  
  private DoodleConfig(DoodleConfig.Builder paramBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy = DoodleConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = DoodleConfig.Builder.a(paramBuilder);
    this.b = DoodleConfig.Builder.b(paramBuilder);
  }
  
  public String toString()
  {
    return "DoodleConfig{doodleStrategy=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy + ", maxBitmapWidth=" + this.jdField_a_of_type_Int + ", maxBitmapHeight=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\config\DoodleConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */