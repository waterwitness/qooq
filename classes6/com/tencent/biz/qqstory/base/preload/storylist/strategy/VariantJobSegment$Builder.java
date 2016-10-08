package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VariantJobSegment$Builder
{
  private ClickPolicy jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy;
  private NetConditionPolicy jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy;
  
  public VariantJobSegment$Builder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Builder a(ClickPolicy paramClickPolicy)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy = paramClickPolicy;
    return this;
  }
  
  public Builder a(NetConditionPolicy paramNetConditionPolicy)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy = paramNetConditionPolicy;
    return this;
  }
  
  public VariantJobSegment a()
  {
    VariantJobSegment localVariantJobSegment = new VariantJobSegment();
    localVariantJobSegment.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy;
    localVariantJobSegment.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy;
    return localVariantJobSegment;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\VariantJobSegment$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */