package com.tencent.biz.qqstory.takevideo.doodle.layer.config;

import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DefaultDoodleStrategy;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DoodleConfig$Builder
{
  private int jdField_a_of_type_Int;
  private DoodleStrategy jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy;
  private int b;
  
  public DoodleConfig$Builder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy = new DefaultDoodleStrategy();
  }
  
  public Builder a(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
    return this;
  }
  
  public Builder a(DoodleStrategy paramDoodleStrategy)
  {
    if (paramDoodleStrategy != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy = paramDoodleStrategy;
    }
    return this;
  }
  
  public DoodleConfig a()
  {
    return new DoodleConfig(this, null);
  }
  
  public Builder b(int paramInt)
  {
    if (paramInt > 0) {
      this.b = paramInt;
    }
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\config\DoodleConfig$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */