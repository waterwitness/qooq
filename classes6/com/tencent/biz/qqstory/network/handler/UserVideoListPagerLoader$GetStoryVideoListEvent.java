package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class UserVideoListPagerLoader$GetStoryVideoListEvent
  extends BasePageLoaderEvent
{
  public int a;
  public long a;
  public String a;
  public List a;
  public int b;
  public long b;
  
  public UserVideoListPagerLoader$GetStoryVideoListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    return "GetStoryVideoListEvent{cookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mVideoItems=" + this.jdField_a_of_type_JavaUtilList + ", uid=" + this.jdField_a_of_type_Long + ", storyVideoTotalTime=" + this.jdField_b_of_type_Long + ", pullType=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\UserVideoListPagerLoader$GetStoryVideoListEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */