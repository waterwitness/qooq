package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class RecommendLabelListPagerLoader$GetRecommendLabelListEvent
  extends BasePageLoaderEvent
{
  public String a;
  public List a;
  
  public RecommendLabelListPagerLoader$GetRecommendLabelListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "GetRecommendLabelListEvent{mKeyword='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRecommendList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\RecommendLabelListPagerLoader$GetRecommendLabelListEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */